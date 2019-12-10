package adu.capstone.apwell.data.source.repository

import adu.capstone.apwell.data.source.Local
import adu.capstone.apwell.data.models.User
import adu.capstone.apwell.data.source.LocalCallback
import adu.capstone.apwell.data.source.UserDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    @Local private val localDataSource: UserDataSource
):UserDataSource {

    override fun getUser(callback: LocalCallback<User>) {
        localDataSource.getUser(callback)
    }

    override fun saveUser(user: User) {
        localDataSource.saveUser(user)
    }
}