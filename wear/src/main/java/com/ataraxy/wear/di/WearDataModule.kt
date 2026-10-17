package com.ataraxy.wear.di

import android.content.Context
import com.ataraxy.wear.data.WearQuoteStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WearDataModule {

    @Provides
    @Singleton
    fun provideWearQuoteStore(@ApplicationContext context: Context): WearQuoteStore =
        WearQuoteStore(context)
}
