package com.ataraxy.app.ui.practices.sos

import com.ataraxy.app.domain.model.SosEmotion
import org.junit.Assert.assertEquals
import org.junit.Test

class SosEmotionOptionsTest {

    @Test
    fun everyFeeling_isOfferedExactlyOnce() {
        assertEquals(SosEmotion.entries.sorted(), sosEmotionOptions.map { it.emotion }.sorted())
    }
}
