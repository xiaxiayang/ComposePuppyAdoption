/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.CatInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }

    // Start building your app here!
    @Composable
    fun MyApp() {
        var cats = listOf(
            CatInfo(R.mipmap.ic_cat_1,"cata","6","male","a in suzhou"),
            CatInfo(R.mipmap.ic_cat_2,"catb","5","female","b in suzhou"),
            CatInfo(R.mipmap.ic_cat_3,"catc","12","male","c in suzhou"),
            CatInfo(R.mipmap.ic_cat_4,"catd","6","female","d in suzhou"),
            CatInfo(R.mipmap.ic_cat_5,"cate","20","female","e in suzhou"),
            CatInfo(R.mipmap.ic_cat_6,"catf","4","male","f in suzhou"),
            CatInfo(R.mipmap.ic_cat_7,"catg","60","female","g in suzhou"),
            CatInfo(R.mipmap.ic_cat_1,"cata","6","male","a in suzhou"),
            CatInfo(R.mipmap.ic_cat_2,"catb","5","female","b in suzhou"),
            CatInfo(R.mipmap.ic_cat_3,"catc","12","male","c in suzhou"),
            CatInfo(R.mipmap.ic_cat_4,"catd","6","female","d in suzhou"),
            CatInfo(R.mipmap.ic_cat_5,"cate","20","female","e in suzhou"),
            CatInfo(R.mipmap.ic_cat_6,"catf","4","male","f in suzhou"),
            CatInfo(R.mipmap.ic_cat_7,"catg","60","female","g in suzhou"),
        )
        Surface(color = MaterialTheme.colors.background,modifier = Modifier.fillMaxSize()) {

            LazyColumn ( modifier = Modifier.background(color = colorResource(id = R.color.divider_color) ),verticalArrangement = Arrangement.spacedBy(10.dp)){
                items(cats) { cat ->
                    myItem(cat)
                }
            }
        }
    }

    @Composable
    fun myItem(cat: CatInfo){
        var modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .clickable {
                var intent = Intent(this@MainActivity,CatDetailActivity::class.java)
                intent.putExtra("cat",cat)
                startActivity(intent)
            }
        Row(modifier) {
            Image(painter = painterResource(id = cat.imageId), contentDescription ="name:${cat.name}",
                modifier = Modifier.size(120.dp,100.dp),contentScale = ContentScale.Crop)
            Column(Modifier.padding(15.dp,0.dp,0.dp,0.dp)) {
                Text(text = "name: ${cat.name}",color = Color.Black,fontSize = 18.sp)
                Text(text = "age: ${cat.age} month",color = Color.Gray,fontSize = 16.sp)
                Text(text = "sex: ${cat.sex}",color = Color.Gray,fontSize = 16.sp)
                Text(text = "address: ${cat.address}",color = Color.Gray,fontSize = 16.sp)
            }
        }

    }
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        MyTheme {
            MyApp()
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkPreview() {
        MyTheme(darkTheme = true) {
            MyApp()
        }
    }
}


