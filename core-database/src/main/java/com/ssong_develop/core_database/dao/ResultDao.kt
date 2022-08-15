package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(resultEntity: ResultEntity)

    @Query("SELECT * FROM result where id = :resultId")
    fun getResult(resultId: String): Flow<ResultEntity>

    @Query("SELECT * FROM result")
    fun getResults(): Flow<List<ResultEntity>>

    @Delete
    fun deleteResult(resultEntity: ResultEntity)

    @Update
    fun updateResult(resultEntity: ResultEntity)
}