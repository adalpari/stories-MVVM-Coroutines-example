package com.adalpari.storiesexample.di

import com.adalpari.storiesexample.network.datasource.DataSource
import com.adalpari.storiesexample.network.datasource.UnsplashDataSource
import com.adalpari.storiesexample.network.service.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.unsplash.com/"
private const val ACCESS_KEY = "vhmaLV-VmybbLBvo5BuOQPWv6BN4bDrwlZPSyxQUlzY"

@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                return chain.proceed(
                    chain.request().newBuilder().apply {
                        addHeader("Authorization", "Client-ID $ACCESS_KEY")
                    }.build()
                )
            }
        }).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUnsplashService(retrofit: Retrofit): UnsplashService = retrofit.create(
        UnsplashService::class.java
    )

    @Provides
    @Singleton
    fun provideDataSource(unsplashService: UnsplashService): DataSource = UnsplashDataSource(
        unsplashService
    )

}