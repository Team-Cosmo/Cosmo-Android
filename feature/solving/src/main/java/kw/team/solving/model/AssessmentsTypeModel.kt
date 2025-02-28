package kw.team.solving.model

import androidx.annotation.StringRes
import kw.team.cosmo.feature.solving.R

enum class AssessmentsTypeModel(@StringRes val value: Int) {
    TODAY(R.string.assessmentsType_today),
    SUBJECT(R.string.assessmentsType_subject),
}