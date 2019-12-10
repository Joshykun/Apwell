package adu.capstone.apwell.data.source.repository

import adu.capstone.apwell.data.source.Local
import adu.capstone.apwell.data.source.UserDataSource
import adu.capstone.apwell.data.source.local.AppDb
import adu.capstone.apwell.data.source.local.UserLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

    @Binds
    @Local
    @Singleton
    abstract fun bindsLocalDataSource(dataSource: UserLocalDataSource): UserDataSource


    @Module
    companion object{
        @JvmStatic
        @Provides
        fun provideUserDao(db: AppDb) = db.UserDao()
    }



}