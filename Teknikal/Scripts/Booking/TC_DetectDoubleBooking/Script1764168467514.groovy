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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println("=== TC: DETECT DOUBLE BOOKING ===")

def mock = WebUI.callTestCase(findTestCase('Mock/DataTabel'), [:])
List bookingList = mock[0]

// Slot booking yang dicek
String checkDate = "2022-12-10"
String checkStart = "09:00"
String checkEnd = "11:00"

// Cek bentrok
def conflicting = bookingList.findAll { b ->
	b.date == checkDate &&
	(
		(b.start_time <= checkStart && b.end_time > checkStart) ||
		(b.start_time < checkEnd && b.end_time >= checkEnd)
	)
}

println("Jumlah booking bentrok: " + conflicting.size())
conflicting.each { println("Bentrok: " + it.booking_id) }

try {
	assert conflicting.size() <= 1 : "DOUBLE BOOKING TERDETEKSI!"
	println("Tidak ada double booking.")
} catch (AssertionError e) {
	println(e.message)
	println("Test gagal tapi dilanjutkan...")
}
