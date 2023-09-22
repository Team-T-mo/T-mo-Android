package com.example.di.modules

import com.example.data.remote.datasource.detail_search.DetailSearchDataSource
import com.example.data.remote.datasource.detail_search.DetailSearchDataSourceImpl
import com.example.data.remote.datasource.search.SearchDataSource
import com.example.data.remote.datasource.search.SearchDataSourceImpl
import com.example.data.remote.datasource.translation.TranslationDataSource
import com.example.data.remote.datasource.translation.TranslationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDatasourceModule {

    @Binds
    abstract fun bindSearchDataSource(
        searchDataSourceImpl: SearchDataSourceImpl
    ): SearchDataSource

    @Binds
    abstract fun bindDetailDataSource(
        detailSearchDataSourceImpl: DetailSearchDataSourceImpl
    ): DetailSearchDataSource

    @Binds
    abstract fun bindTranslationDataSource(
        translationDataSourceImpl: TranslationDataSourceImpl
    ): TranslationDataSource
}