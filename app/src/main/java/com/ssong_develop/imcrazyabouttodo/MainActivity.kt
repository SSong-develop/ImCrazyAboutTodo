package com.ssong_develop.imcrazyabouttodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ssong_develop.imcrazyabouttodo.ui.IcatApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 등록된 mac주소가 있다면 IcatApp 아니라면 mac주소 입력 뷰로 이동
            IcatApp()
        }
    }
}