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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [:], FailureHandling.STOP_ON_FAILURE)

//Add Location to 1st party in the Party List
WebUI.click(findTestObject('Party List/Edit Icon'))

//Select Loc Classification as 'Subsite'
WebUI.selectOptionByLabel(findTestObject('Party Record/Locations Tab/Location Record/Location Classification'), 'Digital Location', false)

//Verify Digital Address field appears
WebUI.verifyTextPresent('Digital Address', false)

//Get the class attribute of Address Line1 field
String classVar = WebUI.getAttribute(findTestObject('Party Record/1.Party Details/Address.AddressLine1'), 'class')

//Verify it is disabled
if(classVar.indexOf('disabled')) {
	
	KeywordUtil.markPassed("Test Passed")
}
else {
	KeywordUtil.markFailed("Test Failed")
}