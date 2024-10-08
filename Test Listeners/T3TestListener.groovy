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

class T3TestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	@BeforeTestCase
	def T3BeforeTestCase() {
		
		//Open the Browser
		WebUI.openBrowser(GlobalVariable.APPURL)
		
		//Navigate to T3 URL
	//	WebUI.navigateToUrl(GlobalVariable.APPURL)
		
		//Maximize the Browser
		WebUI.maximizeWindow()
		
		//Enter User Name
		WebUI.setText(findTestObject('Object Repository/Login/Email'), GlobalVariable.BETAUSER)
		
		//Enter Password
		WebUI.setEncryptedText(findTestObject('Object Repository/Login/Password'), GlobalVariable.BETAPASSWORD)
		
		//Click Login
		WebUI.click(findTestObject('Object Repository/Login/Login'))
		
		//Click on 'Manage Parties' link if it exists
		WebUI.click(findTestObject('Object Repository/Login/Manage Parties'), FailureHandling.OPTIONAL)

		//Wait until page refreshes
		WebUI.waitForPageLoad(10)
		
		//Verify if Logout is visible
		WebUI.verifyElementVisible(findTestObject('Home/Logout'))
		
	}
	
//	@AfterTestCase
	def T3AfterTestCase() {
		
		//Click Logout
		WebUI.click(findTestObject('Home/Logout'))
		
		//Wait until page refreshes
		WebUI.waitForPageLoad(10)
		
		//Close the Browser
		WebUI.closeBrowser()
	}

	
}