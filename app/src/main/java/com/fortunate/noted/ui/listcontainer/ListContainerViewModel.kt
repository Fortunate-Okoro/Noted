package com.fortunate.noted.ui.listcontainer

import androidx.lifecycle.ViewModel
import com.fortunate.noted.database.ListRepository

class ListContainerViewModels : ViewModel() {
    val dataMap = ListRepository()
}