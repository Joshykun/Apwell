package adu.capstone.apwell.data.source.local

import adu.capstone.apwell.data.models.User


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [
        (User::class)
],
    version = 1,
    exportSchema = false
)
abstract class AppDb: RoomDatabase() {

    abstract fun UserDao(): UserDao

}