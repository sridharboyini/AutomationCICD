import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.entity.testcase.TestCaseEntity as TestCaseEntity
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


String str

//Get Test case Name
//str = RunConfiguration.getExecutionSourceName().toString()

//println(str)
//println(str.length())
//
//println(123.mod(10))
Name = 'Hello World'

println("$Name")

RandomNum = Math.random()

Integer GCPValue = RandomNum * Math.pow(10, 6)

println(RandomNum.to)

println(GCPValue)

//String str

//Get Test case Name
//str = RunConfiguration.getExecutionSourceName().toString()

//println(str)
//println(str.length())
//
//println(123.mod(10))
Name = 'Hello World'

println("$Name")

RandomNum = Math.random()

Integer GCPValue = Math.random() * Math.pow(10, 6)

println(RandomNum.to)

println(GCPValue)

