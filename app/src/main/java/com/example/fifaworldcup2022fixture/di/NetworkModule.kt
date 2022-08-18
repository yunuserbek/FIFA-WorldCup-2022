package com.example.fifaworldcup2022fixture.di

import com.example.fifaworldcup2022fixture.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    /*
    @Singleton
    @Provides
    fun retrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun apiFactory(retrofit: Retrofit) = retrofit.create(ApiServiceFixture::class.java)


     */

}

