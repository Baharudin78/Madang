package com.baharudin.common.navigation

import android.net.Uri
import androidx.core.net.toUri

object DestinationDeeplink {

    private val BaseUrl = "app://com.baharudin.madang".toUri()
    val HomePattern = "$BaseUrl/${Destination.HomeScreen.route}"
    val BookmarkPattern = "$BaseUrl/${Destination.BookmarkScreen.route}"

    fun getHomeUri() : Uri =
        HomePattern.toUri()
}