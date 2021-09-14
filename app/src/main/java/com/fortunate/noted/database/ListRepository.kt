package com.fortunate.noted.database

import com.fortunate.noted.appDatabase

val ListsToCompare = mutableListOf<ListWithListItems>()

class ListRepository : IRepository<ListWithListItems> {

    override fun getAll(): kotlin.collections.List<ListWithListItems> {
        return appDatabase.listDao().getListsWithListItems()
    }
    override fun insert(value: ListWithListItems) {
        appDatabase.listDao().insertAll(value.list)
        appDatabase.listItemDao().insertAll(*value.ListItems.toTypedArray())
    }

    override fun remove(index: Int) {
        val list = getAll()[index].list
        val listItems = getAll()[index].ListItems
        listItems.forEach {
            appDatabase.listItemDao().delete(it)
        }
        return appDatabase.listDao().delete(list)
    }

    override fun query(query: String): kotlin.collections.List<ListWithListItems> {
        return appDatabase.listDao().searchLists("%".plus(query).plus("%"))
    }

}