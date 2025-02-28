package kw.team.main.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kw.team.home.navigation.Home
import kw.team.home.navigation.homeScreen
import kw.team.solving.navigation.navigateToSolving
import kw.team.solving.navigation.solvingScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    showBottomSheet: (question: String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Home,
    ) {
        homeScreen(homeNavigation = navController::navigateToSolving)
        solvingScreen(
            onAiChatClick = { question ->
                showBottomSheet(question)
            }
        )
    }
}

//case1: 대학 생활 중 과제할 때 시간을 많이 사용하는 것이 스트레스로 다가온다.
//
//- 과제할 때 가장 많이 시간을 쏟는 단계는 무엇인가요?
//
//-> 요구 사항에 부합하는 과제를 구현하기 위한 자료 조사 및
//
//- 과제 시간을 줄이기 위해 어떤 노력을 해보셨나요?
//- AI를 활용해서 과제를 하는 학생들을 자주 접하시나요? 본인은 어떻게 사용하시나요?
//- 과제를 할 때, 술술 불렸던
//경험과 너무 막막했던 경험을 들려주실 수 있나요? 막막했을 때 결과물을
//만들기 위해 어떤 식으로 노력을 하셨나요?
