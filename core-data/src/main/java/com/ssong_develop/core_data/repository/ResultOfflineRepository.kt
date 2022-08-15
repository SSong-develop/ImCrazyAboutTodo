package com.ssong_develop.core_data.repository

import com.ssong_develop.core_data.model.asEntityModel
import com.ssong_develop.core_database.dao.ResultDao
import com.ssong_develop.core_database.entity.asExternalModel
import com.ssong_develop.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ResultOfflineRepository @Inject constructor(
    private val resultDao: ResultDao
) : ResultRepository {
    override fun getResultStream(id: String): Flow<Result> =
        resultDao.getResult(id).map { entity -> entity.asExternalModel() }

    override fun getResultsStream(): Flow<List<Result>> = resultDao.getResults().map { entities ->
        entities.map { entity -> entity.asExternalModel() }
    }

    override fun insertResult(result: Result) = resultDao.insertResult(result.asEntityModel())

    override fun deleteResult(result: Result) = resultDao.deleteResult(result.asEntityModel())

    override fun updateResult(result: Result) = resultDao.updateResult(result.asEntityModel())
}