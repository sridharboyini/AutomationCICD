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
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad as WaitForPageToLoad
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//************Call T3 Login Test case******************** 
//WebUI.callTestCase(findTestCase('Reusable Test cases/T3 Login'), [('UN') : 'init@mailinator.com', ('PWD') : 'p4y+y39Ir5PEPmX20UxFKw=='], 
//    FailureHandling.OPTIONAL)

//************Call Navigate to Product Group Code Test case********************
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Product Group page'), [:], FailureHandling.STOP_ON_FAILURE)

//Click 'Add Product Group' to create new product group code
WebUI.click(findTestObject('Product Group Code/Add Product Group'))

Integer RandumNum = Math.random() * Math.pow(10, 3)

ProductGroup = ('Prod GRP Code ' + RandumNum)

Description = ('Description of ' + ProductGroup)

WebUI.setText(findTestObject('Product Group Code/Product Group Code'), ProductGroup)

WebUI.click(findTestObject('Product Group Code/Status_Active'))

WebUI.setText(findTestObject('Product Group Code/Description'), Description)

WebUI.click(findTestObject('Object Repository/Product Group Code/Save'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

//WebUI.verifyTextPresent(ProductGroup, false)

GlobalVariable.PRODUCT_GRP_CODE = ProductGroup

println(GlobalVariable.PRODUCT_GRP_CODE)
