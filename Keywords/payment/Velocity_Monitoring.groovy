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

public class Velocity_Monitoring {
	public static void createEvidence(
			String wordPath,
			String SS1_Path,
			String SS2_Path,
			String SS3_Path,
			String SS4_Path,
			String SS5_Path,
			String SS6_Path,
			String SS7_Path,
			String SS8_Path,
			String SS9_Path,
			String SS10_Path,
			String SS11_Path,
			String SS12_Path) {
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
		runTitleValue.setText("Menu Velocity Monitoring")
		runTitleValue.addBreak()
		runTitleValue.setText("--------------------------------------------------")
		runTitleValue.addBreak()
		
//		XWPFParagraph paragraph = document.createParagraph()

		// --- GAMBAR 1 (INPUT) ---
		XWPFRun runMerchantLabel = paragraph.createRun()
		runMerchantLabel.addBreak()
		runMerchantLabel.setBold(true)
		runMerchantLabel.setFontSize(12)
		runMerchantLabel.setText("Select Merchant")
		runMerchantLabel.addBreak()

		XWPFRun runMerchantValue = paragraph.createRun()
		FileInputStream is1 = new FileInputStream(SS1_Path)
		runMerchantValue.addPicture(is1, XWPFDocument.PICTURE_TYPE_PNG, SS1_Path, Units.toEMU(500), Units.toEMU(230))
//		is1.close()
		
		XWPFRun runMerchant2Value = paragraph.createRun()
		FileInputStream is2 = new FileInputStream(SS2_Path)
		runMerchant2Value.addPicture(is2, XWPFDocument.PICTURE_TYPE_PNG, SS2_Path, Units.toEMU(500), Units.toEMU(230))
		is2.close()

		// --- GAMBAR 2 (HASIL) ---
		XWPFRun runVTLabel = paragraph.createRun()
		runVTLabel.addBreak()
		runVTLabel.setBold(true)
		runVTLabel.setFontSize(12)
		runVTLabel.setText("Select Velocity Type")
		runVTLabel.addBreak()
		
		XWPFRun runVTValue = paragraph.createRun()
		FileInputStream is3 = new FileInputStream(SS3_Path)
		runVTValue.addPicture(is3, XWPFDocument.PICTURE_TYPE_PNG, SS3_Path, Units.toEMU(500), Units.toEMU(230))
		is3.close()
		
		XWPFRun runMTLabel = paragraph.createRun()
		runMTLabel.addBreak()
		runMTLabel.setBold(true)
		runMTLabel.setFontSize(12)
		runMTLabel.setText("Search Velocity Type - Merchant Tip")
		runMTLabel.addBreak()
		
		XWPFRun runMTValue = paragraph.createRun()
		FileInputStream is4 = new FileInputStream(SS4_Path)
		runMTValue.addPicture(is4, XWPFDocument.PICTURE_TYPE_PNG, SS4_Path, Units.toEMU(500), Units.toEMU(230))
		is4.close()

		XWPFRun runAPILabel = paragraph.createRun()
		runAPILabel.addBreak()
		runAPILabel.setBold(true)
		runAPILabel.setFontSize(12)
		runAPILabel.setText("Search Velocity Type - Apiburst")
		runAPILabel.addBreak()
		
		XWPFRun runAPIValue = paragraph.createRun()
		FileInputStream is5 = new FileInputStream(SS5_Path)
		runAPIValue.addPicture(is5, XWPFDocument.PICTURE_TYPE_PNG, SS5_Path, Units.toEMU(500), Units.toEMU(230))
		is5.close()

		XWPFRun runCountryLabel = paragraph.createRun()
		runCountryLabel.addBreak()
		runCountryLabel.setBold(true)
		runCountryLabel.setFontSize(12)
		runCountryLabel.setText("Search Velocity Type - Countrylist")
		runCountryLabel.addBreak()
		
		XWPFRun runCountryValue = paragraph.createRun()
		FileInputStream is6 = new FileInputStream(SS6_Path)
		runCountryValue.addPicture(is6, XWPFDocument.PICTURE_TYPE_PNG, SS6_Path, Units.toEMU(500), Units.toEMU(230))
		is6.close()

		XWPFRun runBinlistLabel = paragraph.createRun()
		runBinlistLabel.addBreak()
		runBinlistLabel.setBold(true)
		runBinlistLabel.setFontSize(12)
		runBinlistLabel.setText("Search Velocity Type - Binlist")
		runBinlistLabel.addBreak()
		
		XWPFRun runBinlistValue = paragraph.createRun()
		FileInputStream is7 = new FileInputStream(SS7_Path)
		runBinlistValue.addPicture(is7, XWPFDocument.PICTURE_TYPE_PNG, SS7_Path, Units.toEMU(500), Units.toEMU(230))
		is7.close()
		
		XWPFRun runPanburstLabel = paragraph.createRun()
		runPanburstLabel.addBreak()
		runPanburstLabel.setBold(true)
		runPanburstLabel.setFontSize(12)
		runPanburstLabel.setText("Search Velocity Type - Panburst")
		runPanburstLabel.addBreak()

		XWPFRun runPanburstValue = paragraph.createRun()
		FileInputStream is8 = new FileInputStream(SS8_Path)
		runPanburstValue.addPicture(is8, XWPFDocument.PICTURE_TYPE_PNG, SS8_Path, Units.toEMU(500), Units.toEMU(230))
		is8.close()

		XWPFRun runMaxMerLabel = paragraph.createRun()
		runMaxMerLabel.addBreak()
		runMaxMerLabel.setBold(true)
		runMaxMerLabel.setFontSize(12)
		runMaxMerLabel.setText("Search Velocity Type - Maxtrxmerchant")
		runMaxMerLabel.addBreak()

		XWPFRun runMaxMerValue = paragraph.createRun()
		FileInputStream is9 = new FileInputStream(SS9_Path)
		runMaxMerValue.addPicture(is9, XWPFDocument.PICTURE_TYPE_PNG, SS9_Path, Units.toEMU(500), Units.toEMU(230))
		is9.close()
		
		XWPFRun runMaxtrxpanLabel = paragraph.createRun()
		runMaxtrxpanLabel.addBreak()
		runMaxtrxpanLabel.setBold(true)
		runMaxtrxpanLabel.setFontSize(12)
		runMaxtrxpanLabel.setText("Search Velocity Type - Maxtrxpan")
		runMaxtrxpanLabel.addBreak()

		XWPFRun runMaxtrxpanValue = paragraph.createRun()
		FileInputStream is10 = new FileInputStream(SS10_Path)
		runMaxtrxpanValue.addPicture(is10, XWPFDocument.PICTURE_TYPE_PNG, SS10_Path, Units.toEMU(500), Units.toEMU(230))
		is10.close()
		
		XWPFRun run3dsLabel = paragraph.createRun()
		run3dsLabel.addBreak()
		run3dsLabel.setBold(true)
		run3dsLabel.setFontSize(12)
		run3dsLabel.setText("Search Velocity Type - 3ds")
		run3dsLabel.addBreak()

		XWPFRun run3dsValue = paragraph.createRun()
		FileInputStream is11 = new FileInputStream(SS11_Path)
		run3dsValue.addPicture(is11, XWPFDocument.PICTURE_TYPE_PNG, SS11_Path, Units.toEMU(500), Units.toEMU(230))
		is11.close()
		
		XWPFRun runDomesLabel = paragraph.createRun()
		runDomesLabel.addBreak()
		runDomesLabel.setBold(true)
		runDomesLabel.setFontSize(12)
		runDomesLabel.setText("Search Velocity Type - Domestic")
		runDomesLabel.addBreak()

		XWPFRun runDomesValue = paragraph.createRun()
		FileInputStream is12 = new FileInputStream(SS12_Path)
		runDomesValue.addPicture(is12, XWPFDocument.PICTURE_TYPE_PNG, SS12_Path, Units.toEMU(500), Units.toEMU(230))
		is12.close()
		
		FileOutputStream out = new FileOutputStream(wordPath)
		document.write(out)
		out.close()
		println("Evidence sudah dibuat : " + wordPath)
	}
}

