package adu.capstone.apwell.data.source.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppDbModule {

@Module
companion object{

    private const val APWELL_DB = "AWDB"

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppDb(context: Application) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDb::class.java,
            APWELL_DB
        ).fallbackToDestructiveMigration()
            .build()
}


}


