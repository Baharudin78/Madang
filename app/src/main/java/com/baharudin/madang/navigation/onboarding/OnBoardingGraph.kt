package com.baharudin.madang.navigation.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.baharudin.madang.navigation.root.Graph
import com.google.accompanist.navigation.animation.composable

fun NavGraphBuilder.onBoardingNavGraph(navController: NavController) {
    navigation(
        route = Graph.ON_BOARDING,
        startDestination = OnBoardingScreen.Welcome.route
    ){
//        composable(route = OnBoardingScreen.Welcome.route){
//
//        }
    }
}

sealed class OnBoardingScreen(val route : String){
    object Welcome : OnBoardingScreen("welcome_screen")
}

