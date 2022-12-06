package dicoding.compose.jetpackprime.presentation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dicoding.compose.jetpackprime.navigation.PrimeNavHost
import dicoding.compose.jetpackprime.navigation.Screen
import dicoding.compose.jetpackprime.presentation.component.FloatingButton
import dicoding.compose.jetpackprime.presentation.theme.JetpackPrimeTheme

@Composable
fun JetpackPrimeApp(
    navHost:NavHostController = rememberNavController()
) {
    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val (profileClick,setProfileClick) = remember{
        mutableStateOf<(()-> Unit)?>(null)
    }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        floatingActionButton = {
            if(currentRoute == Screen.Home.route){
                FloatingButton(
                    onClickAction = {profileClick?.invoke()},
                    image = Icons.Filled.Person,
                    tint = MaterialTheme.colors.background,
                    contentDescriptor = "about_page"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ){ innerPadding->
        PrimeNavHost(
            navController = navHost,
            modifier = Modifier.padding(innerPadding),
            setProfileClick = setProfileClick
        )
    }
}

@Preview()
@Composable
private fun JetpackPrimeAppPreview() {
    JetpackPrimeTheme {
        JetpackPrimeApp()
    }
}
