package com.chenguangliu.android.mvpsimplegallery.main

import java.util.*
import javax.inject.Inject

enum class Direction {
    START,
    END
}

/**
 * Fixed size cache using [ArrayDeque]
 */
class FixedSizeCache<T> @Inject constructor(private val cacheSize: Int) {

    private val dataCache: Deque<T> by lazy { ArrayDeque<T>() }

    fun put(direction: Direction, data: T) {
        when (direction) {
            Direction.START -> {
                while (dataCache.isNotEmpty() && dataCache.size >= cacheSize) {
                    dataCache.pollLast()
                }
                dataCache.offerFirst(data)
            }
            Direction.END -> {
                while (dataCache.isNotEmpty() && dataCache.size >= cacheSize) {
                    dataCache.pollFirst()
                }
                dataCache.offerLast(data)
            }
        }
    }

    fun get(direction: Direction): T? {
        if (dataCache.isEmpty()) {
            return null
        }
        return when (direction) {
            Direction.START -> dataCache.pollFirst()
            Direction.END -> dataCache.pollLast()
        }
    }
}
