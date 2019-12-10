package adu.capstone.apwell.di

import adu.capstone.apwell.di.infrastructure.ViewModelModule
import adu.capstone.apwell.ui.register.RegisterActivity
import adu.capstone.apwell.ui.register.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        ViewModelModule::class
    ]
)
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    internal abstract fun registerActivity() : RegisterActivity

}