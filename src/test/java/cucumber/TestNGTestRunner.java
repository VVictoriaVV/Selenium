package cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue = "StepDefinition", monochrome = true,plugin = {"tml:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
