package adu.capstone.apwell.data.source.local

import adu.capstone.apwell.data.models.User
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    companion object {
        const val TABLE_NAME = "tableUser"
        const val FIELD_USER_ID = "uId"
        const val FIELD_USER_NAME = "uName"
        const val FIELD_USER_GENDER = "uGender"
        const val FIELD_USER_BDATE = "uBdate"
        const val FIELD_USER_WEIGHT = "uWeight"
        const val FIELD_USER_HEIGHT = "uHeight"
        const val FIELD_USER_LIFESTYLE = "uLifeStyle"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    fun getUser(): User

    @Insert
    fun insertUser(user:User)

    @Update
    fun updateUser(user: User)

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteUser()
}