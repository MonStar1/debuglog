package com.example

annotation class EntityData

class Test {

    @EntityData
    fun prime(n: Int): Long {
        val result = listOf(0L, 1L, 2L).asSequence().take(n).last()
        return result
    }
}


