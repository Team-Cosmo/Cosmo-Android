package kw.team.solving.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

data class AssessmentsModel(
    val index: Int,
    val value: PersistentList<AssessmentModel>,
) {
    val current: AssessmentModel get() = value[index]
    val currentNumber get() = index + 1

    fun selectOption(index: Int): AssessmentsModel {
        val newItem = current.copy(options = current.options!!.select(index))
        val newValue = value.mapIndexed { mapIndex, value ->
            if (mapIndex == this.index) newItem
            else value
        }.toPersistentList()
        return copy(value = newValue)
    }

    fun next(): AssessmentsModel {
        return copy(index = index + 1)
    }
}
