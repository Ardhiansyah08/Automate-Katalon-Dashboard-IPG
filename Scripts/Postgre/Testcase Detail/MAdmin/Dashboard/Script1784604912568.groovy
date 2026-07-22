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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import org.apache.poi.xwpf.usermodel.XWPFDocument as XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph as XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun as XWPFRun
import org.apache.poi.util.Units as Units
import org.openqa.selenium.interactions.Actions as Actions
import payment.Search_Data as Search_Data

long maxWaitTimeMs = 100000
long startTime = System.currentTimeMillis()

String testCaseName = GlobalVariable.currentTestCaseName
String projectDir = RunConfiguration.getProjectDir()
String evidenceDirPath = (projectDir + File.separator) + 'Evidence'
println('cek test case name : ' + testCaseName)
String wordPath = ((evidenceDirPath + File.separator) + testCaseName) + '.docx'
println('Cek letak evidence : ' + wordPath)

String SS1 = projectDir + '/1.png'

document = new XWPFDocument()
XWPFParagraph paragraph = document.createParagraph()

XWPFRun runTitleValue = paragraph.createRun()
runTitleValue.setBold(true)
runTitleValue.setFontSize(12)
runTitleValue.setText('Menu Dashboard')
runTitleValue.addBreak()
runTitleValue.setText('--------------------------------------------------')
runTitleValue.addBreak()

WebUI.openBrowser('')
WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
WebUI.maximizeWindow()

while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
    boolean visible = WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 
        1, FailureHandling.OPTIONAL)

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
    boolean visible2 = WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/h4_Welcome Administrators'), 
        1, FailureHandling.OPTIONAL)

    if (visible2) {
        WebUI.click(findTestObject('Object Repository/Dashboard/span_Dashboard'))
        WebUI.takeScreenshot(SS1)
        break
    }
    
    Thread.sleep(50)
    println('masih ada otp')
}

XWPFRun runSummaryLabel = paragraph.createRun()
runSummaryLabel.addBreak()
runSummaryLabel.setBold(true)
runSummaryLabel.setFontSize(12)
runSummaryLabel.setText('TC 41. Summary Dashboard')
runSummaryLabel.addBreak()

XWPFRun runSummaryValue = paragraph.createRun()

FileInputStream is1 = new FileInputStream(SS1)
runSummaryValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1, Units.toEMU(500), Units.toEMU(230))
is1.close()

FileOutputStream out = new FileOutputStream(wordPath)
document.write(out)
out.close()
println('Evidence sudah dibuat : ' + wordPath)