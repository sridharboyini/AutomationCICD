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

WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Party List page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Party Test Cases/Add Test Cases/Add party in Draft status'), [('PartyName') : 'Party Testing'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Party Record/Party Tabs/Locations Tab'))

WebUI.click(findTestObject('Party Record/Locations Tab/Add Location'))

WebUI.selectOptionByLabel(findTestObject('Party Record/Locations Tab/Location Record/Location Classification'), 'Function', 
    false)

WebUI.selectOptionByLabel(findTestObject('Party Record/Locations Tab/Location Record/Location Type'), LocationType, false)

//Get 'class' property of Address Line field
String classValue = WebUI.getAttribute(findTestObject('Party Record/Locations Tab/Location Record/Address Line 1'), 'class')

//Verify that the address field is disabled
if(classValue.indexOf("disabled") == -1) {
	KeywordUtil.markFailedAndStop("Test case Failed")
}

String parentName = WebUI.getText(findTestObject('Party Record/Locations Tab/Location Record/Location Parent Name'))

String LocName = (LocationType + ' of ') + parentName

WebUI.setText(findTestObject('Party Record/Locations Tab/Location Record/Location Name'), LocName)

WebUI.click(findTestObject('Party Record/Locations Tab/Location Record/Status_Draft'))

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Party Record/Locations Tab/Location Record/Location Identifiers Tab'))

WebUI.callTestCase(findTestCase('Reusable Test cases/GLN Generator'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Party Record/Locations Tab/Location Record/GLN'), GlobalVariable.ID_GLN.toString())

WebUI.setText(findTestObject('Party Record/Locations Tab/Location Record/GLN Extension'), '123')

WebUI.selectOptionByLabel(findTestObject('Party Record/Locations Tab/Location Record/GCP Length'), '6', false)

WebUI.click(findTestObject('Party Record/Locations Tab/Location Record/bt_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

