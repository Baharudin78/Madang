package com.baharudin.common.components

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.baharudin.common.navigation.Destination

@Composable
fun bottomBarVisibility(
    navController: NavController
) : MutableState<Boolean>{
    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    when(navBackStackEntry?.destination?.route) {
        Destination.HomeScreen.route -> bottomBarState.value = true
        Destination.SearchScreen.route -> bottomBarState.value = true
        Destination.BookmarkScreen.route -> bottomBarState.value = true
        Destination.ProfileScreen.route -> bottomBarState.value = true
        else -> bottomBarState.value = false
    }
    return bottomBarState
}

fun Modifier.bottomBarAnimatedScroll(
    height : Dp = 56.dp,
    offsetHeightPx : MutableState<Float>
) : Modifier = composed {
    val bottomBarHeightPx = with(LocalDensity.current) {
        height.roundToPx().toFloat()
    }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val delta = available.y
                val newOffset = offsetHeightPx.value + delta
                offsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }
    this.nestedScroll(nestedScrollConnection)
}