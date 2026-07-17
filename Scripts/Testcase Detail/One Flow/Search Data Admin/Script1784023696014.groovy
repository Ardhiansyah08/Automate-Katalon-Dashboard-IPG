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
import payment.PGAdmin

println(GlobalVariable.WebPgAdmin)
WebUI.switchToWindowIndex(0)
DriverFactory.changeWebDriver((WebDriver) GlobalVariable.WebPgAdmin)

String projectDir = RunConfiguration.getProjectDir()
String wordPath = path_dokumen
String SS1 = projectDir + "/1.png"
String SS2 = projectDir + "/2.png"
String SS3 = projectDir + "/3.png"
String SS4 = projectDir + "/4.png"
String SS5 = projectDir + "/5.png"
String SS6 = projectDir + "/6.png"

//long maxWaitTimeMs = 100000
//long startTime = System.currentTimeMillis()
//WebUI.openBrowser('')
//WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
//WebUI.maximizeWindow()
//
//while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
//
//	boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 1, FailureHandling.OPTIONAL)
//	if (visible) {
//		//Login PGAdmin
//		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Username  Email_username'), 'ardhiansyah356@gmail.com')
//		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Password_password'), 'Mti123!@#')
//		WebUI.click(findTestObject('Object Repository/Page_PG Admin/span_Sign in'))
//		
//		while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
//		
//				boolean visible2 =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/h4_Welcome Administrators'), 1, FailureHandling.OPTIONAL)
//				if (visible2) {
//					break
//				}
//				Thread.sleep(50)
//				println('masih ada otp')
//			}
//			
//		WebDriver WebPgAdmin = DriverFactory.getWebDriver()
//		GlobalVariable.WebPgAdmin = DriverFactory.getWebDriver()
//		println(WebPgAdmin)
//		break
//	}
//	Thread.sleep(50)
//	println('belum muncul')
//}

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/svg_Search_MuiSvgIcon-root jss70'))
WebUI.delay(1)
//WebUI.setText(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/input_To date_MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart MuiOutlinedInput-inputAdornedStart'), GlobalVariable.referenceId)
WebUI.setText(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/input_To date_MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart MuiOutlinedInput-inputAdornedStart'), referenceId)
WebUI.click(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/button_Search'))
WebUI.click(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/span_chevron_right'))
WebUI.takeScreenshot(SS1)
WebUI.scrollToElement(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/span_voidStatus'), 5)
WebUI.takeScreenshot(SS2)
WebUI.scrollToElement(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/span_currency'), 5)
WebUI.takeScreenshot(SS3)
WebUI.scrollToElement(findTestObject('Object Repository/Page_PG Admin/h6_Customer detail'), 5)
WebUI.takeScreenshot(SS4)

PGAdmin.createEvidence(wordPath, SS1, SS2, SS3, SS4)
