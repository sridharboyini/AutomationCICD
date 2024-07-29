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

WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Serial Number Request'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Serial Number Request Record/Product Code'), 10)

WebUI.sendKeys(findTestObject('Serial Number Request Record/Product Code'), ProductCode)

WebUI.click(findTestObject('Serial Number Request Record/ProductCodeMatchingValue'))

WebUI.selectOptionByLabel(findTestObject('Serial Number Request Record/Requesting Party'), RequestingParty, false)

WebUI.selectOptionByLabel(findTestObject('Serial Number Request Record/Requesting System'), RequestingSystem, false)

WebUI.setText(findTestObject('Serial Number Request Record/Request Quantity'), RequestQTY)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Serial Number Request Record/button_Save'))

//WebUI.verifyTextPresent('successfully', false)

WebUI.verifyElementPresent(findTestObject('Serial Number Request Record/Success Message'), 10)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Serial Number Request Record/Request Log Tab'))

WebUI.verifyTextPresent(ProductCode, false)

