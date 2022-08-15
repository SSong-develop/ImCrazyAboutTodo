package com.ssong_develop.feature_mac_address

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class InputMacAddressViewModel @Inject constructor(
    @ApplicationContext context : Context
) : ViewModel() {
    // Ui Data여서 어떻게 처리를 할까요?
    var macAddressText = mutableStateOf("")
}