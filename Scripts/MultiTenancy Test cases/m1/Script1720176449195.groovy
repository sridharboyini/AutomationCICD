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

WebUI.callTestCase(findTestCase('E2E Test cases/E2E - Party to SGTIN Request'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [('UN') : GlobalVariable.ALPHA_USER, ('PWD') : GlobalVariable.ALPHA_PASSWORD], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Party Test Cases/Search Test Cases/Search Party By GLN'), [('strGLN') : GlobalVariable.ID_GLN
        , ('strMessage') : 'Displaying 0 of 0 records'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Product Test Cases/Search Test Cases/Search Product by GTIN-14'), [('strGTIN') : GlobalVariable.ID_GTIN
        , ('strMessage') : 'Displaying 0 of 0 records', ('strStatus') : 'All'], FailureHandling.STOP_ON_FAILURE)

