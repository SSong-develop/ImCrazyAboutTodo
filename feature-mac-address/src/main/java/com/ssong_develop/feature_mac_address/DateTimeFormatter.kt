package com.ssong_develop.feature_mac_address

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")