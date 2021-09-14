package com.fortunate.noted.database

import com.fortunate.noted.appDatabase
import kotlin.collections.List

class ListItemRepository : IRepository<ListItem> {
    override fun getAll(): List<ListItem> {
        return appDatabase.listItemDao().getAll()
    }

    override fun insert(value: ListItem) {
        return appDatabase.listItemDao().insertAll(value)
    }

    override fun remove(index: Int) {
        return appDatabase.listItemDao().delete(getAll()[index])
    }

    override fun query(query: String): List<ListItem> {
        return appDatabase.listItemDao().searchListItems(query)
    }

}