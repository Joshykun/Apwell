package adu.capstone.apwell.data.source

import adu.capstone.apwell.data.models.User

interface UserDataSource {

    fun getUser(callback:LocalCallback<User>)

    fun saveUser(user: User)

}