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

boolean loadingSelesai = false
long maxWaitTimeMs = 30000
long startTime = System.currentTimeMillis()

String wordPath = path_dokumen
String projectDir = RunConfiguration.getProjectDir()
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

WebUI.openBrowser(GlobalVariable.LandingPage)
//WebUI.openBrowser('https://tst.yokke.co.id:2443/checkout/bzqERqU3Xahf75t5dqNgg')
WebUI.maximizeWindow()

WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Nav/p_Mandiri Virtual Account'))
WebUI.takeScreenshot(SS1)
WebUI.delay(0.5)
WebUI.click(findTestObject('Nav/Page_Yokke/span_Pay now_1'))
WebUI.executeJavaScript("window.scrollTo(0, 0);", null)

while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
	
		boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Waiting VA/h5_Remaining payment time'), 1, FailureHandling.OPTIONAL)
	
		if (visible) {
			WebUI.delay(0.5)
			WebUI.takeScreenshot(SS2)
			loadingSelesai = true
			break
		}
		Thread.sleep(100)
		println('loading masih ada')
	}
	
if (!loadingSelesai) {
WebUI.takeScreenshot(SS2)
}

WebUI.delay(1)

//XWPFDocument document
XWPFDocument document
File file = new File(wordPath)

if (file.exists()) {
    FileInputStream fis = new FileInputStream(file)
    document = new XWPFDocument(fis)
    fis.close()
	
} else {
	// Jika file belum ada (Test Case pertama), buat baru
	document = new XWPFDocument()
}

XWPFParagraph paragraph = document.createParagraph()

XWPFRun runDataKartuLabel = paragraph.createRun()
runDataKartuLabel.addBreak()
runDataKartuLabel.setBold(true)
runDataKartuLabel.setFontSize(12)
runDataKartuLabel.setText("Create VA")
runDataKartuLabel.addBreak()

XWPFRun runDataKartuValue = paragraph.createRun()
FileInputStream is1 = new FileInputStream(SS1)
runDataKartuValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1, Units.toEMU(500), Units.toEMU(250))
is1.close()

XWPFRun runHasilLabel = paragraph.createRun()
runHasilLabel.addBreak()
runHasilLabel.setBold(true)
runHasilLabel.setFontSize(12)
runHasilLabel.setText("Payment VA")
runHasilLabel.addBreak()

XWPFRun runHasilValue = paragraph.createRun()
FileInputStream is2 = new FileInputStream(SS2)
runHasilValue.addPicture(is2, XWPFDocument.PICTURE_TYPE_PNG, SS2, Units.toEMU(500), Units.toEMU(250))
is2.close()


// 6. Simpan file Word
FileOutputStream out = new FileOutputStream(wordPath)
document.write(out)
out.close()
