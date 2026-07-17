package payment

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.util.Units
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

public class PGAdmin {
	public static void createEvidence(
		String wordPath, 
		String SS1_Path, 
		String SS2_Path,
		String SS3_Path,
		String SS4_Path) {
		XWPFDocument document
		File file = new File(wordPath)

		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file)
			document = new XWPFDocument(fis)
			fis.close()
		} else {
			document = new XWPFDocument()
		}
	
	XWPFParagraph paragraph = document.createParagraph()
	
	// --- GAMBAR 1 (INPUT) ---
	XWPFRun runDataKartuLabel = paragraph.createRun()
	runDataKartuLabel.addBreak()
	runDataKartuLabel.setBold(true)
	runDataKartuLabel.setFontSize(12)
	runDataKartuLabel.setText("Admin")
	runDataKartuLabel.addBreak()
	
	XWPFRun runData1Value = paragraph.createRun()
	FileInputStream is1 = new FileInputStream(SS1_Path)
	runData1Value.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1_Path, Units.toEMU(500), Units.toEMU(230))
	is1.close()
	
	XWPFRun runData2Value = paragraph.createRun()
	FileInputStream is2 = new FileInputStream(SS2_Path)
	runData2Value.addPicture(is2, XWPFDocument.PICTURE_TYPE_PNG, SS2_Path, Units.toEMU(500), Units.toEMU(230))
	is2.close()
	
	XWPFRun runData3Value = paragraph.createRun()
	FileInputStream is3 = new FileInputStream(SS3_Path)
	runData3Value.addPicture(is3, XWPFDocument.PICTURE_TYPE_PNG, SS3_Path, Units.toEMU(500), Units.toEMU(230))
	is3.close()
	
	XWPFRun runData4Value = paragraph.createRun()
	FileInputStream is4 = new FileInputStream(SS4_Path)
	runData4Value.addPicture(is4, XWPFDocument.PICTURE_TYPE_PNG, SS4_Path, Units.toEMU(500), Units.toEMU(230))
	is4.close()
	
//	XWPFRun runData5Value = paragraph.createRun()
//	FileInputStream is5 = new FileInputStream(SS5_Path)
//	runData5Value.addPicture(is5, XWPFDocument.PICTURE_TYPE_PNG, SS5_Path, Units.toEMU(500), Units.toEMU(230))
//	is5.close()
//	
//	XWPFRun runData6Value = paragraph.createRun()
//	FileInputStream is6 = new FileInputStream(SS6_Path)
//	runData6Value.addPicture(is6, XWPFDocument.PICTURE_TYPE_PNG, SS6_Path, Units.toEMU(500), Units.toEMU(230))
//	is6.close()
	
	
	XWPFRun runDBLabel = paragraph.createRun()
	runDBLabel.addBreak()
	runDBLabel.setBold(true)
	runDBLabel.setFontSize(12)
	runDBLabel.setText("Database")
	runDBLabel.addBreak()
	
	XWPFRun runMaasLabel = paragraph.createRun()
	runMaasLabel.addBreak()
	runMaasLabel.setBold(true)
	runMaasLabel.setFontSize(12)
	runMaasLabel.setText("Maas")
	runMaasLabel.addBreak()
	
	XWPFRun runFEPLabel = paragraph.createRun()
	runFEPLabel.addBreak()
	runFEPLabel.setBold(true)
	runFEPLabel.setFontSize(12)
	runFEPLabel.setText("FEP")
	runFEPLabel.addBreak()
	
	FileOutputStream out = new FileOutputStream(wordPath)
	document.write(out)
	out.close()
	println("Evidence sudah dibuat : " + wordPath)
	}

}
