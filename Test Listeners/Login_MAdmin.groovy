import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Login_MAdmin {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestSuite
	def BeforeTestSuite(TestSuiteContext testSuiteContext) {
		
		String testSuiteName = testSuiteContext.getTestSuiteId()
		long maxWaitTimeMs = 100000
		long startTime = System.currentTimeMillis()
		
		def listBrowser =[
			"MAdmin", 
			"Login Negative Case"]
		
		if (listBrowser.any { testSuiteName.contains(it) }) {
			
			WebUI.openBrowser('')
			WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
			WebUI.maximizeWindow()
			
		}
		
		if (testSuiteName.contains("MAdmin")) {
			WebUI.openBrowser('')
			WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
			WebUI.maximizeWindow()
			while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {

				boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 1, FailureHandling.OPTIONAL)
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
		} else if (testSuiteName.contains("Login Negative Case")) {
			println("Input dari Testcase")
		
		}
	}
}
		
//		if (testSuiteName.contains("MAdmin")) {
//			WebUI.openBrowser('')
//			WebUI.authenticate('https://tst.yokke.co.id:8443/', 'mtiipg', 'brankasipg', 10)
//			WebUI.maximizeWindow()
//			while ((System.currentTimeMillis() - startTime) < maxWaitTimeMs) {
//				
//					boolean visible =  WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PG Admin/Page_PG Admin/div_Sign InSign in on the PG platform'), 1, FailureHandling.OPTIONAL)
//					if (visible) {
//						//Login PGAdmin
//						WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Username  Email_username'), 'ardhiansyah356@gmail.com')
//						WebUI.setText(findTestObject('Object Repository/Page_PG Admin/input_Password_password'), 'Mti123!@#')
//						WebUI.click(findTestObject('Object Repository/Page_PG Admin/span_Sign in'))
//						break
//							
//					}
//					Thread.sleep(50)
//					println('belum muncul')
//				}
//				
//		} else {
//			println("Skip Listener")
//		}
//	}
//}