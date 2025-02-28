package kw.team.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition.Companion.Center
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import kw.team.ai.model.AiModel.CLAUDE
import kw.team.ai.model.AiModel.GPT
import kw.team.designsystem.component.CosmoAiChatButton
import kw.team.main.component.MainAiChatBottomSheet
import kw.team.main.component.MainBottomAppBar
import kw.team.main.component.MainNavHost
import kw.team.main.model.MainBottomAppBarTab
import kw.team.main.model.MainBottomAppBarTab.HOME
import kw.team.solving.navigation.Solving

private const val BLANK = ""

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    val gptChatLog = mainViewModel.gptChatLog.collectAsStateWithLifecycle()
    val claudeChatLog = mainViewModel.claudeChatLog.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { mainViewModel.aiModels.size })
    var currentBottomSheetTab by remember { mutableStateOf(mainViewModel.aiModels.first()) }
    var isShowBottomSheet by remember { mutableStateOf(false) }
    var currentBottomAppBarTab by remember { mutableStateOf(HOME) }
    var message by remember { mutableStateOf(BLANK) }
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(
        bottomBar = {
            if (currentDestination != null && currentDestination.hasRoute<Solving>().not()) {
                MainBottomAppBar(
                    currentTab = currentBottomAppBarTab,
                    tabs = MainBottomAppBarTab.entries,
                    onTabClick = { selectedTab -> currentBottomAppBarTab = selectedTab },
                )
            }
        },
        floatingActionButton = {
            if (currentDestination != null && currentDestination.hasRoute<Solving>().not()) {
                CosmoAiChatButton(
                    onClick = { isShowBottomSheet = true },
                    elevation = 4.dp,
                    modifier = Modifier.offset(y = 44.dp),
                )
            }
        },
        floatingActionButtonPosition = Center,
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            MainNavHost(
                navController = navController,
                showBottomSheet = { question ->
                    mainViewModel.ask(question = question)
                    isShowBottomSheet = true
                }
            )

            if (isShowBottomSheet) {
                MainAiChatBottomSheet(
                    onDismissRequest = { isShowBottomSheet = false },
                    onTabClick = { selectedTab ->
                        scope.launch { pagerState.animateScrollToPage(selectedTab.ordinal) }
                        currentBottomSheetTab = selectedTab
                    },
                    onSendMessageClick = {
                        mainViewModel.converseWith(message = message)
                        message = BLANK
                    },
                    onTextValueChanged = { text -> message = text },
                    bottomSheetState = bottomSheetState,
                    pagerState = pagerState,
                    selectedTab = currentBottomSheetTab,
                    tabs = mainViewModel.aiModels,
                    messages = when (currentBottomSheetTab) {
                        CLAUDE -> claudeChatLog.value
                        GPT -> gptChatLog.value
                    },
                    message = message,
                )
            }
        }
    }
}
