import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.util.Units
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.interactions.Actions
import payment.Search_Data

long maxWaitTimeMs = 100000
long startTime = System.currentTimeMillis()

String testCaseName = GlobalVariable.currentTestCaseName
String projectDir = RunConfiguration.getProjectDir()
String evidenceDirPath = projectDir + File.separator + "Evidence"
println('cek test case name : ' + testCaseName)
String wordPath = evidenceDirPath + File.separator + testCaseName + ".docx"

println("Cek letak evidence : " + wordPath)
String SS1 = projectDir + "/1.png"
String SS2 = projectDir + "/2.png"
String SS3 = projectDir + "/3.png"
String SS4 = projectDir + "/4.png"
String SS5 = projectDir + "/5.png"
String SS6 = projectDir + "/6.png"
String SS7 = projectDir + "/7.png"
String SS8 = projectDir + "/8.png"

WebUI.openBrowser('')
WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
WebUI.maximizeWindow()

while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {

	boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 1, FailureHandling.OPTIONAL)
	if (visible) {
		//Login PGAdmin
		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Username  Email_username'), 'ardhiansyah356@gmail.com')
		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Password_password'), 'Mti123!@#')
		WebUI.click(findTestObject('Object Repository/Page_PG Admin/span_Sign in'))
		break
			
	}
	Thread.sleep(50)
	println('belum muncul')
}

while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
	
	boolean visible2 =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/h4_Welcome Administrators'), 1, FailureHandling.OPTIONAL)
	if (visible2) {
		
//		Merchant
		WebUI.click(findTestObject('Object Repository/Monitoring/span_Monitoring'))
		WebUI.click(findTestObject('Object Repository/Monitoring/svg_Select Merchant_MuiSvgIcon-root'))
		WebUI.takeScreenshot(SS1)
		
//		Currency
		WebUI.click(findTestObject('Object Repository/currency/Page_PG Admin/svg_-- Select Currency --_MuiSvgIcon-root'))
		WebUI.takeScreenshot(SS2)
		
//		From Date
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/button_From date_MuiButtonBase-root MuiIconButton-root'))
		WebUI.takeScreenshot(SS3)
		WebUI.sendKeys(findTestObject('null'), Keys.chord(Keys.ENTER))
		
//		To Date
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/button_To date_MuiButtonBase-root MuiIconButton-root'))
		WebUI.takeScreenshot(SS4)
		WebUI.sendKeys(findTestObject('null'), Keys.chord(Keys.ENTER))
		
//		Payment Method
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/svg_Payment Method_MuiSvgIcon-root'))
		WebUI.takeScreenshot(SS5)
		WebUI.delay(0.5)
		Actions action = new Actions(DriverFactory.getWebDriver())
		action.sendKeys(Keys.ESCAPE).perform()
		
//		Payment Provider
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/svg_Payment Provider_MuiSvgIcon-root'))
		WebUI.takeScreenshot(SS6)
		WebUI.delay(0.5)
		WebUI.sendKeys(findTestObject('null'), Keys.chord(Keys.TAB))
		Actions action2 = new Actions(DriverFactory.getWebDriver())
		action2.sendKeys(Keys.ESCAPE).perform()
		
// TC Search Data
//		Filter Merchant
		WebUI.setText(findTestObject('Object Repository/Monitoring/input_Select Merchant_mui-22550'), 'LEKASEHAT1')
		WebUI.sendKeys(findTestObject('Object Repository/Monitoring/input_Select Merchant_mui-22550'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Monitoring/input_Select Merchant_mui-22550'), Keys.chord(Keys.ENTER))
		
//		Filter Payment Method
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/svg_Payment Method_MuiSvgIcon-root'))
		WebUI.click(findTestObject('Object Repository/Monitoring/Filter/label_Card Payment'))
		Actions action3 = new Actions(DriverFactory.getWebDriver())
		action3.sendKeys(Keys.ESCAPE).perform()
		
//		Filter Payment Provider
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/svg_Payment Provider_MuiSvgIcon-root'))
		WebUI.click(findTestObject('Object Repository/Monitoring/Filter/label_mtiiso'))
		Actions action4 = new Actions(DriverFactory.getWebDriver())
		action4.sendKeys(Keys.ESCAPE).perform()
		
//		Search Data Filter
		WebUI.takeScreenshot(SS7)
		WebUI.click(findTestObject('Object Repository/Monitoring/Page_PG Admin/button_Search'))
		WebUI.scrollToElement(findTestObject('Object Repository/Monitoring/Page_PG Admin/label_captured'), 5)
		WebUI.takeScreenshot(SS8)
		break
	}
	Thread.sleep(50)
	println('masih ada otp')
}

Search_Data.createEvidence(wordPath, SS1, SS2, SS3, SS4, SS5, SS6, SS7, SS8)


