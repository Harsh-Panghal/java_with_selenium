package utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Scenario Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Scenario Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Scenario Failed: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All Test Executions Completed Successfully!");
    }
}