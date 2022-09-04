package com.ssong_develop.feature_todophotoalbum

import android.net.Uri
import android.util.LruCache
import androidx.compose.ui.graphics.ImageBitmap

object ImageCacheManager {

    private val cache = LruCache<String, ImageBitmap>(10)

    fun saveCache(uriString: String, imageBitmap: ImageBitmap) {
        cache.put(uriString, imageBitmap)
    }

    fun getImage(uriString: String): ImageBitmap? {
        return cache.get(uriString)
    }
}