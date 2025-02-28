package kw.team.solving.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

data class SelectableOptions(
    val value: PersistentList<SelectableOption>,
    val selectedIndex: Int?,
    val answerIndex: Int = -1,
) {
    fun select(index: Int): SelectableOptions {
        if (index == selectedIndex) return this
        val newValue = value.mapIndexed { mapIndex, option ->
            if (mapIndex == selectedIndex) {
                return@mapIndexed option.copy(isSelected = false)
            }
            if (mapIndex == index) {
                return@mapIndexed option.copy(isSelected = true)
            }
            option
        }.toPersistentList()

        return copy(value = newValue, selectedIndex = index)
    }
}
