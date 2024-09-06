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
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Party List/Add Party'))

int randomnumber = Math.random() * 100

String partyName = 'Party ' + randomnumber

WebUI.setText(findTestObject('Party Record/Party Details Tab/Party Name'), partyName)

WebUI.click(findTestObject('Party Record/Party Details Tab/bt_SaveParty'))

WebUI.delay(4)

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Party Record/Party Tabs/Locations Tab'))

WebUI.click(findTestObject('Party Record/Locations Tab/Add Location'))

String parentName

parentName = WebUI.getText(findTestObject('Party Record/Locations Tab/Location Record/Location Parent Name'))

if (parentName == partyName) {
    KeywordUtil.markPassed('Test case passed')
} else {
    KeywordUtil.markFailed('Failed')
}

