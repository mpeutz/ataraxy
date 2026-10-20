package com.ataraxy.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.ataraxy.app.widget.WidgetPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.widgetPrefsDataStore: DataStore<Preferences> by preferencesDataStore(name = "widget_prefs")

@Module
@InstallIn(SingletonComponent::class)
object WidgetModule {

    @Provides
    @Singleton
    @WidgetPrefs
    fun provideWidgetPrefsDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.widgetPrefsDataStore
}
