package com.example.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

@Composable
fun ItemColumn (item: ItemRowModel){
    var isExpanded by remember{
        mutableStateOf(false)
    }
    Row (

        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(Color.White)

    ){

        Image(
            painter = painterResource(id = item.imageId), 
            contentDescription= item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)){
            Text(text = item.title, style= TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic))
            Text(
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                },
                maxLines = if(isExpanded) Int.MAX_VALUE else 2,
                text = item.content)
        }

    }
}

