package kw.team.solving.model

import androidx.annotation.StringRes
import kw.team.cosmo.feature.solving.R

enum class SubjectModel(@StringRes val value: Int) {
    OperatingSystem(R.string.subject_operatingSystem),
    Network(R.string.subject_network),
    Algorithm(R.string.subject_algorithm),
    Database(R.string.subject_database),
    DataStructure(R.string.subject_dataStructure),
}