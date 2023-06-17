package com.baharudin.madang.navigation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.navDeepLink
import com.baharudin.common.navigation.Destination
import com.baharudin.common.navigation.DestinationDeeplink
import com.baharudin.madang.navigation.root.Graph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalLayoutApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainGraph(navHostController: NavHostController, paddingValues: PaddingValues) {
    AnimatedNavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = Destination.HomeScreen.route
    ) {
        composable(
            route = Destination.HomeScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = DestinationDeeplink.HomePattern
                }
            ),
            enterTransition = {
                when (initialState.destination.route) {
                    else -> null
                }
            },
            exitTransition = {
                 when(initialState.destination.route){
                     else -> null
                 }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    else -> null
                }
            }
        ){

        }
        composable()
    }
}