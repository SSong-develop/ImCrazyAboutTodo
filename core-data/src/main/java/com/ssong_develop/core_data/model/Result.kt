package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.TodoPhotoEntity
import com.ssong_develop.model.TodoPhoto

fun TodoPhoto.asEntityModel() = TodoPhotoEntity(
    id = id,
    photo = photo,
    photoDescription = photoDescription,
    photoCreatedAt = photoCreatedAt
)