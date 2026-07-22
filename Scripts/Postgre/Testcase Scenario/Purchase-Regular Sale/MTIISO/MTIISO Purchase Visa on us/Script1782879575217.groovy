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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

String currentTCName = GlobalVariable.TestCaseName

String projectDir = RunConfiguration.getProjectDir()
String evidenceDirPath = projectDir + File.separator + "Evidence"

File folder = new File(evidenceDirPath)
if (!folder.exists()) {
	folder.mkdirs()
}

String wordPath = evidenceDirPath + File.separator + currentTCName + ".docx"
def data = TestDataFactory.findTestData('Data Files/Test Case Automate') 

int targetRow = -1
int totalRows = data.getRowNumbers()

for (int i = 1; i <= totalRows; i++) {
    if (data.getValue('Test Case', i) == currentTCName) {
        targetRow = i
        break
    }
}

if (targetRow == -1) {
    KeywordUtil.markFailedAndStop("Data untuk '" + currentTCName + "' tidak ditemukan di Excel!")
}

// Simpan data yang ditemukan ke dalam variabel string
String Name = data.getValue('Name', targetRow)
String CardData = data.getValue('Data Kartu', targetRow)
String Expired = data.getValue('Expired Card', targetRow)
String CVV = data.getValue('CVV', targetRow)

// 2. Panggil API dan lempar path Word-nya agar API bisa menulis evidence di file yang sama
WebUI.callTestCase(findTestCase('Postgre/Testcase Detail/One Flow/Inquiry_Checkout Page (API)'), [('path_dokumen') : wordPath], FailureHandling.STOP_ON_FAILURE)

// 3. Panggil Landing Page dan lempar data kartu beserta path Word-nya
WebUI.callTestCase(findTestCase('Postgre/Testcase Detail/Payment/Sale/Landing Page IPG MTIISO'), [
	('path_dokumen') : wordPath,
	('Name') 	 : Name,
	('CardData') : CardData,
	('Expired')  : Expired,
	('CVV')      : CVV,
	('wordPath') : wordPath
])