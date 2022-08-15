package com.ssong_develop.core_data.repository

import com.ssong_develop.model.Result
import kotlinx.coroutines.flow.Flow

interface ResultRepository {

    fun getResultStream(id: String): Flow<Result>

    fun getResultsStream(): Flow<List<Result>>

    fun insertResult(result: Result)

    fun deleteResult(result: Result)

    fun updateResult(result: Result)
}