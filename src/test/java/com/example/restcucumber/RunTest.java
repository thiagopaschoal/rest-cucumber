package com.example.restcucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/",
		glue = "com.example.restcucumber",
		tags = {"@AvengerController"},
		plugin = {"pretty", "html:evidences/report-html"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
)
public class RunTest {

}
