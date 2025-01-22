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

//*******Navigate to SGTIN Profile List page**********
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to SGTIN profile'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SGTIN Profile List/bt_Add Profile'))

WebUI.waitForElementPresent(findTestObject('SGTIN Profile Record/Product Code Type'), 10)

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Product Code Type'), 'GTIN-14', false)

WebUI.click(findTestObject('SGTIN Profile Record/Product Code'))

//WebUI.setText(findTestObject('SGTIN Profile Record/Product Code'), ProductCode.toString())
WebUI.sendKeys(findTestObject('SGTIN Profile Record/Product Code'), ProductCode.toString())

WebUI.click(findTestObject('SGTIN Profile Record/ProductCodeMatchingValue', [('ProductCode') : ProductCode]))

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Serial Number Source'), SerialNumberSource, false)

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Serial Number Template'), SerialNumberTemplate, false, FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.waitForElementClickable(findTestObject('SGTIN Profile Record/bt_SaveProfile'), 5)

WebUI.click(findTestObject('SGTIN Profile Record/bt_SaveProfile'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

WebUI.scrollToElement(findTestObject('SGTIN Profile Record/bt_Assign New System'), 0)

WebUI.click(findTestObject('SGTIN Profile Record/bt_Assign New System'))

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Assign System/Party Name'), PartyName, false)

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Assign System/System Name'), SystemName, false)

WebUI.selectOptionByIndex(findTestObject('SGTIN Profile Record/Assign System/Range'), '1', FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('SGTIN Profile Record/Assign System/MaxRequestQty'), MaxRequestQty)

WebUI.selectOptionByLabel(findTestObject('SGTIN Profile Record/Assign System/Encoding Format'), EncodingFormat, false)

WebUI.click(findTestObject('SGTIN Profile Record/Assign System/bt_SaveSystem'))

WebUI.click(findTestObject('SGTIN Profile Record/Status_Active'))

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('SGTIN Profile Record/bt_SaveProfile'))

WebUI.verifyElementPresent(findTestObject('SGTIN Profile Record/SaveConfirm/SaveConfirmPop-up'), 10, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('SGTIN Profile Record/SaveConfirm/bt_Confirm'), FailureHandling.OPTIONAL)

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(SystemName, false, FailureHandling.OPTIONAL)

