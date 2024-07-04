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
import internal.GlobalVariable
import net.bytebuddy.utility.RandomString
import org.apache.commons.text.RandomStringGenerator
import org.openqa.selenium.Keys as Keys

//Call Login test cases
WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [:], FailureHandling.STOP_ON_FAILURE)

//Click 'Add Party' button
WebUI.click(findTestObject('Party List/Add Party'))

//Click 'Save' without input 
WebUI.click(findTestObject('Party Record/1.Party Details/bt_Save'))

//Verify error appears on 'Party Name'
WebUI.verifyTextPresent('Name is required', false)

//Enter Party Name
WebUI.setText(findTestObject('Object Repository/Party Record/1.Party Details/Party Name'), 'Party 101')

//Save Party
WebUI.click(findTestObject('Object Repository/Party Record/1.Party Details/bt_Save'))

//Verify Party is saved 
WebUI.verifyTextPresent("saved successfully", false)