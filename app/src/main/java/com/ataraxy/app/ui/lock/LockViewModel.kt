package com.ataraxy.app.ui.lock

import androidx.lifecycle.ViewModel
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.DeviceAuthenticator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LockViewModel @Inject constructor(
    val appLock: AppLock,
    val authenticator: DeviceAuthenticator
) : ViewModel()
