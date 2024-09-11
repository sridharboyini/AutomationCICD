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

WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to SSCC Profile'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SSCC Profile List/bt_Add Profile'))

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Party Name'), PartyName, false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/GS1 Company Prefix'), GS1Prefix, false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Extension Digit'), ExtensionDigit, false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Assign System/RFID Filter'), RFID, false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Serial Number Source'), SNSource, false)

WebUI.selectOptionByIndex(findTestObject('SSCC Profile Record/Serial Number Template'), '1', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SSCC Profile Record/SSCC Profile Description'))

WebUI.click(findTestObject('SSCC Profile Record/status_Active'))

WebUI.click(findTestObject('SSCC Profile Record/bt_SaveProfile'))

WebUI.delay(3)

WebUI.waitForPageLoad(10)

WebUI.scrollToElement(findTestObject('SSCC Profile Record/bt_Assign New System'), 10)

WebUI.waitForElementClickable(findTestObject('SSCC Profile Record/bt_Assign New System'), 10)

WebUI.click(findTestObject('SSCC Profile Record/bt_Assign New System'))

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Assign System/Party Name'), PartyName, false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Assign System/System Name'), SystemName, false)

WebUI.selectOptionByIndex(findTestObject('SSCC Profile Record/Assign System/Range'), '1', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('SSCC Profile Record/Assign System/Max Request Quantity'), '5000')

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Assign System/Delivery Mode'), 'List', false)

WebUI.selectOptionByLabel(findTestObject('SSCC Profile Record/Assign System/Encoding Format'), 'Plain Serial Numbers', false)

WebUI.click(findTestObject('SSCC Profile Record/Assign System/bt_SaveSystem'))

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('SSCC Profile Record/bt_SaveProfile'))

WebUI.delay(3)

WebUI.waitForPageLoad(10)

