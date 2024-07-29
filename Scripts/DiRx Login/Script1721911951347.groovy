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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.FindWebElementKeyword as FindWebElementKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.codehaus.groovy.ast.stmt.TryCatchStatement
import org.openqa.selenium.Keys as Keys

//try {
WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev.dirxhealth.com/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/DiRx/Sign In/Email Address'), 'tu1@mailinator.com')

WebUI.setEncryptedText(findTestObject('Object Repository/DiRx/Sign In/Password'), 'BrBzdLpvazk/ZzAC4/igcg==')

WebUI.click(findTestObject('Object Repository/DiRx/Sign In/button_Sign In'))

WebUI.click(findTestObject('Object Repository/DiRx/Account/Account Details'))

WebUI.click(findTestObject('Object Repository/DiRx/Account/a_Sign Out'))

WebUI.closeBrowser()

//}catch (Exception e)
//{
	WebUI.takeScreenshot("C:\\Users\\Sridhar Boyini\\Desktop\\Serialization\\testscr.jpg")
//}

