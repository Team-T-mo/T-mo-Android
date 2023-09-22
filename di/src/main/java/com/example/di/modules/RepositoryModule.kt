package com.example.di.modules

import com.example.data.repository.DetailSearchRepositoryImpl
import com.example.data.repository.SearchRepositoryImpl
import com.example.data.repository.TranslationRepositoryImpl
import com.example.domain.repository.DetailSearchRepository
import com.example.domain.repository.SearchRepository
import com.example.domain.repository.TranslationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    abstract fun bindDetailSearchRepository(
        detailSearchRepositoryImpl: DetailSearchRepositoryImpl
    ): DetailSearchRepository

    @Binds
    abstract fun bindTranslationRepository(
        translationRepositoryImpl: TranslationRepositoryImpl
    ): TranslationRepository
}