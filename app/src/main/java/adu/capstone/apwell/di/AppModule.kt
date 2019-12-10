package adu.capstone.apwell.di

import adu.capstone.apwell.util.AppExecutors
import adu.capstone.apwell.util.DiskIOThreadExecutor
import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
abstract class AppModule {


    @Binds
    abstract fun bindContext(app:Application): Context

    @Module
    companion object{

        private const val THREAD_COUNT = 3

        @JvmStatic
        @Provides
        @Singleton
        fun provideAppExecutors():AppExecutors =
            AppExecutors(
                DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                AppExecutors.mainThreadExecutor()
            )

    }


}