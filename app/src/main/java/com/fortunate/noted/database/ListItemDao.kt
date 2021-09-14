package com.fortunate.noted.database

import androidx.room.*
import kotlin.collections.List

@Dao
interface ListItemDao {
    @Query("SELECT * FROM listitem")
    fun getAll(): List<ListItem>

    @Insert
    fun insertAll(vararg listitems: ListItem)

    @Transaction
    @Query("SELECT * FROM listitem WHERE value LIKE :query")
    fun searchListItems(query: String) : List<ListItem>

    @Delete
    fun delete(listitem: ListItem)
}