package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//tags = "@DeletePlace" - used for hooks purpose and running the tests using tag
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
                  plugin ="json:target/jsonReports/cucumber-report.json",
                  glue = {"stepDefinations"}
               
                 )
public class TestRunner {
	
	

}
