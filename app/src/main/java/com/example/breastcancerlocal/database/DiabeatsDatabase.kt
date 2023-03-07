package com.example.breastcancerlocal.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(DiabeatsEntity::class)], version = 1, exportSchema = false)
abstract class DiabeatsDatabase : RoomDatabase() {
    abstract fun diabeatsDao(): DiabeatsEntityDAO
}
