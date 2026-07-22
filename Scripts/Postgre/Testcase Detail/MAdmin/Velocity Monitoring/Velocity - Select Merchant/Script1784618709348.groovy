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
import payment.Velocity_Monitoring

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
String SS9 = projectDir + "/9.png"
String SS10 = projectDir + "/10.png"
String SS11 = projectDir + "/11.png"
String SS12 = projectDir + "/12.png"

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
		

		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Monitoring'))
		
//		TC 42 View Merchant
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown_Merchant'))
		WebUI.takeScreenshot(SS1)
		WebUI.setText(findTestObject('Object Repository/Velocity Monitoring/input_Merchant Velocity'), 'LEKASEHAT1')
		WebUI.sendKeys(findTestObject('Object Repository/Velocity Monitoring/input_Merchant Velocity'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Velocity Monitoring/input_Merchant Velocity'), Keys.chord(Keys.ENTER))
		WebUI.takeScreenshot(SS2)
		
//		TC 43 Velocity Type
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.takeScreenshot(SS3)
		
//		TC 44 Merchant Tip
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/merchantip - Merchant IP validator'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS4)
		
//		TC 45 Apiburst
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/apiburst - Max API call  minutes'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS5)
		
//		TC 46 Countrylist
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/countrylist - Country black list'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS6)
		
//		TC 47 Binlist
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/binlist - BIN black list'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS7)

//		TC 48 Panburst
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/panburst - PAN Burst'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS8)
		
//		TC 49 Maxtrxmerchant
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/maxtrxmerchant - Maximum transactions velocity'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS9)
		
//		TC 50 Maxtrxpan
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/maxtrxpan - Maximum PAN velocity'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS10)
		
//		TC 51 3ds
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/3ds - 3DS'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS11)
		
//		TC 52 Domestic
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/domestic - Domestic Only'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS12)
		break
	}
	Thread.sleep(50)
	println('masih ada otp')
}

Velocity_Monitoring.createEvidence(wordPath, SS1, SS2, SS3, SS4, SS5, SS6, SS7, SS8, SS9, SS10, SS11, SS12)


