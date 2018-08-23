package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "./Feature/SuitSupplyCustomMade.feature",
                 glue = {"stepDefinition" },
                 plugin = {                		 
                		 "html:TestOutput/cucumber-html-report", 
             		    "json:json_output/cucumber.json", 
             		    "junit:junit_xml/cucumber.xml" 
                		    },
                 dryRun= false, // to check the mapping is proper between feature and step definition
                 strict= true, // to check if any step is not defined in step definition file
                 monochrome=true //display the console output in proper readable format
                 )

public class MyRunner
{	
	
}
