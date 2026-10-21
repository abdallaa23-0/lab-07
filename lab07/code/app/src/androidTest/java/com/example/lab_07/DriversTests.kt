package com.example.lab_07

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_screen() {
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("Formula Zero Drivers").assertExists()


    }
    fun add_driver_and_verify(){
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Hamilton").assertExists()

    }

    @Test
    fun clear_drivers(){
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Verstappen")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Hamilton").assertExists()
        composeTestRule.onNodeWithText("Verstappen").assertExists()
        composeTestRule.onNodeWithTag("clearInput").performClick()
        composeTestRule.onNodeWithText("Hamilton").assertDoesNotExist()
        composeTestRule.onNodeWithText("Verstappen").assertDoesNotExist()

    }

    @Test
    fun back_home(){
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }


}