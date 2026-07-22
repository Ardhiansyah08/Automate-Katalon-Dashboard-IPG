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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.util.Units
import java.io.FileInputStream
import java.io.FileOutputStream
import com.kms.katalon.core.configuration.RunConfiguration
import java.awt.Robot
import java.awt.event.KeyEvent
import com.kms.katalon.core.util.KeywordUtil
import payment.Evidence

boolean loadingSelesai = false
long maxWaitTimeMs = 30000
long startTime = System.currentTimeMillis()

String projectDir = RunConfiguration.getProjectDir()
String wordPath = path_dokumen
println("Cek letak evidence : " + wordPath)
String SS1 = projectDir + "/Input.png"
String SS2 = projectDir + "/Result_Payment.png"

def createTestObjectById(String id) {
	TestObject to = new TestObject(id)
	to.addProperty("id", ConditionType.EQUALS, id)
	return to
}

def createTestObjectByXPath(String xpathValue) {
	TestObject to = new TestObject("dynamic_xpath")
	to.addProperty("xpath", ConditionType.EQUALS, xpathValue)
	return to
}

WebUI.executeJavaScript("window.open('" + GlobalVariable.LandingPage + "', '_blank');", null)
WebUI.switchToWindowIndex(1)
//WebUI.openBrowser(GlobalVariable.LandingPage)
WebUI.maximizeWindow()

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/OCBC/OCBC REPO/p_CreditDebit OCBC'))
WebUI.setText(findTestObject('Object Repository/Nav/input_Name_MuiInputBase-input MuiFilledInput-input'), Name)
WebUI.setText(createTestObjectById('cardNumber'), CardData)
WebUI.setText(createTestObjectById('expiryDate'), Expired)
WebUI.setText(createTestObjectById('cvc'), CVV)
switch (Tenor) {
	case "3" :
	WebUI.click(findTestObject('Object Repository/Nav/div_3Bulan Cicilan'))
	break
	case "4" :
	WebUI.click(findTestObject('Object Repository/Nav/div_4Bulan Cicilan'))
	break
	case "6" :
	WebUI.click(findTestObject('Object Repository/Nav/div_6Bulan Cicilan'))
}

WebUI.takeScreenshot(SS1)
WebUI.delay(1)
WebUI.click(findTestObject('Nav/Page_Yokke/span_Pay now_1'))
WebUI.executeJavaScript("window.scrollTo(0, 0);", null)
while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {

	boolean Loading =  WebUI.waitForElementVisible(findTestObject('Object Repository/Nav/div_Mohon Ditunggu'), 1, FailureHandling.OPTIONAL)
	
		if (!Loading) {
			WebUI.takeScreenshot(SS2)
			WebUI.closeBrowser()
			loadingSelesai = true
			break
		}
		Thread.sleep(50)
		println('loading masih ada')
	}
	
	if (!loadingSelesai) {
		WebUI.takeScreenshot(SS2)
		WebUI.closeBrowser()
	}
	
Evidence.createEvidence(wordPath, SS1, SS2)