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
import org.apache.commons.validator.routines.checkdigit.CheckDigit
import org.openqa.selenium.Keys as Keys


//This Test case generates valid 13-digit GLN 
long gln_gtn

long random_number = 0

int multiplier = 3

int checkdigit = 0

int rem

//Generate 13-digit random number. Repeating in case it is not 13-digit.
while(random_number.toString().length() != 13) {
	
	random_number = Math.random() * Math.pow(10, 13)
	
	//println random_number + 'Length:' + random_number.toString().length()
}

println random_number

gln_gtn = random_number

while (random_number!=0) {

	rem = random_number % 10
	
	checkdigit = checkdigit + rem * multiplier
	
	random_number = random_number / 10
		
	if (multiplier == 3) {
	
		multiplier = 1
	}
	else {
		multiplier = 3
	}

}
//println checkdigit

if((checkdigit % 10)!=0) {
	
	checkdigit = 10 - checkdigit % 10
}
else {
	checkdigit = 0
}

GlobalVariable.ID_GTIN = (gln_gtn * 10) + checkdigit

println GlobalVariable.ID_GTIN 
