package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.CatInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class CatDetailActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyDetail()
            }
        }
    }
    @Composable
    fun MyDetail() {
        var cat: CatInfo= intent.getSerializableExtra("cat") as CatInfo
        Surface(color = MaterialTheme.colors.background,modifier = Modifier.fillMaxSize()) {
            Column {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),contentAlignment = Alignment.BottomCenter) {
                    Image(painter = painterResource(id = cat.imageId ) , contentDescription = cat.name ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp),contentScale = ContentScale.Crop)
                    
                    Text(text = "",modifier = Modifier
                        .background(color = colorResource(id = R.color.half_transparent))
                        .fillMaxWidth()
                        .padding(8.dp))
                    Text(text = cat.name,modifier = Modifier.padding(8.dp),color = Color.White)
                }
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = "hello, I am ${cat.name},\n and i am ${cat.age} month old ,\n here is my description: \n i am cute \n" +
                            "hello, I am ${cat.name},\n" +
                            " and i am ${cat.age} month old ,\n" +
                            " here is my description: \n" +
                            " i am cute \n" +
                            "hello, I am ${cat.name},\n" +
                            " and i am ${cat.age} month old ,\n" +
                            " here is my description: \n" +
                            " i am cute \n" +
                            "hello, I am ${cat.name},\n" +
                            " and i am ${cat.age} month old ,\n" +
                            " here is my description: \n" +
                            " i am cute \n",
                        fontSize = 22.sp,color = Color.Black,modifier = Modifier.fillMaxWidth())
                }


            }
            
        }
    }
}