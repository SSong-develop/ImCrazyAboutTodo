package com.ssong_develop.feature_chat

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")