package com.github.mrbean355.android.daggerhilt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<DemoApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: DemoApp): AppComponent
    }
}

@Module
interface AppModule {

    @Binds
    fun bindViewModelFactory(impl: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindSomeRepository(impl: SomeRepositoryImpl): SomeRepository

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(impl: MainViewModel): ViewModel

}
