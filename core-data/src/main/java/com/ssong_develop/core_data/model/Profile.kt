package com.ssong_develop.core_data.model

import com.ssong_develop.core_database.entity.ProfileEntity
import com.ssong_develop.model.Profile

fun Profile.asEntityModel() = ProfileEntity(
    id = id,
    name = name,
    description = description,
    createAt = createAt
)