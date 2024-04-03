package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                ProvideTextStyle(customTextStyle) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFF3DDC84).copy(alpha = 0.9f)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Section1("Name", "Junior Android Developer")
                            Section2("Phone No.", "@yimingliew", "Email")
                        }
                    }
                }
            }
        }
    }
}

val customTextStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontSize = 17.sp
)


@Composable
fun Section1(name: String, title: String) {
    val profilePic = painterResource(R.drawable.profile_pic)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = profilePic,
            contentDescription = null,
            modifier = Modifier.padding(
                    bottom = 10.dp
                    )
        )
        Text(
            text = name,
            style = TextStyle(
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = title
        )
    }
}

@Composable
fun Section2(phone: String, ig: String, email: String){
    val phoneIcon = painterResource(R.drawable.telephone)
    val instagramIcon = painterResource(R.drawable.instagram)
    val gmIcon = painterResource(R.drawable.gmail)

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(
                start = 22.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                painter = phoneIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
                )
            Text(
                text = "  $phone"
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                painter = instagramIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
            )
            Text(
                text = "  $ig"
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image(
                painter = gmIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
            )
            Text(
                text = "  $email"
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        ProvideTextStyle(customTextStyle) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF3DDC84).copy(alpha = 0.9f)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Section1("Name", "Junior Android Developer")
                    Section2("Phone No.", "@yimingliew", "Email")
                }
            }
        }
    }
}