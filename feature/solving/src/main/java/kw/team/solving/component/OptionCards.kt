package kw.team.solving.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kw.team.solving.model.SelectableOption

@Composable
internal fun Options(
    options: ImmutableList<SelectableOption>,
    onClick: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(
            count = options.size,
            key = { options[it].value }
        ) { index: Int ->
            Option(
                option = options[index],
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable { onClick(index) }
            )
        }
    }
}

@Composable
@Preview
private fun OptionsPreview() {
    Options(
        options = persistentListOf(
            SelectableOption(1, "권세 권, 쓸 용, 민첩할 민", false),
            SelectableOption(3, "권세 권, 쓸 용, 백성 민", false),
            SelectableOption(2, "권세 권, 녹 용, 천 민", false),
            SelectableOption(4, "권세 권, 용 용, 옥돌 민", false),
            SelectableOption(5, "권세 권, 얼굴 용, 옥돌 민", false)
        ),
        onClick = {},
    )
}