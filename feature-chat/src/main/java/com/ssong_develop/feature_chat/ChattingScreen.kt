package com.ssong_develop.feature_chat

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ssong_develop.model.Chat
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChattingScreen(
    modifier: Modifier = Modifier,
    viewModel: ChattingViewModel = hiltViewModel()
) {
    // Ui Data
    val listState = rememberLazyListState()
    var chattingMessage by remember { mutableStateOf("") }
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()

    // Data
    val chatList by viewModel.chattingList.collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (chatList.isEmpty()) {
            Column(
                modifier = modifier.weight(9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("나와의 채팅을 시작해보세요.")
            }
        } else {
            LazyColumn(
                state = listState,
                content = {
                    items(chatList.size) { index ->
                        Card(
                            modifier = modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            shape = RoundedCornerShape(4.dp),
                            elevation = 6.dp
                        ) {
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                            ) {
                                Text(chatList[index].message)
                            }
                        }
                    }
                },
                modifier = modifier.weight(9f)
            )
        }

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
                        context.showToast("채팅이 비어있습니다.")
                    } else {
                        viewModel.saveChat(chattingMessage)
                        chattingMessage = ""
                        coroutineScope.launch {
                            listState.animateScrollToItem(chatList.size,0)
                        }
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

fun Context.showToast(message : String) =
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()