package com.example.myapplication

import android.os.Bundle
import androidx.compose.ui.res.painterResource
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background
                ) { paddingValues ->
                    Text("Test Compose Rendering")
                    greetingImage(
                        msg = stringResource(R.string.bday),
                        from = "from me",
                        modifier = Modifier
                            .padding(paddingValues)
                            .padding(8.dp)
                    )
                }

            }
        }
    }
}
@Composable
fun greetingtext(msg: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(2.dp), verticalArrangement = Arrangement.Center) {
        Text(
            text = msg,
            fontSize = 30.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,


        )
        Text(
            text = from,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun greetingImage(msg:String ,from :String , modifier: Modifier=Modifier){
    val img = painterResource(id = R.drawable.bdd)
    Box {
        Image(
            painter = img,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(1f),
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        greetingtext(
            msg = msg,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        )
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        greetingImage(msg = stringResource(R.string.bday), from="from me")
    }
}