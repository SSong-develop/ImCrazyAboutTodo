package com.ssong_develop.feature_result

import androidx.lifecycle.ViewModel
import com.ssong_develop.core_data.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val resultRepository: ResultRepository
) : ViewModel() {

    val results = resultRepository.getResultsStream()

}