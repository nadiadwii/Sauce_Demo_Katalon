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

import com.kms.katalon.core.testobject.ConditionType

WebUI.callTestCase(findTestCase('Login/Login_Standard'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_ADD TO CART'))

// Verifikasi bahwa elemen induk (container) ada di halaman
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/container_Sauce Labs Backpackcarry'), 10)

// Verifikasi bahwa elemen anak (title) ada di dalam container (Cek button Add sudah berubah ke Remove)
TestObject productTitle = new TestObject()
productTitle.addProperty("css", ConditionType.EQUALS, "button.btn_secondary.btn_inventory")

WebUI.verifyElementPresent(productTitle, 10)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/svg_Open Menu_svg-inline--fa fa-shopping-ca_f4ec0f'))

// Verifikasi produk yang ditambahkan ada di keranjang
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Backpack'), 60)