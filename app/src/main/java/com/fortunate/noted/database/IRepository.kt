package com.fortunate.noted.database

interface IRepository<T> {

    fun getAll() : kotlin.collections.List<T>

    fun insert(value: T)

    fun remove(index: Int)

    fun query(query: String) : kotlin.collections.List<T>
}