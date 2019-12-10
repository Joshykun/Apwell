package adu.capstone.apwell.di

import adu.capstone.apwell.App
import adu.capstone.apwell.data.AppLevelDataModule
import adu.capstone.apwell.data.source.local.AppDbModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
AndroidSupportInjectionModule::class,
ActivityBindingModule::class,
    AppLevelDataModule::class,
AppModule::class,
AppDbModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(app:Application):Builder

        fun build(): AppComponent
    }
}