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
import graphql.util.Breadcrumb as Breadcrumb
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebElement as Keys

//Navigate to 'Product List' page
WebUI.callTestCase(findTestCase('Reusable Test cases/Navigate to Product List page'), [:], FailureHandling.STOP_ON_FAILURE)

//***Add New Product***
WebUI.click(findTestObject('Product List/button_Add Product'))

def ActiveStatus = WebUI.findWebElements(findTestObject('Product Record/Packaging Levels/Status_Active'), 3)

println(ActiveStatus.size())

/*for (int i=0; i < ActiveStatus.size(); i++) {
	
	//WebElement Activ_radio = ActiveStatus.get(i)
	WebUI.click(ActiveStatus.get(i))
	WebUI.verifyElementVisible(ActiveStatus.get(i))
    
}*/
WebUI.waitForElementPresent(findTestObject('Product Record/Product Details/Companys Role'), 10)

WebUI.selectOptionByLabel(findTestObject('Product Record/Product Details/Companys Role'), SupplyChainRole, false)

WebUI.click(findTestObject('Product Record/Product Details/Manufacturer Product Owner'))

WebUI.setText(findTestObject('Product Record/Product Details/Manufacturer Product Owner'), ManufacturerProductOwner)

WebUI.click(findTestObject('Product Record/Product Details/Manufacturer Product Owner option', [('ManufacturerProductOwner') : ManufacturerProductOwner]))

Manufacturer_GLN = WebUI.getAttribute(findTestObject('Product Record/Product Details/Manufacturer GLN'), 'Value')

println(Manufacturer_GLN)

WebUI.click(findTestObject('Product Record/Product Details/Product Group'))

WebUI.setText(findTestObject('Product Record/Product Details/Product Group'), ProductGroup)

WebUI.click(findTestObject('Product Record/Product Details/Product Group option', [('ProductGroup') : ProductGroup]))

WebUI.click(findTestObject('Product Record/Product Details/Status_Active'))

WebUI.click(findTestObject('Product Record/Product Details/Target Market(s)'))

WebUI.setText(findTestObject('Product Record/Product Details/Target Market search'), TargetMarket)

WebUI.click(findTestObject('Product Record/Product Details/Target Market option_DO', [('TargetMarket') : TargetMarket]))

WebUI.selectOptionByLabel(findTestObject('Product Record/Product Details/Commercial Status'), ProdCommercialStatus, false)

WebUI.click(findTestObject('Product Record/Product Details/button_Add Identifier'))

WebUI.click(findTestObject('Product Record/Product Details/Product Identifier Type'))

WebUI.setText(findTestObject('Product Record/Product Details/Product Identifier Type'), ProductIdentifierType)

WebUI.click(findTestObject('Product Record/Product Details/Product Identifier Type option', [('ProductIdentifierType') : ProductIdentifierType]))

ProductIdentifierValue = (Math.random() * Math.pow(10, 6)).toInteger()

WebUI.setText(findTestObject('Product Record/Product Details/Product Identifier'), ProductIdentifierValue.toString())

WebUI.selectOptionByLabel(findTestObject('Product Record/Product Details/Country'), ProductIDCountry, false)

WebUI.click(findTestObject('Product Record/Product Details/button_Add'))

WebUI.verifyTextPresent(ProductIdentifierValue.toString(), false)

ProductName = ('Product of ' + ManufacturerProductOwner.toString())

WebUI.setText(findTestObject('Product Record/Product Details/Product Name'), ProductName)

WebUI.setText(findTestObject('Product Record/Product Details/Proprietary Name'), 'Proprietary ' + ProductName)

WebUI.setText(findTestObject('Product Record/Product Details/Strength'), Strength)

WebUI.selectOptionByLabel(findTestObject('Product Record/Product Details/Dosage Form'), DosageForm, false)

WebUI.setText(findTestObject('Product Record/Product Details/Pack Size Description'), PackSizeDescription)

WebUI.selectOptionByLabel(findTestObject('Product Record/Product Details/Pack Type'), PackType, false)

//Scroll up to "Save" button
WebUI.scrollToElement(findTestObject('Home/Bread Crumbs'), 10)

WebUI.click(findTestObject('Product Record/Product Details/bt_SaveProduct'))

WebUI.verifyTextPresent('saved successfully', false)

WebUI.delay(3)

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Reusable Test cases/Add Packaging Level'), [('PackagingLevel') : 'Each', ('RFID') : '3'
        , ('GCPLength') : '5'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/Add Packaging Level'), [('PackagingLevel') : 'Inner Bundle', ('RFID') : '6'
        , ('GCPLength') : '5', ('ContainedQty') : '5'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Test cases/Add Packaging Level'), [('PackagingLevel') : 'Case', ('RFID') : '3'
        , ('GCPLength') : '5', ('ContainedQty') : '10'], FailureHandling.STOP_ON_FAILURE)

