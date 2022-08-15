package com.ssong_develop.feature_mac_address

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InputMacAddressScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    inputMacAddressViewModel: InputMacAddressViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf("") }
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.LightGray)) {
            append("와이파이 Mac 주소를 모른다면, 현재 연결되어 있는 와이파이 설정에서 고급 설정을 확인합니다.\n")
        }
        withStyle(style = SpanStyle(Color.Blue)) {
            append("그래도 모른다면 현재 연결되어 있는 와이파이의 MAC주소로 기본 입력됩니다.")
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = modifier,
                content = {
                    Text("Test AppBar")
                }
            )
        },
        content = { padding ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = modifier
                        .padding(padding)
                        .padding(top = 24.dp),
                    value = text,
                    onValueChange = { inputValue ->
                        text = inputValue
                    },
                    label = { Text("Wifi Mac Address") }
                )

                Text(
                    modifier = modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp),
                    text = annotatedString,
                    lineHeight = 20.sp,
                    fontSize = 10.sp,
                    fontStyle = FontStyle.Normal
                )
                Spacer(modifier = modifier.weight(1f))

                Button(
                    onClick = {
                        onClick()
                    },
                    modifier = modifier.fillMaxWidth(),
                    enabled = true,
                    shape = MaterialTheme.shapes.large,
                    content = {
                        Text("test Button")
                    }
                )
            }
        }
    )
}