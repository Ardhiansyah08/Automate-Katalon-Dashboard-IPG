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
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.util.Units
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

public class Evidence {
		public static void createEvidence(String wordPath, String SS1_Path, String SS2_Path) {
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
		runDataKartuLabel.setText("Input Data Kartu")
		runDataKartuLabel.addBreak()
		
		XWPFRun runDataKartuValue = paragraph.createRun()
		FileInputStream is1 = new FileInputStream(SS1_Path)
		runDataKartuValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1_Path, Units.toEMU(500), Units.toEMU(230))
		is1.close()
		
		// --- GAMBAR 2 (HASIL) ---
		XWPFRun runHasilLabel = paragraph.createRun()
		runHasilLabel.addBreak()
		runHasilLabel.setBold(true)
		runHasilLabel.setFontSize(12)
		runHasilLabel.setText("Hasil Payment")
		runHasilLabel.addBreak()
		
		XWPFRun runHasilValue = paragraph.createRun()
		FileInputStream is2 = new FileInputStream(SS2_Path)
		runHasilValue.addPicture(is2, XWPFDocument.PICTURE_TYPE_PNG, SS2_Path, Units.toEMU(500), Units.toEMU(230))
		is2.close()
		
//		XWPFRun runAdminLabel = paragraph.createRun()
//		runAdminLabel.addBreak()
//		runAdminLabel.setBold(true)
//		runAdminLabel.setFontSize(12)
//		runAdminLabel.setText("Admin")
//		runAdminLabel.addBreak()
//		
//		XWPFRun runMaasLabel = paragraph.createRun()
//		runMaasLabel.addBreak()
//		runMaasLabel.setBold(true)
//		runMaasLabel.setFontSize(12)
//		runMaasLabel.setText("Maas")
//		runMaasLabel.addBreak()
//		
//		XWPFRun runFEPLabel = paragraph.createRun()
//		runFEPLabel.addBreak()
//		runFEPLabel.setBold(true)
//		runFEPLabel.setFontSize(12)
//		runFEPLabel.setText("FEP")
//		runFEPLabel.addBreak()
//		
		FileOutputStream out = new FileOutputStream(wordPath)
		document.write(out)
		out.close()
		println("Evidence sudah dibuat : " + wordPath)
	}
}

