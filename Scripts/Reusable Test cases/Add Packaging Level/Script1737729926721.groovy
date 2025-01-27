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
import org.openqa.selenium.WebElement as Keys

//Go to "Packaging Level" tab
WebUI.click(findTestObject('Product Record/Product Details/Tab_Packaging Levels'))

if (PackagingLevel != 'Each') {
    //Click 'Add Packaging Level' icon
    WebUI.click(findTestObject('Product Record/Packaging Levels/Add Packaging Level'))

    WebUI.delay(3)
}

//Select Packaging Level
WebUI.selectOptionByLabel(findTestObject('Product Record/Packaging Levels/Packaging Level'), PackagingLevel, false)

def ActiveStatus = WebUI.findWebElements(findTestObject('Product Record/Packaging Levels/Status_Active'), 3)

println(ActiveStatus.size())

//WebUI.click(findTestObject('Product Record/Packaging Levels/Status_Active'))
WebUI.selectOptionByLabel(findTestObject('Product Record/Packaging Levels/Product Code Type'), 'GTIN-14', false)

//**********Call Test case to generate new GTIN******************
WebUI.callTestCase(findTestCase('Reusable Test cases/GTIN Generator'), [:], FailureHandling.STOP_ON_FAILURE)

def GTIN = GlobalVariable.ID_GTIN.toString()

WebUI.setText(findTestObject('Product Record/Packaging Levels/Product Code'), GTIN)

WebUI.selectOptionByValue(findTestObject('Product Record/Packaging Levels/RFID Filter Value'), RFID, true)

WebUI.selectOptionByValue(findTestObject('Product Record/Packaging Levels/GS1 Company Prefix Length'), GCPLength, false)

WebUI.setText(findTestObject('Product Record/Packaging Levels/SKU'), GTIN)

//Enter 'Unit of Use' for EACH only
if (PackagingLevel == 'Each') {
    WebUI.setText(findTestObject('Product Record/Packaging Levels/Unit of Use GTIN'), GTIN) //Select the first option
} else {
    WebUI.selectOptionByIndex(findTestObject('Object Repository/Product Record/Packaging Levels/Contained GTIN'), 1)

    WebUI.setText(findTestObject('Object Repository/Product Record/Packaging Levels/Contained Quantity'), ContainedQty)
}

WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Product Record/Product Details/bt_SaveProduct'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

