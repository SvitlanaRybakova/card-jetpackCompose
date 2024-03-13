package com.example.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.card.ui.theme.CardTheme
import com.example.card.ui.theme.GrayCustom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                ListItem("Ulrika Andersson", "The artist")
               Box(
                 modifier = Modifier.fillMaxWidth(),
                   contentAlignment = Alignment.Center
               ){
                   CircleItem()
               }
                LazyRow( modifier = Modifier
                    .fillMaxWidth()
                    .background(color=GrayCustom)
                ){
                        itemsIndexed(
                            listOf(
                                ItemRowModel(R.drawable.image1, "Eric", ""),
                                ItemRowModel(R.drawable.image2, "Amanda", ""),
                                ItemRowModel(R.drawable.image3, "Peter", ""),
                                ItemRowModel(R.drawable.image4, "Andrea", ""),
                                ItemRowModel(R.drawable.image5, "Erika", ""),
                                ItemRowModel(R.drawable.image6, "Anastassia","")
                            )){
                                _, item ->
                                ItemRow(item = item)
                            }

                }

                LazyColumn( modifier = Modifier
                    .fillMaxWidth()
                    .background(color=GrayCustom)
                ){
                    itemsIndexed(
                        listOf(
                            ItemRowModel(R.drawable.image1, "Eric", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras suscipit tincidunt ipsum, vitae venenatis urna feugiat auctor. Mauris sit amet gravida nunc. Mauris lorem mi, vestibulum eget eros in, ornare suscipit dolor. Praesent pellentesque vestibulum nulla, ac lacinia mi accumsan finibus. "),
                            ItemRowModel(R.drawable.image2, "Amanda", "lorem ipsum"),
                            ItemRowModel(R.drawable.image3, "Peter", "lorem ipsum"),
                            ItemRowModel(R.drawable.image4, "Andrea", "lorem ipsum"),
                            ItemRowModel(R.drawable.image5, "Erika", "lorem ipsum"),
                            ItemRowModel(R.drawable.image6, "Anastassia","lorem ipsum")
                        )){
                            _, item ->
                        ItemColumn(item = item)
                    }

                }
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun ListItem(name: String, prof: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = name)
                    Text(text = prof)
                }

            }

        }
    }
}

@Composable
fun CircleItem(){
    var counter= remember{
        mutableStateOf(0)
    }
    var color= remember{
        mutableStateOf(Color.Blue)
    }
    Box(modifier = Modifier
        .size(30.dp)
        .background(color = color.value, shape = CircleShape)
        .clickable {
            counter.value++
            if (counter.value == 10) {
                color.value = Color.Red
            }
        },
        contentAlignment = Alignment.Center
    ){
        Text(
           style = TextStyle(color = Color.White, fontSize = 20.sp),
            text = counter.value.toString()
        )
    }
}

