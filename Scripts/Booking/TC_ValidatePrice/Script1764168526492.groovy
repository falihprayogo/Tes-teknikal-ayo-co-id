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

println("=== TC: VALIDATE BOOKING PRICE ===")

def mock = WebUI.callTestCase(findTestCase('Mock/DataTabel'), [:])
List bookingList = mock[0]
List scheduleList = mock[1]

def validatePrice = { String bookingId ->

	println("\n--- VALIDASI ${bookingId} ---")

	def booking = bookingList.find { it.booking_id == bookingId }
	def schedule = scheduleList.find {
		it.venue_id == booking.venue_id &&
		it.date == booking.date &&
		it.start_time == booking.start_time
	}

	println("Booking Price  : ${booking.price}")
	println("Schedule Price : ${schedule.price}")

	try {
		assert booking.price == schedule.price :
			"❌ Harga booking ${bookingId} tidak sesuai schedule!"
		println("✅ Harga booking ${bookingId} sesuai schedule.")
	} catch (AssertionError e) {
		println(e.message)
		println("⚠ Test gagal tapi dilanjutkan...")
	}
}

validatePrice("BK/000001")
validatePrice("BK/000005")

println("\n=== VALIDASI HARGA SELESAI ===")
