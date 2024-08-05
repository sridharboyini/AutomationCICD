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

final def EPC_SCHEMA = 'SSCC'

final def CODING_SCHEMA = 'SSCC-96'

final def SERIAL_NUMBER_TYPE = 'Sequential'

final def ALLOW_LEADING_ZERO = 'Yes'

//**********Navigate to Serial Number Template List page***************
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Serial Number Template List'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Serial Number Template List/button_Add Template'))

WebUI.waitForElementPresent(findTestObject('Serial Number Template Record/Template Details/EPC Schema'), 10)

WebUI.selectOptionByLabel(findTestObject('Serial Number Template Record/Template Details/EPC Schema'), EPC_SCHEMA, false)

WebUI.verifyElementNotVisible(findTestObject('Serial Number Template Record/Template Details/Serial Number Length'))

WebUI.verifyElementNotVisible(findTestObject('Serial Number Template Record/Template Details/Uniqueness'))

WebUI.click(findTestObject('Serial Number Template Record/Template Details/Status_Active'))

WebUI.selectOptionByLabel(findTestObject('Serial Number Template Record/Template Details/Serial Number Type'), SERIAL_NUMBER_TYPE, 
    false)

WebUI.selectOptionByLabel(findTestObject('Serial Number Template Record/Template Details/Allow Leading Zero'), ALLOW_LEADING_ZERO, false)

WebUI.verifyElementChecked(findTestObject('Serial Number Template Record/Template Details/input_Numeric'), 5)

//Generate Random number
Integer RandomNum = Math.random() * Math.pow(10, 4)

WebUI.click(findTestObject('Serial Number Template Record/Template Details/Serial Number Template Name'))

//Append Random Number to Template Name to make it unique
WebUI.sendKeys(findTestObject('Serial Number Template Record/Template Details/Serial Number Template Name'), '_' + RandomNum.toString())

WebUI.setText(findTestObject('Serial Number Template Record/Template Details/Replenish Threshold'), ReplenishThreshold)

WebUI.setText(findTestObject('Serial Number Template Record/Template Details/Reorder Quantity'), RequestQTY)

WebUI.setText(findTestObject('Serial Number Template Record/Template Details/Alert Available Range'), AlertPercentage)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Product Record/Product Details/button_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

TemplateName = WebUI.getAttribute(findTestObject('Serial Number Template Record/Template Details/Serial Number Template Name'), 'Value')

GlobalVariable.SN_TEMPLATE_NAME = TemplateName

