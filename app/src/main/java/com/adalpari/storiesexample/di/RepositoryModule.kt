package com.adalpari.storiesexample.di

import com.adalpari.storiesexample.datasource.DataSource
import com.adalpari.storiesexample.repository.Repository
import com.adalpari.storiesexample.repository.StoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideRepository(dataSource: DataSource): Repository {
        return StoriesRepository(dataSource)
    }
}