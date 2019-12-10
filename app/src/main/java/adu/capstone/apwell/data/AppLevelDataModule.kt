package adu.capstone.apwell.data

import adu.capstone.apwell.data.source.repository.UserRepositoryModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module(
    includes = [
    UserRepositoryModule::class]
)

class AppLevelDataModule{

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}