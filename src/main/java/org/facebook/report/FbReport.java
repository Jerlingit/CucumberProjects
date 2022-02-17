package org.facebook.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class FbReport {
	
public static void report(String jsonFile) {
	File file=new File("C:\\Users\\ADMIN-SHIVA\\eclipse-workspace\\CucumberProjects\\src\\test\\resources\\Features\\Report");
	
	Configuration configuration=new Configuration(file, "Facebook login page");
	
	configuration.addClassifications("OS", "windows");
	configuration.addClassifications("Browser", "Chrome");
	configuration.addClassifications("Version", "98");
	configuration.addClassifications("Build verision", "23");
	
	List<String> data=new ArrayList<String>();
	data.add(jsonFile);
	
	ReportBuilder builder=new ReportBuilder(data, configuration);
	
	builder.generateReports();
	
	
}
}
