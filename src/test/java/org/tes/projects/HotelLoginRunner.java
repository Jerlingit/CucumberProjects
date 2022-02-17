package org.tes.projects;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\login.feature",glue="org.hotel.login",monochrome=true,
plugin= {"pretty","json:src\\test\\resources\\Features\\Report\\results.json"})
public class HotelLoginRunner {

	@AfterClass
	public static void runner() {
		Reporting.generateJvmReport("C:\\Users\\ADMIN-SHIVA\\eclipse-workspace\\CucumberProjects\\src\\test\\resources\\Features\\Report\\results.json");
	}
}
