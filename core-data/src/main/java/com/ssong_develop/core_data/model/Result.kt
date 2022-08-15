package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.ResultEntity
import com.ssong_develop.model.Result

fun Result.asEntityModel() = ResultEntity(
    id = id,
    photo = photo,
    photoDescription = photoDescription,
    photoCreatedAt = photoCreatedAt
)