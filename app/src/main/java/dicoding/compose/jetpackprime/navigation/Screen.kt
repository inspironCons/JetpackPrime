package dicoding.compose.jetpackprime.navigation

sealed class Screen(val route:String){
    object OnBoarding:Screen("onboarding")
    object Home:Screen("home")
    object DetailMovie:Screen("home/{idMovie}"){
        fun createRoute(id:Int) ="home/$id"
    }
    object Profile:Screen("profile")
}
