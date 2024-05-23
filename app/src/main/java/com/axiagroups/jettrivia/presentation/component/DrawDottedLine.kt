package com.axiagroups.jettrivia.presentation.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import com.axiagroups.jettrivia.presentation.ui.theme.mLightGray


/**
 * Created by Ahsan Habib on 5/23/2024.
 */
@Composable
fun DrawDottedLine(
    modifier: Modifier = Modifier,
    pathEffect:  PathEffect? = PathEffect.dashPathEffect(floatArrayOf(10f,10f), 0f)
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp),
    ) {

        drawLine(
            color = mLightGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect,
        )
    }
}