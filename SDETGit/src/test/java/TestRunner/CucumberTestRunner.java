package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Schedule", features = {"src/test/resources/Features"},
glue = {"StepDefinations"},
plugin = {"pretty", "html:target/htmlreport.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}

