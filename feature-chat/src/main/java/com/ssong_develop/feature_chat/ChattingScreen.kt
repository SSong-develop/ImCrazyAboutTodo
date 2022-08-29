package com.ssong_develop.feature_chat

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ssong_develop.model.Chat

// FIXME SSONG-DEVELOP
// 가장 최신의 채팅이 보이도록 scrollState를 최 하단으로 내리는 기능 만들어야 함
@Composable
fun ChattingScreen(
    modifier: Modifier = Modifier,
    viewModel: ChattingViewModel = hiltViewModel()
) {
    val chatList = viewModel.fakeChatList

    var chattingMessage by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            content = {
                items(chatList.size) { index ->
                    Card(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 6.dp
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                        ) {
                            Text(chatList[index].message)
                        }
                    }
                }
            },
            modifier = modifier.weight(9f)
        )

        Row(
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            TextField(
                value = chattingMessage,
                onValueChange = {
                    chattingMessage = it
                },
                modifier = modifier
                    .padding(end = 4.dp)
                    .weight(8f)
                    .height(48.dp)
            )
            Button(
                onClick = {
                    if (chattingMessage.isEmpty()) {
                        Log.d("ssong-develop","비어 있습니다.")
                    } else {
                        viewModel.fakeChatList.add(Chat("6",chattingMessage,"fdjsklafd"))
                        chattingMessage = ""
                    }
                },
                content = {
                    Text(
                        text = "확인",
                        modifier = modifier,
                        fontSize = 12.sp
                    )
                },
                modifier = modifier
                    .padding(start = 4.dp)
                    .weight(2f)
                    .height(48.dp)
            )
        }
    }
}