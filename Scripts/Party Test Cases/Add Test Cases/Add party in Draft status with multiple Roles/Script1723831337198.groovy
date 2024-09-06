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

//**********Navigate to Party List page***************
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Party List page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Party List/Add Party'))

WebUI.callTestCase(findTestCase('Reusable Test cases/Select Party Business Role'), [('BusinessRole') : '3PL'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/Select Party Business Role'), [('BusinessRole') : 'CMO'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/Select Party Business Role'), [('BusinessRole') : 'Virtual CMO'], FailureHandling.STOP_ON_FAILURE)

Integer RandNum = Math.random() * Math.pow(10, 3)

WebUI.setText(findTestObject('Party Record/Party Details Tab/Party Name'), PartyName + RandNum)

WebUI.click(findTestObject('Party Record/Party Details Tab/bt_SaveParty'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

