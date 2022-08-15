package com.ssong_develop.core_database.dao

import androidx.room.*
import com.ssong_develop.core_database.entity.ResultEntity

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(resultEntity: ResultEntity)

    @Query("SELECT * FROM result where id = :resultId")
    fun getResult(resultId: String)

    // FIXME ssong-develop 에러가 날 수 있어요요
    @Delete
    fun deleteResult()
}