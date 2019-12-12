package adu.capstone.apwell.di

import adu.capstone.apwell.di.infrastructure.ViewModelModule
import adu.capstone.apwell.ui.bmi.BmiActivity
import adu.capstone.apwell.ui.bmi.BmiModule
import adu.capstone.apwell.ui.main.MainActivity
import adu.capstone.apwell.ui.main.MainModule
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

    @ContributesAndroidInjector(modules = [BmiModule::class])
    internal abstract fun bmiActivity() : BmiActivity

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainActivity() : MainActivity

}