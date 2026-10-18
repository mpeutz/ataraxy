package com.ataraxy.app.data.seed

import com.ataraxy.app.domain.model.InsightBullet
import com.ataraxy.app.domain.model.InsightSection
import com.ataraxy.app.domain.model.InsightTable
import com.ataraxy.app.domain.model.QuoteInsight

object InsightData {
    val insights: Map<String, QuoteInsight> = SosInsightData.insights + mapOf(

        // q001 — Marcus Aurelius
        "q001" to QuoteInsight(
            intro = "Marcus wrote this as one of two thoughts he wanted always within reach, a pocket tool for the moments he retreated into himself. The first thought is this one: events stay outside you, and the stir you feel comes from the view you take of them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Events Stay Outside",
                    blockquote = "Things do not touch the soul, for they are external and remain immovable",
                    body = "Marcus pictures events as things that stay where they are. A delayed train, a sharp email, a gray sky: none of them reaches in and moves your mind by itself. They are external and, in his word, immovable. This is not a claim that nothing matters. It is a claim about where the motion starts, and it does not start out there.",
                    bullets = listOf(
                        InsightBullet("Fixed in place", "An event does not travel into you; it stays where it happened, the same for everyone who sees it."),
                        InsightBullet("Same facts, many minds", "Two people can face the identical setback and come away with entirely different days.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Where the Stir Begins",
                    blockquote = "our perturbations come only from the opinion which is within",
                    body = "If the agitation does not come from the thing, it comes from somewhere closer: the judgment you form about it. That can sound like blame, but Marcus meant it as relief. A judgment is something you made, so it is something you can look at again, loosen, or set down. The same note ends with his short summary: the universe is change, and life is opinion.",
                    bullets = listOf(
                        InsightBullet("Name the judgment", "When you feel stirred, try finishing the sentence: this is bad because I think that..."),
                        InsightBullet("A thought at hand", "Marcus kept this idea ready for the moments he felt pulled, the way you keep a key in your pocket.")
                    )
                )
            ),
            modernApplication = "When something rattles you today, separate two things: what happened, and what you are telling yourself about it. Write the event in one plain line with no adjectives. Then ask whether the second line, your opinion, is the one doing the damage.",
            closing = "The event stays where it fell; the storm is a judgment you can revise.",
            reflectionPrompt = "What is one thing troubling you right now? If you described it with no opinions attached, how much of the trouble would remain?"
        ),

        // q002 — Marcus Aurelius
        "q002" to QuoteInsight(
            intro = "Marcus draws a comparison here. The whole of nature absorbs whatever blocks it and turns it into part of its own working. He says a reasoning person has received the same power: to take an obstacle and make it into material for what they were already trying to do.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Obstacles as Raw Material",
                    blockquote = "The rational animal is able to make every hindrance its own material",
                    body = "A sculptor does not resent the stone for being hard; the hardness is what she works with. Marcus asks you to see hindrances in a similar way. The delay, the refusal, the difficult colleague can become the very stuff your patience, fairness, or ingenuity is shaped from. The obstacle does not vanish. It changes its role, from wall to workpiece.",
                    bullets = listOf(
                        InsightBullet("A shared power", "Marcus saw this ability as a gift shared with the whole of nature, which folds every opposing thing into its order."),
                        InsightBullet("Change the question", "Instead of asking how to get rid of the obstacle, ask what it could be used to build.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Still Your Own Aim",
                    blockquote = "to use it for such purposes as it may have designed",
                    body = "The second half matters as much as the first. The hindrance is put to work for purposes you already hold. Your aim does not shrink to fit the obstacle; the obstacle is bent to serve the aim. If you meant to be kind today and someone is rude, the rudeness becomes the occasion for the kindness you intended all along.",
                    bullets = listOf(
                        InsightBullet("Aim first", "Know what you are trying to be in a situation, and the obstacle has somewhere useful to go."),
                        InsightBullet("Nothing wasted", "Even a plan that falls apart leaves material for steadiness, honesty, or learning.")
                    )
                )
            ),
            modernApplication = "Next time a plan is blocked, take ten seconds before reacting and say quietly: this is material. Then ask which of your aims it can feed, whether patience, skill, or care for someone. Let that answer decide your next move rather than the frustration.",
            closing = "What stands in the way can be carved into what you are making.",
            reflectionPrompt = "Think of an obstacle you are facing this week. What quality could it become the material for, if you let it?"
        ),

        // q003 — Marcus Aurelius
        "q003" to QuoteInsight(
            intro = "This note is three short sentences, almost like a reminder pinned above a desk. Marcus is not trying to frighten himself. He is pointing out that time is limited, and that the one thing worth doing with it, being good, is available right now.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Ten Thousand Years",
                    blockquote = "Do not act as if you were going to live ten thousand years.",
                    body = "Much of what we put off rests on a quiet assumption that there will always be more time. The apology can wait, the generous act can wait, the change in habit can wait. Marcus names the assumption and sets it aside. He does not say life is short to make you anxious. He says it so that you stop treating goodness as something for later.",
                    bullets = listOf(
                        InsightBullet("The hidden assumption", "Postponing the good usually rests on a belief in endless tomorrows that nobody actually has."),
                        InsightBullet("A gentle correction", "The point is perspective, not alarm: a reminder to spend the hours you have on what matters.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "While It Is in Your Power",
                    blockquote = "While you live, while it is in your power, be good.",
                    body = "The closing sentence turns the thought from limit to opportunity. While you are here, being good is within your reach. It does not depend on money, status, or luck. It depends on what you choose in the next conversation, the next task, the next small decision. That window is open today, and it is enough.",
                    bullets = listOf(
                        InsightBullet("Within reach", "Goodness asks for nothing outside your control; it is always something you can do now."),
                        InsightBullet("Small and present", "Being good today often looks ordinary: a patient reply, an honest word, a job done well.")
                    )
                )
            ),
            modernApplication = "Pick one good thing you have been postponing, such as a thank-you, a repair, or a kind call, and do it before the day ends. When you catch yourself saying \"someday,\" swap it for \"while I can.\"",
            closing = "Goodness is not a plan for later; it is the best use of today.",
            reflectionPrompt = "What good thing have you been saving for a someday that may not come? What would it take to do it this week?"
        ),

        // q004 — Marcus Aurelius
        "q004" to QuoteInsight(
            intro = "Marcus slipped this line into a note reminding himself that a person can be truly good without anyone noticing. Right after it, he tells himself not to give up on being free and modest just because he never mastered logic or natural philosophy. A happy life, he says, needs very little.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Short List",
                    blockquote = "Very little indeed is necessary",
                    body = "Make a list of what you think a good life requires and it tends to grow: the right job, the right home, the right reputation, the right body. Marcus, an emperor with everything available, reverses the direction. The list is short: a clear mind, honest action, decent relations with others. Most of the rest is pleasant, but it is not the foundation.",
                    bullets = listOf(
                        InsightBullet("From the top", "These words come from a man who had every comfort in the empire and still concluded that little was needed."),
                        InsightBullet("Shorten the list", "Ask of each requirement you hold: is this needed for living well, or only for living comfortably?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Happiness Without Credentials",
                    blockquote = "for living a happy life",
                    body = "In the same note Marcus admits he had given up hope of becoming skilled in logic and natural philosophy. He tells himself this is no reason to give up on being free, modest, and social. Happiness, in his view, does not wait for talent or recognition. It is open to anyone who lives rightly, even if no one ever notices.",
                    bullets = listOf(
                        InsightBullet("No special skill", "You do not need to excel at anything in particular to live a good life; you need to live it rightly."),
                        InsightBullet("Unseen goodness", "Marcus notes that a person can be deeply good and recognized by no one, and that is enough.")
                    )
                )
            ),
            modernApplication = "Today, notice one moment of real contentment and ask what it actually required. Often the answer is small: a quiet cup of coffee, a good conversation, work done carefully. Let that shape how much you chase tomorrow.",
            closing = "The good life travels light; it never needed much luggage.",
            reflectionPrompt = "If you could name only three things you truly need to live well, what would they be? What on your current list could you let go of?"
        ),

        // q005 — Marcus Aurelius
        "q005" to QuoteInsight(
            intro = "Marcus describes a habit he wanted to build: whenever something presents itself, define it plainly. See what it is made of, what it is called, and how long it will last. He says nothing lifts the mind as much as this careful, honest looking.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Lift of Clear Sight",
                    blockquote = "Nothing is so productive of elevation of mind",
                    body = "Elevation of mind here means steadiness and breadth, the ability to stand slightly above the moment instead of being swept along by it. Marcus does not find it in grand thoughts or escape. He finds it in accuracy. When you see something for what it is, it loses its power to inflate itself, and you gain room to respond well.",
                    bullets = listOf(
                        InsightBullet("Height through honesty", "Calm comes less from rising above things than from seeing them exactly as they are."),
                        InsightBullet("Room to choose", "Once a thing is clearly defined, you can decide what virtue it calls for: patience, courage, honesty.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Look Methodically and Truly",
                    blockquote = "to be able to examine methodically and truly every object which is presented to you in life",
                    body = "Around this line Marcus gives the method. Describe the thing as if stripped bare. Name its parts. Ask what it is composed of, how long it will endure, and what quality it asks of you, such as gentleness, truth, or simplicity. Method keeps you from skipping steps; truth keeps you from flattering the thing or making it a catastrophe.",
                    bullets = listOf(
                        InsightBullet("Strip it bare", "Describe a thing without decoration: an angry message is words on a screen, sent by a person having a bad day."),
                        InsightBullet("Ask what it needs", "Marcus ends by asking which virtue a situation calls for, which turns looking into acting.")
                    )
                )
            ),
            modernApplication = "Choose one thing that is weighing on you and write a plain definition of it in two sentences, as if for someone with no stake in it. Then add one line: what quality does this ask of me? Read the note again before you act.",
            closing = "Name a thing plainly and it shrinks to its true size.",
            reflectionPrompt = "What situation in your life could use a plain, honest definition? What would it look like stripped of the story you have built around it?"
        ),

        // q006 — Marcus Aurelius
        "q006" to QuoteInsight(
            intro = "Marcus calls this \"the chief thing,\" which shows how central it was to him. He pairs two reminders: everything unfolds by nature, and soon he will be as gone as Hadrianus (the emperor Hadrian, who ruled shortly before him) and Augustus (Rome's first emperor).",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Nothing Outside the Order",
                    blockquote = "Be not perturbed, for all things are according to the nature of the universal",
                    body = "For the Stoics, events are not random insults aimed at you. They belong to one large, connected order, the same nature that brings seasons, growth, and change. Seeing things this way does not make every event pleasant. It makes them less strange. What happens is the kind of thing that happens, and you can meet it without feeling singled out.",
                    bullets = listOf(
                        InsightBullet("Not aimed at you", "Setbacks belong to the ordinary workings of the world, not to a plot against you."),
                        InsightBullet("Less strange", "When an event feels natural rather than outrageous, the mind has less to fight.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Even Emperors Pass",
                    blockquote = "in a little time you will be nobody and nowhere, like Hadrianus and Augustus",
                    body = "Marcus held the same office as the men he names. Augustus founded the role and Hadrian held it within living memory, and both were long gone. If their power did not last, the worries pressing on Marcus would not either. Right after this, he tells himself to fix his eyes on his work and do what a good man does, speaking justly and with modesty.",
                    bullets = listOf(
                        InsightBullet("Perspective, not gloom", "Remembering how brief everything is shrinks today's worry without shrinking today's duty."),
                        InsightBullet("Then get to work", "Marcus moves straight from this thought to his business, which shows it was meant to steady him, not stop him.")
                    )
                )
            ),
            modernApplication = "When a problem feels enormous, ask how much it will matter in ten years, then in a hundred. Let the answer lower the temperature. Then return to the task in front of you and do the next right thing with care.",
            closing = "Even an emperor's worries fade; do today's work well and let the rest settle.",
            reflectionPrompt = "What is unsettling you most this week? How would it look if you saw it as an ordinary part of how the world works?"
        ),

        // q007 — Marcus Aurelius
        "q007" to QuoteInsight(
            intro = "Marcus uses an old image here: life as a thread spun by fate, each person's portion woven into the larger fabric. He asks himself not merely to accept what arrives but to love it, and then poses a simple question: what could suit you better than what is actually yours?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Love What Arrives",
                    blockquote = "Love that only which happens to you and is spun with the thread of your destiny.",
                    body = "The word \"only\" is striking. Marcus is not saying to love everything in a vague way. He narrows your affection to what actually comes to you, rather than the life you imagined or the one someone else has. The thread image places your circumstances inside a larger pattern, so what arrives is not an accident to resent but part of the weave.",
                    bullets = listOf(
                        InsightBullet("The actual, not the ideal", "Wishing for a different life spends love on something that does not exist."),
                        InsightBullet("Part of a pattern", "The thread image suggests your circumstances belong to a larger whole, not to a random mess.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Fits Better",
                    blockquote = "For what is more suitable?",
                    body = "This short question carries the argument. If your circumstances are spun for you, nothing else could fit you more closely. Another person's luck would be a borrowed coat. The question does not deny that some days are hard. It invites you to stop measuring your life against imagined alternatives and to work with the one in your hands.",
                    bullets = listOf(
                        InsightBullet("Borrowed coats", "Other people's circumstances fit them, not you, however attractive they look from outside."),
                        InsightBullet("Work with it", "The next note in the Meditations treats what happens as material to work on, so acceptance leads to action.")
                    )
                )
            ),
            modernApplication = "When something unwelcome lands on your plate today, try saying: this is mine to work with. Notice the urge to compare it with how things should have gone, and gently set that aside. Then ask what you can do with what is actually here.",
            closing = "The life that fits you best is the one you are already living.",
            reflectionPrompt = "What part of your current life are you resisting most? What might change if you treated it as your own thread to work with rather than a mistake?"
        ),

        // q008 — Marcus Aurelius
        "q008" to QuoteInsight(
            intro = "Marcus is working through a puzzle about long and short lives. His answer is that the longest liver and the one who dies soonest lose exactly the same thing, because the present moment is all anyone truly holds. The past and the future are not ours to lose.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "All You Hold",
                    blockquote = "The present is the only thing of which a man can be deprived",
                    body = "We tend to think of life as a large store of years that can be cut short. Marcus looks at it differently. At any moment, what you actually possess is this moment. Yesterday is gone and tomorrow has not arrived. So what can be taken from you is only ever the present, which is a small thing, and the same size for everyone.",
                    bullets = listOf(
                        InsightBullet("A narrow possession", "At any given time, what you truly have is the moment you are in, nothing more."),
                        InsightBullet("Equal for all", "In this view, a long life and a short one hold the same amount of the present.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Nothing Lost That Was Never Held",
                    blockquote = "a man cannot lose a thing if he has it not",
                    body = "This is the logical hinge. You cannot be robbed of money you never had, and you cannot be robbed of years that never belonged to you. Marcus uses the point to ease the fear of losing time. It also carries a quiet instruction: since the present is all you hold, it is worth holding attentively instead of spending it on regret or worry.",
                    bullets = listOf(
                        InsightBullet("Ease the fear", "Worry about lost future years loosens when you see they were never yours to hold."),
                        InsightBullet("Hold it well", "If the present is the whole of your possession, attention is the way to make use of it.")
                    )
                )
            ),
            modernApplication = "When you notice yourself mourning time already gone or fearing time not yet here, bring your attention back to one concrete thing in front of you: the person speaking, the task in your hands, the breath you are taking. That is the part of life you actually own.",
            closing = "You cannot lose tomorrow; you can only miss today.",
            reflectionPrompt = "Where does your attention go when it leaves the present: backward into regret or forward into worry? What helps you come back?"
        ),

        // q009 — Marcus Aurelius
        "q009" to QuoteInsight(
            intro = "Marcus offers a test for what counts as real harm. If something does not make you a worse person, it has not made your life worse and has not truly harmed you. The note follows another: take away the complaint \"I have been harmed,\" and the harm is gone.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Character Test",
                    blockquote = "That which does not make a man worse than he was",
                    body = "Most of us measure harm by what we lose: money, comfort, standing, a plan. Marcus measures it by something else, whether we have become less honest, less fair, less kind. By that measure, many painful events leave us untouched where it matters. They may hurt. They do not damage the self that chooses how to act.",
                    bullets = listOf(
                        InsightBullet("A different scale", "Harm, for Marcus, is measured in character, not in comfort or possessions."),
                        InsightBullet("Hurt is not harm", "Something can be painful without making you any worse as a person.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Safe From Both Sides",
                    blockquote = "nor does it harm him either from without or from within",
                    body = "Marcus closes off both routes. Nothing outside can damage your character on its own, and nothing inside is harmed unless you join in by acting badly. This makes your goodness unusually secure. The one thing that can truly hurt you is your own choice to become worse, and that choice stays in your hands.",
                    bullets = listOf(
                        InsightBullet("No outside entry", "Events can press on you, but they cannot make you dishonest or cruel without your consent."),
                        InsightBullet("The real risk", "The only lasting injury is choosing badly in response, which is why the response matters most.")
                    )
                )
            ),
            modernApplication = "When something goes wrong today, ask: has this made me a worse person, or only an inconvenienced one? If it is the second, give the event its true weight. Then spend your energy making sure your response does not do the harm the event could not.",
            closing = "Loss can take your things; only your own choices can take your character.",
            reflectionPrompt = "Think of something that felt like harm recently. Did it make you worse as a person, or only make your day harder? How does that change how you see it?"
        ),

        // q010 — Marcus Aurelius
        "q010" to QuoteInsight(
            intro = "Near the start of the final book of his notes, Marcus turns the usual fear around. The thing to fear is not that life will end someday. It is that you might never have begun to live according to nature, which for the Stoics meant living by reason and in fellowship with others.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wrong Fear",
                    blockquote = "If you shall be afraid not because you must some time cease to live",
                    body = "Fear of an ending is common and natural, but Marcus thinks it is aimed at the wrong target. The ending is certain for everyone and outside anyone's control. Spending your worry there leaves less attention for what is in your control. He is not asking you to feel nothing. He is asking you to point the concern at something you can act on.",
                    bullets = listOf(
                        InsightBullet("Misplaced worry", "Fear of an ending you cannot change crowds out care for a life you can shape."),
                        InsightBullet("Redirect, not deny", "The aim is not to stop caring but to care about the right thing.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Begin to Live",
                    blockquote = "if you shall fear never to have begun to live according to nature",
                    body = "Living according to nature meant living as a reasoning and social being: thinking clearly, acting justly, caring for others. Marcus suggests the real loss would be never to have started this kind of life. Whoever does begin, he says, becomes worthy of the universe that produced them, and stops being a stranger in their native land.",
                    bullets = listOf(
                        InsightBullet("A late start is a start", "The fear Marcus names is of never beginning, which means today is still a good day to begin."),
                        InsightBullet("At home in the world", "He says such a person stops wondering at daily events as if they were something unexpected.")
                    )
                )
            ),
            modernApplication = "Ask yourself each morning this week what living well would look like in today's ordinary hours. Pick one concrete act, such as a fair decision, a patient answer, or an honest admission, and treat it as the beginning rather than waiting for a better time.",
            closing = "The question is not how long you live but whether you have begun.",
            reflectionPrompt = "In what part of your life are you still waiting to begin? What is one small way you could start living it as you intend today?"
        ),

        // q011 — Epictetus
        "q011" to QuoteInsight(
            intro = "These are the opening words of the Encheiridion, the short handbook of Epictetus's teaching. Everything else in the book rests on this first division: some things are up to us and some are not, and peace depends on knowing which is which.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The First Division",
                    blockquote = "Of things some are in our power, and others are not.",
                    body = "Epictetus begins with a sorting exercise. Before asking whether something is good or bad, ask whether it is up to you. The next lines list what is not: the body, property, reputation, public office. These matter, but they belong partly to others and to chance. Confusing the two categories, he says, leads to frustration, lament, and blaming gods and men alike.",
                    bullets = listOf(
                        InsightBullet("Sort before judging", "The first question about any situation is not how bad it is but whose it is."),
                        InsightBullet("The other list", "Epictetus names the body, property, reputation, and office as things not in our power.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Is Truly Yours",
                    blockquote = "In our power are opinion, movement toward a thing, desire, aversion, turning from a thing",
                    body = "The list of what is yours is entirely inner: your opinions, your impulses toward and away from things, your desires and aversions. Epictetus sums it up as whatever are our own acts. This can sound small, but he calls these things free by nature, not subject to restraint or hindrance. No one can force your judgment or choose your response for you.",
                    bullets = listOf(
                        InsightBullet("Inner territory", "Everything on the list lives inside you: how you judge, what you want, what you refuse."),
                        InsightBullet("Free by nature", "Epictetus says these are the things no one else can restrain or hinder.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "In Our Power",
                rightHeader = "Not in Our Power",
                rows = listOf(
                    "Your opinions" to "Your reputation",
                    "Your desires and aversions" to "Your body and health",
                    "How you act" to "Your property and position"
                )
            ),
            modernApplication = "When you feel stuck or upset, draw a line down a page. On the left, write what in the situation is up to you; on the right, what is not. Spend the next hour only on the left column, and let the right column rest.",
            closing = "Sort the world in two, and most of your burden lands on the other side.",
            reflectionPrompt = "What are you trying to control that belongs in the \"not in our power\" column? What on your side of the line have you been neglecting?"
        ),

        // q012 — Epictetus
        "q012" to QuoteInsight(
            intro = "Epictetus imagines himself as a witness sent to show others how to live. His message is short: you fear without reason and desire foolishly, because you look for the good in the wrong place. Seek it in yourselves, he says, or you will not find it at all.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wrong Address",
                    blockquote = "Seek not the good in things external",
                    body = "External things include money, praise, comfort, position, and other people's behavior. Epictetus does not call them worthless. He says the good, the thing that actually makes a life go well, is not located there. Searching for it among externals is like looking for your keys in a room you never entered. The effort is real, but the search cannot succeed.",
                    bullets = listOf(
                        InsightBullet("Not worthless, just elsewhere", "Externals may be pleasant or useful, but the good itself does not live among them."),
                        InsightBullet("Restless searching", "Looking for the good outside keeps you chasing, because externals are never fully secure.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Look Within",
                    blockquote = "seek it in yourselves: if you do not, you will not find it",
                    body = "For Epictetus the good lives in your own choices: judging well, desiring wisely, acting with integrity. This is why he could speak calmly of poverty, sickness, and exile. In the same passage he mentions being sent to Gyara, a barren island used as a place of exile. Such conditions could not reach the place where his good was kept.",
                    bullets = listOf(
                        InsightBullet("Kept safe inside", "A good located in your own choices cannot be confiscated by circumstance."),
                        InsightBullet("A plain warning", "The last clause is blunt: search elsewhere and you will come back empty-handed.")
                    )
                )
            ),
            modernApplication = "Before your next purchase, push for promotion, or bid for approval, ask: am I looking here for something only I can give myself? Name the inner good it stands in for, such as security, worth, or calm, and look for a way to practice that directly.",
            closing = "The good was never lost; it was only being sought in the wrong rooms.",
            reflectionPrompt = "Where have you been looking for the good lately: in results, people, or possessions? What would it mean to look for it in how you choose and act?"
        ),

        // q013 — Epictetus
        "q013" to QuoteInsight(
            intro = "Encheiridion 33 is a long list of rules for daily conduct, and this is the line that opens it. Before any specific advice about speech or company, Epictetus asks you to decide who you are going to be, and to be that person in private and in public alike.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Decide Who You Are",
                    blockquote = "Immediately prescribe some character and some form to yourself",
                    body = "The word \"immediately\" stands out. Epictetus does not want you to wait until you feel ready or wise. Choose a pattern now: the kind of person you mean to be, the standards you will keep. A clear character works like a set of rails. When a moment arrives, you are not inventing yourself from scratch; you are following a line already drawn.",
                    bullets = listOf(
                        InsightBullet("No waiting room", "The character you choose today can guide you today, long before you feel complete."),
                        InsightBullet("Rails, not cages", "A chosen standard spares you from deciding everything anew under pressure.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Alone and in Company",
                    blockquote = "which you shall observe both when you are alone and when you meet with men",
                    body = "A character that appears only in front of others is a costume. Epictetus asks for the same person in an empty room and a crowded one. The rules that follow give the flavor: speak little and only when needed, avoid gossip and blame of others, steer talk toward what is worthwhile. These are private habits that happen to show in public.",
                    bullets = listOf(
                        InsightBullet("Same in both rooms", "Integrity means the private self and the public self are the same self."),
                        InsightBullet("Habits that show", "Epictetus's examples, such as speaking less and avoiding gossip, start alone and carry into company.")
                    )
                )
            ),
            modernApplication = "Write three short words describing the person you intend to be, for example calm, honest, unhurried. Read them in the morning. Tonight, check one private moment and one public moment against them, and adjust tomorrow without reproaching yourself.",
            closing = "Be one person, whether the room is full or empty.",
            reflectionPrompt = "What is one way your private conduct differs from how you behave around others? Which version would you rather make permanent?"
        ),

        // q014 — Epictetus
        "q014" to QuoteInsight(
            intro = "Epictetus asks what the first business of anyone studying philosophy is, and answers: throw away self-conceit. This line is his reason. You cannot learn what you believe you already know, so learning begins with admitting how much you have yet to understand.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The First Business",
                    blockquote = "It is impossible for a man to begin to learn",
                    body = "Learning begins with an opening, a sense that there is something here you do not yet grasp. Epictetus calls the thing that blocks that opening self-conceit, the comfortable feeling of already knowing. He notes that everyone talks freely of good and bad, honorable and shameful, as if these were settled. That ease is what keeps real understanding out.",
                    bullets = listOf(
                        InsightBullet("A closed door", "Feeling certain shuts the door that curiosity would have opened."),
                        InsightBullet("Everyday opinions", "We speak of good and bad all day, which is why we rarely examine what we mean.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Trap of Knowing",
                    blockquote = "that which he thinks that he knows",
                    body = "The trouble is not ignorance but false confidence. An honest beginner can be taught; someone who mistakes a slogan for understanding cannot. Epictetus wants his students to hold their opinions loosely enough to test them. Saying \"I may not understand this yet\" is not weakness. It is the posture that makes growth possible, at any age.",
                    bullets = listOf(
                        InsightBullet("Beginner's advantage", "The person who knows they do not know has a head start over the one who thinks they do."),
                        InsightBullet("Hold it loosely", "Treat your firmest opinions as working drafts that can still be revised.")
                    )
                )
            ),
            modernApplication = "In your next disagreement or meeting, pick one topic you feel sure about and ask one honest question about it, as if you were new to it. Listen to the answer fully before replying. Notice what you learn that certainty would have hidden.",
            closing = "Empty the cup of certainty, and there is room to pour something in.",
            reflectionPrompt = "What is one subject you feel certain you understand? What question about it have you never really asked?"
        ),

        // q015 — Epictetus
        "q015" to QuoteInsight(
            intro = "This is one of the best known lines in Stoic writing. Epictetus follows it with an example: death is not terrible, or it would have seemed so to Socrates; the opinion that it is terrible is the terrible thing. The same pattern holds for every disturbance.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not the Event Itself",
                    blockquote = "Men are disturbed not by the things which happen",
                    body = "It feels natural to say the traffic made me angry or the news made me anxious. Epictetus asks you to slow that sentence down. Between the event and the feeling there is a step, usually so quick you miss it: a judgment that this is bad, unfair, or unbearable. The event supplies the occasion; it does not supply the disturbance.",
                    bullets = listOf(
                        InsightBullet("A hidden step", "Between what happens and how you feel sits a judgment, often made in a split second."),
                        InsightBullet("The calm of Socrates", "Epictetus points to Socrates, the Athenian philosopher, who faced what others fear and stayed calm.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Opinion Is the Weight",
                    blockquote = "but by the opinions about the things",
                    body = "If opinions carry the weight, opinions are where relief can be found. Epictetus goes on to describe three stages of growth. The untrained person blames others for their trouble. The beginner starts to blame their own opinions. The one whose training is complete blames no one at all, but simply sees clearly and responds.",
                    bullets = listOf(
                        InsightBullet("Three stages", "Blaming others, then examining yourself, then needing to blame no one: that is the path Epictetus maps."),
                        InsightBullet("Relief is inside", "Since the disturbance lives in the judgment, the judgment is where it can change.")
                    )
                )
            ),
            modernApplication = "The next time you say something made you upset, rephrase it: I judged that this was bad, and I became upset. Then ask whether the judgment holds up. Sometimes it will; often it softens once you see it as your own.",
            closing = "Change the opinion, and the same event weighs differently.",
            reflectionPrompt = "Which recent upset came from an opinion you formed quickly? Is there another way of seeing it that would be just as true?"
        ),

        // q016 — Epictetus
        "q016" to QuoteInsight(
            intro = "Epictetus writes this to students who want a tranquil life. After warning them not to tie their peace to things outside their power, he gives this simple instruction. Then he adds a lovely thought: if you have behaved well today, you can celebrate a small festival every day.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Joy in What Is Here",
                    blockquote = "Rejoice in that which is present",
                    body = "It is easy to postpone gladness until something arrives: the trip, the weekend, the better job. Epictetus points to what is already in front of you, not as a consolation prize but as the real place where joy can happen. The present is the only time you can actually enjoy anything, so it makes sense to start there.",
                    bullets = listOf(
                        InsightBullet("No waiting for joy", "Gladness postponed until conditions improve tends to stay postponed."),
                        InsightBullet("Small festivals", "Epictetus says a person who acted well today can celebrate, and do so again tomorrow.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Things in Their Season",
                    blockquote = "be content with the things which come in season",
                    body = "Think of fruit, which ripens when it ripens; no amount of wanting brings it sooner. Epictetus asks you to let things arrive when they arrive, whether success, recognition, or change in yourself. Contentment here is not passivity. It is the patience of someone who tends the field well and trusts the calendar with the rest.",
                    bullets = listOf(
                        InsightBullet("Not before time", "Wanting something before its season only adds frustration to the waiting."),
                        InsightBullet("Patient tending", "Contentment means doing your part well while letting results arrive in their own time.")
                    )
                )
            ),
            modernApplication = "Tonight, name one thing you did well today, however small, and let yourself be glad about it. Tomorrow, when you catch yourself rushing something that is not ready, say \"in season\" and return to the part that is yours.",
            closing = "Celebrate today's good act; tomorrow can bring its own.",
            reflectionPrompt = "What is one good thing in your present life you have not paused to enjoy? What are you trying to hurry that needs its season?"
        ),

        // q017 — Epictetus
        "q017" to QuoteInsight(
            intro = "Epictetus, who was born enslaved, knew what it meant to live under another person's power. Here he points to a subtler kind of servitude. Whoever controls what you want or fear becomes your master, so if your desires depend on others, so does your freedom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Price of Freedom",
                    blockquote = "Whoever then wishes to be free let him neither wish for anything nor avoid anything which depends on others",
                    body = "Just before this line Epictetus explains the logic. Anyone who can give or take away the things you want has power over you. If your peace depends on a boss's approval, a partner's mood, or a stranger's opinion, those people hold the key. The way out is not to stop caring about others, but to stop staking your freedom on what they do.",
                    bullets = listOf(
                        InsightBullet("Who holds the key", "Whoever controls what you crave or dread holds a kind of mastery over you."),
                        InsightBullet("Care without staking", "You can love and hope for good things from others without making your peace depend on them.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Hidden Chains",
                    blockquote = "if he does not observe this rule, he must be a slave",
                    body = "The word is strong, and Epictetus meant it. For him, servitude was not only a legal status but an inner condition. A wealthy official who trembles for favor is less free than a poor person who wants nothing from anyone. The rule is demanding, but it puts freedom within reach of anyone, whatever their circumstances.",
                    bullets = listOf(
                        InsightBullet("Inner condition", "Freedom, for Epictetus, is measured by what you need from others, not by your legal status."),
                        InsightBullet("Open to anyone", "Because it depends only on your own desires, this freedom is available in any circumstance.")
                    )
                )
            ),
            modernApplication = "Notice today one moment when you wait anxiously for someone else's reaction: a reply, a nod, a compliment. Do your part well, then say to yourself: their response is theirs. See whether letting go of the outcome gives you a little more room to breathe.",
            closing = "Want less from others, and fewer people hold your keys.",
            reflectionPrompt = "Whose approval or behavior has the most power over your peace right now? What would it look like to care about them without depending on them?"
        ),

        // q018 — Epictetus
        "q018" to QuoteInsight(
            intro = "Ancient society assumed that education was a privilege for those born free. Epictetus, who had himself been enslaved, turns the saying around. Education, the training of judgment, is what makes a person free, because it releases them from fear, sorrow, and confusion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Saying Turned Around",
                    blockquote = "We must not believe the many, who say that free persons only ought to be educated",
                    body = "The common view treated learning as a reward for status: those who were already free could afford it. Epictetus rejects that order. Status does not produce a free mind; plenty of free citizens lived anxious, driven, fearful lives. The many, as he calls the crowd, had mistaken a legal label for the real thing.",
                    bullets = listOf(
                        InsightBullet("Status is a label", "Legal freedom says little about whether a person is ruled by fear or craving."),
                        InsightBullet("The crowd's order", "The usual view put status first and learning second; Epictetus reverses it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Learning That Frees",
                    blockquote = "we should rather believe the philosophers who say that the educated only are free",
                    body = "Education here does not mean degrees or reading lists. It means learning to judge well, so you are not pushed around by every fear and impulse. Epictetus asks his listeners whether anyone wants to live in error, fear, or sorrow, and they all say no. Whoever is released from these, he concludes, is free indeed, whatever their station.",
                    bullets = listOf(
                        InsightBullet("Training judgment", "The education Epictetus means is learning to see clearly and respond well."),
                        InsightBullet("A simple test", "Ask whether you are living in fear or confusion; to that degree, you are not yet free.")
                    )
                )
            ),
            modernApplication = "Pick one recurring fear or frustration and treat it as a subject to learn about. Each time it appears this week, write down the judgment behind it. Understanding the pattern slowly loosens its hold, and that loosening is the freedom Epictetus means.",
            closing = "Freedom is learned, one clear judgment at a time.",
            reflectionPrompt = "What fear or habit of mind still keeps you from living as you choose? What would you need to learn to be free of it?"
        ),

        // q019 — Epictetus
        "q019" to QuoteInsight(
            intro = "Epictetus describes a scene: you see someone weeping over a loss, perhaps a child gone abroad or property lost. He asks you to keep a clear distinction in your own mind. Then, importantly, he adds that you should still show sympathy and may even grieve alongside them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Same Event, Different Grief",
                    blockquote = "It is not that which has happened that afflicts this man, for it does not afflict another",
                    body = "The argument is simple observation. If the event itself caused the pain, it would cause the same pain in everyone. It does not: one person is crushed by a loss that another bears calmly. So something besides the event is at work. Epictetus asks you to notice this quietly, so that another person's distress does not sweep you along as if the loss were plainly a disaster.",
                    bullets = listOf(
                        InsightBullet("Watch the difference", "When people react differently to the same event, the difference shows where the weight really lies."),
                        InsightBullet("Steady footing", "Seeing this keeps you from being carried off by someone else's distress.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Sympathy Without Drowning",
                    blockquote = "it is the opinion about this thing which afflicts the man",
                    body = "This is not a license for coldness. Epictetus says plainly that you should not be unwilling to show sympathy in words, and even to lament with the person. What he asks is that you not lament inwardly as well, taking on the opinion that is hurting them. You can be warm and present while keeping your own judgment steady, which often makes you more help.",
                    bullets = listOf(
                        InsightBullet("Warm outside, steady inside", "You can comfort someone fully without taking on the judgment that is hurting them."),
                        InsightBullet("Not cold", "Epictetus explicitly allows sympathy and shared tears; he warns only against being overwhelmed.")
                    )
                )
            ),
            modernApplication = "When a friend is upset, listen fully and say something kind. Inside, hold a quiet note to yourself: this is hard for them, and I can stay steady. Your calm can become something they lean on, rather than one more storm in the room.",
            closing = "Kindness can sit beside someone's sorrow without sinking into it.",
            reflectionPrompt = "When someone close to you is upset, do you tend to absorb their distress? How might you stay warm while keeping your own footing?"
        ),

        // q020 — Epictetus
        "q020" to QuoteInsight(
            intro = "Epictetus opens this discourse with an image from the hearth. Place a dead coal next to a burning one, and either the dead coal will put out the other or the burning one will light it. People work the same way: those we spend time with shape us, for better or worse.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Company Leaves a Mark",
                    blockquote = "Remember that it is impossible that a man can keep company with one who is covered with soot",
                    body = "Epictetus is realistic about influence. Habits of talk and attitude spread quietly. He mentions conversations that drift into gossip about who is good and who is bad, or that turn mocking and ill-natured. Spend enough time in that air and you begin to breathe it. This is not a call to look down on anyone, but to be honest about what rubs off.",
                    bullets = listOf(
                        InsightBullet("Quiet spreading", "Tone, habits, and attitudes pass between people without anyone deciding they should."),
                        InsightBullet("Honest, not proud", "Recognizing influence is about knowing yourself, not judging others as beneath you.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Not Yet Socrates",
                    blockquote = "without being partaker of the soot himself",
                    body = "Epictetus notes that Socrates could lead any conversation toward something worthwhile, like a musician who instantly tunes a lute. Most of us have not reached that point. Until you are steady enough to be the burning coal, take care with the company you keep closest, and choose some relationships that warm you toward what is good.",
                    bullets = listOf(
                        InsightBullet("Know your strength", "If you cannot yet change the tone of a room, it may change you; plan accordingly."),
                        InsightBullet("Seek the burning coal", "Spend time with people whose habits you would be glad to catch.")
                    )
                )
            ),
            modernApplication = "Look at the three or four people you spend the most time with, and the conversations you have most often. Ask which leave you clearer and kinder, and which leave you sour. Without drama, give a little more of your time to the first kind.",
            closing = "Choose your company the way you would choose the air you breathe.",
            reflectionPrompt = "Whose company leaves you better than you were, and whose leaves a little soot behind? What small change would shift that balance?"
        ),

        // q021 — Seneca
        "q021" to QuoteInsight(
            intro = "Seneca has been describing how illnesses of the body make themselves known, while faults of character hide: the worse they are, the less we notice them. He compares it to deep sleep. Only someone who has woken up can tell you what they dreamed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Still in Their Grasp",
                    blockquote = "Why will no man confess his faults? Because he is still in their grasp",
                    body = "Seneca's answer is surprising. People do not hide their faults only out of pride. Often they cannot see them, because they are still inside them. A habit of anger feels like justified reaction. A habit of greed feels like prudence. While a fault holds you, it looks like ordinary life, so it does not occur to you to confess anything.",
                    bullets = listOf(
                        InsightBullet("Faults in disguise", "A fault in full grip usually looks like common sense to the one who has it."),
                        InsightBullet("Not just pride", "Silence about our flaws often comes from blindness rather than stubbornness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Waking Up",
                    blockquote = "only he who is awake can recount his dream",
                    body = "The dream image makes the point gently. You cannot describe a dream while you are deep inside it; you need to be awake. So the ability to name your own faults is a good sign, not a shameful one. It means part of you has stepped outside the fault. Seneca then urges Lucilius to rouse himself, and says philosophy is what can shake off this deep slumber.",
                    bullets = listOf(
                        InsightBullet("A good sign", "Seeing and naming a flaw shows you are no longer wholly in its grip."),
                        InsightBullet("Something to wake you", "Seneca credits philosophy, the steady practice of examining life, with rousing us.")
                    )
                )
            ),
            modernApplication = "At the end of the day, write one sentence that begins: today I noticed in myself... Keep it honest and short, without punishment. The fact that you can write it at all is evidence you are waking up.",
            closing = "To name a fault is to stand, at last, a little outside it.",
            reflectionPrompt = "What fault in yourself have you only recently begun to see? What helped you notice it?"
        ),

        // q022 — Seneca
        "q022" to QuoteInsight(
            intro = "In his very first letter, Seneca urges his friend Lucilius to value time. He points to a habit of mind: we treat death as something waiting far ahead. Seneca suggests that every year already lived has passed beyond reach, so time is being spent daily, and the remedy is to hold each hour well.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Only Ahead",
                    blockquote = "We are mistaken when we look forward to death",
                    body = "Most of us picture the end of life as a single event far down the road. Seneca says this picture misleads us. It lets us feel that time is safe until then, so we spend it carelessly. His point is not to dwell on endings but to see that time is slipping away continuously, which is a reason to pay attention to it now.",
                    bullets = listOf(
                        InsightBullet("A misleading picture", "Imagining the end as far off can make today feel cheap and endlessly available."),
                        InsightBullet("Attention, not dread", "Seneca's aim is to awaken care for time, not to stir up fear.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Years Already Spent",
                    blockquote = "the major portion of death has already passed",
                    body = "Seneca explains in the next line that the years behind us already belong to the past and cannot return. Seen this way, you are not saving time for later; you are spending it as you go. So he gives Lucilius practical advice: hold every hour in your grasp, take hold of today's task, and you will depend less on tomorrow.",
                    bullets = listOf(
                        InsightBullet("Gone as you go", "Each day lived is already beyond recall, which makes the next one worth guarding."),
                        InsightBullet("Today's task", "Seneca's remedy is simple: do what is in front of you today instead of postponing it.")
                    )
                )
            ),
            modernApplication = "Choose one task you have been pushing to tomorrow and do it today, even in a small form. At the end of the day, ask: did I hold this day, or did it slip by? Let the answer guide tomorrow's first hour.",
            closing = "Time is not saved for later; it is spent as you live it.",
            reflectionPrompt = "How did you spend yesterday's hours? Is there one hour today you would like to hold more deliberately?"
        ),

        // q023 — Seneca
        "q023" to QuoteInsight(
            intro = "Seneca wrote this letter in reply to a complaint that a good man had been taken in the prime of life. His answer is that length is the wrong measure. What makes a life long is fullness, and fullness comes when the soul takes charge of itself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wrong Measure",
                    blockquote = "A life is really long",
                    body = "We usually count life in years, as though more were automatically better. Seneca questions this. He points to a man who spent eighty years in idleness and says he has not really lived, only lingered. Long life, he writes, needs only fate, but living rightly needs the soul. One measure is out of your hands; the other is entirely yours.",
                    bullets = listOf(
                        InsightBullet("Years or living", "Length is set by fate; the quality of living is set by you."),
                        InsightBullet("Lingering is not living", "Seneca says a long idle life is less a life than a long delay.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Fullness Means",
                    blockquote = "if it is a full life",
                    body = "Fullness, for Seneca, does not mean a packed calendar. It means the soul has given itself its proper good, which he explains as gaining control over itself. A full life is one where you have been your own master, done your duties, and acted well. By that measure a shorter life can be complete, and a longer one can still be waiting to begin.",
                    bullets = listOf(
                        InsightBullet("Not busyness", "A crowded schedule is not the same as a full life; fullness is about self-mastery and right action."),
                        InsightBullet("Complete at any length", "A life lived well has its fullness whenever it ends.")
                    )
                )
            ),
            modernApplication = "Tonight, instead of asking whether you got enough done, ask whether you were your own master today: did you act as you intended, at least once? Mark that moment. Fullness is built from such moments, not from hours logged.",
            closing = "Measure life by its depth, and every day can add to it.",
            reflectionPrompt = "If you measured your life by fullness instead of length, which recent day would count most? What made it full?"
        ),

        // q024 — Seneca
        "q024" to QuoteInsight(
            intro = "At the end of his fifth letter, Seneca compares people with animals. Animals flee the danger in front of them and, once safe, are at ease. Humans keep suffering after danger has passed and before it arrives, because memory and foresight carry the pain into other times.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Pain Sent Ahead",
                    blockquote = "We men torment ourselves over that which is to come",
                    body = "Just before this line, Seneca observes that hope and fear travel together, like a prisoner chained to his guard. Both come from a mind that leans too far forward. Foresight, which he calls the noblest blessing of the human race, gets turned against us. Instead of preparing, we rehearse suffering that has not happened and may never happen.",
                    bullets = listOf(
                        InsightBullet("Hope and fear chained", "Seneca pictures them chained like prisoner and guard: where one goes, the other follows."),
                        InsightBullet("A gift misused", "Foresight is meant for planning, not for living through troubles in advance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Pain Carried Back",
                    blockquote = "as well as over that which is past",
                    body = "Memory does the same thing in the other direction. A past embarrassment or loss gets replayed until it hurts as if new. Seneca's conclusion is quiet and practical: the present alone can make no one wretched. Right now, in this moment, there is usually something you can bear. The torment comes from what we drag in from other times.",
                    bullets = listOf(
                        InsightBullet("Replays", "Memory can make an old hurt feel fresh every time you revisit it."),
                        InsightBullet("The bearable present", "Seneca ends the letter by saying the present alone can make no one wretched.")
                    )
                )
            ),
            modernApplication = "When you feel a wave of dread or regret, ask: what is actually happening right now, in this room? Name three concrete things you can see or do. Bring your mind back to the moment you are in, which is almost always more bearable than the one you imagined.",
            closing = "The present asks only to be lived, not to carry other days.",
            reflectionPrompt = "Which troubles you more, the past replaying or the future rehearsed? What is one way to return to the present when it starts?"
        ),

        // q025 — Seneca
        "q025" to QuoteInsight(
            intro = "Seneca writes that the greatest flaw in life is that it always feels unfinished, with part of it postponed. His remedy is to treat each day as complete in itself, balancing life's account before you sleep. Whoever does this, he says, never feels short of time.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Day Made Whole",
                    blockquote = "One who daily puts the finishing touches to his life",
                    body = "Picture a craftsman who finishes a piece each evening rather than leaving everything half-done for some later date. Seneca asks you to live like that. Do what matters today, settle what can be settled, and let the day stand complete. Then the shape of your life does not depend on how many more days you get, because each one is already whole.",
                    bullets = listOf(
                        InsightBullet("Settle accounts daily", "Seneca's phrase is to balance life's account every day, leaving little left over."),
                        InsightBullet("Complete pieces", "A day finished with care does not need tomorrow to give it meaning.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Never Short of Time",
                    blockquote = "is never in want of time",
                    body = "The feeling of never having enough time, Seneca says, breeds fear and a craving for the future that eats away at the mind. That feeling comes largely from postponing. When life always waits on a later chapter, every day feels short. When you finish each day as you go, the pressure lifts. You stop needing more time because you are not living on credit.",
                    bullets = listOf(
                        InsightBullet("Postponing breeds hurry", "The more you put off, the more each day feels too short."),
                        InsightBullet("No life on credit", "Living fully today means not borrowing all your meaning from a future you hope to have.")
                    )
                )
            ),
            modernApplication = "Before bed, take two minutes to close the day: one thing you did well, one thing you will let go of, one thing set up for tomorrow. Then consider the day finished. Over time this small habit makes days feel complete rather than rushed.",
            closing = "Finish each day well, and time stops running short.",
            reflectionPrompt = "What do you tend to postpone that leaves your days feeling unfinished? What would it take to finish one day completely?"
        ),

        // q026 — Seneca
        "q026" to QuoteInsight(
            intro = "Seneca praises Lucilius for staying put instead of rushing from place to place. Then he warns about a similar restlessness in reading: sampling every author without settling with any. The traveler who is always moving, he says, ends up knowing many people and befriending none.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Cost of Scattering",
                    blockquote = "Everywhere means nowhere.",
                    body = "Seneca's three words compress the point. Spread attention across everything and it settles on nothing. The letter is mostly about reading: he warns that skimming many books leaves no ideas with a firm hold. He offers a string of images, among them food that passes through without nourishing and a plant moved so often it never grows strong.",
                    bullets = listOf(
                        InsightBullet("Depth needs staying", "Ideas, like roots, need time in one place before they take hold."),
                        InsightBullet("Not against variety", "Seneca allows a change now and then, but asks Lucilius to return to the few authors he trusts.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Acquaintances and Friends",
                    blockquote = "he ends by having many acquaintances, but no friends",
                    body = "The traveler meets countless people and leaves before any bond can form. Seneca uses this to show what happens to a mind that never stays. The same holds for relationships today: a wide circle of contacts is not the same as a few people who truly know you. Friendship, like understanding, is built by returning again and again to the same place.",
                    bullets = listOf(
                        InsightBullet("Returning builds bonds", "Friendship grows from repeated time together, not from a long list of names."),
                        InsightBullet("Wide but thin", "Many contacts can sit alongside a deep loneliness when none of them are close.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Everywhere",
                rightHeader = "Somewhere",
                rows = listOf(
                    "Many acquaintances" to "A few true friends",
                    "Skimming many books" to "Digesting a few",
                    "Restless moving about" to "Lingering in your own company"
                )
            ),
            modernApplication = "Choose one book, one skill, or one friendship to go deeper into this month instead of adding something new. Return to it on purpose a few times a week. Notice how much more it gives back when you stop moving on.",
            closing = "Stay long enough in one place for something to take root.",
            reflectionPrompt = "Where in your life are you spreading yourself so thin that nothing takes hold? What is one thing worth staying with?"
        ),

        // q027 — Seneca
        "q027" to QuoteInsight(
            intro = "Seneca writes this in his first letter to Lucilius, a friend he was guiding in philosophy. Nature, he says, entrusted us with only one real possession, time, and it is so slippery that anyone who wants can take it from us. Yet we guard it less carefully than the cheapest things we own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One True Possession",
                    blockquote = "Nothing, Lucilius, is ours",
                    body = "House, money, reputation, even health can be taken away or lost. Seneca strips the list down to the one thing he says nature truly gave us to own. Addressing Lucilius by name makes the line feel like advice across a table rather than a lecture. It is a friend reminding a friend where real wealth lies.",
                    bullets = listOf(
                        InsightBullet("A friend's advice", "Seneca writes to Lucilius by name, as personal counsel rather than a public sermon."),
                        InsightBullet("Everything else on loan", "Possessions and status can be removed, so Seneca sees them as less truly ours.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Except Time",
                    blockquote = "except time",
                    body = "Seneca notices a strange imbalance. People feel indebted for small, easily replaced gifts, yet they let their hours be taken without a thought and never feel they have received something precious. Time, he says, is the one loan that even a grateful person cannot repay. Guarding it does not mean being stingy. It means spending it on purpose.",
                    bullets = listOf(
                        InsightBullet("Easily given away", "We hand our hours to whatever asks, while guarding things worth far less."),
                        InsightBullet("Spend on purpose", "Valuing time means choosing where it goes, including generously to others.")
                    )
                )
            ),
            modernApplication = "Look at tomorrow's schedule and mark one block of time to spend on purpose, whether for rest, a person you love, or work that matters. Protect it as you would something valuable. Notice what you say yes to out of reflex.",
            closing = "Spend your hours as if they were the only thing you own, because they are.",
            reflectionPrompt = "Where did your time go this week that you would not have chosen? Where would you choose to spend it instead?"
        ),

        // q028 — Seneca
        "q028" to QuoteInsight(
            intro = "Seneca asks how to escape the restless worry about what comes next. His answer is to make the present worth something. Anxiety about the future, he suggests, feeds on days that feel empty. A day that is well used leaves little room for that kind of dread.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Worry as a Symptom",
                    blockquote = "He only is anxious about the future",
                    body = "Seneca treats anxiety about what lies ahead as a sign that something is missing now. When today feels thin, the mind leans forward, hoping tomorrow will make up the difference, and then fears it will not. The worry is real, but its root lies in the present. That is hopeful news: you can tend it where you actually are.",
                    bullets = listOf(
                        InsightBullet("Leaning forward", "An empty present pushes the mind toward the future for what it lacks."),
                        InsightBullet("Root in today", "If anxiety grows from an unused present, today is where to tend it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Making Today Count",
                    blockquote = "to whom the present is unprofitable",
                    body = "An unprofitable present is one where nothing of value is done or received. Seneca's remedy is to pay your soul its due each day: act well, think clearly, give attention to what matters. A few lines later he urges Lucilius to begin at once to live, and to count each separate day as a separate life. A day lived that way is profitable whatever tomorrow holds.",
                    bullets = listOf(
                        InsightBullet("Pay the soul its due", "Give today something worthwhile: a good act, a clear thought, real attention."),
                        InsightBullet("Each day a life", "Seneca suggests treating each day as complete in itself and worth living fully.")
                    )
                )
            ),
            modernApplication = "When worry about the future arrives, ask: what would make this hour worthwhile? Then do that thing, even if small, such as finishing a task, calling someone, or taking a slow walk. Let a well-used present answer the anxious mind.",
            closing = "A full today leaves little hunger for tomorrow.",
            reflectionPrompt = "When you feel anxious about the future, what is usually missing from your present? What could you add to today?"
        ),

        // q029 — Seneca
        "q029" to QuoteInsight(
            intro = "Seneca ends his fourth letter with this line, after reminding Lucilius how little nature asks: enough to keep off hunger, thirst, and cold. It is the extras, he says, that make people sweat, sail to far shores, and grow old chasing. Making peace with having less turns out to be a kind of wealth.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Terms With Less",
                    blockquote = "He who has made a fair compact with poverty",
                    body = "A compact is an agreement freely made, not a defeat. The person who has looked honestly at what they need, and settled on terms with simplicity, has done something no purchase can do. Seneca does not praise misery. He praises the calm of someone who knows that if things were taken away, they could still live well on what nature provides.",
                    bullets = listOf(
                        InsightBullet("Chosen, not forced", "There is a large difference between enduring scarcity reluctantly and choosing simplicity on purpose."),
                        InsightBullet("Fair terms", "The word \"fair\" suggests a settlement that is honest and peaceful, not grudging.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Rich in Enough",
                    blockquote = "He who has made a fair compact with poverty is rich.",
                    body = "Rich here means free from the hunger for more. A person who needs little is hard to threaten, flatter, or buy. Just before this line, Seneca says nature's needs are easily met and ready to hand, and that it is the superfluous things which wear our togas threadbare. Real wealth, in his sense, is having enough and knowing it.",
                    bullets = listOf(
                        InsightBullet("Fewer wants, fewer masters", "Every want you do not need is one less thing others can use to pull you."),
                        InsightBullet("Ready to hand", "Seneca reminds Lucilius that what is enough is usually close by and easy to reach.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "What We Chase",
                rightHeader = "What Nature Asks",
                rows = listOf(
                    "Fine food and drink" to "Enough to end hunger and thirst",
                    "Status and display" to "Warmth and shelter",
                    "Always a little more" to "Contentment with enough"
                )
            ),
            modernApplication = "Pick one comfort you lean on, such as a favorite treat, a convenience, or an upgrade, and go without it for a day or two. Notice that you are fine. Each small proof makes the fear of having less a little quieter.",
            closing = "Make peace with enough, and you will always have it.",
            reflectionPrompt = "Which things do you believe you need to live well? Which are truly necessary, and which are habits you have never questioned?"
        ),

        // q030 — Seneca
        "q030" to QuoteInsight(
            intro = "Seneca is writing about how to hold the good things in life: family, comfort, possessions. He warns against a mind that keeps clutching them in fear of losing them. Such a mind, he says, suffers twice, once in anticipation and again if the loss ever comes.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Clutching the Good",
                    blockquote = "It is tragic for the soul to be apprehensive of the future",
                    body = "The apprehension Seneca describes is the anxious wish that pleasant things stay forever. He notes that such a soul is never at rest; while waiting on the future it loses the present blessings it could enjoy. He even says there is no difference between grief for something lost and fear of losing it. The fear brings the grief early.",
                    bullets = listOf(
                        InsightBullet("Missing the blessing", "Fear of losing a good thing can stop you from enjoying it while you have it."),
                        InsightBullet("Grief in advance", "Seneca says fearing a loss and grieving it come to much the same thing.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Suffering Before the Fact",
                    blockquote = "wretched in anticipation of wretchedness",
                    body = "This phrase captures a double misery: being unhappy now about an unhappiness that may never arrive. Seneca is careful not to recommend carelessness. In the same letter he says to foresee whatever can be foreseen by planning, and to avoid harm where possible. The difference is between preparing with a clear head and living inside a future that has not happened.",
                    bullets = listOf(
                        InsightBullet("Plan, then release", "Do the sensible preparing, then let the outcome rest where it belongs."),
                        InsightBullet("Not indifference", "Seneca wants care and foresight, only without the constant dread.")
                    )
                )
            ),
            modernApplication = "When you catch yourself fearing the loss of something good, do two things. First, take one sensible step to protect it, if there is one. Then turn back to the thing itself and enjoy it today, since today is when you actually have it.",
            closing = "Hold good things with an open hand, and enjoy them while they are here.",
            reflectionPrompt = "What good thing in your life do you hold most anxiously? How might you protect it sensibly and still enjoy it fully today?"
        ),

        // q031 — Seneca
        "q031" to QuoteInsight(
            intro = "Seneca is warning Lucilius against simply repeating what famous teachers said. Those who came before, he writes, are guides, not masters. He will walk the old road, but if he finds a shorter, smoother one he will open it. Truth, he says, is still open to everyone.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Nobody Owns the Truth",
                    blockquote = "Truth lies open for all; it has not yet been monopolized.",
                    body = "Seneca was a Stoic, yet in his early letters he often quotes Epicurus, the founder of a rival school. Here he explains why. No school holds truth as private property. A good idea is worth taking from anywhere, and a famous name does not make a saying true. This frees you to think for yourself while still learning gratefully from others.",
                    bullets = listOf(
                        InsightBullet("Guides, not masters", "Seneca respects earlier thinkers but refuses to treat them as final authorities."),
                        InsightBullet("Good ideas travel", "A wise thought is worth keeping wherever it comes from.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Room for Posterity",
                    blockquote = "there is plenty of it left even for posterity to discover",
                    body = "This is a humble and hopeful thought. Seneca does not believe his age has finished the work of understanding. Those who come later will find what he missed, and that includes you. Truth is not a closed archive to memorize but an open field to keep exploring, and the explorer's job is to look carefully rather than repeat what others found.",
                    bullets = listOf(
                        InsightBullet("Unfinished work", "Understanding is never complete; each generation has its share to find."),
                        InsightBullet("Look, do not just repeat", "Seneca says that one who only follows another discovers nothing and is not even searching.")
                    )
                )
            ),
            modernApplication = "Take one belief you hold mainly because someone respected said it. Look at it fresh: does it match what you have seen yourself? Keep it if it holds, refine it if it does not. Either way, it becomes yours rather than borrowed.",
            closing = "The road of understanding stays open; walk it with your own eyes.",
            reflectionPrompt = "Which of your beliefs have you borrowed without testing? What might you discover if you looked at one of them freshly?"
        ),

        // q032 — Seneca
        "q032" to QuoteInsight(
            intro = "Seneca opens this letter by telling Lucilius something personal: he feels himself changing at a deep level. In the same breath, he refuses to declare the work finished. The fact that he can now see his remaining faults, he says, is itself proof that he is improving.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "More Than Reform",
                    blockquote = "I feel, my dear Lucilius, that I am being not only reformed, but transformed.",
                    body = "Reform adjusts behavior; transformation changes the person doing the behaving. Seneca, writing late in life, says he feels the deeper kind happening. He shares it with Lucilius because he wants his friend to have it too. The letter goes on to say that true friendship grows when friends share what is good, and that he wants to pass this change along.",
                    bullets = listOf(
                        InsightBullet("Deeper than habits", "Transformation changes what you see and want, not only what you do."),
                        InsightBullet("Shared with a friend", "Seneca tells Lucilius because he wants the good he has found to be shared.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Still Under Construction",
                    blockquote = "I do not yet, however, assure myself, or indulge the hope, that there are no elements left in me which need to be changed.",
                    body = "Right after the hopeful claim comes humility. Seneca does not pretend he is finished. He notes that his new ability to see his own faults is the real sign of progress, much as sick people are congratulated when they perceive that they are sick. Seeing more flaws, in this light, is not a step backward. It is clearer eyesight.",
                    bullets = listOf(
                        InsightBullet("Clearer eyesight", "Noticing more of your faults can mean you are seeing better, not doing worse."),
                        InsightBullet("Progress without pride", "Real growth can feel hopeful and still stay honest about what is left.")
                    )
                )
            ),
            modernApplication = "When you notice a flaw you used to miss, try saying: I can see this now, which is progress. Then pick one small adjustment rather than a sweeping vow. Growth tends to come through steady changes you can actually keep.",
            closing = "Seeing your faults more clearly is often the first sign you are changing.",
            reflectionPrompt = "In what way have you truly changed in the past year? What part of you do you now see that still needs work?"
        ),

        // q033 — Seneca
        "q033" to QuoteInsight(
            intro = "Seneca quotes the Roman poet Vergil, whose hero Aeneas says no new form of trouble can surprise him, because he has surveyed everything in advance. Then Seneca draws the lesson: a trouble you have already considered loses much of its force when it arrives.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Thinking It Through Beforehand",
                    blockquote = "If an evil has been pondered beforehand",
                    body = "The Stoics practiced imagining setbacks ahead of time: a plan falling through, a harsh word, a loss. This is not gloom. It is a rehearsal, so the mind has already walked the ground once. Seneca notes that the wise person lightens troubles by long reflection, while others can only lighten them by long endurance after the fact.",
                    bullets = listOf(
                        InsightBullet("Rehearsal, not dread", "Considering a hard possibility calmly is different from worrying about it."),
                        InsightBullet("Reflection over endurance", "The prepared mind does in advance the adjusting that others must do while suffering.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Softer Blow",
                    blockquote = "the blow is gentle when it comes",
                    body = "Seneca observes that much of what makes trouble hard is its novelty. To the unprepared, each event comes in a new and sudden form. People endure hardships more bravely once they have grown used to them. Pondering in advance gives you some of that familiarity before the event, so when it comes, it lands on ground that is ready.",
                    bullets = listOf(
                        InsightBullet("Novelty hurts", "A large part of distress comes from surprise, which preparation removes."),
                        InsightBullet("Familiar ground", "Having considered a difficulty once, you meet it as something known.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Unprepared Mind",
                rightHeader = "The Prepared Mind",
                rows = listOf(
                    "Trouble arrives as a shock" to "Trouble arrives as something known",
                    "Novelty adds to the pain" to "Familiarity softens the blow",
                    "Eased by long endurance" to "Eased by long reflection"
                )
            ),
            modernApplication = "Before an important day, take a minute to picture what might go wrong and how you would respond: a late start, a hard question, a no. Keep the tone calm and practical. Then set the picture aside and go about your day, a little better prepared.",
            closing = "What you have met in thought arrives already half-tamed.",
            reflectionPrompt = "What difficulty would you like to meet more calmly if it came? How would you want to respond, thinking it through now?"
        ),

        // q034 — Epictetus
        "q034" to QuoteInsight(
            intro = "Epictetus warns anyone setting out to live by philosophy that friends may laugh. People will say you have suddenly turned philosopher and ask where you got your superior look. His advice is twofold: do not actually put on a superior look, and hold steady to what seems best.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Expect the Laughter",
                    blockquote = "If you desire philosophy, prepare yourself from the beginning to be ridiculed",
                    body = "Changing how you live tends to unsettle people who knew the old you. Choosing calm over outrage, or moderation over excess, can look strange or even pretentious to others. Epictetus does not say this to discourage you. He says it so it does not catch you off guard. Knowing the teasing is likely makes it easier to bear when it comes.",
                    bullets = listOf(
                        InsightBullet("Change unsettles", "When you shift your habits, others may react to the change rather than to you."),
                        InsightBullet("Forewarned", "Expecting some ridicule takes away its power to surprise and shake you.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Superior Air",
                    blockquote = "to expect that many will sneer at you",
                    body = "Epictetus adds an important condition: do not give them a reason. Do not take on a lofty, superior look. Philosophy is for changing yourself, not for looking down on others. Hold quietly to what seems best, as one appointed by God to this station. If you remain steady, he says, the same people who sneered will come to admire you.",
                    bullets = listOf(
                        InsightBullet("Practice quietly", "The goal is to live better, not to advertise it or lecture others."),
                        InsightBullet("Steadiness wins", "Epictetus notes that those who mock at first often come to respect consistency.")
                    )
                )
            ),
            modernApplication = "If someone teases you for a new habit, such as reading philosophy, declining a drink, or staying calm in an argument, let it pass with good humor. Do not defend or preach. Simply keep doing it, and let consistency speak over time.",
            closing = "Keep to your path quietly; let the sneers tire themselves out.",
            reflectionPrompt = "Is there a change you have held back from because you feared how others would react? What would steady, quiet persistence look like?"
        ),

        // q035 — Marcus Aurelius
        "q035" to QuoteInsight(
            intro = "Marcus finds satisfaction not in pleasure or praise but in doing what a human being is made to do. He then lists those works: being kind to others, not being ruled by the senses, judging appearances fairly, and taking a wide view of the world and its workings.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Where Satisfaction Lives",
                    blockquote = "It is satisfaction to a man",
                    body = "We often look for satisfaction in rewards: the bonus, the praise, the finished vacation. Marcus locates it somewhere quieter. A craftsman feels it in work done well, and a person feels it in living as a person should. The good feeling comes from doing your proper work, not from what you receive afterward, which makes it available on ordinary days.",
                    bullets = listOf(
                        InsightBullet("The work itself", "Satisfaction, for Marcus, comes from acting well rather than from what follows."),
                        InsightBullet("Ordinary days", "Since the work is always available, so is the satisfaction.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Human's Proper Work",
                    blockquote = "to do the proper works of a man",
                    body = "Marcus spells out these works right after this line. Be benevolent to your own kind. Do not be driven by every movement of the senses. Form a just judgment of appearances that seem convincing. Take a survey of the nature of the universe and what happens in it. Kindness, self-command, clear judgment, wide perspective: a short job description for a human life.",
                    bullets = listOf(
                        InsightBullet("Four tasks", "Kindness, self-command, sound judgment, and a wide view of the world make up Marcus's list."),
                        InsightBullet("Fit for anyone", "None of these works requires a title or special talent, only attention.")
                    )
                )
            ),
            modernApplication = "Tonight, look back at your day through Marcus's four tasks: was I kind, did I command my impulses, did I judge fairly, did I see the bigger picture even once? Note which went well. Satisfaction often hides in that answer.",
            closing = "The deepest satisfaction is doing the work you were made for.",
            reflectionPrompt = "Which of Marcus's proper works comes most naturally to you, and which least? Where could you practice the harder one this week?"
        ),

        // q036 — Marcus Aurelius
        "q036" to QuoteInsight(
            intro = "This is a thought experiment, and a surprisingly freeing one. Marcus imagines that his life story has already been completed up to today. Whatever time remains is then like an extra portion, to be lived by reason and nature rather than by old habits and worries.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Close the First Chapter",
                    blockquote = "Consider yourself to be dead, and to have completed your life up to the present time",
                    body = "The image is startling, but the aim is gentle. Imagine that the story so far is finished: its mistakes, regrets, and unfinished business belong to a closed account. You no longer have to defend or redo the past. This lets you put down a great deal of weight and begin again with a clear mind, as though the next page were blank.",
                    bullets = listOf(
                        InsightBullet("A closed account", "Treat the past as completed, so it no longer demands constant revisiting."),
                        InsightBullet("Weight set down", "Old regrets and grudges lose their grip once the earlier chapter is done.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Remainder as a Gift",
                    blockquote = "live according to nature the remainder which is allowed you",
                    body = "Whatever time follows is described as allowed: given, not owed. Marcus asks that it be lived according to nature, meaning with reason, justice, and care for others. There is a lightness in this. If every day ahead is an extra portion, you can spend it on what matters rather than on what you were merely in the habit of doing.",
                    bullets = listOf(
                        InsightBullet("Allowed, not owed", "Seeing the time ahead as granted makes it easier to treat with care."),
                        InsightBullet("Fresh and deliberate", "Each day after the line is drawn can be lived on purpose, not on autopilot.")
                    )
                )
            ),
            modernApplication = "Try this tonight: write one line that closes your story so far, such as \"That chapter is done.\" Then write one line describing how you will live the first hour of the new one tomorrow. Keep it simple and concrete.",
            closing = "Draw a line under the past, and every day after it is a gift.",
            reflectionPrompt = "If the story so far were complete, what would you stop carrying? How would you spend tomorrow as the first day of what remains?"
        ),

        // q037 — Marcus Aurelius
        "q037" to QuoteInsight(
            intro = "This is one of Marcus's shortest and most complete notes. It names three things: how you judge, how you act, and how you receive what happens. Get these right in the present, he says, and nothing more is needed. The word \"present\" appears three times.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Judge Well, Act for Others",
                    blockquote = "Your present opinion founded on understanding, and your present conduct directed to social good",
                    body = "The first two parts concern your mind and your hands. An opinion founded on understanding means seeing this situation clearly, not through haste or fear. Conduct directed to social good means acting in a way that helps the people around you. Neither requires a grand plan. Both are about what you are thinking and doing right now.",
                    bullets = listOf(
                        InsightBullet("Clear seeing", "Base today's judgment on what you actually understand, not on assumptions."),
                        InsightBullet("Hands for others", "Let what you do in this moment serve the common good, even in small ways.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Content, and Enough",
                    blockquote = "your present disposition of contentment with everything which happens: that is enough",
                    body = "The third part is about how you receive events: with contentment rather than complaint. Then comes the striking conclusion: that is enough. Not enough for now, or enough until something better comes. Simply enough. Marcus releases himself from the endless sense that a good life needs more achievement, more time, or more certainty.",
                    bullets = listOf(
                        InsightBullet("Receiving well", "Contentment means meeting what happens without wishing it were otherwise."),
                        InsightBullet("Permission to stop", "\"That is enough\" frees you from the constant feeling that you must add more.")
                    )
                )
            ),
            modernApplication = "Use this as a three-part check at any point in the day: Am I seeing this clearly? Is what I am doing helping others? Am I at peace with what is happening? If the answers are yes, let that be enough, and let the restless urge for more quiet down.",
            closing = "Three things done well in the present, and nothing is missing.",
            reflectionPrompt = "Of the three, clear judgment, helpful action, and contentment, which is hardest for you right now? What would make it easier today?"
        ),

        // q038 — Marcus Aurelius
        "q038" to QuoteInsight(
            intro = "Marcus credits this saying to Monimus, a Cynic philosopher (the Cynics were known for blunt speech and plain living). He adds a careful note: the saying is useful if you take from it what is true. It is a short reminder that much of what weighs on you is your view of things.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Reminder to Keep",
                    blockquote = "Remember that all is opinion.",
                    body = "Marcus did not need to learn this; he needed to remember it. That is the point of many of his notes. Under pressure, we forget that our reactions depend on how we see things. The word \"remember\" turns the idea into a habit: something to call up in the middle of a hard moment, not just to agree with on a calm afternoon.",
                    bullets = listOf(
                        InsightBullet("Recall, not discovery", "Wisdom often fails not because we never learned it but because we forget it in time."),
                        InsightBullet("Call it up", "Treat the line as a cue to recall when a moment starts to feel heavy.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Taking What Is True",
                    blockquote = "all is opinion",
                    body = "Marcus does not mean that nothing is real or that facts do not matter. He says the use of the saying is plain if you receive it as far as it is true. Events happen. But their meaning to you, whether disaster, setback, or nothing much, depends a great deal on your judgment. That part is yours to examine and adjust.",
                    bullets = listOf(
                        InsightBullet("Not denial", "Facts remain facts; what shifts is the meaning and weight you give them."),
                        InsightBullet("As far as it is true", "Marcus asks you to take the saying sensibly, not to stretch it into nonsense.")
                    )
                )
            ),
            modernApplication = "When you catch yourself saying something is terrible or ruined, add the words \"in my opinion\" and say it again. Notice whether the sentence still feels as heavy. Then decide whether that opinion deserves to stay.",
            closing = "Facts are given; their weight is something you assign.",
            reflectionPrompt = "What situation feels heaviest to you right now? How much of that weight is the fact itself, and how much is your view of it?"
        ),

        // q039 — Marcus Aurelius
        "q039" to QuoteInsight(
            intro = "This comes from a long list Marcus wrote to help himself handle anger at others. As the seventh point, he notes that other people's acts come from their own minds. What actually disturbs you is your opinion of those acts, and when that opinion is set aside, the anger goes with it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Their Acts, Their Minds",
                    blockquote = "It is not men's acts which disturb us, for those acts have their foundation in men's ruling principles",
                    body = "The ruling principle is the Stoic term for a person's guiding mind, the part that judges and decides. Marcus points out that what others do grows out of their minds, their beliefs and habits, and those belong to them. You cannot reach in and fix them. Seeing this is not resignation. It simply places their actions where they belong: with them.",
                    bullets = listOf(
                        InsightBullet("Ruling principle", "The Stoic name for the mind's guiding part, the source of each person's choices."),
                        InsightBullet("Where acts belong", "Other people's actions come from their minds, which are theirs to govern, not yours.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Part You Hold",
                    blockquote = "it is our own opinions which disturb us",
                    body = "If their acts are theirs, the disturbance must come from something closer: your judgment that the act is a grievous wrong. Marcus advises dismissing this judgment, and says the anger will go with it. He asks himself how, and answers that no wrongful act of another brings shame on you. Your character remains in your own hands.",
                    bullets = listOf(
                        InsightBullet("No shame transferred", "Marcus reminds himself that another person's wrong does not disgrace the one it is done to."),
                        InsightBullet("Anger follows judgment", "Set down the opinion that you have been gravely wronged, and the anger has less to stand on.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Blaming the Act",
                rightHeader = "Examining the Opinion",
                rows = listOf(
                    "\"They ruined my day\"" to "\"I judged their act as ruinous\"",
                    "Their act is in their control" to "My opinion is in mine",
                    "Anger lingers" to "Anger can be set down"
                )
            ),
            modernApplication = "The next time someone's behavior irritates you, quietly name the opinion you are forming, such as \"this is an insult\" or \"this is unfair to me.\" Then ask whether the act really touches your character. Often the anger shrinks once the opinion is out in the open.",
            closing = "Others steer their own acts; you steer what you make of them.",
            reflectionPrompt = "Whose behavior bothered you most recently? What opinion did you form about it, and what happens to your anger if you set that opinion aside?"
        ),

        // q040 — Marcus Aurelius
        "q040" to QuoteInsight(
            intro = "Marcus compares a mind free from passions to a citadel, the fortified high point of an ancient city where people withdrew when attacked. The ruling faculty, he says, is invincible when it gathers itself and refuses to do what it has not chosen. No refuge is safer.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "High Ground of the Mind",
                    blockquote = "The mind which is free from passions is a citadel",
                    body = "Passions, for the Stoics, were disturbances such as runaway fear, anger, or craving, reactions that overpower judgment. They did not mean every feeling. A mind clear of those disturbances can still feel warmth and care, but it is not stormed by every alarm. Like a citadel above the city, it holds the high ground while trouble moves below.",
                    bullets = listOf(
                        InsightBullet("What passions meant", "The Stoic word refers to overwhelming disturbances, not to every feeling or emotion."),
                        InsightBullet("Holding high ground", "A calm mind can watch trouble without being taken over by it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Refuge You Carry",
                    blockquote = "man has nothing more secure to which he can fly for refuge and for the future be inexpugnable",
                    body = "Inexpugnable is an old word for impossible to take by force. Marcus wrote some of these notes while on military campaign, so the image of a stronghold came naturally. This refuge goes wherever you go. He adds that whoever has not seen this is ignorant, and whoever has seen it and does not fly to it is unhappy. Knowing is not enough; you have to go there.",
                    bullets = listOf(
                        InsightBullet("Impossible to storm", "Inexpugnable means a place no attack can capture, which is how Marcus saw a calm mind."),
                        InsightBullet("Use the refuge", "Marcus says that knowing about this refuge without using it leaves a person unhappy.")
                    )
                )
            ),
            modernApplication = "When pressure builds today, take a breath and silently say: back to the citadel. Pause before acting, and ask what you actually choose to do, rather than what the alarm is pushing you toward. Then act from there.",
            closing = "Whatever storms the walls below, the high ground of a calm mind stays yours.",
            reflectionPrompt = "What most easily storms your mind: fear, anger, or craving? What helps you climb back to calm when it does?"
        ),

        // q048 — Seneca
        "q048" to QuoteInsight(
            intro = "In a letter full of careful argument, Seneca pauses to define bravery. He clears away three counterfeits first, then gives the Stoic answer: courage is a kind of knowledge, the ability to see what is truly bad and what only looks bad.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Three Counterfeits of Courage",
                    blockquote = "Bravery is not thoughtless rashness, or love of danger, or the courting of fear-inspiring objects",
                    body = "Each counterfeit looks bold from the outside. Rashness acts before thinking. A love of danger seeks the thrill rather than the good. Courting frightening things turns fear into a performance. Seneca rejects all three because none of them rests on understanding. Right after this line he adds that bravery takes the greatest care of itself. Real courage is never careless.",
                    bullets = listOf(
                        InsightBullet("Loud is not brave", "Taking risks in order to be seen taking risks is a craving for attention dressed up as courage."),
                        InsightBullet("Courage takes care", "A brave person protects what matters and does not throw themselves at danger for no reason.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Knowing What Can Harm You",
                    blockquote = "it is the knowledge which enables us to distinguish between that which is evil and that which is not",
                    body = "For the Stoics, the only true evil is a bad choice: cowardice, cruelty, dishonesty. Pain, loss, and embarrassment feel terrible, but they cannot make you a worse person. Once you really know this, fear loosens, because many of the things that frighten you are not truly bad. Courage then is less a surge of nerve and more a clear view of what is actually at stake.",
                    bullets = listOf(
                        InsightBullet("Sort the threats", "Ask whether a feared outcome would damage your character or only your comfort."),
                        InsightBullet("Clarity calms", "Much of what we call courage is simply seeing a situation accurately and then acting on it.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "What Bravery Is Not",
                rightHeader = "What Bravery Is",
                rows = listOf(
                    "Thoughtless rashness" to "Clear judgment under pressure",
                    "Love of danger" to "Facing what truly matters",
                    "Courting frightening things" to "Knowing what is truly bad"
                )
            ),
            modernApplication = "Before a hard choice, ask two questions: what is the worst that could happen, and would that worst thing make me a worse person? If the answer is no, the fear is about comfort, not about harm. Let that knowledge, not adrenaline, carry you forward.",
            closing = "Courage is seeing clearly what can and cannot hurt you.",
            reflectionPrompt = "What do you fear right now that might feel bad but could not make you a worse person? How would you act if you truly believed that?"
        ),

        // q041 — Marcus Aurelius
        "q041" to QuoteInsight(
            intro = "Marcus opens this note with a plain fact and a practical conclusion. Since no one knows how much time remains, every act and thought should be one you would be content to have as your last. He goes on to reason that there is nothing in this to be afraid of.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Uncertain Time",
                    blockquote = "Since it is possible that you may depart from life this very moment",
                    body = "Marcus states this calmly, as a fact to be used rather than feared. No one has a guaranteed amount of time. Most of us know this but live as if we did not. The thought is not meant to darken the day. It sharpens it, the way knowing a visit is short can make a conversation more honest and attentive.",
                    bullets = listOf(
                        InsightBullet("A fact to use", "The uncertainty of time is a tool for clarity, not a reason for fear."),
                        InsightBullet("Sharper attention", "Knowing time is not guaranteed tends to make what you do now more deliberate.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Every Act Counts",
                    blockquote = "regulate every act and thought accordingly",
                    body = "The instruction covers both acts and thoughts. It asks you to let each one be something you would be at peace with if it were final. That rules out much petty resentment, careless speech, and postponed kindness. It also brings a quiet courage: a person who lives each moment this way has little left to fear about what comes next.",
                    bullets = listOf(
                        InsightBullet("Acts and thoughts", "Marcus includes the inner life too, so resentments and grudges are worth setting down."),
                        InsightBullet("Quiet courage", "Living each moment well removes much of the fear about what lies ahead.")
                    )
                )
            ),
            modernApplication = "Before sending a sharp message or brushing someone off today, pause and ask: would I be at peace if this were the last thing I did? If not, change it, even slightly. Let the question guide small choices, not only big ones.",
            closing = "Live each hour so it could stand as your final word.",
            reflectionPrompt = "What would you do differently today if you treated each act as one you would be content to end on? What thought would you set down?"
        ),

        // q042 — Marcus Aurelius
        "q042" to QuoteInsight(
            intro = "Marcus sums up moral perfection in a single sentence. It is not about grand deeds. It is about the quality of each ordinary day: living it as if it were the last, keeping an even keel, neither frantic nor sluggish, and never pretending to be what you are not.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Every Day as the Last",
                    blockquote = "The perfection of moral character consists in this, in passing every day as the last",
                    body = "Passing a day as the last does not mean frantic activity or dramatic farewells. It means treating the day as complete and worth doing well: no postponing the important, no saving kindness for later, no squandering hours on what does not matter. A day lived this way is whole in itself, whatever comes after it.",
                    bullets = listOf(
                        InsightBullet("Not frantic", "Living as if it were the last day means care and focus, not a rush to cram things in."),
                        InsightBullet("Whole in itself", "Each day can be lived fully enough that it needs nothing added.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Even Keel",
                    blockquote = "in being neither violently excited nor torpid nor playing the hypocrite",
                    body = "Marcus names three ways to go wrong. Being violently excited means being swept up by agitation or overeagerness. Being torpid means sluggish and dull, going through the motions. Playing the hypocrite means acting a part that is not true to you. Between these lies a steady, awake, honest way of being, which is what he calls the perfection of character.",
                    bullets = listOf(
                        InsightBullet("Neither storm nor stupor", "Avoid both frantic agitation and dull indifference; aim for awake steadiness."),
                        InsightBullet("No masks", "Being the same honest person throughout the day is part of living it well.")
                    )
                )
            ),
            modernApplication = "Check yourself at midday with three quick questions: Am I agitated? Am I numb? Am I pretending? If one answer is yes, take a slow breath, return to the task at hand, and carry on as yourself, steady and honest.",
            closing = "Steady, awake, and honest: a day lived so needs nothing more.",
            reflectionPrompt = "Which tempts you most: agitation, sluggishness, or pretending? What would a day free of all three look like for you?"
        ),

        // q043 — Marcus Aurelius
        "q043" to QuoteInsight(
            intro = "Marcus compares two kinds of skill. A dancer performs steps that were planned in advance, while a wrestler has to answer whatever the other person does next. Life, he says, asks for the second kind: a readiness that holds when the plan falls apart.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not a Rehearsed Routine",
                    blockquote = "The art of life is more like the wrestler's art than the dancer's",
                    body = "A dance can be learned to perfection because the music and the steps stay the same. Life rarely offers that. The phone call, the sharp word, the change of plans all arrive without a cue. Marcus is not dismissing grace or order. He is saying that the skill worth building is the one that still works when nothing goes as scripted.",
                    bullets = listOf(
                        InsightBullet("Scripts break", "Plans are useful, but the day will not always follow them, so your steadiness cannot depend on them."),
                        InsightBullet("Answer, not perform", "The wrestler never asks how a move looks, only what the next sound move is.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Feet Set Before the Shove",
                    blockquote = "it should stand ready and firm to meet onsets which are sudden and unexpected",
                    body = "An onset is an attack, a sudden rush at you. A wrestler does not wait until he is pushed to find his balance; his stance is already low and settled. Marcus wants the mind held the same way, grounded in what it values before the surprise comes, so that the surprise can move events around without moving the person inside them.",
                    bullets = listOf(
                        InsightBullet("Readiness is a stance", "It is built in quiet moments, then simply used when the moment turns rough."),
                        InsightBullet("Expect the unexpected", "Telling yourself each morning that something will go sideways takes much of the shock out of it."),
                        InsightBullet("Firm, not rigid", "A good wrestler bends and shifts. Firmness means keeping your footing, not refusing to move.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Dancer's Art",
                rightHeader = "The Wrestler's Art",
                rows = listOf(
                    "Follows a known routine" to "Meets moves it cannot predict",
                    "Judged on grace and finish" to "Judged on staying upright",
                    "Rehearses one sequence" to "Trains balance for any sequence"
                )
            ),
            modernApplication = "Before a day you expect to be busy, name one likely disruption and decide how you want to meet it. When something sudden happens, let your first move be a breath and the question: where is my footing here? Then respond, rather than perform the reaction you think is expected.",
            closing = "Train for the shove, not for the applause.",
            reflectionPrompt = "What sudden thing knocked you off balance recently, and what would a steadier stance have looked like?"
        ),

        // q044 — Epictetus
        "q044" to QuoteInsight(
            intro = "Epictetus borrows an image from Socrates. Children are terrified by the masks actors wore on stage until they turn one over and see it is only painted material. Many of our fears, he says, are masks of the same kind, frightening only because we have never looked at them closely.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Face Painted to Frighten",
                    blockquote = "What is death? A tragic mask.",
                    body = "Greek tragic masks were made with exaggerated, anguished faces so the back rows could read them. To a child the mask seems alive. Epictetus suggests that what frightens us about mortality is often this painted face, the opinion we lay over the fact, rather than the fact itself. He is not asking you to be cheerful about loss. He is asking you to tell the face apart from the thing.",
                    bullets = listOf(
                        InsightBullet("Fear wears costume", "The dread you feel is often built from images and stories, not from what is actually in front of you."),
                        InsightBullet("Children of a kind", "Epictetus says a child is simply someone without knowledge. Knowledge is what changes the reaction.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Turn It Over in Your Hands",
                    blockquote = "Turn it and examine it. See, it does not bite.",
                    body = "The cure he offers is plain: pick the thing up and look at the back of it. In the same passage he does this with pain too, calling it another mask. Examining a fear means asking what exactly is feared, what is within your power, and what is only a story about the future. Looked at steadily, most masks lose their teeth, and you are free to give your attention to living well today.",
                    bullets = listOf(
                        InsightBullet("Name it exactly", "Vague fears grow, while a fear stated in one clear sentence is usually smaller than it felt."),
                        InsightBullet("Pain is a mask too", "Epictetus applies the same test to pain: turn it, examine it, and see what is really there."),
                        InsightBullet("Calm, not denial", "Looking closely does not pretend loss away; it removes the extra terror we add to it.")
                    )
                )
            ),
            modernApplication = "Pick one fear that has been hovering this week and write it down in a single plain sentence. Then write what part of it is up to you and what part is only imagined. Reading it back, you may find the mask is still there, but it no longer bites.",
            closing = "Most fears are painted faces; turn them around and look.",
            reflectionPrompt = "Which fear in your life have you never actually turned over and examined? What might be on the back of it?"
        ),

        // q045 — Epictetus
        "q045" to QuoteInsight(
            intro = "Epictetus opens a talk on hardship with this line, and his translator adds the word difficulties to make the meaning clear. He goes on to picture God as a wrestling trainer who matches you with a rough young opponent, not to punish you, but so that you can become a champion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trainer's Rough Partner",
                    blockquote = "It is circumstances",
                    body = "Epictetus says a difficulty is like a sparring partner chosen by a good coach. The coach picks someone strong because an easy opponent teaches nothing, and the victory, he adds, is not won without sweat. Seen this way, a hard season is not a sign that something has gone wrong with your life. It is the part of the training where the real work happens.",
                    bullets = listOf(
                        InsightBullet("Chosen opponents", "Treat a difficulty as a partner sent to train you, and ask what skill it is drilling."),
                        InsightBullet("Sweat is the price", "Growth in character, like strength in an athlete, does not come from easy days alone.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What the Test Reveals",
                    blockquote = "which show what men are",
                    body = "The word is show, not make. Difficulty reveals what is already in you: your habits, your values, and how firmly you hold them. That can be humbling, and it is also useful, since you cannot strengthen what you have never seen. Epictetus also warns against being a timid scout, one who sees a shadow and runs home shouting that the enemy is near. Report what is really there.",
                    bullets = listOf(
                        InsightBullet("A fair report", "When trouble comes, describe it as it is, not as the frightened scout would describe it."),
                        InsightBullet("Revealed, then refined", "What hardship shows you about yourself is the starting point for the next round of practice.")
                    )
                )
            ),
            modernApplication = "Next time something goes wrong, ask: if a good coach had arranged this, what would it be training in me? Patience, honesty, steadiness under criticism? Pick one, and treat the situation as a session in that skill rather than as an insult from life.",
            closing = "Trouble is the sparring partner; character is what it brings out.",
            reflectionPrompt = "What did your hardest recent circumstance reveal about you that an easy week never would have?"
        ),

        // q046 — Seneca
        "q046" to QuoteInsight(
            intro = "Seneca offers this as the kind of motto people expect from the Stoics, and he means it. But he adds a careful condition right after: the effort has to be worth it. A good person does not seek danger for its own sake or keep busy merely to be busy.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Courage Without Exposure",
                    blockquote = "No man is brave and earnest if he avoids danger",
                    body = "Bravery that is never tested is only a theory. The motto Seneca quotes begins by saying it is base to flinch under a burden and that you should wrestle with the duties you have taken on. Some tasks cannot be done without exposure: a hard conversation, a stand you must take, work that might fail in public. Avoiding every such moment may feel safe, but it leaves courage unused.",
                    bullets = listOf(
                        InsightBullet("Earnest means serious", "To be earnest is to commit fully, which always carries some risk of loss or embarrassment."),
                        InsightBullet("Worth the danger", "Seneca's condition matters: the risk should serve something honorable, not your pride or restlessness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Growing With the Load",
                    blockquote = "if his spirit does not grow with the very difficulty of his task",
                    body = "This is the more hopeful half. The difficulty is not only something to survive; it is what enlarges the spirit. A task that seemed too much at first can call out a steadiness you did not know you had. Seneca pictures the spirit answering resistance the way a body answers hard work. The harder part of the task is, oddly, the part that makes you equal to it.",
                    bullets = listOf(
                        InsightBullet("Rise to it", "When a task gets harder, let that be a signal to bring more of yourself, not less."),
                        InsightBullet("Purpose over motion", "Seneca says a good man will not be busy merely for the sake of being busy. Choose hard things that matter.")
                    )
                )
            ),
            modernApplication = "Look at one task you have been circling because it feels risky. Ask whether it is truly worthwhile; if it is, take the smallest real step toward it today. Notice afterward whether the difficulty drained you or quietly made you larger.",
            closing = "Let the weight of a worthy task make you grow, not shrink.",
            reflectionPrompt = "Which worthwhile difficulty are you avoiding right now, and what might your spirit become if you stopped avoiding it?"
        ),

        // q047 — Seneca
        "q047" to QuoteInsight(
            intro = "Lucilius has been complaining about his troubles, and Seneca answers gently but firmly. A long life, he says, includes troubles the way a long journey includes dust, mud and rain. Then he asks which Lucilius would choose if a god offered it: a life of easy luxury or a life in a soldier's camp.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Dust and Rain on the Road",
                    blockquote = "Life, Lucilius, is really a battle.",
                    body = "Seneca's point is not grim. He is correcting an expectation. Lucilius wished to live long and also to be spared all ills, and Seneca says those two wishes do not fit together. Trouble is not a sign that life has gone wrong; it is part of what a life is. Once you stop treating every hardship as an injustice, you have more energy left to meet it.",
                    bullets = listOf(
                        InsightBullet("Part of the journey", "Setbacks are the weather of a long life, not proof that you are on the wrong road."),
                        InsightBullet("Drop the double wish", "Wanting a full life with no difficulty in it sets you up to feel cheated every week.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Front-Rank Living",
                    blockquote = "Life, Lucilius, is really a battle.",
                    body = "In the same letter Seneca says that those who climb rough heights and go on hard campaigns are heroes and front-rank fighters, while those who live in idle comfort are safe only because no one bothers with them. The battle here is not about enemies. It is about engagement: standing where the effort is instead of hiding from it. That is where a life becomes worth living.",
                    bullets = listOf(
                        InsightBullet("Not about enemies", "The battle is with circumstance and your own softness, not with other people."),
                        InsightBullet("Choose the camp", "Given the choice, Seneca would take a demanding life with purpose over an easy one without it.")
                    )
                )
            ),
            modernApplication = "When you catch yourself thinking this should not be happening to me, swap it for: this is part of the campaign. Then ask what a good soldier would do next, which is usually something small, practical, and done without complaint.",
            closing = "A full life comes with weather; march on through it.",
            reflectionPrompt = "Where are you still hoping for a long life with no troubles in it? What would change if you expected the campaign?"
        ),

        // q049 — Seneca
        "q049" to QuoteInsight(
            intro = "Seneca writes to Lucilius about the fears that crowd a mind. He reminds his friend that he has already grappled with Fortune and stood his ground. Confidence, he says, cannot come from comfort; it comes from having been knocked down and having got up again.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Untested Is Not Ready",
                    blockquote = "No prizefighter can go with high spirits into the strife",
                    body = "High spirits here means the calm confidence of someone who knows what to expect. A fighter who has never been hit is not confident, only untested, and the first hard blow might break him. Seneca says our powers can only earn our trust after many difficulties have come close to us. You cannot think your way into that trust. You get it by going through things.",
                    bullets = listOf(
                        InsightBullet("Hope versus knowledge", "Feeling sure of yourself before any trial is hope. Trials turn it into knowledge."),
                        InsightBullet("Trust your record", "Recall what you have already come through. That record is evidence you can stand more than you fear.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Downed in Body, Not Spirit",
                    blockquote = "if he has never been beaten black and blue",
                    body = "Seneca's fighter has seen his own blood, felt his teeth rattle, been tripped and thrown, and yet risen each time with more defiance than before. The bruises are not the goal; the rising is. Every setback you recover from becomes part of your strength. This turns old failures into something useful: proof that falling is survivable and that you know how to get up.",
                    bullets = listOf(
                        InsightBullet("Count the risings", "What matters is not how often you were knocked down but that you stood back up."),
                        InsightBullet("Old bruises, new nerve", "Past setbacks, looked at honestly, can steady you before the next contest.")
                    )
                )
            ),
            modernApplication = "Before something daunting, list three hard things you have already come through and how you got back up. Read the list just before you start. It is not a pep talk; it is a fighter's record, and it is yours.",
            closing = "Confidence is a bruise that healed into knowledge.",
            reflectionPrompt = "Which past setback, now healed, quietly made you braver? Where could that experience help you this week?"
        ),

        // q050 — Seneca
        "q050" to QuoteInsight(
            intro = "Seneca writes this after leaving Baiae, a seaside resort famous for its luxury, because he felt such a place softened the spirit. Freedom, he decides, is not the ease that resorts offer. It is a kind of independence from whatever Fortune happens to send.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Answering to No Accident",
                    blockquote = "It means not being a slave to any circumstance, to any constraint, to any chance",
                    body = "Seneca names three masters: circumstance, constraint, and chance. Most of us serve them without noticing. A delayed train ruins a mood, a bad review sinks a week, and luck decides how we feel. Seneca's freedom does not mean controlling these things, which is impossible. It means refusing to let them dictate your character and your peace.",
                    bullets = listOf(
                        InsightBullet("Three masters", "Notice when circumstance, constraint, or chance is quietly deciding how you feel and act."),
                        InsightBullet("Independence", "You cannot rule events, but you can stop letting each event rule you.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Meeting Fortune as an Equal",
                    blockquote = "it means compelling Fortune to enter the lists on equal terms",
                    body = "The lists were the fenced ground where contests were fought. Seneca imagines Fortune not as a tyrant you beg for mercy, but as an opponent you face on level ground. Earlier in the letter he says he refuses to submit to her yoke. The equal terms come from inside: if your good lies in your own choices, Fortune can strike at your possessions but cannot conquer you.",
                    bullets = listOf(
                        InsightBullet("Level ground", "Fortune only has the upper hand when you stake everything on what she controls."),
                        InsightBullet("Beware soft surroundings", "Seneca left a place that weakened him. Notice which comforts make you easier to push around.")
                    )
                )
            ),
            modernApplication = "When something outside your control starts to set your mood, say quietly: you do not get to decide who I am today. Then pick one action that reflects your own values, however small, and do it. That is entering the lists on equal terms.",
            closing = "Freedom is facing Fortune as an equal, not as her servant.",
            reflectionPrompt = "Which circumstance or chance has been acting as your master lately? What would meeting it on equal terms look like?"
        ),

        // q051 — Epictetus
        "q051" to QuoteInsight(
            intro = "Epictetus is speaking about loss and exile. He admits something many teachers skip: a painful impression will arrive whether you want it or not. The work begins after it arrives, in whether you let it grow into a whole story of misery.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Sting You Cannot Stop",
                    blockquote = "When the appearance pains you, for it is not in your power to prevent this",
                    body = "An appearance, for Epictetus, is the first impression a thing makes on the mind: this is terrible, this is unfair. He does not pretend you can block that first sting. Even a wise person feels it. This honesty is a relief. You are not failing at Stoicism when something hurts. You are simply at the start of the exercise, not the end of it.",
                    bullets = listOf(
                        InsightBullet("The first flinch", "The initial pang is natural and not your fault; it is the raw material, not the verdict."),
                        InsightBullet("No shame in feeling", "Expecting to feel nothing sets an impossible standard. Expect to feel, then to answer.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Before It Gathers Strength",
                    blockquote = "contend against it by the aid of reason, conquer it: do not allow it to gain strength",
                    body = "What is in your power is what comes next. Left alone, a painful impression gathers images: what might happen, what you have lost, what others enjoy. Epictetus says that someone sent to Gyara, a small island used as a place of exile, should not keep picturing the pleasures of Rome, but should think how to live well on Gyara. Reason works best early, before the story grows.",
                    bullets = listOf(
                        InsightBullet("Catch it young", "Answer a painful thought in the first minute, before it has gathered a dozen images to support it."),
                        InsightBullet("Live where you are", "Stop feeding the impression with pictures of elsewhere, and ask how to live well in this place.")
                    )
                )
            ),
            modernApplication = "When a painful thought lands, say to yourself: that is an appearance, not the whole truth. Then ask one reasoning question, such as what is actually in my power here. Stop there, before the mind starts building scenes around it.",
            closing = "You cannot stop the sting, but you can refuse to feed it.",
            reflectionPrompt = "Which painful impression have you allowed to grow strong lately? What is one reasonable thought you could answer it with now?"
        ),

        // q052 — Epictetus
        "q052" to QuoteInsight(
            intro = "Epictetus is talking about fever and bodily hardship. A student says philosophy is useless when he is sick. Epictetus replies that this is exactly when it is meant to be used, just as an athlete's training is meant for the day of the contest.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Question for Each Hurt",
                    blockquote = "What then should a man say on the occasion of each painful thing?",
                    body = "Epictetus asks what words should be ready on your lips when pain arrives. He compares the student who abandons philosophy in a fever to a fighter who quits the pancratium, an ancient contest that combined boxing and wrestling, the moment he is struck. Having a sentence prepared matters. In hard moments you rarely invent wisdom; you reach for what you have already stored.",
                    bullets = listOf(
                        InsightBullet("Words in reserve", "Prepare a short phrase in calm times so that it is there when you are hurting."),
                        InsightBullet("Stay in the contest", "Pain is the point at which practice is tested, not the point at which it stops.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "This Is What I Trained For",
                    blockquote = "It was for this that I exercised myself, for this I disciplined myself.",
                    body = "Epictetus imagines God asking for proof that you have trained, eaten sensibly, and obeyed your coach. Now is the time for fever, he says, so bear it well; now is the time for thirst, bear it well. A doctor may forbid you to drink, but no one can stop you from bearing thirst well. The discomfort becomes the occasion your discipline was always aiming at.",
                    bullets = listOf(
                        InsightBullet("Hard days are match days", "Treat a painful stretch as the contest your daily practice has been preparing you for."),
                        InsightBullet("Bearing it well", "You may not control the pain, but how you carry it remains yours.")
                    )
                )
            ),
            modernApplication = "Choose one sentence to keep for hard moments, such as: this is what I practiced for. Use it on small discomforts first, like a cold morning, a long wait, or a headache. When larger pain comes, the sentence will already be worn in.",
            closing = "The hard day is not the end of practice; it is the match.",
            reflectionPrompt = "When pain or illness comes, what do you usually say to yourself? What would you rather have ready to say?"
        ),

        // q053 — Epictetus
        "q053" to QuoteInsight(
            intro = "Epictetus has just said that a tyrant may chain your leg but cannot touch your will. Then he brings the lesson down to earth. Freedom of that kind is not won in grand moments. It is trained on headaches, small losses, and a helper who is slow to bring a bandage.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Practice on Light Weights",
                    blockquote = "We ought to exercise ourselves in small things",
                    body = "Epictetus lists his examples: a pain in the head, a pain in the ear, a slow helper. He does not forbid groaning aloud, he says, only groaning inwardly and crying out that everyone hates you. These small irritations are the training ground. They come often, the stakes are low, and each one is a chance to practice the calm you will need later.",
                    bullets = listOf(
                        InsightBullet("Daily repetitions", "Minor annoyances arrive every day, which makes them the best place to build a habit."),
                        InsightBullet("Low stakes, real gains", "A lost temper over a small thing costs little to correct; that is why it is the place to learn.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Building Toward the Greater",
                    blockquote = "beginning with them to proceed to the greater",
                    body = "No one starts training with the heaviest weight. Epictetus suggests the same progression for character. In the same passage he tells how his iron lamp was stolen, and how he simply resolved to buy an earthen one. The person who can stay even-tempered over a lamp is slowly preparing for real loss. Large tests do not ask for a new skill, only the same one, practiced long enough to hold.",
                    bullets = listOf(
                        InsightBullet("Same muscle", "Patience with a slow line is the same patience you will want on a truly hard day."),
                        InsightBullet("Earn the next step", "Let steadiness in small matters become the base for facing larger ones.")
                    )
                )
            ),
            modernApplication = "Pick one small, recurring irritation, such as traffic, a slow app, or a noisy neighbor, and decide to use it as practice this week. Each time it happens, notice your reaction and choose a calmer one. Keep a quick tally if it helps.",
            closing = "The small annoyance is the gym; the larger trial is the meet.",
            reflectionPrompt = "Which minor irritation could become your training ground this week? What larger challenge might that practice prepare you for?"
        ),

        // q054 — Marcus Aurelius
        "q054" to QuoteInsight(
            intro = "Marcus writes this as a steadying reminder to himself. He goes on to note that other people face the same troubles and stay firm, sometimes from wisdom and sometimes from mere pride. It would be a shame, he says, if ignorance and conceit proved stronger than wisdom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Singled Out",
                    blockquote = "Nothing happens to any man",
                    body = "The first words place your trouble among everyone else's. Whatever you are facing has been faced before by people no stronger than you. Marcus notices that some of them stay calm simply because they do not notice what happened, or because they want to look brave. If those weaker motives can hold a person steady, he reasons, a clear understanding surely can.",
                    bullets = listOf(
                        InsightBullet("Shared ground", "Your hardship is human, not a special sentence passed against you."),
                        InsightBullet("Better reasons", "If others endure for the sake of appearance, you can endure for the sake of what is right.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Built to Carry It",
                    blockquote = "which he is not formed by nature to bear",
                    body = "This is not a promise that life will be easy. It is a claim about capacity. The Stoics believed nature gave human beings reason precisely so they could meet what happens. That does not mean you will bear it without pain, or alone. It means that within you there is a way to carry this with dignity, even if you have not found it yet.",
                    bullets = listOf(
                        InsightBullet("Capacity, not ease", "Being able to bear something does not mean it will be light, only that it need not undo who you are."),
                        InsightBullet("Look for the handle", "Ask what in you is suited to this moment: patience, honesty, care for others, humor.")
                    )
                )
            ),
            modernApplication = "When something feels unbearable, change the question from why me to what in me can meet this. Name one inner resource you have used before, and lean on it for the next hour, not for the whole future.",
            closing = "Whatever comes, there is something in you shaped to meet it.",
            reflectionPrompt = "What are you facing that feels beyond you? What capacity have you already shown that might be enough for the next step?"
        ),

        // q055 — Marcus Aurelius
        "q055" to QuoteInsight(
            intro = "Marcus uses an image from the dyer's vat. Cloth left in dye takes on its color, and a mind left in certain thoughts takes on their character. He then gives himself an example to dye with: wherever a person can live, there they can also live well.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What the Mind Soaks In",
                    blockquote = "Such as are your habitual thoughts, such also will be the character of your mind",
                    body = "The key word is habitual. A single passing thought does little, but the thoughts you return to every day shape who you become. Resentment rehearsed each morning grows into a resentful character, and gratitude rehearsed grows into a grateful one. Marcus is telling himself that character is not fixed by birth or rank. It is built, slowly, out of what he lets his mind dwell on.",
                    bullets = listOf(
                        InsightBullet("Repetition shapes", "The thoughts you replay most often are quietly becoming your temperament."),
                        InsightBullet("Character is built", "You are not stuck with your mind as it is; its color can change over time.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Dyer's Vat",
                    blockquote = "for the soul is dyed by the thoughts",
                    body = "Dye does not coat cloth; it sinks into the fibers. Marcus sees thoughts working the same way, which is both a warning and an invitation. He follows the line by choosing what to dye with: a good life is possible anywhere, even in a palace, which for an emperor was a real test. Choosing your recurring thoughts is like choosing the color of your days.",
                    bullets = listOf(
                        InsightBullet("Choose the dye", "Pick a few thoughts worth soaking in and return to them on purpose."),
                        InsightBullet("Even in a palace", "Marcus reminds himself that one can live well in any setting, including the distracting one he lived in.")
                    )
                )
            ),
            modernApplication = "Choose one sentence to dye your mind with this week, for example: wherever I am, I can live well here. Repeat it at a set time each day, on your commute or while the kettle boils. Notice whether its color starts to show.",
            closing = "Your days take the color of the thoughts you soak in.",
            reflectionPrompt = "What thought have you been steeping in most often lately? What color is it giving your mind?"
        ),

        // q056 — Marcus Aurelius
        "q056" to QuoteInsight(
            intro = "Marcus has just grumbled about people who play at politics and philosophy for show. Then he turns the point on himself: do what is needed now, quietly. He adds that he should not wait for the ideal state Plato described in his Republic, but be content when even a small thing goes well.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What This Hour Asks",
                    blockquote = "Do what nature now requires.",
                    body = "For Marcus, nature means both the order of the world and his own nature as a rational, social being. What it requires is usually close at hand: the letter to answer, the person to listen to, the honest decision to make. The word now matters. He is not drafting a plan for a better life. He is pointing at the next sound action and telling himself to begin it.",
                    bullets = listOf(
                        InsightBullet("Close at hand", "The duty of the moment is usually ordinary and nearby, not grand or far away."),
                        InsightBullet("Now, not someday", "Waiting for ideal conditions is simply another way of not acting.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Audience Required",
                    blockquote = "Set yourself in motion, if it is in your power, and do not look about you to see if any one will observe it.",
                    body = "Two cautions sit inside this sentence. If it is in your power admits limits: do what you can, not what you cannot. Do not look about you warns against acting for an audience. Marcus, an emperor watched by everyone, knew how tempting it is to do good where it will be seen. He ends the note plainly: the work of philosophy is simple and modest.",
                    bullets = listOf(
                        InsightBullet("Within your power", "Start with what you can actually move today and let the rest wait."),
                        InsightBullet("Unwitnessed good", "A kind act no one sees is still complete; the glance around for approval adds nothing.")
                    )
                )
            ),
            modernApplication = "Pick one useful thing you have been postponing and start it in the next ten minutes, without announcing it. If you notice yourself wanting someone to see, smile at that urge and keep going. Let one small thing going well be enough for today.",
            closing = "Begin the needed thing, and let no one need to watch.",
            reflectionPrompt = "What small, useful thing is waiting for you right now? Would you still do it if no one ever knew?"
        ),

        // q057 — Marcus Aurelius
        "q057" to QuoteInsight(
            intro = "Marcus reminds himself to judge every word and deed by whether it fits nature, and then to stop worrying about criticism. Other people, he notes, have their own leading principles and their own paths. His job is to walk straight on along his.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Let Blame Fall Behind",
                    blockquote = "Be not diverted by the blame which follows from any people, nor by their words",
                    body = "Diverted is a traveler's word: turned off the road. Marcus pictures blame and chatter following behind him like noise on a journey. He does not say critics are always wrong. He says their blame should not steer him. People judge by their own standards and moods, and those change. If you let every remark redirect you, you end up walking in circles.",
                    bullets = listOf(
                        InsightBullet("Noise behind you", "Criticism can be heard and weighed without being allowed to take the wheel."),
                        InsightBullet("Their own path", "Others act from their own principles, and you need not live by theirs.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Never Beneath You",
                    blockquote = "if a thing is good to be done or said, do not consider it unworthy of you",
                    body = "This half speaks to a quieter fear: that a good act will make you look foolish, too earnest, or too small. Marcus, an emperor, tells himself that nothing good is beneath his dignity. Apologizing, helping with humble work, saying the kind thing out loud: if it is good, it is worthy. Pride, more than danger, is often what keeps people from doing right.",
                    bullets = listOf(
                        InsightBullet("Pride as a barrier", "Ask whether you are skipping a good act only because it seems beneath you."),
                        InsightBullet("Dignity in plain acts", "A good action carries its own worth, whatever it looks like to others.")
                    )
                )
            ),
            modernApplication = "When you hesitate over a good thing because of what people might say, ask: is it good to do? If yes, do it, and let the comments trail behind. Try it once this week with something small, like being the first to admit a mistake.",
            closing = "If it is good, it is never beneath you.",
            reflectionPrompt = "What good thing have you held back from saying or doing because of how it might look to others?"
        ),

        // q058 — Seneca
        "q058" to QuoteInsight(
            intro = "Writing to his younger friend Lucilius, Seneca observes how many people spend their lives anxiously guarding them. Peace of mind, he suggests, comes from caring more about how you live than about how long, and from holding life with an open hand rather than a clenched one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Anxious Calendar",
                    blockquote = "No man can have a peaceful life",
                    body = "Seneca's concern is peace of mind, the steady calm that lets a person enjoy the present. It is rarely lost to the trouble in front of us and far more often to worry about what might come. In the same sentence he mentions people who think living through many consulships is a great blessing. Rome named each year after its two consuls, its chief officials, so he simply means many years.",
                    bullets = listOf(
                        InsightBullet("Calm needs the present", "Peace grows from attention to today, not from guarding against every tomorrow."),
                        InsightBullet("Years are not the measure", "A life is judged by its quality and character, not by its length alone.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Holding Life Lightly",
                    blockquote = "who thinks too much about lengthening it",
                    body = "The key words are too much. Seneca does not mock care for health or sensible caution. He warns against the clutching that turns all of life into anxious protection. He compares people who cling this way to someone carried down a rushing stream, grabbing at briars and sharp rocks. Held lightly, life becomes something to use well rather than something to hoard.",
                    bullets = listOf(
                        InsightBullet("Care without clutching", "Look after yourself sensibly, then put the worry down and get on with living."),
                        InsightBullet("Use, not hoard", "Spend your days on what matters instead of only keeping them safe.")
                    )
                )
            ),
            modernApplication = "When you notice worry about the future pulling you out of a good moment, say: this hour is the life I have. Then give the hour your full attention, at dinner, on a walk, or in a conversation. Plan sensibly, and stop rehearsing fears once the plan is made.",
            closing = "Peace comes to those who live their days rather than count them.",
            reflectionPrompt = "Where are you guarding your life so carefully that you forget to live it? What would holding it more lightly look like?"
        ),

        // q059 — Seneca
        "q059" to QuoteInsight(
            intro = "Lucilius has been troubled by frequent colds and bouts of fever, and Seneca writes to encourage him. Illness, he says, hampers the body but need not hamper the soul. There is a place for virtue even on a bed of sickness.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Courage Beyond the Battlefield",
                    blockquote = "It is not only the sword and the battle-line that prove the soul alert and unconquered by fear",
                    body = "Roman readers pictured bravery on the battlefield, the soldier holding his place in the line. Seneca widens the picture. A soul can be alert and unconquered by fear in places where no swords are drawn. The real contest is inward, and it can take place anywhere a person faces something hard: at a desk, in a waiting room, or through a sleepless night.",
                    bullets = listOf(
                        InsightBullet("Quiet arenas", "Courage is shown wherever fear is met calmly, not only where others are watching."),
                        InsightBullet("Alert, not loud", "The brave soul in Seneca's sense is awake and steady, not dramatic.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Bravery Under Blankets",
                    blockquote = "a man can display bravery even when wrapped in his bed-clothes",
                    body = "Seneca tells his friend that he has something to do: wrestle bravely with disease. Being patient, not taking it out on others, still thinking and learning while the body is weak: these are real achievements. He even says Lucilius should be his own spectator and seek his own applause, since no crowd gathers at a sickbed. A bedroom can be a place of honor.",
                    bullets = listOf(
                        InsightBullet("Something to do", "Even when you cannot do much, how you bear your condition is meaningful work."),
                        InsightBullet("Your own spectator", "Approve of yourself for the patience that no one else sees.")
                    )
                )
            ),
            modernApplication = "If you are unwell or worn out, choose one small way to carry it well today: a kind word to whoever helps you, a page read, a complaint left unsaid. Count that as courage, because it is.",
            closing = "A sickbed can hold as much bravery as a battlefield.",
            reflectionPrompt = "Where in your quiet, unseen life could you show courage today, even if no one would ever call it that?"
        ),

        // q060 — Epictetus
        "q060" to QuoteInsight(
            intro = "Epictetus speaks to students who want to make real progress. He warns them that caring about inner goodness will often make them look foolish to people who care about money, status, and polish. He asks them to accept that, and to be most suspicious of themselves just when they start to look important.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Willing to Look Foolish",
                    blockquote = "If you would improve, submit to be considered without sense and foolish with respect to externals.",
                    body = "Externals are things outside your will: wealth, status, reputation, possessions. If you stop chasing them as hard as everyone else does, people will think you naive. Epictetus says to accept the label. He explains that it is not easy to keep your will in line with nature and also secure outward things; caring hard for one means neglecting the other.",
                    bullets = listOf(
                        InsightBullet("A price worth paying", "Being thought unambitious is a small cost for keeping your attention on character."),
                        InsightBullet("Two masters", "You cannot fully serve both inner goodness and outward image; one of them will slip.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Distrust the Applause",
                    blockquote = "Wish to be considered to know nothing; and if you shall seem to some to be a person of importance, distrust yourself.",
                    body = "This guards against a quieter danger. When people start to admire you, it is easy to believe them and stop learning. Epictetus asks for the opposite posture: be content to be thought a beginner. A sense of your own importance closes the mind. A student who believes they know nothing keeps listening, keeps questioning, and keeps improving.",
                    bullets = listOf(
                        InsightBullet("Stay a beginner", "Act as if you still have much to learn, because you do."),
                        InsightBullet("Praise as a warning", "When admiration grows, check whether your effort and humility are shrinking.")
                    )
                )
            ),
            modernApplication = "When someone praises you this week, thank them, then ask yourself one honest question: what am I still getting wrong? And when you choose integrity over appearance and someone thinks you foolish for it, let them.",
            closing = "Better to be thought a fool than to stop improving.",
            reflectionPrompt = "Where are you avoiding growth because you want to look sensible or important? What could you learn if you did not mind looking foolish?"
        ),

        // q061 — Marcus Aurelius
        "q061" to QuoteInsight(
            intro = "Marcus often reminds himself that he can withdraw into his own mind at any moment. Here he adds why this retreat brings calm: the ruling part of us is at peace whenever it has acted justly. Tranquility is not a hiding place but the feeling of a clear conscience.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Room You Carry",
                    blockquote = "Retire into yourself.",
                    body = "Marcus had little privacy. As emperor he was surrounded by advisers, petitioners, and soldiers. Yet he believed he could withdraw at any time, not to a country house but into his own judgment. Retiring into yourself means pausing the noise long enough to consult your own reason. It takes no travel, no special place, and only a few moments.",
                    bullets = listOf(
                        InsightBullet("Always available", "You can step inward between meetings, in a line at the store, or in the middle of an argument."),
                        InsightBullet("Not escape", "The point is not to avoid the world but to return to it guided by your own judgment.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Content With Doing Right",
                    blockquote = "The rational principle which rules has this nature, that it is content with itself when it does what is just, and so secures tranquility.",
                    body = "The rational principle which rules is the Stoic name for the guiding part of the mind, the part that judges and decides. Marcus says it has a built-in contentment: when it acts justly, it is at rest. That is why the inward retreat works. You are not looking for comfort there. You are checking whether you have done right, and if you have, peace follows on its own.",
                    bullets = listOf(
                        InsightBullet("Justice brings rest", "Calm is a natural result of fair dealing, not something to chase directly."),
                        InsightBullet("A clear check", "When uneasy, ask whether you have acted justly, and set right what is not.")
                    )
                )
            ),
            modernApplication = "When you feel unsettled today, take thirty seconds and ask one question inwardly: have I acted fairly in this? If yes, let that be enough and return to the day. If not, the restlessness is pointing you to what needs to be set right.",
            closing = "Peace waits wherever you have done what is just.",
            reflectionPrompt = "When did you last feel the quiet that comes from having done the right thing? What brought it about?"
        ),

        // q062 — Marcus Aurelius
        "q062" to QuoteInsight(
            intro = "Marcus ties self-knowledge to knowledge of the world. For the Stoics, the universe is an ordered whole governed by reason, and every person is a part of it. If you misunderstand the whole, you will misunderstand your own place within it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Knowing the Whole",
                    blockquote = "He who does not know what the world is",
                    body = "The Stoics saw the world as a single, rational, connected order in which everything changes and everything belongs. To know what the world is, in this sense, is to see that change is normal, that you share existence with countless others, and that you are part of something larger than your own plans. Marcus thought this understanding was practical, not abstract.",
                    bullets = listOf(
                        InsightBullet("Part of a whole", "You cannot understand your role in isolation, only in relation to everything around you."),
                        InsightBullet("Change is the rule", "A world understood as always changing makes fewer things feel like shocks.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Lost Without a Map",
                    blockquote = "does not know where he is",
                    body = "A person without this understanding is disoriented, like a traveler without a map. Losses feel like betrayals, change feels like injustice, and other people feel like obstacles. Marcus continues that such a person cannot even say what he exists for, and he wonders why anyone would seek praise from people who know neither where they are nor who they are.",
                    bullets = listOf(
                        InsightBullet("Disorientation", "Many daily frustrations come from expecting the world to be something it is not."),
                        InsightBullet("Whose praise?", "Applause from people who are themselves lost is a poor guide for your life.")
                    )
                )
            ),
            modernApplication = "When something frustrates you today, ask: what kind of world am I in? A world of change, of other people with their own aims, and of limits on my control. Seeing that clearly often turns outrage into a simpler question: given this, what is my part?",
            closing = "Know the world, and you will know where you stand in it.",
            reflectionPrompt = "What do you expect from the world that it has never promised you? How would your day feel if you dropped that expectation?"
        ),

        // q063 — Epictetus
        "q063" to QuoteInsight(
            intro = "Epictetus compares life to a play written by someone else. The author decides whether your role is short or long, whether you play a poor man, a lame man, a magistrate, or a private citizen. Your part is to play it well.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Craft in the Assigned Role",
                    blockquote = "This is your duty, to act well the part that is given to you",
                    body = "An actor cannot rewrite the script, but there is still enormous room for skill. Two actors with the same lines can give very different performances. Epictetus applies this to life. Your health, your family, your era, your limits: these are given. How honestly, kindly, and bravely you live inside them is the performance, and that is fully yours.",
                    bullets = listOf(
                        InsightBullet("Room for skill", "Even a small or difficult role can be played with depth and dignity."),
                        InsightBullet("The performance is yours", "You do not own the script, but every choice within it belongs to you.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Who Chooses the Part",
                    blockquote = "but to select the part, belongs to another",
                    body = "For Epictetus the other is God or nature, the author of the whole. Accepting this is not giving up. It means you stop wasting strength resenting the role and spend it on playing it. Resentment says I should have been cast differently. Acceptance says this is my part, so let me do it justice. Only the second can actually improve the play.",
                    bullets = listOf(
                        InsightBullet("Stop auditioning", "Wishing for another life keeps you from fully living the one you have."),
                        InsightBullet("Spend strength wisely", "Energy spent resenting your role is energy taken away from playing it.")
                    )
                )
            ),
            modernApplication = "Name one role you did not choose, such as caregiver, beginner, or the person who has to deliver bad news. Instead of asking why you were cast in it, ask what playing it well would look like today, and do one thing that fits.",
            closing = "You did not write the script, but the performance is yours.",
            reflectionPrompt = "Which part in your life do you keep wishing were different? What would it mean to play that part well, starting this week?"
        ),

        // q064 — Seneca
        "q064" to QuoteInsight(
            intro = "Seneca is preparing to talk with Marcellinus, a friend whose faults he hopes to check. Meanwhile he turns to Lucilius, who has made real progress and understands how far he has come and how far remains. To him Seneca gives three short commands.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Order Before Nerve",
                    blockquote = "Regulate your character, rouse your courage",
                    body = "The order is telling. First regulate your character: put your habits and desires in order. Then rouse your courage. Courage that rests on a disordered character tends to be rash or brittle, while a person whose daily life is steady has firmer ground to stand on when fear arrives. Seneca speaks to Lucilius as someone already on the road, not as a beginner.",
                    bullets = listOf(
                        InsightBullet("Steady first", "Small daily order, in sleep, speech, and spending, gives courage somewhere to stand."),
                        InsightBullet("Rouse it", "Courage often needs waking; it does not always appear on its own.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Facing the Old Terrors",
                    blockquote = "and stand firm in the face of things which have terrified you",
                    body = "Notice the tense: things which have terrified you. Seneca is speaking not of a new threat but of old fears, the ones that have already shaped your choices. Standing firm means turning toward them now that you are stronger. He adds that Lucilius should not count the number of those who inspire fear in him. A fear is often larger in memory than in fact.",
                    bullets = listOf(
                        InsightBullet("Old fears, new you", "You may now be strong enough for what once overwhelmed you."),
                        InsightBullet("Turn and face it", "Standing firm begins with no longer arranging your life around the fear.")
                    )
                )
            ),
            modernApplication = "Think of one situation you have avoided for years because it once frightened you. Ask whether the person you are now still needs to avoid it. If not, take one small step toward it this week, and notice how much smaller it looks up close.",
            closing = "Order your life, wake your courage, then stand where you once fled.",
            reflectionPrompt = "What old fear still shapes your choices? Are you still the same person who first learned to fear it?"
        ),

        // q065 — Seneca
        "q065" to QuoteInsight(
            intro = "Seneca has been mocking a learned debate over whether the virtues are living creatures. Enough of such puzzles, he says; teach me how to become brave. Then he describes bravery not as a theory but as a fortress a person can actually live inside.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Walls Around a Weakness",
                    blockquote = "What is bravery? It is the impregnable fortress for our mortal weakness",
                    body = "Seneca does not pretend humans are strong by nature. We are mortal, breakable, and easily frightened. Bravery is what surrounds that weakness, the way walls surround a town. Impregnable means it cannot be taken by force. Fortune can damage your property, your health, or your plans, but if your courage holds, the citadel inside is not captured.",
                    bullets = listOf(
                        InsightBullet("Honest about weakness", "Courage begins by admitting fragility, not by denying it."),
                        InsightBullet("Walls, not armor", "Bravery is less a weapon for attack than a shelter that lets you stay calm.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Holding Out Through the Siege",
                    blockquote = "he can hold out free from anxiety during life's siege; for he is using his own strength and his own weapons",
                    body = "A siege is long. Seneca pictures life as a series of pressures that do not end quickly. The key is in the last clause: his own strength, his own weapons. He then quotes the Stoic teacher Posidonius, who warned that Fortune does not furnish arms against herself. Money and influence are borrowed weapons. Character is the one no one can take back.",
                    bullets = listOf(
                        InsightBullet("Borrowed weapons", "Wealth and status can be withdrawn by the same Fortune that gave them."),
                        InsightBullet("Your own arsenal", "Judgment, patience, and honesty are tools that remain yours through any siege.")
                    )
                )
            ),
            modernApplication = "When pressure builds, ask what you are relying on. If it is something that could be taken away, such as a title or a bank balance, add something sturdier: a value you will hold to no matter what. Say it aloud once, then act from it.",
            closing = "Build your walls from character; Fortune can neither lend nor recall them.",
            reflectionPrompt = "What are you relying on to feel safe? How much of it is truly your own strength, and how much is borrowed?"
        ),

        // q066 — Seneca
        "q066" to QuoteInsight(
            intro = "Seneca writes during the Saturnalia, Rome's December festival of feasting. He suggests that Lucilius set aside a few days to live on the cheapest food and roughest clothing, asking himself, Is this the condition that I feared? Preparing in calm times makes hard times less frightening.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Maneuvers in Peacetime",
                    blockquote = "If you would not have a man flinch when the crisis comes",
                    body = "Seneca points to the soldier, who drills and throws up earthworks with no enemy in sight, wearing himself out on purpose so that he will be equal to real toil later. Flinching is a reflex born of surprise and unfamiliarity. The crisis itself may be unavoidable. What can be avoided is meeting it as a total stranger.",
                    bullets = listOf(
                        InsightBullet("Familiar ground", "What you have practiced, even a little, frightens you less when it arrives."),
                        InsightBullet("Drill when calm", "The time to prepare is when things are easy and nothing seems urgent.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Rehearsing Want on Purpose",
                    blockquote = "train him before it comes",
                    body = "Seneca's training is concrete: three or four days of hard bread, a coarse cloak, a real pallet to sleep on. He insists it be a true test, not the playacting of rich people who pretend to rough it. The aim is not to suffer, but to discover that what you feared is bearable. After that, the fear of losing comfort loses much of its grip.",
                    bullets = listOf(
                        InsightBullet("A real test", "Make the practice genuine enough to teach you something, not just a game."),
                        InsightBullet("Fear shrinks", "Having lived with less, even briefly, makes the threat of having less much quieter.")
                    )
                )
            ),
            modernApplication = "Choose one comfort you rely on and do without it for a day: eat simply, walk instead of driving, or leave the phone in a drawer for the evening. As you do, ask Seneca's question: is this the condition that I feared? Let the answer steady you.",
            closing = "Meet hardship first on your own terms, and it will not find you a stranger.",
            reflectionPrompt = "Which loss of comfort do you fear most? What small, voluntary rehearsal could show you that it is bearable?"
        ),

        // q067 — Seneca
        "q067" to QuoteInsight(
            intro = "Seneca is careful here. Just before this line he says that work in itself is not a good, and that he would rebuke people who toil to no purpose. But effort aimed at honorable things, pursued without halting, is what keeps a noble mind alive.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Food That Keeps a Mind Alive",
                    blockquote = "Work is the sustenance",
                    body = "Sustenance means nourishment, what keeps a living thing going. Seneca suggests that a mind without worthwhile effort grows weak, as a body does without food. He shouts encouragement to anyone climbing toward something good: rise, draw a fresh breath, and take that hill. The work feeds the mind not because labor is holy, but because striving for good things exercises everything good in us.",
                    bullets = listOf(
                        InsightBullet("Nourishment, not penance", "Worthy effort is something the mind needs, not merely something to endure."),
                        InsightBullet("A fresh breath", "When the climb is steep, pause, breathe, and take the next stretch.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Noble Minds and Empty Toil",
                    blockquote = "of noble minds",
                    body = "The phrase is not every mind. For Seneca, nobility is not a matter of birth but of aim: a mind set on virtue. Such a mind uses work as a means, not a goal. That is why he can say both that work is not a good and that it feeds the noble. Toil without purpose simply exhausts. Effort pointed at what is right strengthens the person doing it.",
                    bullets = listOf(
                        InsightBullet("Aim matters", "Ask what your effort serves. Purpose is what turns strain into nourishment."),
                        InsightBullet("Not endless toil", "Seneca rebukes those who work hard at nothing worthwhile.")
                    )
                )
            ),
            modernApplication = "Look at your to-do list and mark the one task that serves something you truly value. Give it your first and best hour. If something on the list serves nothing at all, consider letting it go.",
            closing = "Feed your mind on effort that points toward the good.",
            reflectionPrompt = "Which of your daily efforts nourishes you, and which only exhausts you? What does the difference tell you?"
        ),

        // q068 — Epictetus
        "q068" to QuoteInsight(
            intro = "Epictetus surprises his listeners. We expect a warning against craving power or money, but he adds that even the desire for leisure, travel, and books can make us subject to others. Anything external, if we value it too highly, hands someone else the key.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Even Quiet Desires Bind",
                    blockquote = "Whatever the external thing may be",
                    body = "The examples he gives are gentle ones: tranquility, leisure, travel, learning. Epictetus imagines someone unhappy because they have no time to read, as if reading were something no one could take away. It can be taken. A crow, a piper, or a fever can interrupt it. Even good things become chains when your peace depends on having them.",
                    bullets = listOf(
                        InsightBullet("Gentle chains", "Noble-sounding wants can enslave you as easily as greed can."),
                        InsightBullet("Who can interrupt it?", "If anything outside you can take it away, it is external, however worthy it seems.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Price Tag Is the Leash",
                    blockquote = "the value which we set upon it places us in subjection to others",
                    body = "The thing does not enslave you; your valuation does. Whoever can give or withhold what you prize gains power over you. This is why Epictetus says that the person who longs to be a senator and the one who longs for quiet reading time can be equally unfree. The way out is not to stop enjoying things but to stop resting your happiness on them.",
                    bullets = listOf(
                        InsightBullet("Your valuation decides", "The grip any external thing has on you comes from the weight you give it."),
                        InsightBullet("Enjoy without depending", "Love good things freely, but do not make your peace a hostage to them.")
                    )
                )
            ),
            modernApplication = "Notice today when an interruption to something you enjoy, such as quiet time or a planned outing, makes you resentful. Ask: have I given this the power to rule my mood? Then let it go for now and return to what is always in your power, your response.",
            closing = "Whatever you prize too highly becomes the leash others hold.",
            reflectionPrompt = "Which good thing, even a gentle one, has quietly gained power over your peace? Who holds that power when it is interrupted?"
        ),

        // q069 — Epictetus
        "q069" to QuoteInsight(
            intro = "Epictetus asks how a person can be calm and still take care, unruffled but not careless. His answer is a game of dice. The counters and the roll are beyond your control and so worth no anxiety, but how you play the roll deserves all your attention.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Pieces Without Worth",
                    blockquote = "The counters are indifferent; the dice are indifferent. How do I know what the cast will be?",
                    body = "Indifferent is a technical Stoic word. It does not mean unimportant. It means neither good nor bad in itself, like money, health, outcomes, and the numbers on the dice. Since you cannot know or control the cast, worrying about it is wasted effort. This removes a weight. You are not responsible for what lands, only for what you do next.",
                    bullets = listOf(
                        InsightBullet("Indifferent, not trivial", "Outcomes can matter to you while still lying outside what makes you good or bad."),
                        InsightBullet("Unknown rolls", "Accept that you cannot predict results, and stop spending your peace on trying.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Playing the Roll Well",
                    blockquote = "But to use carefully and dexterously the cast of the dice, this is my business.",
                    body = "Here is the care that keeps Stoic calm from turning into carelessness. Once the dice have landed, a skilled player thinks hard about the best move. Epictetus says that materials are indifferent but their use is not. You should act carefully because the use matters, and calmly because the material does not. The two attitudes belong together.",
                    bullets = listOf(
                        InsightBullet("Calm and careful", "Detachment from results and full attention to action are partners, not opposites."),
                        InsightBullet("Dexterity", "Bring skill to the situation you actually got, not the one you hoped for.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Dice",
                rightHeader = "The Play",
                rows = listOf(
                    "How they land" to "How you use the result",
                    "Not in my power" to "My business",
                    "Indifferent" to "Handled with care and skill"
                )
            ),
            modernApplication = "When an outcome disappoints you, say: that was the roll. Then ask: what is the most skillful move from here? Put your energy into that move, with real care, and leave the dice alone.",
            closing = "The roll is not yours; the play is.",
            reflectionPrompt = "What roll of the dice are you still arguing with? What would careful, skillful play look like from where you stand?"
        ),

        // q070 — Epictetus
        "q070" to QuoteInsight(
            intro = "Epictetus has just warned against envying people who are honored or powerful. Their status may look like happiness, but it is not. What a wise person wants instead is not a title at all. It is freedom, and there is only one road to it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Different Ambition",
                    blockquote = "You yourself will not wish to be a general or senator or consul, but a free man",
                    body = "General, senator, and consul were the great prizes of Roman public life: command of an army, a seat in the governing council, and the highest elected office. Epictetus, who was born enslaved, had good reason to think hard about what freedom really is. He says the student of philosophy aims elsewhere. Titles are given and taken away by others. Freedom, rightly understood, is not.",
                    bullets = listOf(
                        InsightBullet("Prizes given by others", "Any honor that someone else can bestow, someone else can also remove."),
                        InsightBullet("The real goal", "Aim to be free in judgment and desire rather than high in rank.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "One Road to Freedom",
                    blockquote = "there is only one way to this, to despise the things which are not in our power",
                    body = "Despise is a strong word, and the translator adds the gentler gloss care not for. Epictetus means: stop staking your happiness on things outside your will, such as reputation, office, and other people's decisions. Earlier in the same chapter he says you can be invincible if you enter no contest that you cannot win by your own power.",
                    bullets = listOf(
                        InsightBullet("Care not for", "Release the outcome of what is beyond you, while still doing your own part well."),
                        InsightBullet("Choose your contests", "Enter only contests decided by your own choices, and you cannot be defeated.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "What Others Bestow",
                rightHeader = "What Is Yours",
                rows = listOf(
                    "A general's command" to "Your own judgment",
                    "A senator's seat" to "Your own desires",
                    "A consul's office" to "Your own freedom"
                )
            ),
            modernApplication = "When you feel envy toward someone's position, ask: is what I admire in their power or in their circumstances? Then pick one thing within your own power, such as honesty or patience, and pursue it with the energy envy would have spent.",
            closing = "Let others chase titles; you can aim to be free.",
            reflectionPrompt = "What title or status do you secretly wish for? What kind of freedom would you have if you stopped needing it?"
        ),

        // q071 — Seneca
        "q071" to QuoteInsight(
            intro = "Seneca holds up Cato the Younger, the Roman senator famous for integrity and plain living, as a living example of steadiness. Cato's whole life passed in a time of political upheaval and civil war. Through every shift, Seneca says, Cato remained recognizably himself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "When the State Shifted",
                    blockquote = "No one ever saw Cato change, no matter how often the state changed",
                    body = "In Cato's lifetime the Roman Republic was shaken again and again by powerful men such as Pompey, Caesar, and Crassus. Alliances formed and broke, and many people changed sides as the winds changed. Seneca's point is that Cato's character did not depend on who was in power. His principles were not a reaction to the times; they were his own.",
                    bullets = listOf(
                        InsightBullet("Not a weathervane", "A steady person keeps their values when the surrounding opinion turns."),
                        InsightBullet("Principles of your own", "Convictions you truly hold do not need the approval of the moment.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "One Man in Every Season",
                    blockquote = "he kept himself the same in all circumstances",
                    body = "Seneca lists some of those circumstances: in high office, in electoral defeat, under accusation, governing a province, speaking in public, serving with the army. Success did not puff him up, and failure did not shrink him. Keeping yourself the same does not mean being rigid or never learning. It means your core, your honesty and your care for what is right, holds steady whatever happens.",
                    bullets = listOf(
                        InsightBullet("Same in loss and gain", "Let neither a win nor a setback change how you treat people."),
                        InsightBullet("A steady core", "Growth is welcome, but your basic honesty should not shift with your situation.")
                    )
                )
            ),
            modernApplication = "Think of how you act when things go well and when they go badly. Pick one trait you want to keep constant across both, such as courtesy or honesty, and watch for it this week, especially in the moment something goes wrong.",
            closing = "Be the same person in every kind of weather.",
            reflectionPrompt = "In which circumstances do you become someone you would rather not be? What would staying the same there require?"
        ),

        // q072 — Seneca
        "q072" to QuoteInsight(
            intro = "Seneca again points to Cato the Younger as a living example. Cato once lost an election for praetor, a senior judicial office in Rome, and Seneca says he spent the rest of that day at play. He met far larger political defeats with the same steady heart.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Stout Heart in Defeat",
                    blockquote = "Cato will bear with an equally stout heart anything that thwarts him of his victory",
                    body = "Cato stood with the Republic in Rome's civil war, and his side did not win. Seneca, writing about a century later, does not treat this as a failure of Cato's character. A stout heart is a brave, steady one. Seneca's point is that Cato's courage was the same size whether the stakes were small or enormous, because it rested on his own conduct, not on results.",
                    bullets = listOf(
                        InsightBullet("Victory is not virtue", "A good cause can lose, and its defenders can still have acted rightly."),
                        InsightBullet("Equal courage", "Train the same steadiness for small setbacks as for large ones.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Losing an Election Calmly",
                    blockquote = "as he bore that which thwarted him of his praetorship",
                    body = "A praetor was one of Rome's chief magistrates, ranking just below the consuls, and losing that election was a public blow for an ambitious senator. Seneca says Cato spent the day of his defeat in play. In another letter he says Cato played a game of ball. He was not careless about Rome. He simply refused to let a vote decide his worth.",
                    bullets = listOf(
                        InsightBullet("A game of ball", "Cato's calm after defeat showed that his worth did not rest on the outcome."),
                        InsightBullet("Not careless", "Caring about a cause and being undone by losing it are two different things.")
                    )
                )
            ),
            modernApplication = "Next time you lose something you wanted, such as a promotion, a vote, or a competition, give the rest of the day to something ordinary and pleasant. Not to pretend it does not matter, but to remind yourself that your worth was never on the ballot.",
            closing = "Your worth was never on the ballot.",
            reflectionPrompt = "How do you usually treat yourself after a loss? What would bearing it with a stout heart look like next time?"
        ),

        // q073 — Seneca
        "q073" to QuoteInsight(
            intro = "Seneca lists the lessons that the life of Cato the Younger teaches, each beginning with you see. This first one is about toil. During Rome's civil war, Cato led his troops across the African desert on foot, sharing every hardship with them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Proof That It Can Be Done",
                    blockquote = "You see that man can endure toil",
                    body = "Seneca uses Cato as evidence. When you think a hardship is beyond human strength, a real example answers the doubt: someone has carried this, or something heavier. That is why the Stoics valued examples so highly. A principle tells you endurance is possible, while a life shows you. Seneca goes on in the same vein: you see that thirst can be endured.",
                    bullets = listOf(
                        InsightBullet("Examples teach", "Keep in mind people who have endured hard things; they make your own load seem possible."),
                        InsightBullet("Endurance is human", "The capacity to bear toil belongs to ordinary people, not only to heroes.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Leading on Foot",
                    blockquote = "Cato, on foot, led an army through African deserts.",
                    body = "Seneca adds that Cato marched over sun-baked hills with no supply train, wearing heavy armor, and was always the last to drink at the few springs they found. The detail that matters is on foot. A commander could have ridden. Cato chose to share the hardship of his soldiers. His endurance was not only toughness; it was a form of fairness and leadership.",
                    bullets = listOf(
                        InsightBullet("Share the load", "Leaders earn trust by taking on the same hardships they ask of others."),
                        InsightBullet("Last to drink", "Putting others' needs before your own comfort is endurance with a moral shape.")
                    )
                )
            ),
            modernApplication = "When you lead anything, a team, a family, or a project, look for one hardship you are asking others to bear. Take your share of it yourself, plainly and without speeches. When you are tired, remember that people have walked far harder roads.",
            closing = "Lead from where the walking is hardest.",
            reflectionPrompt = "Whose example of endurance do you keep in mind? Where could you share a hardship instead of handing it to someone else?"
        ),

        // q074 — Epictetus
        "q074" to QuoteInsight(
            intro = "Epictetus notes that people travel to Olympia to see the famous statue of Zeus made by Phidias, and put up with heat, crowds, noise, and rain to do it. If we endure all that for a spectacle, he asks, have we not also been given the strength to endure what life brings?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Gifts Already Given",
                    blockquote = "Have you not received faculties by which you will be able to bear all that happens?",
                    body = "Faculties are capacities: reason, judgment, patience. Epictetus's question is pointed. We complain as if we were helpless, but we already carry the tools. Visitors to Olympia bear sunburn and crowding because the spectacle seems worth it. Life, he suggests, is also a spectacle worth bearing, and we have been equipped for it.",
                    bullets = listOf(
                        InsightBullet("Already equipped", "Before asking for an easier life, take stock of the powers you already have."),
                        InsightBullet("Worth the trouble", "Discomfort is easier to bear when you remember what makes the experience worthwhile.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Answering Yes Each Time",
                    blockquote = "Have you not received greatness of soul? Have you not received manliness? Have you not received endurance?",
                    body = "Greatness of soul means a largeness of spirit that is not easily shaken. Manliness, in this old translation, means courage and steadiness, a quality open to anyone. Endurance is the ability to keep going. Epictetus asks each question so that you will answer yes each time. He then asks why he should trouble himself about anything that can happen, if he possesses greatness of soul.",
                    bullets = listOf(
                        InsightBullet("Answer the questions", "Say yes to each one, and notice how different your situation feels afterward."),
                        InsightBullet("Courage for anyone", "The old word manliness here means steady courage, a capacity every person has.")
                    )
                )
            ),
            modernApplication = "When you catch yourself saying I cannot handle this, ask Epictetus's questions out loud: have I not received patience, courage, endurance? Name one time you used each. Then face the next small part of the problem with that reminder.",
            closing = "You came equipped; open the kit.",
            reflectionPrompt = "Which of your own capacities have you forgotten you possess? How would remembering it change today?"
        ),

        // q075 — Epictetus
        "q075" to QuoteInsight(
            intro = "Epictetus asks what really frightens people. Is it the tyrant and his guards? He answers that it cannot be. A tyrant can chain a leg, but he cannot chain a will. What disturbs us is always our own opinion about what is happening.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Only Hindered From Within",
                    blockquote = "It is not possible that what is by nature free can be disturbed by anything else, or hindered by any other thing than by itself.",
                    body = "What is by nature free, for Epictetus, is the will: your power to judge, choose, and assent. A tyrant can confine your body, take your goods, or threaten you. He cannot reach inside and decide what you value. Epictetus imagines a tyrant threatening to chain a man's leg, and the man replying calmly that if it seems best, the tyrant may chain it.",
                    bullets = listOf(
                        InsightBullet("The free part", "Your judgment and choices are the one region no outside force can enter."),
                        InsightBullet("Bodies can be held", "Possessions and circumstances can be seized; your inner assent cannot.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Opinion Behind the Distress",
                    blockquote = "But it is a man's own opinions which disturb him.",
                    body = "This is one of Epictetus's central teachings. Events happen; distress comes from how we interpret them. The man who values his leg above all begs for pity. The man who values his will above all stays calm. It is a hard teaching and also a hopeful one: if opinions disturb you, opinions can be examined and changed, and that work is yours to do.",
                    bullets = listOf(
                        InsightBullet("Event and opinion", "Separate what happened from what you are telling yourself it means."),
                        InsightBullet("Opinions can change", "A belief that causes distress can be questioned and revised.")
                    )
                )
            ),
            modernApplication = "When you are upset, write two lines: what happened, and what I am telling myself about it. Look hard at the second line. Ask whether it is true, whether it helps, and what a calmer opinion might be.",
            closing = "No tyrant can reach the place where you decide what matters.",
            reflectionPrompt = "What opinion is disturbing you right now, disguised as a fact? What would happen if you questioned it?"
        ),

        // q076 — Epictetus
        "q076" to QuoteInsight(
            intro = "Epictetus describes going out among people with a quiet purpose: to act with modesty and to observe how others speak and behave. He does this not to mock or blame them. Every fault he notices becomes a question about himself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Mirror in Other People",
                    blockquote = "I turn to myself, and ask if I also commit the same faults.",
                    body = "It is easy to watch others and keep a running list of their failings. Epictetus turns the habit inside out. When he sees vanity, impatience, or rudeness, he asks whether it lives in him too. This is not self-punishment. It is a way to learn from everyone you meet, and it quietly removes the pleasure of judging others.",
                    bullets = listOf(
                        InsightBullet("Watch without scorn", "Observe people to learn, not to collect evidence against them."),
                        InsightBullet("Faults are shared", "What irritates you in others is often something you recognize from the inside.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "From Noticing to Changing",
                    blockquote = "How then shall I cease to commit them?",
                    body = "Recognition is only half the work. Epictetus moves at once to the practical question: how do I stop? Right after this line he adds that he once acted wrongly but no longer does, and gives thanks for it. Progress is possible. He also warns that reading philosophy only to explain it to others misses the point; it is meant to be used in action.",
                    bullets = listOf(
                        InsightBullet("Move to how", "Follow every honest self-observation with one concrete change you can try."),
                        InsightBullet("Read to act", "Wisdom is meant to change behavior, not just to be understood or repeated.")
                    )
                )
            ),
            modernApplication = "The next time someone's behavior annoys you, pause and ask: do I ever do this? If the honest answer is yes, pick one small change, like letting others finish speaking, and practice it that day. Judge less, improve more.",
            closing = "Every fault you notice is a lesson addressed to you.",
            reflectionPrompt = "Whose fault irritated you most recently? Is there any trace of the same fault in you, and what could you change?"
        ),

        // q077 — Epictetus
        "q077" to QuoteInsight(
            intro = "Early in the Encheiridion, the short handbook of his teaching, Epictetus offers a simple exercise. Whenever you love something, remind yourself what kind of thing it is. Start, he says, with the smallest things.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Call It by Its Name",
                    blockquote = "If you love an earthen vessel, say it is an earthen vessel which you love",
                    body = "An earthen vessel is a clay pot or jug. Epictetus does not tell you not to love it. He tells you to love it accurately: this is clay, and clay breaks. Naming a thing truly keeps your affection honest. It is the same pot whether you name it or not, but your mind relates to it differently once you have said plainly what it is.",
                    bullets = listOf(
                        InsightBullet("Love accurately", "Enjoy things while keeping in mind their real, breakable nature."),
                        InsightBullet("Begin small", "Epictetus says to start with the smallest things and build the habit from there.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "When the Jug Breaks",
                    blockquote = "for when it has been broken you will not be disturbed",
                    body = "The payoff comes later. If you have been saying all along that this is a clay jug, its breaking confirms what you knew instead of shattering your peace along with it. Disturbance is often the gap between what we thought a thing was and what it turned out to be. Close that gap in advance, and a loss can sting without overturning you.",
                    bullets = listOf(
                        InsightBullet("No false permanence", "Much of our shock comes from quietly assuming that fragile things will last."),
                        InsightBullet("Prepared affection", "You can care deeply about something and still be ready for it to change.")
                    )
                )
            ),
            modernApplication = "Pick one possession you care about, such as a mug, a phone, or a car, and say to yourself as you use it: this is a breakable thing, and I enjoy it. When something does break or wear out, notice how much the habit softens the blow.",
            closing = "Love the jug as a jug, and its breaking will not break you.",
            reflectionPrompt = "What do you love as if it could never break? How might naming its true nature change the way you hold it?"
        ),

        // q078 — Seneca
        "q078" to QuoteInsight(
            intro = "Seneca advises Lucilius to measure every choice against the chief purpose of his whole life. A painter, he says, may have every color ready, but he cannot produce a likeness until he has decided what he wishes to paint.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Mistakes Made in Pieces",
                    blockquote = "The reason we make mistakes is because we all consider the parts of life",
                    body = "Most errors look reasonable in the moment: a job taken only for the money, a remark made to win an argument, an evening lost to something trivial. Each choice made sense as a part. Seneca's diagnosis is that we judge each piece by itself, with no larger picture to check it against. Then the pieces fail to add up to a life we would have chosen.",
                    bullets = listOf(
                        InsightBullet("Reasonable in isolation", "A choice can seem fine by itself and still pull your life off course."),
                        InsightBullet("Pieces add up", "Small decisions, repeated, quietly become the shape of your days.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Seeing the Whole Canvas",
                    blockquote = "but never life as a whole",
                    body = "Seneca follows with two images. The archer must know what he is aiming at. And when a man does not know what harbor he is making for, no wind is the right wind. To see life as a whole is to know your chief aim, the kind of person you want to be, and to measure each choice against it. Then the parts begin to serve something.",
                    bullets = listOf(
                        InsightBullet("Know the harbor", "Without a destination, every wind feels wrong and every choice feels random."),
                        InsightBullet("One aim, many choices", "Hold each decision up to your chief purpose and see whether it fits.")
                    )
                )
            ),
            modernApplication = "Write one sentence describing the person you want your whole life to have made you. Keep it somewhere you will see it. Before a decision today, large or small, read it and ask: does this choice belong in that life?",
            closing = "Choose the harbor first, and the winds start to make sense.",
            reflectionPrompt = "If you looked at your life as a whole, what would you want it to add up to? Which small choice today fits that?"
        ),

        // q079 — Seneca
        "q079" to QuoteInsight(
            intro = "Seneca tells Lucilius that travel and a change of scene will not cure a troubled mind. Better company will: live with great examples such as Cato, Socrates, and Zeno, the founder of the Stoic school. Then he names the one shelter that actually holds against life's storms.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Shelter in Tomorrow",
                    blockquote = "The only harbor safe from the seething storms of this life is scorn of the future",
                    body = "Seneca's harbor is surprising. It is not wealth, a quiet country house, or a well-made plan. It is scorn of the future, which here means refusing to be ruled by what might happen. Much of our storm is worry about tomorrow. A mind that stops borrowing trouble from the future finds a calm that no change of scenery can provide.",
                    bullets = listOf(
                        InsightBullet("Stop borrowing trouble", "Much of the storm lives in tomorrow's imagined problems, not in today's real ones."),
                        InsightBullet("Scenery will not fix it", "A troubled mind travels with you, so steadiness has to be built within.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Facing Fortune's Missiles",
                    blockquote = "a firm stand, a readiness to receive Fortune's missiles full in the breast, neither skulking nor turning the back",
                    body = "The image shifts to a soldier holding his ground. Missiles are thrown weapons, and Fortune throws them at everyone. Seneca's soldier does not hide behind others or run. He faces what comes. This is not recklessness; it is a refusal to waste life in dodging. Facing a difficulty head-on is often less painful than the long unease of avoiding it.",
                    bullets = listOf(
                        InsightBullet("Face it squarely", "Turning toward a problem often shrinks it, while running keeps it growing behind you."),
                        InsightBullet("No skulking", "Avoidance spends more strength than honest engagement does.")
                    )
                )
            ),
            modernApplication = "Pick one problem you have been dodging, such as a bill, a conversation, or a decision, and face it squarely today. Before you start, tell yourself: I will take this full in the breast. Afterward, notice how much lighter the next hour feels.",
            closing = "The safest harbor is a mind that has stopped fleeing the weather.",
            reflectionPrompt = "Which worry about the future is stirring up your storm today? What would a firm stand look like right now?"
        ),

        // q080 — Marcus Aurelius
        "q080" to QuoteInsight(
            intro = "Marcus asks himself a short question and answers it at once. If he has done some good for the common interest, the reward is already his. He needs no thanks, no record, and no return. The doing is enough.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Reward Inside the Deed",
                    blockquote = "Have I done something for the general interest? Well then, I have had my reward.",
                    body = "The general interest means the common good, the welfare of the community that Marcus believed all rational beings share. He treats a good act as complete in itself. Expecting gratitude adds a second, uncertain payment to one already received. When you help and then wait for recognition, you turn a gift into a loan. Marcus refuses to do that.",
                    bullets = listOf(
                        InsightBullet("Complete in itself", "The good you did is finished and real, whether or not anyone notices."),
                        InsightBullet("Gift, not loan", "Expecting repayment turns generosity into a bargain you might lose.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Keep It Close, Keep Going",
                    blockquote = "Let this always be present to your mind, and never stop doing such good.",
                    body = "Marcus knew he would forget, which is why he writes always be present to your mind. Resentment creeps in easily when good deeds go unthanked, and resentment is a common reason people stop helping. Remembering that the reward has already arrived keeps generosity from souring. The second half follows naturally: if every good act pays at once, there is no reason to stop.",
                    bullets = listOf(
                        InsightBullet("Guard against souring", "When you feel unthanked, recall that the reward was already yours."),
                        InsightBullet("Steady kindness", "Make helping a habit that does not depend on how others respond.")
                    )
                )
            ),
            modernApplication = "After you help someone today, quietly say to yourself: I have had my reward. Then let it go. If you notice yourself waiting for thanks, treat that as a reminder to do one more small good thing for someone else.",
            closing = "The good deed pays in full the moment it is done.",
            reflectionPrompt = "Where have you been waiting for thanks that may never come? How would it feel to count the reward as already received?"
        ),

        // q083 — Marcus Aurelius
        "q083" to QuoteInsight(
            intro = "Marcus compresses a whole view of ethics into a picture from the hive. A bee does not thrive by harming the swarm, because its life depends on the swarm. People, he believed, are the same: what damages the community cannot truly benefit the individual.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Harms the Hive",
                    blockquote = "That which is not good for the swarm",
                    body = "The swarm is the whole community: family, workplace, city, the human race. Marcus held that rational beings are made for one another. An action that weakens trust, fairness, or the common good is not good, however clever or profitable it looks. Seen this way, ethics is not a set of limits on self-interest but an accurate picture of where self-interest really lies.",
                    bullets = listOf(
                        InsightBullet("Shared life", "Your well-being is woven into the well-being of those around you."),
                        InsightBullet("Hidden costs", "A gain that harms the group usually carries a cost you have not yet counted.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Private Profit",
                    blockquote = "neither is it good for the bee",
                    body = "The second half denies a common illusion: that someone can quietly benefit by harming the group. A bee that robbed the hive would only be weakening the place it lives. For Marcus, the same is true of a lie, a shortcut, or a cruelty. Even if it seems to pay, it wears away the shared world you depend on and the character you carry.",
                    bullets = listOf(
                        InsightBullet("Slow erosion", "Small harms to the common good come back to you through the world you share."),
                        InsightBullet("Test the gain", "Before taking an advantage, ask what it does to the people around you.")
                    )
                )
            ),
            modernApplication = "Before a decision this week, ask the bee's question: is this good for the swarm? If it helps me but costs my team, family, or neighbors, it is probably not good for me either. Let that question shape at least one choice.",
            closing = "No bee prospers by robbing its own hive.",
            reflectionPrompt = "Is there an advantage you are tempted by that would cost the people around you? How might it cost you as well?"
        ),

        // q091 — Epictetus
        "q091" to QuoteInsight(
            intro = "Epictetus teaches that your roles tell you your duties. Just before this line he walks through being a son and a brother. Here he adds public office and stages of life. Each name you carry, looked at honestly, comes with its own instructions.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Remember Your Name",
                    blockquote = "If you are a senator of any state, remember that you are a senator; if a youth, that you are a youth; if an old man, that you are an old man",
                    body = "A senator in Epictetus's world was a member of a city's ruling council, someone with public responsibility. A youth is still learning. An old man has experience to offer and dignity to keep. The repeated word \"remember\" suggests that we forget our roles easily, acting in ways that do not fit who we are to the people around us.",
                    bullets = listOf(
                        InsightBullet("Roles as reminders", "Each title you hold is a short summary of what others can rightly expect."),
                        InsightBullet("Easy to forget", "Under pressure we tend to act from impulse rather than from our role."),
                        InsightBullet("Every stage counts", "Being young or old is a role too, with its own fitting conduct.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Each Name Asks",
                    blockquote = "for each of such names, if it comes to be examined, marks out the proper duties.",
                    body = "The phrase \"if it comes to be examined\" is the key. A name does not hand you your duties automatically. You have to think about it. What does it actually mean to be a parent, a manager, a neighbor? Epictetus goes on to warn that a brother who blames his brother has forgotten his name. Examining the role gives you a map for what to do.",
                    bullets = listOf(
                        InsightBullet("Duties need thought", "You find your obligations by reflecting on what a role really means."),
                        InsightBullet("A ready guide", "When unsure how to act, ask what your role here requires.")
                    )
                )
            ),
            modernApplication = "List three roles you hold today, such as colleague, sibling, or friend. Next to each, write one thing that role asks of you this week. When a hard moment comes, ask which name you are wearing and what it calls for.",
            closing = "Your titles are quiet instructions; read them when you are unsure.",
            reflectionPrompt = "Which of your roles have you been forgetting lately? If you examined that name honestly, what would it ask of you today?"
        ),

        // q081 — Marcus Aurelius
        "q081" to QuoteInsight(
            intro = "Marcus reflects on the many famous people who have come and gone: philosophers, generals, mathematicians, and wits. Fame did not keep any of them. Against that background, one thing still stands out as worth a great deal.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Remains Worth Much",
                    blockquote = "One thing here is worth a great deal, to pass your life in truth and justice",
                    body = "Marcus names Heraclitus, Pythagoras, Socrates, and Archimedes, among others, the great minds of his world. All of them are long gone, and their greatness did not change that. What is left to value, then? Not reputation, but the way a life is spent. Truth means honesty in word and thought. Justice means fair treatment of others. Both are open to anyone, every day.",
                    bullets = listOf(
                        InsightBullet("Not fame", "Reputation fades for everyone; character is what gives a life its worth now."),
                        InsightBullet("Daily currency", "Truth and justice can be practiced in ordinary conversations and choices.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Kindness Toward the Unkind",
                    blockquote = "with a benevolent disposition even to liars and unjust men",
                    body = "This is the harder part. It is one thing to be honest and fair yourself, and another to stay well-disposed toward those who are not. Marcus does not ask you to trust liars or approve of injustice. He asks you not to let their faults turn you hostile. A benevolent disposition means wishing them well and refusing to become like them.",
                    bullets = listOf(
                        InsightBullet("Not trust, goodwill", "You can protect yourself from a liar and still wish them no harm."),
                        InsightBullet("Refuse their example", "Meeting dishonesty with bitterness lets the dishonest shape who you are.")
                    )
                )
            ),
            modernApplication = "Think of someone who has been unfair or untruthful with you. Without excusing what they did, try wishing them a better path, even silently. Then deal with them honestly and fairly, as you would want to be dealt with.",
            closing = "Truth, justice, and goodwill are worth more than any lasting name.",
            reflectionPrompt = "Who in your life tests your goodwill most? What would a benevolent disposition toward them actually look like?"
        ),

        // q082 — Marcus Aurelius
        "q082" to QuoteInsight(
            intro = "This is the opening of the second book of Marcus's notes, and one of his most practical passages. Before the day begins, he prepares himself for difficult people. Then he reminds himself why they act that way, and why he need not be harmed by them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Forecasting Difficult People",
                    blockquote = "Begin the morning by saying to yourself, I shall meet with the busybody, the ungrateful, arrogant, deceitful, envious, unsocial.",
                    body = "Marcus does not hope for a day free of difficult people. He expects them. A busybody meddles in other people's affairs, and unsocial means hostile to shared life. Naming them in advance removes the surprise, and surprise is often what turns irritation into anger. This is not cynicism. It is like carrying an umbrella, not because you hate rain, but because it comes.",
                    bullets = listOf(
                        InsightBullet("No surprise", "Expecting friction makes it easier to meet it with patience when it arrives."),
                        InsightBullet("Forecast, not cynicism", "Anticipating faults is preparation, not a low opinion of people.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Ignorance, Not Malice",
                    blockquote = "All these things happen to them by reason of their ignorance of what is good and evil.",
                    body = "Here is the turn that makes the preparation kind. Marcus believes people act badly because they misunderstand what is truly good. They think status, pleasure, or winning will help them. That does not excuse the behavior, but it changes how he meets it. He goes on to say the wrongdoer is akin to him, and that we are made to work together, like hands or feet.",
                    bullets = listOf(
                        InsightBullet("Misunderstanding", "Bad behavior often comes from mistaken beliefs about what will bring happiness."),
                        InsightBullet("Made to cooperate", "Marcus compares people to hands and feet, built to work together, not against each other.")
                    )
                )
            ),
            modernApplication = "Tomorrow morning, before you check messages, name the kind of difficulty you are likely to meet. Then add: they are acting from confusion about what is good, and I can still treat them fairly. Notice whether the day's frictions feel smaller.",
            closing = "Expect the difficult, and meet it with understanding.",
            reflectionPrompt = "Who are you likely to find difficult today? What mistaken belief about the good might be driving their behavior?"
        ),

        // q084 — Marcus Aurelius
        "q084" to QuoteInsight(
            intro = "Marcus reasons that whatever the gods intend, he can still ask what is useful, and what is useful to anyone is what fits their nature. His nature, he says, is rational and social. That gives him two cities, a smaller one and a larger one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Reason and Fellowship",
                    blockquote = "My nature is rational and social",
                    body = "These two words carry much of Stoic ethics. Rational means able to think, judge, and choose. Social means made for life with others. Marcus treats them as a pair: reason, rightly used, leads toward cooperation and fairness. A life that is clever but cut off from others, or warm but thoughtless, misses half of what a human being is.",
                    bullets = listOf(
                        InsightBullet("Two halves", "Good thinking and good fellowship belong together in a full human life."),
                        InsightBullet("Useful means fitting", "What is truly useful to you is what fits your rational and social nature.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Two Cities at Once",
                    blockquote = "my city and country, so far as I am Antoninus, is Rome, but so far as I am a man, it is the world",
                    body = "Antoninus was part of Marcus's official name as emperor, so here it stands for his public role. As emperor, his city was Rome, with its laws and duties. As a human being, his city was the whole world, shared with everyone who has reason. He does not cancel the first loyalty; he sets it inside the second. What is useful to these cities, he adds, is alone useful to him.",
                    bullets = listOf(
                        InsightBullet("Local and universal", "Serve your own community, while remembering you also belong to humanity."),
                        InsightBullet("Role within a whole", "Your particular job matters most when it also serves the larger good.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "As Antoninus",
                rightHeader = "As a Human Being",
                rows = listOf(
                    "Citizen of Rome" to "Citizen of the world",
                    "Duties of office" to "Duties of shared reason",
                    "Loyalty to one city" to "Goodwill to all people"
                )
            ),
            modernApplication = "Think of a decision you are facing in a particular role, as a parent, worker, or neighbor. Ask two questions: is it good for my local city, and is it good for the world city? When both answers are yes, go ahead with confidence.",
            closing = "Belong to your town, and to the whole human world.",
            reflectionPrompt = "What is your smaller city, and how does serving it connect to your citizenship in the larger one?"
        ),

        // q085 — Marcus Aurelius
        "q085" to QuoteInsight(
            intro = "Marcus opens Book Two of his notebook by preparing for a hard day: he expects to meet people who are meddling, ungrateful, and dishonest. Before they arrive, he reminds himself what they are to him. They are kin, built for the same work he is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Built Like a Pair of Hands",
                    blockquote = "We are made for co-operation, like feet, like hands, like eyelids, like the rows of the upper and lower teeth.",
                    body = "Every image Marcus picks is a pair or a set. One foot cannot walk alone, one eyelid cannot blink alone, and the upper teeth are useless without the lower. He is saying that people are not separate machines that sometimes bump into each other. We are parts designed to work together, and our best functioning only appears when we do.",
                    bullets = listOf(
                        InsightBullet("Pairs, not singles", "Each image shows something that only works when its partner works with it."),
                        InsightBullet("Ordinary bodies", "Marcus reaches for the plainest examples he has, the ones he uses every minute without noticing."),
                        InsightBullet("Design, not choice", "Cooperation is presented as how we are made, not as an optional kindness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "When Teeth Grind",
                    blockquote = "To act against one another, then, is contrary to nature.",
                    body = "If we are built to work together, then working against each other is a kind of malfunction. Marcus goes on to say that even being vexed with someone and turning away from them counts as acting against them. So the line reaches past open conflict to the small daily habit of resentment, the silent turning of the back.",
                    bullets = listOf(
                        InsightBullet("A malfunction", "Conflict is treated less as wickedness and more as a part failing at its job."),
                        InsightBullet("Quiet opposition", "Sulking and coldness also count as acting against someone, not only open fights."),
                        InsightBullet("A morning rehearsal", "Marcus says this to himself before the day starts, so he is ready when friction comes.")
                    )
                )
            ),
            modernApplication = "Before a meeting with someone who irritates you, picture the two of you as a pair of hands lifting the same box. Ask what the shared task is, and what your half of it would look like if you stopped pulling the other way.",
            closing = "Like upper and lower teeth, we only work when we meet.",
            reflectionPrompt = "Who in your life feels like an opponent but is really your other hand? What would cooperating with them look like this week?"
        ),

        // q086 — Marcus Aurelius
        "q086" to QuoteInsight(
            intro = "Most of us judge fairness by what people do: the harsh word, the broken rule. Marcus adds a quieter category. Sometimes the unjust act is the one that never happens, the help not given or the truth not spoken.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Weight of the Undone",
                    blockquote = "He often acts unjustly who does not do a certain thing",
                    body = "Marcus believed we are made for one another, so each of us owes something to the people around us. When you stay silent while someone is treated badly, or keep back help that was yours to give, you have failed in that duty. Nothing visible happened, yet a wrong was done. The word \"often\" matters too: Marcus thought this kind of failure was common.",
                    bullets = listOf(
                        InsightBullet("Duty includes action", "Justice is not only avoiding harm; it also asks you to do your part."),
                        InsightBullet("Invisible failures", "An omission leaves no mark, which makes it easy to excuse in yourself."),
                        InsightBullet("Common, not rare", "Marcus says this happens often, so it is worth checking for daily.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Not Only the Doer",
                    blockquote = "not only he who does a certain thing",
                    body = "This half keeps the ordinary meaning of injustice in place. Doing harm is still wrong. Marcus simply widens the circle so that standing by is not a safe place to hide. A person who never does anything cruel can still fall short of justice by never doing anything kind or brave when it was needed.",
                    bullets = listOf(
                        InsightBullet("Both count", "Harmful acts and needed acts left undone sit on the same scale."),
                        InsightBullet("No neutral ground", "Standing aside is itself a choice with consequences for others.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Wrongs We Notice",
                rightHeader = "Wrongs Marcus Adds",
                rows = listOf(
                    "Speaking cruelly" to "Staying silent when it costs someone",
                    "Taking what is not yours" to "Keeping help that was owed",
                    "Breaking a rule" to "Never doing the decent thing"
                )
            ),
            modernApplication = "At the end of the day, ask two questions instead of one: \"Did I do anything unfair?\" and \"Was there something fair I should have done and did not?\" The second question often has the more useful answer.",
            closing = "Silence can be a deed, and so can the help you kept in your pocket.",
            reflectionPrompt = "Where have you told yourself you did nothing wrong because you did nothing at all? What small act is still waiting for you?"
        ),

        // q087 — Marcus Aurelius
        "q087" to QuoteInsight(
            intro = "We usually think of wrongdoing as something done to another person. Marcus turns the arrow around. The first and surest victim of an unjust act is the one who commits it, because the act shapes the character of the person who chooses it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Arrow Turns Back",
                    blockquote = "He who does wrong does wrong against himself.",
                    body = "For a Stoic, the only real harm is harm to your own mind and character. Someone who cheats you can take your money, but they cannot make you worse. When they cheat, though, they do make themselves worse. The person they truly damage is the one they see in the mirror, even if they walk away with the profit.",
                    bullets = listOf(
                        InsightBullet("Where harm lands", "Others can touch your possessions; only you can damage your character."),
                        InsightBullet("The hidden cost", "A wrong may look profitable while it quietly takes something from the doer.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How a Self Gets Made",
                    blockquote = "He who acts unjustly acts unjustly to himself, because he makes himself bad.",
                    body = "The reason Marcus gives is practical. Each choice is practice. Act unjustly once and the next time is easier, until it becomes who you are. So the harm is not a punishment sent from outside. It is the natural result of repeated choices, the way a path gets worn into grass by walking it again and again.",
                    bullets = listOf(
                        InsightBullet("Choices as practice", "Every act rehearses a habit, and habits become character."),
                        InsightBullet("No outside judge", "The damage needs no one to discover it; it happens in the doing."),
                        InsightBullet("A reason for patience", "Seeing this, Marcus can feel sorry for wrongdoers rather than furious.")
                    )
                )
            ),
            modernApplication = "When you are tempted to cut a corner, ask: \"What kind of person am I practicing being right now?\" Treat the choice as one more step on a path you are wearing into yourself.",
            closing = "Every unfair act is a small lesson in becoming someone worse.",
            reflectionPrompt = "Think of a choice you are tempted to make today. Leaving aside who else it affects, what would it make of you?"
        ),

        // q088 — Marcus Aurelius
        "q088" to QuoteInsight(
            intro = "Marcus starts this note with something small and almost comic: being annoyed by a person's bad breath. His point is larger. When someone has a fault, you have a mind and so do they. Use yours to reach theirs, and anger becomes unnecessary.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Reason Speaking to Reason",
                    blockquote = "By your rational faculty stir up his rational faculty; show him his error, admonish him.",
                    body = "Marcus believed every person shares in reason. That means the person who annoys you is not a wall to be shouted at. They can understand. Your task is to engage that capacity: explain clearly, point to the mistake, offer a correction. This treats them as an equal who can think, not a problem to be managed.",
                    bullets = listOf(
                        InsightBullet("Shared equipment", "You and the other person have the same capacity to reason, so speak to it."),
                        InsightBullet("Name the error", "Be specific about the problem instead of attacking the person."),
                        InsightBullet("Respect in correction", "Admonishing someone assumes they are able to do better.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Anger Has No Job",
                    blockquote = "For if he listens, you will cure him, and there is no need of anger.",
                    body = "If they listen, the problem is solved and anger contributes nothing. If they do not, anger still contributes nothing. Marcus frames correction as a kind of cure, which casts you more as a healer than a judge. Anger often feels like it is doing work, but here it has no task to perform.",
                    bullets = listOf(
                        InsightBullet("A cure, not a contest", "The aim is to help the other person improve, not to win."),
                        InsightBullet("Useless heat", "Anger adds nothing that a clear explanation cannot do better.")
                    )
                )
            ),
            modernApplication = "Next time someone's habit grates on you, skip the sigh and the side comment. Say one clear, kind sentence that names the issue and what would help. Then let it rest, whether they take it up or not.",
            closing = "Speak to the mind in front of you, and anger finds nothing left to do.",
            reflectionPrompt = "Is there a fault in someone close to you that you complain about but have never calmly named to them? What would you say?"
        ),

        // q089 — Marcus Aurelius
        "q089" to QuoteInsight(
            intro = "Marcus gives himself a test for any gain, any deal, any advantage. If the price is your word, your self-respect, or your peace with others, the thing is not profitable at all, however it looks on paper.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Ledger With Hidden Costs",
                    blockquote = "Never value anything as profitable to yourself which shall compel you to break your promise, to lose your self-respect",
                    body = "The word \"profitable\" is chosen with care. Marcus is not saying ignore your interests. He is saying count properly. A promotion that requires you to break your word, or a deal that leaves you unable to respect yourself, has a cost that does not show up in money. When that cost is counted, the profit disappears.",
                    bullets = listOf(
                        InsightBullet("Count everything", "A true accounting includes what a gain does to your character."),
                        InsightBullet("Promise first", "Keeping your word is listed first, as something no profit can outweigh."),
                        InsightBullet("Self-respect", "If you cannot look at yourself plainly afterward, you have paid too much.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Bad Bargains Breed",
                    blockquote = "to hate any man, to suspect, to curse, to act the hypocrite.",
                    body = "The second part of the list names what a bad bargain does to your inner life. Some gains can only be kept by resenting rivals, watching your back, or wearing a mask. Marcus goes on to mention anything that needs walls and curtains, things that must be hidden. A life arranged that way is full of strain, whatever it earns.",
                    bullets = listOf(
                        InsightBullet("The strain of hiding", "Gains that must be concealed keep you guarded and tense."),
                        InsightBullet("Suspicion as a toll", "Some advantages require you to distrust everyone around you."),
                        InsightBullet("Masks are heavy", "Acting the hypocrite is tiring work that never quite ends.")
                    )
                )
            ),
            modernApplication = "Before saying yes to an opportunity, run it through Marcus's list: will this require me to break a promise, hide something, resent someone, or pretend? If the answer is yes to any of them, count that as a real cost.",
            closing = "A gain you have to hide was never worth having.",
            reflectionPrompt = "Is there something you count as an advantage that quietly requires a mask, a grudge, or a broken word? What would letting it go cost you?"
        ),

        // q090 — Epictetus
        "q090" to QuoteInsight(
            intro = "Epictetus opens this discourse with a hard case: should robbers and adulterers simply be destroyed? His answer is that such people are blind in the faculty that tells good from bad. You would not rage at someone for being blind. Pity fits better than fury.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Their Fault, Your Calm",
                    blockquote = "You ought not to be affected contrary to nature by the bad things of another.",
                    body = "The \"bad things of another\" are their faults and mistakes. Epictetus says they belong to that person, not to you. When someone else's wrongdoing throws you into rage, you have let their error become your disturbance. That is what he means by being affected \"contrary to nature\": a reasoning mind is meant to stay steady and clear, not to be pushed around by what others choose.",
                    bullets = listOf(
                        InsightBullet("Whose problem", "The other person's error is theirs; your reaction is the part that is yours."),
                        InsightBullet("Steady by design", "For Epictetus, a calm and clear mind is our natural state, not a luxury.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Pity in Place of Offense",
                    blockquote = "Pity him rather; drop this readiness to be offended and to hate.",
                    body = "Epictetus notices that many of us are ready to be offended, almost waiting for it. He asks us to drop that readiness. In its place he offers pity, the recognition that the wrongdoer has lost something far more valuable than whatever they took. He adds a sharp observation: we often get angry because we prize the same things the thief prizes.",
                    bullets = listOf(
                        InsightBullet("A loaded trigger", "Being ready to take offense means you will find plenty of it."),
                        InsightBullet("Seeing the loss", "The wrongdoer has damaged their own judgment, which is the greater harm."),
                        InsightBullet("Shared values", "Anger at a thief can reveal how much you overvalue what was taken.")
                    )
                )
            ),
            modernApplication = "When you catch yourself muttering about \"people like that,\" pause and try a different sentence: \"They are confused about what is good, and that is a real loss for them.\" Notice whether your shoulders drop.",
            closing = "Another person's error belongs to them; your calm belongs to you.",
            reflectionPrompt = "When did you last take offense quickly? What were you valuing in that moment that made the offense possible?"
        ),

        // q092 — Epictetus
        "q092" to QuoteInsight(
            intro = "Epictetus opens his discourse against the quarrelsome with Socrates, who avoided fights and calmed others' quarrels too. Socrates even put up patiently with clever opponents and with his own family's arguments, because he knew he could not control another person's mind.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Fight Starts Here",
                    blockquote = "The wise and good man neither himself fights with any person",
                    body = "Epictetus explains why the good person does not fight. Socrates remembered that no one has power over another person's ruling principle, their inner judgment. Quarrels usually come from trying to force someone else to think or act as we want. When you stop demanding control of what is not yours, much of the reason to fight goes away.",
                    bullets = listOf(
                        InsightBullet("The root of quarrels", "Most fights come from wanting control over someone else's mind."),
                        InsightBullet("Socrates as model", "Epictetus points to a real person who lived this way, not an ideal.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Peacemaker When You Can",
                    blockquote = "nor does he allow another, so far as he can prevent it.",
                    body = "The second half adds an outward task. The good person also tries to stop quarrels between others. Epictetus notes that Socrates settled many disputes among his companions. The phrase \"so far as he can prevent it\" keeps this honest: you are not responsible for every argument in the world, only for doing what is within your reach.",
                    bullets = listOf(
                        InsightBullet("Beyond yourself", "Keeping peace includes helping others step back from a fight."),
                        InsightBullet("Within reach", "You do what you can and accept that some quarrels are not yours to end."),
                        InsightBullet("Calm is contagious", "A person who refuses to fight often lowers the heat around them.")
                    )
                )
            ),
            modernApplication = "When you sense a dispute rising, at home or at work, try being the person who asks a calm question instead of taking a side. \"What does each of you actually need here?\" can turn a fight into a conversation.",
            closing = "Refuse the fight in yourself first, then help others put theirs down.",
            reflectionPrompt = "Is there a quarrel near you that you could help soften? What is one calm thing you could say or do?"
        ),

        // q093 — Epictetus
        "q093" to QuoteInsight(
            intro = "This short teaching from the Enchiridion, Epictetus's handbook of his core ideas, changes one word in how you speak about loss. Instead of \"lost,\" say \"restored,\" as in given back. Everything we hold was lent to us, and returning it is part of the arrangement.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Word Lost",
                    blockquote = "Never say about anything, I have lost it",
                    body = "The word \"lost\" quietly assumes the thing was yours to keep. Epictetus asks you to notice that assumption. Your possessions, your position, even the people you love came to you from outside, and you never controlled whether they would stay. Speaking of loss as theft from your property sets you up for bitterness each time something passes on.",
                    bullets = listOf(
                        InsightBullet("A hidden claim", "Saying \"lost\" assumes a permanent ownership you never had."),
                        InsightBullet("Words shape feeling", "How you name an event affects how you carry it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Giving Back What Was Lent",
                    blockquote = "but say I have restored it.",
                    body = "To restore is to give back. Epictetus extends this even to the people dearest to us, which is a demanding thought, offered gently. He adds an image: while you have something, care for it as travelers care for an inn. You look after the room well, you enjoy it, and you know it is not yours forever. That knowledge can make your care more tender, not less.",
                    bullets = listOf(
                        InsightBullet("The inn", "Treat what you have as a good guest treats a room: with care and without clinging."),
                        InsightBullet("Gratitude for the stay", "Seeing things as lent helps you value the time you had with them."),
                        InsightBullet("Not coldness", "This is meant to soften grief over time, not to forbid sorrow.")
                    )
                )
            ),
            modernApplication = "Pick one thing you would hate to lose: a job, a home, an object. Say to yourself, \"This is lent to me for now,\" and then do one small thing to care for it well today, the way a good guest leaves the inn better than they found it.",
            closing = "What was lent is not lost when it goes home.",
            reflectionPrompt = "What do you hold most tightly as if it were permanently yours? How would you treat it differently if you saw it as on loan?"
        ),

        // q094 — Epictetus
        "q094" to QuoteInsight(
            intro = "Epictetus is talking about coins. A Roman coin, a sestertius, was judged by the emperor's face stamped on it: Trajan's stamp was accepted, Nero's was thrown away as counterfeit. People, he says, carry a stamp too, and it is found in their opinions.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Checking the Coin",
                    blockquote = "What is the stamp of his opinions? It is gentleness, a sociable disposition, a tolerant temper, a disposition to mutual affections.",
                    body = "Trajan was remembered as a good emperor and Nero as a cruel one, so the coin image is pointed. A human being is not proved by having a human shape. Epictetus asks what values they actually carry. The marks of a genuine person are gentle, social, patient, and warm. These are the stamp to look for in others and, more importantly, in yourself.",
                    bullets = listOf(
                        InsightBullet("Not the outer form", "Looking like a person is not enough; character is the real mark."),
                        InsightBullet("Four marks", "Gentleness, sociability, tolerance, and affection are what Epictetus looks for."),
                        InsightBullet("Test yourself first", "The same inspection works best when turned on your own habits.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Welcome Aboard",
                    blockquote = "Produce these qualities. I accept them: I consider this man a citizen, I accept him as a neighbor, a companion in my voyages.",
                    body = "Once the right stamp is shown, Epictetus is generous. He accepts the person as a fellow citizen, a neighbor, a shipmate. Sea travel was long and risky, so a companion on a voyage was someone you needed to trust. The welcome does not depend on rank or wealth, only on character. He adds a warning: if the stamp is resentment and violence, the shape of a man is not enough.",
                    bullets = listOf(
                        InsightBullet("Open admission", "Good character is the only entry requirement Epictetus asks for."),
                        InsightBullet("Trust on the voyage", "A shipmate is someone you rely on when conditions turn rough.")
                    )
                )
            ),
            modernApplication = "Before judging someone by their job, clothes, or status, ask what stamp their conduct shows. Then ask the same of yourself: if a stranger watched you for a day, would they find gentleness and tolerance on your coin?",
            closing = "Character is the face stamped on the coin; everything else is metal.",
            reflectionPrompt = "What stamp would the people closest to you say your opinions carry? Is it the one you would choose?"
        ),

        // q095 — Epictetus
        "q095" to QuoteInsight(
            intro = "Epictetus asks a plain question: when the end comes, what do you want to be in the middle of doing? He is not asking you to dwell on death. He is asking you to look at today, since today is where any answer to that question will be found.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Caught in the Act",
                    blockquote = "What then do you wish to be doing when you are found by death?",
                    body = "Just before this, Epictetus lists what people happen to be doing at any moment: farming, trading, holding office, or suffering an upset stomach. Everyone will be found doing something. The question turns that fact into a compass. If you knew this hour would be the last, what would you want it to contain? That answer tells you what matters most.",
                    bullets = listOf(
                        InsightBullet("Everyone is mid-task", "No one stops before the end; we are always in the middle of something."),
                        InsightBullet("A compass, not a fear", "The question points you toward what you value, not toward dread.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Work Worth Being Found At",
                    blockquote = "I, for my part, would wish to be found doing something which belongs to a man, beneficent, suitable to the general interest, noble.",
                    body = "Epictetus answers for himself: something helpful, something that serves others, something fitting for a human being. He goes on to admit that he may not always manage great deeds. Then he would be content to be found improving himself and giving each relationship its due. That fallback is within anyone's reach, on any ordinary day.",
                    bullets = listOf(
                        InsightBullet("Helpful work", "He wants to be found doing good for others, not merely busy."),
                        InsightBullet("A humble fallback", "If great deeds are out of reach, working on your own character is enough."),
                        InsightBullet("Everyday nobility", "Tending your relationships well counts as noble work too.")
                    )
                )
            ),
            modernApplication = "Pick one ordinary task today, such as a phone call, a meal, or a piece of work, and ask whether you would be glad to be found doing it this way. If not, adjust one small thing: your patience, your attention, your care.",
            closing = "Live so that any hour could stand as a fair sample of you.",
            reflectionPrompt = "If someone looked in on your life at a random moment this week, what would they find you doing? Would you be content with that?"
        ),

        // q096 — Seneca
        "q096" to QuoteInsight(
            intro = "Seneca writes to Lucilius about friendship. A friend, he says, shares in all your interests, so your good and bad fortune are theirs too. From there he widens the idea to everyone: a life spent asking only \"what is in it for me?\" cannot be a happy one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Narrow Question",
                    blockquote = "No one can live happily who has regard to himself alone and transforms everything into a question of his own utility",
                    body = "Seneca describes a habit: turning every situation into a calculation of personal advantage. A conversation becomes a chance to gain something, a friendship becomes a resource. He says this habit rules out happiness. When everything is measured by your own benefit, you cut yourself off from the shared life that actually nourishes a person.",
                    bullets = listOf(
                        InsightBullet("A shrinking world", "Measuring everything by self-interest makes your life smaller, not larger."),
                        InsightBullet("We live in common", "Seneca writes just before this that we do not have good or bad fortune alone.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Wider Circle",
                    blockquote = "you must live for your neighbor, if you would live for yourself.",
                    body = "The second half sounds like a paradox but is practical. People flourish through connection. Caring for others, sharing their burdens, and taking part in common life are what make a person's own life full. Seneca is not asking you to erase yourself. He is saying your own good is found by looking beyond yourself.",
                    bullets = listOf(
                        InsightBullet("Not self-erasure", "Living for others is presented as the path to your own good."),
                        InsightBullet("Fellowship", "Seneca says shared life among people prepares us for deep friendship."),
                        InsightBullet("Full, not empty", "Care for others tends to fill a life that self-interest leaves hollow.")
                    )
                )
            ),
            modernApplication = "Notice the next time you size up a situation only by what you will get from it. Ask a second question as well: \"What does the other person need here, and what can I bring?\" Let that question shape at least one choice today.",
            closing = "A life lived only for yourself has no room for you to grow.",
            reflectionPrompt = "Where have you been treating people mainly as useful? What might change if you asked what you could bring to them?"
        ),

        // q097 — Seneca
        "q097" to QuoteInsight(
            intro = "In a long letter on how to treat other people, Seneca offers one short rule to hold everything together. All that exists, gods and humans alike, is one whole, and we are its parts. The rest of his advice about kindness flows from this single image.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Parts, Not Strangers",
                    blockquote = "We are the parts",
                    body = "To be a part is to belong to something larger. A hand does not compete with the foot, and an eye does not resent the ear. Seneca asks you to see other people the same way. They are not outsiders whose good is separate from yours. They are other parts of the same body, and what happens to them happens, in some measure, to the whole you belong to.",
                    bullets = listOf(
                        InsightBullet("Belonging", "Being a part means you are never fully alone or separate."),
                        InsightBullet("No rival limbs", "Parts of one body do not gain by another's loss.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Body Bigger Than You",
                    blockquote = "of one great body.",
                    body = "The word \"great\" matters. This body includes everyone: strangers, rivals, people far away. Seneca says right after that nature made us prone to friendship and fairness, and that our hands should be ready to help. If we truly see ourselves as parts of one body, helping another is as natural as a hand reaching to steady a stumbling foot.",
                    bullets = listOf(
                        InsightBullet("Everyone included", "The body has no outer edge where some people stop counting."),
                        InsightBullet("Natural help", "Helping someone becomes a reflex, like a body protecting itself."),
                        InsightBullet("Fairness built in", "Seneca links this image directly to justice and mutual care.")
                    )
                )
            ),
            modernApplication = "When you hear of someone's trouble, at work or in the news, pause and say, \"That is part of my body hurting.\" Then ask whether there is one small, real thing you can do to help, even if it is just a kind word.",
            closing = "Your hand does not ask the foot what it has done for it lately.",
            reflectionPrompt = "Who do you find it hardest to see as part of the same body as you? What changes if you try?"
        ),

        // q098 — Seneca
        "q098" to QuoteInsight(
            intro = "Seneca has just observed that most people value things simply because others praise them. Then he turns that habit to good use: if we must take some values on public trust, let it be this one. Every nation, he says, would agree that gratitude ranks first.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Thing Everyone Agrees On",
                    blockquote = "Nothing is more honorable",
                    body = "People argue about almost everything: pleasure, toil, wealth, pain. Seneca notes that on gratitude, good and bad people alike agree. Every city and every people would echo it. That is a striking claim. It suggests gratitude is not a local custom or a matter of taste but something people everywhere recognize as deeply right.",
                    bullets = listOf(
                        InsightBullet("Rare agreement", "Seneca points to gratitude as the one value all people endorse."),
                        InsightBullet("Honor, not mood", "Gratitude is called honorable, a matter of character rather than feeling.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Heart That Remembers",
                    blockquote = "than a grateful heart.",
                    body = "A grateful heart remembers what it received. That memory does real work. It keeps you humble, because you see how much came from others. It makes you generous, because you know what it is to be given to. It steadies you, because even when things are taken away, the record of what you had remains. Seneca treats gratitude as the core of a good character, not a decoration on it.",
                    bullets = listOf(
                        InsightBullet("Remembering gifts", "Gratitude is first of all an act of memory."),
                        InsightBullet("Outward facing", "It turns your attention to others and what they have done."),
                        InsightBullet("Steady ground", "What you have been given remains part of you even after it ends.")
                    )
                )
            ),
            modernApplication = "Tonight, name one specific thing someone did for you this week and tell them you noticed. Keep it short and concrete: what they did and what it meant. Gratitude grows stronger the more precisely it is spoken.",
            closing = "Of all the things people disagree about, the grateful heart is not one.",
            reflectionPrompt = "Who has given you something you have never properly thanked them for? What stops you from telling them now?"
        ),

        // q099 — Marcus Aurelius
        "q099" to QuoteInsight(
            intro = "Marcus describes each person as one piece of a larger social whole. If you are part of a community, he reasons, your actions should be part of its life too. He goes on to say that acts with no connection to the common good split your life apart.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Piece of Something",
                    blockquote = "As you yourself are a component part of a social system",
                    body = "Marcus begins with a fact about you: you belong to a social whole. You did not make yourself, feed yourself, or teach yourself to speak. Others did. The life you live is woven from theirs. Starting here, the question of how to act becomes a question of how to fit well into the whole you already belong to.",
                    bullets = listOf(
                        InsightBullet("A fact, not a goal", "Belonging to others is your starting condition, not something you choose."),
                        InsightBullet("Woven lives", "Everything you rely on came through other people.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Acts That Fit the Whole",
                    blockquote = "so let every act of yours be a component part of social life.",
                    body = "If you are a part, your acts should be parts too. Marcus adds a vivid image: an act with no reference to the common good is like a man in a public assembly breaking away from the shared agreement, a small mutiny. Such acts also divide your own life, so that you are one person at work and another at home. Social acts make a life whole.",
                    bullets = listOf(
                        InsightBullet("The small mutiny", "Self-serving acts pull against the group you belong to."),
                        InsightBullet("One life, not many", "Acting for the common good keeps your life consistent and undivided."),
                        InsightBullet("Near or far", "Marcus says an act can serve others immediately or more remotely.")
                    )
                )
            ),
            modernApplication = "Before starting a task, ask: \"Who is this for, besides me?\" Even routine work, such as answering emails or cooking, can be done with the people it serves in mind. Let that answer shape how carefully you do it.",
            closing = "You are one stitch in a large cloth; let every act hold the weave.",
            reflectionPrompt = "Which of your regular activities feels cut off from anyone else's good? How could you connect it back to the whole?"
        ),

        // q100 — Marcus Aurelius
        "q100" to QuoteInsight(
            intro = "Marcus gives himself a simple two-step for when someone is wrong. First, teach them kindly. If that fails, the fault is yours, or perhaps no one's. Either way, there is no place in this plan for anger at the person who erred.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Kindness as the Method",
                    blockquote = "If a man is mistaken, instruct him kindly and show him his error.",
                    body = "Notice the word \"mistaken.\" Marcus does not say \"wicked.\" He sees error as a lack of understanding, which means the remedy is teaching. And the teaching should be kind. Harsh correction makes people defensive and less able to hear. Showing someone their error gently gives the truth its best chance of landing.",
                    bullets = listOf(
                        InsightBullet("Error, not evil", "Treating wrongdoing as a mistake opens the door to teaching."),
                        InsightBullet("Gentle works better", "A kind correction is easier to accept than a harsh one.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Then Let It Go",
                    blockquote = "But if you are not able, blame yourself, or blame not even yourself.",
                    body = "If your teaching fails, Marcus first suggests looking at yourself: perhaps you could have explained better. Then he softens even that: maybe no one is to blame. Some people are not ready to hear, and some moments are wrong for it. The second clause keeps you from turning frustration into either anger at them or harshness toward yourself.",
                    bullets = listOf(
                        InsightBullet("Look inward first", "A failed lesson is a chance to improve how you teach."),
                        InsightBullet("No blame needed", "Sometimes understanding simply does not happen yet, and that is no one's fault."),
                        InsightBullet("Spare yourself too", "Marcus does not swap anger at others for anger at yourself.")
                    )
                )
            ),
            modernApplication = "When a correction does not land, try this sentence: \"Maybe I can explain it better another time, and maybe it just is not the moment.\" Then move on without replaying the conversation.",
            closing = "Teach gently, and if the lesson fails, let blame fall to the floor.",
            reflectionPrompt = "When someone does not take your advice, where does your frustration usually go? What would it be like to blame no one?"
        ),

        // q101 — Marcus Aurelius
        "q101" to QuoteInsight(
            intro = "Near the end of the Meditations, Marcus boils his practice down to two rules. The first is about how to act: with thought and purpose. The second is about why: for the good of others. Together they make a short checklist he could carry anywhere.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "On Purpose, Not by Default",
                    blockquote = "First, do nothing inconsiderately, nor without a purpose.",
                    body = "Marcus was an emperor with endless demands, which makes it easy to act on reflex. This first rule asks for a pause. Before acting, consider what you are doing and why. Acting \"inconsiderately\" means acting without thinking; acting \"without a purpose\" means drifting. Both waste the one thing you control: your choices.",
                    bullets = listOf(
                        InsightBullet("Pause first", "A brief moment of thought turns a reflex into a choice."),
                        InsightBullet("Name the aim", "Knowing why you act keeps you from drifting through the day.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Pointed at the Common Good",
                    blockquote = "Second, make your acts refer to nothing else than to a social end.",
                    body = "The second rule gives purpose a direction. A \"social end\" is the good of the community you belong to. Marcus is not asking for grand gestures. He means letting ordinary acts serve others: doing your work honestly, treating people fairly, contributing your part. When purpose points outward, even small tasks take on meaning.",
                    bullets = listOf(
                        InsightBullet("Outward aim", "The best purpose is one that serves more than yourself."),
                        InsightBullet("Small tasks count", "Ordinary work done fairly and well is a social act."),
                        InsightBullet("Two rules, one life", "Thoughtful action and social aim support each other.")
                    )
                )
            ),
            modernApplication = "Write Marcus's two questions on a card: \"Have I thought about this?\" and \"Whom does this serve?\" Glance at it before a decision today, even a small one like how to reply to a message.",
            closing = "Think before you act, and aim the act beyond yourself.",
            reflectionPrompt = "What did you do today on autopilot? If you had paused, what purpose might you have given it?"
        ),

        // q102 — Marcus Aurelius
        "q102" to QuoteInsight(
            intro = "Marcus names a capacity he thinks belongs especially to human beings: loving people even when they wrong us. It sounds almost impossible. He then explains how it happens, offering reasons rather than demands, which makes the ideal feel reachable.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Human Gift",
                    blockquote = "It is peculiar to man",
                    body = "\"Peculiar\" here means special, belonging to humans in particular. Animals can return affection for affection. What reason adds is the ability to see past an injury to the person behind it. Marcus suggests this is not a rare saintly trait but part of what a human being is equipped to do, if they use their reason well.",
                    bullets = listOf(
                        InsightBullet("Distinctly human", "Loving past an injury is something reason makes possible for us."),
                        InsightBullet("Equipment we have", "Marcus treats this as a capacity to use, not a miracle to wait for.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How Love Survives a Wrong",
                    blockquote = "to love even those who do wrong.",
                    body = "Marcus gives four reminders that make this love possible. Wrongdoers are kin. They err through ignorance, not by choice. Both of you will soon be gone, so the quarrel is brief. And above all, they have not harmed you, because they have not made your mind worse. Each reminder loosens the grip of resentment until love has room again.",
                    bullets = listOf(
                        InsightBullet("Kin", "The person who wronged you shares your nature and your reason."),
                        InsightBullet("Ignorance", "Marcus believed people do wrong because they misjudge what is good."),
                        InsightBullet("No real harm", "Your character is untouched unless you choose to let it change.")
                    )
                )
            ),
            modernApplication = "When someone wrongs you, try Marcus's four reminders in order: they are kin, they misjudged, this is brief, my mind is still my own. See which one loosens the knot the most, and keep that one ready.",
            closing = "To love those who wrong us is not weakness; it is reason finishing its work.",
            reflectionPrompt = "Who has wronged you that you still hold at a distance? Which of Marcus's reminders would help you most with them?"
        ),

        // q103 — Seneca
        "q103" to QuoteInsight(
            intro = "Seneca is asking whether the liberal arts, the polite learning of educated Romans, can make a person good. Walking through the virtues one by one, he comes to loyalty and gives it a striking title. Then he asks whether any amount of learning could produce it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Holiest Good",
                    blockquote = "Loyalty is the holiest good in the human heart",
                    body = "\"Holiest\" is a strong word for a virtue that can seem ordinary. Seneca places loyalty, keeping faith with those who trust you, near the center of a good character. It is holy because so much depends on it. Friendship, family, and every partnership rest on people keeping their word. Without loyalty, nothing else between people can stand for long.",
                    bullets = listOf(
                        InsightBullet("Keeping faith", "Loyalty means being someone others can rely on."),
                        InsightBullet("Foundation stone", "Every lasting bond rests on trust kept over time.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Neither Pushed Nor Bought",
                    blockquote = "it is forced into betrayal by no constraint, and it is bribed by no rewards.",
                    body = "Seneca names the two ways loyalty is tested: pressure and temptation. Some people break under threat; others sell out for gain. True loyalty does neither. Seneca imagines it holding a secret more tightly the harder someone tries to pry it loose. He then asks whether learning alone can create such a spirit, and suggests it cannot. It must be chosen and practiced.",
                    bullets = listOf(
                        InsightBullet("Two tests", "Loyalty is tried both by threats and by offers."),
                        InsightBullet("Not for sale", "A loyalty that has a price is only a delayed betrayal."),
                        InsightBullet("Chosen, not taught", "Seneca doubts that knowledge alone produces this kind of steadiness.")
                    )
                )
            ),
            modernApplication = "Think of one confidence you have been trusted with, or one commitment you made to someone. Today, keep it a little more carefully: no hinting, no softening, no small exceptions. Notice how it feels to be fully trustworthy.",
            closing = "Loyalty has no price tag, and no pressure finds its seam.",
            reflectionPrompt = "Is there a trust you have been tempted to bend, through pressure or reward? What would holding it completely look like?"
        ),

        // q104 — Seneca
        "q104" to QuoteInsight(
            intro = "Seneca tells Lucilius he is learning so that he can teach. He would refuse wisdom itself if he had to keep it hidden. Then he sums up the feeling in a single line: good things lose their pleasure when no one shares them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Lonely Treasure",
                    blockquote = "No good thing is pleasant to possess",
                    body = "Seneca is talking about what he has found in his reading and reflection, the ideas that help him. He says no insight, however excellent, pleases him if he must keep it to himself. A good thing held alone is strangely flat. Much of its delight comes from passing it on and seeing it help someone else.",
                    bullets = listOf(
                        InsightBullet("Flat alone", "Even real goods lose their savor when there is no one to share them."),
                        InsightBullet("Wisdom included", "Seneca applies this even to wisdom, the thing he values most.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Friends at the Table",
                    blockquote = "without friends to share it.",
                    body = "Right after this line, Seneca promises to send Lucilius the books themselves, with the best passages marked. That is friendship in action: not only feeling warmly, but handing over what helped you. He adds that living alongside someone teaches more than letters, because example works faster than advice. Sharing goods is how friends grow together.",
                    bullets = listOf(
                        InsightBullet("Marked passages", "Seneca shows friendship by sending what he found useful."),
                        InsightBullet("Example over advice", "He notes that shared life teaches more than written words."),
                        InsightBullet("Growing together", "Friends who share goods also share progress.")
                    )
                )
            ),
            modernApplication = "Think of one thing that has helped you lately: a book, an idea, a habit, a recipe. Pass it to one friend today, with a sentence about why it mattered to you. Let the pleasure of it double.",
            closing = "A good thing kept to yourself is only half enjoyed.",
            reflectionPrompt = "What is something good in your life you have not yet shared with anyone? Who would you most like to give it to?"
        ),

        // q105 — Seneca
        "q105" to QuoteInsight(
            intro = "Seneca notices that people worry about how many years they will get, but rarely about how well they are living them. The irony is sharp: the thing we fret about is out of our hands, while the thing we neglect is fully within reach.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Counting the Wrong Thing",
                    blockquote = "Men do not care how nobly they live, but only how long",
                    body = "Seneca writes this at the end of a letter about stepping back from busy public life. He observes that many people arrive at old age with nothing stored up, their days spent and scattered. They have been measuring life by its length. But length alone says nothing about worth. A long life spent carelessly is not a better life, only a longer one.",
                    bullets = listOf(
                        InsightBullet("Length is not worth", "More years do not by themselves make a life good."),
                        InsightBullet("Spent and scattered", "Seneca pictures lives emptied out by distraction rather than lived."),
                        InsightBullet("A common habit", "He presents this as how most people think, without scolding.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Is Within Reach",
                    blockquote = "although it is within the reach of every man to live nobly, but within no man's power to live long.",
                    body = "This is the turn, and it is hopeful. No one controls how long they will live. But anyone, at any age and in any circumstance, can choose to live with honesty, courage, and care. Seneca moves your attention from the thing you cannot touch to the thing you can. Living nobly does not wait for a long future; it is available today.",
                    bullets = listOf(
                        InsightBullet("Not up to you", "The number of your years lies outside your control."),
                        InsightBullet("Fully up to you", "How you live each day is always your choice."),
                        InsightBullet("Available now", "Nobility needs no long future, only this present day.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Living Long",
                rightHeader = "Living Nobly",
                rows = listOf(
                    "Outside your control" to "Within your control",
                    "Measured in years" to "Measured in choices",
                    "Always worried about" to "Often neglected"
                )
            ),
            modernApplication = "Each morning, swap the question \"How much time do I have?\" for \"How well will I use today?\" Choose one way to live nobly in the next few hours, such as an honest word or a patient response, and do it.",
            closing = "You cannot choose the length of your days, only their quality.",
            reflectionPrompt = "If you stopped measuring your life by its length, what would you measure it by instead? How did today score?"
        ),

        // q106 — Seneca
        "q106" to QuoteInsight(
            intro = "Seneca writes this in his famous letter about how Romans treated their slaves. He calls his countrymen haughty and cruel toward them and offers a rule that cuts through status: treat those beneath you the way you would want to be treated by those above you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Looking Down",
                    blockquote = "Treat your inferiors",
                    body = "\"Inferiors\" here means people with less power than you: in Seneca's world, slaves; in ours, perhaps employees, servers, or anyone who depends on your goodwill. Seneca reminds Lucilius that a slave is born of the same stock and breathes the same air. Power over someone does not make you a better person. It only gives you a chance to show what kind of person you are.",
                    bullets = listOf(
                        InsightBullet("Same stock", "Seneca insists that people of every station share the same nature."),
                        InsightBullet("Power reveals", "How you treat those who cannot push back shows your character.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Looking Up",
                    blockquote = "as you would be treated by your betters.",
                    body = "The test is to imagine yourself on the other side. Seneca adds that as often as you think of how much power you hold over someone, remember that someone holds just as much over you. Fortune can turn quickly; he notes that people of high birth have been reduced to herding sheep. Treating others well is both just and wise.",
                    bullets = listOf(
                        InsightBullet("Swap places", "Picture how you would want to be treated in their position."),
                        InsightBullet("Fortune turns", "Anyone's status can change, so humility makes sense."),
                        InsightBullet("Friendly terms", "Seneca urges talking and planning with those who serve you.")
                    )
                )
            ),
            modernApplication = "Notice how you speak to someone today who has less power than you, such as a cashier, a junior colleague, or a service worker. Ask yourself, \"Is this how I want my own boss to speak to me?\" Adjust your tone if needed.",
            closing = "Treat those below you as you hope to be treated from above.",
            reflectionPrompt = "Who in your life has less power than you? Would you be content to be treated the way you treat them?"
        ),

        // q107 — Epictetus
        "q107" to QuoteInsight(
            intro = "Epictetus is speaking to someone who grieves at leaving friends and familiar places. What disturbs us, he says, is our opinions, and the cure is to keep a certain law before our eyes. Here he spells that law out in a few plain clauses.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Keeping to What Is Yours",
                    blockquote = "What is the divine law? To keep a man's own, not to claim that which belongs to others",
                    body = "For Epictetus, \"a man's own\" is his will: his judgments, choices, and character. Everything else, including bodies, places, and other people, belongs to the wider order of things. The divine law begins by telling you to keep hold of what is truly yours and not to grasp at what is not. Much unhappiness comes from reversing this.",
                    bullets = listOf(
                        InsightBullet("Your own", "Your judgments and choices are what truly belong to you."),
                        InsightBullet("Not yours", "Places, possessions, and other people's choices lie outside your keeping."),
                        InsightBullet("A reversed life", "Clinging to externals while neglecting your will brings distress.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Use, and Do Not Crave",
                    blockquote = "but to use what is given, and when it is not given, not to desire it.",
                    body = "The second part is about how to live with external things. When they are given, use them well. When they are not given, do not long for them. Epictetus continues that when a thing is taken away, you should give it up readily and be thankful for the time you had it. This turns life into a series of gifts to be enjoyed and returned.",
                    bullets = listOf(
                        InsightBullet("Use well", "What comes to you is meant to be used, not hoarded or feared."),
                        InsightBullet("Let absence be", "What has not come to you need not become a source of longing."),
                        InsightBullet("Thankful release", "Epictetus adds gratitude for the time you had with what leaves.")
                    )
                )
            ),
            modernApplication = "When you find yourself longing for something you do not have, say: \"This was not given to me now.\" Then turn to something that has been given, such as a friend, a skill, or an hour of free time, and use it well.",
            closing = "Use what is given, release what is taken, and want nothing else.",
            reflectionPrompt = "What are you craving that has not been given to you? What has been given that you are not using well?"
        ),

        // q108 — Epictetus
        "q108" to QuoteInsight(
            intro = "Epictetus opens a short discourse aimed at people who want to be admired. He imagines a student strutting about, hoping others will exclaim at what a great philosopher he is. The problem, he says, is a person who has lost his proper place.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Standing in Your Place",
                    blockquote = "When a man holds his proper station in life",
                    body = "A \"proper station\" is not a social rank. Epictetus means the right relationship to things: desiring and avoiding in line with nature, choosing and assenting well. When you are in that place, you are already content. Your attention rests on your own conduct, the one area where your good actually lives. There is nothing missing that applause could add.",
                    bullets = listOf(
                        InsightBullet("Not a rank", "Your station is your proper relationship to your own choices."),
                        InsightBullet("Already enough", "Doing your own part well leaves nothing for admiration to supply.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Need to Gape",
                    blockquote = "he does not gape after things beyond it.",
                    body = "To \"gape\" is to stare open-mouthed with longing. Epictetus pictures someone craving praise, fame, or status. He asks who exactly they want to be admired by, and points out that they often consider those same people foolish. Wanting their approval makes little sense. The person settled in their station has no reason to look around with longing.",
                    bullets = listOf(
                        InsightBullet("Open-mouthed want", "Gaping is the posture of someone who feels incomplete."),
                        InsightBullet("Whose approval", "Epictetus asks whether you even respect the people you want to impress."),
                        InsightBullet("Settled calm", "Contentment with your own conduct quiets the urge to be admired.")
                    )
                )
            ),
            modernApplication = "The next time you feel the urge to impress someone, ask: \"Do I respect this person's judgment enough to need their praise?\" Then turn your attention back to doing your own task well.",
            closing = "Hold your place well and the world's applause loses its pull.",
            reflectionPrompt = "Whose admiration do you find yourself chasing? Would you trust their judgment on anything else that matters?"
        ),

        // q109 — Seneca
        "q109" to QuoteInsight(
            intro = "In a letter about how to treat other people, Seneca gives the reason underneath all his advice. We share an origin and a destination. Nature made us family, and our duties to one another follow from that kinship.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Family Tree",
                    blockquote = "Nature produced us related to one another",
                    body = "Seneca says nature made us \"related,\" a family word. He means that every person, however distant or different, belongs to the same human family. He goes on to say nature planted affection in us and made us inclined toward friendship. Kindness, in this view, is not a rule laid on from outside. It is what our nature is already reaching toward.",
                    bullets = listOf(
                        InsightBullet("Kinship", "Every person is a relative in the widest sense."),
                        InsightBullet("Built for friendship", "Seneca says nature made us inclined toward mutual affection.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Same Source, Same End",
                    blockquote = "since she created us from the same source and to the same end.",
                    body = "This is the reason for the kinship: we all come from the same place and are heading to the same end. Seneca follows this with an image. Our relations are like a stone arch, which would fall if the stones did not support one another. Each person holds others up and is held up in turn. That is how the whole stands.",
                    bullets = listOf(
                        InsightBullet("Shared origin", "Everyone begins from the same source, whatever their station."),
                        InsightBullet("Shared end", "Everyone is headed for the same end, which levels pride."),
                        InsightBullet("The stone arch", "Seneca pictures people as stones that keep each other from falling.")
                    )
                )
            ),
            modernApplication = "When you meet someone very different from you today, say silently, \"Same source, same end.\" Let that remind you that you are relatives, and treat them with the ease you would give a cousin you have just met.",
            closing = "We are stones in one arch, each holding the others up.",
            reflectionPrompt = "Who seems most unlike you in your daily life? What would change if you thought of them as family?"
        ),

        // q110 — Epictetus
        "q110" to QuoteInsight(
            intro = "Epictetus is criticizing philosophy students who argue badly. Faced with someone untrained, they push a little, then mock or abuse the person and give up. He offers a better model: a guide who meets a lost traveler.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Finding the Lost",
                    blockquote = "A guide, when he has found a man out of the road, leads him into the right way",
                    body = "A guide's job is to help people who are lost. When the guide finds someone off the road, the response is simple: show them the way. Epictetus applies this to conversation. When someone holds a mistaken view, your task is to lead them gently toward the truth, not to prove how far off they are.",
                    bullets = listOf(
                        InsightBullet("The guide's role", "Helping the lost is the whole point of knowing the way."),
                        InsightBullet("Truth as a road", "Mistaken views are treated as wrong turns, not as crimes.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Mockery, No Abandonment",
                    blockquote = "he does not ridicule or abuse him and then leave him.",
                    body = "Epictetus names three failures: ridicule, abuse, and abandonment. Each one helps the guide feel superior while doing nothing for the lost traveler. He then turns the point around. If you cannot show someone the truth, do not mock them. Instead, recognize your own lack of skill. The failure of a conversation often says more about the teacher than the student.",
                    bullets = listOf(
                        InsightBullet("Three failures", "Mocking, insulting, and walking away all leave the person lost."),
                        InsightBullet("Own the gap", "If you cannot persuade someone, consider your own lack of skill."),
                        InsightBullet("Stay with them", "A good guide walks alongside until the road is found.")
                    )
                )
            ),
            modernApplication = "In your next disagreement, resist the urge to score a point. Instead, ask yourself, \"How would a guide help this person find the road?\" Offer one clear, patient explanation, and if it does not land, consider how you could explain it better.",
            closing = "A guide who mocks the lost has forgotten why he knows the way.",
            reflectionPrompt = "When did you last ridicule someone's view instead of helping them see more clearly? What would a guide have done?"
        ),

        // q111 — Seneca
        "q111" to QuoteInsight(
            intro = "Seneca has been describing a scandal from Rome's past: Clodius, a notorious politician, was acquitted at his trial because the jury itself was corrupted. Seneca's point is that vice is always available, while true integrity, like that of Cato, is rare.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Common Vice, Rare Virtue",
                    blockquote = "All ages will produce men like Clodius, but not all ages men like Cato.",
                    body = "Clodius stands for easy corruption, the kind every era produces. Cato the Younger was a Roman senator famous for his integrity, his plain living, and his opposition to Caesar. Seneca holds Cato up as a living example of something genuinely scarce. Every generation has its scoundrels; not every generation has someone who stays upright no matter what.",
                    bullets = listOf(
                        InsightBullet("Who Clodius was", "A Roman politician remembered for scandal and for escaping justice by corruption."),
                        InsightBullet("Who Cato was", "A senator known for integrity, simplicity, and refusing to bend to power."),
                        InsightBullet("Rarity of goodness", "Seneca suggests real integrity must be sought and treasured.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Easy Slope Down",
                    blockquote = "We degenerate easily, because we lack neither guides nor associates in our wickedness.",
                    body = "Seneca explains why vice is common. It never lacks company. There are always people ready to show us the way down and to join us on it. He adds that the road to vice is not only downhill but steep. Goodness, by contrast, often means walking a path with fewer companions, which is why examples like Cato matter so much.",
                    bullets = listOf(
                        InsightBullet("Never alone in vice", "Bad habits always find teachers and partners."),
                        InsightBullet("A steep slope", "Seneca says the way down is easy and fast."),
                        InsightBullet("Choose your company", "Since examples pull us, it matters whom we keep close.")
                    )
                )
            ),
            modernApplication = "Think of one person whose integrity you admire, living or historical. When you face a choice today, ask: \"What would they do here?\" Let their example be the guide that pulls you upward instead of down.",
            closing = "Scoundrels are never scarce; be glad of the upright and walk with them.",
            reflectionPrompt = "Who are your guides and companions right now? Are they pulling you toward the person you want to be?"
        ),

        // q112 — Seneca
        "q112" to QuoteInsight(
            intro = "Seneca has been discussing a saying of Epicurus: a wrongdoer may stay hidden, but can never be sure of staying hidden. Seneca agrees, and adds something stronger. Even before fear arrives, the deed itself has already done its damage.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Escape Hatch",
                    blockquote = "The punishment of crime",
                    body = "People often think of punishment as something that comes later: getting caught, being judged. Seneca says even a wrongdoer whom fortune protects can never truly go unpunished. Fortune may dress up the deed and shield it from discovery, but it cannot undo what the deed was. There is no clever way out, because the penalty does not wait to be imposed.",
                    bullets = listOf(
                        InsightBullet("Fortune cannot shield", "Luck may hide a wrong but cannot make it harmless."),
                        InsightBullet("Not deferred", "The real penalty does not depend on being caught.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Built Into the Deed",
                    blockquote = "lies in the crime itself.",
                    body = "Seneca says the first and worst penalty for doing wrong is having done it. The act makes the doer worse. Then a second set of penalties follows close behind: constant fear, unease, and distrust of one's own safety. Conscience, he says, keeps the wrongdoer trembling. The punishment is not an outside event but part of the deed's nature.",
                    bullets = listOf(
                        InsightBullet("First penalty", "Becoming someone who did wrong is the deepest cost."),
                        InsightBullet("Second penalty", "Fear and unease follow even when no one finds out."),
                        InsightBullet("Conscience", "Seneca describes it as a whip that keeps the wrongdoer restless.")
                    )
                )
            ),
            modernApplication = "When tempted by something you would rather no one knew about, ask: \"Am I willing to carry this, even if it is never discovered?\" Picture the quiet unease that would follow, and let that weigh in the decision.",
            closing = "A wrong carries its sentence inside it, waiting to be served.",
            reflectionPrompt = "Is there something you have done that still sits uneasily even though no one knows? What would it take to set it right?"
        ),

        // q113 — Epictetus
        "q113" to QuoteInsight(
            intro = "Epictetus points to Socrates as the model for how to argue. Socrates was famous for discussing hard questions with anyone. What set him apart, Epictetus says, was not his cleverness but his temper: he would not be provoked, and he ended quarrels instead of winning them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Unruffled in Debate",
                    blockquote = "This was the first and chief peculiarity of Socrates, never to be irritated in argument, never to utter anything abusive, anything insulting",
                    body = "\"First and chief\" means this was the most distinctive thing about him. Socrates could have been remembered for brilliance alone. Epictetus chooses his calm instead. He never lost his temper in argument and never resorted to insults. That restraint kept conversations open, because no one had to defend their pride against him.",
                    bullets = listOf(
                        InsightBullet("Calm before clever", "Epictetus ranks Socrates's temper above his wit."),
                        InsightBullet("No insults", "Abuse ends real conversation and turns it into a contest of pride.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Ending the Quarrel",
                    blockquote = "but to bear with abusive persons and to put an end to the quarrel.",
                    body = "Socrates did more than stay calm. He bore with people who were rude to him, and he actively ended quarrels. Epictetus says that reading Xenophon's Symposium, an account of a dinner party Socrates attended, shows how many disputes he settled. The goal of an argument, for Socrates, was understanding and peace, not victory.",
                    bullets = listOf(
                        InsightBullet("Bearing with rudeness", "He let insults pass without letting them steer him."),
                        InsightBullet("A settler of disputes", "Socrates used his skill to calm conflicts, not inflame them."),
                        InsightBullet("Peace as the goal", "A conversation went well if it ended in less conflict, not a winner.")
                    )
                )
            ),
            modernApplication = "In your next heated discussion, set yourself one goal: no insult, no sarcasm, no raised voice. If the other person gets abusive, let it pass and say something that lowers the temperature, such as \"Let's come back to this.\"",
            closing = "The best arguer in Athens was remembered for ending quarrels, not winning them.",
            reflectionPrompt = "In your last argument, what mattered more to you: being right or bringing it to a good end? What would Socrates have done?"
        ),

        // q114 — Seneca
        "q114" to QuoteInsight(
            intro = "Seneca urges Lucilius to help a friend become as good a man as possible. He says this will help Lucilius himself, then quotes a maxim: the best kindnesses are the ones that benefit the giver as much as the receiver.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Kindness That Flows Both Ways",
                    blockquote = "Those kindnesses, they tell us, are to be both sought for and bestowed, which benefit the giver no less than the receiver",
                    body = "Some kindnesses cost the giver and help only the receiver. Others enrich both. Seneca's example is helping a friend grow in character. As you encourage him toward virtue, you practice virtue yourself. You learn by teaching, steady yourself by steadying him. These are kindnesses worth seeking out, both to give and to receive.",
                    bullets = listOf(
                        InsightBullet("Two beneficiaries", "The best help leaves both people better off."),
                        InsightBullet("Teaching teaches you", "Helping someone grow strengthens your own growth."),
                        InsightBullet("Seek them out", "Seneca says such kindnesses are worth both asking for and offering.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Best Kind of Gift",
                    blockquote = "and they are unquestionably the best kind.",
                    body = "Why are these the best? Because they do not run out. A gift of money leaves the giver with less. A gift of encouragement, wisdom, or good example leaves the giver with more. Seneca adds that his friend's debt can be fully paid by goodwill alone, since character answers to no fortune. These are gifts no one can take away.",
                    bullets = listOf(
                        InsightBullet("They do not run out", "Gifts of character grow in the giving rather than shrinking."),
                        InsightBullet("Beyond fortune", "Seneca notes that fortune has no power over character.")
                    )
                )
            ),
            modernApplication = "Look for one chance today to help someone grow, not just to do a favor: share something you have learned, encourage a good habit, or model patience. Notice what you gain in the process.",
            closing = "The finest gifts leave both hands fuller than before.",
            reflectionPrompt = "Who in your life could you help become better, in a way that would also make you better? What is one step?"
        ),

        // q115 — Marcus Aurelius
        "q115" to QuoteInsight(
            intro = "Marcus asks himself a pointed question about doing good. After helping someone, why expect anything back? Being kind is simply what human beings are built for, the way an eye is built for seeing. Wanting payment misunderstands the act.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Already Paid",
                    blockquote = "What more do you want when you have done a man a service? Are you not content that you have done something conformable to your nature, and do you seek to be paid for it?",
                    body = "Marcus says the reward of a kind act is having done it. You acted in line with your nature, which is the deepest kind of success. Just before this, he notes that if you feel betrayed by an ungrateful person, part of the fault is yours for giving with strings attached. A service given freely is already complete when it is done.",
                    bullets = listOf(
                        InsightBullet("The act is the reward", "Acting well is its own payment, needing nothing more."),
                        InsightBullet("No strings", "Marcus warns that expecting thanks sets you up to feel cheated."),
                        InsightBullet("Content in giving", "A kind act is finished when it is done, not when it is repaid.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Eyes Do Not Bill",
                    blockquote = "Just as if the eye demanded a recompense for seeing, or the feet for walking.",
                    body = "The image is gently funny. Imagine your eyes demanding a fee each time they see, or your feet charging you for walking. They simply do what they are made for, and in doing it, they get what is theirs. Marcus says humans are made for kindness in the same way. When we help, we are working as designed, and that is enough.",
                    bullets = listOf(
                        InsightBullet("Built for it", "Kindness is to a person what sight is to an eye."),
                        InsightBullet("Functioning well", "Doing what you are made for is its own fulfillment.")
                    )
                )
            ),
            modernApplication = "After doing someone a favor today, catch the thought \"I hope they appreciate this.\" Replace it with \"I did what I am made for.\" Let the act be complete without waiting for thanks.",
            closing = "Your eyes never send a bill for seeing; let kindness keep the same terms.",
            reflectionPrompt = "Do you keep a quiet tally of the good you do for others? What would it feel like to let that tally go?"
        ),

        // q116 — Marcus Aurelius
        "q116" to QuoteInsight(
            intro = "Marcus gives himself a test for when something feels harmful. Ask whether it harms the community. If not, it has not truly harmed you either. He was an emperor responsible for a whole state, but the rule works for anyone who belongs to a larger whole.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wider Measure",
                    blockquote = "That which does no harm to the state",
                    body = "Marcus measures harm by its effect on the whole, not by how it feels to him personally. A slight, an inconvenience, a bruised ego may sting, but do they damage the shared life you belong to? Often they do not. By placing your own interest inside the common good, Marcus gives you a calmer scale for weighing events.",
                    bullets = listOf(
                        InsightBullet("Whole before part", "Judge an event first by what it does to the community."),
                        InsightBullet("A calmer scale", "Many personal stings shrink when weighed against the common good.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Follows for You",
                    blockquote = "does no harm to the citizen.",
                    body = "If the whole is unharmed, Marcus says, so are you. Your real good is bound up with the good of the community, so a thing that leaves the community intact leaves you intact too. He adds a second step: if the state is harmed, do not be angry with the person who caused it. Show him his error instead.",
                    bullets = listOf(
                        InsightBullet("Bound together", "Your good and the community's good rise and fall together."),
                        InsightBullet("Even then, no anger", "When real harm occurs, Marcus still prefers correction to rage."),
                        InsightBullet("A quick test", "He calls this a rule to apply whenever harm appears.")
                    )
                )
            ),
            modernApplication = "When something bothers you today, ask: \"Did this actually harm anyone, including the people I share life with?\" If the honest answer is no, let it go. If yes, look for a way to help repair it calmly.",
            closing = "If the whole is unharmed, so are you; let the sting pass.",
            reflectionPrompt = "What recent annoyance felt like harm but left the people around you untouched? How might you weigh it now?"
        ),

        // q117 — Seneca
        "q117" to QuoteInsight(
            intro = "Seneca's letter is about ingratitude: what to do when the same person both helped and hurt you. Justice, someone objects, means paying back thanks for good and ill will for harm. Seneca disagrees. The good weighs more than the bad.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Unequal Scales",
                    blockquote = "I do not set an equal value on benefits and injuries.",
                    body = "Many people keep an even ledger: one good deed against one bad deed. Seneca refuses that kind of bookkeeping. When the same person has helped you and later wronged you, he says the injury is cancelled by the earlier kindness. A person who has done you good deserves more than strict fairness when they fall short.",
                    bullets = listOf(
                        InsightBullet("No even ledger", "Seneca will not weigh a kindness and an injury as equals."),
                        InsightBullet("Kindness cancels", "A past benefit can outweigh a later wrong from the same person.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Benefit Weighs More",
                    blockquote = "I reckon a benefit at a higher rate than an injury.",
                    body = "Seneca prefers, as he says, to be the more indulgent judge, who tells us to forget the injury and remember the kindness. This is not naivety. It reflects a choice about what to keep in mind. Holding on to injuries poisons memory; holding on to benefits keeps relationships alive. He adds that only the wise know how much a benefit is truly worth.",
                    bullets = listOf(
                        InsightBullet("The indulgent judge", "Seneca chooses to remember kindness and let injury fade."),
                        InsightBullet("A choice of memory", "What you dwell on shapes how you treat people."),
                        InsightBullet("True value", "Seneca says a wise person sees how much a benefit really deserves.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "An Even Ledger",
                rightHeader = "Seneca's Scales",
                rows = listOf(
                    "One good, one bad, even" to "A benefit outweighs an injury",
                    "Remember the wrong" to "Remember the kindness",
                    "Strict fairness" to "Generous judgment"
                )
            ),
            modernApplication = "Think of someone who has both helped and hurt you. Write down three good things they did, then the one that stung. Read the list and let the benefits carry the weight Seneca gives them.",
            closing = "Weigh kindness heavier than injury, and memory becomes a kinder place.",
            reflectionPrompt = "Whose single fault have you been holding over their many kindnesses? What happens if you reverse the weights?"
        ),

        // q118 — Epictetus
        "q118" to QuoteInsight(
            intro = "Epictetus describes how a true friend treats people who are not like him. He has just said that a person who cuts out bad opinions will be fully a friend to those who share his values. Here he turns to everyone else, and his answer is generous.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Patience With the Unlike",
                    blockquote = "He will bear with the man who is unlike himself, he will be kind to him, gentle, ready to pardon on account of his ignorance",
                    body = "The person Epictetus describes does not demand that others think as he does. He bears with them, is kind and gentle, and readily pardons their mistakes. The reason is ignorance: they do not yet see clearly. Epictetus cites Plato's teaching that no one is deprived of truth willingly. If error is involuntary, pardon is the fitting response.",
                    bullets = listOf(
                        InsightBullet("Bearing with", "Tolerating difference is a form of strength, not weakness."),
                        InsightBullet("Unwilling error", "Epictetus follows Plato in saying no one chooses to be wrong."),
                        InsightBullet("Ready pardon", "Forgiveness comes easily once you see mistakes as ignorance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Harsh to No One",
                    blockquote = "on account of his being mistaken in things of the greatest importance; but he will be harsh to no man.",
                    body = "Even when someone is wrong about the most important things, about good and bad, how to live, Epictetus says to be harsh to no one. That is a high standard. The bigger the mistake, the stronger the pull to condemn. But a larger error is a greater misfortune for the one who holds it, which calls for more gentleness, not less.",
                    bullets = listOf(
                        InsightBullet("Big errors too", "Gentleness applies even to mistakes about what matters most."),
                        InsightBullet("No harshness", "Epictetus makes this a rule without exceptions."),
                        InsightBullet("Misfortune, not crime", "Deep error is something to pity, since it harms its holder.")
                    )
                )
            ),
            modernApplication = "When you meet someone whose views on something important seem badly wrong, pause before reacting. Tell yourself, \"They do not see it yet, and no one chooses to be wrong.\" Then respond with the same tone you would use with a friend.",
            closing = "The deeper someone's mistake, the gentler your answer can be.",
            reflectionPrompt = "Who holds views you find hardest to tolerate? What would it look like to be kind to them without agreeing?"
        ),

        // q119 — Seneca
        "q119" to QuoteInsight(
            intro = "Seneca imagines a single wise voice speaking above the noise of ambition. It tells you not to envy officials in purple or the great men cleared a path through the crowd. Real command, it says, starts somewhere much closer to home.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Rule That Harms No One",
                    blockquote = "If you would wield a command that is profitable to yourself, and injurious to nobody",
                    body = "Most power has costs. It wins for one person at another's expense. Seneca describes a different kind of command, one that benefits you and harms no one. He goes on to describe conquerors who stormed great cities but were themselves conquered by greed and desire for power. Their command was neither good for them nor harmless to others.",
                    bullets = listOf(
                        InsightBullet("A rare kind of power", "Seneca describes command that helps you and hurts no one."),
                        InsightBullet("Conquered conquerors", "He notes that great generals were often ruled by their own greed.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Start With Your Own Faults",
                    blockquote = "clear your own faults out of the way.",
                    body = "This kind of command is self-command. You clear away your own faults: greed, anger, vanity, fear. The more you master yourself, the freer you become, and no one is harmed in the process. Seneca's point is quietly radical. The most valuable rule you can hold is over your own character, and it is open to anyone.",
                    bullets = listOf(
                        InsightBullet("Self-command", "The best command is mastery of your own desires and habits."),
                        InsightBullet("Open to all", "No office or army is needed to rule yourself."),
                        InsightBullet("Clear the path", "Removing your own faults is the first step toward real freedom.")
                    )
                )
            ),
            modernApplication = "Pick one habit that rules you more than you would like, such as checking your phone, snapping when tired, or overspending. For one day, practice commanding it: notice the pull and choose differently once.",
            closing = "The only empire worth ruling is the one inside your own chest.",
            reflectionPrompt = "Which fault of yours holds the most power over you? What would it mean to take command of it?"
        ),

        // q120 — Epictetus
        "q120" to QuoteInsight(
            intro = "Epictetus is speaking to someone afraid of being despised for being gentle. No one can injure your will, he says, so why act afraid? Then he offers a bold suggestion: declare peace with everyone and smile at those who think they can hurt you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Public Peace",
                    blockquote = "Why do you not come forth and proclaim that you are at peace with all men whatever they may do",
                    body = "Epictetus asks why you hide your calm. If others cannot touch your will, then you can be at peace with them no matter how they behave. \"Whatever they may do\" is the key phrase. This peace does not depend on others being good. It rests on the fact that your judgments and choices are your own, and nothing they do can reach them.",
                    bullets = listOf(
                        InsightBullet("Unconditional peace", "Your peace need not wait for others to behave well."),
                        InsightBullet("Out of reach", "Others cannot touch your will, so your calm is safe."),
                        InsightBullet("Say it openly", "Epictetus suggests making your peace a stance, not a secret.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Laughing at the Besiegers",
                    blockquote = "and laugh at those chiefly who think that they can harm you?",
                    body = "Epictetus compares this to people in a well-supplied city mocking the besiegers outside: our wall is strong, we have food, your efforts are wasted. The soul's wall is its opinions. If your judgments are sound, those who try to harm you are laboring for nothing. The laugh is not cruel. It is the relaxed ease of someone who knows they are secure.",
                    bullets = listOf(
                        InsightBullet("The secure city", "Sound judgments make a mind as safe as a fortified town."),
                        InsightBullet("Wasted effort", "Those who try to harm your character have no way in."),
                        InsightBullet("Ease, not scorn", "The laughter is relief, not contempt for others.")
                    )
                )
            ),
            modernApplication = "When someone tries to provoke you, picture yourself inside a strong, well-stocked city. Say quietly, \"My wall is my judgment, and it holds.\" Let a small, relaxed smile replace the urge to fight back.",
            closing = "Your judgments are the wall; let the besiegers tire themselves out.",
            reflectionPrompt = "Who seems able to unsettle you most easily? What would it take to feel secure enough to smile at their efforts?"
        ),

        // q121 — Seneca
        "q121" to QuoteInsight(
            intro = "Seneca writes that the highest proof of wisdom is when word and deed agree. A person should be the same in every setting. He then suggests a practical step: choose one standard and let it govern every corner of your life.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Choose One Standard",
                    blockquote = "You should lay hold, once for all, upon a single norm to live by",
                    body = "\"Once for all\" means decide and be done. Seneca is tired of watching people shift their values to suit the moment. Just before this, he asks Lucilius to check whether his dress and his house match, whether he eats simply but builds lavishly. A single norm ends that kind of inconsistency. You know what you stand for, and you stand for it everywhere.",
                    bullets = listOf(
                        InsightBullet("Decide once", "Settling your standard saves endless renegotiation with yourself."),
                        InsightBullet("Check for mismatch", "Seneca suggests comparing your habits in different areas of life.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Life of One Color",
                    blockquote = "and should regulate your whole life according to this norm.",
                    body = "Seneca elsewhere in this letter says the inner life should be of one hue. The phrase \"whole life\" matters: not just public conduct, not just private habits, but all of it. Some people live simply at home and swagger in public, and he calls that a wavering mind. Applying one norm everywhere gives life a steady, unified character.",
                    bullets = listOf(
                        InsightBullet("One hue", "A consistent life looks the same in every light."),
                        InsightBullet("No public mask", "Seneca criticizes those who live one way at home and another in public."),
                        InsightBullet("Steadiness", "Consistency is a sign that the mind has found its balance.")
                    )
                )
            ),
            modernApplication = "Write one sentence that sums up how you want to live, such as \"Be honest and kind, and want little.\" For a week, check one decision a day against it, at home, at work, and with friends.",
            closing = "Pick your norm once, then let it rule every room you walk into.",
            reflectionPrompt = "Where does your life change color depending on who is watching? What single norm could make it one hue?"
        ),

        // q122 — Marcus Aurelius
        "q122" to QuoteInsight(
            intro = "This is one of Marcus's shortest notes, only a handful of words. It addresses two moments: when good fortune arrives, and when it leaves. The translator added the words \"wealth or prosperity\" in brackets to make clear what Marcus meant.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Gracious Arrival",
                    blockquote = "Receive wealth or prosperity without arrogance",
                    body = "When things go well, it is easy to feel you earned every bit of it, or to look down on those with less. Marcus warns against that. Elsewhere he praises his adoptive father, Antoninus, the emperor before him, for using good fortune without arrogance and without apology. Receiving success humbly means enjoying it while knowing it does not make you better than anyone.",
                    bullets = listOf(
                        InsightBullet("No swagger", "Prosperity is no proof of superior worth."),
                        InsightBullet("A model", "Marcus admired Antoninus, the emperor before him, for handling wealth humbly.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Open Hands",
                    blockquote = "and be ready to let it go.",
                    body = "The second half is just as important. Fortune comes and goes. A person who clings to prosperity lives in fear of losing it. Marcus asks for readiness: hold good things loosely, so that when they leave, you are not crushed. This readiness actually makes enjoyment easier, because it removes the anxiety of possession.",
                    bullets = listOf(
                        InsightBullet("Loose grip", "Holding prosperity lightly protects you when it changes."),
                        InsightBullet("Less fear", "Readiness to lose something frees you to enjoy it now."),
                        InsightBullet("Fortune moves", "Good times are real, but they are never guaranteed to stay.")
                    )
                )
            ),
            modernApplication = "When something good comes your way, such as a raise, praise, or a windfall, say to yourself: \"Welcome, and I know you may not stay.\" Enjoy it fully, and resist the urge to treat it as proof of your worth.",
            closing = "Take good fortune with open hands, so it can leave without tearing.",
            reflectionPrompt = "What good thing in your life are you gripping tightly? What would holding it more loosely change?"
        ),

        // q123 — Seneca
        "q123" to QuoteInsight(
            intro = "Seneca warns Lucilius against showy austerity: philosophy asks for plain living, not penance. Then he offers a balanced picture of greatness. What matters is not what you own but how you hold it, whether the dishes in front of you are clay or silver.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Clay Treated as Silver",
                    blockquote = "He is a great man who uses earthenware dishes as if they were silver",
                    body = "Using humble things with the respect you might give to fine ones shows contentment. The person who eats from clay dishes without shame or resentment is not diminished by them. Seneca has just said a philosopher's life should be simple but neat, with no rough clothing worn for show. Greatness here is being at ease with little.",
                    bullets = listOf(
                        InsightBullet("Content with little", "A great person is not lessened by simple things."),
                        InsightBullet("No show", "Seneca warns against using plainness to attract attention.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Silver Treated as Clay",
                    blockquote = "but he is equally great who uses silver as if it were earthenware.",
                    body = "The other side is just as important. A person who owns fine things but is not attached to them is equally great. They use the silver without being impressed by it or ruled by it. Seneca adds that being unable to endure riches is the sign of an unstable mind. True freedom is the same calm whether you have much or little.",
                    bullets = listOf(
                        InsightBullet("Unimpressed by wealth", "Fine things can be used without being worshipped."),
                        InsightBullet("Enduring riches", "Seneca suggests handling wealth well is a test of character too."),
                        InsightBullet("Same calm", "Greatness looks the same in poverty or abundance.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Unsteady Mind",
                rightHeader = "Great Mind",
                rows = listOf(
                    "Ashamed of clay" to "Uses clay as if it were silver",
                    "Dazzled by silver" to "Uses silver as if it were clay",
                    "Self-worth tied to things" to "Same calm with much or little"
                )
            ),
            modernApplication = "Look at one possession you value and one you consider plain. Use the plain one today with care and the valued one without fuss. Notice whether your sense of yourself shifts with either.",
            closing = "Greatness is the same hand holding clay or silver.",
            reflectionPrompt = "Which is harder for you: being content with plain things, or staying unattached to fine ones? Why?"
        ),

        // q124 — Seneca
        "q124" to QuoteInsight(
            intro = "Seneca has been explaining that the person who wants nothing is truly rich. A skeptical reader objects that this is just poverty in disguise. Seneca answers with a question that reframes wealth entirely: do you want much, or do you want enough?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Endless More",
                    blockquote = "Would you rather have much, or enough? He who has much desires more, a proof that he has not yet acquired enough",
                    body = "The question sounds simple, but the answer reveals something. A person with much keeps wanting more, which shows they still do not have enough. Wealth by itself does not satisfy desire; it often feeds it. Seneca's point is that \"much\" and \"enough\" are different targets. Chasing the first can keep you from ever reaching the second.",
                    bullets = listOf(
                        InsightBullet("Two targets", "Much is a quantity; enough is a state of mind."),
                        InsightBullet("Hunger proves lack", "Wanting more shows you have not yet reached enough.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Place to Stop",
                    blockquote = "but he who has enough has attained that which never fell to the rich man's lot: a stopping-point.",
                    body = "A stopping-point is the place where desire rests. Seneca says the merely rich never reach it, no matter how much they acquire. The person with enough has something the wealthy lack: the freedom to stop striving. He goes on to note that such riches also bring leisure in peacetime and are safe in war, because no one envies them.",
                    bullets = listOf(
                        InsightBullet("Desire at rest", "Enough means wanting no more than you have."),
                        InsightBullet("Rare for the rich", "Seneca says accumulation alone never brings this peace."),
                        InsightBullet("Safe wealth", "Riches of contentment cannot be seized or envied.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Having Much",
                rightHeader = "Having Enough",
                rows = listOf(
                    "Desires more" to "Desire comes to rest",
                    "Never satisfied" to "Already content",
                    "No stopping-point" to "A clear place to stop"
                )
            ),
            modernApplication = "Pick one area where you keep wanting more, such as money, clothes, or recognition. Decide today what \"enough\" would actually look like there. Write it down, and when the urge for more comes, check it against your line.",
            closing = "Much always wants more; enough knows where to stop.",
            reflectionPrompt = "Where in your life have you never defined enough? What would a stopping-point look like there?"
        ),

        // q125 — Seneca
        "q125" to QuoteInsight(
            intro = "Seneca writes that he has withdrawn from public life so he can write things useful to others. He imagines speaking to everyone at once, and this is the core of his advice: give the body what health requires, and no more.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Rule to Hold Fast",
                    blockquote = "Hold fast, then, to this sound and wholesome rule of life",
                    body = "Seneca calls this rule \"sound and wholesome,\" plain words for a plain idea. He has just warned that the gifts of fortune are snares: we think we hold them, but they hold us. A clear rule about the body gives you somewhere firm to stand. \"Hold fast\" suggests it will be tested, and that you will need to keep coming back to it.",
                    bullets = listOf(
                        InsightBullet("Firm ground", "A simple rule steadies you against fortune's lures."),
                        InsightBullet("Tested daily", "Holding fast means returning to the rule again and again.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Just What Health Needs",
                    blockquote = "that you indulge the body only so far as is needful for good health.",
                    body = "The measure is health, not pleasure or display. Seneca goes on to make it concrete: eat to relieve hunger, drink to quench thirst, dress to keep out the cold, and live in a house that shelters you. He adds that a person is sheltered as well by a thatch roof as by imported marble. Beyond what health needs, extra comfort adds little and can take much.",
                    bullets = listOf(
                        InsightBullet("Health as the measure", "Give the body what keeps it well, not what pampers it."),
                        InsightBullet("Thatch or marble", "Seneca notes a simple roof shelters as well as a grand one."),
                        InsightBullet("Freedom through enough", "Fewer bodily wants means fewer chains to fortune.")
                    )
                )
            ),
            modernApplication = "At your next meal, pause halfway and ask: \"Am I still hungry, or just eating?\" Let that question guide one choice today about food, drink, clothing, or comfort.",
            closing = "Feed the body for health, and the rest of you stays free.",
            reflectionPrompt = "Where do you give your body more than it needs, out of habit or comfort? What would Seneca's rule ask of you there?"
        ),

        // q126 — Marcus Aurelius
        "q126" to QuoteInsight(
            intro = "Marcus gives himself a short list of things to wear inwardly: simplicity, modesty, and calm toward the things that are neither good nor bad. Right after this, he adds three more words to himself: love mankind, follow God.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Simple Clothing for the Soul",
                    blockquote = "Adorn yourself with simplicity and modesty",
                    body = "\"Adorn\" usually means decorating with jewelry or fine clothes. Marcus flips it. The best ornaments are inner qualities: simplicity, which strips away pretense, and modesty, which refuses to inflate yourself. For an emperor who could wear anything, choosing these as his adornment says a great deal about what he valued.",
                    bullets = listOf(
                        InsightBullet("Inner ornaments", "Marcus treats character traits as the finest thing to wear."),
                        InsightBullet("Simplicity", "Being simple means having nothing to hide and nothing to prove."),
                        InsightBullet("Modesty", "Modesty keeps you honest about your size in the world.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Things Between",
                    blockquote = "and with indifference toward the things which lie between virtue and vice.",
                    body = "For Stoics, the things between virtue and vice are \"indifferents\": wealth, health, fame, comfort, and their opposites. They are not bad, but they are not your true good either. Being indifferent to them does not mean careless. It means not letting them define your worth. Marcus wants to care deeply about virtue and stay calm about everything else.",
                    bullets = listOf(
                        InsightBullet("Indifferents", "Stoics call things neither good nor bad, like wealth or fame, indifferents."),
                        InsightBullet("Calm, not careless", "Indifference means steadiness, not neglect."),
                        InsightBullet("Love and follow", "Marcus pairs this with a reminder to love mankind.")
                    )
                )
            ),
            modernApplication = "Before dressing or preparing for the day, add one inner item to your outfit: \"Today I wear simplicity,\" or \"Today I wear modesty.\" When something outside goes wrong, remember it lies between virtue and vice.",
            closing = "Dress your character plainly, and let fortune's weather pass by.",
            reflectionPrompt = "Which indifferent thing, such as money, health, or reputation, do you treat as if it were your true good? How might you hold it more lightly?"
        ),

        // q127 — Epictetus
        "q127" to QuoteInsight(
            intro = "Epictetus closes a talk about trades. Every time you chase an office or a reward, he says, you may be paying for it with your modesty, your fidelity, or your peace of mind. His advice is to guard the one good that is truly yours and treat everything else as allowed, not essential.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Guard What Is Yours",
                    blockquote = "Preserve that which is your own good in everything",
                    body = "For Epictetus, your own good is the condition of your will: honest, steady, free from fear. Nobody can hand it to you and nobody can take it, but you can give it away in a bad bargain. He pictures a rival who gains a public office while he keeps his decency, and he is content with his side of the trade. The word \"everything\" matters. No situation, large or small, puts this good off duty.",
                    bullets = listOf(
                        InsightBullet("Your side of the trade", "When someone gains something by bending, notice what you kept by not bending."),
                        InsightBullet("No days off", "The smallest choices, like a reply or a shortcut, are also places where your character is kept or spent.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Everything Else, Lightly Held",
                    blockquote = "as to every other thing, as it is permitted",
                    body = "Epictetus does not tell you to despise money, health, or position. You may have them and use them, as far as they are given and as far as you can handle them reasonably. The limit is the point where keeping them would require acting against reason. Then they stop being worth it. \"Content with this only\" is the quiet center: you need not demand more from outside than reason allows.",
                    bullets = listOf(
                        InsightBullet("Use, not grip", "Enjoy what comes your way while it is permitted, and let it go without a scene when it is not."),
                        InsightBullet("The reasonable line", "Ask whether holding on to a thing would require you to act in a way you could not defend.")
                    )
                )
            ),
            modernApplication = "Before a decision that tempts you, name the trade out loud: \"I would get the promotion, and I would pay with my honesty.\" Seeing both sides of the exchange often settles it. When the price is your character, the bargain is almost always a poor one.",
            closing = "Keep your own good whole, and every other trade becomes small.",
            reflectionPrompt = "What did you trade away recently that was worth more than what you received? What would it look like to keep it next time?"
        ),

        // q128 — Epictetus
        "q128" to QuoteInsight(
            intro = "A rhetorician on his way to Rome for a lawsuit stops to visit Epictetus between errands. When he worries that philosophy would leave him without land or silver cups, Epictetus turns the worry around: the man with many possessions is the one who needs more.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wealth of Not Needing",
                    blockquote = "I have no need of such things",
                    body = "Epictetus owned very little, and he did not apologize for it. His point is not that land and silver are evil, but that he has stopped depending on them. A person who does not need a thing cannot be made anxious by its absence. That freedom is a kind of wealth that never shows up in an inventory, and nobody can confiscate it.",
                    bullets = listOf(
                        InsightBullet("Need versus want", "Separate what you actually need from what you have simply grown used to having."),
                        InsightBullet("Nothing to guard", "What you do not depend on cannot be held over you as a threat.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "More Things, More Wants",
                    blockquote = "if you possess many things you have need of others",
                    body = "Possessions tend to call for more possessions. A big house wants furniture, staff, repairs, and a better street. Each thing brings new needs with it, so the person who owns much often feels shortest. Epictetus adds \"whether you choose or not\": this is how wanting works, not a matter of attitude. He then names what the visitor truly lacks: firmness, and a mind free from disturbance.",
                    bullets = listOf(
                        InsightBullet("The chain of wants", "Before buying, ask what further purchases or worries this one will bring along."),
                        InsightBullet("Real poverty", "Being short of steadiness is a deeper lack than being short of cash."),
                        InsightBullet("Choose or not", "Gathering more does not cure the feeling of not having enough; it often feeds it.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Rich in Things",
                rightHeader = "Rich in Not Needing",
                rows = listOf(
                    "Each purchase invites the next" to "A short list of real needs",
                    "Worry about loss" to "Little that can be taken",
                    "Always slightly short" to "Quietly enough"
                )
            ),
            modernApplication = "Pick one area where you keep upgrading: a phone, a wardrobe, a hobby kit. For a month, add nothing new and notice whether you actually feel poorer. Often the urge fades and you find that what you already had was enough.",
            closing = "The fewer your needs, the harder you are to make poor.",
            reflectionPrompt = "Which of your possessions has quietly created a list of new needs? Which could you do without and feel lighter?"
        ),

        // q129 — Epictetus
        "q129" to QuoteInsight(
            intro = "Epictetus offers a simple ruler for possessions. Your body's real needs, such as food, shelter, and clothing, set the measure, the way a foot sets the size of a shoe. Stay with that measure and you stay steady. Step past it and there is no natural place to stop.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Foot and the Shoe",
                    blockquote = "The measure of possession is to every man the body, as the foot is of the shoe.",
                    body = "A shoe has an obvious right size: it fits the foot. Too small and it hurts; too large and it trips you. Epictetus suggests that possessions work the same way. The body needs warmth, food, rest, and a roof, and those needs are real and limited. Measured against them, much of what we own and want is decoration. The rule is kind, not harsh: it gives you something firm to stand on.",
                    bullets = listOf(
                        InsightBullet("A fixed measure", "Bodily needs change little, so they make a steady standard for what is enough."),
                        InsightBullet("Fit, not excess", "Ask whether a thing serves a real need or only enlarges the shoe.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Slope Past Enough",
                    blockquote = "if you pass beyond it, you must then of necessity be hurried as it were down a precipice",
                    body = "In the full passage Epictetus goes on: once the shoe goes beyond the foot, it is gilded, then dyed purple, then embroidered. Past the measure set by need, every step invites the next, because there is no longer any natural limit. The precipice is an image of momentum. The first step past enough feels small, but it removes the line that kept you steady.",
                    bullets = listOf(
                        InsightBullet("Gilded, then purple", "Notice when an upgrade is quickly followed by an upgrade of the upgrade."),
                        InsightBullet("Keep the line", "A clear limit is easier to keep than a vague one you renegotiate each time.")
                    )
                )
            ),
            modernApplication = "Write down what your body actually needs this week: meals, sleep, warm clothes, a place to rest. Before your next purchase, ask which item on that list it serves. If it serves none, give it a waiting period and see whether the want survives.",
            closing = "Let the foot decide the shoe, and the shoe will stop growing.",
            reflectionPrompt = "Where in your life has a reasonable want started to slide past its natural limit? What would putting the line back look like?"
        ),

        // q130 — Epictetus
        "q130" to QuoteInsight(
            intro = "Near the end of his handbook, Epictetus warns students not to call themselves philosophers or lecture others about principles. Live them instead. His example is a dinner table, where the urge to comment on everyone's plate is strong and the better choice is simply to eat well yourself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Lectures at Dinner",
                    blockquote = "At a banquet do not say how a man ought to eat",
                    body = "It is easy to turn a new idea into a sermon. Someone learns about moderation and starts noticing who takes a second helping. Epictetus sees this as a trap. Talking about the rule feels like progress, but it mostly feeds pride, and it makes the meal worse for everyone. Among people who have not asked for your philosophy, your commentary is only noise.",
                    bullets = listOf(
                        InsightBullet("Unasked advice", "If no one asked how they should eat, your view on it is probably not needed."),
                        InsightBullet("Pride in disguise", "Correcting others can feel virtuous while quietly serving your own image.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Let the Plate Speak",
                    blockquote = "eat as you ought to eat",
                    body = "The real test is your own conduct. Eat with restraint and good manners, take what is fitting, and leave the rest. Later in the same passage Epictetus notes that sheep do not show the shepherd how much grass they ate; they digest it and give wool and milk. Your principles should show up the same way, in what you do rather than in what you announce.",
                    bullets = listOf(
                        InsightBullet("Wool, not grass", "Show what you have learned through how you act, not through explanations."),
                        InsightBullet("Quiet example", "A calm, moderate habit teaches more than a well-argued opinion.")
                    )
                )
            ),
            modernApplication = "The next time you feel the urge to comment on someone's diet, spending, or screen time, let the remark go and attend to your own choice instead. If anyone asks, answer briefly. Otherwise, let your conduct be the whole of your contribution.",
            closing = "Principles digested become character; principles recited become noise.",
            reflectionPrompt = "Where are you tempted to explain how others should live? What would it look like to simply live that way yourself, without comment?"
        ),

        // q131 — Marcus Aurelius
        "q131" to QuoteInsight(
            intro = "Marcus Aurelius was emperor of Rome, and in this private note he warns himself not to become \"a Caesar\" in the worst sense: proud, grand, and changed by power. He lists the plain qualities he wants to keep, and in the lines that follow he holds up Antoninus Pius, his adoptive father and the emperor before him, as his model.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Dyed by Power",
                    blockquote = "Take care that you are not made into a Caesar, that you are not dyed with this dye; for such things happen.",
                    body = "Dye soaks into cloth until you cannot wash it out. Marcus knew that power works the same way, slowly coloring how a person speaks, wants, and expects to be treated. \"Such things happen\" is an honest admission: he did not assume he was immune. The warning is not about the title itself but about letting the role replace the person who holds it.",
                    bullets = listOf(
                        InsightBullet("Slow coloring", "Changes in character from status usually arrive gradually, not all at once."),
                        InsightBullet("No immunity", "Assume that you, too, can be shaped by your position, and watch for it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Six Plain Words to Keep",
                    blockquote = "Keep yourself then simple, good, pure, serious, free from affectation, a friend of justice.",
                    body = "The remedy is a list of plain words. Simple means without show or complication. Serious means steady and attentive, not grim. Free from affectation means acting naturally instead of performing importance. A friend of justice cares more about what is fair than about what is flattering. Marcus could read this list in a few seconds, which made it useful on a crowded day.",
                    bullets = listOf(
                        InsightBullet("Simple", "Prefer the plain way of doing things over the impressive one."),
                        InsightBullet("Free from affectation", "Speak and act like yourself, not like someone playing a role."),
                        InsightBullet("A friend of justice", "Let fairness, not rank, decide how you treat people.")
                    )
                )
            ),
            modernApplication = "If you have gained any authority, such as a new title, a team, or a bit of local fame, check yourself once a week: am I speaking to people differently than I used to? Am I expecting more deference? Read Marcus's list and pick one word to practice that day.",
            closing = "A title is a coat you wear, not a dye you soak in.",
            reflectionPrompt = "Has any role you hold begun to color how you treat others? Which of Marcus's six qualities do you most need to keep today?"
        ),

        // q132 — Marcus Aurelius
        "q132" to QuoteInsight(
            intro = "Marcus spoke in the Roman senate, the council of leading citizens, and also to soldiers, servants, and petitioners. This short note reminds him to speak the same way to all of them: fittingly, without show, in plain words. It is a rule about speech that is really a rule about respect.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Voice for Everyone",
                    blockquote = "Speak both in the senate and to every man, whoever he may be, appropriately",
                    body = "Appropriately does not mean identically. You speak differently to a council than to a child. But the honesty and care underneath stay the same. Marcus is warning against a common split: polished, careful words for important people and careless ones for everyone else. \"Whoever he may be\" closes that gap. Each person deserves speech that fits the moment and treats them as someone who matters.",
                    bullets = listOf(
                        InsightBullet("Fit the moment", "Adjust tone and detail to the listener, but never your honesty."),
                        InsightBullet("No ranking", "Notice if your care in speaking rises and falls with the other person's status.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Plain Words Over Polish",
                    blockquote = "not with any affectation: use plain discourse.",
                    body = "Affectation is speech that performs: big words, studied phrases, a voice meant to impress. Marcus asks for plain discourse instead, words chosen to be understood. Plain speech is harder than it looks. It requires knowing what you actually mean and being willing to say it without decoration. It also respects the listener's time and intelligence.",
                    bullets = listOf(
                        InsightBullet("Say what you mean", "If you cannot say it simply, you may not yet know what you think."),
                        InsightBullet("Drop the costume", "Notice jargon or flourish you use mainly to sound impressive."),
                        InsightBullet("Respect the listener", "Clear words assume the other person is worth being understood by.")
                    )
                )
            ),
            modernApplication = "Before an important email or meeting, write your main point in one plain sentence a friend would understand, and then use that sentence. Later in the day, speak to a cashier or a new colleague with the same care you gave the meeting.",
            closing = "Speak to the senate as to the stranger, and to both plainly.",
            reflectionPrompt = "Who in your life gets your most careful words, and who gets the leftovers? What would plain, fitting speech sound like with both?"
        ),

        // q133 — Seneca
        "q133" to QuoteInsight(
            intro = "In his first letter to his friend Lucilius, Seneca writes about time, the possession we waste most freely. He admits he has lost some of his own, but he keeps an honest account of it. Then he offers this line: a person is not poor if what remains is enough.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "An Honest Ledger",
                    blockquote = "I do not regard a man as poor",
                    body = "Seneca speaks here like someone balancing accounts. He confesses that he wastes some time, but he knows how much, and why. That honesty is the first step out of poverty. A person who keeps no account feels vaguely short all the time. A person who knows what was spent and what is left can stop fretting and start using what remains. For Seneca, being poor is more about the fit than the amount.",
                    bullets = listOf(
                        InsightBullet("Know the numbers", "Looking honestly at where your time goes is less painful than guessing."),
                        InsightBullet("Record, not blame", "Note the losses without punishing yourself, then turn to what is left.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "When the Little Is Enough",
                    blockquote = "if the little which remains is enough for him",
                    body = "The line works for time and money alike. If what you have left is enough for what matters, you are not poor, whatever the total. Seneca adds a warning drawn from an old saying: it is too late to save when you reach the dregs of the cask, where what remains is little and poor. So begin now. Treat today's hours as the good wine near the top, not as something to stretch out later.",
                    bullets = listOf(
                        InsightBullet("Enough is decided", "Settle what the remaining time is for, and it will often prove sufficient."),
                        InsightBullet("Start at the top", "Spend your best hours on what matters before they turn into leftovers.")
                    )
                )
            ),
            modernApplication = "Tonight, write down roughly where your waking hours went today, without judgment. Then choose one hour tomorrow to spend deliberately on something you value. A small, chosen hour is worth more than a large, drifting afternoon.",
            closing = "Enough is not an amount; it is a fit between what remains and what matters.",
            reflectionPrompt = "If you knew exactly how much time you had this week, what would you make sure it was enough for?"
        ),

        // q134 — Seneca
        "q134" to QuoteInsight(
            intro = "Writing in his later years, Seneca reflects on growing old and on an old saying that one day is equal to every day. A single day holds the whole pattern of light and darkness. So he suggests living each day as a finished whole, complete in itself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Day With Its Own Shape",
                    blockquote = "Every day ought to be regulated as if it closed the series",
                    body = "Regulated is a quiet, practical word. It means arranged, put in order, given a shape. Seneca is not asking you to cram every pleasure into the day or to fear the night. He is asking you to live it so that it makes sense on its own: work done, kindness shown, loose ends tied where they can be. A well-ordered day does not need tomorrow to justify it.",
                    bullets = listOf(
                        InsightBullet("Shape, not speed", "Order the day around what matters instead of rushing to fit more in."),
                        InsightBullet("Tie small ends", "Finish the reply, the thanks, or the apology you would not want left hanging.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Rounded and Complete",
                    blockquote = "as if it rounded out and completed our existence",
                    body = "Seneca suggests going to sleep content, able to say, I have lived. If another day comes, receive it gladly as a gift. This is not gloomy. It frees you from the feeling that real life is always about to start. Each day can be a complete thing, and that makes it easier to enjoy the next one without grasping at it.",
                    bullets = listOf(
                        InsightBullet("I have lived", "End the day by naming what was good in it, however small."),
                        InsightBullet("Tomorrow as gift", "Greet a new morning as something extra rather than something owed.")
                    )
                )
            ),
            modernApplication = "Before bed tonight, ask: if this day were the whole story, is there anything I would want to set right? Do one small thing about it, such as sending the note or letting the argument go, and then rest. In the morning, take the new day as a bonus.",
            closing = "Let each evening find the day already whole.",
            reflectionPrompt = "What would you need to do today so that it felt complete by evening, even if nothing more came after it?"
        ),

        // q135 — Seneca
        "q135" to QuoteInsight(
            intro = "Seneca passes along a saying of Epicurus: live by nature and you will never be poor; live by opinion and you will never be rich. Then he explains why. Hunger, thirst, and cold can be satisfied, but wants built on other people's opinions have nowhere to stop.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Needs That Can Be Met",
                    blockquote = "Natural desires are limited",
                    body = "Natural desires come with their own finish line. A hungry person eats and is full. A cold person finds a coat and is warm. These needs are real and deserve to be met, and once met they quiet down. That is good news: the things your body and life truly require are mostly within reach, and they do not keep raising the price.",
                    bullets = listOf(
                        InsightBullet("A finish line", "Real needs end when they are satisfied, which makes them easy to recognize."),
                        InsightBullet("Within reach", "Most of what nature asks for is simple and close at hand.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Wants Without a Ceiling",
                    blockquote = "those which spring from false opinion can have no stopping-point",
                    body = "False opinion is the belief that something is necessary when it is only admired: the bigger car, the right address, the label others notice. These wants are measured against other people, and other people always have more. So no amount satisfies them. The trouble is not the thing itself but the mistaken belief that you need it to be well.",
                    bullets = listOf(
                        InsightBullet("Measured by others", "If a want would vanish once no one could see it, it likely springs from opinion."),
                        InsightBullet("No amount is enough", "Wants based on comparison move every time you reach them.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Natural Desire",
                rightHeader = "Desire From Opinion",
                rows = listOf(
                    "Ends when met" to "Moves when reached",
                    "Asks for bread and water" to "Asks for the best brand",
                    "Rarely makes you poor" to "Never lets you feel rich"
                )
            ),
            modernApplication = "When you notice a strong want, ask one question: would I still want this if no one else would ever know I had it? If the answer is no, you have found a want from opinion. You may still choose it, but you will choose it knowing it will not satisfy for long.",
            closing = "Hunger ends at the table; envy has no table to end at.",
            reflectionPrompt = "Which of your current wants has a clear stopping point, and which keeps moving whenever you get close to it?"
        ),

        // q136 — Seneca
        "q136" to QuoteInsight(
            intro = "Seneca has just come home from the public games feeling worse for the experience. Crowds, he tells Lucilius, wear down a person who is still forming good habits. His advice has two parts: spend more time in your own company, and choose companions who help you grow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Time in Your Own Company",
                    blockquote = "Withdraw into yourself, as far as you can.",
                    body = "This is not a call to hide from the world. Seneca means turning inward to think, read, and steady yourself, instead of soaking up the moods of a crowd. \"As far as you can\" is realistic. Most of us cannot leave our work or our families, but we can protect some quiet hours. Those hours are where your own judgment gets a chance to speak.",
                    bullets = listOf(
                        InsightBullet("Steady first", "Character still in progress is easily shaken; quiet time lets it settle."),
                        InsightBullet("As far as you can", "Look for small, realistic pockets of solitude rather than a grand retreat.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Company That Lifts You",
                    blockquote = "Associate with those who will make a better man of you.",
                    body = "We take on the habits of the people around us, often without noticing. Seneca suggests choosing that influence on purpose. Spend time with people whose patience, honesty, or discipline you would like to share. Right after this line he adds that you should also welcome those you can help, because people learn while they teach. Good company works in both directions.",
                    bullets = listOf(
                        InsightBullet("Choose your influences", "Notice who leaves you calmer and kinder, and see them more often."),
                        InsightBullet("Teach to learn", "Helping someone else improve sharpens your own understanding.")
                    )
                )
            ),
            modernApplication = "Look back at the last week and note which gatherings left you restless and which left you better. Keep one evening free for reading or a long walk alone. Then make a plan to see the friend whose company makes you want to be a little better.",
            closing = "Choose your company as you would choose your habits, because it becomes them.",
            reflectionPrompt = "Who in your life makes you a better person just by being around them? When will you next spend time with them?"
        ),

        // q137 — Seneca
        "q137" to QuoteInsight(
            intro = "Lucilius was making real progress, and Seneca warns him against one trap: showing off his philosophy through rough clothes, an unkempt beard, or a hard bed. Philosophy, he says, asks for a simple life, not for self-punishment or a public display of austerity.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Plain Without Penance",
                    blockquote = "Philosophy calls for plain living, but not for penance",
                    body = "Penance is suffering taken on as a show of seriousness, and Seneca has no use for it. A plain life means not needing luxuries; it does not mean making yourself miserable. Hardship worn in public can become its own kind of vanity, a way of being noticed for how little you have. The aim is freedom from excess, not a new costume of poverty.",
                    bullets = listOf(
                        InsightBullet("Simple, not severe", "Living plainly means wanting little, not hurting yourself on purpose."),
                        InsightBullet("Austerity as vanity", "If a hardship is mainly for others to see, it serves pride, not virtue.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Neat and Unassuming",
                    blockquote = "we may perfectly well be plain and neat at the same time",
                    body = "Seneca wants an inner difference with outward ordinariness. Dress cleanly and modestly, keep a tidy home, eat simple food well prepared. None of this draws a crowd or pushes people away. In the same letter he says the first thing philosophy promises is fellow feeling with all people. A strange appearance would put a wall between you and the people you hope to live alongside.",
                    bullets = listOf(
                        InsightBullet("Clean and modest", "Plain things can still be cared for and pleasant to use."),
                        InsightBullet("No walls", "Avoid habits whose main effect is to set you apart from others."),
                        InsightBullet("Different inside", "Let the change be in your judgment, not in your costume.")
                    )
                )
            ),
            modernApplication = "If you are trying to simplify your life, check that it is not turning into a performance. Keep your clothes clean, your home tidy, and your meals simple and good. Let the simplicity show in what you no longer chase, not in how hard you appear to live.",
            closing = "Wear simplicity like clean linen, not like a hair shirt.",
            reflectionPrompt = "Is any part of your effort to live simply aimed more at being seen than at being free? What would the quieter version look like?"
        ),

        // q138 — Epictetus
        "q138" to QuoteInsight(
            intro = "Epictetus is talking about how a person keeps their proper character in every situation. Some people will sell their integrity for a dinner or a favor. He asks you to look at the deal plainly: if your will must have a price, at least do not let it go cheaply.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Name the Price",
                    blockquote = "Consider at what price you sell your own will",
                    body = "The will, for Epictetus, is your power to choose, judge, and consent. It is the most valuable thing you have and the one thing fully in your control. Yet people trade it away all the time: agreeing to what they think is wrong to avoid an awkward moment, or flattering to keep a seat at the table. Epictetus asks you to stop and name the price before you sign.",
                    bullets = listOf(
                        InsightBullet("Name the trade", "When you are about to go along with something, ask what you are getting for it."),
                        InsightBullet("Small sales add up", "Most compromises are cheap ones, made quickly and repeated often.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Never for a Trifle",
                    blockquote = "if for no other reason, at least for this, that you sell it not for a small sum",
                    body = "There is a touch of humor here. Epictetus meets his listeners where they are. If you are not yet ready to treat your integrity as priceless, at least stop selling it for trifles. In the lines that follow he admits that few become a Socrates, the Athenian philosopher he admired most. But no one neglects their body just because they will never be a champion. Progress starts with refusing the cheap deals.",
                    bullets = listOf(
                        InsightBullet("Start somewhere", "You do not need to be a sage to refuse a bad bargain today."),
                        InsightBullet("Raise the price", "Each time you decline a trifling compromise, your will becomes harder to buy.")
                    )
                )
            ),
            modernApplication = "Think of one small compromise you make regularly, such as laughing at a joke you dislike or saying yes when you mean no. Next time, pause and ask, \"Is this worth my agreement?\" If the honest answer is no, decline kindly. That one refusal raises the price of your will.",
            closing = "If your will must have a price, make it too high to pay.",
            reflectionPrompt = "What is the smallest thing you have recently traded your honest judgment for? Was it worth it?"
        ),

        // q139 — Epictetus
        "q139" to QuoteInsight(
            intro = "Epictetus compares life to a dinner where dishes are passed around the table. Some reach you, some pass by, some have not arrived yet. The guest who waits calmly and takes a fair share, he says, will one day be worthy to dine with the gods.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Take Your Portion",
                    blockquote = "Stretch out your hand and take a portion with decency.",
                    body = "When good things come within reach, Epictetus does not ask you to refuse them. Take them, with decency: a fair share, without grabbing or heaping your plate. Friendship, work, comfort, and honor are all dishes on the table. Enjoy what comes to you, and be the kind of guest who leaves enough for others.",
                    bullets = listOf(
                        InsightBullet("Accept the good", "There is no virtue in refusing what is fairly offered to you."),
                        InsightBullet("A fair share", "Take what is yours to take, and leave the rest for the next person.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Let the Dish Pass",
                    blockquote = "Suppose that it passes by you. Do not detain it.",
                    body = "The harder part is watching a dish pass you by. The promotion goes to someone else; the invitation never comes. Epictetus says do not grab at it, and in the full passage, do not send your desire ahead to dishes not yet near you. Waiting your turn calmly keeps you free. Craning after every plate only makes the meal anxious.",
                    bullets = listOf(
                        InsightBullet("No grabbing", "When something passes you by, let it go without reaching after it."),
                        InsightBullet("Do not lean ahead", "Wanting what has not yet reached you spoils what is already in front of you."),
                        InsightBullet("Patient guest", "Trust that your turn will come, and enjoy the company meanwhile.")
                    )
                )
            ),
            modernApplication = "When something good goes to someone else, picture the dish moving down the table and say to yourself, \"That one was passing by.\" Then turn back to what is in front of you, the work, the meal, the people, and give it your full attention.",
            closing = "Good guests take with grace and let dishes pass without a sigh.",
            reflectionPrompt = "What dish has recently passed you by? What is already on your plate that you have been too distracted to enjoy?"
        ),

        // q140 — Seneca
        "q140" to QuoteInsight(
            intro = "Seneca is arguing that short maxims do real good, because they go straight to the heart. One example he gives comes from the famous sayings of Cato the Elder, an earlier Roman statesman known for his thrift and plain habits: buy only what you must have.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Need Versus Must",
                    blockquote = "Buy not what you need, but what you must have.",
                    body = "The line sounds odd at first, since need and must seem the same. Here \"need\" means the loose way we use the word: I need a new jacket, I need that gadget. \"Must have\" is stricter: what you cannot do without. By pulling the two apart, the saying shows how many of our needs are really preferences in disguise.",
                    bullets = listOf(
                        InsightBullet("Loose need", "Notice how often you say \"I need\" about things you simply like."),
                        InsightBullet("Strict must", "Ask whether you could actually manage without this, even if less comfortably.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Dear at Any Price",
                    blockquote = "That which you do not need, is dear even at a farthing.",
                    body = "A farthing was the smallest coin, a quarter of a penny. Even at that price, the saying goes, an unneeded thing is expensive. The real cost is not only the money. It is the space, the care, the clutter, and the habit of buying without thinking. A bargain on something you do not need is not a bargain at all.",
                    bullets = listOf(
                        InsightBullet("The hidden bill", "Unneeded things cost storage, upkeep, and attention long after the sale."),
                        InsightBullet("Sales are not savings", "Paying less for something unnecessary still costs more than buying nothing.")
                    )
                )
            ),
            modernApplication = "Before your next purchase, say Cato's line quietly: must I have this? If the answer is \"not really,\" walk away from it for a day. If the urge returns and the reason holds up, buy it without guilt. If not, you kept both the coin and the clutter.",
            closing = "An unneeded bargain is the most expensive thing in the shop.",
            reflectionPrompt = "What did you buy recently because it was cheap rather than because you must have it? What did it really cost you?"
        ),

        // q141 — Seneca
        "q141" to QuoteInsight(
            intro = "Seneca closes a letter about mastering the passions with a frank diagnosis. People say they cannot control their emotions. Seneca disagrees: nature gave us enough strength. What we lack is the will to use it, and we cover that lack with talk of inability.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Strength Already Given",
                    blockquote = "We mortals have been endowed with sufficient strength by nature",
                    body = "Seneca is not flattering anyone. He is simply saying the capacity is already there. You do not need a special gift to resist anger or excess. But strength must be used, gathered, and pointed in one direction. Many of us scatter our efforts, half resisting and half indulging, so our own powers work against each other. The first step is to stop hindering yourself.",
                    bullets = listOf(
                        InsightBullet("Already equipped", "Assume you have enough strength for today's task, and act on that."),
                        InsightBullet("Stop working against yourself", "Remove one habit that undoes the effort you are making elsewhere.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Reason and Excuse",
                    blockquote = "The reason is unwillingness, the excuse, inability.",
                    body = "This is the sharpest line in the letter, and Seneca means it kindly. Just before it, he says we are in love with our vices and would rather make excuses for them than shake them off. \"I can't\" is often a softer way of saying \"I don't want to yet.\" Naming the difference is not an accusation. It returns the choice to you, which is where Seneca believes it belongs.",
                    bullets = listOf(
                        InsightBullet("Translate the phrase", "When you hear yourself say \"I can't,\" test whether \"I won't\" is more accurate."),
                        InsightBullet("Choice restored", "Admitting unwillingness is hopeful, because willingness can change.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Excuse",
                rightHeader = "The Reason",
                rows = listOf(
                    "I can't stop" to "I don't want to stop yet",
                    "I'm not the type" to "I haven't tried steadily",
                    "It's too hard" to "It's uncomfortable"
                )
            ),
            modernApplication = "Pick one habit you have called impossible to change. Write \"I can't\" at the top of a page and \"I won't, because\" beneath it, then finish the second sentence honestly. The reason you write is the real obstacle, and it is usually smaller than inability.",
            closing = "Most of what we call can't is won't wearing a softer coat.",
            reflectionPrompt = "Where do you say you are unable when you are really unwilling? What would one willing step look like this week?"
        ),

        // q142 — Epictetus
        "q142" to QuoteInsight(
            intro = "In a chapter of short rules for daily conduct, Epictetus begins with speech. Most of the time, he suggests, silence is enough. When speaking is needed, say what is needed and say it briefly. Talk about gladiators, horse races, and food, he adds, rarely needs your voice.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Silence by Default",
                    blockquote = "Let silence be the general rule",
                    body = "Epictetus does not ban speech. He makes silence the starting point, the place you return to when nothing needs saying. Much talk is filler: repeating news, comparing people, keeping the air busy. Quiet gives you room to listen and to notice what is really going on. It also spares you many of the small regrets that follow careless words.",
                    bullets = listOf(
                        InsightBullet("Start from quiet", "Let speaking be a choice you make, not a reflex you follow."),
                        InsightBullet("Room to listen", "Silence gives other people space to finish their thought.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Few and Needed Words",
                    blockquote = "let only what is necessary be said, and in few words",
                    body = "When you do speak, Epictetus offers two filters. Is it necessary? Can it be said briefly? In the same chapter he names what to avoid most: idle chatter about games and meals, and above all praising, blaming, or comparing people. Brief, needed words carry more weight because they are not buried in noise.",
                    bullets = listOf(
                        InsightBullet("Two filters", "Ask whether it needs saying, and whether it can be said shorter."),
                        InsightBullet("Leave people out", "Skip remarks that grade or compare others who are not present.")
                    )
                )
            ),
            modernApplication = "At your next meeting or dinner, let one comment you were about to make go unsaid and see whether anything is lost. When you do speak, aim for one clear sentence instead of three. Notice how people listen more closely when you talk less.",
            closing = "Words kept few are words that are heard.",
            reflectionPrompt = "What conversations do you fill with talk you later wish you had skipped? Where would a little more silence serve you?"
        ),

        // q143 — Seneca
        "q143" to QuoteInsight(
            intro = "During Saturnalia, the noisy December festival when all of Rome feasted, Seneca suggested an odd exercise to Lucilius. For a few days, live on the plainest food and the roughest clothes, and ask yourself whether this is really what you were afraid of.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Rehearsal of Little",
                    blockquote = "Set aside a certain number of days, during which you shall be content with the scantiest and cheapest fare, with coarse and rough dress",
                    body = "Seneca means a real practice, not an imagined one. Choose a few days, eat simply, dress plainly, and live with less than usual. He compares it to soldiers drilling in peacetime, with no enemy in sight, so that they are ready when trouble comes. The exercise is voluntary and brief. That is what makes it calming: you meet the thing you fear on your own terms.",
                    bullets = listOf(
                        InsightBullet("Drill in peacetime", "Rehearse simplicity while life is easy, so it is familiar if life gets hard."),
                        InsightBullet("Brief and chosen", "A few planned days are enough; the point is learning, not suffering.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Fear Up Close",
                    blockquote = "Is this the condition that I feared?",
                    body = "Much of our worry about losing comfort comes from never having looked at it closely. From a distance, a simpler life seems frightening. Up close, plain bread and a worn coat are ordinary and bearable. Seneca's question lets the fear shrink to its true size. Once you have seen that you can be content with little, you can enjoy what you have without dreading its loss.",
                    bullets = listOf(
                        InsightBullet("Shrink the fear", "Meeting a feared condition often shows it is smaller than imagined."),
                        InsightBullet("Enjoy without dread", "Knowing you could manage on less lets you relax into what you have.")
                    )
                )
            ),
            modernApplication = "Choose a weekend to eat simple meals, skip the paid entertainment, and wear your plainest clothes. Halfway through, ask Seneca's question out loud. Write down what you notice, and keep the note for the next time you find yourself worrying about money.",
            closing = "Meet the plain life once, and it stops haunting the comfortable one.",
            reflectionPrompt = "What loss of comfort do you most dread? How could you safely taste a small piece of it and see how it actually feels?"
        ),

        // q144 — Seneca
        "q144" to QuoteInsight(
            intro = "Lucilius was spending a lot of effort on physical training, lifting weights and building muscle. Seneca does not object to keeping the body healthy, but he warns against letting it take over. Give the body what it needs, he says, and give the mind room to grow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Body in Its Place",
                    blockquote = "Limit the flesh as much as possible",
                    body = "Seneca is not against health. In the same letter he recommends short, simple exercises like running and jumping. His concern is proportion. When looking after the body becomes the main project, with heavy meals, long hours of training, and constant attention, it crowds out everything else. Limiting the flesh means giving it what keeps it well and then stopping.",
                    bullets = listOf(
                        InsightBullet("Short and simple", "Keep exercise brief and useful rather than all-consuming."),
                        InsightBullet("Enough, then stop", "Care for the body until it is well, not until it is the center of life.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Room for the Spirit",
                    blockquote = "allow free play to the spirit",
                    body = "Free play suggests movement and room, not grim effort. Seneca wants the mind to have time to read, think, and reflect, the way a runner wants open ground. He notes that the mind should be exercised day and night, and that this kind of exercise is not stopped by bad weather or even old age. The time you gain by not overdoing the physical can go to what makes you wiser and calmer.",
                    bullets = listOf(
                        InsightBullet("Always available", "The mind can be trained anywhere, with a book, a walk, or a quiet moment."),
                        InsightBullet("Balanced effort", "Match the hours spent on the body with some time spent on the mind.")
                    )
                )
            ),
            modernApplication = "Look at how many hours this week go to your appearance, fitness, or food, and how many go to reading or reflection. If the balance is lopsided, trade thirty minutes of the first for the second. Keep exercising, but let it be one part of the day, not its whole shape.",
            closing = "Keep the body fit enough to carry a mind that keeps growing.",
            reflectionPrompt = "Is your care for your body serving your life, or starting to replace it? Where could your mind use more room to move?"
        ),

        // q145 — Epictetus
        "q145" to QuoteInsight(
            intro = "Epictetus notes that every habit grows by use. Walking strengthens walking, reading strengthens reading, and anger strengthens anger. So if you want a habit, practice it. If you want to lose one, stop feeding it and put something else in its place.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Habits Grow by Use",
                    blockquote = "If you would make anything a habit, do it",
                    body = "Epictetus gives plain examples: a good reader reads, a good writer writes. Skip reading for thirty days and you will notice the loss. Lie in bed for ten and your legs grow weak. The same is true of character. Patience grows by being patient, honesty by being honest. There is no shortcut around repetition, but there is no mystery either: you become what you keep doing.",
                    bullets = listOf(
                        InsightBullet("Repetition builds", "Small daily practice does more than rare, intense effort."),
                        InsightBullet("Use or lose", "A skill or virtue left unused quietly weakens.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Replace, Don't Just Resist",
                    blockquote = "accustom yourself to do something else in place of it",
                    body = "Stopping a habit is only half the work. Epictetus says that each time you give in to anger, you strengthen the habit, like throwing fuel on a fire. Simply resisting leaves an empty space that the old habit rushes back to fill. So choose a replacement. When the urge comes, do something else on purpose, until the new response is the familiar one.",
                    bullets = listOf(
                        InsightBullet("Fuel or water", "Each repetition either feeds a habit or starves it; none is neutral."),
                        InsightBullet("Fill the gap", "Pick a specific action to do when the old urge appears."),
                        InsightBullet("Count calm days", "Epictetus suggests noting how many days you go without the old reaction.")
                    )
                )
            ),
            modernApplication = "Choose one habit you want to weaken, like reaching for your phone when bored. Decide in advance what you will do instead: stand up, take three slow breaths, or read one page. Each time you swap, mark it down. After a few weeks, the new action will begin to feel like yours.",
            closing = "Feed the habit you want and let the other one go hungry.",
            reflectionPrompt = "What habit have you been feeding without meaning to? What will you do in its place the next time it calls?"
        ),

        // q146 — Marcus Aurelius
        "q146" to QuoteInsight(
            intro = "Marcus pictures the busy crowds of earlier reigns, marrying, feasting, quarreling, and chasing office, all of them long since passed. From that wide view he draws a modest rule: give each thing the amount of attention it actually deserves, and no more.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Attention Has a Price",
                    blockquote = "the attention given to everything has its proper value and proportion",
                    body = "Attention is limited, and Marcus treats it like a budget. Some things deserve a great deal: your duties, the people you love, your own conduct. Others deserve a glance: a rumor, a slight, a small inconvenience. Trouble starts when the proportion slips and a minor matter takes the hours a major one needed. Seeing attention as something with value helps you spend it on purpose.",
                    bullets = listOf(
                        InsightBullet("A budget", "Treat your attention as limited, because it is."),
                        InsightBullet("Match the weight", "Give large things large care and small things small care.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Small Things, Small Share",
                    blockquote = "you will not be dissatisfied, if you apply yourself to smaller matters no further than is fit",
                    body = "Marcus links proportion to contentment. When you pour too much energy into a minor matter, you end up frustrated, partly because the result never repays the effort. Giving small things only what is fit leaves you free for what matters and spares you the letdown of overinvesting. It is a practical way to keep your days from being eaten by trifles.",
                    bullets = listOf(
                        InsightBullet("Avoid overinvesting", "Too much effort on a trifle leads to irritation when it fails to satisfy."),
                        InsightBullet("Fit, not more", "Decide how much a task deserves before you start, then stop there.")
                    )
                )
            ),
            modernApplication = "Before starting a task, give it a rough size: five minutes, an hour, a day. When a minor issue begins to swallow more than its share, notice it and say, \"This is a five-minute matter.\" Then close it and move to something that deserves the time.",
            closing = "Pay each matter what it is worth and no more.",
            reflectionPrompt = "What small matter has taken more of your attention than it deserves lately? What larger thing has gone short because of it?"
        ),

        // q147 — Seneca
        "q147" to QuoteInsight(
            intro = "Seneca tells Lucilius that until he respects himself enough to be his own guard, he should keep a good person in mind as a watcher. He names Roman examples: Cato, famed for integrity; Scipio, a celebrated general; and Laelius, Scipio's close friend, known for his wisdom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "An Imagined Witness",
                    blockquote = "Set as a guard over yourself the authority of some man",
                    body = "Just before this line, Seneca quotes Epicurus: do everything as if someone were watching you. Solitude, he admits, tempts us toward things we would never do in company. So choose a person whose good opinion you value and keep them in mind as a witness. Seneca adds that once you respect yourself enough, you can send this guard away. Until then, borrow someone's steadiness.",
                    bullets = listOf(
                        InsightBullet("Borrowed conscience", "Picture a respected person beside you when you are tempted to cut corners."),
                        InsightBullet("Temporary help", "The goal is to become your own witness in time.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Presence That Steadies",
                    blockquote = "any man in whose presence even abandoned wretches would check their bad impulses",
                    body = "The guard need not be famous. Seneca's test is simple: someone whose presence alone makes people behave better. Most of us know such a person, a grandparent, a teacher, or a friend whose quiet integrity changes the room. Keeping them in mind is not about fear of judgment. It reminds you of who you want to be when no one else is looking.",
                    bullets = listOf(
                        InsightBullet("The room-changer", "Think of someone whose calm decency makes others more careful."),
                        InsightBullet("Not fear, but aim", "Let the imagined witness remind you of your own standards."),
                        InsightBullet("Become one", "Seneca hopes you will grow into the kind of presence that steadies others.")
                    )
                )
            ),
            modernApplication = "Pick one person you deeply respect and keep their name in mind for a day. When you face a small choice, such as how to answer a rude email or whether to take a shortcut, ask what you would do if they were sitting beside you. Then do that.",
            closing = "Borrow a good witness until you can be your own.",
            reflectionPrompt = "Whose presence would make you behave a little better right now? What would you do differently today if they were watching?"
        ),

        // q148 — Seneca
        "q148" to QuoteInsight(
            intro = "Seneca opens a letter with a playful promise: he will show Lucilius the quickest way to become rich. The secret comes from a famous saying of Cato the Elder, the old Roman statesman known for thrift. You will need a loan, Seneca jokes, but the lender is yourself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Creditor Within",
                    blockquote = "Borrow from yourself",
                    body = "Seneca enjoys the joke. Lucilius expects advice about money, and instead he gets a lender who charges no interest and is always available. Borrowing from yourself means meeting your needs by reducing your wants, rather than by getting more. Your own resources, such as patience, simplicity, and contentment, are a bank you can draw on without asking anyone's permission.",
                    bullets = listOf(
                        InsightBullet("Always open", "Your ability to want less is a resource no one can freeze or call in."),
                        InsightBullet("No interest", "Contentment drawn from within leaves you owing nothing to anyone.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Enough From Your Own",
                    blockquote = "No matter how small it is, it will be enough if we can only make up the deficit from our own resources.",
                    body = "The size of your means matters less than whether they cover your wants. If you can close the gap from within, by needing a little less, even a small amount is enough. Seneca adds right after this that it makes no difference whether you crave nothing or possess something. Either way, the prize is the same: freedom from worry.",
                    bullets = listOf(
                        InsightBullet("Close the gap", "When money is short, look first at shrinking the want, not only at growing the income."),
                        InsightBullet("Freedom from worry", "The wealth Seneca offers is not more, but less anxiety about more.")
                    )
                )
            ),
            modernApplication = "Next time you feel short of money, time, or anything else, ask: can I borrow from myself here? Perhaps you can do without the upgrade, cook instead of ordering, or skip one commitment. Make up the deficit from within once, and notice how it feels to owe nothing.",
            closing = "The kindest creditor asks only that you want a little less.",
            reflectionPrompt = "Where in your life could you close a gap by wanting less instead of getting more? What would that free you from?"
        ),

        // q149 — Epictetus
        "q149" to QuoteInsight(
            intro = "Epictetus offers a simple method for handling a tempting pleasure. Do not let the first impression sweep you along. Make the pleasure wait, give yourself a pause, and in that pause look at both moments: the enjoyment now and how you will feel afterward.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Swept Along",
                    blockquote = "guard yourself against being carried away by it",
                    body = "An impression is the first picture that arrives in your mind: the taste of a second dessert, the thrill of an impulse purchase. Epictetus does not say pleasure is bad. He says the danger is being carried away, acting before you have looked. The image is of a current. If you stand still for a moment, the current loses its pull.",
                    bullets = listOf(
                        InsightBullet("First picture", "Recognize the initial appeal as an impression, not yet a decision."),
                        InsightBullet("Stand still", "A moment's pause is often enough to break the pull.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Let the Pleasure Wait",
                    blockquote = "let the thing wait for you, and allow yourself a certain delay on your own part",
                    body = "Notice who waits for whom. Usually we wait on our pleasures and rush to them. Epictetus reverses this: let the pleasure wait for you. In the delay, he suggests picturing both times, the enjoyment and the hour after, and how glad you would be to have chosen well. Sometimes you will still choose the pleasure. But now it is your choice, not the current's.",
                    bullets = listOf(
                        InsightBullet("Reverse the waiting", "Make the pleasure wait for your decision instead of you waiting on it."),
                        InsightBullet("Picture both times", "Imagine the moment of enjoyment and the hour that follows it."),
                        InsightBullet("Still your choice", "The delay is not a ban; it returns the decision to you.")
                    )
                )
            ),
            modernApplication = "Set a rule for one tempting habit: wait ten minutes before acting. When the urge comes, look at the clock and say, \"You can wait for me.\" Use the ten minutes to picture how you will feel an hour later. Then decide calmly, whichever way you go.",
            closing = "A pleasure that waits for you is a pleasure you can choose.",
            reflectionPrompt = "Which pleasure tends to carry you along before you have decided? What might a short, deliberate delay change?"
        ),

        // q150 — Marcus Aurelius
        "q150" to QuoteInsight(
            intro = "Marcus begins this note with an old saying: do few things if you want to be tranquil. He refines it: do what is necessary, and ask of each act whether it is needed. Then he goes deeper. Cut unnecessary thoughts too, and the unneeded acts will fall away on their own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Daily Question",
                    blockquote = "On every occasion a man should ask himself, Is this one of the unnecessary things?",
                    body = "Marcus does not hand himself a list of things to cut. He gives himself a question to ask everywhere. Much of what we do is never questioned; it simply happens because it happened yesterday. Asking \"Is this necessary?\" brings habits into the light. Many remain, and that is fine. Some, once looked at, quietly disappear, and their absence leaves a calmer day.",
                    bullets = listOf(
                        InsightBullet("On every occasion", "Make the question a habit, not a once-a-year cleanup."),
                        InsightBullet("Into the light", "Unexamined routines are where unnecessary things hide.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Pruning at the Root",
                    blockquote = "a man should take away not only unnecessary acts, but also unnecessary thoughts",
                    body = "Acts grow from thoughts. Replaying an argument leads to the sharp message; imagining what others think leads to the needless favor. Marcus sees that trimming actions alone is endless work, because the thoughts keep producing new ones. Clear the unnecessary thought, and the superfluous act never starts. It is pruning at the root rather than clipping leaves.",
                    bullets = listOf(
                        InsightBullet("Thought before act", "Trace an unwanted action back to the thought that set it moving."),
                        InsightBullet("Let it pass", "An unnecessary thought need not be argued with; it can simply be let go.")
                    )
                )
            ),
            modernApplication = "Three times today, at your desk, in your inbox, and in your own head, stop and ask Marcus's question. Drop one task that fails it. And when you notice yourself rehearsing an old grievance, label it \"unnecessary\" and return to what is in front of you.",
            closing = "Clear the needless thought, and the needless deed never begins.",
            reflectionPrompt = "What thought have you been replaying that leads only to unnecessary actions? What would your day look like without it?"
        ),

        // ── Archive-only quotes (q151–q165) ────────────────────────────────────

        // q151 — Marcus Aurelius
        "q151" to QuoteInsight(
            intro = "Marcus warns himself against spending his life wondering what others think of him. Not every opinion deserves weight. He suggests heeding only the judgment of people who live according to nature, which for the Stoics meant living by reason, honesty, and care for others.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Every Voice Counts",
                    blockquote = "A man should hold on to the opinion not of all",
                    body = "Trying to please everyone is exhausting and impossible, because people want contradictory things. Marcus releases himself from that task. He does not say to ignore everyone, but to stop treating every comment, glance, or rumor as a verdict. In the full passage he notes that praise from people who are not even satisfied with themselves is worth very little.",
                    bullets = listOf(
                        InsightBullet("Release the crowd", "You cannot satisfy everyone, so stop measuring yourself by everyone."),
                        InsightBullet("Consider the source", "Praise or blame from someone careless with their own life weighs little.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Judges Worth Hearing",
                    blockquote = "but of those only who confessedly live according to nature",
                    body = "\"Confessedly\" means openly, evidently: people whose lives plainly show good sense, fairness, and self-control. Their judgment is worth hearing because it comes from a steady place. These might be a few friends, a mentor, or a relative whose conduct you admire. Their honest criticism is a gift, and their praise means something precisely because they give it carefully.",
                    bullets = listOf(
                        InsightBullet("A short list", "Name two or three people whose judgment you genuinely trust."),
                        InsightBullet("Evident lives", "Choose judges by how they live, not by how loudly they speak."),
                        InsightBullet("Welcome correction", "From trusted judges, criticism is help, not attack.")
                    )
                )
            ),
            modernApplication = "When a comment stings, ask: does this person live in a way I respect? If not, let the remark go. If so, take it seriously and consider what is true in it. Keep your list of trusted judges short, and check your choices against theirs.",
            closing = "Weigh opinions by the lives behind them, not by their volume.",
            reflectionPrompt = "Whose opinion has been weighing on you lately? Does their life give their judgment the weight you have been giving it?"
        ),

        // q152 — Seneca
        "q152" to QuoteInsight(
            intro = "Seneca urges Lucilius to learn how to feel joy, real joy, not the passing cheer that luck brings. Then he adds a surprising line: this kind of joy is serious. It does not come from laughter or good fortune, but from a mind confident and at peace with what it values.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Joy Worth Learning",
                    blockquote = "Real joy, believe me",
                    body = "Seneca wants Lucilius to be glad, and he says so plainly. But he means a gladness that is born inside a person and does not depend on chance. Other kinds of cheer, he says, smooth the brow but do not fill the heart. They come and go with circumstances. Real joy can be learned and owned, and once you find its source, it will not fail you.",
                    bullets = listOf(
                        InsightBullet("Born inside", "Look for gladness rooted in your character, not your luck."),
                        InsightBullet("Owned, not lent", "Joy that depends on events is borrowed and can be called back.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Serious, Not Somber",
                    blockquote = "is a stern matter",
                    body = "Stern does not mean grim. Seneca means weighty, deep, and steady. He compares it to rich mines whose veins lie deep rather than on the surface. A person who can face hardship, hold back from excess, and keep their values has a quiet gladness that laughter cannot match. It is less like a burst of fun and more like solid ground underfoot.",
                    bullets = listOf(
                        InsightBullet("Deep veins", "Lasting joy is found by digging into what matters, not by skimming pleasures."),
                        InsightBullet("Solid ground", "Steady contentment holds up when lighter cheer gives way.")
                    )
                )
            ),
            modernApplication = "Notice the difference today between moments of fun and moments of quiet satisfaction, such as finishing hard work or keeping a promise. Both are fine, but the second kind lasts. Choose one thing to do today that you know will leave that deeper gladness behind.",
            closing = "The deepest joy rarely laughs out loud, but it stays.",
            reflectionPrompt = "When did you last feel a quiet, steady gladness rather than a passing thrill? What was its source?"
        ),

        // q153 — Epictetus
        "q153" to QuoteInsight(
            intro = "In a talk about bearing sickness, Epictetus says we need the right principles ready for each occasion, the way you keep the right tools at hand for each job. He names two to keep closest: only the will is truly good or bad, and we should follow events rather than try to lead them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Only the Will Decides",
                    blockquote = "except the will nothing is good nor bad",
                    body = "This is the core Stoic claim. Health, money, and reputation matter, but they are not good or bad in themselves; what you do with them is. Your will, meaning your choices and judgments, is where good and evil actually live. In sickness, this means a fever cannot make you bad, though how you bear it can make you better. It turns attention from what is happening to how you meet it.",
                    bullets = listOf(
                        InsightBullet("Events are neutral", "A diagnosis or a loss is a circumstance; your response carries the moral weight."),
                        InsightBullet("The real arena", "Look for the choice inside each situation, since that is where good is found.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Following, Not Leading",
                    blockquote = "we ought not to lead events, but to follow them",
                    body = "We often try to drive events, insisting things go our way and arguing with what has already happened. Epictetus suggests a lighter posture: let events lead, and follow them with good judgment. He gives an example at once: my brother should not have treated me this way, but that is his business; mine is to treat him as I ought. Following is not passivity. It puts your effort where it works.",
                    bullets = listOf(
                        InsightBullet("Lighter posture", "Stop arguing with what has already happened and ask what it calls for."),
                        InsightBullet("Your business", "Other people's conduct is theirs; your response is yours.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Leading Events",
                rightHeader = "Following Events",
                rows = listOf(
                    "Demanding a set outcome" to "Responding to what comes",
                    "Arguing with what happened" to "Asking what it now requires",
                    "Effort spent on others' choices" to "Effort spent on your own"
                )
            ),
            modernApplication = "When something goes wrong today, a delay, a cold, a rude remark, say both principles to yourself: \"This is not good or bad in itself. I will follow it, not fight it.\" Then ask what the best response would be, and do that.",
            closing = "Let events lead the way, and let your will choose how you walk.",
            reflectionPrompt = "What event are you currently trying to lead that would be better followed? What would following it well look like?"
        ),

        // q154 — Seneca
        "q154" to QuoteInsight(
            intro = "Seneca considers the earliest people, who lived simply and innocently. He admires them, but he will not call them wise. Their goodness came from not knowing temptation, not from choosing well. Virtue, he says, is not handed out at birth; it is a skill that has to be learned.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not a Birth Gift",
                    blockquote = "Nature does not bestow virtue",
                    body = "Nature gives us capacities: reason, feeling, the ability to learn. It does not give us a finished character. Seneca says the early humans were innocent because they did not know about luxury, not because they had mastered desire. That kind of goodness is fragile. It holds only until temptation arrives. Real virtue has met the temptation and chosen otherwise.",
                    bullets = listOf(
                        InsightBullet("Capacity, not character", "You are born able to become good, not already good."),
                        InsightBullet("Tested goodness", "Virtue that has faced temptation is sturdier than innocence.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "A Craft to Learn",
                    blockquote = "it is an art to become good",
                    body = "Art here means a craft, like carpentry or medicine, learned through teaching and practice. That is hopeful. If goodness were a gift, those born without it would be stuck. Because it is an art, anyone can begin, make mistakes, and improve. Like any craft, it takes attention, repetition, and patience with yourself as a beginner.",
                    bullets = listOf(
                        InsightBullet("Anyone can start", "No one is barred from learning goodness, whatever their beginning."),
                        InsightBullet("Beginner's patience", "Expect clumsy early attempts, as with any new skill."),
                        InsightBullet("Daily exercises", "Small acts of honesty and kindness are the drills of this craft.")
                    )
                )
            ),
            modernApplication = "Treat one virtue as a skill this week, perhaps patience or honesty. Pick a specific moment each day to practice it: the commute, a meeting, dinner. At night, note one thing you did well and one you would do differently, the way an apprentice reviews the day's work.",
            closing = "Goodness is a craft, and every day offers a workbench.",
            reflectionPrompt = "Which virtue would you most like to learn as a skill? What is one small exercise you could practice tomorrow?"
        ),

        // q155 — Seneca
        "q155" to QuoteInsight(
            intro = "Lucilius has lost his friend Flaccus, and Seneca writes to console him. He does not forbid tears, and later in the letter he admits he once grieved too much himself, for his friend Serenus. But he hopes Lucilius will set grief down by choice rather than wait for time to wear it away.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Choosing to Set It Down",
                    blockquote = "I should prefer you to abandon grief",
                    body = "Seneca is gentle here. He is not saying grief is wrong; in the same letter he allows that tears will come and are natural. His hope is that Lucilius will in time decide to let grief go, out of understanding: the friend's life was a gift, and remembering him can become a pleasant memory rather than a wound. Letting go becomes an act of love, not of forgetting.",
                    bullets = listOf(
                        InsightBullet("Tears allowed", "Grief is natural, and Seneca does not ask you to hide it."),
                        InsightBullet("Memory as gladness", "In time, let remembering a loved one bring warmth instead of only pain.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Not Waiting for Weariness",
                    blockquote = "rather than have grief abandon you",
                    body = "Time ends grief eventually, Seneca observes, but simply growing tired of sorrow is a poor way for it to end. He would rather you take part in your own healing. This does not mean rushing. It means noticing when grief has become a habit rather than a tribute, and gently turning to the life and the people still in front of you.",
                    bullets = listOf(
                        InsightBullet("Take part", "Healing can be something you do, not only something that happens to you."),
                        InsightBullet("Habit or tribute", "Ask kindly whether your sorrow still honors the person or only weighs on you."),
                        InsightBullet("Turn to life", "Seneca encourages looking for others to love and care for.")
                    )
                )
            ),
            modernApplication = "If you are carrying an old loss, set aside a quiet moment to remember the person with thanks: a story, a phrase they used, a meal they loved. Let that memory be warm. Then do one small thing they would have enjoyed seeing you do.",
            closing = "Set grief down gently, and carry the memory instead.",
            reflectionPrompt = "Is there a sorrow you have been waiting for time to lift? What might it mean to choose, gently, to set part of it down?"
        ),

        // q156 — Seneca
        "q156" to QuoteInsight(
            intro = "Seneca has been advising Lucilius to keep a low profile in dangerous political times. He imagines Lucilius objecting with the example of Cato the Younger, the Roman senator famous for integrity and plain living, who stood against both great rivals of his day, Pompey and Julius Caesar.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Voice Against the Tide",
                    blockquote = "Cato's voice strove to check a civil war. Cato parted the swords of maddened chieftains.",
                    body = "Rome was sliding toward civil war between powerful men with armies. Cato had no army of his own, only his voice and his reputation for honesty, and he used both to try to hold the factions apart. \"Parted the swords\" is vivid language: one man, unarmed, stepping between leaders gripped by rage. Seneca's letter admires the courage even as it questions the politics.",
                    bullets = listOf(
                        InsightBullet("Unarmed courage", "Cato's only weapons were his words and his good name."),
                        InsightBullet("Stepping between", "Sometimes courage means standing in the gap between people who are angry.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Defying Both Sides",
                    blockquote = "When some fell foul of Pompey and others fell foul of Caesar, Cato defied both parties at once.",
                    body = "Most people choose a side and defend it. Cato refused to belong to either strongman. \"Fell foul of\" means quarreled with or opposed. While others lined up behind one leader against the other, Cato opposed both, because neither stood for what he valued. That kind of independence is lonely and rare. It is what made him an example Seneca kept returning to.",
                    bullets = listOf(
                        InsightBullet("No easy camp", "Integrity sometimes means refusing both of the sides on offer."),
                        InsightBullet("Lonely but clear", "Standing alone is hard, but it keeps your judgment your own.")
                    )
                )
            ),
            modernApplication = "When a dispute at work or in your family pushes you to pick a side, pause and ask what you actually think is right. You may find both sides partly wrong. Say so calmly, to both, even if it pleases no one. That is a small, everyday version of Cato's stand.",
            closing = "Some courage stands with a side; Cato's stood with what was right.",
            reflectionPrompt = "Is there a conflict where you have chosen a side out of pressure rather than conviction? What would Cato's independence look like there?"
        ),

        // q157 — Seneca
        "q157" to QuoteInsight(
            intro = "Seneca watches Romans scramble during elections, begging for votes. He imagines a better position: wanting nothing, and telling Fortune so. He contrasts Cato the Younger, famed for honesty, with Vatinius, a politician of Cato's day known for bribery, who beat Cato in a race to become praetor, a senior judge.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Nothing to Ask of Luck",
                    blockquote = "Fortune, I have nothing to do with you. I am not at your service.",
                    body = "For the Romans, Fortune was the goddess of chance who handed out success and failure. Seneca pictures a person who refuses to bargain with her. Others pray, campaign, and flatter in hope of her favor. This person simply steps out of the contest. Being \"not at her service\" means your sense of worth no longer depends on what luck delivers.",
                    bullets = listOf(
                        InsightBullet("Out of the contest", "When you stop needing a prize, the anxiety around it eases."),
                        InsightBullet("Worth not on loan", "Let your sense of yourself rest on your conduct, not your results.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Cato Spurned, Vatinius Made",
                    blockquote = "I know that men like Cato are spurned by you, and men like Vatinius made by you. I ask no favors.",
                    body = "Seneca points to a plain fact of Roman life: the honest Cato could lose an election and the corrupt Vatinius could win it. Fortune does not reward virtue. Seeing this clearly is freeing. If good people are often passed over, then being passed over says nothing about your worth. You can stop asking for favors and simply keep doing what is right.",
                    bullets = listOf(
                        InsightBullet("Results are not verdicts", "Losing out says little about character when luck plays favorites."),
                        InsightBullet("Ask nothing", "Wanting no favors leaves you free to speak and act honestly."),
                        InsightBullet("Cato's company", "Better to be spurned with integrity than raised up by compromise.")
                    )
                )
            ),
            modernApplication = "When you are passed over for a role, a prize, or praise, remind yourself that Fortune spurned Cato too. Then ask whether you acted well. If you did, you have what matters. Spend the energy you would have spent resenting it on your next honest piece of work.",
            closing = "Fortune has favorites; integrity has no need to be one.",
            reflectionPrompt = "Where are you still asking Fortune for favors? What would change if you stopped needing her approval?"
        ),

        // q158 — Seneca
        "q158" to QuoteInsight(
            intro = "Lucilius sent Seneca a letter through a man he called a friend, then warned Seneca not to discuss his affairs with him. Seneca points out the confusion. If the man is a friend, trust him fully. If not, do not call him one yet. Judge first, then trust.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Trust Without Reserve",
                    blockquote = "When friendship is settled, you must trust",
                    body = "Seneca holds friendship to a high standard. Once you have truly accepted someone as a friend, half trust is not enough. Speak to them as freely as you would to yourself. Holding back, testing, and watching for betrayal treats a friend as a suspect. Seneca adds that some people, fearing to be deceived, have taught others to deceive. Regard a friend as loyal, he says, and you will make him loyal.",
                    bullets = listOf(
                        InsightBullet("Full trust", "With a true friend, speak as openly as you would in your own thoughts."),
                        InsightBullet("Suspicion invites wrong", "Treating a friend as a suspect can teach them to act like one.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Judge Before You Join",
                    blockquote = "before friendship is formed, you must pass judgment",
                    body = "The care belongs at the start. Before you call someone a friend, take time to watch how they act, what they value, and how they treat others. Seneca says to ponder for a long time whether to admit someone to friendship, and once you decide, to welcome them with all your heart. The mistake is reversing the order: making a friend first and judging afterward.",
                    bullets = listOf(
                        InsightBullet("Slow to choose", "Give new acquaintances time before you name them friends."),
                        InsightBullet("Watch conduct", "Judge by how someone acts over time, not by how charming they are."),
                        InsightBullet("Right order", "Judge first and trust after, never the other way around.")
                    )
                )
            ),
            modernApplication = "Think of someone you call a friend but do not quite trust. Either the friendship needs more judging or the trust needs more giving, so decide which. With a new acquaintance, enjoy their company, but wait before sharing what matters most. With proven friends, let your guard down.",
            closing = "Choose slowly, then trust with your whole heart.",
            reflectionPrompt = "Is there someone you call a friend whom you secretly keep at arm's length? Does the friendship need more judgment or more trust?"
        ),

        // q159 — Seneca
        "q159" to QuoteInsight(
            intro = "At the end of a long letter, Seneca turns to justice, the virtue that looks to another person's good and seeks nothing for itself. He urges Lucilius to be just without needing reward or renown. The just act, he says, is already its own best payment.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Stop Looking for Payment",
                    blockquote = "You need not look about for the reward of a just deed",
                    body = "When we do something fair or kind, we often glance around: did anyone see, and will it be returned? Seneca says to stop looking. Justice that waits for a reward is closer to a trade. Just before this line he suggests telling yourself, \"I must be just without reward.\" That frees you from keeping score, and from disappointment when no thanks arrive.",
                    bullets = listOf(
                        InsightBullet("No scorekeeping", "Do the fair thing without tracking what you are owed for it."),
                        InsightBullet("Unseen is fine", "A just act is no smaller for having no witness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Deed as Its Return",
                    blockquote = "a just deed in itself offers a still greater return",
                    body = "The return is the kind of person you become by acting justly. Each fair choice strengthens your character and lets you live without inner conflict. Seneca adds that it makes no difference how many people know of your uprightness. Those who want their virtue advertised are striving for renown, not virtue. The reward is quiet, but it is entirely yours.",
                    bullets = listOf(
                        InsightBullet("Inner return", "Acting justly leaves you at peace with yourself, which no prize can buy."),
                        InsightBullet("Not for display", "If you want your good deed noticed, ask what you are really seeking.")
                    )
                )
            ),
            modernApplication = "Do one fair or generous thing today and tell no one: correct an error in someone else's favor, give credit where it is due, or return extra change. Afterward, notice how it feels to have done it with no audience and nothing owed.",
            closing = "Justice pays in the coin of who you become.",
            reflectionPrompt = "Which good deed of yours has gone unnoticed lately? Can you let its own goodness be enough of a reward?"
        ),

        // q160 — Marcus Aurelius
        "q160" to QuoteInsight(
            intro = "Marcus describes his own method for seeing things plainly. A fine dinner is the body of a fish or a bird; a purple robe is sheep's wool dyed with shellfish blood. When something dazzles you, he says, strip away its grand language and look at what it actually is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Lay Things Bare",
                    blockquote = "Where there are things which appear most worthy of our approbation, we ought to lay them bare and look at their worthlessness",
                    body = "Approbation means approval or admiration. Marcus targets the things that seem most impressive, because those pull hardest. Laying them bare is a deliberate act of plain description. He applied it even to the purple robe, a mark of his own rank as emperor. The point is not to sneer at everything, but to see clearly what you are really wanting.",
                    bullets = listOf(
                        InsightBullet("Describe it plainly", "Name an admired thing by what it is made of, not by its reputation."),
                        InsightBullet("Start at the top", "Apply the method especially to what impresses you most.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Strip the Fancy Words",
                    blockquote = "strip them of all the words by which they are exalted",
                    body = "Much of a thing's appeal lives in the words around it: exclusive, luxury, prestigious, award-winning. Marcus notices that we are often moved more by the description than by the thing. Remove the praise and look again. Sometimes something good remains, and you can enjoy it honestly. Often very little is left, and its hold on you weakens.",
                    bullets = listOf(
                        InsightBullet("Words that lift", "Notice adjectives doing the work of making something seem precious."),
                        InsightBullet("What remains", "Value what is still good after the praise is removed.")
                    )
                )
            ),
            modernApplication = "Pick one thing you have been wanting, perhaps a car, a title, or a famous restaurant. Describe it in the plainest terms you can: metal and rubber, a line on a business card, a cooked meal. Read your description back. Then decide whether you still want it, and how much.",
            closing = "Remove the praise, and see what is left to want.",
            reflectionPrompt = "What do you admire mostly because of how it is described? What does it look like with the grand words taken away?"
        ),

        // q161 — Seneca
        "q161" to QuoteInsight(
            intro = "Lucilius asks whether a wise person may keep emotions in moderation. Seneca warns that emotions start small and grow. Every passion is weak at the beginning, he says, and that is the time to deal with it. Once it gains strength, it is far harder to set aside.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Weak at First",
                    blockquote = "Every emotion at the start is weak.",
                    body = "Anger begins as irritation, envy as a passing comparison, craving as a small thought. In those early moments, the emotion is easy to notice and easy to redirect. Seneca observes that every vice has some plea at first and seems modest and easily persuaded. The opening is short, but it is real. Learning to recognize the first flicker is the main skill he recommends.",
                    bullets = listOf(
                        InsightBullet("The first flicker", "Notice the small early version of a strong feeling."),
                        InsightBullet("A modest plea", "Early emotions often arrive with a reasonable-sounding excuse.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Easier Before Than After",
                    blockquote = "it is more easy to forestall it than to forgo it",
                    body = "To forestall is to stop something before it gets going; to forgo is to give it up once you have it. Seneca says the first is much easier. Once an emotion has grown, it argues for itself, gathers memories, and colors everything. He adds that if you let it begin, you cannot be sure of its ending. So the best time to act is at the threshold, before the guest has moved in.",
                    bullets = listOf(
                        InsightBullet("Before, not after", "Act on a feeling while it is small rather than after it takes hold."),
                        InsightBullet("Uncertain endings", "Once a passion starts, you cannot count on stopping it where you planned.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Forestalling",
                rightHeader = "Forgoing",
                rows = listOf(
                    "A small irritation noticed" to "A full anger to undo",
                    "A brief pause" to "A long struggle",
                    "The choice still easy" to "The feeling arguing for itself"
                )
            ),
            modernApplication = "Today, catch one emotion in its first moment: a flash of impatience in traffic or a twinge of envy online. Name it quietly, \"irritation, just starting,\" and take a slow breath. Then choose your next action before the feeling chooses for you.",
            closing = "Meet a passion at the threshold, before it unpacks its bags.",
            reflectionPrompt = "Which emotion tends to grow in you before you notice it? What is its first, small sign?"
        ),

        // q162 — Epictetus
        "q162" to QuoteInsight(
            intro = "Epictetus speaks to students who have let their early resolve slip. He compares the moral life to an athletic contest, but a far greater one, a contest for happiness itself. In such a contest, he says, you cannot expect to avoid every blow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Greatest Contest",
                    blockquote = "We must not shrink when we are engaged in the greatest combat",
                    body = "The Greeks prized wrestling and the pancration, a rough mix of boxing and wrestling. Epictetus says the real contest is bigger: it is for a good life and peace of mind, so flinching makes little sense. He also offers comfort. Unlike the Olympic Games, this contest does not make you wait four years. If you drop out, you can return as soon as you have recovered yourself.",
                    bullets = listOf(
                        InsightBullet("Higher stakes", "The effort to live well matters more than any game or prize."),
                        InsightBullet("No four-year wait", "After a setback, you can rejoin the contest today.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Expect to Be Hit",
                    blockquote = "we must even take blows",
                    body = "Every athlete knows that contests involve being knocked down. Epictetus treats setbacks the same way: a broken resolution, a lapse in temper, a hard week. They are part of the contest, not proof that you should quit. Taking blows means accepting that you will sometimes fail and staying in anyway. The danger he warns of is not falling, but growing comfortable with giving up.",
                    bullets = listOf(
                        InsightBullet("Blows are normal", "A lapse is part of training, not a reason to stop."),
                        InsightBullet("Mind the habit", "Repeated quitting is the real danger, more than any single fall.")
                    )
                )
            ),
            modernApplication = "If you have abandoned a good intention, list what you aimed for, what you kept, and what slipped. Choose one thing that slipped and restart it today. When a new setback comes, say, \"That was a blow, not the end of the match,\" and continue.",
            closing = "Take the blow, stay in the ring, and begin again.",
            reflectionPrompt = "Which good intention have you quietly stepped away from? What would rejoining the contest look like this week?"
        ),

        // q163 — Epictetus
        "q163" to QuoteInsight(
            intro = "In a talk on friendship, Epictetus asks what really holds people together. Not shared parents, long acquaintance, or living under one roof, since those bonds can break when money or status is at stake. True friendship, he says, exists only where people share faithfulness, decency, and honest aims.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Fidelity and Modesty",
                    blockquote = "Where else is friendship than where there is fidelity, and modesty",
                    body = "Fidelity means being faithful and keeping your word. Modesty here means a sense of decency and restraint, the inner check that keeps you from taking advantage of others. Epictetus says people who place their good in money or status will turn on each other when those things are at stake. Only those who place their good in their own character can rely on each other.",
                    bullets = listOf(
                        InsightBullet("Faithful", "A friend is someone whose word holds when keeping it costs something."),
                        InsightBullet("Decent", "Friendship needs the restraint that will not exploit the other person.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Sharing Only the Honest",
                    blockquote = "where there is a communion of honest things and of nothing else",
                    body = "Communion means sharing. Epictetus says real friends share honest things, and nothing else. Friendships built on shared gossip, shared grudges, or shared schemes may feel close, but they rest on weak ground. When the gossip ends or the scheme goes wrong, the bond dissolves. What two people build around honesty and good aims tends to last.",
                    bullets = listOf(
                        InsightBullet("What you share", "Notice whether a friendship runs mainly on complaints or on good aims."),
                        InsightBullet("Solid footing", "Bonds built on honesty hold when other ties give way."),
                        InsightBullet("Be that friend", "Offer fidelity and decency first, rather than only seeking them.")
                    )
                )
            ),
            modernApplication = "Think of your closest friendships and ask what holds each one together. Strengthen the honest ties: keep a promise, speak a hard truth kindly, encourage a good aim. Where a bond runs mostly on grumbling, try steering the conversation to something you both care about.",
            closing = "Friendship lives where faithfulness lives, and nowhere else.",
            reflectionPrompt = "What is truly shared in your closest friendship? Is it built on honest things, or on something that could break under pressure?"
        ),

        // q164 — Seneca
        "q164" to QuoteInsight(
            intro = "Lucilius complains that a long journey has not lifted his low spirits. Seneca explains why: he took himself along. Changing places does not change the mind. A person who stops tying their peace to one spot finds that the whole world can be home.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No Corner Owns You",
                    blockquote = "I am not born for any one corner of the universe",
                    body = "Seneca says the person you are matters more than the place you go. If your peace depends on a particular house, town, or view, you become a servant of that place. Leave it and you suffer; stay and you may grow restless. Seneca wants a mind that is not bound to any one spot, so that it can settle wherever life puts it.",
                    bullets = listOf(
                        InsightBullet("Bring yourself", "A new place helps little if the same worries ride along."),
                        InsightBullet("Unbound", "Do not let your contentment depend on one location.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The World as Home",
                    blockquote = "this whole world is my country",
                    body = "This is the Stoic idea of being a citizen of the world. If the whole world is your country, you are never truly in exile, and no place is entirely foreign. Seneca notes that what you seek, to live well, can be found everywhere. Even the crowded forum can be lived in quietly if you must. The idea widens your loyalty too: every person you meet is in some sense a fellow citizen.",
                    bullets = listOf(
                        InsightBullet("Never in exile", "Wherever you are, you can live by the same values."),
                        InsightBullet("Fellow citizens", "Treat strangers as members of the same larger community."),
                        InsightBullet("Living well travels", "The aim of a good life goes with you wherever you go.")
                    )
                )
            ),
            modernApplication = "If you feel restless and think a new place will fix it, try a week of changing your habits instead: how you spend evenings, what you dwell on, how you treat people nearby. If you do travel, treat each place as part of your country and greet its people as neighbors.",
            closing = "Wherever you stand, you are already at home in the world.",
            reflectionPrompt = "Where do you hope a change of scene will fix something only a change of mind can fix? What would make you at home where you are?"
        ),

        // q165 — Seneca
        "q165" to QuoteInsight(
            intro = "Seneca is advising Lucilius about reading. Skipping from author to author, he says, is like constant travel: many acquaintances, no friends. Ideas need time to take root. He reaches for several images, including food never digested, salves tried one after another, and this one: a plant moved too often.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Roots Need Time",
                    blockquote = "A plant which is often moved",
                    body = "Every time a plant is dug up and replanted, its fine roots tear and it must start again. A mind treated the same way, jumping between books, plans, or methods, never settles deep enough to draw strength. Seneca's advice is to choose a few good authors and stay with them. \"Everywhere means nowhere,\" he writes in the same letter. Depth comes from staying put long enough to grow.",
                    bullets = listOf(
                        InsightBullet("Fewer, deeper", "Return to a few trusted books instead of sampling endless new ones."),
                        InsightBullet("Everywhere is nowhere", "Spreading attention thin leaves nothing firmly rooted.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Strength From Staying",
                    blockquote = "can never grow strong",
                    body = "Strength is the slow result of steady conditions. The image reaches beyond reading, to skills, friendships, and habits. Someone who changes jobs, diets, or routines every month may learn a little about each but master none. Seneca suggests that when you crave novelty, you go back to what you already know is good. Steadiness is not dullness. It is the soil where real growth happens.",
                    bullets = listOf(
                        InsightBullet("Steady soil", "Give a practice enough time in one place to take hold."),
                        InsightBullet("Return, not replace", "When restless, revisit a good source instead of starting a new one.")
                    )
                )
            ),
            modernApplication = "Pick one book, skill, or routine you have started and abandoned. Commit to it for a set stretch, perhaps a month, without switching. When the urge for something new arrives, return to a favorite page or step instead. Let the roots take hold before judging the plant.",
            closing = "Stay planted long enough, and even a small root holds fast.",
            reflectionPrompt = "What part of your life keeps getting replanted before it can grow? What would it take to let it stay put for a season?"
        )
    )
}
