package com.baharudin.common.navigation

import com.baharudin.common.R
import com.baharudin.common.util.Constants

sealed class Destination(
    val route : String,
    val title : String? = null,
    val icon : Int? = null
) {

    object HomeScreen: Destination(
        route = Constants.HOME_ROUTE,
        title = Constants.HOME_SCREEN,
        icon = R.drawable.house
    )

    object SearchScreen: Destination(
        route = Constants.SEARCH_ROUTE,
        title = Constants.SEARCH_SCREEN,
        icon = R.drawable.search_interface_symbol
    )

    object BookmarkScreen: Destination(
        route = Constants.BOOKMARK_ROUTE,
        title = Constants.BOOKMARK_SCREEN,
        icon = R.drawable.bookmark
    )

    object ProfileScreen: Destination(
        route = Constants.PROFILE_ROUTE,
        title = Constants.PROFILE_SCREEN,
        icon = R.drawable.user
    )

    object DetailScreen : Destination(
        route = Constants.DETAIL_ROUTE,
    )
    object LoginScreen : Destination(
        route = Constants.LOGIN_ROUTE
    )

    object RegisterScreen : Destination(
        route = Constants.REGISTER_ROUTE
    )

}