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

//*********Call Login Test case************
//WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [('UN') : 'init@mailinator.com', ('PWD') : 'p4y+y39Ir5PEPmX20UxFKw=='], 
//    FailureHandling.STOP_ON_FAILURE)
//Navigate to 'Party List' page
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Party List page'), [:], FailureHandling.STOP_ON_FAILURE)

//Click on 'Add Party' to create new party
WebUI.click(findTestObject('Party List/Add Party'))

WebUI.waitForElementPresent(findTestObject('Party Record/Party Details Tab/Party Type'), 10)

WebUI.selectOptionByLabel(findTestObject('Party Record/Party Details Tab/Party Type'), PartyType, false)

WebUI.click(findTestObject('Party Record/Party Details Tab/Business Role(s)'))

WebUI.setText(findTestObject('Party Record/Party Details Tab/Business Role(s)_search'), RoleString)

WebUI.click(findTestObject('Party Record/Party Details Tab/Business Role(s) option', [('RoleString') : RoleString]))

//********Create unique name for the party****************
Integer RandNum = Math.random() * Math.pow(10, 5)

GlobalVariable.PARTY_NAME = ('Party ' + RandNum)

WebUI.setText(findTestObject('Party Record/Party Details Tab/Party Name'), GlobalVariable.PARTY_NAME.toString())

WebUI.click(findTestObject('Party Record/Party Details Tab/Status_Active'))

WebUI.click(findTestObject('Party Record/Party Tabs/Party Identifiers'))

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/Add GCP'))

//*************Generate random GCP************
Integer GCP = RandNum

GlobalVariable.ID_GCP = GCP

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GCP Window/GCP GS1CompanyPrefix'), GCP.toString())

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GCP Window/GCP Description'), 'Testing: GCP Description')

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/GCP Window/StatusActive'))

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/GCP Window/bt_Add'))

WebUI.verifyTextPresent(GCP.toString(), false)

//**************Generate GLN**********************
WebUI.callTestCase(findTestCase('Reusable Test cases/GLN Generator'), [:], FailureHandling.STOP_ON_FAILURE)

//String GLN = GlobalVariable.ID_GLN
WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GLN'), GlobalVariable.ID_GLN.toString())

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GLNExtension'), GLNExtension)

WebUI.selectOptionByValue(findTestObject('Party Record/Party Identifiers Tab/GCP Length'), GCPLength, false)

//****Save the Party****
WebUI.click(findTestObject('Party Record/Party Details Tab/bt_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

