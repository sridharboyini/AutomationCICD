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

//***********Call T3 Login********************
WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [('PWD') : PWd, ('UN') : UN], FailureHandling.STOP_ON_FAILURE)

//Add Party
WebUI.click(findTestObject('Party List/Add Party'))

//Go to Party Identifiers Tab
WebUI.click(findTestObject('Party Record/Party Tabs/Party Identifiers Tab'))

//Click Add GCP 
WebUI.click(findTestObject('Party Record/Party Identifiers Tab/Add GCP'))

//Enter GCP value less than 4-digits
WebUI.setText(findTestObject('Object Repository/Party Record/Party Identifiers Tab/GCP Window/GCP GS1CompanyPrefix'), InvalidGCP)

//Enter GCP Description
WebUI.setText(findTestObject('Object Repository/Party Record/Party Identifiers Tab/GCP Window/GCP Description'), GCPDescription)

//Add GCP
WebUI.click(findTestObject('Object Repository/Party Record/Party Identifiers Tab/GCP Window/bt_Add'))

//Verify there is error 
WebUI.verifyTextPresent('GCP length should be >= 4 and <= 12', false, FailureHandling.STOP_ON_FAILURE)

//Generate a random 8-digit GCP
Integer GCP = Math.random() * Math.pow(10, 8)

//Enter above GCP 
WebUI.setText(findTestObject('Object Repository/Party Record/Party Identifiers Tab/GCP Window/GCP GS1CompanyPrefix'), GCP.toString())

//Add GCP
WebUI.click(findTestObject('Object Repository/Party Record/Party Identifiers Tab/GCP Window/bt_Add'))

//Verify GCP is added successfully
WebUI.verifyTextPresent(GCP.toString(), false)

