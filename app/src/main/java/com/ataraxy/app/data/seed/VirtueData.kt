package com.ataraxy.app.data.seed

import com.ataraxy.app.data.local.entity.SubConceptEntity
import com.ataraxy.app.data.local.entity.VirtueEntity

object VirtueData {
    val virtues = listOf(
        VirtueEntity(
            id = "WISDOM",
            name = "Wisdom",
            latinName = "Phronesis",
            symbol = "owl",
            definingQuote = "You have power over your mind — not outside events. Realize this, and you will find strength.",
            definingQuoteAuthor = "Marcus Aurelius"
        ),
        VirtueEntity(
            id = "COURAGE",
            name = "Courage",
            latinName = "Andreia",
            symbol = "shield",
            definingQuote = "It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.",
            definingQuoteAuthor = "Seneca"
        ),
        VirtueEntity(
            id = "JUSTICE",
            name = "Justice",
            latinName = "Dikaiosyne",
            symbol = "scales",
            definingQuote = "We are made for cooperation, like feet, like hands, like eyelids, like the rows of the upper and lower teeth.",
            definingQuoteAuthor = "Marcus Aurelius"
        ),
        VirtueEntity(
            id = "MODERATION",
            name = "Moderation",
            latinName = "Sophrosyne",
            symbol = "hourglass",
            definingQuote = "If one does not know to which port one is sailing, no wind is favorable.",
            definingQuoteAuthor = "Seneca"
        )
    )

    val subConcepts = listOf(
        // WISDOM
        SubConceptEntity("sc_w1", "WISDOM", 1, "Clarity of Perception",
            "The Stoics held that wisdom begins with seeing things as they truly are, stripped of distortion. This means questioning your first impressions, asking whether your judgments are based on facts or on stories you tell yourself."),
        SubConceptEntity("sc_w2", "WISDOM", 2, "The Dichotomy of Control",
            "Central to Stoic thought: some things are within our power (our opinions, desires, actions) and some are not (our bodies, reputations, the weather). Wisdom is knowing the difference and focusing energy only on what you govern."),
        SubConceptEntity("sc_w3", "WISDOM", 3, "Premeditatio Malorum",
            "The deliberate contemplation of possible misfortune before it occurs. Not pessimism, but preparation — by imagining setbacks, you diminish their sting and appreciate what you still have."),
        SubConceptEntity("sc_w4", "WISDOM", 4, "The View from Above",
            "Zoom out from your personal troubles and see them in cosmic perspective. What seemed enormous shrinks to almost nothing against the backdrop of eternity. This practice restores equanimity."),
        SubConceptEntity("sc_w5", "WISDOM", 5, "Logos and Living According to Nature",
            "The Stoics believed the universe is governed by reason — Logos. To live wisely is to live in accord with this rational order, accepting what cannot be changed and acting rightly within what can."),

        // COURAGE
        SubConceptEntity("sc_c1", "COURAGE", 1, "Voluntary Hardship",
            "Periodically choosing discomfort — cold, hunger, simple living — fortifies the spirit and reveals how little you truly need. What was once feared becomes merely inconvenient."),
        SubConceptEntity("sc_c2", "COURAGE", 2, "Confronting Fear Directly",
            "Rather than avoiding what frightens you, Stoic courage asks you to examine it. Name the fear. Ask: what is the worst that can actually happen? The monster shrinks when you look at it."),
        SubConceptEntity("sc_c3", "COURAGE", 3, "Death as Advisor",
            "The Stoic practice of memento mori — remembering you will die — is not morbid but liberating. Kept close, it strips away trivial concerns and sharpens focus on what is genuinely worth doing."),
        SubConceptEntity("sc_c4", "COURAGE", 4, "Acting Despite Uncertainty",
            "Courage is not the absence of fear but the judgment that action is required in spite of it. The Stoics honoured those who move forward even without guarantees of outcome."),
        SubConceptEntity("sc_c5", "COURAGE", 5, "Endurance Under Pressure",
            "Lasting hardship with composure — neither collapsing nor hardening into bitterness — is a Stoic ideal. What cannot be changed must be borne; bearing it with grace is a form of victory."),

        // JUSTICE
        SubConceptEntity("sc_j1", "JUSTICE", 1, "The Social Animal",
            "Humans are rational and social by nature. We flourish only in community. Justice calls us to recognise that our good is inextricably bound to the good of others."),
        SubConceptEntity("sc_j2", "JUSTICE", 2, "Cosmopolitanism",
            "The Stoics believed in one human family — citizens not of a single city but of the cosmos. This universal fellowship is the foundation of Stoic justice: every person deserves equal moral consideration."),
        SubConceptEntity("sc_j3", "JUSTICE", 3, "Giving Each Their Due",
            "Justice means treating people according to what they deserve — not what flatters you, nor what you fear. It requires overcoming favoritism, prejudice, and self-interest."),
        SubConceptEntity("sc_j4", "JUSTICE", 4, "Truthfulness in All Things",
            "For the Stoics, honesty is a form of justice. To deceive another is to deny them the truth they are owed. Keep your word, speak clearly, act transparently."),

        // MODERATION
        SubConceptEntity("sc_m1", "MODERATION", 1, "Temperance in Appetite",
            "Moderation begins with the body. Food, drink, comfort, pleasure — taken in excess, these become masters. The Stoic practices restraint not to punish the body but to remain its ruler."),
        SubConceptEntity("sc_m2", "MODERATION", 2, "Simplicity of Life",
            "A life cluttered with possessions and obligations is a life that cannot be examined. Voluntary simplicity creates space for reflection, strengthens independence, and clarifies what genuinely matters."),
        SubConceptEntity("sc_m3", "MODERATION", 3, "Equanimity",
            "The still point in the turning world. Not numbness, but an inner steadiness that is neither elevated by good fortune nor crushed by bad. Equanimity is moderation applied to emotion."),
        SubConceptEntity("sc_m4", "MODERATION", 4, "Contentment",
            "Wanting what you already have is a radical discipline in an age of endless desire. The Stoics taught that abundance is not having more, but needing less."),
        SubConceptEntity("sc_m5", "MODERATION", 5, "Measured Speech",
            "Speak less than you know; act more than you speak. The Stoics prized the economy of words — to say exactly what is needed, no more, no less, with care for truth and for the listener.")
    )
}
