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

WebUI.callTestCase(findTestCase('Party Test Cases/Add New Party'), [('RoleString') : 'Dispenser', ('PartyType') : 'Partner'
        , ('GLNExtension') : '1234', ('GCPLength') : '6'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Product Group Code Test Cases/Add New Product Group code'), [('ProductGroup') : '', ('Description') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Product Test Cases/Add New Product'), [('SupplyChainRole') : 'CMO', ('ManufacturerProductOwner') : GlobalVariable.PARTY_NAME
        , ('ProductGroup') : GlobalVariable.PRODUCT_GRP_CODE, ('TargetMarket') : 'US', ('ProdCommercialStatus') : 'In Market'
        , ('ProductIdentifierType') : 'MG_ADMDM', ('ProductIdentifierValue') : '', ('ProductIDCountry') : 'US - United States of America'
        , ('ProductName') : GlobalVariable.PARTY_NAME, ('ProprietaryName') : '', ('Strength') : '100 MG', ('DosageForm') : 'CAPSULE'
        , ('PackSizeDescription') : '25 units', ('PackType') : 'CAPSULE', ('ProductDescription') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('System Test Cases/Add New System for Partner Party'), [('PartyName') : GlobalVariable.PARTY_NAME
        , ('SystemName') : '', ('SystemDescription') : '', ('SenderIDGLN') : GlobalVariable.ID_GLN], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Serial Number Template/Add new Template with Active status'), [('TemplateName') : '', ('ProductOwner') : GlobalVariable.PARTY_NAME
        , ('EPCSchema') : 'SGTIN', ('CodingSchema') : 'SGTIN-96', ('SNType') : 'Random', ('SNLength') : '10', ('SparsenessFactor') : '100'
        , ('Uniqueness') : 'Packaging Level', ('ReplenishThreshold') : '15000', ('RequestQTY') : '5000', ('AlertPercentage') : '50'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('SGTIN Profile/Add New SGTIN Profile'), [('ProductCode') : GlobalVariable.ID_GTIN, ('SerialNumberTemplate') : GlobalVariable.SN_TEMPLATE_NAME
        , ('PartyName') : GlobalVariable.PARTY_NAME, ('SystemName') : GlobalVariable.SYSTEM_NAME, ('Range') : '1', ('MaxRequestQty') : '15000'
        , ('DeliveryMode') : 'List', ('EncodingFormat') : 'PLAIN_KEY'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Serial Number Request/Add New SGTIN Request'), [('ProductCode') : GlobalVariable.ID_GTIN
        , ('RequestingParty') : GlobalVariable.PARTY_NAME, ('RequestingSystem') : GlobalVariable.SYSTEM_NAME, ('RequestQTY') : '15000'], 
    FailureHandling.STOP_ON_FAILURE)
