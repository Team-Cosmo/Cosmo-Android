package kw.team.solving.model

data class AssessmentModel(
    val questionModel: QuestionModel,
    val options: SelectableOptions,
    val isSaved: Boolean,
)
