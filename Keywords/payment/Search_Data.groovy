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

public class Search_Data {
	public static void createEvidence(
			String wordPath,
			String SS1_Path,
			String SS2_Path,
			String SS3_Path,
			String SS4_Path,
			String SS5_Path,
			String SS6_Path,
			String SS7_Path,
			String SS8_Path) {
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
		
		XWPFRun runTitleValue = paragraph.createRun()
		runTitleValue.setBold(true)
		runTitleValue.setFontSize(12)
		runTitleValue.setText("Menu Monitoring")
		runTitleValue.addBreak()
		runTitleValue.setText("--------------------------------------------------")
		runTitleValue.addBreak()
		
//		XWPFParagraph paragraph = document.createParagraph()

		// --- GAMBAR 1 (INPUT) ---
		XWPFRun runMerchantLabel = paragraph.createRun()
		runMerchantLabel.addBreak()
		runMerchantLabel.setBold(true)
		runMerchantLabel.setFontSize(12)
		runMerchantLabel.setText("TC 34. Field Merchant")
		runMerchantLabel.addBreak()

		XWPFRun runMerchantValue = paragraph.createRun()
		FileInputStream is1 = new FileInputStream(SS1_Path)
		runMerchantValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1_Path, Units.toEMU(500), Units.toEMU(230))
		is1.close()

		// --- GAMBAR 2 (HASIL) ---
		XWPFRun runCurrencyLabel = paragraph.createRun()
		runCurrencyLabel.addBreak()
		runCurrencyLabel.setBold(true)
		runCurrencyLabel.setFontSize(12)
		runCurrencyLabel.setText("TC 35. Field Currency")
		runCurrencyLabel.addBreak()

		XWPFRun runCurrencyValue = paragraph.createRun()
		FileInputStream is2 = new FileInputStream(SS2_Path)
		runCurrencyValue.addPicture(is2, XWPFDocument.PICTURE_TYPE_PNG, SS2_Path, Units.toEMU(500), Units.toEMU(230))
		is2.close()
		
		XWPFRun runFDLabel = paragraph.createRun()
		runFDLabel.addBreak()
		runFDLabel.setBold(true)
		runFDLabel.setFontSize(12)
		runFDLabel.setText("TC 36. Field From Date")
		runFDLabel.addBreak()
		
		XWPFRun runFDValue = paragraph.createRun()
		FileInputStream is3 = new FileInputStream(SS3_Path)
		runFDValue.addPicture(is3, XWPFDocument.PICTURE_TYPE_PNG, SS3_Path, Units.toEMU(500), Units.toEMU(230))
//		is3.close()
		
		XWPFRun runTDValue = paragraph.createRun()
		FileInputStream is4 = new FileInputStream(SS4_Path)
		runTDValue.addPicture(is4, XWPFDocument.PICTURE_TYPE_PNG, SS4_Path, Units.toEMU(500), Units.toEMU(230))
		is4.close()

		XWPFRun runMethodLabel = paragraph.createRun()
		runMethodLabel.addBreak()
		runMethodLabel.setBold(true)
		runMethodLabel.setFontSize(12)
		runMethodLabel.setText("TC 37. Field Payment Method")
		runMethodLabel.addBreak()
		
		XWPFRun runMethodValue = paragraph.createRun()
		FileInputStream is5 = new FileInputStream(SS5_Path)
		runMethodValue.addPicture(is5, XWPFDocument.PICTURE_TYPE_PNG, SS5_Path, Units.toEMU(500), Units.toEMU(230))
		is5.close()

		XWPFRun runProviderLabel = paragraph.createRun()
		runProviderLabel.addBreak()
		runProviderLabel.setBold(true)
		runProviderLabel.setFontSize(12)
		runProviderLabel.setText("TC 38. Field Payment Provider")
		runProviderLabel.addBreak()
		
		XWPFRun runProviderValue = paragraph.createRun()
		FileInputStream is6 = new FileInputStream(SS6_Path)
		runProviderValue.addPicture(is6, XWPFDocument.PICTURE_TYPE_PNG, SS6_Path, Units.toEMU(500), Units.toEMU(230))
		is6.close()

		XWPFRun runFilterLabel = paragraph.createRun()
		runFilterLabel.addBreak()
		runFilterLabel.setBold(true)
		runFilterLabel.setFontSize(12)
		runFilterLabel.setText("TC 39. Search With Filter Data")
		runFilterLabel.addBreak()
		
		XWPFRun runFilterValue = paragraph.createRun()
		FileInputStream is7 = new FileInputStream(SS7_Path)
		runFilterValue.addPicture(is7, XWPFDocument.PICTURE_TYPE_PNG, SS7_Path, Units.toEMU(500), Units.toEMU(230))
		is7.close()
		
		XWPFRun runHasilLabel = paragraph.createRun()
		runHasilLabel.addBreak()
		runHasilLabel.setBold(true)
		runHasilLabel.setFontSize(12)
		runHasilLabel.setText("TC 40. Search Data")
		runHasilLabel.addBreak()

		XWPFRun runHasilValue = paragraph.createRun()
		FileInputStream is8 = new FileInputStream(SS8_Path)
		runHasilValue.addPicture(is8, XWPFDocument.PICTURE_TYPE_PNG, SS8_Path, Units.toEMU(500), Units.toEMU(230))
		is8.close()

		FileOutputStream out = new FileOutputStream(wordPath)
		document.write(out)
		out.close()
		println("Evidence sudah dibuat : " + wordPath)
	}
}

