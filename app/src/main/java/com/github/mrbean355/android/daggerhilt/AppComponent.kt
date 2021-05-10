package com.github.mrbean355.android.daggerhilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindSomeRepository(impl: SomeRepositoryImpl): SomeRepository

}
