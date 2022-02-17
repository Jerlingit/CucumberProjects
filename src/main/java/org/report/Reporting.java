package org.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJvmReport(String jsonFile) {
		File file=new File("C:\\Users\\ADMIN-SHIVA\\eclipse-workspace\\CucumberProjects\\src\\test\\resources\\Features\\Report");
		
		Configuration configuration=new Configuration(file, "Hotel App login verification");
		configuration.addClassifications("OS", "Windows10");
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("version", "98");
		configuration.addClassifications("Sprint", "13");
		
		List<String> data=new ArrayList<String>();
		data.add(jsonFile);
		
		ReportBuilder builder=new ReportBuilder(data, configuration);
		builder.generateReports();
		
	}
}
