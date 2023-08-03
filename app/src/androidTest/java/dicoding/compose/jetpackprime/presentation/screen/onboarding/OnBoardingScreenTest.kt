package dicoding.compose.jetpackprime.presentation.screen.onboarding

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dicoding.compose.jetpackprime.di_test.NetworkModule
import dicoding.compose.jetpackprime.di_test.RepositoryModule
import dicoding.compose.jetpackprime.di_test.UseCaseModule
import dicoding.compose.jetpackprime.presentation.JetpackPrimeApp
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(
    NetworkModule::class,
    RepositoryModule::class,
    UseCaseModule::class
)
@HiltAndroidTest
class OnBoardingScreenTest {

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val rule = createComposeRule()


    @Before
    fun setUp(){
        hiltRule.inject()
        rule.setContent {
            JetpackPrimeTheme {
                JetpackPrimeApp()
            }
        }
    }
    @Test
    fun click_button_then_navigate_to_home_screen(){

        rule.mainClock.advanceTimeBy(4010)
        rule.onNode(hasText("Enter Now")).assertIsDisplayed()
        rule.onNodeWithText("Enter Now").performClick()
    }
}