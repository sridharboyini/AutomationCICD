import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.apache.groovy.parser.antlr4.GroovyParser.IfElseStatementContext as IfElseStatementContext
import org.codehaus.groovy.ast.stmt.IfStatement as IfStatement
import org.openqa.selenium.Keys as Keys

//************Call Login Test case***************
//************Navigate to System List page**********
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to System List page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('System List/button_Add System'))

WebUI.waitForElementPresent(findTestObject('System Record/Party Name'), 10)

WebUI.selectOptionByLabel(findTestObject('System Record/Party Name'), PartyName, false)

WebUI.click(findTestObject('System Record/Status_Active'))

SystemName = ('System ' + PartyName)

SystemDescription = ('Description ' + SystemName)

GlobalVariable.SYSTEM_NAME = SystemName

WebUI.setText(findTestObject('System Record/System Name'), SystemName)

WebUI.setText(findTestObject('System Record/System Description'), SystemDescription)

WebUI.click(findTestObject('System Record/button_Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

