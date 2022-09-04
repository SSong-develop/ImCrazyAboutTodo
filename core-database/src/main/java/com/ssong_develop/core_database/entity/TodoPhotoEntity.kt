package com.ssong_develop.core_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ssong_develop.model.TodoPhoto

// fixme ssong-develop 엔티티 요소들은 다시 생각
@Entity(tableName = "todo_photo")
data class TodoPhotoEntity(
    @PrimaryKey
    val id: String,
    val uriString: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val photo: ByteArray,
    val photoDescription: String,
    val photoCreatedAt: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TodoPhotoEntity

        if (id != other.id) return false
        if (uriString != other.uriString) return false
        if (!photo.contentEquals(other.photo)) return false
        if (photoDescription != other.photoDescription) return false
        if (photoCreatedAt != other.photoCreatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + uriString.hashCode()
        result = 31 * result + photo.contentHashCode()
        result = 31 * result + photoDescription.hashCode()
        result = 31 * result + photoCreatedAt.hashCode()
        return result
    }
}

fun TodoPhotoEntity.asExternalModel() = TodoPhoto(
    id = id,
    uriString = uriString,
    photo = photo,
    photoDescription = photoDescription,
    photoCreatedAt = photoCreatedAt
)