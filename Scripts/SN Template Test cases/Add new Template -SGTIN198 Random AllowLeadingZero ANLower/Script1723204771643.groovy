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

//New Template with attributes as:
//SGTIN-96, Random, Numeric10, SPF > 1  
//**********Navigate to Serial Number Template List page***************
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Serial Number Template List'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Serial Number Template List/button_Add Template'))

WebUI.waitForElementPresent(findTestObject('SN Template Record/Template Details/EPC Schema'), 10)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/EPC Schema'), EPCSchema, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Coding Schema'), CodingSchema, false)

WebUI.click(findTestObject('SN Template Record/Template Details/Status_Active'))

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Serial Number Type'), SNType, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Allow Leading Zero'), 'Yes', false)

WebUI.setText(findTestObject('SN Template Record/Template Details/Serial Number Length'), SNLength)

WebUI.click(findTestObject('SN Template Record/Template Details/input_AN_Lower Case'))

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Sparseness Factor'), SparsenessFactor, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Uniqueness'), Uniqueness, false)

WebUI.scrollToElement(findTestObject('SN Template Record/Template Details/Serial Number Template Name'), 10)

WebUI.click(findTestObject('SN Template Record/Template Details/Serial Number Template Name'))

//Generate Random number 
Integer RandomNum = Math.random() * Math.pow(10, 4)

//Append Random Number to Template Name
WebUI.sendKeys(findTestObject('SN Template Record/Template Details/Serial Number Template Name'), '_' + RandomNum.toString())

WebUI.setText(findTestObject('SN Template Record/Template Details/Replenish Threshold'), ReplenishThreshold)

WebUI.setText(findTestObject('SN Template Record/Template Details/Maximum Threshold'), RequestQTY)

WebUI.setText(findTestObject('SN Template Record/Template Details/Alert Available Range'), AlertPercentage)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('SN Template Record/Template Details/bt_SaveTemplate'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

TemplateName = WebUI.getAttribute(findTestObject('Object Repository/SN Template Record/Template Details/Serial Number Template Name'), 
    'Value')

GlobalVariable.SN_TEMPLATE_NAME = TemplateName

WebUI.click(findTestObject('SN Template Record/Template Details/button_Assign Template Tab'))

WebUI.click(findTestObject('SN Template Record/Assign Template Tab/Product Owner dropdown'))

WebUI.setText(findTestObject('SN Template Record/Assign Template Tab/Product Owner search'), ProductOwner)

WebUI.click(findTestObject('SN Template Record/Assign Template Tab/Product Owner checkbox_DO', [('ProductOwner') : ProductOwner]))

WebUI.click(findTestObject('SN Template Record/Assign Template Tab/button_Add'))

WebUI.verifyElementPresent(findTestObject('SN Template Record/Assign Template Tab/Product Owner row_DO', [('ProductOwner') : ProductOwner]), 
    10)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 0)

WebUI.click(findTestObject('SN Template Record/Template Details/bt_SaveTemplate'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

