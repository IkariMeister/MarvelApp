package com.ikarimeister.marvelapp.di

import com.ikarimeister.marvelapp.data.HeroFakeRepository
import com.ikarimeister.marvelapp.data.Repository
import com.ikarimeister.marvelapp.domain.model.Hero
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class HeroesListModule {
    @Provides
    fun providesHeoresRepository(repository: HeroFakeRepository): Repository<Hero, String> =
        repository

    @Provides
    fun providesBackgroundDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
