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

//*********Call T3 Login Test case***********
WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [:], FailureHandling.STOP_ON_FAILURE)

//Open the Party from the Party List
WebUI.click(findTestObject('Party List/Party Name Link_DO', [('PartyName') : PartyName]))

WebUI.verifyElementPresent(findTestObject('Party Record/Party Details Tab/bt_Edit'), 10)

//Edit from View mode
WebUI.click(findTestObject('Party Record/Party Details Tab/bt_Edit'))

//Edit Description
WebUI.setText(findTestObject('Party Record/Party Details Tab/Party Description'), 'Test desc')

//Scroll upto breadcrumbs
WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 0)

//Save the party
WebUI.click(findTestObject('Party Record/Party Details Tab/bt_SaveParty'))

//Verify success message
WebUI.verifyTextPresent('saved successfully', false)

