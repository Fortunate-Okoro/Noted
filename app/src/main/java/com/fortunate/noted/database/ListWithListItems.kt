package com.fortunate.noted.database

import androidx.room.Embedded
import androidx.room.Relation

data class ListWithListItems (
    @Embedded val list: List,
    @Relation(
        parentColumn = "uid",
        entityColumn = "listId"
    )
    val ListItems: kotlin.collections.List<ListItem>
)
