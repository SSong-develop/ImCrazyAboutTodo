package com.ssong_develop.feature_mac_address

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class InputMacAddressViewModel @Inject constructor(
    @ApplicationContext context : Context
) : ViewModel() {

}