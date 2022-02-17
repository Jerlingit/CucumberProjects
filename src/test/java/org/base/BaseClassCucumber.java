package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCucumber {
	public static WebDriver driver;
	public static JavascriptExecutor executor;
	public static Robot robot; 
	public static Select select;
	public static Map<String, Integer> m;
	public static Map<Integer, String> m1;
	
	public static void browserLaunch(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static WebElement findElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public static WebElement findElementXpath(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		return element;
	}
	
	public static WebElement findElementClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
		
	}
	
	public static WebElement findElementLinkText(String text) {
		WebElement element = driver.findElement(By.linkText(text));
		return element;
		
	}
	
	public static WebElement findElementCssSelector(String selector) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		return element;
		
	}
	
	public static WebElement findElementName(String name) {
		
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	
	public static WebElement findElementPartialText(String parText){
		WebElement element = driver.findElement(By.partialLinkText(parText));
		return element;
		
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void sendKeys(WebElement element, String id) {
		
		element.sendKeys(id);
		
	}
	
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public static void mouseOver(WebElement element) {
		
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public static void dragDrop(WebElement element, WebElement element1) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element, element1).perform();
	}
	
	public static void doubleClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public static void rightClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public static void pressKey(Integer key) throws AWTException {
		robot=new Robot();
		robot.keyPress(key);
	}
	public static void releaseKey(Integer key) throws AWTException {
		robot=new Robot();
		robot.keyRelease(key);
	}
		
	
	public static void javaScriptSetValue(String data, WebElement element) {
		 executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value',data)",element);
	}
	
	public static Object javaScriptGetValue(WebElement element) {
		Object element1 = executor.executeScript("return arguments[0].getAttribute('value')",element);
		return element1;
	}
	
	public static void javaScriptClick(WebElement element) {
		
		executor.executeScript("arguments[0].click()", element);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public static void takeScreenshot(String path) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		FileUtils.copyFile(source, des);
	}
	
	public static void selectDropDownIndex(WebElement element, Integer index) {
		select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectDropDownVisibleText(WebElement element, String text) {
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void openSiteWithInvalidCertificate(String url) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static String getExcelCellValue(String path,String sheetName,int rowNo,int cellNo) throws IOException {
		
		String data=null;
		File file=new File(path);
		
		FileInputStream stream=new FileInputStream(file);
		
		Workbook book=new XSSFWorkbook(stream);
		
		Sheet sheet=book.getSheet(sheetName);
		
		Row row2 = sheet.getRow(rowNo);
		
		Cell cell2 = row2.getCell(cellNo);
		
		
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if(cellType==1) {
					
				data = cell.getStringCellValue();
				}
				
				if(cellType==0) {
					
					if(DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat dateformat=new SimpleDateFormat("dd-MMM-yyyy");
						data = dateformat.format(date);
						
					}
					else {
						double db = cell.getNumericCellValue();
						long l=(long) db;
						data = String.valueOf(l);
					}
			}
			
		}
	
	}
			return data;
	
}
	
	public static void writeDataExcel(String path,String data) throws IOException {
		File file=new File(path);
		
		Workbook  workbook=new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet();
		
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(0);
		
		cell.setCellValue(data);
		
		FileOutputStream stream=new FileOutputStream(file);
		
		workbook.write(stream);
		
	}
	
	public static void updateExcelValue(String path,String sheetName,int rowNo,int cellNo,String input1,String input2) throws IOException {
		File file=new File(path);
		
		FileInputStream stream=new FileInputStream(file);
		
		Workbook workbook=new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNo);
		
		Cell cell = row.getCell(cellNo);
		
		String data = cell.getStringCellValue();
		
		if(data.equals(input1)) {
			
			cell.setCellValue(input2);
		}
		FileOutputStream stream2=new FileOutputStream(file);
		workbook.write(stream2);
	}
	
	
	public static void goToFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void goToFrameName(String name) {
		driver.switchTo().frame(name);
	}
	
	public static void goToFrameId(String id) {
		driver.switchTo().frame(id);
	}
	
	public static void goToFrameElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void comeOutOfFrame() {
		driver.switchTo().defaultContent();
	}
	
	public static String printWebTable(String path) {
		String text=null;
		WebElement table = findElementXpath(path);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int size = rows.size();
		for (int i = 0; i < rows.size(); i++) {
			 text = rows.get(i).getText();
			
}
		return text;

	}
	
	public static void goToNewWindow() {
		Set<String> allWindow = driver.getWindowHandles();
		List<String> listAllWindow=new ArrayList<String>();
		listAllWindow.addAll(allWindow);
		String window = listAllWindow.get(1);
		driver.switchTo().window(window);
	}
	
	public static String getAllDropDownOptions(String path) {
		String text=null;
		WebElement element = findElementXpath(path);
		Select s=new Select(element);
		List<WebElement> data = s.getOptions();
		for (WebElement a : data) {
			text = a.getText();
		}
		return text;
	}
	
	public static String getAllSelectedDropDownOptions(String path) {
		String text=null;
		WebElement element = findElementXpath(path);
		Select s=new Select(element);
		List<WebElement> data = s.getAllSelectedOptions();
		for (WebElement a : data) {
			text = a.getText();
		}
		return text;
	}
	public static void navigateURL(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	public static void nagivgateForward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void createMap(String key,Integer value) {
		m=new LinkedHashMap<String, Integer>();
		m.put(key, value);
	}
	
	public static void createMap1(Integer key,String value) {
		m1=new LinkedHashMap<Integer, String>();
		m1.put(key, value);
	}
	
	public static boolean mapContainsValueInteger(Integer value) {
		boolean containsValue = m.containsValue(value);
		return containsValue;
	}
	public static boolean mapContainsValueString(String value) {
		boolean containsValue1 = m.containsValue(value);
		return containsValue1;
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static int stringIndexOf(String ref, char ch) {
		int indexOf = ref.indexOf(ch);
		return indexOf;
	}
	
	public static char getStringCharByIndex(String ref, int index) {
		char charAt = ref.charAt(index);
		return charAt;
	}
	
	public static boolean startsWithString(String ref, String data) {
		
		boolean startsWith = ref.startsWith(data);
		return startsWith;
	}
	
	public static boolean endsWithString(String ref, String data) {
		
		boolean endsWith = ref.endsWith(data);
		return endsWith;
	}
	public static boolean stringEmpty(String ref) {
		boolean empty = ref.isEmpty();
		return empty;
	}
	
}
