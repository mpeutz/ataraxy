package com.ataraxy.app.di

import com.ataraxy.app.data.export.DownloadsWriter
import com.ataraxy.app.data.export.MediaStoreDownloadsWriter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ExportModule {
    @Binds
    abstract fun bindDownloadsWriter(impl: MediaStoreDownloadsWriter): DownloadsWriter
}
