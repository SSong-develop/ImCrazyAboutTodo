package com.ssong_develop.model

data class TodoPhoto(
    val id: String,
    val uriString: String,
    val photo: ByteArray,
    val photoDescription: String,
    val photoCreatedAt: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TodoPhoto

        if (id != other.id) return false
        if (uriString != other.uriString) return false
        if (!photo.contentEquals(other.photo)) return false
        if (photoDescription != other.photoDescription) return false
        if (photoCreatedAt != other.photoCreatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + photo.contentHashCode()
        result = 31 * result + uriString.hashCode()
        result = 31 * result + photoDescription.hashCode()
        result = 31 * result + photoCreatedAt.hashCode()
        return result
    }
}