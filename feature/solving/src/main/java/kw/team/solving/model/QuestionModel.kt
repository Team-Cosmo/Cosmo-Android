package kw.team.solving.model

import android.content.Context

data class QuestionModel(
    val id: Int,
    val subject: SubjectModel,
    val assessmentType: AssessmentTypeModel,
    val assessmentsType: AssessmentsTypeModel,
    val question: String,
    val answer: Int = -1,
) {
    fun getAssessmentInfo(context: Context): String {
        val sb = StringBuilder()
        return sb.append(context.getString(assessmentsType.value))
            .append(" · ")
            .append(context.getString(subject.value))
            .append(" · ")
            .append(context.getString(assessmentType.value))
            .toString()
    }
}
