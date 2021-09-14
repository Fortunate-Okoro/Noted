package com.fortunate.noted.ui.add

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunate.noted.database.ListItem
import com.fortunate.noted.database.ListItemRepository
import com.fortunate.noted.database.ListRepository
import com.fortunate.noted.database.ListWithListItems

class NewlistViewModel : ViewModel() {

    private val datapage: ListRepository = ListRepository()

    private val listItemsRepo : ListItemRepository = ListItemRepository()

    private val lastId = if (datapage.getAll().isNotEmpty()) datapage.getAll().last().list.uid else 0
    private val lastElementId = if (listItemsRepo.getAll().isNotEmpty()) listItemsRepo.getAll().last().uid else 0
    private var indexToList = 0

    private var _listItem = MutableLiveData<ListWithListItems>().apply {
        value = ListWithListItems(com.fortunate.noted.database.List(lastId + 1, "Example title"), mutableListOf())
    }
    var listItem: LiveData<ListWithListItems> = _listItem
    fun setTitle(title:String) {
        _listItem.postValue(ListWithListItems(com.fortunate.noted.database.List(_listItem.value!!.list.uid, title), _listItem.value!!.ListItems))
    }
    fun addItem(item:String){
        val currentVal = _listItem.value ?: return
        val elements = currentVal.ListItems
        _listItem.postValue(ListWithListItems(com.fortunate.noted.database.List(currentVal.list.uid, currentVal.list.title), elements.plus(
            ListItem(lastElementId + 1, currentVal.list.uid, item, indexToList))))
        Log.e("list uid", currentVal.list.uid.toString())
        Log.e("list element uid", (listItemsRepo.getAll().size + 1).toString())
    }
    fun commit() {
        datapage.insert(listItem.value!!)
    }
}