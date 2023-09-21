package com.example.di.modules

import com.example.data.remote.datasource.DetailSearchDataSource
import com.example.data.remote.datasource.DetailSearchDataSourceImpl
import com.example.data.remote.datasource.SearchDataSource
import com.example.data.remote.datasource.SearchDataSourceImpl
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
}