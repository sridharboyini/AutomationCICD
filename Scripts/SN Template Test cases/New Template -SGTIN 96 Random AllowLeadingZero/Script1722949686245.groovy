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

//*****New Template with following attributes:
final String EPC_SCHEMA = 'SGTIN'

final String CODING_SCHEMA = 'SGTIN-96'

final String SERIAL_NUM_TYPE = 'Random'

final String ALLOW_LEADING_ZERO = 'Yes'


//**********Navigate to Serial Number Template List page***************
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Serial Number Template List'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Serial Number Template List/button_Add Template'))

WebUI.waitForElementPresent(findTestObject('SN Template Record/Template Details/EPC Schema'), 10)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/EPC Schema'), EPC_SCHEMA, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Coding Schema'), CODING_SCHEMA, false)

WebUI.click(findTestObject('SN Template Record/Template Details/Status_Active'))

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Serial Number Type'), SERIAL_NUM_TYPE, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Allow Leading Zero'), ALLOW_LEADING_ZERO, false)

WebUI.setText(findTestObject('SN Template Record/Template Details/Serial Number Length'), SNLength)

WebUI.click(findTestObject('SN Template Record/Template Details/input_Numeric'))

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Sparseness Factor'), SparsenessFactor, false)

WebUI.selectOptionByLabel(findTestObject('SN Template Record/Template Details/Uniqueness'), Uniqueness, false)

WebUI.click(findTestObject('SN Template Record/Template Details/Serial Number Template Name'))

//Generate Random number 
Integer RandomNum = Math.random() * Math.pow(10, 4)

//Append Random Number to Template Name
WebUI.sendKeys(findTestObject('SN Template Record/Template Details/Serial Number Template Name'), '_' + RandomNum.toString())

WebUI.setText(findTestObject('SN Template Record/Template Details/Replenish Threshold'), ReplenishThreshold)

WebUI.setText(findTestObject('SN Template Record/Template Details/Reorder Quantity'), RequestQTY)

WebUI.setText(findTestObject('SN Template Record/Template Details/Alert Available Range'), AlertPercentage)

//Scroll-up so that Save button is visible
WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

//Save the Template
WebUI.click(findTestObject('Product Record/Product Details/button_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

//Capture Template Name from the UI
TemplateName = WebUI.getAttribute(findTestObject('SN Template Record/Template Details/Serial Number Template Name'), 'Value')

//Save the Template Name in Global Variable
GlobalVariable.SN_TEMPLATE_NAME = TemplateName

//Go to 'Assign Template' tab
WebUI.click(findTestObject('SN Template Record/Template Details/button_Assign Template Tab'))

//Assign Product Owner to the Template
WebUI.click(findTestObject('SN Template Record/Assign Template Tab/Product Owner dropdown'))

WebUI.setText(findTestObject('SN Template Record/Assign Template Tab/Product Owner search'), ProductOwner)

WebUI.click(findTestObject('SN Template Record/Assign Template Tab/Product Owner checkbox_DO', [('ProductOwner') : ProductOwner]))

WebUI.click(findTestObject('SN Template Record/Assign Template Tab/button_Add'))

WebUI.verifyElementPresent(findTestObject('SN Template Record/Assign Template Tab/Product Owner row_DO', [('ProductOwner') : ProductOwner]), 
    10)

//Scroll-up so that 'Save' button is visible
WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

//Save the Template
WebUI.click(findTestObject('SN Template Record/Template Details/button_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

