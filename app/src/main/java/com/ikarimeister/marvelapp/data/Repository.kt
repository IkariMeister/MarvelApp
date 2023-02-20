package com.ikarimeister.marvelapp.data

interface Repository<DATA,KEY> {
    operator fun get(key:KEY) : DATA?
    operator fun plus(item:DATA)
    operator fun minus(item:DATA)
    suspend fun getAll() : List<DATA>
}