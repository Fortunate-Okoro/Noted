package com.fortunate.noted.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [List::class, ListItem::class], version = 3)
abstract class AppDatabase: RoomDatabase() {
    abstract fun listDao(): ListDao
    abstract fun listItemDao(): ListItemDao
}