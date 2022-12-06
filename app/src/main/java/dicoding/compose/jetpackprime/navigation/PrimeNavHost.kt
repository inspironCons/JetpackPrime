package dicoding.compose.jetpackprime.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dicoding.compose.jetpackprime.presentation.screen.SplashScreen
import dicoding.compose.jetpackprime.presentation.screen.detail_movie.DetailMovieScreen
import dicoding.compose.jetpackprime.presentation.screen.detail_movie.DetailMovieViewModel
import dicoding.compose.jetpackprime.presentation.screen.home.HomeScreen
import dicoding.compose.jetpackprime.presentation.screen.home.HomeViewModel
import dicoding.compose.jetpackprime.presentation.screen.onboarding.OnBoardingScreen
import dicoding.compose.jetpackprime.presentation.screen.profile.ProfileScreen
import dicoding.compose.jetpackprime.presentation.screen.profile.ProfileViewModel

@Composable
fun PrimeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    setProfileClick: ((() -> Unit)?) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination =Screen.Splash.route,
        modifier = modifier
    ){
        composable(Screen.Splash.route){
            SplashScreen(){
                navController.navigate(Screen.OnBoarding.route){
                    popUpTo(Screen.Splash.route){
                        inclusive = true
                    }
                }
            }
        }
        composable(Screen.OnBoarding.route){
            OnBoardingScreen {
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.OnBoarding.route){
                        inclusive = true
                    }
                }
            }
        }

        composable(Screen.Home.route){
            val viewModel:HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel =viewModel,
                setProfileClick = setProfileClick,
                navigateToDetail = { id->
                    navController.navigate(Screen.DetailMovie.createRoute(id))
                },
                navigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }

        composable(
            route = Screen.DetailMovie.route,
            arguments = listOf(
                navArgument("idMovie"){
                    type = NavType.IntType
                }
            )
        ){
            val viewModel:DetailMovieViewModel = hiltViewModel()
            val id = it.arguments?.getInt("idMovie") ?: -1
            DetailMovieScreen(
                idMovie = id,
                viewModel = viewModel
            ){
                navController.navigateUp()
            }
        }

        composable(Screen.Profile.route){
            val viewModel:ProfileViewModel = hiltViewModel()
            ProfileScreen(
                viewModel = viewModel,
                onBackPress = {
                    navController.navigateUp()
                },
                navigateToDetail = {id->
                    navController.navigate(Screen.DetailMovie.createRoute(id))
                }
            )
        }
    }
}