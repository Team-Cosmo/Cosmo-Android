package kw.team.home.model

import kw.team.cosmo.feature.home.R
import kw.team.subject.model.Subject
import kw.team.subject.model.Subject.Algorithm
import kw.team.subject.model.Subject.DataStructure
import kw.team.subject.model.Subject.Database
import kw.team.subject.model.Subject.Network
import kw.team.subject.model.Subject.OperatingSystem

data class SubjectUiModel(
    val subject: Subject,
) {
    val name by lazy {
        when (subject) {
            Algorithm -> "알고리즘"
            OperatingSystem -> "운영체제"
            Network -> "네트워크"
            Database -> "데이터베이스"
            DataStructure -> "자료구조"
        }
    }
    val icon by lazy {
        when (subject) {
            Algorithm -> R.drawable.ic_algorithm
            OperatingSystem -> R.drawable.ic_os
            Network -> R.drawable.ic_network
            Database -> R.drawable.ic_database
            DataStructure -> R.drawable.ic_data_structure
        }
    }
}
