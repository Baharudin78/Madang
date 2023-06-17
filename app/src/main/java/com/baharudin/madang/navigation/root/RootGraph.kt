package com.baharudin.madang.navigation.root

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.baharudin.madang.navigation.onboarding.onBoardingNavGraph
import com.google.accompanist.navigation.animation.composable

@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun RootNavigationGraph(
    navHostController: NavHostController,
    startDestination : String
) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        onBoardingNavGraph(navHostController)
        composable(route = Graph.MAIN) {
         //   MainScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val MAIN = "main_graph"
    const val ON_BOARDING = "on_boarding"
}