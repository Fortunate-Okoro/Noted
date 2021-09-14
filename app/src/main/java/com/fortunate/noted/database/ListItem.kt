package com.fortunate.noted.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListItem (
    @PrimaryKey val uid: Int,
    val listId: Int,
    val value: String,
    val order_number: Int?
)