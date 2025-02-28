package kw.team.solving.model

import androidx.annotation.StringRes
import kw.team.cosmo.feature.solving.R

enum class AssessmentTypeModel(@StringRes val value: Int) {
    DESCRIPTIVE(R.string.assessmentType_descriptive),
    MULTIPLE_CHOICE(R.string.assessmentType_multipleChoice),
}