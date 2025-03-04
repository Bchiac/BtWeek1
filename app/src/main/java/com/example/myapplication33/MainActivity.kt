package com.example.myapplication33

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import com.example.myapplication33.ui.theme.MyApplication33Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication33Theme {
                Scaffold(
                    topBar = { TopBar() }, // Hiển thị thanh công cụ trên cùng
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        // Ảnh đại diện bo tròn
        Image(
            painter = painterResource(id = R.drawable.profile_placeholder),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Tên người dùng
        Text(
            text = "John Wick",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121)
        )

        // Địa điểm
        Text(
            text = "California, USA",
            fontSize = 16.sp,
            color = Color(0xFF424242)
        )
    }
}

@Composable
fun TopBar() {
    val context = LocalContext.current
    val activity = (context as? ComponentActivity)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Nút quay lại
        IconButton(
            onClick = { activity?.finish() }, // Thoát Activity
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color.Gray, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Quay lại",
                tint = Color.Gray
            )
        }

        // Nút chỉnh sửa
        IconButton(
            onClick = {
                Toast.makeText(context, "Chỉnh sửa chưa được triển khai!", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color(0xFF00AEEF), CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Chỉnh sửa",
                tint = Color(0xFF00AEEF)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication33Theme {
        Greeting()
    }
}
