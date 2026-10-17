package com.ataraxy.app.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider

fun inMemoryDatabase(): AtaraxyDatabase =
    Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        AtaraxyDatabase::class.java
    ).allowMainThreadQueries().build()
