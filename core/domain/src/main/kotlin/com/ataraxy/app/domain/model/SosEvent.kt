package com.ataraxy.app.domain.model

import java.time.LocalDateTime

enum class SosEmotion {
    OVERWHELMED,
    PROCRASTINATING,
    STUCK,
    HELPLESS,
    INSECURE,
    ASHAMED,
    GUILTY,
    LONELY,
    REJECTED,
    DISCOURAGED,
    RESENTFUL,
    TREATED_UNFAIRLY,
    BURNED_OUT,
    NUMB,
    RESTLESS,
    CONFUSED,
    REGRETFUL,
    JEALOUS_ENVIOUS,
    UNMOTIVATED,
    HOPELESS
}

data class SosEvent(
    val id: Long = 0L,
    val emotion: SosEmotion,
    val quoteId: String,
    val triggeredAt: LocalDateTime
)
