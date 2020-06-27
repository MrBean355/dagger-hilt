package com.github.mrbean355.android.daggerhilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface AppModule {

    @Binds
    fun bindSomeRepository(impl: SomeRepositoryImpl): SomeRepository

}
