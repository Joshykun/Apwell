package adu.capstone.apwell.data.source.local

import adu.capstone.apwell.data.models.User
import adu.capstone.apwell.data.source.LocalCallback
import adu.capstone.apwell.data.source.UserDataSource
import adu.capstone.apwell.util.AppExecutors
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao
):UserDataSource {

    override fun getUser(callback: LocalCallback<User>) {
        appExecutors.diskIO().execute{
            val user = userDao.getUser()

            appExecutors.mainThread().execute{
                if(user != null){
                    callback.done(user)
                }
            }
        }
    }

    override fun saveUser(user: User) {
        appExecutors.diskIO().execute{
            userDao.deleteUser()
            userDao.insertUser(user)
        }
    }
}




