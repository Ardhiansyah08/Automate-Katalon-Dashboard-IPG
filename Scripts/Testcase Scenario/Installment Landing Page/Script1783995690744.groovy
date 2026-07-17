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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil

String projectDir = RunConfiguration.getProjectDir()
String evidenceDirPath = projectDir + File.separator + "Evidence"
File folder = new File(evidenceDirPath)
if (!folder.exists()) {
	folder.mkdirs()
}
String wordPath = evidenceDirPath + File.separator + Member_Bank + " " + Test_Case + " " + Brand + ".docx"
println("Mengeksekusi Test Case: " + Member_Bank)

// 2. Panggil API
WebUI.callTestCase(findTestCase('Testcase Detail/One Flow/Inquiry_Checkout Page (API)'), [('path_dokumen') : wordPath], FailureHandling.STOP_ON_FAILURE)

Map dataExcel = [
	('path_dokumen') : wordPath,
	('wordPath')     : wordPath,
	('Name')         : Name,
	('CardData')     : CardData,
	('Expired')      : Expired,	
	('CVV')          : CVV,
	('Tenor')    	 : Tenor
]

if (Member_Bank.startsWith("MTIISO")) {

	println("Start MTIISO")
	WebUI.callTestCase(findTestCase('Test Cases/Testcase Detail/Installment/Installment MTIISO'), dataExcel)
	
} else if (Member_Bank.startsWith("OCBCISO")) {

	println("Start OCBCISO")
	WebUI.callTestCase(findTestCase('Test Cases/Testcase Detail/Installment/Installment OCBCISO'), dataExcel)
	
} else if (Member_Bank.startsWith("BTN")) {

	println("Start BTN")
	WebUI.callTestCase(findTestCase('Test Cases/Testcase Detail/Installment/Installment BTN'), dataExcel)
	
} else if (Member_Bank.startsWith("CIMB")) {

	println("Start CIMB")
	WebUI.callTestCase(findTestCase('Test Cases/Testcase Detail/Installment/Installment CIMB'), dataExcel)
	
} else {
	KeywordUtil.markFailedAndStop("Script belum tersedia untuk bank: " + Member_Bank)
}