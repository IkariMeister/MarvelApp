package com.ikarimeister.marvelapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CellButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    subtitleTextColor: Color = Color.Black,
    topDividerVisible: Boolean = true,
    bottomDividerVisible: Boolean = true,
    disclosure: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .defaultMinSize(minHeight = 82.dp)
            .clickable { onClick() }
            .padding(start = 16.dp, end = 16.dp)
    ) {
        if (topDividerVisible) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {
            if (leadingIcon != null) {
                Box(
                    Modifier.padding(end = 16.dp)
                        .fillMaxWidth(0.2f)
                        .fillMaxHeight(1f)
                ) {
                    leadingIcon()
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                if (!subtitle.isNullOrBlank()) {
                    Text(
                        text = subtitle,
                        color = subtitleTextColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            if (trailingIcon != null) {
                Box(Modifier.padding(start = 16.dp)) {
                    trailingIcon()
                }
            }

            if (disclosure != null) {
                Box(Modifier.padding(start = 16.dp)) {
                    disclosure()
                }
            }
        }

        if (bottomDividerVisible) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}
