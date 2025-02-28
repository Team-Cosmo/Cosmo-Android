package kw.team.solving

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kw.team.ai.repository.AiRepository
import kw.team.solving.model.AssessmentModel
import kw.team.solving.model.AssessmentTypeModel
import kw.team.solving.model.AssessmentsModel
import kw.team.solving.model.AssessmentsTypeModel
import kw.team.solving.model.QuestionModel
import kw.team.solving.model.SelectableOption
import kw.team.solving.model.SelectableOptions
import kw.team.solving.model.SubjectModel
import kw.team.subject.model.Subject
import javax.inject.Inject

@HiltViewModel
class SolvingViewModel @Inject constructor(
    private val aiRepository: AiRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(UiState.getIdleState())
    val state: StateFlow<UiState> = _state

    private val dummy = AssessmentsModel(
        index = 0,
        value = persistentListOf(
            AssessmentModel(
                questionModel = QuestionModel(
                    id = 1,
                    subject = SubjectModel.OperatingSystem,
                    assessmentsType = AssessmentsTypeModel.SUBJECT,
                    assessmentType = AssessmentTypeModel.MULTIPLE_CHOICE,
                    question = "자바의 기본 데이터 타입은?",
                    answer = 2,
                ),
                options = SelectableOptions(
                    value = persistentListOf(
                        SelectableOption(1, "int", false),
                        SelectableOption(2, "String", false),
                        SelectableOption(3, "Array", false),
                        SelectableOption(4, "List", false),
                    ),
                    selectedIndex = null,
                ),
                isSaved = false,
            ),
            AssessmentModel(
                questionModel = QuestionModel(
                    id = 2,
                    subject = SubjectModel.OperatingSystem,
                    assessmentsType = AssessmentsTypeModel.SUBJECT,
                    assessmentType = AssessmentTypeModel.MULTIPLE_CHOICE,
                    question = "SQL에서 데이터를 추가하는 명령어는?",
                    answer = 2,
                ),
                options = SelectableOptions(
                    value = persistentListOf(
                        SelectableOption(1, "INSERT", false),
                        SelectableOption(2, "UPDATE", false),
                        SelectableOption(3, "DELETE", false),
                        SelectableOption(4, "SELECT", false),
                    ),
                    selectedIndex = null,
                ),
                isSaved = false,
            )
        )
    )

    val reply: MutableStateFlow<String> = MutableStateFlow("")

    fun fetchAssessments(subject: Subject?) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            runCatching {
                //aiRepository.fetchQuiz()
                // if(subject == null) 오늘의 학습 else 과목별 학습
                delay(1000L)
            }.onSuccess {
                _state.update { it.copy(assessments = dummy, isLoading = false) }
            }.onFailure {
                _state.update { it.copy(isLoading = false, isError = true) }
            }
        }
    }

    fun selectOption(index: Int) {
        _state.update {
            it.copy(assessments = it.assessments.selectOption(index))
        }
    }

    fun returnAnswer() {
        _state.update {
            it.copy(
                assessments = it.assessments.next()
            )
        }
    }

    fun saveAssessment() {
        // 문제 북마크 로직 필요
    }

    data class UiState(
        val assessments: AssessmentsModel,
        val isLoading: Boolean,
        val isError: Boolean,
    ) {
        companion object {
            fun getIdleState(): UiState {
                return UiState(
                    assessments = AssessmentsModel(0, persistentListOf()),
                    isLoading = true,
                    isError = false
                )
            }
        }
    }
}
