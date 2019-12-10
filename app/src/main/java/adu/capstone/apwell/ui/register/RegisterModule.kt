package adu.capstone.apwell.ui.register

import adu.capstone.apwell.di.infrastructure.ViewModelKey
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class RegisterModule{

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindViewModel(viewModel: RegisterViewModel): ViewModel

}