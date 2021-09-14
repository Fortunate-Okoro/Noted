package com.fortunate.noted.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGATION_2_3 = object  : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE `ListItem` ADD COLUMN order_number INTEGER")
    }
}