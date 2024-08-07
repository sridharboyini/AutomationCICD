import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Dialog.ModalExclusionType as ModalExclusionType
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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
import org.checkerframework.checker.units.qual.Length as Length
import org.openqa.selenium.Keys as Keys

final PARTY_TYPE = 'Partner'

Integer GCPValue = Math.random() * Math.pow(10, 6)

//***Navigate to Party List*****
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Party List page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Party List/Add Party'))

WebUI.verifyElementPresent(findTestObject('Party Record/Party Tabs/Party Details Tab'), 10)

WebUI.selectOptionByLabel(findTestObject('Party Record/Party Details Tab/Party Type'), PARTY_TYPE, false)

WebUI.click(findTestObject('Party Record/Party Details Tab/Status_Active'))

WebUI.click(findTestObject('Party Record/Party Details Tab/Business Role(s)'))

WebUI.setText(findTestObject('Party Record/Party Details Tab/Business Role(s)_search'), BusinessRole)

WebUI.click(findTestObject('Party Record/Party Details Tab/Business Role(s)_searchResult', [('RoleString') : BusinessRole]))

PartyName = ('Party ' + GCPValue)

WebUI.setText(findTestObject('Party Record/Party Details Tab/Party Name'), PartyName)

WebUI.click(findTestObject('Party Record/Party Tabs/Party Identifiers Tab'))

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/Add GCP'))

GCP = GCPValue.toString()

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GCP Window/GCP GS1CompanyPrefix'), GCP)

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GCP Window/GCP Description'), 'Testing ' + GCP)

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/GCP Window/StatusActive'))

WebUI.click(findTestObject('Party Record/Party Identifiers Tab/GCP Window/bt_Add'))

WebUI.callTestCase(findTestCase('Reusable Test cases/GLN Generator'), [:], FailureHandling.STOP_ON_FAILURE)

GLN = GlobalVariable.ID_GLN.toString()

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GLN'), GLN)

WebUI.setText(findTestObject('Party Record/Party Identifiers Tab/GLNExtension'), GLN_Extn)

String GCPLength = GCPValue.toString().length()

WebUI.selectOptionByLabel(findTestObject('Party Record/Party Identifiers Tab/GCP Length'), GCPLength, false)

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Party Record/Party Details Tab/bt_Save'))

WebUI.verifyElementVisible(findTestObject('Home/Save Message'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

GlobalVariable.PARTY_NAME = PartyName

