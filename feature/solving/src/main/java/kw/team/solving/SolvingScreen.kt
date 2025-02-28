package kw.team.solving

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.solving.component.Options
import kw.team.solving.component.QuestionBox
import kw.team.solving.component.SolvingBottomButtons
import kw.team.solving.component.SolvingTopBar
import kw.team.solving.model.AssessmentModel
import kw.team.subject.model.Subject

@Composable
fun SolvingScreen(
    subject: Subject?,
    onAiChatClick: (question: String) -> Unit,
    viewModel: SolvingViewModel = hiltViewModel<SolvingViewModel>(),
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.fetchAssessments(subject)
    }

    if (uiState.value.isLoading) {
        // LoadingScreen 필요
    } else {
        SolvingScreenContent(
            assessmentIndex = uiState.value.assessments.currentNumber,
            assessment = uiState.value.assessments.current,
            goBack = { println("뒤로가기 네비게이션 구현 필요") },
            save = viewModel::saveAssessment,
            selectOption = viewModel::selectOption,
            showBottomSheet = { onAiChatClick(uiState.value.assessments.current.questionModel.question) },
            returnAnswer = viewModel::returnAnswer,
        )
    }
}

@Composable
fun SolvingScreenContent(
    assessmentIndex: Int,
    assessment: AssessmentModel,
    selectOption: (index: Int) -> Unit,
    goBack: () -> Unit,
    save: () -> Unit,
    showBottomSheet: () -> Unit,
    returnAnswer: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            SolvingTopBar(
                isSaved = assessment.isSaved,
                goBack = goBack,
                save = save,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "문제 $assessmentIndex",
                style = typography.headline20SB,
                color = colors.onBackground,
            )
            Spacer(Modifier.height(12.dp))
            QuestionBox(assessment.questionModel)
            Spacer(Modifier.height(36.dp))
            Text(
                text = "답변",
                style = typography.headline20SB,
                color = colors.onBackground,
            )
            Spacer(Modifier.height(12.dp))
            Options(assessment.options.value, selectOption)
        }

        SolvingBottomButtons(
            onReturnClick = returnAnswer,
            onAiChatClick = showBottomSheet,
            isReturnClickable = assessment.options.selectedIndex != null,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}
