package ru.madmax.autodoctestcase.presentation.home_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.madmax.autodoctestcase.ui.theme.Theme

@Composable
fun Refresher(
    isNeedToRefresh: Boolean,
    isRefresh: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    onRefresh: () -> Unit
) {
    if (isNeedToRefresh) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefresh),
            onRefresh = { onRefresh() },
            indicator = { state, trigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = trigger,
                    contentColor = Theme.colors.barIconColor,
                    backgroundColor = Theme.colors.barColor,
                )
            }
        ) {
            content()
        }
    } else {
        content()
    }
}