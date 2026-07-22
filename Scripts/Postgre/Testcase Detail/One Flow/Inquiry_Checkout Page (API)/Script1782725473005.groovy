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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RequestObject
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import com.kms.katalon.core.configuration.RunConfiguration
import groovy.json.JsonSlurper

String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
XWPFDocument document = new XWPFDocument()
XWPFParagraph paragraph = document.createParagraph()

XWPFRun runTitleValue = paragraph.createRun()
runTitleValue.setBold(true)
runTitleValue.setFontSize(12)
runTitleValue.setText("POSTMAN EVIDENCE - CHECKOUT FLOW")
runTitleValue.addBreak()
runTitleValue.setText("Waktu Eksekusi: " + timeStamp)
runTitleValue.addBreak()
runTitleValue.setText("--------------------------------------------------")
runTitleValue.addBreak()

RequestObject reqToken = findTestObject('Postman/Access token')
ResponseObject responseToken = WS.sendRequest(reqToken)
WS.verifyResponseStatusCode(responseToken, 200)

String myToken = WS.getElementPropertyValue(responseToken, 'access_token')
println("Token yang didapat: " + myToken)

String currentCounter = System.currentTimeMillis().toString() + new Random(). nextInt (10000)
RequestObject reqInquiry = findTestObject('Postman/Inquiry_Checkout Page', [
	('accessToken') : myToken,
	('counter') : currentCounter.toString()
])
String requestBody = reqInquiry.getHttpBody()
JsonSlurper jsonSlurper = new JsonSlurper()
def parsedJson = jsonSlurper.parseText(requestBody)
GlobalVariable.referenceId = parsedJson.order.id

ResponseObject responseInquiry = WS.sendRequest(reqInquiry)
println("--- RESPONS API INQUIRY ---")
println("Body: " + responseInquiry.getResponseText())
WS.verifyResponseStatusCode(responseInquiry, 200)

//GlobalVariable.referenceId = WS.getElementPropertyValue(responseInquiry, 'referenceId')
GlobalVariable.LandingPage = WS.getElementPropertyValue(responseInquiry, 'urls.checkout')
println("referenceId: " + GlobalVariable.referenceId)
println("Landing Page: " + GlobalVariable.LandingPage)

XWPFRun runReq = paragraph.createRun()
runReq.setBold(true)
runReq.setFontSize(13)
runReq.setText("[1] REQUEST: Inquiry Checkout Page")
runReq.addBreak()

// URL
XWPFRun runUrlLabel = paragraph.createRun()
runUrlLabel.setBold(true)
runUrlLabel.setText("URL: ")
XWPFRun runUrlValue = paragraph.createRun()
runUrlValue.setBold(false)
runUrlValue.setFontSize(11) 
runUrlValue.setText(reqInquiry.getRestUrl())
runUrlValue.addBreak()

//Status Code
XWPFRun runStatusLabel = paragraph.createRun()
runStatusLabel.setBold(true)
runStatusLabel.setFontSize(12)
runStatusLabel.setText("Status Code: ")
XWPFRun runStatusValue = paragraph.createRun()
runStatusValue.setBold(false)
runStatusValue.setFontSize(11)
runStatusValue.setText(responseInquiry.getStatusCode().toString()) 
runStatusValue.addBreak()

// Request Body
XWPFRun runReqBodyLabel = paragraph.createRun()
runReqBodyLabel.setBold(true)
runReqBodyLabel.setFontSize(12)
runReqBodyLabel.setText("Request Body : ")
XWPFRun runReqBodyValue = paragraph.createRun()
runReqBodyValue.setBold(false)
runReqBodyValue.setFontSize(11)
runReqBodyValue.setText(reqInquiry.getHttpBody())
runReqBodyValue.addBreak()

//Response Body
XWPFRun runResBodyLabel = paragraph.createRun()
runResBodyLabel.setBold(true)
runReqBodyLabel.setFontSize(12)
runResBodyLabel.setText("Response Body:")
runResBodyLabel.addBreak()

// Response Body Value (Buat run baru khusus untuk nilainya)
XWPFRun runResBodyValue = paragraph.createRun()
runResBodyValue.setBold(false) // Matikan bold
runResBodyValue.setFontSize(11) // Sesuaikan ukuran
String[] resInquiryLines = responseInquiry.getResponseBodyContent().split("\n")
for (String line : resInquiryLines) { 
    runResBodyValue.setText(line) 
    runResBodyValue.addBreak() 
}
runResBodyValue.setText("--------------------------------------------------")
runResBodyValue.addBreak()

// EXTRACTED GLOBAL VARIABLES =
XWPFRun runGlobalVarsLabel = paragraph.createRun()
runGlobalVarsLabel.setBold(true)
runGlobalVarsLabel.setFontSize(13)
runGlobalVarsLabel.setText("[2] EXTRACTED GLOBAL VARIABLES:")
runGlobalVarsLabel.addBreak()

// Global Variables Value
XWPFRun runRefLabel = paragraph.createRun()
runRefLabel.setBold(true)
runRefLabel.setText("Reference ID: ") 
XWPFRun runRefValue = paragraph.createRun()
runRefValue.setBold(false)
runRefValue.setText(GlobalVariable.referenceId)
runRefValue.addBreak() // Memberikan 'enter' setelah isi variabel dicetak

XWPFRun runLandingLabel = paragraph.createRun()
runLandingLabel.setBold(true)
runLandingLabel.setText("Landing Page: ")
XWPFRun runLandingValue = paragraph.createRun()
runLandingValue.setBold(false)
runLandingValue.setText(GlobalVariable.LandingPage)
runLandingValue.addBreak() // Memberikan 'enter' setelah isi variabel dicetak

String projectDir = RunConfiguration.getProjectDir()
String wordPath = path_dokumen
//String wordPath = "E:\\Yokke\\Automation\\Evidence\\Evidence_Sale IPG_MTIISO.docx"
println("Evidence sudah dibuat : " + wordPath)

FileOutputStream out = new FileOutputStream(wordPath)
document.write(out)
out.close()
//document.close()
println("Evidence sudah dibuat : " + wordPath)