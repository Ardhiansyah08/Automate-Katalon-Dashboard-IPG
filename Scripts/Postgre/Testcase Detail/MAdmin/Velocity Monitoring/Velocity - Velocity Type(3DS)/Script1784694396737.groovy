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
String evidenceDirPath = projectDir + File.separator + "Evidence" + File.separator + "Monitor"

File folderMonitor = new File(evidenceDirPath)
if (!folderMonitor.exists()) {
	folderMonitor.mkdirs() 
}

String wordPath = evidenceDirPath + File.separator + testCaseName + ".docx"
println("Cek letak evidence : " + wordPath)

document = new XWPFDocument()
XWPFParagraph paragraph = document.createParagraph()

XWPFRun runTitleValue = paragraph.createRun()
runTitleValue.setBold(true)
runTitleValue.setFontSize(12)
runTitleValue.setText("Menu Velocity Monitoring - Velocity Type(3DS)")
runTitleValue.addBreak()
runTitleValue.setText("--------------------------------------------------")
runTitleValue.addBreak()

String SS1 = projectDir + "/1.png"
String SS2 = projectDir + "/2.png"

//WebUI.openBrowser('')
//WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
//WebUI.maximizeWindow()

//while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
//
//	boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 1, FailureHandling.OPTIONAL)
//	if (visible) {
//		//Login PGAdmin
//		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Username  Email_username'), 'ardhiansyah356@gmail.com')
//		WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Password_password'), 'Mti123!@#')
//		WebUI.click(findTestObject('Object Repository/Page_PG Admin/span_Sign in'))
//		break
//			
//	}
//	Thread.sleep(50)
//	println('belum muncul')
//}

while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
	
	boolean visible2 =  WebUI.waitForElementVisible(findTestObject('Object Repository/While/p_DASHBOARD'), 1, FailureHandling.OPTIONAL)
	if (visible2) {
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Monitoring'))
		
//		TC 51 3ds
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Dropdown Velocity Type'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/Select Velocity Type/3ds - 3DS'))
		WebUI.click(findTestObject('Object Repository/Velocity Monitoring/button_Search'))
		WebUI.takeScreenshot(SS1)
		break
	}
	Thread.sleep(50)
	println('masih ada otp')
}

XWPFRun runMerchTipValue = paragraph.createRun()

FileInputStream is1 = new FileInputStream(SS1)
runMerchTipValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1, Units.toEMU(500), Units.toEMU(230))
is1.close()


FileOutputStream out = new FileOutputStream(wordPath)
document.write(out)
out.close()
println("Evidence sudah dibuat : " + wordPath)


