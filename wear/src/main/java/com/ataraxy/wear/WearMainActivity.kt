package com.ataraxy.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ataraxy.wear.ui.navigation.WearNavHost
import com.ataraxy.wear.ui.theme.WearAtaraxyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WearMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearAtaraxyTheme {
                WearNavHost()
            }
        }
    }
}
