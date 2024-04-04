package com.example.weatherapp.utils

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun DefaultToolbar(
    title: String,
    backgroundColor: Color = Base50,
    backIcon: Int  = com.example.weatherapp.R.drawable.ic_back_arrow,
    toolbarTextEndPadding: Dp = 48.dp,
    textColor: Color = Base900,
    fontSize: TextUnit = fontSize18,
    fontWeight: FontWeight = FontWeight.Bold,
    iconColor: Color = Base900,
    showBackButton: Boolean = true,
    onBackClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
    ) {
        Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

        Row(
            modifier = Modifier.padding(spacing4),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                BackButton(
                    iconRes = backIcon,
                    iconColor = iconColor,
                    onBackClick = onBackClick
                )
            } else {
                Box(modifier = Modifier.size(48.dp))
            }

            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    textAlign = TextAlign.Center,
                    color = textColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Box(
                modifier = Modifier
                    .height(48.dp)
                    .width(toolbarTextEndPadding)
            )
        }
    }
}
@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int = com.example.weatherapp.R.drawable.ic_back_arrow,
    iconColor: Color,
    onBackClick: () -> Unit
) {
    Button(onClick = onBackClick, modifier = modifier) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconColor
        )
    }
}
