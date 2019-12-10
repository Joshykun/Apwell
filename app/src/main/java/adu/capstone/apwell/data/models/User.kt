package adu.capstone.apwell.data.models

import adu.capstone.apwell.data.source.local.UserDao
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserDao.TABLE_NAME)
data class User (

    @ColumnInfo(name = UserDao.FIELD_USER_ID)
    @PrimaryKey
    val userId : Int = 0,

    @ColumnInfo(name = UserDao.FIELD_USER_NAME)
    val userName: String = "",

    @ColumnInfo(name = UserDao.FIELD_USER_GENDER)
    val userGender:String = "",

    @ColumnInfo(name = UserDao.FIELD_USER_BDATE)
    val userBdate:String = "",

    @ColumnInfo(name = UserDao.FIELD_USER_WEIGHT)
    val userWeight:Int = 0,

    @ColumnInfo(name = UserDao.FIELD_USER_HEIGHT)
    val userHeight:Int = 0,

    @ColumnInfo(name = UserDao.FIELD_USER_LIFESTYLE)
    val userLifeStyle:String = ""
)