package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightResultsPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class BlazeDemoE2ETest extends BaseTest {

    @DataProvider(name = "blazeDemoData")
    public Object[][] getPassengerData() {
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> dataList = excelReader.getData("./src/test/resources/testdata/BlazeDemoData.xlsx", "PassengerData");
        
        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }

    @Test(dataProvider = "blazeDemoData", groups = {"Regression", "E2E"}, retryAnalyzer = listeners.RetryAnalyzer.class)
    public void validateCompleteFlightBookingWorkflow(Map<String, String> dataMap) {
        
        HomePage homePage = new HomePage(driver);
        FlightResultsPage resultsPage = new FlightResultsPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        String depCity = dataMap.get("Departure");
        String destCity = dataMap.get("Destination");
        homePage.searchFlight(depCity, destCity);

        // fatch the flightDetails to verify cross page state
        Map<String, String> extractedFlightDetails = resultsPage.selectCheapestFlight();

        // Excel ka data + previous page data -> Passing the data mean CONTEXT TRANSFER
        purchasePage.fillDetailsAndPurchase(dataMap, extractedFlightDetails);

        confirmationPage.verifySuccess();
    }
}