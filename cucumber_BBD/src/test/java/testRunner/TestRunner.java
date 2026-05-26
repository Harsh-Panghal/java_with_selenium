package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.Listeners;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Listeners(utilities.MyListener.class) 
@CucumberOptions(
    features = "src/test/resources/Features/NinjaMaster.feature", 
    glue = "stepDefinitions", 
    tags = "@Smoke",
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/NinjaHTMLReport.html"
    }
)
public class TestRunner {
   
}