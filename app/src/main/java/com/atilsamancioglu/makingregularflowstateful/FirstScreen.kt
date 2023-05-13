package com.atilsamancioglu.makingregularflowstateful

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(time: Int, onButtonClicked : () -> Unit) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = time.toString(),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(2.dp).clickable(onClick = onButtonClicked),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant,
            textAlign = TextAlign.Center,
            )
    }

}