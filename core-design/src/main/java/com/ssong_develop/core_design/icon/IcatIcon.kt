package com.ssong_develop.core_design.icon

import androidx.annotation.DrawableRes
import com.ssong_develop.core_design.R

// fixme ssong-develop 어떻게 쓸지는 조금 생각을 해보자
object IcatIcon {
    val todo = R.drawable.ic_todo
    val todoOutLined = R.drawable.ic_todo_outline
    val profile = R.drawable.ic_profile
    val profileOutLined = R.drawable.ic_profile_outline
    val result = R.drawable.ic_result
    val resultOutLined = R.drawable.ic_result_outline
}

sealed class Icon {
    data class DrawableResourceIcon(@DrawableRes val id : Int): Icon()
}