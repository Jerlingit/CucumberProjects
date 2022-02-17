package org.tes.projects;

import org.facebook.report.FbReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\facebooklogin.feature",glue="org.snippets",monochrome=true,
                  plugin= {"pretty","json:src\\test\\resources\\Features\\Report\\report2.json"})

public class FacebookRunnerClass {
 
	@AfterClass
	public static void test() {
		FbReport.report("C:\\Users\\ADMIN-SHIVA\\eclipse-workspace\\CucumberProjects\\src\\test\\resources\\Features\\Report\\report2.json");
	}
	
}

