package com.ataraxy.app.data.seed

import com.ataraxy.app.domain.model.InsightBullet
import com.ataraxy.app.domain.model.InsightSection
import com.ataraxy.app.domain.model.InsightTable
import com.ataraxy.app.domain.model.QuoteInsight

object InsightData {
    val insights: Map<String, QuoteInsight> = mapOf(

        // q001 — Marcus Aurelius
        "q001" to QuoteInsight(
            intro = "This is perhaps the most direct statement of the Stoic worldview ever written. In a single sentence, Marcus Aurelius draws the line that divides what is yours from what is not — and then tells you exactly where your power lies. It is deceptively simple. Read slowly.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Dichotomy of Control",
                    blockquote = "You have power over your mind — not outside events.",
                    body = "The Stoics built their entire philosophy on a single distinction: some things are up to us, and some things are not. Your mind — your judgments, desires, reactions, values — belongs to you completely. The weather, other people's opinions, illness, fortune: these belong to the world.",
                    bullets = listOf(
                        InsightBullet("What is yours", "Your thoughts, your intentions, your effort, your character."),
                        InsightBullet("What is not yours", "Outcomes, reputation, other people's choices, your body's health, time itself.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Promise",
                    blockquote = "Realize this, and you will find strength.",
                    body = "Marcus doesn't say you will find happiness, wealth, or ease. He says strength. The Stoic promise is not comfort — it is resilience. Once you stop fighting battles you cannot win and redirect that energy inward, a quiet, unshakeable power becomes available to you.",
                    bullets = listOf(
                        InsightBullet("Why strength?", "Because you can always govern your mind, no matter what is taken from you. That is an unconquerable position."),
                        InsightBullet("The shift", "From \"how do I change this?\" to \"how do I respond to this?\" — a small shift with enormous consequences.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Ordinary Thinking",
                rightHeader = "Stoic Thinking",
                rows = listOf(
                    "My happiness depends on what happens to me." to "My happiness depends on how I meet what happens.",
                    "I need to control outcomes." to "I only need to control my response.",
                    "External success = strength." to "Internal mastery = strength."
                )
            ),
            modernApplication = "We live in a culture obsessed with optimising outcomes — productivity systems, life hacks, networking strategies. None of it is inherently wrong, but it becomes a trap when we believe outcomes are what matter. Marcus would say: plan thoroughly, act virtuously, then release attachment to the result. The effort is yours. The outcome is not.",
            closing = "Your mind is the only kingdom you will ever truly rule. Rule it well.",
            reflectionPrompt = "Think of something causing you distress right now. Which part of it is actually within your control — and which part have you been spending energy trying to change that belongs to the world?"
        ),

        // q002 — Marcus Aurelius
        "q002" to QuoteInsight(
            intro = "Known as the \"obstacle is the way\" — a phrase so powerful it became the title of a modern bestseller — this line from Marcus Aurelius describes one of the most practical Stoic techniques for navigating adversity. It is not wishful thinking. It is a reframe with a method behind it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Physics of Obstacles",
                    blockquote = "The impediment to action advances action.",
                    body = "Marcus is drawing on a physical metaphor: fire. He describes in the Meditations how fire consumes what tries to block it — the obstacle becomes fuel. The same principle applies to the rational, purposeful will. Resistance, properly met, generates momentum.",
                    bullets = listOf(
                        InsightBullet("Not positive thinking", "This is not \"everything happens for a reason.\" It is a deliberate reframing: what can this obstacle teach me, strengthen in me, or redirect me toward?"),
                        InsightBullet("Action-oriented", "The insight only works if you act on it. The obstacle advances action — not passive endurance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Way Becomes the Way",
                    blockquote = "What stands in the way becomes the way.",
                    body = "The second half is the punchline. You thought the path was A → B. The obstacle appears to block you. But the Stoic sees the obstacle itself as the new path. The failed project teaches you what success requires. The difficult relationship reveals something about your own character. The illness forces you to rest and reconsider priorities.",
                    bullets = listOf(
                        InsightBullet("Perception", "First, you must see clearly — not in panic or denial, but with calm eyes."),
                        InsightBullet("Action", "Then, you must act on the obstacle rather than around it."),
                        InsightBullet("Will", "Finally, if the obstacle cannot be moved, you accept it without being broken by it.")
                    )
                )
            ),
            modernApplication = "Every significant achievement in history involved people who turned setbacks into fuel. The entrepreneur whose first company failed and learned what the second needed. The athlete whose injury forced the technical correction that made them elite. The lost job that opened a door. None of this is automatic — it requires the conscious choice to look at an obstacle and ask: \"What is this for?\"",
            closing = "The path is not blocked. The path is the block.",
            reflectionPrompt = "What is the largest obstacle in your life right now? What if it weren't in the way of your path — but was the path itself?"
        ),

        // q003 — Marcus Aurelius
        "q003" to QuoteInsight(
            intro = "Marcus Aurelius reduces an entire philosophical tradition to two words. The endless debate about what virtue looks like, what a good man must do, what ethics requires — all of it dissolves into a single imperative. Stop arguing. Begin.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trap of Endless Theory",
                    blockquote = "Waste no more time arguing about what a good man should be.",
                    body = "Discussing goodness is comfortable. Becoming good is demanding. The debate never ends; there is always one more objection, one more edge case, one more philosophical nuance to resolve before you are ready to act. Marcus recognises this for what it is: a sophisticated form of avoidance.",
                    bullets = listOf(
                        InsightBullet("Armchair virtue", "Knowing what goodness looks like is not the same as embodying it. The gap between knowledge and practice is where character is either built or abandoned."),
                        InsightBullet("The ready trap", "\"I'll be ready when I understand it better\" is the argument's most seductive lie. Understanding follows action; it does not precede it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Only Answer That Counts",
                    blockquote = "Be one.",
                    body = "Two words. Marcus collapses centuries of philosophical debate into a single imperative. You want to know what a good person is? Look at your next action. Character is not defined by knowing — it is revealed by doing, in the ordinary moments when no one is watching and no theory is required.",
                    bullets = listOf(
                        InsightBullet("Ethics as action", "You do not become good by understanding goodness. You become good by acting well, consistently, in small things."),
                        InsightBullet("The living answer", "Every time you act with integrity, courage, or fairness, you answer the question that all the arguing could not.")
                    )
                )
            ),
            modernApplication = "Every generation has people who specialise in telling others how to live. Marcus's reminder is timeless: less analysis, more action. The gap between knowing what is right and doing it is precisely where character is formed — or forfeited.",
            closing = "The argument about virtue has waited long enough. Your next action is the answer.",
            reflectionPrompt = "Is there an area of your life where you have been thinking, discussing, or planning what you should do — but not yet doing it? What would it look like to begin today, without waiting for certainty?"
        ),

        // q004 — Marcus Aurelius
        "q004" to QuoteInsight(
            intro = "This quiet line from the Meditations dismantles one of the most persistent myths of human life: that happiness is an acquisition problem. Marcus Aurelius, writing from within one of the most powerful positions on earth, makes a radical claim — the ingredients for a good life are already inside you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Myth of More",
                    blockquote = "Very little is needed to make a happy life...",
                    body = "The assumption that a better life requires better circumstances runs deep. More money, a better relationship, a different city. These things can improve comfort — but Marcus is pointing to something that wealth and circumstance cannot supply and cannot take away.",
                    bullets = listOf(
                        InsightBullet("The acquisition trap", "Each upgrade is quickly absorbed into the baseline, and the wanting begins again. The finish line moves every time you approach it."),
                        InsightBullet("The evidence", "If happiness depended on external conditions, no one in adversity could be happy. History demonstrates this is clearly false.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Location of the Solution",
                    blockquote = "...it is all within yourself, in your way of thinking.",
                    body = "This is not magical positive thinking. It is a precise philosophical claim: the frame you bring to your life — the judgments you make, the meaning you assign — determines your experience far more than the content of your circumstances. Thinking is not passive. It is the primary architect of your life.",
                    bullets = listOf(
                        InsightBullet("The frame", "Two people can inhabit identical circumstances and live entirely different inner lives based on how they interpret what happens to them."),
                        InsightBullet("A learnable skill", "If happiness is a way of thinking, it can be cultivated. It is a practice — not a lucky accident waiting for the right conditions.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The External Path",
                rightHeader = "The Internal Path",
                rows = listOf(
                    "Happiness depends on getting what you want." to "Happiness depends on wanting what you have.",
                    "The source is outside you." to "The source is within you.",
                    "Requires the right circumstances." to "Requires the right thinking."
                )
            ),
            modernApplication = "Positive psychology research consistently finds that external circumstances — income, status, possessions — account for a surprisingly small share of life satisfaction. How you think about your life accounts for far more. Marcus arrived at this empirically, through lived experience of extraordinary extremes.",
            closing = "The good life is not waiting for you in the future. It is available now, through a shift in how you see.",
            reflectionPrompt = "What do you believe you are missing that would make your life genuinely better? Now ask honestly: would having it change how you fundamentally think — or would the thinking remain the same?"
        ),

        // q005 — Marcus Aurelius
        "q005" to QuoteInsight(
            intro = "Marcus Aurelius reduces all of ethics to two tests. Every action: is it right? Every word: is it true? This is not naïve simplicity — it is deliberate minimalism. The Stoic life does not require elaborate moral calculus. It requires two honest questions, applied without exception.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Test of Action",
                    blockquote = "If it is not right, do not do it...",
                    body = "Before acting, the question is not: will this benefit me? Not: will anyone find out? Not: is this technically permitted? But: is it right? This framing removes convenience, self-interest, and social permission from the equation entirely. The standard is internal and non-negotiable.",
                    bullets = listOf(
                        InsightBullet("The right standard", "Self-interest and social norms are both unreliable guides. What benefits you may harm another. What society permits may still be wrong."),
                        InsightBullet("The inner witness", "Marcus cultivated an inner observer — the rational faculty that sees clearly and cannot be bribed or pressured into approval.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Test of Speech",
                    blockquote = "...if it is not true, do not say it.",
                    body = "Half of all social friction is generated by speech that is not quite true — the exaggeration, the flattery, the half-truth told for comfort. Marcus applies the same minimal standard to words that he applies to deeds. If it is not true, silence is always available.",
                    bullets = listOf(
                        InsightBullet("The cost of untruth", "Every small untruth trains the mind to be a little less reliable. Over time, you lose track of what you actually believe."),
                        InsightBullet("Honesty as respect", "To tell someone the truth — even an uncomfortable truth — is to treat them as a rational adult capable of bearing reality.")
                    )
                )
            ),
            modernApplication = "In a world of curated personas, spin, and social performance, this two-part test is almost countercultural. Not everything needs to be said, but what is said should be true. Not every opportunity needs to be taken, but what is taken should be right. The standard is simple; living up to it daily is the work of a lifetime.",
            closing = "Two questions. A whole life's worth of guidance.",
            reflectionPrompt = "In the past week, have you done something that didn't pass the 'is it right' test, or said something that didn't pass the 'is it true' test? What drove the exception?"
        ),

        // q006 — Marcus Aurelius
        "q006" to QuoteInsight(
            intro = "Marcus Aurelius offers two rules that seem in tension but are not. An untroubled spirit might sound like comfortable avoidance. Looking things in the face sounds like confrontation with difficulty. The Stoic insight is that both are possible simultaneously — and each requires the other.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The First Rule: Inner Stillness",
                    blockquote = "The first rule is to keep an untroubled spirit.",
                    body = "Not a numb spirit, not a dull one — an untroubled one. The Stoics called this tranquillitas: inner steadiness that does not depend on external conditions remaining smooth. It is earned through practice, not assumed, and it is available even in the middle of genuine difficulty.",
                    bullets = listOf(
                        InsightBullet("Not indifference", "An untroubled spirit is not the same as not caring. It means your core is not shaken even when the surface is turbulent."),
                        InsightBullet("The foundation", "All Stoic practice ultimately aims at this: a settled inner life that remains yours regardless of what happens outside it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Second Rule: Clear Perception",
                    blockquote = "The second is to look things in the face and know them for what they are.",
                    body = "The untroubled spirit is not won by looking away from difficulty, but by seeing it clearly. Denial creates fear because the unexamined threat grows in the imagination. The Stoic method is to look steadily, name the thing, and find that it is rarely as large as the fear of it.",
                    bullets = listOf(
                        InsightBullet("Clear-eyed realism", "Stoicism is not optimism. It looks at hard things squarely and asks: what actually is this, stripped of catastrophising?"),
                        InsightBullet("Mutual reinforcement", "The untroubled spirit makes clear vision possible. Clear vision sustains the untroubled spirit. They strengthen each other.")
                    )
                )
            ),
            modernApplication = "These two rules together describe what psychologists call equanimity: the capacity to remain emotionally stable while engaging honestly with reality. It is not suppression and not avoidance — it is the combination of emotional steadiness and clear perception that the most resilient people seem to possess.",
            closing = "The goal is not to feel nothing. It is to see clearly without being destroyed by what you see.",
            reflectionPrompt = "Is there something in your life you have been avoiding looking at clearly? What might you find if you looked at it steadily, with an untroubled spirit rather than dread?"
        ),

        // q007 — Marcus Aurelius
        "q007" to QuoteInsight(
            intro = "This is one of the warmest lines in the Meditations — a book often associated with austere discipline. Marcus describes something harder and more beautiful than stoic resignation: amor fati — the active love of one's fate, including the people in it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Accepting Fate's Bindings",
                    blockquote = "Accept the things to which fate binds you...",
                    body = "The circumstances you did not choose — your era, your body, your starting conditions — are not obstacles to the life you were meant to live. They are the material of that life. Resentment of what fate has set is optional. Engagement with what it offers is always available.",
                    bullets = listOf(
                        InsightBullet("Not passive", "Acceptance is not approval or surrender. It means engaging fully with what actually is, rather than with what you wish were."),
                        InsightBullet("The energy question", "Every unit of energy spent resenting fate cannot be used to navigate it well. The equation is simple.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Loving the People Fate Brings",
                    blockquote = "...and love the people with whom fate brings you together.",
                    body = "The colleague who frustrates, the family member who disappoints, the stranger whose life intersects yours — none were chosen, all arrive as part of the same given life. Marcus's practice was to find something to appreciate in each person, because each person was, in some sense, given.",
                    bullets = listOf(
                        InsightBullet("Common humanity", "Every person fate places in your path shares the same essential nature: the same capacity for reason, the same vulnerability, the same desire to live well."),
                        InsightBullet("A practice", "Loving the people fate brings you is not a sentiment that arrives automatically. It is a discipline — practised deliberately, especially when difficult.")
                    )
                )
            ),
            modernApplication = "Acceptance and belonging research both point to the same finding: people who accept their circumstances without resentment and find genuine connection in their existing relationships consistently report higher wellbeing than those who resist their situation or wait for better company.",
            closing = "Your life — circumstances and all, people and all — is the one you have been given. Live it fully.",
            reflectionPrompt = "Is there a circumstance you are in, or a person fate has brought into your life, that you have been resisting or resenting? What would accepting, or even appreciating, them look like?"
        ),

        // q008 — Marcus Aurelius
        "q008" to QuoteInsight(
            intro = "Three words. Among the most compact instructions in all of philosophy — and among the most difficult to follow. Marcus wrote this in a private journal, as a reminder to himself. He needed the reminder. So do we.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Mind That Will Not Stay",
                    blockquote = "Confine yourself...",
                    body = "The untrained mind slides into regret about the past and anxiety about the future. Both are forms of absence — you are physically here but mentally somewhere else entirely. Marcus is not offering a technique. He is issuing a direct command to himself.",
                    bullets = listOf(
                        InsightBullet("The wandering default", "Research suggests the mind spends roughly half of waking hours not attending to what is actually happening. This is the default — not a failure but a starting point."),
                        InsightBullet("The cost", "Decisions made from distraction are poorer. Relationships lived in half-attention are thinner. The life not noticed is not fully lived.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Present as Sufficient",
                    blockquote = "...to the present.",
                    body = "The present moment is not a waiting room for the future. It is the only place where anything actually happens. Action is only possible now. Connection is only possible now. Whatever good you intend must be done now, because now is the only time available.",
                    bullets = listOf(
                        InsightBullet("The sufficient unit", "Marcus elsewhere notes that a person cannot be harmed by the past or future — only the present requires a response. The present is enough."),
                        InsightBullet("The brevity is the point", "Three words. Not because this is simple, but because it needs no elaboration — only attention.")
                    )
                )
            ),
            modernApplication = "Present-moment awareness is strongly associated with wellbeing, and mind-wandering is the primary source of unhappiness in daily life, according to attention research. 'Confine yourself to the present' becomes more difficult and more important as the number of distractions competing for attention grows.",
            closing = "The past is over. The future is not yet. This moment is where your life is taking place.",
            reflectionPrompt = "When you are doing something today, how much of your attention is actually on what is in front of you — and how much is elsewhere? What would it feel like to be fully here?"
        ),

        // q009 — Marcus Aurelius
        "q009" to QuoteInsight(
            intro = "This is one of Marcus Aurelius's most psychologically precise lines. When we are wronged, retaliation feels like justice. Marcus argues it is neither justice nor relief. The truest response to being wronged is to refuse to become the kind of person who wrongs others.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trap of Retaliation",
                    blockquote = "The best revenge...",
                    body = "The word 'revenge' is deliberate. Marcus acknowledges the impulse — he is not pretending the injury doesn't sting. He is redirecting it. Instead of asking 'how do I make them pay?' he asks: 'how do I live in response to what they did?'",
                    bullets = listOf(
                        InsightBullet("Retribution's hidden cost", "Returning harm for harm requires you to carry the harm — and to reproduce it. The bitterness of revenge poisons the one who holds it more reliably than it harms its target."),
                        InsightBullet("The energy redirect", "The anger that would go into retaliation can go into something more powerful: becoming someone whose character cannot be diminished by what was done to them.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Character as the Response",
                    blockquote = "...is to be unlike him who performed the injustice.",
                    body = "The person who wronged you acted out of something — fear, selfishness, cruelty, weakness. To respond by mirroring that behaviour is to let them determine your character. Marcus's answer: refuse the mirror. Be defined by your values, not by their actions.",
                    bullets = listOf(
                        InsightBullet("The ultimate independence", "You cannot control what others do to you. You can control what their actions make of you."),
                        InsightBullet("The living demonstration", "The person who wrongs you and finds, over time, that you have grown rather than hardened — that is more confounding to them than any retaliation.")
                    )
                )
            ),
            modernApplication = "Forgiveness research consistently finds that holding onto resentment correlates with worse mental and physical health, while choosing not to let another's actions define your character is protective. Marcus is not recommending passivity — he is recommending that injustice not be allowed to corrupt the only thing you truly own.",
            closing = "The greatest insult you can offer someone who wronged you is to flourish.",
            reflectionPrompt = "Think of someone who has wronged you. Has your response to their actions brought you closer to the person you want to be — or further from it?"
        ),

        // q010 — Marcus Aurelius
        "q010" to QuoteInsight(
            intro = "Marcus Aurelius identifies the real danger — not the inevitable end, but the failure to start. Most people do not die too soon. They begin living too late — holding back, deferring full engagement until some condition is met that never quite arrives.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Misplaced Fear",
                    blockquote = "It is not death that a man should fear...",
                    body = "Death is universal, certain, and entirely outside our control. Fearing it is understandable, but it changes nothing. What the fear of death does do is consume energy that could go toward living — it becomes a paralysing shadow rather than an honest motivator.",
                    bullets = listOf(
                        InsightBullet("The certainty of death", "Because death is certain, it is not an emergency. What remains uncertain is what you do with the time before it."),
                        InsightBullet("Fear's misdirection", "Fearing death typically leads to avoiding all risk, all depth, all genuine engagement — the very things that make a life worth living.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Real Risk",
                    blockquote = "...but he should fear never beginning to live.",
                    body = "The person who has never truly begun — who has spent their years in safety, in performance, in deferral — faces a more frightening reckoning than one who has lived fully and lost much. The unlived life, not death, is the genuine catastrophe.",
                    bullets = listOf(
                        InsightBullet("What beginning means", "Committing to what you value. Engaging with people honestly. Taking on the projects and relationships that are genuinely yours."),
                        InsightBullet("Postponement compounds", "Every year of deferral makes beginning harder and the remaining time shorter. Marcus's warning is urgent, not abstract.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Fearing Death",
                rightHeader = "Fearing the Unlived Life",
                rows = listOf(
                    "Fear of the unavoidable." to "Fear of the preventable.",
                    "No action can resolve it." to "Action, taken now, can resolve it.",
                    "Leads to avoidance and paralysis." to "Leads to urgency and engagement."
                )
            ),
            modernApplication = "Palliative care researchers studying what dying people most regret find a consistent pattern: not risks taken but roads not taken — the wish to have lived a life truer to themselves. Marcus was right. The wrong fear is the fear of dying. The right fear is the fear of never having started.",
            closing = "Death comes for everyone. An unlived life is its own kind of death, taken in small doses daily.",
            reflectionPrompt = "Is there something — a relationship, a project, a way of living — that you have been deferring? What would it look like to begin it today, imperfectly, without waiting?"
        ),

        // q011 — Epictetus
        "q011" to QuoteInsight(
            intro = "Epictetus offers a two-part formula that is both practically precise and philosophically complete. The first half is a call to total engagement. The second half is a call to release. Together, they describe the Stoic life: maximum effort within your domain, full acceptance beyond it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Full Engagement Within Your Power",
                    blockquote = "Make the best use of what is in your power...",
                    body = "'The best use' is demanding. Not adequate use, not occasional use — the best use. Epictetus is not recommending passive acceptance of your situation. He is demanding complete engagement with everything that actually belongs to you: your attention, your effort, your judgments, your character.",
                    bullets = listOf(
                        InsightBullet("What is in your power", "Your intentions, your effort, your values, your responses. Not your outcomes, your reputation, or others' reactions."),
                        InsightBullet("The work", "Making the best use requires clarity about what you can actually affect — and then acting on it without reservation or distraction.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Release What Is Not Yours",
                    blockquote = "...and take the rest as it happens.",
                    body = "Not resist, not fight — take. As it happens, not as you wish it would. This is not fatalism. It is the intelligent conserving of energy: having done everything possible, releasing attachment to outcomes that were never in your hands to begin with.",
                    bullets = listOf(
                        InsightBullet("Precision over passivity", "The Stoic life is not about doing less — it is about directing effort precisely. Maximum input, minimum attachment to output."),
                        InsightBullet("The source of equanimity", "'Take the rest as it happens' is where Stoic peace comes from. Not indifference to outcomes, but freedom from being broken by them.")
                    )
                )
            ),
            modernApplication = "What psychologists call psychological flexibility — acting in line with your values while accepting what you cannot control — is one of the strongest predictors of mental resilience and wellbeing. Epictetus describes it in eight words.",
            closing = "Give everything to what is yours. Accept everything that is not.",
            reflectionPrompt = "In a current challenge, where is the exact line between what is in your power and what is not? Are you directing your energy accordingly — or spending it on the wrong side of that line?"
        ),

        // q012 — Epictetus
        "q012" to QuoteInsight(
            intro = "This line from Epictetus is one of the clearest expressions of Stoic value theory. The good life is not built from external acquisitions — not wealth, status, health, or pleasure. These can be preferred and enjoyed. But none of them is the good. Only virtue is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wrong Address",
                    blockquote = "Seek not the good in external things...",
                    body = "Most of us search for the good in the usual places: relationships that validate, achievements that impress, possessions that signal worth. These are not nothing — Epictetus called them preferred indifferents, things worth having if they arrive without compromising your character. But they are not the good. They can be taken away.",
                    bullets = listOf(
                        InsightBullet("The fragility of external good", "Anything external can be lost — by chance, by age, by others' choices. A good that can be taken is not truly yours."),
                        InsightBullet("The false address", "Seeking the good externally is searching for a key where the light is better. The key is elsewhere.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Right Address",
                    blockquote = "...seek it in yourself.",
                    body = "The good — in Stoic terms — is virtue: practical wisdom, justice, courage, and moderation. These are entirely internal. They cannot be given to you by circumstances or taken by them. They are developed through choice, tested in difficulty, and owned completely.",
                    bullets = listOf(
                        InsightBullet("The unconquerable", "A person of excellent character who loses everything external still possesses the good. That possession cannot be confiscated."),
                        InsightBullet("The building", "Virtue is not a gift — it is the product of daily choices, consistently made, in the direction of what is right.")
                    )
                )
            ),
            modernApplication = "Research on self-determination theory finds that acting from internal values rather than external reward or validation is among the strongest contributors to wellbeing. The person who acts for external approval is perpetually dependent on its supply. The person who acts from internal values is self-sufficient.",
            closing = "The good you are searching for is not out there. It has never been out there.",
            reflectionPrompt = "Think of something you are working hard to attain. Is it external — an outcome, recognition, a possession? What internal quality does that pursuit require of you, and could you cultivate that quality directly?"
        ),

        // q013 — Epictetus
        "q013" to QuoteInsight(
            intro = "Epictetus's instruction is deceptively sequential: identity before action. Decide who you are — then let that decision determine what you do. This is the Stoic reversal of how most people live, who act first and construct a sense of self afterward from the pattern of actions they have accumulated.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Identity Comes First",
                    blockquote = "First, say to yourself what you would be...",
                    body = "Before the meeting, the decision, the difficult conversation — establish who you are. Not your role, not your feelings in the moment, not the identity that would make things easiest. Your character: the values you have chosen to live by and the kind of person you have decided to be.",
                    bullets = listOf(
                        InsightBullet("The anchor", "A stated identity functions as an anchor against situational pressure. When you know what you are, moment-to-moment choices become easier to navigate."),
                        InsightBullet("Not performance", "This is not about reputation or self-image. It is about internal clarity — what do I actually stand for, and what does that require of me here?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Action Follows Naturally",
                    blockquote = "...and then do what you have to do.",
                    body = "Once the identity is established, the action follows with a certain inevitability. 'What you have to do' is not an arbitrary obligation — it is the natural expression of who you have decided to be. The action is not separate from the self; it is the self, demonstrated.",
                    bullets = listOf(
                        InsightBullet("The integrity gap", "Most regretted actions come from a gap between stated values and situational choices. Epictetus closes that gap by insisting the identity question be settled first."),
                        InsightBullet("Character as compass", "When identity is clear, the right action in a given situation often becomes obvious — even when it is difficult or costly.")
                    )
                )
            ),
            modernApplication = "Research on implementation intentions shows that stating in advance what you will do in a specific situation dramatically increases follow-through. Epictetus goes deeper: establish who you are, and what you do in any situation naturally follows from that.",
            closing = "Know who you are before the world asks you to be someone else.",
            reflectionPrompt = "Before you face something difficult today, pause and ask: what kind of person do I intend to be in this situation? Then act from that identity rather than from the pressure of the moment."
        ),

        // q014 — Epictetus
        "q014" to QuoteInsight(
            intro = "Epictetus locates the single greatest obstacle to learning: the conviction that learning is no longer necessary. This is not about intelligence or capacity — it is about the attitude a person brings to experience. The mind that arrives full cannot be filled. The mind that arrives open can receive anything.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Closed Door",
                    blockquote = "It is impossible for a man to learn...",
                    body = "Impossibility is a strong word. Epictetus does not say it is difficult or unlikely — he says it is impossible. Once you have decided you already know, no new information can enter. It arrives and is rejected before it lands: 'I know this.' 'I've heard this before.' 'This doesn't apply to me.'",
                    bullets = listOf(
                        InsightBullet("The expert's trap", "The more expertise a person has, the more likely they are to stop learning in precisely the domain where their knowledge matters most."),
                        InsightBullet("The recognition reflex", "'I already know this' often fires before the content has been fully received. The knowing stops the hearing.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Prerequisite for Growth",
                    blockquote = "...what he thinks he already knows.",
                    body = "The solution is not doubt for its own sake — it is genuine openness. Approaching each situation with the possibility that something new could be learned, that your current view might be incomplete, is the precondition for any real growth.",
                    bullets = listOf(
                        InsightBullet("Hold knowledge lightly", "Not ignorance, but revisability — certain enough to act, open enough to update when better evidence arrives."),
                        InsightBullet("The revisable mind", "The greatest thinkers in any field are distinguished not by the rigidity of their views but by their willingness to change them when they should.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Closed Mind",
                rightHeader = "The Open Mind",
                rows = listOf(
                    "Arrives at experience with conclusions." to "Arrives at experience with questions.",
                    "Filters new information through existing beliefs." to "Lets new information challenge existing beliefs.",
                    "Confirms what it knows." to "Discovers what it doesn't."
                )
            ),
            modernApplication = "The research on intellectual humility shows that people who acknowledge the limits of their knowledge make better decisions, have healthier relationships, and are more trusted by others. Epictetus identified the same pattern two thousand years before the psychology was formalised.",
            closing = "The wisest thing you can know is how much you do not.",
            reflectionPrompt = "In what area of your life are you most certain you already have the answer? Could there be something you have been unable to learn there precisely because of that certainty?"
        ),

        // q015 — Epictetus
        "q015" to QuoteInsight(
            intro = "This line, taken from the opening of Epictetus's Enchiridion, is the cornerstone of Stoic psychology. It predates cognitive-behavioural therapy by nearly two thousand years, yet describes the same fundamental insight that modern psychology has validated over and over: it is not events that disturb us, but the meaning we assign to them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Events Are Neutral",
                    blockquote = "Men are disturbed not by things...",
                    body = "A thunderstorm is not frightening — your opinion that you might be struck is frightening. Criticism from a colleague is not painful — your opinion that their words diminish your worth is painful. The event is the same for everyone. The disturbance is personal, because the opinion is personal.",
                    bullets = listOf(
                        InsightBullet("The event", "Neutral, external, outside your control."),
                        InsightBullet("The opinion", "Yours, internal, within your power to examine and revise.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Power Hidden in This Idea",
                    blockquote = "...but by the opinions about things.",
                    body = "If your distress is caused by the event, you are powerless — you cannot un-happen the event. But if your distress is caused by your opinion of the event, you have a foothold. You can examine the opinion. You can ask whether it is true, whether it is necessary, whether another view is possible.",
                    bullets = listOf(
                        InsightBullet("Not denial", "Epictetus is not saying \"pretend bad things are good.\" He is saying: examine what you are telling yourself about what happened."),
                        InsightBullet("Not cold", "This is not emotional suppression. It is emotional clarity — knowing where your feeling comes from.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Common Response",
                rightHeader = "Stoic Response",
                rows = listOf(
                    "\"That event ruined my day.\"" to "\"My opinion of that event disrupted me.\"",
                    "\"They made me angry.\"" to "\"I chose anger as my response.\"",
                    "\"This situation is unbearable.\"" to "\"I'm telling myself this is unbearable — is that true?\""
                )
            ),
            modernApplication = "Cognitive-behavioural therapy, acceptance and commitment therapy, and most modern evidence-based psychotherapies are built on exactly this principle. Epictetus was not a therapist — he was a freed slave turned philosopher — but his insight is among the most clinically useful ideas ever articulated. The next time you feel anxious or angry, pause and ask: what am I telling myself about this?",
            closing = "Between stimulus and response, there is a space. In that space lies your freedom.",
            reflectionPrompt = "Bring to mind something that recently disturbed you. What was the event — and what was the opinion you layered on top of it? Could another opinion of the same event be equally valid?"
        ),

        // q016 — Epictetus
        "q016" to QuoteInsight(
            intro = "Epictetus identifies one of the simplest and most powerful shifts available to any mind: moving from the grammar of lack to the grammar of possession. The wise man is not defined by what he has accumulated, but by what he does with what he already has.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Grief of Absence",
                    blockquote = "He is a wise man who does not grieve for the things which he has not...",
                    body = "Grief over absence is the mind comparing its current reality to an imagined better one and finding the present wanting. The comparison itself generates the suffering — not the absence. What is missing is real, but the suffering over it is a choice of attention.",
                    bullets = listOf(
                        InsightBullet("The gap as generator", "Unhappiness lives in the gap between what is and what you believe should be. Wise perception narrows that gap by questioning the 'should.'"),
                        InsightBullet("Not suppression", "This is not about pretending the lack doesn't exist. It is about not treating that lack as the primary fact of your situation.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Joy of Presence",
                    blockquote = "...but rejoices for those which he has.",
                    body = "Rejoicing — not just tolerating, not just accepting, but actively finding satisfaction in what is present. This is not performance positivity. It is a trained faculty, a deliberate redirection of attention toward what already exists and has value.",
                    bullets = listOf(
                        InsightBullet("Gratitude as skill", "Gratitude is not a feeling that arrives when conditions are good — it is a practice of noticing what already has worth."),
                        InsightBullet("The richness already here", "Most people have far more than they regularly notice. The wise person simply notices it.")
                    )
                )
            ),
            modernApplication = "Gratitude research consistently shows that people who regularly notice and name what they value — not as performance but as genuine attention — report measurably higher wellbeing. The wisdom Epictetus describes is both ancient and empirically validated.",
            closing = "What you have is already enough to rejoice in, if you choose to see it.",
            reflectionPrompt = "What have you been grieving the absence of recently? Now look at what is present. What is already here that deserves more of your attention?"
        ),

        // q017 — Epictetus
        "q017" to QuoteInsight(
            intro = "Epictetus, who knew what literal enslavement meant, writes with particular authority on freedom. His definition is precise and provocative: the free man is not the one without chains, but the one who governs himself. External freedom without self-mastery is simply a different kind of captivity.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Freedom Actually Requires",
                    blockquote = "No man is free...",
                    body = "The statement cuts against every conventional notion of freedom. We tend to define freedom as the absence of constraint — no one telling you what to do, no obligations you did not choose. Epictetus says this misses the point entirely. A person with no external constraints but who is driven by unexamined impulses, fears, and appetites is not free. They are ruled.",
                    bullets = listOf(
                        InsightBullet("The invisible master", "Passions, fears, and cravings are the least visible and most tyrannical rulers. They command without announcing themselves."),
                        InsightBullet("External freedom is insufficient", "Remove every external chain, and the unexamined mind will simply bind itself to its own impulses instead.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Self-Mastery as the Foundation",
                    blockquote = "...who is not master of himself.",
                    body = "Mastery here does not mean suppression. It means governance — the rational faculty in its proper position, directing rather than being driven. Epictetus spent years in literal slavery and emerged with a philosophy that made him freer than most emperors.",
                    bullets = listOf(
                        InsightBullet("Governance, not suppression", "The master of himself does not crush his impulses — he observes them, examines them, and chooses which to act on."),
                        InsightBullet("The lifelong project", "Self-mastery is not achieved once. It is practised daily, in small decisions, in moments of pressure, in the gap between impulse and response.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "External Freedom",
                rightHeader = "Inner Freedom",
                rows = listOf(
                    "Absence of external constraint." to "Governance of internal impulse.",
                    "Can be given and taken away." to "Can only be earned and surrendered.",
                    "Depends on circumstances." to "Depends on character."
                )
            ),
            modernApplication = "Addiction, compulsion, and the inability to resist short-term impulse at the cost of long-term wellbeing are the modern names for the captivity Epictetus describes. The most common form of unfreedom in the modern world is not political — it is psychological.",
            closing = "The person who governs themselves cannot truly be enslaved by anything else.",
            reflectionPrompt = "In what area of your life are you most governed by impulse, habit, or fear rather than by deliberate choice? What would it mean to reclaim mastery there?"
        ),

        // q018 — Epictetus
        "q018" to QuoteInsight(
            intro = "Epictetus frames freedom and discipline as a paradox — seek freedom directly and you enslave yourself; seek discipline and you discover the only genuine liberty. This is counterintuitive enough to stop a person cold. It is also, on reflection, obviously true.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Freedom That Enslaves",
                    blockquote = "Seek freedom and become captive of your desires.",
                    body = "If freedom means doing whatever you want whenever you want, you quickly find yourself ruled by your most urgent impulses — not your most considered ones. The appetite for pleasure enslaves you to pleasure. The desire for validation enslaves you to others' opinions. The pursuit of ease enslaves you to comfort and away from anything meaningful.",
                    bullets = listOf(
                        InsightBullet("The desire trap", "Every unsatisfied desire creates restlessness. Every satisfied desire creates either satiety (temporary) or a larger desire. The net result is not freedom."),
                        InsightBullet("Chosen captivity", "The person chasing unconstrained freedom has typically not examined which master they are running toward.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Discipline That Liberates",
                    blockquote = "Seek discipline and find your liberty.",
                    body = "Discipline — the consistent practice of ordering your choices according to your values rather than your impulses — is what creates the space for genuine freedom. The person who has trained their appetites, who can delay gratification and tolerate discomfort, is free to pursue what actually matters to them.",
                    bullets = listOf(
                        InsightBullet("The platform", "Discipline is not the enemy of enjoyment — it is its platform. Things enjoyed by a disciplined person are enjoyed more fully, without the anxiety of dependence."),
                        InsightBullet("Liberty through constraint", "The musician's freedom to improvise beautifully comes from years of disciplined practice. Structure enables the thing it appears to limit.")
                    )
                )
            ),
            modernApplication = "Every modern productivity, wellbeing, and performance tradition arrives at the same conclusion: the people who report the greatest sense of freedom and flow in their lives are typically those with strong habits and disciplines, not those with the fewest constraints. Discipline is the path, not the obstacle.",
            closing = "The person who is governed by nothing has, without realising it, given themselves to everything.",
            reflectionPrompt = "Where in your life have you confused freedom with the absence of discipline? And where has a constraint — a routine, a commitment, a practice — actually made you more capable and more free?"
        ),

        // q019 — Epictetus
        "q019" to QuoteInsight(
            intro = "Few lines in all of philosophy pack more practical guidance into fewer words. This principle — sometimes called the \"last human freedom\" — is the hinge on which the entire Stoic life turns. Viktor Frankl arrived at the same insight in a Nazi concentration camp. Epictetus arrived at it as a slave.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Happens to You",
                    blockquote = "It's not what happens to you...",
                    body = "Epictetus had personal authority on this subject. He was born into slavery, his leg was deliberately broken by his master, and he had no control over the material conditions of his early life. Yet he became one of the most celebrated philosophers in the ancient world. The \"what happens\" is often brutal, unfair, and beyond our reach.",
                    bullets = listOf(
                        InsightBullet("Loss", "Jobs lost, relationships ended, health declined."),
                        InsightBullet("Injustice", "Being treated unfairly, overlooked, or wronged."),
                        InsightBullet("Chance", "Illness, accident, misfortune that no one planned.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How You React to It",
                    blockquote = "...but how you react to it that matters.",
                    body = "The reaction is yours. Not the automatic, flinching, animal reaction — but the considered response, the one you choose after the first wave of feeling passes. This is where character is built. Not in ease, but in how you meet difficulty.",
                    bullets = listOf(
                        InsightBullet("Response vs. reaction", "A reaction is automatic. A response is chosen. The Stoic trains the gap between the two."),
                        InsightBullet("Character is revealed", "Adversity doesn't build character so much as it reveals and tests the character already there."),
                        InsightBullet("The long game", "How you respond to one hard thing shapes how you respond to the next.")
                    )
                )
            ),
            modernApplication = "Modern psychology calls this \"locus of control\" — the degree to which you believe your actions influence outcomes. People with an internal locus of control — who believe their responses matter — consistently show greater resilience, health, and life satisfaction than those with an external locus. Epictetus was teaching locus of control philosophy while chained to a wall.",
            closing = "You cannot always choose your circumstances. You can always choose who you are inside them.",
            reflectionPrompt = "Think of a recent setback. How did you react in the first moment — and how did you respond over time? What, if anything, would you change about that response now?"
        ),

        // q020 — Epictetus
        "q020" to QuoteInsight(
            intro = "Epictetus understood that character is not formed in isolation. The people we spend time with do not merely reflect who we are — they actively shape who we become. This is not a casual observation. It is a prescription for one of the most important choices available to us.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Invisible Influence",
                    blockquote = "The key is to keep company only with people who uplift you...",
                    body = "We absorb the standards, habits, and expectations of those around us without realising it. Spend time with people who take intellectual life seriously, and your own curiosity sharpens. Spend time with people who treat cynicism as sophistication, and your own outlook slowly narrows. The influence is constant, subtle, and powerful.",
                    bullets = listOf(
                        InsightBullet("The standard-setter", "The people around you define what is normal — in behaviour, in ambition, in how seriously to take the work of becoming good."),
                        InsightBullet("Not elitism", "Epictetus is not advising you to avoid people who are struggling. He is advising you to seek people who are genuinely trying — in whatever direction — to live well.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Upward Pull",
                    blockquote = "...whose presence calls forth your best.",
                    body = "The highest standard Epictetus sets is not merely that company not drag you down — but that it actively draws your best self forward. Some people make you more thoughtful, more honest, more ambitious in the right direction. Seek those people deliberately.",
                    bullets = listOf(
                        InsightBullet("A two-way test", "Ask not only whether this person uplifts you, but whether your presence calls forth their best. The best relationships are mutually elevating."),
                        InsightBullet("The quality question", "It is better to have fewer relationships of genuine depth than many that leave you feeling smaller than when you arrived.")
                    )
                )
            ),
            modernApplication = "Social contagion research confirms what Epictetus observed: habits, attitudes, and even levels of happiness spread through social networks. The people physically and digitally closest to you are among the strongest environmental forces shaping your character — whether you are aware of it or not.",
            closing = "You become, over time, a composite of the people you spend the most time with. Choose accordingly.",
            reflectionPrompt = "Think of the people you spend the most time with. Does their presence call forth your best — or does it pull you toward something smaller? What does that suggest about your social choices?"
        ),

        // q021 — Seneca
        "q021" to QuoteInsight(
            intro = "Seneca's definition of poverty is not material — it is psychological. The man with very little who is at peace with that little is rich. The man with great abundance who craves more is, in the only sense that matters, poor. This distinction changes everything about how we understand wealth.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Poverty of Craving",
                    blockquote = "It is not the man who has too little...",
                    body = "Having too little is a material condition. Craving more is a psychological one. The former can be addressed by resources; the latter cannot — because it is not caused by a shortage of resources. It is caused by a habit of mind that compares the present to an imagined better and finds the present wanting.",
                    bullets = listOf(
                        InsightBullet("More never satisfies", "The craving for more is structurally insatiable. It is a mechanism, not a problem to be solved by acquisition."),
                        InsightBullet("The misdiagnosis", "Most people treat their craving as evidence of need. Seneca says it is evidence of poverty — not of goods but of character.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Wealth of Enough",
                    blockquote = "...but the man who craves more, that is poor.",
                    body = "The man who has made peace with what he has — who can find fullness in modest circumstances — is rich in the way that matters. This peace is not resignation. It is a cultivated capacity, a trained perception that knows how to receive what is already present.",
                    bullets = listOf(
                        InsightBullet("Richness as perception", "The rich person, in Seneca's sense, is the one who has learned to see the richness already in their life."),
                        InsightBullet("Voluntary simplicity", "The Stoics practiced voluntary poverty — temporarily living without comforts — not as punishment but to discover how little they actually needed.")
                    )
                )
            ),
            modernApplication = "Consumer culture operates on precisely the poverty Seneca describes: create desire, then sell its temporary relief, then create new desire. The person who has stepped off this cycle — who has developed genuine contentment with less — has achieved something rare and largely independent of income level.",
            closing = "The richest person in any room is often the one who needs the least from it.",
            reflectionPrompt = "Where in your life are you craving more of something — money, recognition, comfort? Is that craving evidence of a genuine need, or of a habit of wanting that more cannot fix?"
        ),

        // q022 — Seneca
        "q022" to QuoteInsight(
            intro = "Seneca's instruction has two parts that together reframe how to inhabit time. Not merely to begin living — but to begin at once. And not to see days as segments of a longer story — but to see each as a complete life in itself. This changes both the urgency and the depth with which you meet each morning.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Begin at Once",
                    blockquote = "Begin at once to live...",
                    body = "The 'at once' is the decisive phrase. Not when circumstances improve. Not when you feel ready. Not when the project is finished. Now. Seneca's letters to Lucilius return again and again to the theme of time stolen by postponement — life spent in preparation for living rather than in actual living.",
                    bullets = listOf(
                        InsightBullet("Postponement's cost", "Each day spent waiting for the right moment to begin is a day of life spent in the waiting room rather than in the life itself."),
                        InsightBullet("The preparation trap", "There is always a reason to wait one more season. The preparation is real but it becomes a permanent substitute for the thing it was meant to enable.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Each Day as a Complete Life",
                    blockquote = "...and count each separate day as a separate life.",
                    body = "This is a profound reframe. When you see days as segments of an indefinite future, it is easy to defer — there is always tomorrow. When you see each day as complete in itself, it carries its own weight and its own potential. What would you do with today if it were all you had?",
                    bullets = listOf(
                        InsightBullet("The completeness of now", "A day fully lived — with presence, purpose, and honest engagement — is not a fragment. It is sufficient unto itself."),
                        InsightBullet("The mortality reminder", "Counting each day as a life is a mild form of memento mori: a reminder that this day will not recur and is therefore worth inhabiting fully.")
                    )
                )
            ),
            modernApplication = "The psychological research on 'time affluence' — the felt sense of having enough time — shows that it is not determined by how much time you have but by how present and intentional you are within it. People who treat each day as complete rather than as a stepping stone to a future payoff consistently report higher wellbeing.",
            closing = "This day will not come again. That is not a threat — it is an invitation.",
            reflectionPrompt = "If today were a complete life rather than a day among many, what would you make sure to include in it? What would you stop deferring to some other day?"
        ),

        // q023 — Seneca
        "q023" to QuoteInsight(
            intro = "Written in Latin, this line from Seneca's letters loses nothing in translation: while we are putting things off, life is passing. Not accumulating. Not waiting for us to be ready. Simply passing. The observation is as urgent in the modern era as when Seneca wrote it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Mechanism of Postponement",
                    blockquote = "Dum differtur vita transcurrit — While we are postponing...",
                    body = "Postponement is not a neutral act. It is a choice — to let the current moment pass in favour of a future one that may not arrive, or that will arrive under different conditions than anticipated. Seneca understood that postponement is one of the primary ways life is lost without violence or tragedy.",
                    bullets = listOf(
                        InsightBullet("The comfortable thief", "Postponement steals time without feeling like theft. It feels like prudence, preparation, patience — reasonable things. That is its danger."),
                        InsightBullet("What gets postponed", "People postpone the important for the urgent, the meaningful for the convenient, the genuine for the manageable. The pattern is consistent.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Speed of Life",
                    blockquote = "...vita transcurrit — life speeds by.",
                    body = "Not 'life passes' but 'life speeds by' — transcurrit carries movement, momentum, irreversibility. You cannot recover the year you spent preparing for the life you intended to live. The time does not bank. It moves.",
                    bullets = listOf(
                        InsightBullet("Irreversibility", "Unlike money or effort, time cannot be recovered or reinvested. The unit of postponement is always life itself."),
                        InsightBullet("The acceleration", "The subjective experience of time accelerating as we age is well-documented. The urgency Seneca describes increases, not decreases, as the years pass.")
                    )
                )
            ),
            modernApplication = "Procrastination research distinguishes between practical delay (waiting for the right information or moment) and experiential avoidance (postponing what matters because starting it is uncomfortable). Seneca's observation targets the second kind — the deferral of life's substance in favour of its postponement.",
            closing = "Time does not wait for you to be ready. It simply continues.",
            reflectionPrompt = "What have you been postponing — not because the time isn't right, but because starting is uncomfortable? How much of your life has passed in that waiting?"
        ),

        // q024 — Seneca
        "q024" to QuoteInsight(
            intro = "Seneca wrote this in a letter to his friend Lucilius, and it may be the single most practically useful sentence in all of Stoic literature. It describes — with surgical precision — the mechanism behind most human anxiety. We are not afraid of what is happening. We are afraid of what we imagine might happen.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Imagination's Cruelty",
                    blockquote = "We suffer more often in imagination than in reality.",
                    body = "The mind is a magnificent instrument for anticipating threats — it evolved to keep you alive by simulating danger before it arrives. But it has no off switch. Left unguided, it will simulate threats that never materialise, catastrophise outcomes that remain unlikely, and dwell in imagined suffering that the present moment does not contain.",
                    bullets = listOf(
                        InsightBullet("More often", "Seneca doesn't say \"sometimes\" — he says \"more often.\" The scale of imagined suffering dwarfs the real thing."),
                        InsightBullet("The body doesn't know the difference", "Physiologically, imagined threats trigger the same stress response as real ones. The mind's fictions have real costs.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Stoic Remedy",
                    blockquote = "...than in reality.",
                    body = "The cure is not to stop thinking about the future — it is to think about it clearly. Seneca elsewhere advises a practice called premeditatio malorum: deliberately imagining the worst outcome, seeing it clearly, and recognising that you could endure it. This deflates the imagined monster by replacing it with a real (if difficult) thing.",
                    bullets = listOf(
                        InsightBullet("Name it", "Bring the vague dread into focus. What exactly are you afraid of?"),
                        InsightBullet("Examine it", "Is this outcome likely? If it happened, could you endure it?"),
                        InsightBullet("Release it", "Having faced it clearly, let the imagination rest.")
                    )
                )
            ),
            modernApplication = "Anxiety disorders — the most common mental health challenge in the modern world — are largely disorders of imagination. The worry is almost always worse than the event. This doesn't invalidate the suffering; it locates it correctly, which is the first step toward relief. When you notice yourself suffering, pause and ask: is this happening, or am I imagining it happening?",
            closing = "The present moment rarely contains as much suffering as the mind predicts for it.",
            reflectionPrompt = "What are you most worried about right now? Describe it as concretely as possible. Now ask: how much of this suffering exists in the present moment, and how much of it is imagined?"
        ),

        // q025 — Seneca
        "q025" to QuoteInsight(
            intro = "Seneca makes two moves in one sentence: acknowledging the genuine uncertainty of the future, and deriving from it not anxiety but urgency. The future is uncertain precisely because it is not here yet. What is here is the present moment — and living immediately is the only rational response to that fact.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Honest Uncertainty",
                    blockquote = "The whole future lies in uncertainty...",
                    body = "Seneca does not pretend otherwise or offer false comfort. The future is genuinely uncertain. Acknowledging this honestly is the Stoic starting point. The error is not in recognising uncertainty but in responding to it with paralysis rather than presence.",
                    bullets = listOf(
                        InsightBullet("Not denial", "Stoicism does not pretend that bad things won't happen. It insists they be prepared for with clear eyes rather than avoided through wishful thinking."),
                        InsightBullet("The one certainty", "The only guaranteed moment is this one. The future will come or it won't — but the present is undeniably here.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Rational Response",
                    blockquote = "...live immediately.",
                    body = "From uncertainty, Seneca derives not caution but action. If the future is uncertain, deferring your life until conditions are right is a gamble on something you cannot control. Living immediately is the only investment that cannot be taken by circumstances.",
                    bullets = listOf(
                        InsightBullet("Immediacy as wisdom", "Acting now is not recklessness. It is the acknowledgment that the present is the only time anything is actually possible."),
                        InsightBullet("The reversal", "Most people treat uncertainty as a reason to wait. Seneca treats it as a reason to begin.")
                    )
                )
            ),
            modernApplication = "Psychological research on mortality salience — the awareness that life is finite and uncertain — shows it increases focus on what genuinely matters when processed constructively. Seneca's instruction converts the anxiety of uncertainty into the fuel of presence.",
            closing = "The future is not promised. The present is. Use it.",
            reflectionPrompt = "Is there something you have been deferring until the future feels more certain? What would it look like to live that thing immediately?"
        ),

        // q026 — Seneca
        "q026" to QuoteInsight(
            intro = "Latin condenses what English struggles to express efficiently: nusquam est qui ubique est — the person who is everywhere is effectively nowhere. Seneca's observation about scattered attention is more pressing now than when he wrote it. The technologies of distraction have multiplied; the principle has not changed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Illusion of Everywhere",
                    blockquote = "He who is everywhere...",
                    body = "Being everywhere is a modern aspiration — across multiple platforms, projects, and conversations simultaneously. It feels like reach and connection. Seneca says it produces the opposite: a dispersal of presence so complete that nowhere receives what it actually needs.",
                    bullets = listOf(
                        InsightBullet("Attention divided", "Attention is not infinitely divisible. What is spread across ten things is ten times thinner than what is concentrated on one."),
                        InsightBullet("The performance of presence", "Being notionally present in many places is not the same as being actually present anywhere. The form without the substance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Depth of Somewhere",
                    blockquote = "...is nowhere.",
                    body = "The only place where anything of substance happens is where your whole attention is. The conversation that receives your full presence is different in kind from one you conduct while half elsewhere. Work done with concentrated focus differs in quality from work distributed across distractions.",
                    bullets = listOf(
                        InsightBullet("Depth requires constraint", "Choosing to be somewhere means choosing not to be somewhere else — and that limitation is what makes genuine presence possible."),
                        InsightBullet("Quality over coverage", "One relationship inhabited fully is worth more than ten inhabited partially.")
                    )
                )
            ),
            modernApplication = "Attention research confirms that the human mind cannot genuinely multitask — it can only rapidly switch between tasks, with a measurable cost at each switch. Deep focus on one thing produces better results and greater satisfaction than distributed attention across many.",
            closing = "To be fully somewhere is one of the rarest things a person can offer — to themselves or to another.",
            reflectionPrompt = "Where are you spreading yourself across too many things and arriving nowhere fully? What would it mean to choose one thing and actually be there?"
        ),

        // q027 — Seneca
        "q027" to QuoteInsight(
            intro = "Seneca's claim is radical: of all the things we call ours — property, relationships, reputation, health — only time actually belongs to us. Everything else is borrowed from circumstances that can reclaim it. Time is the only resource that is purely ours, and also the only one we treat as though it is unlimited.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Everything Is on Loan",
                    blockquote = "Omnia aliena sunt — Everything is alien to us...",
                    body = "Alien does not mean bad — it means belonging to another. Your possessions belong to fortune. Your relationships belong to other people, who have their own fates. Your body belongs to nature, which will eventually ask for it back. None of it is truly and permanently yours.",
                    bullets = listOf(
                        InsightBullet("The illusion of ownership", "We call things ours because we hold them temporarily. The holding gives a sense of possession that loss will eventually correct."),
                        InsightBullet("Not nihilism", "Seneca is not saying nothing matters. He is saying clinging to what is not truly ours is the source of unnecessary suffering when it is reclaimed.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Time Alone Is Yours",
                    blockquote = "...tempus tantum nostrum est — time alone is ours.",
                    body = "Time is genuinely yours because it passes through you and cannot be transferred. No one else can live your hours. They cannot be stockpiled, delegated, or recovered. What you do with them is entirely, irreversibly yours.",
                    bullets = listOf(
                        InsightBullet("The only non-renewable", "Every other resource can be replenished. Time is not — and it is being spent whether you direct it or not."),
                        InsightBullet("Guard it accordingly", "If time is the one thing truly yours, giving it freely to trivial pursuits or others' agendas is the greatest possible waste.")
                    )
                )
            ),
            modernApplication = "The entire time-management industry exists because people feel their time is not their own — and they are often right. Seneca's prescription: reclaim it. Treat time with the jealousy you would reserve for something uniquely and irreplaceably yours, because it is.",
            closing = "Everything else can be recovered. The hour just passed cannot.",
            reflectionPrompt = "Look at how you spent your time yesterday. Was it spent on what you would choose if you truly believed time was your only genuine possession?"
        ),

        // q028 — Seneca
        "q028" to QuoteInsight(
            intro = "Seneca defines happiness with precision: not the absence of difficulty, not the accumulation of good things, but a specific relationship with time. True happiness inhabits the present, free from the anxiety that borrows from a future that may never arrive in the form imagined.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Present as the Home of Happiness",
                    blockquote = "True happiness is to enjoy the present...",
                    body = "Present enjoyment is not shallow — it is the only happiness that is structurally real. Happiness anticipated in the future is a projection; happiness remembered from the past is a recollection. Only the present moment contains actual experience. Happiness that does not inhabit the present has no address.",
                    bullets = listOf(
                        InsightBullet("Not hedonism", "Enjoying the present is not about chasing pleasure. It is about being fully available to what is already here — the quality of a conversation, work done well, the fact of being alive."),
                        InsightBullet("Arrival", "Much of what people seek — peace, contentment, connection — is available now. The barrier is not its absence but the mind's habit of looking past it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Freedom from Future Anxiety",
                    blockquote = "...without anxious dependence upon the future.",
                    body = "Anxious dependence upon the future is the belief that your happiness is in escrow — deferred until circumstances align. Seneca identifies this as the mechanism that makes happiness unavailable in the present. The dependence is the problem, not the future.",
                    bullets = listOf(
                        InsightBullet("The deferral habit", "'When X happens, then I'll be happy' — this conditional happiness never arrives, because there is always another X required first."),
                        InsightBullet("The release", "Dropping the anxious dependence does not require the future to be safe. It requires only that the present be allowed to be sufficient.")
                    )
                )
            ),
            modernApplication = "Happiness research consistently finds that the achievement of anticipated goals delivers less satisfaction than expected. The 'impact bias' causes us to overestimate how much future events will change our wellbeing. Seneca understood this two thousand years before the empirical data.",
            closing = "Happiness is not what you are waiting for. It is what you have been standing in.",
            reflectionPrompt = "What are you waiting for before you allow yourself to be fully present and content? Is there something worth enjoying in exactly the circumstances you are in now?"
        ),

        // q029 — Seneca
        "q029" to QuoteInsight(
            intro = "Seneca's line about poverty and richness inverts the conventional hierarchy entirely. Making a 'fair compact' with poverty — coming to genuine terms with having less — is described not as resignation but as the very definition of wealth. The compact is the key word.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Compact with Less",
                    blockquote = "He who has made a fair compact with poverty...",
                    body = "A compact is a negotiated agreement — not a forced surrender. The person who has genuinely examined what they need versus what they want, and made peace with the difference, has achieved something no external acquisition can provide. The compact is internal, voluntary, and durable.",
                    bullets = listOf(
                        InsightBullet("Voluntary vs. forced", "There is a profound difference between accepting scarcity reluctantly and choosing simplicity deliberately. One is defeat; the other is mastery."),
                        InsightBullet("What the compact covers", "Not just material things, but comfort, status, convenience — all the preferred indifferents that are fine to have but unnecessary for a good life.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Richness of Peace",
                    blockquote = "...is rich.",
                    body = "Rich in the only way that cannot be taken: free from the anxiety of needing more, capable of finding sufficiency where others find lack, and independent from the uncertainty of external provision.",
                    bullets = listOf(
                        InsightBullet("The independence dividend", "The person who needs very little is free in a way the person who needs a great deal cannot be. Every want is a small captivity."),
                        InsightBullet("The Stoic practice", "The Stoics voluntarily practised austerity — simple food, plain dress — not as punishment but to discover how little the good life actually required.")
                    )
                )
            ),
            modernApplication = "Research on voluntary simplicity consistently finds that people who deliberately choose to live with less — and have examined what they genuinely need — report higher levels of freedom, meaning, and contentment than those who pursue accumulation without that examination.",
            closing = "The richest position is not to have everything you want. It is to want very little.",
            reflectionPrompt = "What material things do you believe you need in order to live well? Which are genuinely necessary — and which are simply habitual wants you haven't yet examined?"
        ),

        // q030 — Seneca
        "q030" to QuoteInsight(
            intro = "Seneca writes directly about the mechanism of anxiety: it is not the future itself that causes misery, but the mind's relationship to it. The anxious mind does not suffer from what happens — it suffers continuously from what might happen, which is a form of voluntary misery with no necessary cause.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Anticipatory Suffering",
                    blockquote = "The mind that is anxious about future events...",
                    body = "The anxious mind reaches forward in time, simulating threats that do not yet exist and may never exist. This simulation is real — physiologically, the body responds to imagined threats as it does to actual ones. The suffering is genuine even when the cause is entirely hypothetical.",
                    bullets = listOf(
                        InsightBullet("Active generation", "Anxiety is not passive — it is the active production of suffering from raw material that has not yet arrived."),
                        InsightBullet("The probability problem", "Most imagined threats never materialise. The mind consistently overestimates both the likelihood and severity of future difficulty.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Remedy",
                    blockquote = "...is miserable.",
                    body = "Miserable is precise: the anxious mind does not merely experience occasional discomfort — it lives in ongoing anticipatory suffering that the present moment does not require. The solution is not to eliminate future-thinking but to examine its content.",
                    bullets = listOf(
                        InsightBullet("Examine the fear", "What specifically are you afraid of? Named clearly, most fears are either improbable, survivable, or both. The vague dread is always worse than the specific thing."),
                        InsightBullet("Return to now", "The present moment rarely contains the emergency the anxious mind has projected into it.")
                    )
                )
            ),
            modernApplication = "Anxiety disorders are largely disorders of future imagination — the mind running scenarios of threat that the present does not contain. Cognitive therapy and mindfulness both work, in part, by returning attention to what is actually here.",
            closing = "The misery the anxious mind produces is almost entirely self-supplied.",
            reflectionPrompt = "What future event are you most anxious about right now? How probable is it? And if it did occur, could you endure it?"
        ),

        // q031 — Seneca
        "q031" to QuoteInsight(
            intro = "Seneca wrote this in his Natural Questions — a work of scientific inquiry — and it captures something the Stoics understood deeply: knowledge is cumulative, patient, and long. Great understanding does not arrive in a single moment. It is built across years by those willing to work without seeing the final result.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Long Work of Discovery",
                    blockquote = "The time will come when diligent research over long periods...",
                    body = "Diligence over long periods — not brilliance in a single flash — is what brings hidden things to light. The person who expects insight to arrive quickly has not understood what genuine understanding requires.",
                    bullets = listOf(
                        InsightBullet("Diligence over time", "Not intensity alone, not talent alone — sustained effort over time is the mechanism by which what is hidden becomes known."),
                        InsightBullet("The unseen inheritance", "Every piece of knowledge you hold was once a hidden thing that patient effort brought to light. You are living on the compound interest of others' long work.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Hidden Will Be Found",
                    blockquote = "...will bring to light things which now lie hidden.",
                    body = "This is an expression of epistemic confidence: the world is knowable. The hidden things are not hidden by design but by distance — the distance between our current understanding and what sustained effort makes possible.",
                    bullets = listOf(
                        InsightBullet("Patience as a tool", "What cannot be seen now may be seen with enough time and careful attention. Absence of a solution today is not evidence that none exists."),
                        InsightBullet("Contribution across generations", "The work you do may bear fruit long after you. That is not a consolation — it is a form of purpose.")
                    )
                )
            ),
            modernApplication = "Every major scientific breakthrough was the culmination of years of accumulated, patient inquiry by people who never saw the final discovery. The same principle applies to personal growth: the transformation that seems sudden is almost always the result of long, quiet preparation.",
            closing = "The work that feels invisible is often the most important work being done.",
            reflectionPrompt = "Is there a long project — intellectual, personal, or practical — that you have been giving up on too quickly because results are not yet visible? What would patient continuation look like?"
        ),

        // q032 — Seneca
        "q032" to QuoteInsight(
            intro = "Among the most deceptively simple lines in Seneca's letters, this one announces a genuine achievement. Not 'I have conquered my fears' — but something quieter and rarer: I have learned to be a friend to myself. In a culture that treats self-criticism as virtue, this is a radical statement.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Self-Friendship Means",
                    blockquote = "I have learned to be a friend to myself.",
                    body = "A good friend is honest but not cruel. They support your genuine interests, not just your immediate desires. They stay present in difficulty rather than abandoning you when you fall short. Seneca claims to have cultivated this same quality in his relationship with himself — and he calls it an achievement requiring learning.",
                    bullets = listOf(
                        InsightBullet("Honest, not harsh", "A friend tells you the truth without treating your failures as permanent verdicts. The self-friend applies the same standard inwardly."),
                        InsightBullet("Not self-indulgence", "Self-friendship is not permissiveness. It is the difference between a harsh judge and a trusted advisor.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Why It Must Be Learned",
                    blockquote = "I have learned...",
                    body = "The word 'learned' is significant. This is not natural or automatic. Many people are their own harshest critics, their own least forgiving companions. Learning not to be that person is genuine progress — perhaps among the most difficult and most useful work available.",
                    bullets = listOf(
                        InsightBullet("The inner critic", "Most people would not speak to another person the way they speak to themselves in moments of failure. The standard applied inward is often harsher than any external judgment."),
                        InsightBullet("Solitude requires it", "The person who cannot be a friend to themselves will find solitude unbearable. The person who can will find it nourishing.")
                    )
                )
            ),
            modernApplication = "Research on self-compassion — treating yourself with the same kindness you would offer a good friend in difficulty — consistently shows it improves resilience, reduces anxiety, and increases motivation to grow. The self-critical approach, paradoxically, tends to undermine the very improvement it aims at.",
            closing = "You will spend more time with yourself than with anyone else. That relationship deserves the same care as any other.",
            reflectionPrompt = "If a close friend described their struggles to you the way you speak to yourself about yours, how would you respond? Could you offer yourself the same quality of response?"
        ),

        // q033 — Seneca
        "q033" to QuoteInsight(
            intro = "This is Seneca's most direct description of the Stoic practice known as premeditatio malorum — the premeditation of adversity. By anticipating difficulty clearly in advance, you strip it of the power to ambush you. The feared thing, seen beforehand, is almost always smaller than its shadow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Anticipation vs. Worry",
                    blockquote = "The man who has anticipated the coming of troubles...",
                    body = "Anticipation is not the same as worry. Worry is vague, repetitive, and circular — it rehearses anxiety without resolving it. Anticipation is clear-eyed and specific. Seneca's recommendation is to look at potential difficulties directly, name them, and consider how you would meet them if they arrived.",
                    bullets = listOf(
                        InsightBullet("The difference", "Worry circles without landing. Anticipation lands — it asks: what is this, and what would I do if it came?"),
                        InsightBullet("The preview effect", "Having mentally rehearsed a difficulty, you have already processed a version of it. When it arrives, it meets someone who has already been there.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Removing the Power to Shock",
                    blockquote = "...takes away their power when they arrive.",
                    body = "Much of adversity's power is the power of surprise — the ambush of the unexpected. Anticipated difficulty is robbed of that ambush. It arrives and meets a mind that has already prepared a response rather than one that is overwhelmed by the shock of the new.",
                    bullets = listOf(
                        InsightBullet("Surprise as multiplier", "Difficulty is always made worse by unexpectedness. The same setback navigated calmly if anticipated can be devastating when it ambushes."),
                        InsightBullet("Preparation, not prediction", "You are not trying to predict the future. You are building resilience across a range of possibilities so that whatever arrives finds you ready.")
                    )
                )
            ),
            modernApplication = "Modern stress-inoculation therapy — used with first responders, soldiers, and athletes — is built on exactly this principle: controlled mental exposure to difficult scenarios in advance reduces the stress response when they occur. Seneca was practising a form of psychological preparation that modern research has validated.",
            closing = "The difficulty you have already faced in your mind has lost its greatest weapon: surprise.",
            reflectionPrompt = "What difficulty might be coming for you in the near future? Take a few minutes to anticipate it clearly — what it would look like, how you would respond. Does it feel less powerful when seen directly?"
        ),

        // q034 — Epictetus
        "q034" to QuoteInsight(
            intro = "Epictetus delivers a warning that is also an invitation. Choosing a philosophical life — a life governed by honest self-examination, by pursuing virtue over approval, by questioning conventional assumptions — will make you a strange figure to many people. He says: know this from the start, and choose it anyway.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Social Cost of Seriousness",
                    blockquote = "If you want to be a philosopher, prepare to be laughed at from the start.",
                    body = "Philosophy, properly practised, involves doing and saying things that look odd from the outside: examining your assumptions, questioning what everyone takes for granted, declining to pursue what convention says is worth pursuing. People who have not done this work will not understand it — and incomprehension often presents as mockery.",
                    bullets = listOf(
                        InsightBullet("The price of seriousness", "Any life lived with genuine intention and unconventional values will invite incomprehension. This is not a sign that something has gone wrong — it is a sign that something is actually happening."),
                        InsightBullet("Not provocation", "Epictetus is not recommending courting controversy for its own sake. He is warning that if you live seriously, you should not be surprised when others treat that seriousness as an eccentricity.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Choosing It Anyway",
                    blockquote = "...prepare to be laughed at from the start.",
                    body = "The instruction is to prepare — not to avoid, not to be undeterred, but to go in with clear eyes. The philosophical life will cost you social comfort and the easy validation of fitting in. Epictetus says this is the honest price. It is worth knowing before you begin.",
                    bullets = listOf(
                        InsightBullet("Clarity before commitment", "Knowing the cost of a path in advance allows you to choose it freely rather than stumble into it and be surprised by the price."),
                        InsightBullet("The alternative cost", "What is the cost of not living seriously, not examining your life, not pursuing what you genuinely value? That cost is also real, and higher.")
                    )
                )
            ),
            modernApplication = "People who pursue unconventional paths — whether philosophical, creative, or ethical — frequently report the same friction: mockery or dismissal from those living differently. Research on social conformity shows that deviating from group norms triggers real social pressure. Epictetus's counsel: expect it, don't be stopped by it.",
            closing = "The laughing stops when the life becomes evident. Begin anyway.",
            reflectionPrompt = "Is there a way you have been holding back from living more seriously or authentically because of how it might appear to others? What would it cost you to stop holding back?"
        ),

        // q035 — Marcus Aurelius
        "q035" to QuoteInsight(
            intro = "Marcus Aurelius makes a claim that inverts the usual assumption about virtue: it does not need to be rewarded, recognised, or validated by outcomes. Good character is its own complete justification. This is not resignation — it is a precise account of where the value of virtue actually lives.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Self-Contained Value",
                    blockquote = "A good character carries within it its own reward.",
                    body = "Most things we pursue are valuable because of what they lead to — money enables comfort, status brings opportunity, skill produces results. Virtue is different. It is not valued for its consequences; it is valued in itself. Acting with integrity is not a means to a reward. It is the reward.",
                    bullets = listOf(
                        InsightBullet("Intrinsic value", "The person who acts well and receives no recognition has still acted well. The value is in the action, not in the response to it."),
                        InsightBullet("Independence from outcome", "External rewards for virtue are unreliable — they may not come. But the internal reward of knowing you acted with integrity cannot be taken away.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Why This Matters",
                    blockquote = "A good character carries within it...",
                    body = "If virtue required external reward to be worth pursuing, it would be a conditional good — something worth doing only if it paid off. Marcus argues it is unconditional. The person of good character acts well in situations where it costs them something, precisely because the action's value is not in the payoff.",
                    bullets = listOf(
                        InsightBullet("The test of character", "Character is most clearly visible when virtue has no practical benefit — when honesty costs you something, when fairness is inconvenient."),
                        InsightBullet("The lasting quality", "External rewards erode. The character that generated them does not.")
                    )
                )
            ),
            modernApplication = "Self-determination theory identifies intrinsic motivation — doing something because it is inherently valuable — as the most durable and satisfying form of motivation. External rewards can actually undermine the intrinsic satisfaction of virtuous action. Marcus's observation is consistent with modern psychology's best understanding of what makes action meaningful.",
            closing = "The person who acts well only when rewarded is not yet virtuous. They are merely strategic.",
            reflectionPrompt = "Think of a time you acted with integrity and received no recognition for it. Did the absence of recognition change the quality of the action? Should it have?"
        ),

        // q036 — Marcus Aurelius
        "q036" to QuoteInsight(
            intro = "This is Marcus Aurelius at his most startling: imagine yourself already dead, then look at what remains of your life as a gift. This is not morbidity. It is one of the most effective reframes in all of Stoic practice — a way of stepping outside the habituation that makes the present feel like nothing special.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Death Thought Experiment",
                    blockquote = "Think of yourself as dead. You have lived your life.",
                    body = "The instruction is to mentally complete your life — to stand at its imagined end and look back at the time remaining not as the continuation of something already underway, but as unexpected additional time. This shift in perspective changes how the remaining time feels.",
                    bullets = listOf(
                        InsightBullet("The gift quality", "A person who has survived a near-fatal experience often reports that life afterward feels more vivid, more valuable, more urgent. Marcus is producing this effect deliberately."),
                        InsightBullet("The habituation problem", "We adapt to our circumstances and begin to take them for granted. The death thought experiment temporarily breaks that adaptation.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Fresh Start",
                    blockquote = "Now take what's left and live it properly.",
                    body = "Having imaginatively completed your life, everything that follows is surplus — extra time you were not owed. This changes the frame entirely: from 'getting through' to 'using well.' From running out to being given more. From the habitual to the precious.",
                    bullets = listOf(
                        InsightBullet("Properly, not perfectly", "Live it 'properly' — not without flaw, not under extraordinary pressure, but according to your actual values and with genuine attention."),
                        InsightBullet("Today is the fresh start", "Marcus used this practice as a way to reset — not in crisis but as a regular exercise in perspective.")
                    )
                )
            ),
            modernApplication = "The technique Marcus describes is used in modern therapeutic contexts: imagining the end of something you currently take for granted — a relationship, a period of health, a chapter of life — and looking back from that imagined ending to appreciate what is present now. The psychological effect is real and well-documented.",
            closing = "What remains of your life is a bonus. Treat it accordingly.",
            reflectionPrompt = "If your life were considered complete right now, and what followed was simply extra time — how would you choose to use today?"
        ),

        // q037 — Marcus Aurelius
        "q037" to QuoteInsight(
            intro = "Marcus Aurelius addresses a specific form of anxiety: the fear of future difficulties. His response is not 'it will be fine' — it is something more useful. He points out that whatever reasoning and steadiness you bring to present challenges, you will bring those same capacities to future ones. The tool does not expire.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Don't Borrow Future Trouble",
                    blockquote = "Never let the future disturb you.",
                    body = "The future has not arrived. Its difficulties, if they come, will arrive with their own context, their own available information, their own set of circumstances. Borrowing suffering from it now — suffering in advance of events that may not materialise — is unnecessary and counterproductive.",
                    bullets = listOf(
                        InsightBullet("Premature suffering", "Worrying about future difficulty does not reduce it. It simply adds present suffering to a future that remains uncertain."),
                        InsightBullet("The unknown variables", "When the future difficulty arrives, you will have information you don't have now. The present anxiety is making decisions without that information.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Portable Tool",
                    blockquote = "...with the same weapons of reason which today arm you against the present.",
                    body = "This is the reassurance Marcus offers: the capacity for rational, measured response to difficulty is not a one-time resource — it travels with you. What helps you meet today's challenges will help you meet tomorrow's, because the instrument is reason itself, which does not deteriorate.",
                    bullets = listOf(
                        InsightBullet("The constant", "Circumstances change. Reason remains. The tool that helps you now is the same tool that will help you then."),
                        InsightBullet("Confidence without certainty", "Marcus is not saying the future will be easy. He is saying you will face it with the same equipment you are using now — and that is enough.")
                    )
                )
            ),
            modernApplication = "Research on resilience consistently finds that people who have navigated past difficulties tend to carry greater confidence in their ability to handle future ones — not because the future is less difficult, but because they have evidence of their own capacity to respond. Marcus is pointing to that same self-evidence.",
            closing = "The reasoning that arms you today will arm you tomorrow. You are not meeting the future unarmed.",
            reflectionPrompt = "What future difficulty are you most anxious about? Consider how the same rationality and steadiness you bring to today's challenges could meet that one too."
        ),

        // q038 — Marcus Aurelius
        "q038" to QuoteInsight(
            intro = "In this line from the Meditations, Marcus Aurelius applies the Stoic theory of impressions to knowledge itself. Every conclusion we hold, every judgment we make, is not direct access to reality — it is our interpretation of what our senses and minds have received. Epistemological humility is not scepticism; it is accuracy.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What We Hear",
                    blockquote = "Everything we hear is an opinion, not a fact.",
                    body = "Information arrives already filtered — by the speaker's perspective, interests, knowledge, and blind spots, and then by our own. What we receive as 'what happened' is actually 'what someone believes happened, filtered through what we believe about what they believe.' Treating opinion as fact is the source of countless errors in judgment.",
                    bullets = listOf(
                        InsightBullet("The filter stack", "Every piece of information has passed through multiple interpretive layers before reaching you. The Stoic asks: how many layers, and what distortions might each have introduced?"),
                        InsightBullet("Not paralysis", "Recognising that what you hear is opinion does not mean refusing to act on it. It means holding it with appropriate tentativeness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What We See",
                    blockquote = "Everything we see is a perspective, not the truth.",
                    body = "Visual perception feels immediate and direct — but it is constructed by the brain from incomplete information, shaped by expectation and attention, and bounded by a single viewpoint. The Stoics were not idealists who denied external reality; they were careful thinkers who recognised that access to reality is always mediated.",
                    bullets = listOf(
                        InsightBullet("The partial view", "You see from one position, with one history, with one set of concerns. Someone else stands elsewhere and sees something genuinely different — not wrong, just different."),
                        InsightBullet("The virtue of tentativeness", "Holding your perceptions as perspectives rather than as truths makes you more accurate, more genuinely curious, and more open to correction.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Treating Perception as Truth",
                rightHeader = "Treating Perception as Perspective",
                rows = listOf(
                    "My view is correct; other views are errors." to "My view is partial; other views add what I'm missing.",
                    "Disagreement is a threat." to "Disagreement is information.",
                    "Certainty is comfortable." to "Tentativeness is accurate."
                )
            ),
            modernApplication = "Cognitive science confirms what Marcus observed: perception is actively constructed, not passively received. We fill gaps, match patterns, and apply expectations — often without awareness. The humility Marcus practises is not weakness; it is a more accurate account of how minds actually access the world.",
            closing = "You see what you are positioned to see. The truth is larger than any one position.",
            reflectionPrompt = "Think of a situation where you are confident in your interpretation. What perspective would someone standing elsewhere — with different experiences or interests — bring that you might be missing?"
        ),

        // q039 — Marcus Aurelius
        "q039" to QuoteInsight(
            intro = "Marcus Aurelius applies a precise cost-benefit analysis to anger. The observation is not philosophical — it is practical. The anger almost always costs more than the thing that caused it, in time, in health, in damaged relationships, in the quality of decisions made while inflamed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Disproportionate Cost",
                    blockquote = "How much more grievous are the consequences of anger...",
                    body = "Anger distorts perception, impairs judgment, damages relationships, and continues burning long after the triggering event has passed. The person who was wronged in a small way and responded with large anger has compounded their suffering: first the original slight, then the corrosive aftermath of the anger itself.",
                    bullets = listOf(
                        InsightBullet("The aftermath", "Anger rarely ends when the situation ends. It follows you — in rumination, in regret, in the damage left behind in words said or decisions made."),
                        InsightBullet("The physical cost", "Chronic anger is associated with measurable harm to cardiovascular health, immune function, and sleep quality. The body pays the bill.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Examining the Causes",
                    blockquote = "...than the causes of it.",
                    body = "The causes of anger — the rude comment, the unfair treatment, the broken expectation — are usually smaller than the response they trigger. Marcus does not say the causes are imaginary or trivial. He says the consequences of anger are almost always larger than the causes justify.",
                    bullets = listOf(
                        InsightBullet("The proportionality test", "Before acting from anger, ask: is the response I am considering proportionate to what actually happened, or proportionate to how I feel about what happened?"),
                        InsightBullet("The Stoic pause", "Marcus practised a deliberate pause between stimulus and response — enough time to let the first intensity of anger pass and reason to resume.")
                    )
                )
            ),
            modernApplication = "Research on anger consistently shows that expressing anger typically intensifies rather than releases it, and that the person most harmed by unmanaged anger is usually the one who holds it. The Stoic prescription — pause, examine the proportion, choose the response — is consistent with the most effective modern anger-management approaches.",
            closing = "The price of anger is almost always paid by the person who feels it.",
            reflectionPrompt = "Think of the last time you were genuinely angry. Looking back now, were the consequences of that anger greater than the cause justified? What might a more proportionate response have looked like?"
        ),

        // q040 — Marcus Aurelius
        "q040" to QuoteInsight(
            intro = "In this line from the Meditations, Marcus Aurelius points to something that Stoic practice aims to make accessible: an inner source of strength that does not depend on external conditions. It is always available, but it requires something specific to access it — the willingness to look inward rather than outward.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Inner Source",
                    blockquote = "Look well into thyself; there is a source of strength...",
                    body = "The strength Marcus describes is not willpower or raw determination — it is the deeper stability of a person who knows who they are and what they stand for. This kind of strength does not require favourable circumstances. It requires self-knowledge and the practice of returning to it.",
                    bullets = listOf(
                        InsightBullet("Not circumstantial", "External strength — confidence from success, energy from good circumstances — is conditional. The inner strength Marcus describes is unconditional."),
                        InsightBullet("The practice of looking", "Meditations itself is the record of Marcus looking inward — not once, but daily. The strength is not found once and banked. It is renewed through the practice of looking.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Condition of Access",
                    blockquote = "...which will always spring up if thou wilt always look.",
                    body = "'Always spring up' — the image is of a natural source, inexhaustible, ready. The condition is 'if thou wilt always look.' The source is not given automatically. It requires direction of attention. The person who looks outward for strength will find it inconsistent; the person who looks inward will find it always available.",
                    bullets = listOf(
                        InsightBullet("The inward turn", "Every tradition of depth — philosophical, contemplative, psychological — points to the same discovery: the most durable resources are inward, not outward."),
                        InsightBullet("Regular access", "The word 'always' is key: not look once and find, but look regularly and find regularly. This is a description of a practice, not a single event.")
                    )
                )
            ),
            modernApplication = "Research on psychological resilience consistently finds that the most resilient people tend to have a stable, coherent sense of identity and values — an inner foundation they can return to when external conditions are adverse. Marcus is describing this same foundation and pointing to how it is built: by looking, and looking again.",
            closing = "The strength you are looking for outside is waiting for you to look inside.",
            reflectionPrompt = "When you face difficulty, where do you first turn for strength — outward or inward? What would it look like to make the inward turn more deliberate and more regular?"
        ),

        // q048 — Seneca
        "q048" to QuoteInsight(
            intro = "This is one of Seneca's most counterintuitive — and most liberating — observations. We usually think difficulty causes hesitation. Seneca argues the opposite: hesitation is what creates difficulty. Fear, not the task itself, is the obstacle.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Paradox of Difficulty",
                    blockquote = "It is not because things are difficult that we do not dare...",
                    body = "We tell ourselves: \"I'll start when I'm ready. I'll apply when I have more experience. I'll speak when I'm more confident.\" We treat daring as something that follows readiness. Seneca inverts this. The readiness you're waiting for only comes through daring, not before it.",
                    bullets = listOf(
                        InsightBullet("The story we tell", "\"It's too hard\" — this feels like an observation about the task."),
                        InsightBullet("The truth beneath it", "\"I'm afraid\" — this is actually an observation about ourselves.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Daring Creates the Path",
                    blockquote = "...it is because we do not dare that they are difficult.",
                    body = "The undared thing looms. It grows in the imagination. Each day of avoidance adds weight to it. The moment you begin — imperfect, uncertain, afraid — it begins to shrink back to its actual size. Action is the antidote to the illusion of difficulty.",
                    bullets = listOf(
                        InsightBullet("Competence follows action", "You become capable by doing the thing, not by preparing to do the thing."),
                        InsightBullet("Confidence is retrospective", "Real confidence — not bravado — only comes after you've done the hard thing and survived.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Waiting for Readiness",
                rightHeader = "Acting into Readiness",
                rows = listOf(
                    "Difficulty feels external, fixed." to "Difficulty is revealed as internal, malleable.",
                    "The task grows in the imagination." to "The task shrinks on contact with action.",
                    "Confidence is a prerequisite." to "Confidence is a by-product."
                )
            ),
            modernApplication = "The research on procrastination consistently shows that the emotional relief of avoidance is real but short-lived, while the cost — accumulated anxiety, shrinking self-belief — compounds over time. The task itself is rarely as bad as the dread of it. Seneca's prescription: begin before you feel ready.",
            closing = "The mountain looks tallest from the base. Begin climbing and watch it change.",
            reflectionPrompt = "What is one thing you've been telling yourself is \"too difficult\" or that you're \"not ready for\"? What would happen if you began it — imperfectly — today?"
        ),

        // q041 — Marcus Aurelius
        "q041" to QuoteInsight(
            intro = "Marcus Aurelius uses mortality not as a source of dread but as a clarifying instrument. If you could leave life right now — if this were your last moment — what would that fact say about how you should use the moments that remain? The answer to that question is the answer to how you should live.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Clarifying Thought",
                    blockquote = "You could leave life right now.",
                    body = "This is not morbid speculation — it is accurate. The possibility of death at any moment is real, not remote. Marcus uses this truth deliberately: if life could end now, what does that do to the weight and quality of this present moment? It makes it count. It makes the trivial look trivial and the important look important.",
                    bullets = listOf(
                        InsightBullet("The filter", "Few things survive the memento mori filter. Most of what we worry about, most of what we argue about, shrinks dramatically when seen against the backdrop of mortality."),
                        InsightBullet("The amplifier", "What survives the filter — relationships, integrity, genuine work — becomes more vivid, more urgent, more obviously worth attending to.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practical Instruction",
                    blockquote = "Let that determine what you do and say and think.",
                    body = "Not as an abstract exercise but as a practical guide. What would you do? What would you say to the people around you? What would you stop thinking about? Marcus is asking these questions not in crisis but as a daily practice — a way of keeping priorities in alignment with reality.",
                    bullets = listOf(
                        InsightBullet("Do", "Act in ways you would not regret if this were the last day. Which choices survive that test?"),
                        InsightBullet("Say", "Speak in ways you would stand behind if your words were the last ones. Which conversations would you start, or finish, differently?")
                    )
                )
            ),
            modernApplication = "Research on terror management theory shows that awareness of mortality, when processed constructively, shifts priorities toward meaning, relationships, and values rather than status and accumulation. Marcus's daily practice produces exactly the constructive processing the research describes.",
            closing = "Death is not the enemy of life. Forgetting that you are mortal is.",
            reflectionPrompt = "If today were your last, what would you do differently — in your actions, your words, your thoughts? Is any of that worth starting without waiting for the last day?"
        ),

        // q042 — Marcus Aurelius
        "q042" to QuoteInsight(
            intro = "Marcus Aurelius defines perfection of character not as an achievement but as a daily practice. Live each day as if it were your last — but not in panic, not in passivity, and not in pretense. Three negatives that together define a middle way: full engagement without distortion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Standard: Each Day as the Last",
                    blockquote = "Perfection of character is this: to live each day as if it were your last...",
                    body = "This is not merely about intensity or urgency — it is about alignment. A person living their last day does not waste it on things that don't matter to them. They do not hold back from people they love. They do not defer what is important. The last-day frame clarifies and concentrates.",
                    bullets = listOf(
                        InsightBullet("The alignment function", "The last-day thought removes the assumption that there will always be more time — and with it, the habitual deferral that assumption enables."),
                        InsightBullet("Not literally last", "Marcus doesn't mean the exhausted finish line. He means the clarity and intention of a person who knows this moment counts.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Three Negatives",
                    blockquote = "...without frenzy, without apathy, without pretense.",
                    body = "Three wrong responses to mortality: frenzy (racing panic, desperate accumulation of experience), apathy (giving up because it all ends anyway), and pretense (performing a life rather than living it). Marcus rules all three out. What remains is genuine, steady, present engagement.",
                    bullets = listOf(
                        InsightBullet("Without frenzy", "The last day is not about doing everything — it is about being fully present in what is actually here."),
                        InsightBullet("Without apathy or pretense", "Apathy says nothing matters because it ends. Pretense performs a life for observers. Both are forms of absence from your own experience.")
                    )
                )
            ),
            modernApplication = "The research on 'good death' — what people value in their final days — consistently emphasises presence, genuine connection, and integrity over achievement or experience accumulation. Marcus is describing the same qualities as a daily standard rather than a deathbed discovery.",
            closing = "You do not need to wait for the last day to live as if it were the last day.",
            reflectionPrompt = "Of the three — frenzy, apathy, or pretense — which is most present in your current life? What would living without it look like today?"
        ),

        // q043 — Marcus Aurelius
        "q043" to QuoteInsight(
            intro = "Marcus Aurelius offers a gentle reframe for the anxiety that precedes new things: the fear of the unfamiliar is simply the recognition that something genuinely new is approaching. That newness is not a threat — it is the raw material of experience. The corner hides what the straight path never offered.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Fear Before New Things",
                    blockquote = "Never be afraid of what you are about to do...",
                    body = "Fear before a new action or experience is natural — the unfamiliar triggers a vigilance response that evolved for good reasons. But the Stoics taught that initial fear is not reliable information about the actual danger ahead. It is information about the state of the mind encountering the unknown.",
                    bullets = listOf(
                        InsightBullet("Fear is about the unknown, not the thing", "Most fear before new experiences is fear of the category 'unknown' rather than specific knowledge of what is coming."),
                        InsightBullet("The pre-experience limit", "You cannot know how you will feel about an experience before you have had it. Fear before the experience is prediction, not perception.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Promise Around the Corner",
                    blockquote = "...a new experience is just around the corner.",
                    body = "What lies around the corner of any new action is, by definition, something you have not encountered before. That is precisely the value of it. New experience — however it arrives — is the mechanism by which you grow, learn, and discover what you are capable of.",
                    bullets = listOf(
                        InsightBullet("The growth edge", "Every meaningful development comes from encountering something new. The fear before a new thing is often the feeling of standing at the growth edge."),
                        InsightBullet("Reframe", "Instead of 'I'm afraid of what's ahead,' try: 'something genuinely new is ahead.' The same fact, differently framed.")
                    )
                )
            ),
            modernApplication = "Approach motivation research shows that framing new situations as opportunities to gain rather than threats to defend against produces better performance, more creative thinking, and greater satisfaction. Marcus's reframe — a new experience is approaching — is exactly the shift from avoidance to approach orientation.",
            closing = "The corner hides not danger but discovery. Walk toward it.",
            reflectionPrompt = "What new thing are you currently afraid of doing? Can you reframe it — not as something threatening but as a new experience approaching? How does that feel?"
        ),

        // q044 — Epictetus
        "q044" to QuoteInsight(
            intro = "Epictetus gives the Stoic definition of courage — and it is not the absence of fear. That definition would disqualify almost everyone and make courage a gift rather than a practice. Instead, courage is the conquest of fear: feeling it and acting well anyway. This is both more demanding and more useful.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Courage Is Not",
                    blockquote = "The brave man is not he who does not feel afraid...",
                    body = "Fearlessness is either a gift of temperament, a product of ignorance, or evidence of an absence of stakes. None of these is courage. The person who does not feel afraid before genuine danger either does not understand the danger or does not care about the outcome. Neither is admirable.",
                    bullets = listOf(
                        InsightBullet("The wrong standard", "Defining courage as the absence of fear sets an impossible standard for most people and excludes from courage precisely those who feel fear most acutely."),
                        InsightBullet("Fear as appropriate response", "In genuinely dangerous situations, fear is the correct physiological and psychological response. It is not the enemy of courage — it is its necessary raw material.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Courage Is",
                    blockquote = "...but he who conquers that fear.",
                    body = "Conquest here does not mean elimination. It means acting in the presence of fear, choosing the right action despite the pull of avoidance. This is entirely within reach — not for the fearless few but for anyone willing to act from values rather than from the path of least resistance.",
                    bullets = listOf(
                        InsightBullet("Action despite feeling", "The courageous act is defined by its relation to fear, not by its absence of it. The fear may be present; the right action happens anyway."),
                        InsightBullet("Practisable", "Because courage is defined as a practice rather than a state, it can be developed. Every small act of choosing difficulty over ease is a practise of courage.")
                    )
                )
            ),
            modernApplication = "The psychological literature on courage distinguishes between physical courage (facing bodily danger) and moral courage (acting from values against social pressure). Both involve the same structure Epictetus describes: acknowledging the fear and acting well anyway. Both can be trained.",
            closing = "Courage is not the absence of fear. It is the decision that something else matters more.",
            reflectionPrompt = "Think of something you have been avoiding because it frightens you. If you acted despite the fear — not after it disappeared but while it was present — what would that look like?"
        ),

        // q045 — Epictetus
        "q045" to QuoteInsight(
            intro = "Epictetus makes a simple but profound claim about the function of difficulty: it is revelatory. Not punishing, not arbitrary, not merely something to survive — difficulty shows you what you are made of. This reframe turns adversity from something to avoid into something that provides genuinely useful information.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Difficulty as Mirror",
                    blockquote = "Difficulties are things that show a person what they are.",
                    body = "In comfortable circumstances, it is possible to believe you are more patient, more principled, more generous than you actually are. Difficulty tests those beliefs. It shows, with uncomfortable clarity, whether the character you thought you had is actually there under pressure or only in the absence of it.",
                    bullets = listOf(
                        InsightBullet("The revealing function", "Hardship does not create character so much as it reveals what is already there — or reveals what is absent and needs building."),
                        InsightBullet("Comfortable self-deception", "Easy circumstances do not test character; they only fail to contradict the flattering story you hold about yourself.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What the Showing Offers",
                    blockquote = "Difficulties are things that show...",
                    body = "Being shown what you are — even if what is shown is difficult — is valuable. You cannot improve what you do not see. Difficulty strips away the comfortable assumptions and reveals the actual starting point. That may be humbling; it is also the only honest foundation for genuine development.",
                    bullets = listOf(
                        InsightBullet("Useful information", "If difficulty reveals a gap between who you thought you were and who you actually are, that gap is where the real work lies."),
                        InsightBullet("Not judgment", "The Stoic does not treat the revelation as a condemnation — it is simply data, and data is the starting point for change.")
                    )
                )
            ),
            modernApplication = "Post-traumatic growth research shows that people who engage constructively with difficulty — examining what it revealed about themselves and using that to grow — often emerge with stronger character and greater resilience than before. The difficulty was not wasted; it was informative.",
            closing = "You cannot know who you are in the easy moments. Difficulty provides the honest answer.",
            reflectionPrompt = "Think of a recent difficulty you faced. What did it reveal about you — your actual patience, courage, or steadiness — that the comfortable version of your life had not shown?"
        ),

        // q046 — Seneca
        "q046" to QuoteInsight(
            intro = "Seneca's observation connects risk and achievement with a structural claim: not that danger is good in itself, but that anything worth accomplishing will involve some exposure to loss, failure, or the unknown. The absence of any risk is almost always the absence of anything genuinely valuable being attempted.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Structure of Achievement",
                    blockquote = "Nothing great is accomplished without danger.",
                    body = "Danger here means exposure — the risk of failure, of judgment, of loss, of being wrong in a way that matters. Any action that involves genuine stakes carries this exposure. This is not accidental: the things worth doing are worth doing precisely because they involve real effort toward uncertain outcomes.",
                    bullets = listOf(
                        InsightBullet("The risk-value correlation", "The size of what is attempted tends to correlate with the size of what is at risk. Small bets, safe paths, and guaranteed outcomes rarely produce great things."),
                        InsightBullet("Not recklessness", "Seneca is not recommending courting danger for its own sake. He is observing that the presence of risk is the honest indicator that something of substance is being attempted.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Danger Indicates",
                    blockquote = "Nothing great is accomplished...",
                    body = "Conversely: the absence of any danger, risk, or exposure is almost always a sign that nothing of significance is being attempted. The safe path, the guaranteed return, the risk-free option — these are descriptions of the unremarkable. If nothing is at stake, the odds are that nothing much will result.",
                    bullets = listOf(
                        InsightBullet("Danger as signal", "When you feel the exposure that comes with attempting something significant, that feeling is not a warning to stop — it is a confirmation that you are attempting something real."),
                        InsightBullet("The cost of safety", "Playing safe has a cost that is rarely measured: the accumulated weight of unrealised potential.")
                    )
                )
            ),
            modernApplication = "Research on high achievement consistently shows that the defining variable is not talent or circumstance but willingness to tolerate the discomfort and risk involved in genuinely attempting something difficult. The people who accomplish most are not those who face less risk — they are those who act despite it.",
            closing = "If there is no exposure, there is probably no great thing being built.",
            reflectionPrompt = "What would you attempt if the risk of failure felt more acceptable to you? What is the real cost of not attempting it?"
        ),

        // q047 — Seneca
        "q047" to QuoteInsight(
            intro = "Seneca's Latin — vivere militare est — compresses a whole Stoic attitude into three words. Life is not a state of rest interrupted by challenges; it is itself the challenge. The soldier metaphor is not about violence — it is about the posture of someone who has accepted that conditions will be difficult and has prepared accordingly.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Life as Active Engagement",
                    blockquote = "Vivere militare est — To live is to fight.",
                    body = "The soldier does not expect the campaign to be comfortable. They prepare, they endure, they adapt. They do not treat hardship as an anomaly — they treat it as the nature of the work. Seneca is applying this posture to life itself: not that life should be warlike, but that it requires the same active, prepared engagement.",
                    bullets = listOf(
                        InsightBullet("The prepared posture", "The soldier is not defeated by difficulty because they expected difficulty. The person who expected an easy life is defeated by ordinary adversity."),
                        InsightBullet("Not pessimism", "This is not saying life is nothing but suffering. It is saying that life requires active engagement — not passive waiting for difficulty to resolve itself.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Implication for How We Meet Difficulty",
                    blockquote = "To live is to fight.",
                    body = "If life is inherently a form of active struggle, then difficulty is not an interruption of life — it is part of what life is. This reframe changes the emotional response to hardship: from 'why is this happening to me' to 'this is the nature of the terrain I chose to navigate by being alive.'",
                    bullets = listOf(
                        InsightBullet("Normalising difficulty", "When you expect challenge as part of life's structure, each challenge becomes navigable rather than outrageous."),
                        InsightBullet("The active stance", "Fighting — in Seneca's sense — means engaging, not withdrawing. Showing up with full capacity, not conserving yourself for a comfort that won't arrive.")
                    )
                )
            ),
            modernApplication = "Psychological resilience research identifies 'hardiness' — the belief that life involves challenge and that challenge is meaningful rather than threatening — as one of the strongest predictors of wellbeing under stress. Seneca is describing the hardy posture: life is campaign, not holiday.",
            closing = "The person who expects difficulty is never surprised by it. That is a profound advantage.",
            reflectionPrompt = "How do you typically meet difficulty — as an anomaly that shouldn't be happening, or as part of the terrain of a life fully engaged? How would your response to current challenges change if you held the second view?"
        ),

        // q049 — Seneca
        "q049" to QuoteInsight(
            intro = "Four words from Seneca that describe one of the most underappreciated forms of strength. Not the dramatic conquest or the brilliant solution — but endurance. The person who simply does not quit is, in the long run, the person who wins most of the things worth winning.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Quiet Victory",
                    blockquote = "He conquers who endures.",
                    body = "Conquest usually implies a decisive moment — the decisive battle, the breakthrough, the climactic effort. Seneca points to something different: the victory that comes not from a single brilliant act but from the accumulated weight of not stopping. Most long-term achievements are won this way.",
                    bullets = listOf(
                        InsightBullet("Duration over intensity", "The person who keeps going at moderate intensity across years typically outproduces the person who exerts maximum intensity for months. Endurance compounds."),
                        InsightBullet("The invisible victory", "Endurance rarely looks like winning from the outside. It often looks like ordinary persistence — until the cumulative effect becomes undeniable.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Endurance Requires",
                    blockquote = "He conquers...",
                    body = "Endurance is not passive — it is an active choice made repeatedly. Every day of continuing is a decision. Every moment of not stopping is a small act of will. The enduring person is not someone without difficulty; they are someone who has decided that stopping is not an option they are taking.",
                    bullets = listOf(
                        InsightBullet("Not stubbornness", "Endurance is applied with judgment. Persisting in the wrong direction is not endurance — it is refusal to learn. Seneca means enduring in the right direction, even when it is hard."),
                        InsightBullet("The habit of continuing", "Each act of continuing, however small, reinforces the capacity for further continuation. Endurance builds itself.")
                    )
                )
            ),
            modernApplication = "Research on achievement in every long-duration domain — athletic, academic, entrepreneurial, artistic — consistently finds that the variable most predictive of eventual success is not initial talent but sustained persistence. The people who finish what they begin are, by that fact alone, a small minority.",
            closing = "The race is not always to the swift. It is often to those who do not stop.",
            reflectionPrompt = "What are you currently close to giving up on? Is the difficulty you are experiencing a signal that the path is wrong — or simply the experience of what endurance actually feels like?"
        ),

        // q050 — Seneca
        "q050" to QuoteInsight(
            intro = "This quote describes what has come to be known as the Stockdale Paradox — the combination of unwavering long-term optimism with unsparing short-term realism. The two are often treated as opposites. Seneca understood they must coexist. Faith without realism is delusion. Realism without faith is despair.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Faith Without Illusion",
                    blockquote = "You must never confuse faith that you will prevail in the end...",
                    body = "Faith here is not wishful thinking — it is a settled orientation toward eventual success that remains stable even when current conditions are adverse. It is the conviction that the work matters, that continuing is correct, that the outcome toward which you are working is achievable — even when no evidence of that is immediately visible.",
                    bullets = listOf(
                        InsightBullet("Not optimism bias", "The faith Seneca describes is not the belief that things will be easy or that difficulty won't come. It is the belief that you will come through it — which is different."),
                        InsightBullet("The motivation function", "Without some version of this faith, sustained effort in difficult circumstances is psychologically impossible. The faith is the fuel.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Realism Without Despair",
                    blockquote = "...with the discipline to confront the most brutal facts of your current reality.",
                    body = "The discipline to see clearly — to acknowledge bad news, to face difficult realities without minimising them — is not the enemy of faith. It is its partner. The person who sees clearly what they are dealing with can respond to it accurately. The person who looks away cannot.",
                    bullets = listOf(
                        InsightBullet("Facts, not interpretations", "Brutal facts are confronted as facts, not as proof that the situation is hopeless. They are information about what needs to be addressed."),
                        InsightBullet("The Stoic combination", "The Stoic holds both: I will endure, AND this is genuinely difficult. The combination is more resilient than either alone.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Unbalanced Approaches",
                rightHeader = "The Stoic Balance",
                rows = listOf(
                    "Pure optimism: 'It will all work out.' (Avoids the brutal facts)" to "Faith + Realism: 'This is genuinely hard, AND I will come through it.'",
                    "Pure realism: 'The facts are terrible.' (No faith to sustain effort)" to "See the facts clearly, and continue anyway.",
                    "Either/or thinking about hope and honesty." to "Both/and: hope and honesty together."
                )
            ),
            modernApplication = "Admiral James Stockdale, held as a prisoner of war for years, identified exactly this dynamic in those who survived versus those who did not. Those who combined genuine faith with clear-eyed realism endured. Those who held only optimism were broken when their predictions failed. Those who had no faith gave up.",
            closing = "See clearly. Continue anyway. These are not contradictions — they are the full Stoic posture.",
            reflectionPrompt = "In your most difficult current situation, where are you on the spectrum — too optimistic about how hard it will be, or too pessimistic about whether you can come through it? What would the balanced position look like?"
        ),

        // q051 — Epictetus
        "q051" to QuoteInsight(
            intro = "Epictetus gives a two-part instruction for one of the most demanding forms of Stoic practice: self-examination. Not a comfortable survey of strengths, but a direct engagement with the parts of yourself that you would rather not examine — and then, crucially, work to address them rather than simply condemning them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Confrontation",
                    blockquote = "Confront the dark parts of yourself...",
                    body = "The dark parts are the things we avoid looking at: the selfishness, the fear, the resentment, the small cruelties, the ways we are not the person we believe ourselves to be. Epictetus doesn't say acknowledge them distantly or accept them philosophically — he says confront them, which implies a direct and honest encounter.",
                    bullets = listOf(
                        InsightBullet("Why avoid it", "Most people avoid honest self-examination because the encounter with their own shadow is uncomfortable. The discomfort is precisely the signal that something real is being seen."),
                        InsightBullet("The necessary beginning", "You cannot work on what you have not confronted. The Stoic examination is not self-punishment — it is the essential first step in any genuine self-improvement.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Work That Follows",
                    blockquote = "...and work to banish them with illumination and forgiveness.",
                    body = "Two tools: illumination (seeing clearly) and forgiveness (not condemning yourself for what is seen). Neither alone is sufficient. Illumination without forgiveness becomes harsh self-judgment that paralyses. Forgiveness without illumination becomes comfortable self-acceptance that changes nothing.",
                    bullets = listOf(
                        InsightBullet("Illumination", "See the dark part clearly — what it is, where it comes from, how it operates in your behaviour. Name it specifically."),
                        InsightBullet("Forgiveness", "Having seen it, do not treat it as a permanent verdict. You are not your worst tendencies — you are the person who can, having seen them, choose differently.")
                    )
                )
            ),
            modernApplication = "Depth psychology, acceptance and commitment therapy, and shadow work all converge on the same practice Epictetus describes: bringing unconscious or avoided aspects of self into awareness, with both honesty and self-compassion. The research is clear: avoidance prolongs; honest engagement with self-forgiveness transforms.",
            closing = "You cannot banish what you refuse to see. And you cannot see clearly while condemning yourself for what is found.",
            reflectionPrompt = "What is the dark part of yourself — the tendency, the pattern, the impulse — that you most avoid confronting? What would it look like to look at it directly, with honesty and without self-condemnation?"
        ),

        // q052 — Epictetus
        "q052" to QuoteInsight(
            intro = "Epictetus offers something that simple philosophy rarely provides: a time horizon. This pain will turn to your good — but the qualifier is crucial: by and by. Not immediately. Not once you have understood it intellectually. In time, through endurance, through the arc that pain traces when it is met rather than fled.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Instruction: Endure and Persist",
                    blockquote = "Endure and persist...",
                    body = "Two words, not one. Endure — which implies passive bearing of what cannot be changed. Persist — which implies active continuation in the direction of your purpose. Together they describe the Stoic response to pain: hold on to what you must bear, and keep moving in the direction that matters.",
                    bullets = listOf(
                        InsightBullet("Endure", "Some pain cannot be resolved, only borne. The Stoic endures without amplifying through complaint, resentment, or dramatic response."),
                        InsightBullet("Persist", "Alongside endurance, persistence: keep doing the work, keep moving, keep engaging — not in spite of the pain but through it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Transformation Over Time",
                    blockquote = "...this pain will turn to your good by and by.",
                    body = "The mechanism by which pain turns to good is not mysterious: endured pain builds resilience, reveals character, deepens understanding, and creates the experience base from which wisdom is drawn. The transformation is real, but it takes time, and the time requirement is non-negotiable.",
                    bullets = listOf(
                        InsightBullet("Not automatic", "Pain does not automatically become good. It becomes good when engaged with honestly and endured without being allowed to corrupt character or destroy purpose."),
                        InsightBullet("The by and by", "The time dimension matters. Expecting immediate transformation is a form of impatience. Growth is almost always slower than the pain that drives it.")
                    )
                )
            ),
            modernApplication = "Post-traumatic growth research confirms that people who endure significant difficulty and engage with it constructively — rather than avoiding or catastrophising — often report enhanced personal strength, new possibilities, and deeper relationships compared to before the difficulty. The growth is real, and it is never immediate.",
            closing = "The transformation that pain makes possible is not a consolation prize. It is a genuine gift — delivered slowly.",
            reflectionPrompt = "Think of a pain in your life that has not yet turned to good. Are you enduring it — bearing it without amplifying it — and persisting in the direction that matters? What might the 'by and by' look like?"
        ),

        // q053 — Epictetus
        "q053" to QuoteInsight(
            intro = "Epictetus gives a training prescription that applies as much to virtue as to athletics: start small, build systematically, progress to greater things. No one becomes courageous by facing the greatest possible challenge first. They become courageous by facing a series of progressively demanding challenges, each built on the last.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Training Principle",
                    blockquote = "Practice yourself, for heaven's sake, in little things...",
                    body = "The 'for heaven's sake' is urgency — this is not optional or trivial. The little things are not practice for the real work; they are the real work, at the beginning. The person who neglects the small practices, assuming they will rise to the occasion when it matters, is mistaken: occasions are met with the habits already formed.",
                    bullets = listOf(
                        InsightBullet("Small is where skill is built", "Every large capacity — patience, courage, self-control — is an accumulation of small acts. There is no shortcut around the small things."),
                        InsightBullet("Daily rehearsal", "Stoic practice was deliberately incremental: a small act of restraint today, a slightly larger one tomorrow. The virtue grows with the practice.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Progression",
                    blockquote = "...and thence proceed to greater.",
                    body = "The greater things are not separate from the little things — they are the little things, at scale. The person who has practised honesty in small, low-stakes moments will have it available in large, high-stakes ones. The practice is the preparation.",
                    bullets = listOf(
                        InsightBullet("Stacking capacity", "Each small practice adds to the next. The person who has practised patience in traffic has marginally more patience when it matters in a difficult relationship."),
                        InsightBullet("The test reveals the training", "When the significant moment arrives, what shows up is the product of all the small moments preceding it. You meet it with what you have built.")
                    )
                )
            ),
            modernApplication = "Habit formation research confirms that complex behaviours are built through small, repeated actions rather than through single dramatic changes. The principle of progressive overload in training — incrementally increasing challenge — applies equally to psychological and character development.",
            closing = "The great act is impossible without the long preparation of little ones.",
            reflectionPrompt = "What virtue or capacity do you want to develop? What is the smallest, most immediate opportunity to practise it today — not in a significant moment, but in an ordinary one?"
        ),

        // q054 — Marcus Aurelius
        "q054" to QuoteInsight(
            intro = "Marcus Aurelius refines the Stoic theory of impressions into something actionable: not only is your judgment the source of your pain, but you have the power to revise that judgment now — not eventually, not once you have processed the situation, but immediately. The freedom is not future; it is present.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Source of Pain",
                    blockquote = "If you are pained by any external thing, it is not this thing that disturbs you, but your own judgment about it.",
                    body = "Marcus applies Epictetus's foundational principle to pain specifically. The external thing is what it is — it cannot disturb you by itself. What disturbs you is the meaning you attach to it: the judgment that it is terrible, unfair, unacceptable, a sign of something bad about you or your life. That judgment is yours.",
                    bullets = listOf(
                        InsightBullet("The useful implication", "If pain comes from your judgment, then pain can be addressed by examining your judgment. You are not powerless before your own suffering."),
                        InsightBullet("Not denial", "This is not saying external things don't matter or that pain isn't real. It is locating the pain correctly — in the interpretation, not the event.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Power to Wipe It Out",
                    blockquote = "And it is in your power to wipe out that judgment now.",
                    body = "Now — not after reflection, not once you understand it better. The judgment that is causing your pain can be examined and revised in this moment. This is a demanding claim. But Marcus means it: the rational faculty that generates judgments can also dissolve them when they are examined.",
                    bullets = listOf(
                        InsightBullet("The immediate application", "Ask right now: what am I telling myself about this situation that is causing me pain? Is that judgment true? Is it necessary?"),
                        InsightBullet("The practice", "Wiping out the judgment is not suppression — it is genuine revision. You examine the judgment, find it wanting, and let it go.")
                    )
                )
            ),
            modernApplication = "Cognitive reappraisal — the practice of examining and revising your interpretation of a situation — is one of the most evidence-supported psychological interventions for managing emotional distress. Marcus describes the process and locates the power to engage it exactly where it is: in you, right now.",
            closing = "The freedom from your pain is not locked away somewhere. It is available in the moment you examine the judgment that created it.",
            reflectionPrompt = "What external thing is currently causing you pain? What judgment are you holding about it? Is that judgment definitely true — and does it serve you to hold it?"
        ),

        // q055 — Marcus Aurelius
        "q055" to QuoteInsight(
            intro = "Five words that contain an entire psychology. Marcus Aurelius is not offering a motivational insight — he is making a structural claim about how human experience is produced. The life you live is not a product of your circumstances. It is a product of what your thoughts make of your circumstances.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Thoughts as Architects",
                    blockquote = "Our life is what our thoughts make it.",
                    body = "The same event — a setback, a disappointment, an unexpected difficulty — can be made into a catastrophe or an education depending entirely on what the mind does with it. The thought is not the commentary on the life. The thought is the construction of the life, in real time.",
                    bullets = listOf(
                        InsightBullet("Active construction", "You are not passively receiving a life. You are, through your interpretations and judgments, actively constructing your experience of it moment by moment."),
                        InsightBullet("Two people, one event", "Two people can experience the same event — a failure, a loss — and live entirely different lives because of what their minds build from the same raw material.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Implication: Train the Thoughts",
                    blockquote = "Our life is what our thoughts make it.",
                    body = "If thoughts construct your life, then the most important work is not changing circumstances — it is examining and training thought. This is the Stoic project: not a passive philosophy of acceptance but an active practice of shaping the mind that shapes everything else.",
                    bullets = listOf(
                        InsightBullet("Where the leverage is", "If you want to improve your life, the highest leverage point is not external — it is the quality and direction of your thinking."),
                        InsightBullet("The daily practice", "Stoic morning reflection, journaling, and evening review are all practices of attending to thought — which is attending to the primary constructor of life.")
                    )
                )
            ),
            modernApplication = "Cognitive science confirms that emotional experience is largely constructed by the mind's interpretation of events rather than by the events themselves. This is not a philosophical position — it is an empirically verified account of how experience is generated. Marcus knew it by careful self-observation.",
            closing = "Change the thinking, and you change what is built from it.",
            reflectionPrompt = "What is your dominant thinking about the most difficult aspect of your current life? What life is that thinking constructing for you — and is it the life you would choose to be building?"
        ),

        // q056 — Marcus Aurelius
        "q056" to QuoteInsight(
            intro = "Marcus Aurelius gives a directive about motivation and recognition. Move forward when opportunity presents — but do not do it for the audience. The action should be its own complete justification. Looking around to see who noticed is both a distraction from the work and a transfer of its value from you to those watching.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Forward, Without Waiting",
                    blockquote = "Forward, as occasion offers.",
                    body = "When the opportunity to act — to help, to contribute, to do the right thing — presents itself, take it. Don't deliberate endlessly about whether conditions are ideal. Don't wait for a larger stage or a more significant moment. Act when occasion offers, which is to say: act now.",
                    bullets = listOf(
                        InsightBullet("Responsiveness", "Virtue, for Marcus, was responsive — it saw the moment and acted on it. The contemplative philosopher who sees but does not act has missed the point."),
                        InsightBullet("Occasion as enough", "The occasion offering is sufficient justification for the action. You do not need more than the opportunity and the capacity to respond to it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Without Seeking Recognition",
                    blockquote = "Never look round to see whether any shall note it.",
                    body = "The act done for recognition is a different act from the same act done without it. The first is commerce — virtue traded for approval. The second is virtue itself. Marcus practised the discipline of acting well without registering who was watching, which is the only way virtue becomes genuinely yours.",
                    bullets = listOf(
                        InsightBullet("The corruption of the gaze", "The moment you act for the audience, the action is no longer fully yours. It belongs partly to those whose approval you are seeking."),
                        InsightBullet("Anonymous virtue", "The highest form of virtue, for Marcus, was the kind that would be identical whether or not anyone was watching. That is the definition of genuine character.")
                    )
                )
            ),
            modernApplication = "Research on motivation shows that external validation as the primary driver of behaviour is associated with lower intrinsic satisfaction and greater fragility. The person who acts for recognition is dependent on its supply. The person who acts from values is self-sufficient.",
            closing = "The best act is the one that would look the same with no audience at all.",
            reflectionPrompt = "Think of a recent good action you took. How much of it was genuinely for its own sake — and how much was shaped by who might notice it? What does that ratio reveal?"
        ),

        // q057 — Marcus Aurelius
        "q057" to QuoteInsight(
            intro = "Marcus Aurelius makes an observation that sounds provocative but is actually precise: the goal of life is not majority membership but sanity. The majority can, and historically does, hold beliefs and engage in behaviours that a clear-eyed person would recognise as forms of collective madness. Independent judgment is not arrogance — it is the effort not to go mad in company.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Inadequacy of the Majority",
                    blockquote = "The object of life is not to be on the side of the majority...",
                    body = "The majority provides social comfort and reduced friction. It does not provide philosophical guidance. History is full of majorities that were wrong about important things — and of individuals who maintained independent judgment at significant personal cost. Marcus is asking: whose standard are you living by?",
                    bullets = listOf(
                        InsightBullet("Social proof's limits", "Popularity and correctness are unrelated. The majority standard shifts with fashion, fear, and incentive — it is not a reliable guide to what is actually good."),
                        InsightBullet("The comfort trap", "Conforming to the majority is comfortable. It is also a delegation of your judgment to a group that is not accountable for your life.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Goal: Sanity",
                    blockquote = "...but to escape finding oneself in the ranks of the insane.",
                    body = "The 'ranks of the insane' refers to those who have adopted the prevalent values without examination — who pursue what convention says is worth pursuing without asking whether it is actually worth their life. Sanity, in this sense, is maintained by independent evaluation: what do I actually believe, and why?",
                    bullets = listOf(
                        InsightBullet("Examined values", "The insane majority Marcus describes has not examined its values. The sane person has — and continues to."),
                        InsightBullet("Not misanthropy", "This is not contempt for people. It is a warning about the force of social pressure and the ease with which it substitutes for thought.")
                    )
                )
            ),
            modernApplication = "Conformity research — particularly Asch's famous experiments — demonstrates that even in situations with an objectively correct answer, the majority opinion exerts enormous pressure. The capacity for independent judgment under social pressure is among the most psychologically demanding — and most important — human capacities.",
            closing = "The unexamined life, lived in the comfort of the majority, is a form of madness dressed as normality.",
            reflectionPrompt = "In what areas of your life are you following majority convention without having examined whether that convention actually reflects your values? What would your independent assessment of those areas produce?"
        ),

        // q058 — Seneca
        "q058" to QuoteInsight(
            intro = "Seneca connects the fear of death directly to the failure to live fully. This is not merely poetic — it is structural: the person who holds death as their greatest fear will organise their entire life around avoiding it, which means avoiding everything that might bring them close to it — which means avoiding risk, depth, commitment, and full engagement.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Cost of Death-Fear",
                    blockquote = "The man who fears death will never do anything...",
                    body = "The fear of death is the most powerful fear available because it organises all other fears beneath it. If the worst outcome is non-existence, then any significant action — any action with real stakes — becomes potentially catastrophic. The death-fearing person retreats from everything that matters.",
                    bullets = listOf(
                        InsightBullet("The logic of retreat", "If death is the worst, then preservation becomes the priority. But preservation at any cost is a kind of living death — the sacrifice of life in order to extend it."),
                        InsightBullet("The safe life", "The safest life is also the most impoverished one. Safety and significance are in permanent tension.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Worth of a Living Man",
                    blockquote = "...worth of a man who is alive.",
                    body = "The standard Seneca sets is pointed: worth of a man who is alive. To be alive and to fully live are not the same thing. The person who restricts everything to maximise safety is biologically alive but philosophically absent — not yet living in the sense that matters.",
                    bullets = listOf(
                        InsightBullet("The two senses of alive", "Biological life is a condition. Philosophical life — fully engaged, taking genuine stakes — is an achievement. Seneca distinguishes them."),
                        InsightBullet("The Stoic relationship with death", "The Stoics did not ignore death — they thought about it constantly. But they thought about it as a clarifier rather than a constraint: death makes the life you have more precious, not more timid.")
                    )
                )
            ),
            modernApplication = "Terror management theory research shows that excessive death anxiety tends to push people toward rigid, conventional, defensively organised lives — the opposite of the rich, engaged, values-directed life. Processing mortality constructively — as Marcus and Seneca did — produces the opposite: greater engagement, not greater retreat.",
            closing = "The man who is afraid to die has already placed a ceiling on what his life can become.",
            reflectionPrompt = "Is the fear of failure, rejection, or loss — in any sense, physical or otherwise — limiting what you are willing to attempt? What would you do if those fears held less power?"
        ),

        // q059 — Seneca
        "q059" to QuoteInsight(
            intro = "In his letters to Lucilius, Seneca returned repeatedly to the question of ownership. Of all the things we call ours, none truly is — except time. This version of the observation is addressed directly to his friend, with the intimacy and urgency of one person telling another something they need to hear.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Dispossession",
                    blockquote = "Omnia, Lucili, aliena sunt — All things, Lucilius, belong to others...",
                    body = "Everything we hold — money, status, health, the goodwill of friends — is held temporarily and conditionally. Fortune gives and fortune takes. Seneca is not complaining about this; he is making a precise observation about the nature of possession. You are the custodian of these things, not their owner.",
                    bullets = listOf(
                        InsightBullet("Temporary custody", "Treat what you hold as a loan rather than a possession. The loan may be long, but it will eventually be called in."),
                        InsightBullet("The release", "When you hold things as temporary custodian rather than permanent owner, their loss, when it comes, is a return rather than a theft.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The One True Possession",
                    blockquote = "...tempus tantum nostrum est — time alone is ours.",
                    body = "Time is yours not because you can hold it — you cannot; it passes — but because the way you use it is entirely your choice. The hours of your life are the medium in which you construct everything that is genuinely yours: your character, your relationships, your work, the person you have become.",
                    bullets = listOf(
                        InsightBullet("The medium of life", "Everything of lasting value is made from time. It is not just one resource among many — it is the substrate from which all other value is drawn."),
                        InsightBullet("The urgency", "If time alone is yours, then spending it on what genuinely matters is the most important financial decision available to you.")
                    )
                )
            ),
            modernApplication = "Research on end-of-life regret consistently finds that people regret how they spent their time far more than how they spent their money. Time is non-renewable and non-delegable. The recognition that it is your primary — and essentially your only — real resource changes every priority calculation.",
            closing = "You are not time-poor. You are time-inattentive. They are different problems with different solutions.",
            reflectionPrompt = "If time is your only true possession, how well are you managing it? Where are you spending it that doesn't reflect what you actually value?"
        ),

        // q060 — Epictetus
        "q060" to QuoteInsight(
            intro = "Epictetus names one of the specific prices of genuine improvement: the willingness to appear foolish or stupid while you are in the process of becoming better. Most people are not willing to pay this price, which is why most people's improvement is modest and slow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Price of Growth",
                    blockquote = "If you want to improve, be content to be thought foolish and stupid.",
                    body = "Improvement in any domain requires a period of visible incompetence — the beginner's phase, the apprenticeship, the early attempts that don't yet meet the standard. During this phase, the person improving looks worse than the person who is not trying. Social judgment follows: they are thought foolish. Epictetus says: this must be accepted.",
                    bullets = listOf(
                        InsightBullet("The visibility problem", "Improvement is messy and public. The person who needs to look competent at every stage cannot afford to be a genuine beginner at anything new."),
                        InsightBullet("The growth edge paradox", "You can only improve at what you are currently bad at. Being bad at something publicly is therefore not a sign of failure — it is a sign of actual learning.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Content to Be Thought So",
                    blockquote = "...be content to be thought foolish and stupid.",
                    body = "'Content' is the demanding word. Not resigned, not indifferent — content. Genuinely at peace with the social judgment that accompanies visible incompetence. This requires a settled sense of purpose that is stronger than the need for immediate approval.",
                    bullets = listOf(
                        InsightBullet("Values over approval", "The person content to be thought foolish while improving has decided that becoming better matters more than appearing capable. This is a specific and powerful form of courage."),
                        InsightBullet("The long perspective", "In the short term, the non-improver looks more capable. In the long term, the person who paid the price of being thought foolish while learning arrives somewhere the approval-seeker never does.")
                    )
                )
            ),
            modernApplication = "Growth mindset research confirms that people who believe intelligence and ability are developable — and who are therefore willing to display effort and incompetence — consistently outperform those who prioritise looking smart over actually learning. Epictetus describes the internal condition that growth mindset requires.",
            closing = "The person who cannot afford to look foolish cannot afford to grow.",
            reflectionPrompt = "What would you learn or attempt if the fear of appearing foolish or incompetent were less powerful? What is that fear actually costing you?"
        ),

        // q061 — Marcus Aurelius
        "q061" to QuoteInsight(
            intro = "Marcus Aurelius, governing an empire and surrounded by constant external demands, recognised that the deepest resource available to him was not military, political, or intellectual — it was internal. Retreat into yourself is not withdrawal from life. It is the renewal that makes genuine life possible.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Inner Retreat",
                    blockquote = "Retire into yourself as much as you can.",
                    body = "Marcus elsewhere describes the mind as a property that offers what countryside or ocean retreats promise: peace, renewal, perspective. But unlike geographical retreat, the inner retreat is always available. You do not need to travel anywhere or achieve any external condition. You need only to turn inward.",
                    bullets = listOf(
                        InsightBullet("Accessible always", "The inner retreat costs nothing and requires no preparation. It is available in the middle of a crowded day, in the presence of chaos, in the hardest circumstances."),
                        InsightBullet("The quality of attention", "Retiring into yourself is not disengagement from the world — it is the renewal of the attention you bring to the world.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "As Much as You Can",
                    blockquote = "...as much as you can.",
                    body = "The qualification matters. Not total withdrawal — not the life of the hermit. As much as you can, within the life you actually live. Brief moments of inward return throughout the day accumulate into something significant: a person who knows themselves, who is not entirely at the mercy of external noise.",
                    bullets = listOf(
                        InsightBullet("Micro-retreats", "A few minutes of genuine inward attention is more renewing than hours of distracted external activity. The quality matters more than the duration."),
                        InsightBullet("The practice of solitude", "Even small daily practices of inner retreat — a morning moment of reflection, a quiet walk without input — build the capacity for the deeper returns when they are needed.")
                    )
                )
            ),
            modernApplication = "Research on attention restoration theory shows that even brief periods of directed inward attention — away from the demands of social and professional life — restore cognitive function and emotional regulation more effectively than many external interventions. Marcus's prescription is both philosophically grounded and neurologically sound.",
            closing = "The inner retreat is the only one that is always available and costs nothing to take.",
            reflectionPrompt = "When did you last spend time in genuine inward attention — not input, not activity, but quiet return to yourself? What practice would make that available to you daily?"
        ),

        // q062 — Marcus Aurelius
        "q062" to QuoteInsight(
            intro = "Marcus Aurelius makes a claim about cosmological self-knowledge: understanding what the world is — its nature, its structure, the principles by which it operates — is inseparable from understanding who you are. You are not separate from the world. You are part of it. To misunderstand the whole is to misunderstand your place within it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "World-Knowledge as Self-Knowledge",
                    blockquote = "He who does not know what the world is does not know where he is.",
                    body = "The Stoics held a cosmological view: the universe is a rational, interconnected whole — the Logos — and every rational being is a part of it. To understand this is not merely philosophical — it is practical. It tells you what you are, what you are part of, and therefore what your responsibilities and possibilities are.",
                    bullets = listOf(
                        InsightBullet("Part of a whole", "You cannot understand your nature or purpose in isolation. The part cannot be understood except in relation to the whole of which it is a part."),
                        InsightBullet("The Stoic cosmos", "The Stoics believed reason was the principle structuring reality itself. As rational beings, humans participate in that principle — which has implications for how to live.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Disoriented Person",
                    blockquote = "...does not know where he is.",
                    body = "Without understanding what kind of world this is — subject to change, governed by natural law, shared with other rational beings — a person acts as if they are permanent, isolated, and exempt from the conditions everyone else navigates. This is the source of much unnecessary suffering and many strategic errors.",
                    bullets = listOf(
                        InsightBullet("The realistic foundation", "Understanding the world as it is — impermanent, shared, rational — is the foundation of the Stoic's practical effectiveness."),
                        InsightBullet("Orientation as prerequisite", "Before navigating well, you must know where you actually are. Cosmological understanding is Marcus's version of orientation.")
                    )
                )
            ),
            modernApplication = "Placing yourself in accurate context — understanding the scale of the world, the nature of change, your actual position in the systems you inhabit — is consistently associated with better decision-making, greater equanimity about setbacks, and more realistic planning. Marcus's cosmological exercise produces practical benefits.",
            closing = "To know yourself, you must first know what kind of world you are inside of.",
            reflectionPrompt = "How often do you think about your life in its broader context — the scale of time, the nature of change, your connections to others? What shifts when you hold that larger view?"
        ),

        // q063 — Epictetus
        "q063" to QuoteInsight(
            intro = "Epictetus uses the Stoic metaphor of the actor to describe something important about duty and honour. In the ancient theatre, an actor played their part without choosing it — the role was assigned. Their honour lay entirely in playing it well. Life, Epictetus suggests, works the same way.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Assigned Role",
                    blockquote = "Act well your part...",
                    body = "You did not choose your starting circumstances, your native abilities, your era, or many of the roles you inhabit. But these unchosen roles are nevertheless yours. The Stoic question is not 'did I choose this role?' but 'am I playing it well?' The honour lies entirely in the quality of the performance, not in the size of the stage.",
                    bullets = listOf(
                        InsightBullet("The role is given", "You did not choose to be a parent, a child, a citizen, or a worker in this particular place and time. But these roles are yours, and they carry real responsibilities."),
                        InsightBullet("Quality is chosen", "Within any assigned role, the quality of the performance is entirely within your power. That is where your agency and your honour reside.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "There All the Honour Lies",
                    blockquote = "...there all the honour lies.",
                    body = "Not in the size of the role. Not in whether it is recognised. Not in whether it leads to a better role. The honour is in acting well your part, wherever that is, now. The great emperor and the slave both have a part to play. Playing it well is equally available to both.",
                    bullets = listOf(
                        InsightBullet("Democratised honour", "If honour lies in acting well one's part, it is available to everyone in every circumstance. It does not require a grand stage."),
                        InsightBullet("The small part played well", "More honour can be found in a modest role performed with full integrity than in a grand role performed carelessly or dishonestly.")
                    )
                )
            ),
            modernApplication = "Role theory in sociology confirms that individuals draw a significant portion of their identity and sense of worth from how they perform their social roles. People who perform their actual roles well — with integrity and full engagement — consistently report greater wellbeing than those who resent their roles or perform them poorly while aspiring to others.",
            closing = "The honour is not in the part you were given. It is in how completely you inhabit it.",
            reflectionPrompt = "Think of a role you inhabit right now — parent, colleague, friend, citizen. Are you acting it well? What would acting it better look like, practically, today?"
        ),

        // q064 — Seneca
        "q064" to QuoteInsight(
            intro = "Seneca makes a counterintuitive claim about value in friendship: the most valuable friend is not the most agreeable one, not the most loyal one, not even the wisest one — but the one who will tell you your faults. This kind of friendship is rare because it requires both courage from the friend and genuine humility from the person receiving it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Rare Friend",
                    blockquote = "There is nothing so well worth having as a friend who will boldly tell us our faults.",
                    body = "Most friendships are built partly on comfortable mutual validation. We tell each other what is going right, reinforce each other's self-image, and avoid the friction of honest critique. This is pleasant but limited. The friend who is willing to tell you something you don't want to hear is offering something of far greater value.",
                    bullets = listOf(
                        InsightBullet("The scarcity", "Friends willing to give honest critique are rare because the cost — risking the relationship — is real, and the benefit — their friend's growth — is delayed and uncertain."),
                        InsightBullet("The test of genuine care", "A friend who only tells you comfortable truths is, in some ways, serving themselves — they are preserving an easy relationship. The honest friend serves you, at personal cost.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Receiving It Well",
                    blockquote = "...who will boldly tell us our faults.",
                    body = "The value of this friend depends on your capacity to receive what they offer. An honest critique delivered to a person who becomes defensive, wounded, or hostile is wasted. The Stoic practices hearing critique as information rather than attack — which is the only stance that allows you to benefit from it.",
                    bullets = listOf(
                        InsightBullet("Information, not attack", "A friend pointing out a fault is not attacking you. They are offering data about a gap between your self-image and your actual impact."),
                        InsightBullet("The grateful response", "The Stoic ideal is to thank the person who reveals your faults rather than to defend against them. The fault revealed is a growth opportunity given.")
                    )
                )
            ),
            modernApplication = "Research on feedback and self-improvement consistently shows that people who seek out and genuinely process honest critique improve faster and make better decisions than those who avoid it. The friend Seneca describes is, functionally, an accelerant of development.",
            closing = "Flattery is easy to find. Honest friendship is rare and worth protecting.",
            reflectionPrompt = "Do you have a friend who will tell you your faults? And when they do, how do you receive it — as information to use, or as something to defend against?"
        ),

        // q065 — Seneca
        "q065" to QuoteInsight(
            intro = "Seneca issues one of the most urgent instructions in his letters: prepare as if life were ending, and then act without postponement. This is not pessimism — it is the practical prescription that follows from any honest reckoning with the fact that life is genuinely finite and the future is genuinely uncertain.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Preparation",
                    blockquote = "Let us prepare our minds as if we had come to the very end of life.",
                    body = "Preparing as if you were at the end of life means doing what the dying consistently say they wish they had done: telling people what they mean to you, doing the work that actually matters, releasing the resentments and distractions that absorbed time that could have gone elsewhere. It means acting from your actual values rather than from convenience.",
                    bullets = listOf(
                        InsightBullet("The end-of-life clarity", "At the end of life, priorities clarify dramatically. Most of what seemed urgent disappears. What remains is what actually matters. Seneca wants you to access that clarity now."),
                        InsightBullet("Mind preparation", "The preparation is mental — not literal organisation of affairs, but the internal shift that happens when you take seriously the finite and uncertain nature of your time.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Let Us Postpone Nothing",
                    blockquote = "Let us postpone nothing.",
                    body = "Having prepared the mind, the instruction is immediate: act. The apology you have been meaning to make, the work you have been deferring, the conversation you have been avoiding — all of it: postpone nothing. The preparation without the action is only contemplation. The action is the point.",
                    bullets = listOf(
                        InsightBullet("Urgency without panic", "Postponing nothing does not mean doing everything frantically. It means allowing the genuine urgency of a finite life to inform your choices about what to do, today."),
                        InsightBullet("The cost of deferral", "Every day you postpone what matters, you have spent a day of your actual life on something other than what you believe most important.")
                    )
                )
            ),
            modernApplication = "Palliative care research documents the enormous regret that comes with realising, at the end, that important things were endlessly deferred. Seneca's prescription does not require waiting for that moment — it asks you to access the clarity of that perspective while there is still time to act on it.",
            closing = "The end of life is coming. The question is whether it arrives to find you living or still preparing to.",
            reflectionPrompt = "What are you currently postponing that, at the end of your life, you would most regret not having done? What would it take to stop postponing it?"
        ),

        // q066 — Seneca
        "q066" to QuoteInsight(
            intro = "Seneca answers a question about progress with an answer that reframes what progress means. Not philosophical mastery, not public achievement, not conquest of any external goal — but something interior and far more demanding: learning to be a friend to yourself. This is a specific kind of progress, and Seneca names it as the most significant kind.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Question of Progress",
                    blockquote = "What progress, you ask, have I made?",
                    body = "The expected answer would list achievements: I have studied such texts, I have practised such disciplines, I have overcome such difficulties. Seneca declines to answer that way. He measures progress not in external accomplishments but in the quality of the relationship with himself.",
                    bullets = listOf(
                        InsightBullet("The internal metric", "External progress can be easily exaggerated, performed, or measured incorrectly. The internal quality of your relationship with yourself is harder to fake."),
                        InsightBullet("A different question", "Most people assess their progress by asking what they have done. Seneca assesses it by asking what he has become — specifically, what kind of inner companion he has learned to be.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Achievement",
                    blockquote = "I have begun to be a friend to myself.",
                    body = "'Begun' — still in process, not complete. Honest about where he is. And 'a friend to myself' — with all the precision of that phrase: honest, supportive, genuinely caring for his own interests rather than just his immediate wants, present in difficulty rather than abandoning.",
                    bullets = listOf(
                        InsightBullet("The ongoing project", "Self-friendship is not a state achieved once. Seneca says 'begun' — it is a practice, always in progress, always requiring renewal."),
                        InsightBullet("The foundation of everything else", "You cannot be a reliable friend to others if you are a harsh enemy to yourself. Self-friendship is not indulgence — it is the inner foundation from which genuine goodness toward others grows.")
                    )
                )
            ),
            modernApplication = "Self-compassion research establishes that a warm, honest, supportive relationship with oneself is associated with greater motivation, resilience, and kindness toward others. Seneca's self-friendship is not a soft consolation prize — it is the inner infrastructure for living well.",
            closing = "All other progress rests on this one: have you learned to be your own honest friend?",
            reflectionPrompt = "What is the quality of your inner relationship with yourself right now? Are you the kind of friend to yourself that you would value if the friendship were with someone else?"
        ),

        // q067 — Seneca
        "q067" to QuoteInsight(
            intro = "Seneca's instruction is a paradox resolved: as long as you live, learning how to live is the appropriate and necessary work. Not how to succeed, not how to accumulate, but how to live — the ongoing mastery of the art of existence itself, which is never finished and always available to be practised further.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Learning How to Live",
                    blockquote = "As long as you live, keep learning how to live.",
                    body = "The art of living — understanding what matters, what doesn't, how to meet difficulty, how to hold relationships, how to use time — is not learned once in youth and then applied thereafter. Every stage of life presents new challenges to which the previous learning is incomplete. The genuine student of living never graduates.",
                    bullets = listOf(
                        InsightBullet("The ongoing curriculum", "What counts as a good life at twenty is different from what counts as a good life at fifty. Each stage requires fresh learning from the experience that stage provides."),
                        InsightBullet("Theory vs. practice", "You can read about the good life extensively. But the actual learning — the embodied understanding — only comes from living, reflecting, and revising.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "As Long as You Live",
                    blockquote = "As long as you live...",
                    body = "There is no stage at which this learning is complete or its continuation unnecessary. Seneca was writing to Lucilius about his own ongoing philosophical development — not as a young student but as an elderly man. The instruction applies to the end.",
                    bullets = listOf(
                        InsightBullet("Against complacency", "The person who believes they have already learned how to live has closed the door on the most important education available."),
                        InsightBullet("The gift of ageing", "Each stage of life offers what previous stages could not: the wisdom of hindsight, the perspective of change, the deepening of experience. The learning gets richer, not more finished.")
                    )
                )
            ),
            modernApplication = "Research on lifelong learning and psychological wellbeing consistently shows that continued engagement with new challenges and genuine growth — intellectual, moral, and practical — is one of the strongest predictors of wellbeing in later life. The learning of how to live is not a youthful activity — it is the appropriate occupation of a full life.",
            closing = "The person who has finished learning how to live has stopped living in the only sense that matters.",
            reflectionPrompt = "What are you actively learning about how to live right now — not a skill or a subject, but the practice of existence itself? Where is your understanding of the good life still developing?"
        ),

        // q068 — Epictetus
        "q068" to QuoteInsight(
            intro = "Epictetus states a mathematical relationship that the Stoic life is built upon: the more you invest emotionally and practically in things you cannot control, the less actual control you have over your life. This is not just philosophical — it is a description of how dependence works.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Investment Problem",
                    blockquote = "The more we value things outside our control...",
                    body = "Valuing something means treating its presence or absence as significant to your wellbeing. When you value something outside your control — a relationship's outcome, a career result, others' opinions — you have made your wellbeing contingent on something you cannot govern. The contingency is the loss of control.",
                    bullets = listOf(
                        InsightBullet("Conditional wellbeing", "Every attachment to an uncontrollable thing is a condition placed on your own peace. The conditions multiply, and peace becomes increasingly unavailable."),
                        InsightBullet("The dependency trap", "Valuing external things creates dependency on their cooperation. The more dependencies you accumulate, the less stable your inner life becomes.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Inverse",
                    blockquote = "...the less control we have.",
                    body = "And by implication: the less you value what is outside your control — not the less you care about it, but the less you make your peace contingent on it — the more control you actually have. Control over your response, over your inner state, over who you are in the face of what happens.",
                    bullets = listOf(
                        InsightBullet("The positive version", "Invest your primary concern in what is within your power — your effort, your judgment, your character — and your wellbeing becomes yours to govern."),
                        InsightBullet("Disentanglement", "The Stoic practice is gradual disentanglement of your core wellbeing from external outcomes — not indifference, but the removal of existential dependence.")
                    )
                )
            ),
            modernApplication = "Research on locus of control confirms Epictetus's observation: people who locate their sense of efficacy and wellbeing in external outcomes — over which they have limited control — consistently report less resilience and satisfaction than those who locate it in their own responses and efforts.",
            closing = "Every external attachment is a small transfer of power from yourself to something you cannot govern.",
            reflectionPrompt = "What things outside your control are you currently valuing most — in the sense that their absence would most disturb your peace? What would happen if you loosened that attachment, even slightly?"
        ),

        // q069 — Epictetus
        "q069" to QuoteInsight(
            intro = "Epictetus states the core Stoic freedom with perfect economy: we cannot choose what happens to us, but we can always choose how we respond. This 'always' is the crucial word. Not 'usually' or 'in good circumstances' — always. Even in the worst situations, the power of response remains.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Unchosen Circumstances",
                    blockquote = "We cannot choose our external circumstances...",
                    body = "Much of life arrives without your consent: the family you were born into, the body you inhabit, the era you live in, the unexpected events that arrive without invitation. The Stoics did not pretend otherwise. They accepted that much of life's content is not chosen.",
                    bullets = listOf(
                        InsightBullet("The honest starting point", "Stoicism begins with a clear-eyed acceptance of what is not in your power. This is not resignation — it is the accurate starting point for effective action."),
                        InsightBullet("The unchosen is real", "External circumstances matter. They are not trivial. But their power over your life is always mediated by your response to them.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Chosen Response",
                    blockquote = "...but we can always choose how we respond to them.",
                    body = "'Always' — this is the Stoic bet. Even in prison, even in illness, even in loss, the capacity to choose how you meet what has happened remains. It may be the only thing that remains. But it is enough. Viktor Frankl, who was in Auschwitz, confirmed this from experience.",
                    bullets = listOf(
                        InsightBullet("The last freedom", "The response is the last freedom available to a person when everything else has been taken. Epictetus, who was enslaved, knew this firsthand."),
                        InsightBullet("A practice, not a talent", "The capacity to choose response wisely under pressure is developed through practice — through the many small moments of choosing response over reaction.")
                    )
                )
            ),
            modernApplication = "Logotherapy, developed by Viktor Frankl from his experience in Nazi concentration camps, is built on exactly this insight. The capacity to choose one's response to circumstances — including the worst imaginable — is real and is the foundation of human dignity and psychological survival.",
            closing = "Circumstances arrive uninvited. Your response to them is always yours to choose.",
            reflectionPrompt = "Think of a difficult circumstance in your life right now. You may not have chosen it — but how have you been responding to it? Is that the response you would choose if you chose it deliberately?"
        ),

        // q070 — Epictetus
        "q070" to QuoteInsight(
            intro = "Epictetus makes a precise identification: freedom is not a political or material condition — it is won by a specific inner action, the disregarding of what lies beyond your control. This is a demanding definition, but it is also an empowering one: freedom is available to everyone, in any circumstances, because it is an act of the will.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Only Worthy Goal",
                    blockquote = "Freedom is the only worthy goal in life.",
                    body = "Epictetus is provocative here. Not wealth, not health, not pleasure, not even virtue as a separate goal — freedom. But his definition of freedom is specific: it is the condition in which your fundamental wellbeing is not held hostage by anything outside your control. This is the highest form of independence available to a human being.",
                    bullets = listOf(
                        InsightBullet("Not political freedom", "The freedom Epictetus means is internal — the Stoic freedom of a mind that is genuinely its own. It is available to the enslaved person and unavailable to the emperor who is driven by appetites."),
                        InsightBullet("Why only worthy", "Other goals — wealth, success, recognition — are contingent on the cooperation of the world. Freedom, in Epictetus's sense, is unconditional. That is what makes it the only worthy goal.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How It Is Won",
                    blockquote = "It is won by disregarding things that lie beyond our control.",
                    body = "The mechanism is precise: freedom is won by withdrawing your attachment to outcomes you cannot govern. Not indifference — disregarding, in the Stoic sense, means not making your fundamental peace contingent on them. This is difficult. It is also completely within reach.",
                    bullets = listOf(
                        InsightBullet("Disregarding vs. ignoring", "Disregarding what is beyond your control does not mean being blind to it. It means your inner peace is not held in its hands."),
                        InsightBullet("The daily practice", "Each time you notice yourself making your peace contingent on an uncontrollable outcome, and choose to release that contingency, you are practising the winning of freedom.")
                    )
                )
            ),
            modernApplication = "Self-determination theory identifies autonomy — the experience of being the genuine author of your actions rather than controlled by external pressure — as one of the three fundamental human needs. Epictetus's freedom is the most radical form of autonomy: independence not just from coercion but from attachment to uncontrollable outcomes.",
            closing = "The free person is not the one without chains. It is the one whose peace no chain can reach.",
            reflectionPrompt = "What currently holds your peace hostage — what outcome, opinion, or circumstance beyond your control must go a certain way for you to feel okay? What would it feel like to disregard that hostage-holding?"
        ),

        // q071 — Seneca
        "q071" to QuoteInsight(
            intro = "Seneca holds up Cato the Younger as the Stoic exemplar — not because Cato won political contests (he lost them) but because he won the only ones that matter: the contest of character under the most extreme pressure, including the final and most difficult contest of all.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Living Under a Tyrant",
                    blockquote = "He showed that a brave man can live under a tyrant...",
                    body = "Cato lived through the final collapse of the Roman Republic and the rise of Julius Caesar's dominance. He consistently refused to compromise his principles, refused to flatter, and refused to accept what he believed was the destruction of legitimate government — at tremendous personal cost. Living with integrity under a tyrant requires a specific kind of courage.",
                    bullets = listOf(
                        InsightBullet("Integrity as resistance", "Cato's refusal to bend was not passive — it was active moral resistance. Each maintenance of principle under pressure was a victory."),
                        InsightBullet("The cost of principle", "Cato paid a real price for his integrity. The Stoic does not pretend principle is without cost — they count the cost and pay it anyway.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Harder Thing",
                    blockquote = "...and — which is harder — can die.",
                    body = "Seneca adds a comparison: living courageously is hard. Dying courageously is harder still. Cato chose death over submission, which Seneca frames not as defeat but as the ultimate expression of a life lived in alignment with its values. The manner of exit was consistent with the life.",
                    bullets = listOf(
                        InsightBullet("Death as statement", "For the Stoics, how one faces death reveals the quality of the life that preceded it. Cato's end was consistent with his beginning."),
                        InsightBullet("The ultimate freedom", "The Stoics held that the capacity to choose one's own exit — rather than submit to any tyranny — was the final expression of inner freedom. This was not a counsel of despair but of ultimate self-ownership.")
                    )
                )
            ),
            modernApplication = "Historical exemplars matter in moral psychology: seeing specific people who embodied virtues under extreme conditions makes those virtues feel real rather than merely theoretical. Cato functioned for Seneca as such an exemplar — a proof that the Stoic principles are liveable, not just thinkable.",
            closing = "Cato's life is not an antique story. It is a proof that integrity under pressure is possible.",
            reflectionPrompt = "Think of the person in your life — historical or contemporary — who most embodies integrity under pressure. What specific quality of theirs do you most want to develop?"
        ),

        // q072 — Cato
        "q072" to QuoteInsight(
            intro = "Cato the Younger's words carry the particular authority of a man who had every opportunity for military glory and chose to evaluate it differently. This is not indifference or cowardice — it is a deliberate reordering of what counts as winning.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Let Others Chase Glory",
                    blockquote = "Let him who wants glory fight...",
                    body = "Glory — public recognition, martial honour, the admiration of others — was among the highest values in Roman culture. Cato is declining to compete for it on those terms. He is not saying glory is worthless. He is saying his own peace and judgment matter more to him than whether the crowd awards him the prize.",
                    bullets = listOf(
                        InsightBullet("The choice of currency", "Every person chooses what they are competing for. Cato names his choice explicitly: not the glory that requires fighting for it, but something else."),
                        InsightBullet("The courage of declination", "Declining the dominant cultural prize — refusing to compete for what everyone else is competing for — requires a settled enough sense of one's own values to absorb the social cost.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Quiet Alternative",
                    blockquote = "I will sit quietly and rest my bones.",
                    body = "This is not resignation or defeat — it is the active choice of a different kind of life. The quietness Cato describes is not emptiness; it is the stillness of someone who has decided that their energy belongs elsewhere. The resting of bones is the Stoic economy: not spending what you have on what you don't actually want.",
                    bullets = listOf(
                        InsightBullet("Quiet as choice", "The decision to live quietly — to opt out of the striving, the competition, the performance — is a genuine decision that requires clarity about what you actually value."),
                        InsightBullet("The energy conservation", "Energy spent chasing glory externally is energy not available for the internal work that matters more.")
                    )
                )
            ),
            modernApplication = "Research on intrinsic versus extrinsic motivation consistently finds that people who pursue intrinsically valued goals — things they find genuinely meaningful — report greater wellbeing and lasting satisfaction than those who primarily pursue external recognition and status. Cato is describing the intrinsic life.",
            closing = "The most courageous thing is sometimes simply not to compete for what everyone else says matters.",
            reflectionPrompt = "What are you currently fighting for that is primarily about what others think rather than what you genuinely value? What would you do with that energy if you released the competition?"
        ),

        // q073 — Cato
        "q073" to QuoteInsight(
            intro = "Cato the Younger makes a preference that inverts the Roman hierarchy of status. Rome was the centre; a village was the periphery. To prefer the village is to prefer genuine excellence in a modest domain over distant second place in the grandest possible one. The principle behind this preference is durable.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "First in a Village",
                    blockquote = "I would rather be first in a village...",
                    body = "Being first in a village means genuinely excelling in your actual context — making a real and leading contribution to a community where you can be known, where your work can be seen and felt, and where your leadership is real rather than nominal.",
                    bullets = listOf(
                        InsightBullet("Real contribution", "In the village, your work has direct, visible, personal impact. The excellence is lived, not performed for a distant audience."),
                        InsightBullet("Genuine mastery", "Being first in a small domain because you have genuinely mastered it is worth more, in character terms, than second place in a vast domain you have only partially engaged.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Second in Rome",
                    blockquote = "...than second in Rome.",
                    body = "Second in Rome is proximity to greatness without possessing it. It is status without substance — the reflected glow of being near the centre without being the centre. For Cato, this arrangement trades genuine excellence for comfortable near-excellence, and he rejects the trade.",
                    bullets = listOf(
                        InsightBullet("Status vs. excellence", "Second in Rome may carry more prestige than first in a village. But prestige and excellence are different things."),
                        InsightBullet("The comparison trap", "Living in permanent comparison to those who are larger, better, or more powerful is a guaranteed path to inadequacy. The village offers a domain in which genuine excellence is possible.")
                    )
                )
            ),
            modernApplication = "Research on meaning and work finds that genuine mastery and direct impact in a specific domain produces more lasting satisfaction than proximity to power without real contribution. The 'big fish in a small pond' effect is well-documented: people who are relatively excellent in their actual context tend to have higher self-efficacy and motivation than those who are relatively mediocre in highly prestigious contexts.",
            closing = "Real excellence in your actual domain beats nominal proximity to someone else's.",
            reflectionPrompt = "In your current life, where are you genuinely first — genuinely contributing and excelling? And where are you second in Rome — close to something impressive but not really in your element? Which of those is worth more to you?"
        ),

        // q074 — Epictetus
        "q074" to QuoteInsight(
            intro = "This compressed insight from Epictetus states something fundamental about human endurance: the capacity to bear suffering is not primarily a physical or even a psychological phenomenon — it is a purposive one. The person who knows why they are enduring something can endure almost any how.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Why as Foundation",
                    blockquote = "He who has a why to live...",
                    body = "A why to live is not a reason to avoid death — it is a purpose that organises and gives meaning to one's life. It might be a person, a mission, a value, a responsibility. It might be simple or complex. But its presence or absence determines the available capacity for endurance more than almost anything else.",
                    bullets = listOf(
                        InsightBullet("Purpose as resource", "People with a clear sense of purpose navigate difficulty with more resilience than those without it — not because the difficulty is less, but because it can be framed in relation to something that matters."),
                        InsightBullet("The question beneath all questions", "When everything else is stripped away, the question 'why am I doing this?' is what remains. If you have a real answer, you have what you need.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Almost Any How",
                    blockquote = "...can bear almost any how.",
                    body = "Almost — not quite everything. The Stoics were not claiming invulnerability. But almost any how: suffering, deprivation, indignity, loss — all of these can be borne if they can be placed in the context of something worth the bearing. Without the why, the smallest how becomes unbearable.",
                    bullets = listOf(
                        InsightBullet("The suffering that makes sense", "Meaningful suffering is experienced differently from arbitrary suffering. The athlete's pain in training, the parent's sacrifice for a child — these are borne with resources unavailable to suffering without meaning."),
                        InsightBullet("Choosing the why", "Purpose is not always given. Sometimes it must be actively chosen, even constructed. But the choosing itself is within your power.")
                    )
                )
            ),
            modernApplication = "Viktor Frankl's logotherapy is built on this exact insight, documented from the extreme environment of concentration camps: those who retained a sense of purpose — a why — were more likely to survive than those who lost it. Purpose is not a luxury. It is a survival resource.",
            closing = "Find what is worth enduring for. Everything else follows from that.",
            reflectionPrompt = "What is your current why — the purpose that gives your endurance meaning? If the answer doesn't come quickly, that might be the most important question you could spend time with."
        ),

        // q075 — Epictetus
        "q075" to QuoteInsight(
            intro = "Epictetus makes a sharp point about the origin of obstacles: when the obstacle you encounter is your own — your own fear, your own avoidance, your own habit — no one else put it there. Recognising this is not self-blame. It is the recognition of agency: if you made it, you can unmake it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Self-Made Obstacle",
                    blockquote = "You have been imposed upon by nobody, when the obstacles you meet are your own.",
                    body = "It is easy and comfortable to locate obstacles in the world: the difficult circumstances, the unhelpful people, the poor luck. Sometimes these externals are genuinely present. But many of the most persistent obstacles in a person's life are internal — the habits of avoidance, the limiting beliefs, the self-imposed constraints that have been there so long they feel like the world.",
                    bullets = listOf(
                        InsightBullet("The invisible author", "The obstacles that most persistently block you are often ones you have authored — sometimes unconsciously, sometimes long ago — and then forgotten that you made."),
                        InsightBullet("The honesty required", "Acknowledging that an obstacle is your own is uncomfortable. It removes the comfort of an external enemy. But it also restores agency.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Implication: Reclaim Agency",
                    blockquote = "When the obstacles you meet are your own.",
                    body = "If you made the obstacle, you can examine it, question it, and ultimately choose whether to maintain it. This is not easy — deeply held patterns are not dissolved by a single insight. But the starting point is the recognition of authorship: this is mine, I made it, and therefore I can work with it.",
                    bullets = listOf(
                        InsightBullet("From victim to author", "The shift from 'something is blocking me' to 'I am blocking myself' is uncomfortable but empowering. The agent of the obstacle and the agent of the change are the same person."),
                        InsightBullet("The path through", "Self-made obstacles are, in principle, available to be changed. External obstacles may not be. This is why recognising which is which matters so much.")
                    )
                )
            ),
            modernApplication = "Cognitive behavioural therapy works largely by identifying the ways in which a person's own thoughts and habits are maintaining the conditions that cause them distress — not to blame the person, but to locate the leverage. If the obstacle is internal, the intervention is internal.",
            closing = "The most persistent obstacles are often self-authored. Which means the author can revise them.",
            reflectionPrompt = "What obstacle do you most frequently encounter in your life? Is it genuinely external, or is some part of it something you have been maintaining? What would happen if you looked at it honestly?"
        ),

        // q076 — Epictetus
        "q076" to QuoteInsight(
            intro = "Epictetus prescribes the most practically useful response to being offended: turn the mirror around. What you see in another person's fault — the irritation, the judgment, the sense of superiority — often illuminates something about your own character. This is not self-punishment; it is self-education.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trigger as Mirror",
                    blockquote = "When you are offended at any man's fault, turn to yourself...",
                    body = "The things that most offend us in others tend to reveal something about our own relationship with those qualities. The person who is offended by arrogance may be wrestling with their own. The person angered by dishonesty may have something to examine in their own relationship with truth. The fault seen in another is not random — it is a reflection.",
                    bullets = listOf(
                        InsightBullet("Projection and recognition", "We are most sensitive to faults we have some relationship with — either our own version of them, or the version of them that once hurt us. The sensitivity is informative."),
                        InsightBullet("Not excuse", "Recognising that your offense reveals something about you is not an excuse for the other person's fault. It is an additional layer of honest self-examination.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Study of Your Own Failings",
                    blockquote = "...and study your own failings.",
                    body = "Study — not condemn, not wallow, but look carefully at what is actually there. The failing might be the same as the one that offended you. It might be a different failing that the encounter has surfaced. Whatever it is, studying it is more productive than continuing to focus on the other person.",
                    bullets = listOf(
                        InsightBullet("The productive redirect", "Energy directed outward at another person's fault is, in most cases, less productive than energy directed inward at what the fault-response reveals."),
                        InsightBullet("Ongoing inventory", "The Stoics practised regular self-examination — daily review of their actions and responses. Each encounter with another's fault was an opportunity for that examination.")
                    )
                )
            ),
            modernApplication = "Psychological shadow work draws on the same observation: the qualities that trigger our strongest reactions in others often correspond to aspects of ourselves we have difficulty acknowledging. Turning the reaction into self-examination is both Stoic practice and sound depth psychology.",
            closing = "The fault you see most clearly in others is often the one that most needs your attention in yourself.",
            reflectionPrompt = "What specific fault in other people reliably offends you most? Now look honestly at your own behaviour: is there any version of that fault — however different in form — that lives in you too?"
        ),

        // q077 — Epictetus
        "q077" to QuoteInsight(
            intro = "Epictetus gives a practical technique for managing desire and attachment: before you pursue or become attached to anything, name clearly what kind of thing it is. Not what you want it to be — what it actually is. This deliberate act of accurate labelling is one of the Stoic's most effective tools against being deceived by impressions.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Instruction: Name It First",
                    blockquote = "With everything which entices you and is of use to you, or which you love, remember to say to yourself what sort of a thing it is.",
                    body = "The categories matter: things that entice, things that are useful, things you love. All three are sources of potential attachment. Epictetus does not say avoid them — he says, before you engage with them, name accurately what they are. A beautiful object is fragile. A relationship is mortal. Success is temporary.",
                    bullets = listOf(
                        InsightBullet("Accurate labelling", "The label 'a fragile, temporary, externally contingent thing' attached to the object of desire puts your relationship with it in honest context."),
                        InsightBullet("Before attachment, not after", "The technique works before the attachment forms, when it is easier to hold the thing in perspective. After deep attachment, accurate labelling is harder but still possible.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Protective Function",
                    blockquote = "...remember to say to yourself what sort of a thing it is.",
                    body = "Remembering what sort of thing it is — its nature, its fragility, its impermanence — is protective. Not protective against enjoyment, but against the specific suffering that comes from treating temporary things as permanent, fragile things as unbreakable, and contingent things as certain.",
                    bullets = listOf(
                        InsightBullet("Enjoy accurately", "The Stoic can enjoy the beautiful object, the good relationship, the success — while knowing its nature. The enjoyment is real; the illusion about its permanence is dissolved."),
                        InsightBullet("Grief prevention", "Much grief comes from the gap between what we believed something to be and what it turned out to be. Accurate labelling closes that gap in advance.")
                    )
                )
            ),
            modernApplication = "Cognitive defusion — a practice in acceptance and commitment therapy — involves creating psychological distance from thoughts and attachments by naming them clearly rather than being fused with them. Epictetus's technique is a first-century version of exactly this practice.",
            closing = "Know what a thing actually is, and you will know what your relationship with it should be.",
            reflectionPrompt = "Think of something you are currently very attached to or excited about. What sort of a thing is it, stated accurately — including its fragility and impermanence? Does that change your relationship with it?"
        ),

        // q078 — Seneca
        "q078" to QuoteInsight(
            intro = "Seneca draws a sharp distinction between two ways of inhabiting time: as part of an ordered whole, or as a series of disconnected moments. The difference is not merely about organisation — it is about whether a person is genuinely living toward something or simply moving through days.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Ordered Whole",
                    blockquote = "The good man orders his life as a whole.",
                    body = "Ordering a life as a whole means that individual decisions are made in relation to a considered direction — that today's choices are coherent with yesterday's and tomorrow's, that the life being lived is a single, purposeful entity rather than a collection of unconnected responses to immediate circumstances.",
                    bullets = listOf(
                        InsightBullet("The long frame", "The person who orders their life as a whole asks not just 'what should I do now?' but 'what kind of life am I building, and does this contribute to it?'"),
                        InsightBullet("Coherence over time", "A life ordered as a whole is recognisable across time: the values that show up in the small moments are the same ones that show up in the large ones.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Day-to-Day Life",
                    blockquote = "The bad man lives only from day to day.",
                    body = "Living only from day to day means responding to immediate circumstances without the organising framework of a longer intention. It is reactive rather than purposive — governed by what is urgent rather than what is important, by what appears rather than by what has been chosen.",
                    bullets = listOf(
                        InsightBullet("Reactive vs. purposive", "The day-to-day life accumulates experience without building anything coherent. Each day is complete in itself but unconnected to a larger direction."),
                        InsightBullet("The drift", "Without an ordering principle for the whole, the individual days drift. The sum of many individual days, lived without coherence, is not a life — it is a passage of time.")
                    )
                )
            ),
            modernApplication = "Research on life purpose consistently finds that people with a clear sense of where their life is heading — even if the path is uncertain — report greater wellbeing, resilience, and satisfaction than those who lack such a direction. Seneca's good man has something psychologists call 'purpose orientation.'",
            closing = "A life ordered as a whole is different in kind from a series of days. It is worth the ordering.",
            reflectionPrompt = "What is the ordering principle of your life — the intention or direction that makes individual days coherent parts of something larger? If you don't have a clear answer, that might be the most important question you could sit with."
        ),

        // q079 — Seneca
        "q079" to QuoteInsight(
            intro = "Seneca's Latin — omnia aliena sunt — is blunt to the point of discomfort. Everything. Not most things, not the things we think of as temporary, but everything. The Stoic confrontation with ownership is total, and it is designed to produce a specific kind of liberation.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Total Dispossession",
                    blockquote = "Omnia, Lucili, aliena sunt — Everything, Lucilius, belongs to others.",
                    body = "The address to Lucilius is intimate — Seneca is making this point person-to-person, as something his friend needs to hear and absorb. Everything you call yours is held temporarily. It was given by circumstances that can take it back. Your claim on it is real but provisional.",
                    bullets = listOf(
                        InsightBullet("Provisional possession", "You hold what you hold not as its owner but as its temporary custodian. The distinction is important — owners fight to keep what is theirs; custodians can release what is returned."),
                        InsightBullet("The freedom in this", "Knowing that what you hold is borrowed changes your relationship to losing it. Loss is not theft — it is return.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practical Implication",
                    blockquote = "Everything belongs to others.",
                    body = "If everything belongs to others, then clinging to what you hold is a category error — like a librarian weeping over books that must be returned. The library's books were never yours. They pass through you. The question is how well you used them while they were in your care.",
                    bullets = listOf(
                        InsightBullet("Use, not ownership", "Seneca's implication: the question is not what you own but what you do with what passes through you. The custodian is judged by stewardship, not by permanent possession."),
                        InsightBullet("Against grief for loss", "The Stoic practice of seeing possessions as borrowed is not designed to eliminate attachment — it is designed to frame loss as return rather than theft, which is the appropriate response.")
                    )
                )
            ),
            modernApplication = "Buddhist philosophy arrives at the same point through different reasoning. Modern research on materialism — the degree to which possessions are tied to identity and wellbeing — consistently finds that high materialism predicts lower wellbeing, particularly at moments of loss. Seneca's dispossession is protective.",
            closing = "You do not own what you hold. You are simply the current custodian of it. Be a good one.",
            reflectionPrompt = "Think of something you are holding tightly — a possession, a relationship, a status. What would change in how you relate to it if you thought of yourself as its custodian rather than its owner?"
        ),

        // q080 — Marcus Aurelius
        "q080" to QuoteInsight(
            intro = "Marcus Aurelius prescribes a daily practice that is both modest in scale and significant in its cumulative effect: every day, some action of benefit to others. Not a grand gesture, not a transformation of the world, but a consistent, daily offering of whatever is within your power to give.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Daily Commitment",
                    blockquote = "Carry out some action every day that is of benefit to others.",
                    body = "The daily frame matters. Not occasionally, not when you feel moved, not when the opportunity is significant enough — every day. Small, medium, or large, but present. The daily practice builds a habit that becomes a character trait: the person who acts for others' benefit as naturally as breathing.",
                    bullets = listOf(
                        InsightBullet("Accumulation", "One act of benefit per day is 365 per year. Across a lifetime, the cumulative impact of consistent daily acts is enormous — and so is the impact on the character of the person who performs them."),
                        InsightBullet("Some action", "Not a transformation, not a sacrifice — some action. Marcus sets a modest standard on purpose. The point is the consistency, not the scale.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Stoic Social Obligation",
                    blockquote = "...that is of benefit to others.",
                    body = "The Stoics held that human beings are naturally social — that we are made for cooperation, that the individual and the collective are deeply intertwined. Contributing to others is not charity; it is the expression of human nature properly understood. The daily act of benefit is living in accordance with that nature.",
                    bullets = listOf(
                        InsightBullet("Cooperation as nature", "Marcus elsewhere writes that we are made for each other. Daily contribution is not surplus virtue — it is the basic expression of being fully human."),
                        InsightBullet("The benefit to the actor", "Acting for others' benefit does not leave the actor unchanged. Research on prosocial behaviour consistently shows it increases the wellbeing of the person acting, not only the recipient.")
                    )
                )
            ),
            modernApplication = "Research on the psychology of giving consistently finds that performing acts of kindness or service — even small ones, even when motivated partly by self-interest — measurably increases the wellbeing of the person acting. Marcus's daily practice serves both the recipients and the practitioner.",
            closing = "The world is changed by daily acts, not only by dramatic ones. Begin with today.",
            reflectionPrompt = "What is one action you could take today — however small — that would genuinely benefit someone else? And what would it mean to make this question part of every day?"
        ),

        // q083 — Marcus Aurelius
        "q083" to QuoteInsight(
            intro = "Four words. Among the most compact expressions of Stoic social philosophy ever written. Marcus Aurelius, emperor of the known world, is reminding himself — and us — that individual wellbeing cannot be separated from collective wellbeing. We are not isolated atoms. We are nodes in a living system.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Metaphor of the Hive",
                    blockquote = "What harms the hive harms the bee.",
                    body = "A single bee cannot thrive in a dying hive. The hive's health is not separate from the bee's health — it is the precondition for it. Marcus uses this metaphor to argue for a natural, rational basis for ethics: caring for others is not charity or self-sacrifice. It is self-preservation understood clearly.",
                    bullets = listOf(
                        InsightBullet("The Stoic cosmos", "Marcus believed the universe was a single, rational, interconnected whole. Human society was its local expression."),
                        InsightBullet("Rationality as grounds for ethics", "For Marcus, harming others was irrational — not just wrong, but self-defeating at the deepest level.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Implication for How We Live",
                    blockquote = "What harms the hive...",
                    body = "We are inside a hive right now — a family, a team, a community, a civilisation. Choices that corrode trust, that exploit rather than contribute, that take without reciprocating — these harm the hive. And a harmed hive eventually cannot sustain the very bees who harmed it.",
                    bullets = listOf(
                        InsightBullet("On institutions", "Every institution — legal, civic, cultural — is a hive-wall holding shared life together. Cynicism and corruption weaken these walls for everyone."),
                        InsightBullet("On relationships", "A relationship is a small hive. What you do to it, you ultimately do to yourself.")
                    )
                )
            ),
            modernApplication = "The modern world celebrates individual achievement in ways the ancient world did not. This is not entirely wrong — individual freedom and dignity matter. But the Stoics understood something systems thinkers are rediscovering: individual and collective health are coupled. Climate, social trust, public health — these are hive problems. No single bee escapes a hive collapse.",
            closing = "You cannot harm the whole without, eventually, harming yourself.",
            reflectionPrompt = "In what \"hive\" — family, team, community — do you play a role? Are there ways your choices have harmed the hive, however small? What would it look like to strengthen it instead?"
        ),

        // q091 — Epictetus
        "q091" to QuoteInsight(
            intro = "This quote from the Stoic philosopher Epictetus is deceptively simple. At a glance, it sounds like fashion advice — but in true Stoic fashion, it is actually a profound meditation on integrity, self-awareness, and the relationship between our inner character and our outward presentation.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Priority of Self-Knowledge",
                    blockquote = "Know, first, who you are...",
                    body = "Before you take any action in the world — whether choosing a career, a partner, or even an outfit — you must understand your core nature. For Epictetus, \"who you are\" is not your job title or social status. It is your prohairesis: your moral character and faculty of choice.",
                    bullets = listOf(
                        InsightBullet("The internal vs. the external", "Your identity is not your role. It is your values, your choices, your character under pressure."),
                        InsightBullet("The foundation", "If you don't know your values, you will adorn yourself with the expectations of others — living a life that is essentially a costume.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Intentional Presentation",
                    blockquote = "...and then adorn yourself accordingly.",
                    body = "Once you have a firm grasp of your identity, your external choices should be a natural extension of that internal truth. Epictetus isn't saying \"don't wear nice things.\" He is saying your adornment — your behaviour, your speech, your lifestyle — should be an honest reflection of your soul.",
                    bullets = listOf(
                        InsightBullet("Authenticity over vanity", "True self-presentation is not performance. It is coherence between who you are and how you appear."),
                        InsightBullet("Congruency", "There should be no gap between the person you are in private and the person you present to the world.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Fragmented Living",
                rightHeader = "Stoic Integrity",
                rows = listOf(
                    "Adorning yourself to impress others." to "Adorning yourself to reflect your principles.",
                    "Seeking identity through external things." to "Finding identity within, then expressing it.",
                    "Being a \"chameleon\" to fit in." to "Being consistent regardless of the setting."
                )
            ),
            modernApplication = "In a world of social media filters and personal branding, this quote is more relevant than ever. We often do the opposite: we adorn ourselves first in hopes that the costume will eventually tell us who we are. Epictetus flips the script: character is the substance; the rest is just the presentation. If the character is solid, the adornment becomes easy and honest.",
            closing = "Don't let your possessions or your public image define you. Define yourself first through your virtues, and let everything else be the wrapping paper that matches the gift inside.",
            reflectionPrompt = "Is there an area of your life where your \"adornment\" — how you present yourself — doesn't quite match who you actually are? What would it take to close that gap?"
        ),

        // q121 — Seneca
        "q121" to QuoteInsight(
            intro = "Navigators once crossed oceans by fixing their gaze on a single star. Seneca's observation is equally simple and equally essential: without a destination, movement is just drift. All the favourable winds in the world cannot help a ship that doesn't know where it's going.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Sailing Metaphor",
                    blockquote = "If one does not know to which port one is sailing...",
                    body = "Seneca lived in a world of literal sailors navigating real seas. He uses the metaphor not as decoration but as precision: navigation requires a destination. Without it, you cannot interpret what the conditions mean — a northerly wind is a gift to the ship bound south and a hindrance to the ship bound north. The same wind. Two ships. One of them lost.",
                    bullets = listOf(
                        InsightBullet("The wind", "Circumstances, opportunities, resources — external things that can help or hinder."),
                        InsightBullet("The port", "Your telos: your purpose, your direction, your most fundamental intention.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "No Wind is Favorable",
                    blockquote = "...no wind is favorable.",
                    body = "This is not pessimism. It is a structural observation. Without a chosen direction, you cannot evaluate anything. Is a job offer good? Depends on where you're going. Is a relationship worth pursuing? Depends on what kind of life you're building. Clarity of purpose doesn't restrict you — it makes every choice interpretable.",
                    bullets = listOf(
                        InsightBullet("Decision-making", "Every hard decision becomes easier when you know your direction. You simply ask: does this take me toward the port?"),
                        InsightBullet("Regret prevention", "Most regret comes from drift, not from deliberate wrong turns.")
                    )
                )
            ),
            modernApplication = "The modern world offers an overwhelming abundance of options, opportunities, and directions. This is, paradoxically, a major source of paralysis and dissatisfaction. Research on goal-setting consistently shows that clarity of purpose — not the achievement of it, but the having of it — dramatically increases motivation and wellbeing. Seneca knew: the first step is not to work harder. It is to decide where you are going.",
            closing = "A life without direction is not freedom. It is drift wearing the mask of freedom.",
            reflectionPrompt = "If someone asked you right now what port you are sailing toward — what your life is fundamentally for — what would you say? If the answer doesn't come quickly, that might be worth sitting with."
        ),

        // q081 — Marcus Aurelius
        "q081" to QuoteInsight(
            intro = "This simple principle lies at the heart of Stoic ethics and directly opposes one of the most common human failures — treating people as instruments to be used. Marcus, a Roman Emperor with absolute power, wrote this as a reminder to himself as much as to us.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Human Being is Not a Tool",
                    blockquote = "Treat other people as ends in themselves, not as means to an end.",
                    body = "Every person possesses the same fundamental capacity you do: to reason, to choose, to pursue virtue. This is not obvious in a world of hierarchies and power dynamics. It would have been particularly unobvious to an emperor. But Marcus insists on it: the servant, the slave, the rival — each has an inner citadel that belongs only to them.",
                    bullets = listOf(
                        InsightBullet("An end in themselves", "Their life is not a chapter in your story. They are the authors of their own."),
                        InsightBullet("The consequence of forgetting", "If you treat people as means, you trap yourself in endless manipulation and are shocked when loyalty fails.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How to Actually Do This",
                    blockquote = "Treat other people as ends...",
                    body = "Theory is one thing; practice is another. What does it look like to treat someone as an end in themselves? It means considering their wellbeing and autonomy as real, as mattering. Respecting their choices even when they differ from what you want. Offering honesty instead of manipulation. Seeing work you do together as a shared pursuit, not as extraction.",
                    bullets = listOf(
                        InsightBullet("Respect", "Even (and especially) with people you have power over — this is your true test of character."),
                        InsightBullet("The deeper benefit", "Ironically, people treated as ends end up far more loyal and engaged than those treated as means.")
                    )
                )
            ),
            modernApplication = "This principle became the foundation of modern human rights and ethical philosophy. In practice, it means not manipulating colleagues, not using relationships for advancement, not extracting value from people and then discarding them. It means seeing the other person's autonomy as sacred, even when it costs you.",
            closing = "Every person you meet is not a character in your story. They are the protagonist of their own.",
            reflectionPrompt = "Think of a relationship where you have been treating someone as a means rather than an end. What would shift if you saw them primarily as pursuing their own good, their own growth?"
        ),

        // q082 — Marcus Aurelius
        "q082" to QuoteInsight(
            intro = "This is Marcus preparing himself for the day ahead — speaking to himself as a commanding general addresses troops before battle. It is a warning and a clarion call. Do not be shocked by human nature. Meet it with preparedness, courage, and compassion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Prepare Yourself by Acknowledging What Comes",
                    blockquote = "When you wake up in the morning, tell yourself: The people I deal with today will be meddling, ungrateful, arrogant, dishonest, jealous, and surly.",
                    body = "Marcus is not being pessimistic — he is being realistic. He knows history, human nature, and the court of Rome. He also knows that if you expect perfection and people fail to deliver it, you will spend the day angry. But if you expect them to be exactly what they are, you can meet them with preparation instead of disappointment.",
                    bullets = listOf(
                        InsightBullet("Premeditatio malorum", "Seneca and other Stoics practised imagining difficulties before they came — not to be gloomy, but to be ready."),
                        InsightBullet("The power of expectation", "Your frustration comes not from what people do, but from what you expected them not to do.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Response This Requires",
                    blockquote = "...than you have one crucial gift: you know their limits in advance.",
                    body = "Once you have acknowledged what human nature typically produces, you are free. You stop demanding that today's people be different from all of history. And with that shift, a surprising capacity opens: you can meet their flaws with compassion rather than indignation. They are showing up as they have been shaped to show up.",
                    bullets = listOf(
                        InsightBullet("No false hope", "This is not cynicism — it is the clarity that allows realistic strategy instead of naive shock."),
                        InsightBullet("Edge of compassion", "Understanding this, you become capable of patience with human weakness — including your own.")
                    )
                )
            ),
            modernApplication = "This practice maps to modern concepts like mental contrasting, negative visualisation, and defensive pessimism — all backed by research showing that people who practice realistic scenario planning perform better in crisis and report less frustration.",
            closing = "Expect the worst of human nature — so that when the actual human arrives, you can meet them with grace.",
            reflectionPrompt = "What frustrations are you carrying about people's behaviour? For each one—ask: was this realistic to expect something different? If they showed up exactly as you should have expected them to, what would that free up in you?"
        ),

        // q084 — Marcus Aurelius
        "q084" to QuoteInsight(
            intro = "This is a profound claim about the nature of concordance. Marcus suggests that inner harmony and harmony with the world are not separate problems to be solved independently—they are the same problem, approached from two directions.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Internal Coherence",
                    blockquote = "He who lives in harmony with himself...",
                    body = "To live in harmony with yourself means your desires align with your reason, your actions align with your values, and your judgments align with reality. It means you are not at war with yourself—not wanting one thing while chasing another, not believing one thing while acting on a different belief. This internal alignment is extraordinarily rare and extraordinarily powerful.",
                    bullets = listOf(
                        InsightBullet("When fragmented", "Most people live in internal conflict—knowing what matters, but spending time on what doesn't; wanting calm, but creating drama."),
                        InsightBullet("The prerequisite", "This internal harmony is the first achievement Stoic practice aims at")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "And Therefore, External Coherence",
                    blockquote = "...lives in harmony with the universe.",
                    body = "Marcus is making a remarkable claim: once you genuinely align with reason and reality *internally*, you find you are naturally aligned with how the universe actually works. You stop fighting against what is. You stop demanding that reality conform to your fantasies. You are in sync.",
                    bullets = listOf(
                        InsightBullet("Not magically", "This isn't that the universe rewards good people. It's that a person at peace internally has stopped resisting reality—and that is itself harmony with how things are."),
                        InsightBullet("The freedom", "You become adaptable, responsive, unreactive—precisely the posture that makes you resilient within reality as it is.")
                    )
                )
            ),
            modernApplication = "Wholeness psychology, systems thinking, and integration practices all converge on this insight: internal coherence produces external effectiveness. A person who knows what they believe and why acts with clarity that others respond to, perceive as real authority.",
            closing = "The person at war with themselves makes war with the world. The person at peace with themselves discovers the world is also making peace.",
            reflectionPrompt = "Where do you experience internal discord right now? Where are your actions not aligned with your deepest values, or your hopes conflicting with your judgments? What if resolving that one internal conflict would shift your entire relationship to what happens around you?"
        ),

        // q085 — Marcus Aurelius
        "q085" to QuoteInsight(
            intro = "Marcus uses the human body as an argument for human interconnection. Each part does its own job, yet the whole works because coordination is built in. He is suggesting we are likewise made for each other, not accidentally or optionally, but fundamentally.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Metaphor of the Body",
                    blockquote = "We are made for cooperation, like feet, like hands, like eyelids, like the rows of the upper and lower teeth.",
                    body = "These are not independent parts that *choose* to cooperate. Cooperation is not a request your eyelids make of your eye—it is built into what they are. A foot is not a self-sufficient unit that occasionally helps out the leg. A foot that refuses to work with the leg is a broken foot. The same is true of humans, Marcus argues.",
                    bullets = listOf(
                        InsightBullet("Not metaphorical", "This is not poetic—it is his claim about human fundamental nature."),
                        InsightBullet("Built in, not chosen", "Just as your immune system doesn't meet to vote on defending you, humans are constituted to work together.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What This Means for How You Act",
                    blockquote = "We are made for cooperation...",
                    body = "If cooperation is constitutive of what you are, then selfishness is not strength—it is acting against your own nature. A person refusing to cooperate is like an eye refusing to see. They might resist, but they are thereby malfunctioning, not asserting independence. Virtue, then, is not self-sacrifice—it is functioning as you are designed to function.",
                    bullets = listOf(
                        InsightBullet("Enlightened self-interest", "Cooperation is not altruism—it is the way your wellbeing actually works. You cannot flourish alone."),
                        InsightBullet("The paradox resolved", "By giving to the whole, you give to yourself. This is not noble—it is architecture.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "If We're Independent Atoms",
                rightHeader = "If We're Made for Cooperation",
                rows = listOf(
                    "Helping others is a virtue I choose." to "Cooperation is my nature I either express or deny.",
                    "Groups are useful tools I can leave." to "I am fundamentally part of the human body.",
                    "My good is separate from theirs." to "My good cannot be separated from the whole's good."
                )
            ),
            modernApplication = "This maps to modern evolutionary psychology: humans are profoundly cooperative creatures. We are weaker and slower than most predators. Our survival evolved through cooperation, and our neurobiology remains wired for it. The research on loneliness, social isolation, and adversarial isolation consistently shows: we flourish together or we suffer apart.",
            closing = "Isolation is not freedom. It is amputation.",
            reflectionPrompt = "In what area of your life are you acting as though you must be independent—refusing help, refusing to contribute to something larger? What if that resistance is acting against your own nature?"
        ),

        // q086 — Marcus Aurelius
        "q086" to QuoteInsight(
            intro = "This cryptic line points to a profound truth about self-knowledge: you cannot know yourself isolated from context. Understanding who you are requires understanding what you are—and that requires understanding the world you are part of.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The World as Mirror",
                    blockquote = "He who does not know what the world is does not know who he is.",
                    body = "Your confusion about yourself, Marcus suggests, often stems from being unclear about the conditions you exist in. If you think the world is a machine set up to reward you, and you are thereby special, you will have a delusional self-image. If you think the world is a test of virtue, your self-image shifts entirely. The world *is* interpretive—but once you interpret it accurately, you see yourself more clearly.",
                    bullets = listOf(
                        InsightBullet("Cosmology determines psychology", "How you think reality works directly generates who you think you are."),
                        InsightBullet("The common delusion", "Most people misunderstand the world—and therefore misunderstand themselves as well.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Kind of World Is This?",
                    blockquote = "...does not know who he is.",
                    body = "The Stoic understanding: the world is a place where virtue is possible and virtue alone is good. Your role is not central, not specially treated. You are a rational being within a rational cosmos, subject to natural law like everything else. This sounds diminishing—but it is liberating. You are not playing a special game with special rules. You are part of something coherent. That means you can align with it. That is your freedom.",
                    bullets = listOf(
                        InsightBullet("Realism about position", "You are not the center. And that is exactly what makes sense of your life."),
                        InsightBullet("Self-knowledge through context", "Once you know what the world is, you know what you are in it: a participant, not an exception.")
                    )
                )
            ),
            modernApplication = "This is the insight that connects worldview to psychology. How you interpret reality (the world is fair / unfair / random / meaningful) directly shapes your sense of self-efficacy and identity. Therapy often works by clarifying the distorted cosmology that was generating a distorted self-image.",
            closing = "You cannot know yourself truly while you are confused about what you are part of.",
            reflectionPrompt = "What is your implicit belief about what kind of world this is? Is it rigged against you? Against everyone? Set up to reward goodness? How does that belief shape how you see yourself?"
        ),

        // q087 — Marcus Aurelius
        "q087" to QuoteInsight(
            intro = "This appears twice in the Meditations, and for good reason—Marcus is reminding himself of the fundamental commitment that holds Stoicism together. It is a simple rule with inexhaustible implications.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Criterion for Action",
                    blockquote = "If it is not right, do not do it...",
                    body = "Rightness as the filter. Not profitability, not popularity, not success-likelihood, not comfort. Marcus is drawing a bright line: no matter what advantage a wrong action might bring, it is disqualified automatically. You do not even get to weigh it. This is how you know you are serious about virtue—not in the reflection, but in what you refuse to do.",
                    bullets = listOf(
                        InsightBullet("The automatic refusal", "You don't debate whether to do an unright thing—you refuse it instantly."),
                        InsightBullet("The test of whether you believe", "If you continue to do unright things 'just this once,' you don't actually believe this principle.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Criterion for Speech",
                    blockquote = "...if it is not true, do not say it.",
                    body = "The Stoics understood: speech is the tool of your character. What you speak reveals and reinforces what you believe about rightness, about others, about truth. Speaking falsity (even 'helpful' falsity, even 'kind' falsity) corrupts both the listener and yourself. This is why Marcus is explicit: not just 'don't say obviously harmful lies,' but truthfulness as a standard.",
                    bullets = listOf(
                        InsightBullet("Kindness cannot override truth", "A comforting lie is still a lie—and you are training yourself to believe it is acceptable."),
                        InsightBullet("The integrity of speech", "Your words either align with reality or they don't. If you treat that as optional, everything becomes optional.")
                    )
                )
            ),
            modernApplication = "Integrity—meaning wholeness, where what you do and what you believe are aligned—is both a moral achievement and a psychological one. Research shows people with high integrity report less stress, clearer decision-making, and stronger self-trust. The person constantly compromising their principles is in a state of permanent conflict.",
            closing = "Your actions and your words are the tools by which you build yourself. Use them to build the person you want to be, or they will build someone else.",
            reflectionPrompt = "What is something you know is not right or not true that you have been doing or saying anyway? It might be small. It might feel justified. But if you stopped—what would shift?"
        ),

        // q088 — Marcus Aurelius
        "q088" to QuoteInsight(
            intro = "Marcus warns against escalating punishment beyond what is needed to correct. This is not weakness—it is precision. And it reveals a mature understanding of what justice actually is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Function of Consequences",
                    blockquote = "Do not indulge in anger or punishment more than is needful.",
                    body = "When someone wrongs you or violates a boundary, a response is necessary. But Marcus is pointing out that we almost always exceed that necessity. We indulge the anger. We extract extra punishment as payment for the hurt we felt. We make them suffer *more* than would be required to correct the behaviour. This, Marcus suggests, is not justice—it is us getting revenge dressed in virtue's clothes.",
                    bullets = listOf(
                        InsightBullet("Anger as fuel for excess", "Anger's job is to alert you and energise a response. Beyond that, it is just burning."),
                        InsightBullet("The indulgence", "What makes it an indulgence? It feels good to punish. That feeling is your clue that you are doing too much.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Is \"Needful\" Actually Means",
                    blockquote = "...more than is needful.",
                    body = "Needful punishment has a purpose: to communicate clearly that crossing this boundary will not work. It prevents repetition. But punishment beyond that is noise. It teaches nothing except resentment. A Stoic responds with the minimum force required to be effective. This is not kindness. It is precision. It is the surgeon's cut, not the madman's slash.",
                    bullets = listOf(
                        InsightBullet("Effectiveness over indulgence", "The goal is correction, not satisfaction. This requires calculation, not feeling."),
                        InsightBullet("Character in restraint", "Anyone can explode when wronged. The question is: can you maintain your reason while enforcing consequences?")
                    )
                )
            ),
            modernApplication = "Modern neuroscience shows us why Marcus's warning is crucial: the limbic system (emotion) hijacks the cortex (reason) during anger, and consequent punishments often far exceed what changed the situation. Restorative justice research shows that measured, proportional responses to wrongdoing are actually more effective at preventing recurrence than severe ones.",
            closing = "Justice is not the expression of your hurt. It is the minimum required to make things right.",
            reflectionPrompt = "The last time you punished someone—a child, a colleague, a friend—did you use the minimum force required, or did you indulge your anger? What would have changed if you had shown only what was necessary?"
        ),

        // q089 — Marcus Aurelius
        "q089" to QuoteInsight(
            intro = "This principle seems obvious—of course don't break your promise for profit. But Marcus knew the places where principle gets quietly forgotten, and profit whispers that this time, just this time, is different.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Promises Are the Skeleton of Trust",
                    blockquote = "Never value anything as profitable to yourself which will compel you to break your promise.",
                    body = "A promise is a commitment you make with your word. When you break it for gain, you signal to yourself and others: I am for sale. My commitment means nothing. My word is just a tool I discard when convenient. It is a small death of character—and it is irreversible in a subtle way. The person you become who breaks promises for profit is different from the person who wouldn't.",
                    bullets = listOf(
                        InsightBullet("The boundary", "This is the line Marcus draws as non-negotiable. Profit can motivate compromise in other areas—but not broken promises."),
                        InsightBullet("Why it matters", "Promises are the technological foundation of human cooperation. Break them casually, and you undermine the possibility of trust itself.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Cost of Keeping It",
                    blockquote = "...which will compel you to break your promise.",
                    body = "Notice Marcus says compel—suggesting that money, opportunity, advantage can all feel like they *force* you to break promises. But this is his point: they don't. You always have a choice. The Stoic sees through that seduction. Yes, breaking the promise might bring profit. But it brings something else: you become a person who breaks promises. That is a worse loss.",
                    bullets = listOf(
                        InsightBullet("Character as currency", "Your integrity is worth more than the profit you'd gain by losing it."),
                        InsightBullet("The clarity of refusal", "Sometimes the answer is simply: I will lose the money, not my word.")
                    )
                )
            ),
            modernApplication = "This connects to research on identity-based decision-making: when people see themselves as 'the kind of person who keeps promises,' they are far more likely to actually keep them. It also connects to reputation research: a reputation for trustworthiness is more valuable long-term than any single gain from breaking trust.",
            closing = "Every promise kept builds your character. Every broken promise, no matter the profit, diminishes it.",
            reflectionPrompt = "When was the last time you were tempted to break a promise because of opportunity or profit? Whether you yielded or refused—what did you learn about yourself?"
        ),

        // q090 — Epictetus
        "q090" to QuoteInsight(
            intro = "This is a striking inversion: to be offended is to be inferior. Epictetus turns the usual response on its head—shame does not belong to the person who is wronged, but to the person who wrongs.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Wisdom in Restraint",
                    blockquote = "He who offends you in some way is your superior in wisdom, inferior in vice.",
                    body = "The person who maintains their composure when offended shows wisdom. The person who loses composure in response shows they have been mastered by circumstance. But here is the flip: the person doing the offending is superior in capability (they achieved their effect), *inferior* in having used that capability toward vice. They have more raw power, less moral power.",
                    bullets = listOf(
                        InsightBullet("Reframing power", "The person who offends you is stronger in one sense (they affected you) and weaker in another (they acted badly)."),
                        InsightBullet("Your choice remains", "Whether you are offended—whether you take the bait—is up to you.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Liberation",
                    blockquote = "...is your superior in wisdom, inferior in vice.",
                    body = "If you grant them power over your emotions, you are admitting they have wisdom you don't—the wisdom to master themselves. But the fact that they act viciously shows they lack that wisdom. Epictetus is pointing out the paradox: the person who offended you has demonstrated their weakness to you. They have no actual power except what you grant by being upset.",
                    bullets = listOf(
                        InsightBullet("The test", "Someone offends you. Your calmness in return shows their words to be powerless."),
                        InsightBullet("Dignity is not granted by others", "It is maintained by your refusal to surrender your reason to their provocations.")
                    )
                )
            ),
            modernApplication = "This maps to emotional regulation research: people who respond calmly to provocation show evidence of greater executive function and wisdom. They also model that response for others (mirror neurons), subtly shifting cultural expectations. The person taking offense teaches everyone around them that offense works as a strategy.",
            closing = "The person who offends you has shown you their weakness. Do not teach them it works by granting them its effect.",
            reflectionPrompt = "Who has recently offended you? If you met their offense with your composure instead of your reaction, what would that communicate—to them, to yourself, to anyone observing?"
        ),

        // q092 — Epictetus
        "q092" to QuoteInsight(
            intro = "This short statement from Epictetus carries the weight of liberation. You have been given yourself by the universe—your mind, your reason, your capacity to choose. That is the trust. What will you do with it?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Gift You Have Custody Of",
                    blockquote = "God hath entrusted me with myself.",
                    body = "Epictetus uses the sacred language of trust deliberately. You were not given a life to waste. You were given yourself—the capacity to reason, judge, choose, and act—as a trust. Someone trusted you with this. Not to become famous. Not to accumulate. But to steward it well. To use it as an instrument of virtue and reason.",
                    bullets = listOf(
                        InsightBullet("Custodian, not owner", "You don't own your mind—you are responsible for it."),
                        InsightBullet("The obligation", "This trust is not optional. You are already trusted. The question is: will you honor it?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Honoring That Trust Involves",
                    blockquote = "...entrusted me with myself.",
                    body = "If you have been trusted with yourself, then how you use your mind matters immensely. Squandering it in distraction, in vice, in slavery to your appetites—this is a betrayal of trust. Using it to reason clearly, to choose well, to understand reality and act virtuously—this honors the trust. The Stoic sees this as the highest responsibility.",
                    bullets = listOf(
                        InsightBullet("Accountability", "You cannot blame circumstances for how you steward your mind. That is entirely yours."),
                        InsightBullet("Dignity through stewardship", "You are not important because of status or power. You are important because you have been trusted with yourself.")
                    )
                )
            ),
            modernApplication = "This connects to the concept of existential responsibility: you are the author of your life, and that is simultaneously a radical freedom and a total responsibility. It manifests in the difference between people who treat their attention, their time, their mental space as sacred versus those who treat it as infinitely expendable.",
            closing = "You have been trusted with yourself. That is not a privilege—it is an obligation. How will you keep that trust?",
            reflectionPrompt = "If your mind had been entrusted to you, and you had to report back on how you stewarded it, what would you say? Are you using it as it was meant to be used?"
        ),

        // q093 — Epictetus
        "q093" to QuoteInsight(
            intro = "This reframing is one of the most practical Stoic techniques for managing loss and grief. Instead of 'I have lost something,' Epictetus suggests: 'I have returned it.' To whom? To the universe. It was never yours to begin with—you merely had its use for a time.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Possession as Illusion",
                    blockquote = "Never say of anything 'I have lost it'...",
                    body = "When you say 'I have lost something,' you are implying you owned it. But nothing belongs to you permanently. Your health, your loved ones, your reputation, your life—all are temporary loans. The confusion that leads to suffering is thinking you ever owned them. Once you see that you didn't own them, the grief shifts.",
                    bullets = listOf(
                        InsightBullet("Impermanence is the law", "Everything that exists is temporary. Fighting this fact is fighting nature itself."),
                        InsightBullet("The comfort in reality", "Once you accept that you never owned it, you cannot lose it. You can only return it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Art of Returning",
                    blockquote = "...but say 'I have returned it.'",
                    body = "This is not resignation or cold detachment. It is clarity about what was yours to keep (your reaction, your character response to the loss) and what never was (control over whether it stays). You had the use of it while you could. Now you have the privilege of releasing it with grace. This is not loss—this is returning a borrowed thing when the loan is up.",
                    bullets = listOf(
                        InsightBullet("Gratitude for the loan", "Instead of grieving what's gone, be grateful for what you had."),
                        InsightBullet("The practice", "When facing loss, deliberately say: 'I am returning this now. I had it for a while. That was a gift.'")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Loss Mindset",
                rightHeader = "Return Mindset",
                rows = listOf(
                    "This was mine and now it's taken." to "This was loaned to me and now I return it.",
                    "I should have kept it forever." to "I am grateful I had it at all.",
                    "Unfair that it's gone." to "Natural that all things end."
                )
            ),
            modernApplication = "This practice is psychologically similar to what grief researchers call acceptance—the shift from 'this should not have happened' to 'this did happen; now I continue.' It shortens the duration of intense suffering and accelerates meaning-making.",
            closing = "Everything you love is a loan. Treasure it while you have it, then release it freely when the time comes.",
            reflectionPrompt = "What are you grieving or fearing to lose? If it is a borrowed thing—and it is—what changes when you shift from 'I will lose this' to 'someday I will return this'?"
        ),

        // q094 — Epictetus
        "q094" to QuoteInsight(
            intro = "This is Epictetus's formula for tranquility. It is not that things will go well—it is that your relationship to how things go will be settled. That settlement is available now, regardless of what happens.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Futile Struggle",
                    blockquote = "Seek not that the things which happen should happen as you wish...",
                    body = "You spend enormous energy trying to make the world conform to your preferences. You negotiate with reality. You hope. You strategise. None of it changes the fundamental structure: you don't control what happens. Epictetus sees this as the root of most suffering—not the events themselves, but the energy spent demanding that events be different.",
                    bullets = listOf(
                        InsightBullet("The leverage you actually have", "You can plan, work, hope—all good. But at no point do you control the outcome. Acknowledging this is the first step to peace."),
                        InsightBullet("The exhaustion", "Constant resistance to what is exhales you. A tranquil flow becomes impossible because you are at war with reality.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Shift to Peace",
                    blockquote = "...but wish the things which happen to be as they are, and you will have a tranquil flow of life.",
                    body = "Epictetus is not asking you to pretend bad things don't hurt. He is asking you to stop resisting their existence once they have occurred. Once something has happened, it is no longer a matter of preference—it is fact. To have peace, stop wishing facts were different. Instead, wish them to be exactly what they have become. This is not acceptance of injustice; it is acceptance of what happened, and then deciding what to do about it.",
                    bullets = listOf(
                        InsightBullet("Peace is available now", "Not after things improve—now, through this shift in relationship to them."),
                        InsightBullet("Then act", "Once you are not resisting reality, you can respond to it clearly.")
                    )
                )
            ),
            modernApplication = "Acceptance and Commitment Therapy (ACT) operates on this exact principle: stop struggling against what has happened, accept it as reality, and then commit to effective action. The research shows this produces both better psychological outcomes and better real-world results.",
            closing = "Tranquility comes not from circumstances being perfect, but from your relationship to circumstances being settled.",
            reflectionPrompt = "What are you still wishing were different—some event that already happened, some reality you cannot change? What would peace feel like if you stopped resisting that fact?"
        ),

        // q095 — Epictetus
        "q095" to QuoteInsight(
            intro = "This is Epictetus asking: what would it mean to die well? And his answer is clear—not in comfort, not in fame, but in the middle of useful work. This frames life itself as the opportunity to be found doing something that matters.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "How Would You Like to Be Found?",
                    blockquote = "What wouldst thou be found doing when overtaken by death?",
                    body = "Epictetus is asking the deepest question: what would need to be true of how you spent your time for you to be content to die today? It cuts through all the trivial pursuits. It separates what you claim matters from what you actually spend time on. Most people would not want to be found arguing online, scrolling endlessly, or trapped in pettiness. But that is what death might overtake them doing.",
                    bullets = listOf(
                        InsightBullet("Clarity through mortality", "This question contains its own answer. Whatever you would regret being found doing—stop doing that now."),
                        InsightBullet("It's not morbid", "It's the deepest clarity available about how to spend your finite time.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Answer: Useful Work",
                    blockquote = "I would have it be some work of humanity, of general utility.",
                    body = "Epictetus's answer is not mystical achievement or peak experience. It is simply: engaged in something useful to others. Work that matters. Work that serves. This is what he would want to be found doing. And not just at the moment of death—this is what deserves your time now. Your life is made of the moments you are spending. Make them count.",
                    bullets = listOf(
                        InsightBullet("Utility, not grandeur", "It doesn't have to be world-changing to matter. Any honest work that helps is dignified."),
                        InsightBullet("The life worth living", "A life spent in work of general utility is already, in every moment of it, a life well-lived.")
                    )
                )
            ),
            modernApplication = "Research on meaning and wellbeing shows that people who believe their work matters—that it contributes something useful—report significantly higher life satisfaction, even when the work is difficult or poorly compensated. Meaning matters more to wellbeing than comfort.",
            closing = "The way to live well is to be the kind of person who would be content to die doing what you are doing right now.",
            reflectionPrompt = "If death came today, would you be content being found doing what you spent your time on recently? If not—what needs to change about how you spend your days?"
        ),

        // q096 — Seneca
        "q096" to QuoteInsight(
            intro = "This short line contains a radical reframing: your neighbour's good is not separate from yours. They are not a competitor in a zero-sum game. Their flourishing is your flourishing. This is Seneca describing the Stoic understanding of human nature.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Illusion of Separation",
                    blockquote = "Regard your neighbour's good as your own good.",
                    body = "Most people operate from a premise of scarcity: if they win, I lose. If they flourish, my relative standing diminishes. This generates competition, envy, and a constant low-level conflict. But Seneca is proposing something different: their flourishing is not my loss. It is my gain. Why? Because we are part of the same human community. Their wellbeing improves the whole; the whole includes me.",
                    bullets = listOf(
                        InsightBullet("Not altruism", "This is not asking you to sacrifice yourself. It's pointing out that your good and theirs are connected."),
                        InsightBullet("The reality of interdependence", "You do not flourish in a community that suffers. You suffer with it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practice",
                    blockquote = "...as your own good.",
                    body = "To regard their good as your own means: when they succeed, something in you relaxes. When they suffer, it legitimately concerns you. Not as a performance—genuinely. This shift changes how you move through the world. You stop expending energy envying others and start noticing how their flourishing contributes to yours. It makes you a different kind of actor in the world.",
                    bullets = listOf(
                        InsightBullet("The test", "Next time someone near you achieves something—can you feel genuinely glad, or is envy your first response?"),
                        InsightBullet("The expansion", "Beginning to regard their good as your own expands who you are and what matters to you.")
                    )
                )
            ),
            modernApplication = "Mirror neurons, prosocial motivation research, and studies on community wellbeing all support this: humans are genuinely connected. Communities where people regard each other's good as their own have better health outcomes, lower crime, and higher life satisfaction across the board.",
            closing = "Your neighbour's good is not the opposite of yours. It is part of yours.",
            reflectionPrompt = "Is there someone whose success usually triggers envy in you? What would shift if you genuinely regarded their good as your own? Not as a pretense, but actually?"
        ),

        // q097 — Seneca
        "q097" to QuoteInsight(
            intro = "Seneca uses the body as metaphor again: you are a cell in a larger organism. The organism's health is your health. And just as a cell cannot hoard its resources while the body suffers, neither can you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Integrity of the Whole",
                    blockquote = "We are all one body...",
                    body = "This is not poetic language. It is Seneca's claim about the actual structure of human community. Just as your hand cannot be healthy while your heart is dying, you cannot be flourishing while those around you are suffering. The pretense that you can extract wellbeing from a suffering whole is a delusion. You *are* part of the whole. Its suffering is yours.",
                    bullets = listOf(
                        InsightBullet("Not optional connection", "You don't choose to be part of the body. You are. The question is how you respond to that."),
                        InsightBullet("The logic", "If you are part of the body, then the body's illness is literally your illness.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Mutual Obligation",
                    blockquote = "...to preserve the whole as you preserve the part.",
                    body = "You naturally preserve your own part (you don't cut off your fingers). Seneca is saying: preserve the whole *with that same instinct*. The difference between enlightened self-interest and petty selfishness is that the first sees itself as part of something larger and acts accordingly. You preserve the whole not from nobility—from recognition that your preservation depends on it.",
                    bullets = listOf(
                        InsightBullet("Self-preservation correctly understood", "Your own good is accomplished through service to the whole, not at its expense."),
                        InsightBullet("The alignment", "This is not a sacrifice—it's recognizing what actually serves you.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Illusion of Separation",
                rightHeader = "Recognition of Unity",
                rows = listOf(
                    "I must protect my interests against others." to "Protecting the whole protects me.",
                    "My wellbeing is separate from theirs." to "My wellbeing is inseparable from theirs.",
                    "Help is something I give up." to "Help is something I give myself through the whole."
                )
            ),
            modernApplication = "Systems theory, organisational psychology, and neuroscience all confirm Seneca: humans are deeply interconnected organisms. The research on empathy shows we cannot even do well psychologically while witnessing others suffer. The attempt to extract wellbeing from a suffering system is literally neurologically exhausting.",
            closing = "You are a cell with consciousness. Act like it.",
            reflectionPrompt = "Where in your life are you trying to preserve your own part while the larger body—your community, your relationships, your world—is suffering? What would change if you genuinely saw that as your suffering?"
        ),

        // q098 — Seneca
        "q098" to QuoteInsight(
            intro = "In Seneca's view, gratitude is not a nice feeling to cultivate. It is the highest honour. This inversion—gratitude as the summit, not kindness's reward—is worth sitting with.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Gratitude as Recognition",
                    blockquote = "Nothing is more honorable than a grateful heart.",
                    body = "To be grateful is to recognize that you have received something. That your existence is not self-sufficient. That others have given. This recognition is humbling—and humility in the face of reality is, for the Stoic, the highest honour. A grateful person is someone who has seen reality correctly and is responding to it truthfully.",
                    bullets = listOf(
                        InsightBullet("The clarity it shows", "Gratitude reveals you understand that you are not self-made."),
                        InsightBullet("The honour", "The refusal to be grateful—the claiming that you deserve everything—is actually profound dishonour.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "How Gratitude Shapes Character",
                    blockquote = "...than a grateful heart.",
                    body = "The person with a grateful heart is naturally generous, because they remember they were given to. They are humble, because they know they are indebted. They are resilient, because they remember what they were given even when it is taken away. Gratitude is not an emotion you cultivate for feeling good—it is the practice that produces a good character.",
                    bullets = listOf(
                        InsightBullet("The direction", "Gratitude points you outward, toward what was given, instead of inward at grievance."),
                        InsightBullet("The consequence", "A truly grateful person cannot be arrogant, tyrannical, or petty. The shape of the heart changes everything.")
                    )
                )
            ),
            modernApplication = "Research on gratitude practices shows they measurably reduce entitlement, increase prosocial behaviour, and improve both mental health and relationship quality. Seneca's intuition—that gratitude shapes honour—is empirically supported.",
            closing = "A grateful heart is the most honourable thing you can cultivate, because it reflects the truth about how you came to be.",
            reflectionPrompt = "For what are you still ungrateful? What if you looked at it differently—not as something you deserved less, but as something you were fortunate to receive?"
        ),

        // q099 — Marcus Aurelius
        "q099" to QuoteInsight(
            intro = "This statement seems to grant enormous power to you—everything is just opinion, and you control opinion. But Marcus knows this is more precisely: your judgments are in your power, but they must align with reality to be wise. Opinion is not arbitrary.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What This Is Not Saying",
                    blockquote = "Consider that everything is opinion...",
                    body = "This is not 'everything is subjective and I can believe whatever I want.' That is a modern misreading. Marcus is saying something else: *how you judge* what is happening is opinion. Your interpretation, your evaluation, your response—these are up to you. But they must be *good* opinions, aligned with reason and reality.",
                    bullets = listOf(
                        InsightBullet("The confusion", "Many people read this and think it means 'reality doesn't matter.' It is the opposite."),
                        InsightBullet("The power is real", "Your judgment determines your experience. That is genuine power. But it must be exercised correctly.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Responsibility",
                    blockquote = "...and opinion is in thy power.",
                    body = "That opinion is in your power means something is in your power. You are responsible for your judgments. You cannot blame circumstances for how you interpret them (though circumstances are real). You choose how you meet reality. That is the only power you truly have—and it is enough. It is, in fact, everything.",
                    bullets = listOf(
                        InsightBullet("The freedom", "Because opinion is yours, your wellbeing is not dependent on external things going a certain way."),
                        InsightBullet("The burden", "But that means you cannot escape responsibility for how you respond to what happens.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Misreading",
                rightHeader = "Marcus's Actual Claim",
                rows = listOf(
                    "Nothing is real if I think otherwise." to "What is real is fixed; how I judge it is my choice.",
                    "I can believe whatever I want." to "I can judge as I wish, but wise judgment aligns with reason.",
                    "My experience is all that matters." to "My judgment shapes my experience, and I am responsible for it."
                )
            ),
            modernApplication = "Cognitive therapy operates on exactly this: clients' distress often comes not from circumstances but from judgments about circumstances. Changing unhelpful judgments while acknowledging reality produces the most effective healing.",
            closing = "Your opinion about what is happening is yours to form. That responsibility is your freedom.",
            reflectionPrompt = "What situation are you suffering over right now? What is the objective fact of it, and what is your opinion/judgment about it? Could that judgment be different while the fact remains the same?"
        ),

        // q100 — Marcus Aurelius
        "q100" to QuoteInsight(
            intro = "In seeking to understand why something happened, we tend to grab the simplest explanation: one cause, one culprit. Marcus warns against this reductionism. Reality is more complex. Understanding that complexity is essential to wisdom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Danger of Simple Answers",
                    blockquote = "We are too much accustomed to attribute to a single cause that which is the product of several.",
                    body = "When something goes wrong, we search for a villain. Someone to blame. A single cause. But most events are the result of multiple factors coinciding. Your failure came not from one error, but from a combination of factors: insufficient preparation, bad timing, an element you didn't anticipate. Blaming yourself or others for the single 'true cause' misses the actual picture.",
                    bullets = listOf(
                        InsightBullet("Reductionism limits learning", "If you think there was one cause, you'll fix that one thing and be surprised when the same problem recurs."),
                        InsightBullet("Blame becomes impossible", "With multiple causes, blame becomes less useful. Understanding becomes more useful.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What Complexity Requires",
                    blockquote = "...that which is the product of several.",
                    body = "To think clearly about why something happened, you must resist the urge to find a single story. You must hold multiple factors in mind simultaneously. Your frustration with a colleague played a role. Their stress played a role. The deadline played a role. The misunderstanding in the initial brief played a role. None of these alone explains it. Together, they do.",
                    bullets = listOf(
                        InsightBullet("The sophistication it requires", "To see causality accurately is harder than to see it simply. Yet it is essential to wisdom."),
                        InsightBullet("The mercy it brings", "With multiple causes, you can stop searching for the one culprit and start addressing the actual factors.")
                    )
                )
            ),
            modernApplication = "Root cause analysis and systems thinking both emphasize this insight: most significant problems result from multiple interacting factors, not single causes. Single-factor explanations are seductive but usually misleading.",
            closing = "The simple explanation feels satisfying. Reality rarely does. Wisdom requires holding complexity without collapsing it into simplicity.",
            reflectionPrompt = "What recent failure have you been attributing to a single cause? If you look at it honestly, what other factors contributed to it?"
        ),

        // q101 — Marcus Aurelius
        "q101" to QuoteInsight(
            intro = "Marcus names something we often ignore: there are circumstances where we might gain advantage, but gaining it would cost us something more important—our word and our self-respect. He is saying: don't make that trade.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Tempting Trade",
                    blockquote = "Never esteem anything as of advantage to you which will make you break your word...",
                    body = "Every person faces moments when breaking your word would be advantageous. The deal that works only if you lie. The way out of trouble that requires betraying a promise. The success available only through dishonesty. Marcus is drawing a line: none of these count as advantage. Something that costs your word as payment is not a gain—it is a loss dressed up as one.",
                    bullets = listOf(
                        InsightBullet("The currency", "Your word is more valuable than the profit you'd gain breaking it. Not as poetry—as fact."),
                        InsightBullet("The slope", "Break your word once for advantage, and you've established that your word is for sale. The next time is easier.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Deeper Loss",
                    blockquote = "...or lose your self-respect.",
                    body = "Even if no one else knew you had compromised your word, you would know. And self-respect is not something you can fake internally. You *would* lose it. Marcus understood that what matters most is not how others see you but how you see yourself. If you don't respect yourself, no external advantage compensates.",
                    bullets = listOf(
                        InsightBullet("The permanent consequence", "You might regain money. You might rebuild a reputation with others. But self-respect lost to your own actions is harder to recover."),
                        InsightBullet("The only audience that matters", "You are your own constant witness. Live in a way that allows self-respect.")
                    )
                )
            ),
            modernApplication = "Research on integrity and wellbeing shows that people who violate their own values experience measurable psychological distress, even without external consequences. Self-respect and integrity are closely linked to mental health.",
            closing = "Learn what is actually in your advantage: everything that preserves both your word and your self-respect.",
            reflectionPrompt = "What opportunity are you considering that would require breaking your word or compromising yourself? If you said no—what would you preserve that the yes would cost you?"
        ),

        // q102 — Marcus Aurelius
        "q102" to QuoteInsight(
            intro = "This maxim contains a paradox: towards others, be easygoing; towards yourself, be exacting. Most people have it backward. Marcus shows the way.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Easy Judgment of Others",
                    blockquote = "Be tolerant with others...",
                    body = "Other people will fail, make mistakes, fall short of your expectations. Welcome to being human. Marcus says: be tolerant. Why? Because you don't have full information about their circumstances, their struggles, their limitations. Because judgment is expensive—it costs you energy and poisons your relationships. Because you will want tolerance too.",
                    bullets = listOf(
                        InsightBullet("Not weakness", "Tolerance is not condoning. It is clarity that others are doing their best with what they have."),
                        InsightBullet("The benefit", "A tolerant stance toward others frees you from the burden of being a judge.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Strict Judgment of Yourself",
                    blockquote = "...and strict with yourself.",
                    body = "Meanwhile, apply a much higher standard to yourself. Not out of self-hatred, but because you have full information about your own circumstances. You know where you compromised. You know where you could have tried harder. You have access to your own excuses—and you can see through them. For yourself, this justified strictness. For others, tolerance.",
                    bullets = listOf(
                        InsightBullet("The accountability", "You are responsible for your own choices in a way you cannot be for others' choices."),
                        InsightBullet("The balance", "Strict with yourself prevents self-deception. Tolerant with others prevents resentment.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "Most People Do",
                rightHeader = "Marcus Suggests",
                rows = listOf(
                    "Harsh judgment of others, excuses for themselves." to "Tolerance for others, strictness for themselves.",
                    "Others should meet my standard." to "I should meet a high standard; others are doing their best.",
                    "Judge first; understand later." to "Understand first; judge second—or not at all."
                )
            ),
            modernApplication = "Self-compassion research shows that being strict with yourself while allowing failure in others creates both personal growth and relational health. This exact balance produces the most psychologically resilient people.",
            closing = "Hold yourself to a high standard and others to a gracious one. This is not contradiction—it is wisdom about where your leverage actually is.",
            reflectionPrompt = "Where have you been lenient with yourself but harsh with others? Or vice versa? What would it look like to flip that—to be exacting about your own choices and tolerant about theirs?"
        ),

        // q103 — Seneca
        "q103" to QuoteInsight(
            intro = "Seneca paints a portrait of what Stoic virtue looks like in action: a person unshaken by danger, untouched by lust, discovering happiness in hardship, serene in chaos. This is not philosophy as theory. It is philosophy as visible character.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Paradigm Shift",
                    blockquote = "To see a man fearless in dangers, untainted with lusts, happy in adversity, composed in a tumult...",
                    body = "Most people assume these qualities come from circumstance: fearlessness from safety, contentment from comfort, happiness from prosperity. But Seneca is describing someone showing virtue *in* difficulties. Fearlessness when danger is real. Happiness when adversity is present. This is virtue as strength, not virtue as comfort.",
                    bullets = listOf(
                        InsightBullet("The shock of it", "Such a person appears exceptional because virtue in its pure form is rare in a world of self-protective fear and desire."),
                        InsightBullet("The inspiration", "Seneca notes that Romans should rejoice at the sight of such a person— meaning it is aspirational, exemplary.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Why This Matters",
                    blockquote = "...is not this a sight at which every Roman should rejoice?",
                    body = "Such a person is living proof that virtue is possible. That human beings are not condemned to react in panic or lust or despair. That the capacity for composure, for refusal of corruption, for maintaining joy—these are actually achievable. Not through magic, but through practice. That alone makes such a person worth celebrating.",
                    bullets = listOf(
                        InsightBullet("The proof", "Such a person proves that this way of living is possible."),
                        InsightBullet("The challenge", "And implicitly challenges everyone who sees them: why not you?")
                    )
                )
            ),
            modernApplication = "Research on moral exemplars shows that exposure to people who embody difficult virtues measurably increases others' motivation to cultivate those same virtues. We learn virtue by witnessing it.",
            closing = "Such virtue is rare precisely because it is possible—and therein lies its power to inspire.",
            reflectionPrompt = "Have you encountered someone who maintained composure, courage, or equanimity in circumstances where you would have panicked? What did witnessing that teach you about what is possible?"
        ),

        // q104 — Seneca
        "q104" to QuoteInsight(
            intro = "This is Seneca noticing something simple but profound: the expectations of others can motivate us to higher achievement than we would manage for ourselves. The question is how we respond to that fact.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Power of Being Expected",
                    blockquote = "I shall do more because of your expectation than I could have done merely for my own sake.",
                    body = "When you expect something of me—genuinely expect it, not as judgment but as recognition of what I can do—I rise to meet it. Not out of desperation to please, but out of a kind of honoured call. Someone has seen what I am capable of and invited me to live up to it. That invitation unlocks something.",
                    bullets = listOf(
                        InsightBullet("The mechanism", "Social psychology calls this the Pygmalion effect: when others expect our best, we tend to deliver it."),
                        InsightBullet("Not manipulation", "This is different from pressure or threat. It is genuine recognition of capacity.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Reciprocal Insight",
                    blockquote = "...than I could have done merely for my own sake.",
                    body = "Seneca is admitting something: he can become lazy with himself. He can lower his own standard on his own authority. But when someone else has faith in him, it awakens higher standards. This suggests a practice: seek out people who believe in you, who expect your best. Allow their expectations to become a mirror that shows you what you are capable of.",
                    bullets = listOf(
                        InsightBullet("The utility", "Find people who believe in you not for what you've done, but for what you could do."),
                        InsightBullet("Then return it", "Believe in others with the same force. Help them rise to their own capacity.")
                    )
                )
            ),
            modernApplication = "This connects to concepts of intrinsic vs. extrinsic motivation: while pure external pressure produces inferior results, genuine belief from respected others produces the highest outcomes. Community expectations and mutual encouragement are powerful forces for good.",
            closing = "We become more for those who believe we can be more. Seek such people. Become such a person.",
            reflectionPrompt = "Who expects your best not as judgment but as recognition? Whose expectations help you rise? And for whom can you offer that gift of genuine expectation?"
        ),

        // q105 — Seneca
        "q105" to QuoteInsight(
            intro = "Seneca names a tragic human inversion: we obsess over longevity (how long we live) while ignoring nobility (how well we live). Yet well-living is actually in our power and longevity is not.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Futile Obsession",
                    blockquote = "Men do not care how nobly they live, but only how long...",
                    body = "Society measures life by duration. We celebrate centenarians. We grieve early deaths. But duration itself tells you nothing about the quality of the life lived. A year lived nobly is worth more than fifty years lived in cowardice, mediocrity, and shame. Yet we spend our energy trying to extend duration while neglecting nobility.",
                    bullets = listOf(
                        InsightBullet("The misdirection", "We focus energy where we have limited control and ignore what is entirely in our control."),
                        InsightBullet("The tragedy", "One person lives eighty years well. Another lives thirty but lives nobly. Which life is superior?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Where Your Actual Power Is",
                    blockquote = "...although it is within the reach of every man to live nobly, but within no man's power to live long.",
                    body = "You cannot guarantee longevity—genetics, accident, disease—none are in your control. But nobility? That is entirely your choice. The decision to act with integrity, to face challenges courageously, to treat others justly—this is available to you right now, at any length of life. Seneca is suggesting: stop trying to extend what you can't control and start perfecting what you can.",
                    bullets = listOf(
                        InsightBullet("The available goal", "You can achieve a noble life. Today. At any age. Regardless of circumstances."),
                        InsightBullet("The reorientation", "Shift your anxiety from 'will I live long enough' to 'am I living well enough.'")
                    )
                )
            ),
            modernApplication = "Positive psychology and end-of-life research both confirm Seneca: people least filled with regret are those who lived according to their values, not those who lived longest. Life satisfaction correlates far more with quality than duration.",
            closing = "The length of your life is not in your hands. The nobility of it is entirely yours.",
            reflectionPrompt = "Where are you sacrificing noble living in hopes of longer living? What would change if you genuinely believed that a short, noble life is better than a long trivial one?"
        ),

        // q106 — Seneca
        "q106" to QuoteInsight(
            intro = "This is Seneca's diagnosis: anxiety about the future is not just unpleasant—it is a form of misery happening right now. You are not just worried; you are suffering. In the present. About futures that may never arrive.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Double Suffering",
                    blockquote = "The mind that is anxious about future events is miserable.",
                    body = "Notice Seneca does not say 'bad things might happen.' He says anxiety itself—the preoccupation with what might happen—is misery. You are not in pain because bad things are occurring. You are in pain because you are imaginatively creating pain in your mind about things that haven't happened and may never happen. The suffering is present. The event is future.",
                    bullets = listOf(
                        InsightBullet("The immediate cost", "Anxiety is not just a warning system—it is a current state of misery you are choosing to inhabit."),
                        InsightBullet("The paradox", "You create twice the suffering: once in anticipation, once if the thing actually occurs.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Path Out",
                    blockquote = "...is miserable.",
                    body = "If anxiety is misery, then the cure is clear: return to the present. Not through denial (bad things might happen), but through accuracy (right now, at this moment, you are safe enough). Right now, you are not starving. Right now, you have not failed. Right now, the disaster has not arrived. Meet the present as it is, not the future as you fear it.",
                    bullets = listOf(
                        InsightBullet("The practice", "When anxiety arises, deliberately name what is true right now, in this moment."),
                        InsightBullet("The relief", "You may still need to plan for futures. But you don't need to suffer them in advance.")
                    )
                )
            ),
            modernApplication = "Neuroscience shows that anxiety literally activates the same neural systems as actual threat, meaning your body suffers real stress over imagined futures. Grounding techniques that return attention to the present measurably reduce cortisol and anxiety.",
            closing = "Anxiety about future events is suffering that is entirely present. You have the power to stop it now.",
            reflectionPrompt = "What future event is making you anxious right now? In this actual moment, is that event happening? If not—why are you suffering it in advance?"
        ),

        // q107 — Epictetus
        "q107" to QuoteInsight(
            intro = "Epictetus notices a pattern: we spoil what we have by focusing on what we lack. We are ungrateful to the present because we are greedy for the absent. And he offers a reframe: what you have was once merely hoped for.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Spoiling",
                    blockquote = "Do not spoil what you have by desiring what you have not...",
                    body = "To spoil something is to damage it, corrupt it, make it unsuitable for use. When you possess something good but spend your time wishing for something else, you are spoiling the good thing. Not its external quality—its value to you. The dinner is delicious, but you want dessert, so the dinner becomes unsatisfying. The relationship is good, but you wish for someone else, so you poison it with neglect.",
                    bullets = listOf(
                        InsightBullet("The mechanism", "Constant desire trains you to be ungrateful. Ungrateful people cannot enjoy what they have."),
                        InsightBullet("The tragedy", "The thing spoiled is spoiled by your own mind, not by external circumstance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Reframe",
                    blockquote = "...remember that what you now have was once among the things you only hoped for.",
                    body = "There was a time when you didn't have what you now have, and you wanted it. You hoped for it. Perhaps you got it, or perhaps it is still something you worked to achieve. Now that you have it, treating it as pedestrian and wishing for something else is a form of ingratitude. The thing you have was once precious in your imagination. Return to that vision. See it with the eyes you had before you had it.",
                    bullets = listOf(
                        InsightBullet("The practice", "Periodically, deliberately remember when you didn't have what you now possess."),
                        InsightBullet("The gratitude", "This remembering is not nostalgia—it is restoration of accurate valuing.")
                    )
                )
            ),
            modernApplication = "Gratitude practices and negative visualization both produce measurable increases in life satisfaction. Research confirms Epictetus's insight: remembering what you desired before acquiring it reliably increases satisfaction with what you have.",
            closing = "Everything precious was once a hope. Remember that, and you will always have enough.",
            reflectionPrompt = "What do you now possess that you once hoped for? Can you see it with the gratitude you felt when you desired it? What shifted?"
        ),

        // q108 — Epictetus
        "q108" to QuoteInsight(
            intro = "This statement is about internal self-sufficiency: a person grounded in sound philosophy and clear thinking does not need external validation. They have learned to be their own authority.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Props We Carry",
                    blockquote = "When someone is properly grounded in life...",
                    body = "Most people are not grounded. They lean on approval from others to prop up their sense of worth. They look for external validation that they are doing okay. This creates a fragile structure: if the approval comes, they feel good; if it doesn't, they collapse. Epictetus is saying: develop grounding first. A clear philosophy, sound judgment, reliable principles—these are the foundation.",
                    bullets = listOf(
                        InsightBullet("What grounding looks like", "Clear about what matters, why it matters, and how to live according to it."),
                        InsightBullet("The independence", "That kind of clarity didn't depend on anyone else's assessment to begin with.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Freedom It Creates",
                    blockquote = "...they shouldn't have to look outside themselves for approval.",
                    body = "A grounded person can receive praise without inflating, criticism without deflating. Both become data points, but neither becomes identity. They don't have to look outside for approval because they already know whether they are acting according to their principles. That is the only approval that matters.",
                    bullets = listOf(
                        InsightBullet("The peace", "Needing others' approval keeps you in a constant state of performance anxiety."),
                        InsightBullet("The alignment", "When your own approval is enough, you become free to act on principle rather than on audience.")
                    )
                )
            ),
            modernApplication = "Research on internal vs. external locus of control shows that people primarily guided by internal principles are more resilient, less anxious, and more effective than those dependent on external validation. Intrinsic motivation outperforms extrinsic motivation across domains.",
            closing = "Develop yourself so thoroughly that you are your own sufficient approval. Then external opinions become suggestions, not verdicts.",
            reflectionPrompt = "Where are you looking outside yourself for approval? How would your life change if that external validation disappeared—and how can you address that vulnerability?"
        ),

        // q109 — Seneca
        "q109" to QuoteInsight(
            intro = "This is Seneca's vision of human unity: nature itself has constructed us with an intrinsic connection to each other. This is not philosophy we are adding to human nature. It is recognizing what is already there.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Built-In Connection",
                    blockquote = "Nature has so created us that a certain tie unites us all.",
                    body = "Seneca is making an empirical claim: look at human nature. We are not built to be isolated. We understand each other through language, through mirror neurons, through empathy. We suffer in isolation. We flourish in connection. This is not a cultural add-on—it is foundational. Remove the tie and you have damaged something fundamental.",
                    bullets = listOf(
                        InsightBullet("Not sentimental", "This is biology and neurology, not just ethics."),
                        InsightBullet("The implication", "If we are built for connection, acting in isolation is working against ourselves.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Natural Ethics That Follows",
                    blockquote = "...a certain tie unites us all.",
                    body = "If the tie is real, then ethics follow naturally from nature. You don't have to argue yourself into caring about others—you just have to notice that you are connected to them already. Harming others is harming yourself, not metaphorically but actually. Helping others is helping yourself. This is not altruism overriding self-interest. It is recognizing that they are not opposite.",
                    bullets = listOf(
                        InsightBullet("The logic", "If we are bound together by nature, then individual good and collective good are inseparable."),
                        InsightBullet("The responsibility", "We don't have to invent reasons to care for humanity. We just have to notice we are part of it.")
                    )
                )
            ),
            modernApplication = "Systems biology, neuroscience, and evolutionary psychology all confirm Seneca's insight: humans are deeply interconnected organisms, not isolated units. The distinction between individual and collective wellbeing is artificial.",
            closing = "You are tied to all humanity by nature itself. This is not obligation—it is recognition of what is already true.",
            reflectionPrompt = "What difference would it make in your daily decisions if you genuinely felt the tie that connects you to all humanity? Where would you treat people differently?"
        ),

        // q110 — Epictetus
        "q110" to QuoteInsight(
            intro = "This is a cryptic and profound warning: there is a danger in people who have found answers and now possess them as certainty. The danger is often worse than honest confusion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Virtue of Seeking",
                    blockquote = "Cherish those who seek the truth...",
                    body = "People in genuine search—people who admit uncertainty and ask questions—are safe to be around. Their humility leaves room for learning. They can change their mind. They can be corrected. They are not defending a position; they are investigating a question. Such people make good teachers, good friends, good colleagues.",
                    bullets = listOf(
                        InsightBullet("The character reflected", "Someone seeking truth is admitting they don't have it yet. This is an honest posture."),
                        InsightBullet("The openness", "A truth-seeker can incorporate new evidence without their whole identity collapsing.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Danger of Certainty",
                    blockquote = "...but beware of those who find it.",
                    body = "The moment someone believes they have found the final truth, they become dangerous. They stop questioning. They stop listening. They become defensive of the truth they have 'found.' They become zealots, ideologues, dogmatists. The more convinced they are, the more likely they are to harm others (and themselves) in defence of their certainty.",
                    bullets = listOf(
                        InsightBullet("The irony", "People most sure they have found truth are often most distant from it."),
                        InsightBullet("The tragedy", "Certainty closes the door to deeper truth.")
                    )
                )
            ),
            modernApplication = "Cognitive science research on belief perseverance and backfire effects shows Epictetus was right: people convinced they have found truth resist correction and sometimes double down when shown contradicting evidence. The seeker is in a far better epistemic position than the finder.",
            closing = "Remain suspicious of anyone who claims to have found the final truth. Support those who are still searching.",
            reflectionPrompt = "Where do you possess certainty that might actually be closed-mindedness? What truth are you still actively seeking rather than defending?"
        ),

        // q111 — Cato
        "q111" to QuoteInsight(
            intro = "Cato's claim is sweeping: of all the virtues — wisdom, courage, temperance — none exceeds justice in dignity or importance. Justice is the crowning glory. This suggests that justice is not one virtue among others but the capstone that gives meaning and coherence to all the others.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Why Justice Is Central",
                    blockquote = "Justice is the crowning glory of the virtues.",
                    body = "A person might be wise but use wisdom for exploitation. Brave but use courage for domination. Temperate but indulge only themselves. But a person who is just brings all their other capacities into alignment with others' wellbeing. Justice is the virtue that makes the others beneficial rather than merely impressive. It is the difference between capability and character.",
                    bullets = listOf(
                        InsightBullet("The capstone", "Justice completes the other virtues by directing them toward what is right, not merely what works."),
                        InsightBullet("The connector", "Justice bridges the individual and the collective—it acknowledges that virtue in isolation is incomplete.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Glory Through Rightness",
                    blockquote = "...crowning glory...",
                    body = "Glory in the Stoic sense is not fame or public recognition. It is the honour that comes from living according to principle. When Cato says justice is the crowning glory, he means that a just life is the most honourable life available—regardless of whether anyone else acknowledges it.",
                    bullets = listOf(
                        InsightBullet("True glory is quiet", "The greatest distinction is not noticed by crowds. It is recognised only by those who understand character."),
                        InsightBullet("The self-validating path", "Justice requires no external approval. Its own integrity is its reward.")
                    )
                )
            ),
            modernApplication = "Research on character strengths and virtues shows that people who rate justice and fairness as central strengths report higher life satisfaction and are rated as more trustworthy by others. Justice is not merely right—it is, practically, the foundation of human flourishing.",
            closing = "When all other virtues are present but justice is missing, what remains is merely a well-dressed crime. When justice is present, all becomes honourable.",
            reflectionPrompt = "What would it look like to make justice the crowning concern of your life? Where might you be developing other virtues without the guidance of justice to direct them?"
        ),

        // q112 — Seneca
        "q112" to QuoteInsight(
            intro = "Seneca diagnoses psychological self-imprisonment: guilt is not something done to you from outside. It is a trap you set for yourself by your own deeds. The guilty person's own actions work against them, creating a prison that locks from the inside.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Self-Made Trap",
                    blockquote = "The guilty catch their own guilt in their deeds.",
                    body = "When you act unjustly, you do not simply commit an external crime. You embed dishonesty into your own mind. You become someone who knows what they are capable of—betrayal, cruelty, dishonesty. That knowledge is your guilt. You cannot unknow yourself. The deed itself becomes the prison.",
                    bullets = listOf(
                        InsightBullet("Internal consequences", "Guilt is not a punishment imposed; it is a natural consequence built into the act itself."),
                        InsightBullet("The inescapable witness", "You are always present at the scene of your own crime. Escape is impossible.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Way Out",
                    blockquote = "...catch their own guilt...",
                    body = "If guilt is self-created by deeds, then freedom is also self-created by different deeds. The person who chooses just acts over many repetitions becomes someone different—not guilty but clear-minded. The key is that the catching of guilt happens the same way the shedding of it does: through the accumulation of choices.",
                    bullets = listOf(
                        InsightBullet("No escape, only transformation", "You cannot atone by fleeing guilt; you can only atone by becoming just."),
                        InsightBullet("Prevention is easier than cure", "Better to never catch guilt than to spend years shedding it.")
                    )
                )
            ),
            modernApplication = "Neuroscience research on guilt shows that it literally activates threat-detection systems, keeping the nervous system in a state of defensive vigilance. The guilt doesn't fade from punishment or time alone—it fades only when the internal narrative changes through genuine change in behaviour and self-concept.",
            closing = "Your deeds do not just affect others—they change who you are. Choose them accordingly.",
            reflectionPrompt = "Is there a deed whose guilt you carry? What would it take not just to apologise but to genuinely become the kind of person who wouldn't repeat it?"
        ),

        // q113 — Epictetus
        "q113" to QuoteInsight(
            intro = "Epictetus reframes defeat in a way that inverts defeat's apparent meaning. What looks like loss—failure, setback, loss—is actually information. Defeat is a teacher, and the lesson is that something needs to change.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Lesson Embedded in Failure",
                    blockquote = "What is defeat? Nothing but education...",
                    body = "Defeat arrives to tell you something you didn't know. Your method doesn't work. Your assumption was wrong. Your strength was insufficient. These are not shameful discoveries—they are the necessary data for improvement. The person who never meets defeat is either supremely fortunate or never challenges themselves to grow.",
                    bullets = listOf(
                        InsightBullet("Information is value", "Defeat that teaches what works is more valuable than success that teaches nothing."),
                        InsightBullet("Growth through limitation", "You learn the boundaries of your capacity only by encountering them.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The First Step",
                    blockquote = "...nothing but the first step to something better.",
                    body = "Defeat is not an ending. It is a waypoint. Epictetus insists: it is the first step to something better. Not back to where you were, but forward to where you couldn't have reached without the defeat. The person who learns from loss moves ahead faster than the person who was never tested.",
                    bullets = listOf(
                        InsightBullet("The necessary descent", "Sometimes you must descend into failure to reach a higher place."),
                        InsightBullet("Trajectory matters more than position", "Where you are is less important than the direction you're moving.")
                    )
                )
            ),
            modernApplication = "Growth mindset research shows that people who view setbacks as information to learn from (rather than verdicts on their abilities) recover faster, try again sooner, and ultimately achieve more. Epictetus's reframe is not just philosophical—it's neurologically sound. The brain learns best through mistakes.",
            closing = "Defeat in the service of growth is not failure; it is education being delivered at cost.",
            reflectionPrompt = "What recent defeat are you carrying? What is it trying to teach you? What becomes possible if you take the lesson and move forward?"
        ),

        // q114 — Seneca
        "q114" to QuoteInsight(
            intro = "Seneca makes a distinction that threatens the entire edifice of formal education: real learning doesn't happen in institutions. It happens in the actual world, through living. The classroom is a preparation, but life is the curriculum.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Limits of the Classroom",
                    blockquote = "We learn not in the school but in life.",
                    body = "In school, you study principles in the abstract. You consider scenarios. You pass examinations. But in life, the stakes are real. Your mistakes cost you. Your understanding is tested under pressure, fatigue, and unexpected circumstances. You encounter problems that no textbook predicted. This is where learning becomes real.",
                    bullets = listOf(
                        InsightBullet("Theory vs. embodiment", "You can know something intellectually and still not know it in the way that living teaches."),
                        InsightBullet("The irreducible unpredictability", "Life includes situations no one warned you about—which is exactly when learning is most urgent.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Life as the Real Master",
                    blockquote = "...in life.",
                    body = "This doesn't mean formal education is worthless—it is preparation. A good education teaches you how to learn, provides frameworks, tests your thinking. But the actual learning, the embodied wisdom—that comes only through living. By the end of your life, you will have learned far more than any degree could teach, precisely because you lived.",
                    bullets = listOf(
                        InsightBullet("The continuing curriculum", "Every day of life teaches if you are paying attention and willing to learn."),
                        InsightBullet("The humble position", "The greatest scholars are also the humblest students of life.")
                    )
                )
            ),
            modernApplication = "Experiential learning research confirms what Seneca observed: retention and comprehension are vastly higher when learning is embedded in real consequences and motivated problem-solving. The brain is wired to learn through living.",
            closing = "You may graduate from school, but you never graduate from life's classroom.",
            reflectionPrompt = "What has life taught you that no school could have? What are you currently learning through living that you couldn't learn any other way?"
        ),

        // q115 — Marcus Aurelius
        "q115" to QuoteInsight(
            intro = "Marcus Aurelius offers one of Stoicism's most powerful reframes: obstacles are not interruptions to your path—they are part of the path. And more: they are raw material that a rational being can transform into exactly what they need for their goals.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "How Nature Integrates Obstacles",
                    blockquote = "Just as nature takes every obstacle, every impediment, and works around it — turns it to its purposes, incorporates it into itself...",
                    body = "Notice the image: nature doesn't fight obstacles; it incorporates them. A river encounters a boulder and becomes stronger through the resistance. A tree grows around a wound and the scar strengthens the wood. Every obstacle is woven into the thing's development, making it more complex and resilient.",
                    bullets = listOf(
                        InsightBullet("Integration, not avoidance", "The obstacle doesn't stop growth—it redirects it and often accelerates it."),
                        InsightBullet("The design of nature", "If this is how nature works everywhere, why do we expect it to work differently for ourselves?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Your Raw Material",
                    blockquote = "...so, too, a rational being can turn each setback into raw material and use it to achieve its goals.",
                    body = "You have a capacity nature's mere objects lack: rationality. You can take the obstacles that arrive and deliberately ask: what can I use this for? A delay teaches patience. A refusal teaches adaptation. A loss teaches what actually matters. A failure teaches a method that doesn't work. You have the power to transform every impediment into exactly the material you need.",
                    bullets = listOf(
                        InsightBullet("Your unique power", "Not merely to survive obstacles but to use them purposefully."),
                        InsightBullet("Infinite raw material", "As long as you live, obstacles will arrive—and so will opportunities to practice transformation.")
                    )
                )
            ),
            modernApplication = "Neuroscience research on post-traumatic growth shows that people who integrate hardship into their narrative and extract meaning from it experience measurable increases in resilience, wisdom, and strength. The obstacle literally becomes the raw material for growth.",
            closing = "The obstacle that frustrates you today is the strength you'll possess tomorrow, if you have the wisdom to use it.",
            reflectionPrompt = "What obstacle in your life right now feels like a pure impediment? What would change if you tried to see it as raw material for exactly what you're trying to become?"
        ),

        // q116 — Marcus Aurelius
        "q116" to QuoteInsight(
            intro = "Marcus Aurelius extends the logic of community that runs through Stoicism: what harms the group harms you as a member of that group. You cannot be well if the hive is diseased. This is not morality imposed from outside—it is simple logic about interconnection.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Logic of the Hive",
                    blockquote = "That which is not good for the bee-hive cannot be good for the bees.",
                    body = "A bee that acts against the hive's interests is also acting against its own interests, because the bee's survival depends on the hive. The individual bee cannot flourish if the hive is weak. Something might seem beneficial to a single bee—keeping extra honey when others are starving—but it ultimately harms that bee by weakening the structure it depends on.",
                    bullets = listOf(
                        InsightBullet("Interdependence is not idealism", "It's structural reality. You depend on the health of the systems you're part of."),
                        InsightBullet("Short-term vs. long-term", "Actions that benefit you immediately often harm you eventually.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Your Hives",
                    blockquote = "...good for the bees.",
                    body = "You belong to multiple hives: your family, your community, your society, humanity itself. What harms these harms you—not as a moral position but as a fact. Your prosperity depends on living in a society with some level of stability, trust, and justice. Injustice anywhere weakens the structure everywhere.",
                    bullets = listOf(
                        InsightBullet("Your enlightened interest", "Acting justly is not self-sacrifice. It's enlightened self-interest."),
                        InsightBullet("The level of analysis matters", "Zoom out far enough and you see that your wellbeing and the collective wellbeing are inseparable.")
                    )
                )
            ),
            modernApplication = "Systems theory and evolutionary biology both confirm Marcus Aurelius: organisms that behave selfishly in isolation often suffer when the larger system fails. Cooperation and fairness are not moral imperatives imposed from outside—they're systemic requirements for thriving.",
            closing = "Your interests and the hive's interests are not opposed—they're the same interest viewed at different scales.",
            reflectionPrompt = "What 'hives' are you part of that depend on you contributing to their health? What happens to you if the systems you depend on become corrupted?"
        ),

        // q117 — Seneca
        "q117" to QuoteInsight(
            intro = "Seneca offers a definition of virtue that invokes an almost medical precision: virtue's object — its purpose, its end result — is peace of mind. Not pleasure, not success, not power. Peace of mind.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The True Target of Virtue",
                    blockquote = "The object of all virtue is peace of mind.",
                    body = "When you live justly, honestly, courageously, temperately — you are not doing so in hopes of public recognition or material reward. These may come or not. But the direct result of virtue is a kind of peace: freedom from regret, from shame, from the war between your values and your actions. A guilty person cannot have peace of mind, regardless of external success.",
                    bullets = listOf(
                        InsightBullet("The direct effect", "Peace of mind is not the distant reward—it arrives immediately with virtuous action."),
                        InsightBullet("The compass", "If peace of mind is the object, you have a way to measure whether you're on the right path.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Distraction of External Goals",
                    blockquote = "...peace of mind.",
                    body = "Many people pursue virtue for the wrong reasons—to be admired, to succeed, to avoid punishment. But these external goals don't produce peace; they produce anxiety. The ambitious person is never at rest because ambition is never sated. The person seeking admiration is always vulnerable to criticism. Only the person who pursues virtue for its own sake—for the peace that follows—finds the actual peace.",
                    bullets = listOf(
                        InsightBullet("The right motivation", "Virtue pursued for external reward becomes a kind of vice. Virtue pursued for inner peace becomes actual peace."),
                        InsightBullet("The paradox", "Stop chasing peace and you'll find it. Pursue it directly and it eludes you.")
                    )
                )
            ),
            modernApplication = "Research on eudaimonia and flourishing shows that people oriented toward meaning and virtue report higher life satisfaction than those oriented toward external achievement alone. Purpose aligned with virtue produces measurable psychological peace.",
            closing = "All virtue ultimately converges on the same destination: the quiet of a well-ordered soul.",
            reflectionPrompt = "When you have acted virtuously, what kind of peace did you feel? When you have compromised your principles, what kind of unrest followed? Which is the real evidence about virtue's purpose?"
        ),

        // q118 — Epictetus
        "q118" to QuoteInsight(
            intro = "Epictetus makes a striking claim: clear vision — really seeing things as they are — is itself a kind of transcendence. To see clearly is poetry because it reveals beauty. Prophecy because it reveals what will unfold. Religion because it reveals the sacred.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Clarity As Revelation",
                    blockquote = "To see clearly is poetry, prophecy, and religion all in one.",
                    body = "Poetry reveals hidden beauty in the ordinary. When you see clearly — when the distractions and illusions fall away — the world appears beautiful. Prophecy reveals what will come. Clear vision shows you the logical consequences of actions, the trajectory of choices. Religion reveals the sacred dimension of existence. A clear mind recognises the sacred in structure, order, and the interconnection of all things.",
                    bullets = listOf(
                        InsightBullet("Vision as spiritual practice", "Clarity is not just intellectual—it's transformative. It changes how you experience reality."),
                        InsightBullet("Unity of perception", "Poetry, prophecy, and religion aren't different practices. They're aspects of clear sight.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Work of Seeing",
                    blockquote = "...all in one.",
                    body = "Clear vision doesn't come automatically. Clouded vision — through desire, fear, prejudice, distraction — is the default. To see clearly requires discipline. You must remove the obstacles: the craving for things outside your control, the false beliefs you've accepted without examination, the defensive narratives you tell yourself. As obstacles clear, vision clarifies.",
                    bullets = listOf(
                        InsightBullet("Perception as practice", "You develop clear sight through the same discipline that develops any skill."),
                        InsightBullet("The reward of seeing", "Once you've seen clearly once, you'll spend your life trying to see that clearly again.")
                    )
                )
            ),
            modernApplication = "Neuroscience shows that perception is not passive—it's an active construction. Attention, belief, and emotional state all shape what we literally perceive. Practices that clarify mind (meditation, philosophical reflection) measurably change what people notice about reality.",
            closing = "The sacred is not hidden. It's obscured only by unclear sight. Develop clarity and the sacred reveals itself.",
            reflectionPrompt = "When have you seen something with complete clarity — all illusions stripped away? What did that clarity reveal? What usually clouds your vision and prevents that clarity?"
        ),

        // q119 — Seneca
        "q119" to QuoteInsight(
            intro = "Seneca offers a historical perspective that amounts to prophecy: injustice does not endure. It may seem to flourish. It may appear victorious. But it carries within it the seeds of its own destruction.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Instability of Injustice",
                    blockquote = "Injustice never rules forever.",
                    body = "Unjust systems breed resentment, instability, and resistance. They must be defended through increasing force and deception, which requires more resources and more people and creates more enemies. An unjust ruler surrounds themselves with those they can control only through fear or payment — loyal only while fear exceeds the reward for betrayal. Injustice is inherently fragile.",
                    bullets = listOf(
                        InsightBullet("The unsustainability", "Injustice requires constant maintenance and vigilance. Justice, once established, sustains itself."),
                        InsightBullet("The temporal reality", "What seems permanent is temporary. The unjust regime falls; the just principle endures.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What This Means for You",
                    blockquote = "...never rules forever.",
                    body = "This is not a promise that the universe is morally just. Unjust people do prosper temporarily. But the promise is longer-term: injustice collapses under its own weight. For you, this means: act justly even when injustice appears to win. Act with integrity even when corruption appears rewarded. The long game is yours.",
                    bullets = listOf(
                        InsightBullet("Patience in justice", "You don't need to win immediately. History sides with justice."),
                        InsightBullet("The internal victory", "Even if injustice ruled forever externally, you have the internal victory of acting justly.")
                    )
                )
            ),
            modernApplication = "Historical analysis and game theory both support Seneca: cooperative, fair, honest systems outcompete unfair ones over time. Corruption collapses. Justice institutions prove more stable.",
            closing = "The unjust may have a turn. But the just have the future.",
            reflectionPrompt = "Where are you tempted to act unjustly because injustice appears rewarded in the short term? What changes if you extend your time horizon?"
        ),

        // q120 — Epictetus
        "q120" to QuoteInsight(
            intro = "Epictetus offers what might be Stoicism's most paradoxical line: you are a little soul carrying around a corpse. The body is just meat. But what a soul. This is not pessimism about the body—it's awe at the soul's greatness.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Relative Insignificance of the Body",
                    blockquote = "You are a little soul carrying around a corpse.",
                    body = "The body is literally made of the same matter as a corpse will be. Finite. Fragile. Subject to disease, decay, inevitable death. You feed it, tend to it, but it will fail. In the scale of eternity, it's nothing. The temptation to treat the body as supremely important — to exhaust yourself in its service, to fear its suffering above all else — is to mistake the corpse for the treasure.",
                    bullets = listOf(
                        InsightBullet("Perspective on the body", "Essential to respect and care for, but not to exalt."),
                        InsightBullet("The meditative reality", "Spending an hour imagining the body's inevitable decay is one way to reset priority.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "But What a Soul",
                    blockquote = "— But what a soul!",
                    body = "The dash — that interruption — marks the pivot. Yes, the body is a corpse-to-be. But the soul. Your capacity to choose, to reason, to transcend circumstance, to love, to create meaning — this is extraordinary. This is the true you. The body follows; the soul leads. The body ages; the soul grows. The body can be imprisoned; the soul remains free.",
                    bullets = listOf(
                        InsightBullet("The true wealth", "Your soul's capacities are boundless even while your body decays."),
                        InsightBullet("The right proportion", "Don't neglect the body. But don't mistake it for yourself.")
                    )
                )
            ),
            modernApplication = "Research on meaning and transcendence shows that people who identify with something beyond their physical self — purpose, principle, legacy — weather physical decline with significantly greater equanimity. The soul transcends what the body cannot escape.",
            closing = "The body carries you for a time. But the soul — the real you — is carrying something far more significant than matter.",
            reflectionPrompt = "When you imagine your death, what part of you do you feel afraid for? Which part do you feel is truly you? Where is your actual investment?"
        ),

        // q121 — Seneca
        "q121" to QuoteInsight(
            intro = "Seneca diagnoses a common human predicament: without a clear destination, every breeze pushes you around. The wind of opportunity, circumstance, opinion, and desire all move the aimless person. But the person with a clear purpose has something the wind cannot move.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Aimless Drift",
                    blockquote = "If one does not know to which port one is sailing, no wind is favorable.",
                    body = "A ship pointed at a specific harbour can use any wind — even headwinds it tacks against. But a ship without a destination is blown hither and yon, all winds equally useless because none of them advance anything. The aimless person has the same problem. External circumstances arrive — opportunities, setbacks, invitations — but without a clear port (a life direction), none of it moves you forward. You're just drifting.",
                    bullets = listOf(
                        InsightBullet("Direction as meaning", "Without a destination, activity becomes mere motion. With a destination, every action carries weight."),
                        InsightBullet("The power of constraint", "A clear purpose actually increases your freedom by eliminating confusion about what to do.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Choosing Your Port",
                    blockquote = "...no wind is favorable.",
                    body = "The first work is to identify your port — not someone else's destination, but the one that calls to you when you're honest about what matters. Is it wisdom? Contribution? Mastery? Family? Once you know this, you have a rudder. Every wind — every circumstance — becomes usable. The opportunity that doesn't point toward your port you can refuse. The difficulty that approaches it you can embrace.",
                    bullets = listOf(
                        InsightBullet("Self-knowledge as prerequisite", "You can't navigate well to a destination you don't know you're choosing."),
                        InsightBullet("The decision to decide", "The hardest step is often simply committing to a direction rather than keeping options perpetually open.")
                    )
                )
            ),
            modernApplication = "Research on meaning and goal-setting shows that people with a clear sense of life direction report higher satisfaction and make better decisions even under uncertainty. Purpose acts like an anchor that keeps random circumstances from derailing you.",
            closing = "A clear destination makes every wind useful. Without one, no wind helps at all.",
            reflectionPrompt = "What is your port? If you don't have one clearly identified, what would help you choose one? And if you do, are you actually sailing toward it or drifting nearby?"
        ),

        // q122 — Marcus Aurelius
        "q122" to QuoteInsight(
            intro = "Marcus Aurelius offers instructions for the two fundamental transactions of life: receiving and letting go. In both, pride and struggle are the errors. The right relationship to what comes is receptive openness. The right relationship to what departs is willing release.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Receiving Without Pride",
                    blockquote = "Receive without pride...",
                    body = "When something good comes to you — success, recognition, help, fortune — the natural movement is to inflate with pride. To take particular credit. To believe you deserved it. When you receive with pride, you're contradicting what you've received. Good things that come to you are partly chance, partly circumstance, partly the help of others — yet pride claims they are entirely your doing. This denial of reality is corrupting.",
                    bullets = listOf(
                        InsightBullet("Humility as accuracy", "Receiving without pride is not modesty—it's honest accounting. You didn't do it alone."),
                        InsightBullet("The freedom of acceptance", "Once you accept that you didn't completely deserve what came, you can enjoy it without needing to defend it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Relinquishing Without Struggle",
                    blockquote = "...relinquish without struggle.",
                    body = "When something departs — youth, a person, a position, health — the natural movement is to struggle against it. To deny it. To try to fight physics and time. But this struggle is the source of suffering. The thing has already left. Fighting against what has already happened is fighting against reality itself. The wise response is to release what has released itself, without internal struggle.",
                    bullets = listOf(
                        InsightBullet("Acceptance as power", "The person who lets go easily is the strongest—they're not wasting energy fighting the inevitable.")
                    )
                )
            ),
            modernApplication = "Gratitude research shows that people who receive generously (without attributing it entirely to themselves) experience greater wellbeing and deeper relationships. Acceptance research shows that struggling against unchanged loss increases suffering while acceptance allows moving forward.",
            closing = "Hold what comes without claiming it. Release what leaves without fighting it. This is the rhythm of wisdom.",
            reflectionPrompt = "What recent gift have you received with pride? What are you currently struggling to relinquish rather than releasing?"
        ),

        // q123 — Seneca
        "q123" to QuoteInsight(
            intro = "Seneca draws a sharp distinction: the same tool — wealth — serves the wise as a slave but the foolish person becomes enslaved to it. Wealth itself is neutral. The difference is entirely in how you relate to it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Wealth as Slave",
                    blockquote = "Wealth is the slave of a wise man.",
                    body = "A wise person uses wealth as a tool: to provide security, to create opportunity, to help others, to support serious work. But the wise person doesn't need wealth. If it came, they would use it well. If it departed, so what? Because wealth is literally serving them, they can put it down anytime. It follows orders rather than giving them.",
                    bullets = listOf(
                        InsightBullet("The instrumental view", "The wise see wealth as a means, not an end. As a resource, not an identity."),
                        InsightBullet("Non-dependence", "The proof of freedom is that you can walk away from what you have.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Foolish Person's Master",
                    blockquote = "The master of a fool.",
                    body = "A fool cannot walk away. The fool believes that security, happiness, and worth all depend on having wealth. So the fool works at its pursuit endlessly, makes compromises to keep it, fears losing it, and ends up serving it. The wealth has become the master and the fool becomes enslaved to the pursuit and protection of it.",
                    bullets = listOf(
                        InsightBullet("The reversal", "What was supposed to serve you has become what you serve."),
                        InsightBullet("The entrapment", "The moment you believe you cannot live well without wealth, you have given it power over you.")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Wise Relationship",
                rightHeader = "The Foolish Relationship",
                rows = listOf(
                    "Uses wealth as a tool for living well." to "Pursues wealth as though it IS living well.",
                    "Can be content without it." to "Cannot be content without it.",
                    "Wealth serves the person's values." to "The person serves wealth's accumulation."
                )
            ),
            modernApplication = "Research on materialism and wellbeing shows that people oriented toward financial security for its own sake experience higher anxiety and lower life satisfaction than those who use money as a resource for chosen goals. Seneca's diagnosis is supported by evidence.",
            closing = "The question is not how much wealth you have. The question is whether you own it or it owns you.",
            reflectionPrompt = "What relationship do you have to money? Could you walk away from what you have? If not, who is the master and who is the slave?"
        ),

        // q124 — Seneca
        "q124" to QuoteInsight(
            intro = "Seneca redefines richness: the rich person is not the one with the most possessions but the one with the least need. Richness and contentment are not about the absolute amount you have but your capacity to feel sufficient with what is available.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Paradox of Abundance",
                    blockquote = "He is richest who is content with the least...",
                    body = "A person with an enormous fortune but perpetual dissatisfaction is poor in the only way that matters: internal poverty. A person with modest means but a satisfied mind is rich in the only way that matters: internal wealth. Contentment is the currency of actual richness.",
                    bullets = listOf(
                        InsightBullet("Wealth is internal", "Your richness is not in your account balance—it's in your mind's relationship to having."),
                        InsightBullet("The inversion", "More can make you poorer. Less can make you richer. It depends entirely on your contentment.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Wealth of Nature",
                    blockquote = "...for contentment is the wealth of nature.",
                    body = "Nature provides what is necessary: food, shelter, community. Everything beyond that is luxury. The person who is content with what nature provides is, by definition, rich. Because they lack nothing — they have everything that satisfies them. Seneca is saying: align your sense of richness with what nature actually offers and you will be wealthy.",
                    bullets = listOf(
                        InsightBullet("Alignment with reality", "The wealthy person is wealthy with respect to what is actually available, not with respect to unlimited desire."),
                        InsightBullet("Sufficiency redefined", "Richness is the state of having enough. And enough is determined by contentment, not by quantity.")
                    )
                )
            ),
            modernApplication = "Contentment research shows that people who practice contentment exercises (gratitude, negative visualization, simple pleasures) report equal or higher satisfaction with lower incomes compared to those perpetually pursuing more. Contentment is the lever by which people become wealthy.",
            closing = "The richest person is the one who wants the least. Not because they're resigned but because they're satisfied.",
            reflectionPrompt = "What would it take for you to feel rich? Is it an amount of money, or is it a shift in contentment? Could you be rich with what you have if your mind shifted?"
        ),

        // q125 — Seneca
        "q125" to QuoteInsight(
            intro = "Seneca repeats this refrain—Omnia aliena sunt—because the truth it carries is so counterintuitive that it requires repetition. Everything is alien to us. Temporary. On loan. Everything except time, which is — uniquely — ours.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Alienness of Possessions",
                    blockquote = "Omnia, Lucili, aliena sunt — Everything is alien to us...",
                    body = "You possess things but you do not own them permanently. They will be taken from you through age, loss, theft, death, or simply the fact that you will die and then they will belong to someone else. In this sense, everything you have is borrowed from the future. Treating it as though it's fundamentally yours is a kind of delusion.",
                    bullets = listOf(
                        InsightBullet("Possession without attachment", "You can use and care for what you have while acknowledging it was never truly yours."),
                        InsightBullet("The freedom in impermanence", "If nothing is yours, you can't really lose anything—it was never yours to keep.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Time Alone Is Ours",
                    blockquote = "...time alone is ours.",
                    body = "Everything except time can be taken. Your property, your position, your body, eventually your life. But while you live, this moment is yours. The next heartbeat you take is yours. The hour you spend is yours. The decision about attention right now — that is entirely yours. Seneca is saying: stop expending energy protecting what you can't protect. Focus it on using what you actually have: time.",
                    bullets = listOf(
                        InsightBullet("The actual resource", "Time is the only wealth that cannot be stolen, inherited, or transferred. Only spent."),
                        InsightBullet("The use of what you have", "Stop protecting possessions. Spend time on what matters.")
                    )
                )
            ),
            modernApplication = "End-of-life research consistently shows that people regret time spent on material pursuits far more than unachieved material goals. Time—actually spent on what mattered—is the one thing people wish they had invested in more heavily.",
            closing = "Let go of what isn't yours to keep. Invest deeply in what you actually have: the time you're given.",
            reflectionPrompt = "What possession are you spending significant time protecting or pursuing? What could you do with that time if you accepted that it was never yours to keep?"
        ),

        // q126 — Marcus Aurelius
        "q126" to QuoteInsight(
            intro = "Two words: Simplify, simplify. Marcus Aurelius doesn't elaborate because he doesn't need to. The instruction is to examine your life and remove what doesn't serve you. Do this repeatedly.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Complexity Creep",
                    blockquote = "Simplify, simplify.",
                    body = "Life accrues complexity. Possessions multiply, commitments accumulate, opinions proliferate, relationships require maintenance. What began simple gradually becomes intricate until you're managing systems instead of living. Marcus Aurelius, as a Roman emperor with enormous complexity available to him, chose instead the opposite discipline: relentless simplification.",
                    bullets = listOf(
                        InsightBullet("Entropy of complexity", "Complexity spreads naturally. Simplicity requires deliberate work."),
                        InsightBullet("The weight of possession", "Each additional thing — physical or mental — adds to what you must manage.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practice of Pruning",
                    blockquote = "Simplify, simplify.",
                    body = "The repetition is key. Not 'simplify once' but 'simplify, simplify.' This is an ongoing practice. Because complexity will always return unless you prune it regularly. Each item asked to justify its place: do I need this? Does this support my values? Is this moving me toward what matters? If not: remove it.",
                    bullets = listOf(
                        InsightBullet("Clarity through constraint", "Simplicity creates space for what actually matters by removing what merely complicates."),
                        InsightBullet("The ease that follows", "Simplicity is not deprivation. It's relief.")
                    )
                )
            ),
            modernApplication = "Research on decision fatigue and cognitive load shows that excessive complexity and possession exhausts mental resources and reduces wellbeing. Simplification increases available mental energy and reduces stress measurably.",
            closing = "Look at your life. What is here that doesn't need to be? Remove it. Then look again.",
            reflectionPrompt = "What complexity in your life is actually just complication? What would become possible if you removed it?"
        ),

        // q127 — Epictetus
        "q127" to QuoteInsight(
            intro = "Epictetus restates the dichotomy of control in practical terms: do everything you can with what's in your power. Then receive what comes — good or bad — as nature giving it. The rest is not ours to determine.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Maximal Effort With What We Control",
                    blockquote = "We must make the best use of those things that are in our power...",
                    body = "You control your effort, your intention, your principles, your attention, your choices. These are entirely yours. The instruction is to use them excellently. Not halfheartedly. Not with reserve. Not conditionally. Maximum effort applied to what you actually control.",
                    bullets = listOf(
                        InsightBullet("The full commitment", "Don't hold back from what you can control because you're anxious about what you can't."),
                        InsightBullet("Owned effort", "This is the only effort that's truly yours—all power and full responsibility.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Acceptance of What We Don't",
                    blockquote = "...and take the rest as nature gives it.",
                    body = "What results from your effort — the outcome — is not entirely in your control. Luck arrives. Circumstance interferes. Other people have agency. Nature doesn't care about your preferences. The instruction is to accept what nature gives: the results, the circumstances, the limitations. Not as a consolation but as simple realistic engagement with how the world works.",
                    bullets = listOf(
                        InsightBullet("Peace in the boundary", "The peace comes not from controlling everything but from clearly knowing the boundary."),
                        InsightBullet("Full engagement without attachment", "Give your complete effort without requiring specific results.")
                    )
                )
            ),
            modernApplication = "Research on psychological wellbeing shows that people who focus on process (what they control) rather than outcome (external results) experience lower anxiety and higher life satisfaction. This pattern holds across domains from athletics to achievement.",
            closing = "Do what is yours with full commitment. Accept what is not yours with equanimity.",
            reflectionPrompt = "What are you trying to control that isn't actually in your power? Where could you focus that effort instead?"
        ),

        // q128 — Epictetus
        "q128" to QuoteInsight(
            intro = "Epictetus offers the inverse of ambition: he who has the most contentment is the richest. Not the one with the most accumulation but the one with the most satisfaction relative to what they have.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Abundance Paradox",
                    blockquote = "He has the most who is most content with the least.",
                    body = "Two people. One has wealth but constant anxiety about losing it, need for more, comparison with those who have more. Another has modest means but is satisfied. Who has the most? Not in absolute terms but in the terms that matter: autonomy, peace, freedom from grasping. The satisfied person with little has more actual wealth than the anxious person with much.",
                    bullets = listOf(
                        InsightBullet("Wealth measured rightly", "True wealth is having enough and knowing you have enough."),
                        InsightBullet("Satisfaction as achievement", "Contentment is not given. It's developed as a skill through practice.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practice of Sufficiency",
                    blockquote = "...most content with the least.",
                    body = "To develop contentment with the least, you practice gratitude for little things. You practice negative visualization — imagining loss so that what you have becomes precious. You practice redirecting desire away from accumulation and toward appreciation of what is. These practices are not spiritual luxuries — they are the practical means to the wealth of contentment.",
                    bullets = listOf(
                        InsightBullet("Skill you can build", "Contentment is not temperament—it's a learnable discipline."),
                        InsightBullet("The paradox of prosperity", "The wealthy (in contentment) can enjoy simplicity. The desperate cannot.")
                    )
                )
            ),
            modernApplication = "Well-being research consistently finds that people who practice contentment-building activities (gratitude, simplicity, mindfulness) report higher life satisfaction regardless of income level. The skill is learnable and the payoff is substantial.",
            closing = "Accumulate contentment and you'll have everything. Chase accumulation and contentment will elude you.",
            reflectionPrompt = "How much is enough? If you're honest, is your answer a number or is it 'just a bit more'? What would change if you practiced being content with less?"
        ),

        // q130 — Epictetus
        "q130" to QuoteInsight(
            intro = "Epictetus offers a simple principle about fundamental appetites: reduce eating from the status of a hobby or pursuit to a tool for survival. The body is a function to be maintained, not a pleasure garden to be tended.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Eating as Means, Not End",
                    blockquote = "Eat to live...",
                    body = "Food is necessary. The body must be fueled. But when food becomes a source of intensive pleasure-seeking — when meals are elaborate performances, when the goal is sensation rather than sustenance — eating has inverted its purpose. It's no longer a servant of life but a master of time, money, and health.",
                    bullets = listOf(
                        InsightBullet("Inversion of purpose", "When the fuel becomes the goal, the organism becomes enslaved to feeding."),
                        InsightBullet("Simple survival", "A simple meal that nourishes you is actually superior to an elaborate one that merely excites.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Not Living to Eat",
                    blockquote = "...not live to eat.",
                    body = "The life you're building — your purposes, relationships, growth, contribution — these are what's worth living for. Eating is the servant of that life. When you find yourself organizing your day around food, spending time researching meals, using eating as your main pleasure, eating has become disproportionate. The instruction is to return it to its proper place: one function among many.",
                    bullets = listOf(
                        InsightBullet("Perspective on appetite", "Appetites are real and need attending. But they're not the point of the life."),
                        InsightBullet("The freedom of simplicity", "When eating is simple and functional, energy and attention are available for what actually matters.")
                    )
                )
            ),
            modernApplication = "Research on eating for health vs. eating for pleasure shows that when food becomes primarily a source of emotional regulation or sensory experience, it often correlates with overconsumption, weight gain, and reduced physical wellbeing. Simple, functional eating correlates with better health and freer mental energy.",
            closing = "Feed your body what it needs to do what you need to do. That's all appetite requires.",
            reflectionPrompt = "What role does eating play in your life? Is it functional or has it become an end in itself? What would change if you genuinely ate to live?"
        ),

        // q131 — Marcus Aurelius
        "q131" to QuoteInsight(
            intro = "Marcus Aurelius points to a form of dishonesty that's easy to commit and hard to recognise: the attempt to appear other than what you are. The correction is simple: be content to be what you actually are, openly.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Costume of Pretence",
                    blockquote = "Be content to seem what you really are.",
                    body = "There's enormous effort spent constructing a self for external consumption — a version that's smarter, more successful, more confident, more virtuous than the actual person. This is exhausting. You must continually monitor this constructed self. You must defend it against revelation. You must adjust it as circumstances demand.",
                    bullets = listOf(
                        InsightBullet("The energy cost", "Pretence requires constant vigilance and adjustment. Authenticity requires only honesty."),
                        InsightBullet("The isolation effect", "The more carefully you construct a false image, the further you are from genuine connection.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Freedom of Authenticity",
                    blockquote = "...what you really are.",
                    body = "There is a profound relief available: stop trying to seem and simply be. The actual you — with limitations, failures, quirks, uncertainties — is infinitely less demanding to maintain than any construction. And here's the surprise: people connect with actual people far more than with images. Authenticity is magnetic. Pretence is exhausting for everyone.",
                    bullets = listOf(
                        InsightBullet("Genuine presence", "The person who shows up as they are is more powerful than the person performing."),
                        InsightBullet("The paradoxical safety", "Ironically, being vulnerable is often safer than defending an image.")
                    )
                )
            ),
            modernApplication = "Research on authenticity and social connection shows that people who present authentically report higher life satisfaction and deeper relationships. Paradoxically, perceived authenticity increases credibility and likeability more than careful image management.",
            closing = "Stop performing who you think you should be. The relief of simply being yourself is available immediately.",
            reflectionPrompt = "What image are you spending energy maintaining? What would become possible if you stopped and showed up as you actually are?"
        ),

        // q132 — Marcus Aurelius
        "q132" to QuoteInsight(
            intro = "Marcus Aurelius warns against a specific form of waste: speech that consumes time and energy without providing nourishment. Not just silence but purposeful silence — or speech with substance.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Speech Without Nourishment",
                    blockquote = "Do not indulge in speech that consumes without nourishing.",
                    body = "Think of conversation that fills time but imparts nothing. Gossip, complaint, rumination, small talk that never reaches sincerity. These consume — they take your time and energy — but they don't nourish. They don't create insight, connection, growth, or understanding. They leave you the same as they found you.",
                    bullets = listOf(
                        InsightBullet("Consumption without value", "Time is your rarest resource and consuming it without nourishment is perhaps the most wasteful mistake."),
                        InsightBullet("The illusion of connection", "Endless talking can masquerade as connection without creating any actual bond.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Speech That Nourishes",
                    blockquote = "...nourishing.",
                    body = "Speech nourishes when it clarifies, teaches, creates understanding, deepens connection, or moves something important forward. Not every moment requires speech. Sometimes the nourishing choice is considered silence. When speech comes, let it earn its place.",
                    bullets = listOf(
                        InsightBullet("Silence as speech", "Often what nourishes most is what is not said — the space for others to think, feel, be heard."),
                        InsightBullet("Quality over quantity", "One true sentence can nourish more than hours of empty talk.")
                    )
                )
            ),
            modernApplication = "Research on conversation quality and wellbeing shows that meaningful conversation increases psychological wellbeing while empty small talk provides no benefit. The distinction between consumption and nourishment in speech is real and measurable.",
            closing = "Before you speak, ask: will this nourish? If not, you're spending what cannot be recovered.",
            reflectionPrompt = "What percentage of your conversation is truly nourishing? What would change if you spoke less but with more substance?"
        ),

        // q133 — Seneca
        "q133" to QuoteInsight(
            intro = "Seneca makes a striking claim: it's enough — sufficient — if every person considers themselves poor with respect to time. This single perspective shift would reorder priorities entirely.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Only Real Poverty",
                    blockquote = "It is enough if each man thinks himself poor only in respect of time.",
                    body = "A person wealthy in money but poor in time is actually poor. A person with little money but abundant time — or at least the view that time is the scarcity — has the important priority correct. The irony is that perceiving yourself as poor in time (the actual scarcity) creates wealthy decisions, while perceiving yourself as poor in money (which is abundant relative to time) creates poor decisions.",
                    bullets = listOf(
                        InsightBullet("The hierarchy of poverty", "Money poverty is recoverable. Time poverty is not. And yet we often treat them in reverse."),
                        InsightBullet("Perception as correction", "Just thinking of yourself as time-poor would redirect most misguided choices about spending.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Reorientation",
                    blockquote = "...only in respect of time.",
                    body = "If you genuinely believe you are poor in time, you make different choices. You refuse time-wasting activities. You avoid accumulating obligations. You spend time on what actually matters. You notice that selling your time for money you don't need effectively makes you poor. Seneca is suggesting: if everyone had this single accurate self-assessment, almost all poor financial and life decisions would vanish.",
                    bullets = listOf(
                        InsightBullet("The leverage point", "A single shift in perception — one true belief about scarcity — reorders an entire life."),
                        InsightBullet("The practical test", "Ask yourself: would my choices be different if I truly believed time is my only scarcity?")
                    )
                )
            ),
            modernApplication = "Time allocation research shows that people's actual happiness correlates far more with how they allocate time than with absolute income. Yet most decisions treat money as the scarce resource and time as abundant. Seneca's perspective is empirically superior.",
            closing = "You are poor in time. Behave accordingly.",
            reflectionPrompt = "How would your choices change if you truly accepted that time is your only scarcity? What are you currently spending time on that you wouldn't if you felt genuinely time-poor?"
        ),

        // q134 — Seneca
        "q134" to QuoteInsight(
            intro = "Seneca offers a paradox that resolves only through practice: live as though this is your last day (which makes you act decisively on what matters) while learning as though you'll live forever (which makes you invest in growth that transcends any single day).",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Die Tomorrow, Live Today",
                    blockquote = "Live as if you were to die tomorrow.",
                    body = "This is the memento mori perspective: assume today is your last. What would change? You'd stop the petty grievances. You'd tell people what they mean to you. You'd do the meaningful work. You'd be present. This assumption makes you live more consciously, more aligned with actual values.",
                    bullets = listOf(
                        InsightBullet("Urgency breeds clarity", "The temporary illusion of finality cuts through distractions with remarkable precision."),
                        InsightBullet("The reality check", "Most regrets are about things not done when they could have been. This assumption prevents that.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Live Forever, Learning Today",
                    blockquote = "Learn as if you were to live forever.",
                    body = "Simultaneously, approach learning and growth as though you'll have unlimited time to use what you learn. Don't dismiss knowledge as impractical. Don't avoid studying what you're curious about. Don't stop developing capabilities. Because wisdom compounds. Understanding you gain now affects how you understand later.",
                    bullets = listOf(
                        InsightBullet("The paradox resolved", "Die today (act on what matters), live forever (invest in growth). Both are true and both inform your life."),
                        InsightBullet("The temporal vertigo", "You don't know which assumption applies to you. So you honor both.")
                    )
                )
            ),
            modernApplication = "People who maintain both perspectives — awareness of mortality and openness to growth — report the highest life satisfaction and engagement. The seeming contradiction is resolved in practice through balancing action with learning.",
            closing = "Act today like it's your last day. Learn today like it's your first of many more to come.",
            reflectionPrompt = "If today were your last, what would be undone? If you had infinite time, what would you learn? Can you do both?"
        ),

        // q135 — Seneca
        "q135" to QuoteInsight(
            intro = "Seneca makes a precise claim: knowledge is not mere intellectual accumulation. It is added power. What you know and understand expands what you can do.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Knowledge as Capability",
                    blockquote = "Every addition to true knowledge is an addition to human power.",
                    body = "Notice 'true knowledge' — not mere facts or information, but genuine understanding. When you understand how something works, possibilities expand. When you understand yourself better, your agency increases. When you understand others, your influence grows. Knowledge isn't theoretical — it's the mechanism by which you become more capable.",
                    bullets = listOf(
                        InsightBullet("The practical dimension", "Knowledge is not separated from action. It's the foundation of action."),
                        InsightBullet("The compounding effect", "Each new understanding builds on previous understanding, making each new piece of knowledge more valuable.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Investment in Self",
                    blockquote = "...addition to human power.",
                    body = "This reframes learning as not a luxury but a strategic investment. The person who stops learning has stopped expanding their power. The person who continues learning continuously gains new capabilities. In a world that changes, the power to understand and adapt is the power that endures.",
                    bullets = listOf(
                        InsightBullet("Power through understanding", "True power is never coercive—it's the power of understanding that allows better action."),
                        InsightBullet("The lifelong project", "Your power is not fixed at birth or education's end. It expands with each genuine addition to knowledge.")
                    )
                )
            ),
            modernApplication = "Neuroplasticity research shows that learning literally rewires the brain, creating new neural pathways that enable new capabilities. Seneca's metaphor matches current neuroscience: knowledge is the mechanism by which power grows.",
            closing = "Each new understanding is not decoration—it's infrastructure for greater capability.",
            reflectionPrompt = "What knowledge have you gained that genuinely expanded your power? What knowledge are you pursuing now that will increase your capability?"
        ),

        // q136 — Seneca
        "q136" to QuoteInsight(
            intro = "Seneca suggests a radical move: leave society temporarily. Retreat from the noise, expectations, and social friction. Live with yourself. This is not running away but a form of restoration.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Need for Withdrawal",
                    blockquote = "Retire from the world and live with yourself.",
                    body = "Constant engagement with the world — with others' demands, expectations, judgments — drowns out your own voice. In the cacophony, you lose touch with who you actually are and what you actually value. Seneca suggests: step out. Not forever, but long enough to remember what your own company is like.",
                    bullets = listOf(
                        InsightBullet("Solitude as restoration", "Time alone is not isolation—it's restoration of contact with yourself."),
                        InsightBullet("The difference restored", "Only in solitude do you notice what you think versus what you've been taught to think.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Living With Yourself",
                    blockquote = "...with yourself.",
                    body = "What does it mean to live with yourself? To be company to yourself. To know your own mind. To be comfortable in your own presence. Most people have not developed this. We fill silence with noise. We escape ourselves through distraction. But this is an atrophied capacity that can be restored through practice.",
                    bullets = listOf(
                        InsightBullet("Restoration through solitude", "Spend time alone without distraction and you remember who you are beneath the social performance."),
                        InsightBullet("The foundation of freedom", "You cannot be free in the world until you're free in solitude.")
                    )
                )
            ),
            modernApplication = "Research on solitude shows that time alone — without distraction — increases self-awareness, creativity, and psychological resilience. For many, learning to be alone without loneliness is the achievement that enables everything else.",
            closing = "You cannot live well with others until you've learned to live well with yourself. Retire to remember.",
            reflectionPrompt = "How comfortable are you with solitude? What happens when you remove distraction? What would you learn about yourself if you did?"
        ),

        // q137 — Seneca (Already covered as q125, but this is the full quote)
        "q137" to QuoteInsight(
            intro = "Seneca repeats this truth a third time because it requires that iteration: all things are alien to you. Your possessions, your status, your accomplishments—none are inherently yours. The only response is to hold them lightly and invest in what cannot be taken.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Alienness Made Clear",
                    blockquote = "Omnia aliena sunt — All things are alien to us.",
                    body = "The word 'alien' is precise. Not 'temporary' but 'foreign.' Not yours. As if you're carrying them on behalf of someone else. This is actually the truth: you hold everything on loan from time and circumstance. The clearer you see this, the less sting loss carries.",
                    bullets = listOf(
                        InsightBullet("Clarity as prevention", "When you see clearly that nothing is yours to keep, you're less devastated when it departs."),
                        InsightBullet("Alienness as freedom", "If nothing is yours, you can't really lose anything—or you lose nothing that was ever truly yours.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "What This Produces",
                    blockquote = "...are alien to us.",
                    body = "This isn't nihilism. Seneca isn't saying don't care for what you have. Care for it excellently—as a steward cares for what belongs to another. But without clinging. This produces a freedom: to act without attachment, to hold without desperation, to release without trauma.",
                    bullets = listOf(
                        InsightBullet("Stewardship, not ownership", "Care for what you have as if it belongs to the universe—which it does."),
                        InsightBullet("The resulting peace", "Once you release the illusion of ownership, peace arrives.")
                    )
                )
            ),
            modernApplication = "Attachment theory and Buddhism both converge on Seneca's insight: the illusion of permanent ownership causes suffering. Accepting impermanence and trusting in our capacity to flow with change produces psychological freedom.",
            closing = "Hold everything you have as if you're caring for it on behalf of the future. Because you are.",
            reflectionPrompt = "What possession do you grip most tightly? What would happen if you genuinely accepted that you're simply a temporary steward of it?"
        ),

        // q138 — Epictetus
        "q138" to QuoteInsight(
            intro = "Epictetus asks a negotiating question disguised as moral philosophy: at what cost does one sell integrity? This assumes integrity has a price — which it does if you're willing to sell it. Which you might be. The question forces you to notice.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Negotiation",
                    blockquote = "Consider at what price you sell your integrity.",
                    body = "Most compromises aren't made at the moment of choice. They're made through a series of small negotiations. You bend a principle slightly for advancement. You tell a small lie to avoid conflict. You act against your values for convenience. And then gradually you notice: you sold your integrity—you're just doing it in increments.",
                    bullets = listOf(
                        InsightBullet("The incremental surrender", "We rarely sell integrity all at once. We auction it piecemeal until nothing is left."),
                        InsightBullet("The price awareness", "Epictetus wants you to see the price clearly — then to decide if you're willing to pay it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Pricelessness",
                    blockquote = "...your integrity.",
                    body = "The unstated premise is: integrity should have no price. Or rather, its price should be infinity—it should not be for sale. Which means zero temptation or compromise is acceptable. When you know this, what previously seemed like a dilemma becomes clear: you either have integrity or you don't.",
                    bullets = listOf(
                        InsightBullet("Clarity through absolutes", "The moment you decide integrity is not for sale at any price, decisions simplify dramatically."),
                        InsightBullet("The ironic profit", "People who refuse to sell integrity often end up with more freedom and opportunity than those who did.")
                    )
                )
            ),
            modernApplication = "Research on moral decision-making shows that people with clear ethical boundaries experience less internal conflict and make faster, clearer decisions. The person who has decided their integrity is not for sale operates with remarkable freedom.",
            closing = "Name your price for integrity and you'll know immediately whether your answer changes your life.",
            reflectionPrompt = "At what price would you compromise your core values? If the price is 'no price,' are you actually living that way?"
        ),

        // q139 — Epictetus
        "q139" to QuoteInsight(
            intro = "Epictetus offers a psychological law: satisfaction is not relative to what you have, but to your internal orientation. A person satisfied with little will be satisfied with nothing — meaning they cannot be satisfied. A person never satisfied will remain unsatisfied regardless.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Law of Satisfaction",
                    blockquote = "He who is not satisfied with a little...",
                    body = "The person who cannot be satisfied with little has no mechanism for satisfaction. They have trained themselves to always want more. So more never arrives (or arrives and is immediately insufficient). This is a stable state: permanent dissatisfaction is produced by the inability to be satisfied with what is.",
                    bullets = listOf(
                        InsightBullet("The mechanism of dissatisfaction", "Dissatisfaction is self-reinforcing. Wanting creates the condition for further wanting."),
                        InsightBullet("The trap of conditionality", "As long as satisfaction is conditional ('if only I had X'), satisfaction is always deferred.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Alternative Path",
                    blockquote = "...is satisfied with nothing.",
                    body = "The reverse is equally true: a person who has learned to be satisfied with little carries this capacity everywhere. If your bar for satisfaction can be low, you're satisfied often. This is not resignation — it's freedom. The person satisfied with little can enjoy abundance without becoming enslaved to it.",
                    bullets = listOf(
                        InsightBullet("The trainable capacity", "Satisfaction is not fixed temperament. It's a habit you can build."),
                        InsightBullet("The portable peace", "People who are satisfied with little are satisfied everywhere. They carry their contentment with them.")
                    )
                )
            ),
            modernApplication = "Research on hedonic adaptation and life satisfaction confirms Epictetus: ability to appreciate what you have (rather than comparing to what you lack) is the reliable predictor of wellbeing across income levels.",
            closing = "Satisfaction with little is freedom. Dissatisfaction with much is a prison you've built yourself.",
            reflectionPrompt = "Can you be satisfied with what you have right now? If not, what would need to change—externally or internally?"
        ),

        // q140 — Cato
        "q140" to QuoteInsight(
            intro = "Cato elevates moderation itself: not just one virtue among others, but the highest. This suggests that moderation is not restraint imposed on you but the crowning achievement of a life well-directed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Moderation as Mastery",
                    blockquote = "Moderation is the highest virtue.",
                    body = "Moderation is not mediocrity. It's the intelligence to know what serves you and what doesn't. It's the power to resist the pull of excess. It's the judgment to want what is good rather than what is merely available. The moderate person — who eats well but not obsessively, who enjoys but doesn't enslave themselves, who has but doesn't cling — is actually the most powerful person.",
                    bullets = listOf(
                        InsightBullet("Power through restraint", "The person who can say no is more powerful than the person who says yes to everything."),
                        InsightBullet("The sophisticated capacity", "Moderation requires more judgment and self-knowledge than excess.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Why It's Highest",
                    blockquote = "...the highest virtue.",
                    body = "Moderation is highest because it coordinates all the other virtues. Courage without moderation becomes recklessness. Wisdom without moderation becomes pedantry. Justice without moderation becomes harshness. Moderation is the virtue that makes the other virtues beneficial rather than distorted.",
                    bullets = listOf(
                        InsightBullet("The integrating virtue", "Moderation is not alongside the virtues—it's what makes them work together."),
                        InsightBullet("The sustainable choice", "What is moderate can be sustained. What is extreme exhausts itself.")
                    )
                )
            ),
            modernApplication = "Research on self-control and wellbeing consistently finds that people with strong moderation (ability to regulate impulse and desire) report higher life satisfaction, better health, stronger relationships, and greater achievement.",
            closing = "All other virtues are refined through moderation. All other vices are enabled by its absence.",
            reflectionPrompt = "Where in your life do you lack moderation? What virtues have become vices through excess?"
        ),

        // q141 — Seneca
        "q141" to QuoteInsight(
            intro = "Seneca offers mercy: the possibility of becoming what you didn't become, if you choose to now. Time wasted cannot be recovered, but time remaining can be used differently.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Regret Perspective",
                    blockquote = "It is never too late to be what you might have been.",
                    body = "There's a version of yourself — someone wiser, bolder, kinder, more aligned with your values — that you might have become if you'd chosen differently earlier. Regret is looking backward at that possibility. But Seneca offers something beyond regret: it is not too late to become that person now.",
                    bullets = listOf(
                        InsightBullet("The pivot point", "Every moment is the beginning of the rest of your life. What you weren't earlier doesn't determine what you are now."),
                        InsightBullet("The power in now", "You cannot change the past, but you can change the present and therefore the future.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Actually Available Path",
                    blockquote = "...what you might have been.",
                    body = "This isn't therapy-speak or false comfort. It's practical: the version of you that you might have been if you'd chosen differently — the key traits, values, capabilities — are still available. Choose them now. Start now. Become now. The years lost cannot be recovered, but the person you can still become is not diminished because you started late.",
                    bullets = listOf(
                        InsightBullet("Redemption in action", "The person who begins again at sixty is more admirable than the person who never began at all."),
                        InsightBullet("Time relative to purpose", "How late you start matters far less than whether you start.")
                    )
                )
            ),
            modernApplication = "Research on life change and self-transformation shows that people can shift their lives and identities substantially even late in life. The brain retains plasticity. Habits can be changed. Directions can shift.",
            closing = "The you that you might have been is still you. Become them starting now.",
            reflectionPrompt = "What version of yourself do you regret not becoming? What would it take to start becoming them today?"
        ),

        // q142 — Epictetus
        "q142" to QuoteInsight(
            intro = "Epictetus offers practical wisdom about damage control: if you're going to make a mistake, prefer the mistake that damages only your body over the mistake that damages your character. The tongue damages character.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Distinction",
                    blockquote = "Better to trip with the feet than with the tongue.",
                    body = "A stumble with your feet is a physical mistake — embarrassing perhaps, but confined. You fall, you get up. But a stumble with the tongue — a false word, a cruelty, a lie, a betrayal spoken — damages something lasting. The word gets out. The trust is broken. The character is strained.",
                    bullets = listOf(
                        InsightBullet("Damage scope", "Physical mistakes are recoverable. Words create lasting impressions."),
                        InsightBullet("The permanence of speech", "You can bandage a wound. You cannot unsay a word.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practice",
                    blockquote = "...with the tongue.",
                    body = "This suggests a discipline: if you must err, let your error be in the physical realm. Avoid the mouth errors. Think before speaking. Choose silence when you're tempted to speak falsely. Choose kindness when you might speak cruelty. The tongue requires more careful management than the feet.",
                    bullets = listOf(
                        InsightBullet("Prevention", "The easier path is not speaking carelessly to begin with. Much easier than managing the aftermath."),
                        InsightBullet("The guard at the gate", "Every word has a chance to be questioned before it leaves. Once it's out, it's gone.")
                    )
                )
            ),
            modernApplication = "Research on words' effects shows that harsh speech has measurable effects on both the speaker (stress, guilt, damaged relationships) and the listener (hurt, defensive posturing, damaged trust). Epictetus's preference is supported by evidence.",
            closing = "Your feet might stumble. Your tongue is more dangerous. Guard it accordingly.",
            reflectionPrompt = "When have your own words damaged something important? What pause could you have introduced that would have changed the outcome?"
        ),

        // q143 — Seneca
        "q143" to QuoteInsight(
            intro = "Seneca draws a parallel between physical and mental strength: as labour develops the body, difficulty develops the mind. This is not suffering celebrated for its own sake, but difficulty recognised as the mechanism of growth.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Muscle and the Mind",
                    blockquote = "Difficulties strengthen the mind, as labor does the body.",
                    body = "The body doesn't grow through rest—it grows through resistance. Muscles develop by being challenged. The mind works identically. It doesn't strengthen through comfort and certainty. It's forged through difficulty, confusion, and struggle against problems larger than previous problems.",
                    bullets = listOf(
                        InsightBullet("The parallel system", "Both body and mind have the same design: challenge produces strength."),
                        InsightBullet("The growth requirement", "Without difficulty, neither the body nor mind develops.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Correct Response",
                    blockquote = "...as labor does the body.",
                    body = "This reframes difficulty: it's not something to avoid but to welcome. The harder the problem, the more the mind develops in solving it. The person who avoids challenges remains weak. The person who seeks them out, proportional to their current capacity, becomes formidable.",
                    bullets = listOf(
                        InsightBullet("The voluntary growth path", "Seeking challenges appropriate to your current level is how you become stronger."),
                        InsightBullet("The unexpected gift", "Difficulties that arrive unbidden are free growth opportunities if you engage them.")
                    )
                )
            ),
            modernApplication = "Neuroscience research on learning and neuroplasticity confirms that challenge (at the right level—not overwhelming) is the mechanism by which the brain rewires and develops new capabilities. The 'testing effect' is well-documented.",
            closing = "Your difficulties are your development. The harder the problem, the stronger you'll be for solving it.",
            reflectionPrompt = "What current difficulty could you reframe as an opportunity for mental development? What new capacity might it build in you?"
        ),

        // q144 — Seneca
        "q144" to QuoteInsight(
            intro = "Seneca makes an interesting claim: we are lazier in mind than in body. The body will move if prompted. The mind resists growth, learning, and difficult thinking more stubbornly than the body resists physical labour.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Sloth of Mind",
                    blockquote = "We are lazier in mind than in body.",
                    body = "You might be willing to run a marathon (body exertion) yet deeply resistant to changing your mind about a held belief (mind exertion). You might labor physically yet refuse the harder work of examining your assumptions. The mental exertion often meets more resistance than the physical.",
                    bullets = listOf(
                        InsightBullet("The asymmetry", "Physical effort feels like strain but produces results you can see. Mental effort is more subtle and feels less productive."),
                        InsightBullet("The seduction of certainty", "The mind prefers to settle into what it already believes rather than exert itself in examination.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Correction",
                    blockquote = "...in body.",
                    body = "This suggests that mental discipline is the rarer and more important discipline. Your body will follow orders if given. Your mind requires more coaxing. The practice is to deliberately exercise the mind: studying philosophy, examining assumptions, wrestling with difficult ideas, changing your mind in light of evidence.",
                    bullets = listOf(
                        InsightBullet("The harder discipline", "Mental flexibility and growth require more deliberate practice than physical fitness."),
                        InsightBullet("The payoff", "A disciplined mind transforms everything. A strong body is secondary.")
                    )
                )
            ),
            modernApplication = "Research on cognitive biases and belief perseverance shows that the mind actively resists changing established beliefs, even in light of contradicting evidence. Seneca's observation is supported by cognitive science.",
            closing = "You know how to make your body work. The question now is: how will you make your mind work?",
            reflectionPrompt = "What belief do you hold that you've never seriously questioned? What would it take to examine it with genuine intellectual effort?"
        ),

        // q145 — Epictetus
        "q145" to QuoteInsight(
            intro = "Epictetus offers a tautology that cuts through all theory and excuse: if you wish to be a writer, write. The doing is the becoming. There is no path to the destination that doesn't involve the action itself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Identity Through Action",
                    blockquote = "If you wish to be a writer, write.",
                    body = "People speak of their aspirations as though they're separate from their actions. 'I want to be a writer' while not writing. 'I want to be brave' while avoiding challenge. But identity is not aspiration — it's accumulated action. You become a writer by writing. You become brave by acting courageously.",
                    bullets = listOf(
                        InsightBullet("The elimination of separation", "there is no path to becoming a writer except through writing. No substitute, no preparation phase that substitutes for the doing."),
                        InsightBullet("The directness", "The most efficient path to your destination is the direct path: do what the thing requires.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Myth of Readiness",
                    blockquote = "...write.",
                    body = "People wait to feel ready. But readiness comes through doing, not before. The writer who waits until she feels like a real writer will never write. The person who writes (however imperfectly) becomes a writer. The doing precedes the identity. You don't wait to be ready—you become ready through being.",
                    bullets = listOf(
                        InsightBullet("Readiness emerges in action", "You can't be ready before you start. You become ready by starting."),
                        InsightBullet("The permission you're waiting for", "You don't need permission or readiness. You need to do the thing.")
                    )
                )
            ),
            modernApplication = "Identity theory research shows that identity is constructed through repeated behaviour, not the reverse. You don't become a writer by identifying as one—you identify as one because you write.",
            closing = "The person you want to become is created through the actions of that person. Start acting and you'll become who you aspire to be.",
            reflectionPrompt = "What identity do you aspire to that you're not yet embodying through action? What single action would make you that person today?"
        ),

        // q146 — Marcus Aurelius
        "q146" to QuoteInsight(
            intro = "Marcus Aurelius reframes achievement: the greatest thing is not the grand accomplishment but the small thing done with excellence. Perfection in the small. Mastery in the modest.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The False Measure of Greatness",
                    blockquote = "The greatest thing is the small thing done well.",
                    body = "We confuse scale with significance. A grand thing done poorly is not great. A small thing done excellently is. The daily ritual performed with care. The ordinary task executed with mastery. These are greater than the ambitious project done half-heartedly.",
                    bullets = listOf(
                        InsightBullet("Quality over ambition", "Excellence at scale 1 is greater than mediocrity at scale 1000."),
                        InsightBullet("The available mastery", "You can achieve mastery in small things today. Mastery in large things requires luck and circumstance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Practice of Excellence",
                    blockquote = "...done well.",
                    body = "This is an antidote to paralysis. You cannot do the great thing. The circumstances, opportunities, and abilities required are not yours. But the small thing — the email written carefully, the cup of tea prepared thoughtfully, the brief conversation held with full attention — these are entirely within your power. Master these and you'll have mastered the greatest thing available to you.",
                    bullets = listOf(
                        InsightBullet("Available achievement", "The greatest thing you can do is the small thing in front of you, done excellently."),
                        InsightBullet("The compounding effect", "A life of small things done well compounds into something great.")
                    )
                )
            ),
            modernApplication = "Flow state research shows that mastery produces the most sustaining form of satisfaction. Mastery is achievable in small domains. Excellence at any scale produces wellbeing.",
            closing = "Do not wait for the great thing. Master the small things in front of you.",
            reflectionPrompt = "What small thing in your life could you do with complete excellence today? What would change if you did?"
        ),

        // q147 — Cato
        "q147" to QuoteInsight(
            intro = "Cato makes a value judgment: restraint in all things is worth more than brilliance in any one thing. The generalist who is moderate everywhere is greater than the specialist who excels in one domain while unraveling in another.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Seduction of Brilliance",
                    blockquote = "Restraint in all things is a greater virtue than brilliance in any one thing.",
                    body = "Brilliance is attractive. A person brilliant at their work but reckless in their personal life, kind to some and cruel to others, generous in public but petty in private—this person is fragmented. The greatness that shows up in one domain disappears in another. This is not integrity.",
                    bullets = listOf(
                        InsightBullet("The cost of brilliance", "Brilliance concentrated in one area often comes at the expense of balance."),
                        InsightBullet("Fragmentation as failure", "Excellence that doesn't extend across life's domain is incomplete excellence.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Integrity of Restraint",
                    blockquote = "...in any one thing.",
                    body = "Restraint that applies everywhere — in ambition, appetite, anger, claiming credit, seeking pleasure — creates a coherent person. Not spectacular in any one area but reliable everywhere. This is the greater virtue because it shows integrated character.",
                    bullets = listOf(
                        InsightBullet("Wholeness over highlights", "The person moderate in all things is more admirable than the person brilliant in fragments."),
                        InsightBullet("The trust that builds", "People trust the moderate person everywhere. The brilliant person only in their domain of brilliance.")
                    )
                )
            ),
            modernApplication = "Research on integrity and leadership shows that consistency across domains—behaving according to values in all contexts—is the most reliable predictor of trust and sustainable success.",
            closing = "Brilliance in one area doesn't matter if you're reckless in others. Restraint everywhere matters more.",
            reflectionPrompt = "Where are you brilliant? And where do you abandon restraint? What would it take to extend your virtue to those domains?"
        ),

        // q148 — Cato
        "q148" to QuoteInsight(
            intro = "Cato describes a paradox resolved: the frugal person, even while hungry, doesn't demand more than is appropriate. This person has developed an internal measure of propriety that constrains even basic appetite.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Hunger Versus Propriety",
                    blockquote = "The frugal man, though hungry, does not ask for more than what is fitting.",
                    body = "Hunger is a real physical need. Yet the frugal person doesn't let hunger override judgment about what's appropriate. They're willing to remain slightly hungry rather than take too much. This isn't deprivation—it's the application of reason even to physical appetite.",
                    bullets = listOf(
                        InsightBullet("Reason over appetite", "The ability to remain slightly uncomfortable rather than violate principle is the mark of the frugal person."),
                        InsightBullet("The internal constraint", "The frugal person doesn't need external rules. They apply principle even when no one is watching.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Wisdom of Restraint",
                    blockquote = "...what is fitting.",
                    body = "There is a measured amount that 'fits.' Not zero—that would be denial. Not unlimited—that would be excess. The fitting amount. The frugal person has internalized what is appropriate and conducts themselves according to it regardless of circumstances.",
                    bullets = listOf(
                        InsightBullet("The internal compass", "True frugality is not about how little you can take. It's about knowing what's fitting and stopping there."),
                        InsightBullet("The sustainable path", "The person who takes only what's fitting in small things maintains this proportion in larger ones.")
                    )
                )
            ),
            modernApplication = "Research on self-control and willpower shows that practicing restraint in small domains (food intake, spending, impulse satisfaction) strengthens the capacity for restraint in larger domains.",
            closing = "The frugal person's hunger doesn't change. Their principle does.",
            reflectionPrompt = "Where do you allow appetite to override propriety? What would change if you developed the discipline to take only what's fitting?"
        ),

        // q149 — Epictetus
        "q149" to QuoteInsight(
            intro = "Epictetus suggests that moderation — specifically, keeping the middle way — is not just a virtue but the foundation upon which other wisdom rests. Remove this foundation and everything else becomes unstable.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Extreme Pull",
                    blockquote = "In moderation keeping the middle way is the foundation of wisdom.",
                    body = "Extremes are attractive. If a little virtue is good, more must be better. If some restraint is wise, complete deprivation must be wiser. But this is a trap. The extremes collapse. The person who goes to extremes in any direction becomes imbalanced.",
                    bullets = listOf(
                        InsightBullet("The instability of extremes", "Extremes are unsustainable. They create reaction and backlash."),
                        InsightBullet("The seduction", "Extremes feel like commitment. But they're often just imbalance dressed as dedication.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Stable Middle",
                    blockquote = "...the middle way...",
                    body = "The middle way — moderation, restraint, appropriate measure — is stable. It can be sustained indefinitely. It's not flashy or extreme but it's enduring. And from this stability, all other wisdom grows. Without this foundation — without the capacity to stay in the middle — everything else that's built topples.",
                    bullets = listOf(
                        InsightBullet("Foundation and structure", "Wisdom without moderation is unstable. Moderation is what allows wisdom to endure."),
                        InsightBullet("The long view", "What lasts is what's moderate. What's extreme eventually collapses.")
                    )
                )
            ),
            modernApplication = "Research on habit formation and sustainable change shows that moderate approaches are far more sustainable than extreme ones. Forty-year studies of change show that modest, consistent practices outperform dramatic transformations.",
            closing = "Stay in the middle way and everything else that's wise can be built on that foundation.",
            reflectionPrompt = "Where are you pulled toward extremes? What would it look like to find and stay in the middle way?"
        ),

        // q150 — Marcus Aurelius
        "q150" to QuoteInsight(
            intro = "Marcus Aurelius addresses a fundamental habit: the tendency to focus on what you lack rather than what you have. The correction is simple and difficult: deliberately shift attention toward presence and possession.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Default Focus",
                    blockquote = "Let not your mind run on what you lack...",
                    body = "Notice what catches your attention naturally. The mind tends toward the deficit. What am I missing? What do I want? What's wrong? This is a protective mechanism, but it's also a trap. Your attention is finite. When it fixates on lack, it cannot see what you have.",
                    bullets = listOf(
                        InsightBullet("The attention economy", "Your mind can't examine lack and simultaneously appreciate presence. One must give way to the other."),
                        InsightBullet("The self-created scarcity", "The focus on lack creates a felt scarcity regardless of actual abundance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Deliberate Redirection",
                    blockquote = "...as much as on what you have already.",
                    body = "This is a discipline, not a permanent state. The mind will drift toward lack. Your practice is to notice and redirect. Deliberately attend to what you have already. Not in denial of lack, but in acknowledgement that both exist and attention is a choice.",
                    bullets = listOf(
                        InsightBullet("The practice of gratitude", "Attention to what you have is not naive optimism. It's accurate perception of abundance that's also present."),
                        InsightBullet("The shift in felt reality", "Where attention goes, felt reality follows. Attend to abundance and you feel abundant.")
                    )
                )
            ),
            modernApplication = "Research on attention and wellbeing shows that where you direct attention literally changes your neurological experience of abundance or scarcity. Gratitude practices measurably increase perceived wellbeing.",
            closing = "Let your mind linger on what you have. This is not denial but accurate attention to your actual situation.",
            reflectionPrompt = "Right now, what are you attending to more—what you lack or what you have? What would shift in your experience if you deliberately attended to what you have?"
        ),

        // q150 — Epictetus
        "q150" to QuoteInsight(
            intro = "In a culture built on the premise that more is better — more wealth, more options, more experiences, more followers — Epictetus offers a direct counterargument. Happiness, he says, is not an acquisition problem. It is a perception problem. And the solution is not to get more; it is to want differently.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Wrong Search",
                    blockquote = "The secret of happiness, you see, is not found in seeking more...",
                    body = "The pursuit of more has a structural flaw: it relocates the finish line. You reach the salary you wanted and discover you need a higher one. You achieve the goal and find the satisfaction is brief. This is not weakness of character — it is how the reward system works. It evolved to keep you wanting, not to keep you satisfied.",
                    bullets = listOf(
                        InsightBullet("The hedonic treadmill", "Psychologists call it adaptation: we return to a baseline of happiness regardless of what we gain or lose."),
                        InsightBullet("The trap", "Believing that the next acquisition will finally do it — when the mechanism itself ensures it never will.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Capacity to Enjoy Less",
                    blockquote = "...but in developing the capacity to enjoy less.",
                    body = "This is the Stoic inversion. Instead of expanding what you have to meet your desires, you train your desires to meet what you have. This is not resignation — it is a skill. The capacity to find richness in simple things, to feel the full weight of what you already possess, is one of the rarest and most durable forms of happiness available.",
                    bullets = listOf(
                        InsightBullet("Negative visualisation", "Epictetus and the Stoics practised imagining losing what they had — not to be gloomy, but to sharpen their appreciation of it."),
                        InsightBullet("Sufficiency", "The question is not \"do I have enough?\" — it is \"have I developed the capacity to feel that I have enough?\"")
                    )
                )
            ),
            comparisonTable = InsightTable(
                leftHeader = "The Accumulation Path",
                rightHeader = "The Stoic Path",
                rows = listOf(
                    "Happiness = having more than you currently have." to "Happiness = fully experiencing what you currently have.",
                    "Satisfaction is always deferred." to "Satisfaction is available now.",
                    "Desire is a problem to be solved by acquisition." to "Desire is a habit to be trained by attention."
                )
            ),
            modernApplication = "Minimalism, mindfulness, and gratitude practices have all arrived at the same destination Epictetus pointed to two thousand years ago. The research on gratitude in particular is robust: regularly noticing and naming what you have — not as a performance, but as a genuine exercise in attention — measurably increases wellbeing. The capacity Epictetus describes is real, and it can be built.",
            closing = "Contentment is not the reward for getting everything you want. It is what remains when you stop needing everything you don't have.",
            reflectionPrompt = "What do you already have — relationships, capabilities, simple pleasures — that you have stopped fully noticing? What would it feel like to experience one of those things today as if for the first time?"
        ),

        // ── Archive-only quotes (q151–q165) ────────────────────────────────────

        // q151 — Marcus Aurelius
        "q151" to QuoteInsight(
            intro = "Marcus Aurelius challenges the idea of predetermined paths. Many people wait for the path to be clear before acting. But for the person ready to move, the path itself is created by moving. You are not discovering a path — you are making one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Illusion of the Pre-made Path",
                    blockquote = "Do not go where the path may lead; go instead where there is no path...",
                    body = "The well-worn path is safe but circuitous. It's the path others have walked, which means it serves others' destinations, not necessarily yours. The person waiting for the path to appear will wait indefinitely. Or will end up walking someone else's path, wondering why it doesn't feel right.",
                    bullets = listOf(
                        InsightBullet("Safety vs. alignment", "The clear path is safe but may be misaligned with your purpose."),
                        InsightBullet("The comfort trap", "Waiting for clarity can become another word for fear.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Creating as You Go",
                    blockquote = "...and leave a trail.",
                    body = "When you move into unmapped territory, you leave a trail. Your movement becomes the path. This is leadership in its truest form — not following, but pioneering. And here's the paradox: the trail you leave becomes the path for others. In acting without a pre-made path, you create one.",
                    bullets = listOf(
                        InsightBullet("Pioneer vs. follower", "You can choose to be the one who creates clarity or the one who waits for it."),
                        InsightBullet("Your legacy is your trail", "The path you forge becomes guidance for those who come after.")
                    )
                )
            ),
            modernApplication = "Research on agency and self-efficacy shows that people who view themselves as capable of creating their life (rather than waiting for it to happen) have dramatically higher achievement, resilience, and satisfaction. The capability to pioneer is built through pioneering.",
            closing = "The path worthy of your energy may not exist yet. Your task is to create it by walking.",
            reflectionPrompt = "What area of your life are you waiting for a clear path to appear in? What would happen if you started creating the path through your actions?"
        ),

        // q152 — Seneca
        "q152" to QuoteInsight(
            intro = "Seneca identifies what might seem paradoxical: the day in which you haven't laughed is the day you've lost something essential. Laughter is not frivolous — it's a sign of aliveness, perspective, resilience, and freedom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Laughter as Vitality",
                    blockquote = "The day is lost on which one has not laughed.",
                    body = "Laughter is involuntary joy. It arises when you see absurdity, perspective, or connection. A day without laughter is a day where you failed to perceive these things — or where you were too defended against them to allow the response. Laughter reveals that you are alive, that you can see beyond the immediate, that you retain the capacity for lightness.",
                    bullets = listOf(
                        InsightBullet("The involuntary test", "You can't laugh on command. It reveals your actual state of consciousness."),
                        InsightBullet("Perspective through laughter", "To laugh at something is already to have perspective on it.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Discipline of Lightness",
                    blockquote = "...lost...",
                    body = "In a life of serious purpose, the discipline is not to never laugh but to maintain the capacity for it. Stoicism is not grim. It's clear-eyed and therefore often finds the joke. The person too defended against pain also loses the capacity for joy. The capacity to laugh is inseparable from the capacity to live fully.",
                    bullets = listOf(
                        InsightBullet("Laughter as freedom", "To be able to laugh is to be free from complete compulsion."),
                        InsightBullet("The forgotten practice", "Many people stop laughing in adulthood. They mistake gravity for seriousness.")
                    )
                )
            ),
            modernApplication = "Psychology research on laughter and wellbeing shows correlations with resilience, immune function, and longevity. Laughter literally shifts your nervous system. The inability to laugh often indicates depression or rigidity. The capacity to laugh is a sign of psychological health.",
            closing = "A day without laughter is a day you failed to remain fully alive.",
            reflectionPrompt = "When was the last time you laughed? What prevents you from laughing more often? What might change if you deliberately sought out situations where laughter was possible?"
        ),

        // q153 — Epictetus
        "q153" to QuoteInsight(
            intro = "Epictetus teaches a middle path regarding tasks: don't go searching for difficulty, and don't avoid it either. When it arrives (and it will), meet it with equanimity. Grace is the ability to face what comes without resistance or drama.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trap of Either Extreme",
                    blockquote = "Neither seek nor shun tasks; but bear whatever comes with grace.",
                    body = "Some people chase difficulty to prove themselves. They take on more than is wise, wearing fatigue like a badge. Others avoid any challenge, which is its own exhaustion. Neither is wise. Wisdom is meeting tasks as they naturally arrive, without the drama of either seeking them or fleeing them.",
                    bullets = listOf(
                        InsightBullet("The proof trap", "Don't chase difficulty to prove strength. Strength proves itself quietly."),
                        InsightBullet("The avoidance cost", "Avoiding tasks doesn't create peace. It creates the additional burden of avoidance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Grace as Responsiveness",
                    blockquote = "...bear whatever comes...",
                    body = "Grace is not passivity. It's the ability to meet what arrives with clear-eyed acceptability. The task presents itself, and you respond — not with eagerness (which is performance), not with resentment (which is resistance), but with presence. This is what Epictetus calls grace: the capacity to engage without the extra emotions that distort engagement.",
                    bullets = listOf(
                        InsightBullet("Effort without drama", "You can work hard without the internal narrative that it's unfair or heroic."),
                        InsightBullet("The natural response", "Grace looks effortless because it's not fighting against what is.")
                    )
                )
            ),
            modernApplication = "Flow state research shows that peak performance comes from meeting challenges at appropriate difficulty with present attention. Neither excessive challenge (which creates anxiety) nor insufficient challenge (which creates boredom) produces flow. Equanimity is what allows optimal engagement.",
            closing = "Meet each task as it arrives, without seeking it or fleeing it, and you'll find a rhythm where effort becomes natural.",
            reflectionPrompt = "Are you currently seeking difficulty to prove something, or avoiding it out of fear? What would change if you met your tasks simply as they come?"
        ),

        // q154 — Seneca
        "q154" to QuoteInsight(
            intro = "Seneca makes an observation that seems pessimistic but is actually liberating: life contains so much that grieves us that asking why about each part misses the point. The better question is: what remains that's worthwhile despite the grief?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Weight of Existence",
                    blockquote = "What need is there to weep over parts of life? The whole of it calls for tears.",
                    body = "If you catalog the painful elements of life separately — loss, decay, injustice, difficulty — you can make sense of each one. But if you look at the whole, the sheer weight of existence itself is staggering. Everyone faces mortality. Everyone faces loss. Everyone faces failure. The wonder is not that we weep. The wonder is that we can stand at all.",
                    bullets = listOf(
                        InsightBullet("The realistic assessment", "Acknowledging the genuinely painful is not pessimism. It's honesty."),
                        InsightBullet("Against denial", "Stoicism is not positive thinking. It's clear seeing.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Perseverance That Remains",
                    blockquote = "...calls for tears.",
                    body = "And yet. Despite this weight, people choose to continue. People create. People love despite knowing loss is coming. People try despite knowing failure is possible. This is not naive. This is actually the highest form of courage — to see clearly what grieves and to live fully anyway.",
                    bullets = listOf(
                        InsightBullet("Courage after honesty", "The perseverance that follows clear seeing is real bravery."),
                        InsightBullet("Meaning despite tragedy", "You don't need to deny the tears to find what's worth living for.")
                    )
                )
            ),
            modernApplication = "Existential psychology (Frankl, Yalom, Kanter) shows that acknowledging life's fundamental difficulties and mortality actually increases meaning-making capacity. The ability to find purpose in the face of tragedy is what creates psychological resilience.",
            closing = "The question is not why life calls for tears. The question is: what beauty do you create anyway?",
            reflectionPrompt = "What griefs are you trying not to see? What beauty have you experienced that makes those griefs worthwhile?"
        ),

        // q155 — Seneca
        "q155" to QuoteInsight(
            intro = "Seneca offers a reversal of a common belief about time: reason and willpower alone cannot heal all wounds. But time does. Seneca is not saying to wait passively — he's identifying the limits of logic and pointing to the reality that healing sometimes requires what cannot be forced.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Reason Cannot Reach",
                    blockquote = "Time heals what reason cannot.",
                    body = "You can understand intellectually why something shouldn't hurt you. You can reason your way to acceptance. But the heart often won't follow logic. Trauma, loss, attachment — these don't yield only to rational persuasion. They yield to something slower: repeated exposure, gradual distance, the natural wearing-away that time accomplishes.",
                    bullets = listOf(
                        InsightBullet("The limits of philosophy", "Stoicism teaches perspective, but perspective alone doesn't heal."),
                        InsightBullet("The body's wisdom", "The nervous system has its own timeline separate from the mind's.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Work of Time",
                    blockquote = "...heals...",
                    body = "This doesn't mean passivity. It means cooperation with time. You can facilitate healing through continued practice of reason, through community, through new experiences that rewrite the nervous system. But you cannot force it faster than time allows. Seneca is saying: be patient. Time is doing work on you whether or not you notice.",
                    bullets = listOf(
                        InsightBullet("Patience as practice", "Allowing time to do its work is itself a discipline."),
                        InsightBullet("The cumulative effect", "Small shifts across many days accumulate into transformation.")
                    )
                )
            ),
            modernApplication = "Neuroscience on trauma and recovery confirms that healing requires time, repetition, and nervous system reset — not just cognitive reframing. The default mode network and emotional centers need time to update their patterns.",
            closing = "Reason prepares the ground. But time does the true healing. Neither alone suffices.",
            reflectionPrompt = "What do you wish you could reason away? What are you allowing time to heal in your life? Where are you impatient for healing that only time can provide?"
        ),

        // q156 — Cato
        "q156" to QuoteInsight(
            intro = "Cato warns against the dangers of proximity: you absorb the character of those you spend time with. This is not about judgment, but about a real psychological law — you become like those around you through osmosis.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Osmosis and Character",
                    blockquote = "Choose your companion carefully; the man who associates with the wretched soon learns their habits.",
                    body = "Character is not fixed in isolation. It's created through relationship and repetition. When you spend time with someone, you don't just associate with them — you begin to adopt their patterns, their values, their ways of interpreting the world. Slowly and invisibly, you become more like them. This is not a moral judgment. It's observation of how minds work.",
                    bullets = listOf(
                        InsightBullet("The influence you don't notice", "The strongest influences are the ones you don't specifically choose to adopt."),
                        InsightBullet("Habituation", "Repeated exposure to any behavior makes it seem increasingly normal, even comfortable.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Deliberate Selection",
                    blockquote = "Choose your companion carefully...",
                    body = "This is why the Stoics are so attentive to companionship. If character is created through those you spend time with, then your choice of companions is effectively your choice of who you're becoming. This is not snobbery — it's strategic wisdom about how human development works.",
                    bullets = listOf(
                        InsightBullet("Your future self is created now", "Who you spend time with is a vote for the person you're becoming."),
                        InsightBullet("Self-selection", "Choose those who elevate you, and you're voting for becoming elevated.")
                    )
                )
            ),
            modernApplication = "Social psychology research is clear: peer effects are real and powerful. People adopt the income, health behaviors, and worldviews of those around them. Character is created through company as much as through conscious choice.",
            closing = "You become the average of your companions. Choose with that reality in mind.",
            reflectionPrompt = "Who do you spend significant time with? Are you becoming more of who you want to be through that proximity, or less? Who would you need to spend more time with to move toward your better self?"
        ),

        // q157 — Cato
        "q157" to QuoteInsight(
            intro = "Cato identifies the traits that make a person truly excellent: wisdom in thought, courage in action, and commitment to principle. Together, they create not a hero, but a citizen effective to their world.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Three Pillars",
                    blockquote = "Bold in counsel, brave in action, steadfast in resolution — these three make the perfect citizen.",
                    body = "Notice: not three separate virtues, but three facets of integrated excellence. Bold in counsel means you can think clearly and speak truthfully, even when it's unpopular. Brave in action means you can execute what needs doing despite fear or opposition. Steadfast in resolution means you don't waver once you've committed to what's right.",
                    bullets = listOf(
                        InsightBullet("Integration", "These three only make sense together. Bravery without wisdom could be recklessness. Counsel without action is mere theory."),
                        InsightBullet("The practical focus", "This isn't about heroism. It's about being functionally good in your sphere.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Citizen's Excellence",
                    blockquote = "...make the perfect citizen.",
                    body = "Cato uses the word citizen deliberately. You're not meant for exile or isolation. You're meant to be effective in the world you're part of. That requires wisdom (good judgment), courage (willingness to act despite cost), and steadfastness (not being moved by circumstance or opinion). The perfect citizen is not perfect in every way — they're excellent in the ways that matter for community.",
                    bullets = listOf(
                        InsightBullet("Public virtue", "Your excellence matters because it affects those around you."),
                        InsightBullet("Realistic excellence", "You don't need to be flawless. You need to be reliably good in the ways that count.")
                    )
                )
            ),
            modernApplication = "Research on leadership and trustworthiness shows that these three qualities — clear thinking, brave action, and consistency — are what make people worth following. They're rare enough that when present, they attract and inspire.",
            closing = "The world needs citizens bold in thought, brave in deed, and true to principle. Can you be one?",
            reflectionPrompt = "In which of these three areas are you strongest? Which one is calling for development? What would that development look like?"
        ),

        // q158 — Seneca
        "q158" to QuoteInsight(
            intro = "Seneca makes a firm statement about trust: someone who has once been disloyal should not be trusted again. This seems harsh, but Seneca is protecting wisdom from sentiment. Trust broken is trust damaged irreparably.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Irreversibility of Betrayal",
                    blockquote = "Do not trust him who once has been perfidious.",
                    body = "After betrayal, the betrayer may apologize, may make amends, may promise change. But something has been broken that rehabilitation doesn't restore. You now know two things: what they're capable of when incentive aligns, and that their word is contingent. Trust, once lost, is not merely reduced — it's fundamentally altered. You can forgive, but forgetting the knowledge is unwise.",
                    bullets = listOf(
                        InsightBullet("Knowledge persists", "You cannot unknow someone's capacity for betrayal."),
                        InsightBullet("The second chance trap", "Offering unlimited trust to someone who broke it once is enabling, not virtue.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Wisdom in Relationships",
                    blockquote = "...not trust...",
                    body = "This is not cruelty. It's realism. You can be kind to the person who once betrayed you. You can even work with them. But trust — the deep assumption that their commitment to you aligns with your wellbeing — is a luxury only available after intact consistency. To offer it to someone proven inconsistent is to make yourself vulnerable to the same harm.",
                    bullets = listOf(
                        InsightBullet("Mercy and wisdom", "Being kind doesn't require naively trusting again."),
                        InsightBullet("Boundaries as respect", "Trusting someone to behave better than they've shown they will is disrespecting their own nature.")
                    )
                )
            ),
            modernApplication = "Attachment theory and trauma research both support this: repeated betrayal creates attachment injuries that don't heal quickly. The brain literally learns to predict betrayal from that person. Willfully ignoring that learning is not generosity — it's harm.",
            closing = "Forgiveness does not require renewed trust. Learn the lesson and move forward protected.",
            reflectionPrompt = "Is there someone you've forgiven but whose betrayal still informs your guard? Is that guard protecting you wisely, or is it unnecessary? Can you be kind while remaining clear-eyed?"
        ),

        // q159 — Seneca
        "q159" to QuoteInsight(
            intro = "Seneca states a paradox that reverses normal thinking: virtue is not a means to something else. It is the reward itself. You don't practice virtue to get something. The practice of virtue is what you get.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Reversal of Motivation",
                    blockquote = "Virtue is its own reward.",
                    body = "Most human motivation is instrumental: you do X to get Y. You work to have money. You study to get credentials. You are kind to be popular. But virtue, Seneca says, is categorical. You practice virtue because it is itself the good. The moment you practice virtue for some external reward — approval, wealth, reputation — you have already corrupted it.",
                    bullets = listOf(
                        InsightBullet("The authenticity test", "If your virtue would change if no one was watching, it wasn't virtue."),
                        InsightBullet("The contamination of motive", "The moment virtue seeks reward, it becomes a performance.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Intrinsic Good",
                    blockquote = "...its own reward.",
                    body = "What does it feel like to act virtuously? Clear. Complete. Whole. There's a sense of integration — your actions align with your values, your values align with your choices, and there's nothing you need to add to make it meaningful. That feeling is the reward. It can't be purchased or performed. It comes only from genuine virtue.",
                    bullets = listOf(
                        InsightBullet("The completeness", "Virtue doesn't promise external success. It promises completion in the moment of action."),
                        InsightBullet("The self-validating life", "A virtuous life validated itself. It needs no external endorsement.")
                    )
                )
            ),
            modernApplication = "Psychology research on intrinsic vs. extrinsic motivation shows that intrinsic motivation (acting because it aligns with values) is more sustainable and satisfying than extrinsic. The reward that comes from alignment itself is what sustains the virtue.",
            closing = "The person who practices virtue for virtue's sake has already found what others spend their lives seeking.",
            reflectionPrompt = "Where are you practicing virtue to be seen or rewarded? What would change if you practiced the same virtue purely because it's right?"
        ),

        // q160 — Marcus Aurelius
        "q160" to QuoteInsight(
            intro = "Marcus Aurelius observes that everything changes — this is the constant of existence. But virtue, paradoxically, is the one thing that abides. Everything else is temporary. Only virtue endures.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Impermanence of All Else",
                    blockquote = "There is nothing permanent except change. But virtue abides.",
                    body = "Look at what seems permanent: your body will decay. Your possessions will transform or vanish. Your relationships will shift. Your achievements will be forgotten. Your reputation will be rewritten. Everything — absolutely everything — ultimately changes. And this would be terrifying if there was nothing that remained.",
                    bullets = listOf(
                        InsightBullet("The comfort in acceptance", "Accepting impermanence paradoxically makes it less terrifying."),
                        InsightBullet("The futility of holding", "You cannot keep anything. The question is: what are you becoming in the process of trying?")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The One Permanence",
                    blockquote = "But virtue abides.",
                    body = "Virtue abides because it's not a thing but a way of being. Your generosity isn't a possession that can be taken — it's woven into your character. Your integrity isn't an achievement that fades — it accrues. The virtuous choices you've made are part of your permanent having, not because they won't change, but because they've changed you permanently. You are your choices.",
                    bullets = listOf(
                        InsightBullet("You become your choices", "Virtue isn't accumulated like wealth. It's embodied like skill."),
                        InsightBullet("The true legacy", "What remains is not your reputation or possessions but who you became.")
                    )
                )
            ),
            modernApplication = "Research on meaning and dying shows that people facing death report that what matters most are the relationships and character they developed, not the achievements or possessions. Virtue aligns with what actually endures in human significance.",
            closing = "Everything passes except the character you're building. Build it carefully.",
            reflectionPrompt = "What in your life are you protecting as if it's permanent? What would change if you focused instead on the virtue you're developing through this season of change?"
        ),

        // q161 — Seneca
        "q161" to QuoteInsight(
            intro = "Seneca reframes how to order your life: imagine your death now, not as morbid meditation but as clarifying practice. From that vantage point, what truly matters? Begin now with that clarity.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Perspective from the End",
                    blockquote = "Begin with the end in mind. The sage imagines his death to order his life.",
                    body = "When you imagine yourself at the end, looking back, what matters? Not the worries that consumed you yesterday. Not the small failures and embarrassments. Not the status symbols. What matters is: did I love? Did I create? Did I learn? Did I serve? Did I become someone I respect? Imagining death is not pessimism — it's the ultimate perspective adjustment.",
                    bullets = listOf(
                        InsightBullet("The reality test", "What you think will matter at the end is usually what matters now."),
                        InsightBullet("Against the urgent", "Death clarifies that the urgent is rarely important.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Ordering from That Clarity",
                    blockquote = "...to order his life.",
                    body = "The sage doesn't just meditate on death passively. They use that clarity to reorganize how they live. From the perspective of the end, certain activities become unforgivable wastes. Certain relationships become precious. Certain goals become hollow. The sage then lives in alignment with this clarity. Every day becomes an expression of what makes sense from the perspective of the end.",
                    bullets = listOf(
                        InsightBullet("Alignment", "When how you live matches what matters at the end, there's no wasted motion."),
                        InsightBullet("The integrated life", "Your daily life and your deathbed perspective align. That's wholeness.")
                    )
                )
            ),
            modernApplication = "Existential psychology research (Yalom, Frankl) confirms that awareness of mortality actually increases meaning-making and alignment. People who regularly contemplate mortality make different choices than those who live as if they have infinite time.",
            closing = "The view from the end clarifies what the middle should look like.",
            reflectionPrompt = "What would future-you, looking back from the end, want to tell you about how to spend today? What are you doing that future-you would consider time wasted?"
        ),

        // q162 — Epictetus (duplicate quote, different context/number)
        "q162" to QuoteInsight(
            intro = "Epictetus makes a paradoxical observation: the person who fears labor has already, in that fear, lost the thing they're afraid of — their capacity to do what's difficult. Fear itself is the defeat.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Pre-Defeat",
                    blockquote = "He who dreads toil has already lost.",
                    body = "Notice that Epictetus doesn't say the toil defeats you. He says the dread defeats you. The labor hasn't happened yet, but the fear is already active. You're already living a diminished life, already robbed of your capability through the internal reality of dread.",
                    bullets = listOf(
                        InsightBullet("The preemptive collapse", "You can be defeated by what hasn't happened yet."),
                        InsightBullet("The real enemy", "Fear does more damage than the thing feared.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Win Before the Challenge",
                    blockquote = "...has already lost.",
                    body = "This means that the path to victory goes through the fear. The person who can feel the dread, acknowledge it, and proceed anyway has already won the most important part. The labor itself might fail. But the person has succeeded in the pre-condition: they've kept their agency.",
                    bullets = listOf(
                        InsightBullet("Agency preserved", "What matters is not whether you succeed but whether you tried despite fear."),
                        InsightBullet("The double victory", "When you act despite dread, you've won twice: the task and your own respect.")
                    )
                )
            ),
            modernApplication = "Neuroscience on fear shows that anticipated dread is often worse than the actual experience. The brain's threat response activates before the stimulus. Proceeding despite the dread literally retrains the nervous system.",
            closing = "The one defeat you can't recover from is surrendering before you start.",
            reflectionPrompt = "What toil are you dreading? Have you already half-surrendered to it? What becomes possible if you move toward it despite the dread?"
        ),

        // q163 — Epictetus
        "q163" to QuoteInsight(
            intro = "Epictetus advises attention to friendship quality over quantity: be selective about who you let close. The character of your friends shapes your character.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Power of Proximity",
                    blockquote = "Take heed of the quality, not the quantity, of your friends.",
                    body = "A few genuine friends of good character will do more for your development than many shallow connections. The people closest to you — the ones you talk to regularly, the ones who know you — become your mirrors and your teachers whether they mean to or not.",
                    bullets = listOf(
                        InsightBullet("Mirror function", "Your friends reflect who you are and who you're becoming."),
                        InsightBullet("The teaching effect", "You learn from proximity, not just from intention.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Strategic Selectivity",
                    blockquote = "...of your friends.",
                    body = "This is not about snobbery. It's about recognizing that friendship — real friendship — is formative. You can have many acquaintances, but the people you genuinely befriend shape your life. Choose them with attention to their character, not their status or entertainment value.",
                    bullets = listOf(
                        InsightBullet("The depth strategy", "A few deep friendships nourish more than many surface ones."),
                        InsightBullet("The elevation", "Friendships with those who elevate you are not luxuries — they're the infrastructure of your growth.")
                    )
                )
            ),
            modernApplication = "Social psychology research shows that the quality of relationships is far more predictive of wellbeing than quantity. Close friendships with people who share your values are protective health factors.",
            closing = "You don't need many friends. You need the right ones.",
            reflectionPrompt = "Which of your friendships are genuinely shaping you? Are they shaping you toward the person you want to become? Is there a friendship of low quality you should recalibrate?"
        ),

        // q164 — Seneca
        "q164" to QuoteInsight(
            intro = "Seneca makes a profound claim about identity and belonging: you are not a creature of one place. The entire world is your home. This is liberation from parochialism — you belong everywhere because your principles belong everywhere.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Parochial Trap",
                    blockquote = "I am not born for one corner; the whole world is my native land.",
                    body = "It's natural to feel most at home in one place. But Seneca suggests this is limiting. If your identity is tied to a location, you're bound to that location. You're diminished by any exile. But if you recognize yourself as a citizen of the world, as someone whose principles work anywhere, you're free. You can go anywhere and still be home.",
                    bullets = listOf(
                        InsightBullet("Identity beyond place", "What makes you you is not where you're from but who you are."),
                        InsightBullet("The Stoic cosmopolitanism", "Your true home is principle, not geography.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "Freedom Through Expansiveness",
                    blockquote = "...my native land.",
                    body = "This doesn't mean you don't cherish specific places or people. It means you're not imprisoned by them. Your values, your character, your capacity for virtue — these travel with you. Anywhere you go, you can act with integrity. Anywhere you go, you can find beauty. Anywhere you go, you're home.",
                    bullets = listOf(
                        InsightBullet("The portability of virtue", "You don't need a specific location to be yourself."),
                        InsightBullet("The freedom in expansion", "The wider your sense of belonging, the less vulnerable you are to loss.")
                    )
                )
            ),
            modernApplication = "Research on adaptation and resilience shows that people with broader identities who aren't overly location-dependent adapt better to changing circumstances. Psychological flexibility increases wellbeing.",
            closing = "Your soul is your native land. Carry it anywhere, and you're always home.",
            reflectionPrompt = "How much of your identity is tied to one place? What would change if you saw yourself as belonging to the world? What would that freedom make possible?"
        ),

        // q165 — Seneca
        "q165" to QuoteInsight(
            intro = "Seneca revisits a theme he knows speaks to the modern person: trying to be everywhere is being nowhere. Spread yourself too thin and you don't exist fully anywhere.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Fragmentation of Presence",
                    blockquote = "To be everywhere is to be nowhere.",
                    body = "Imagine being in multiple places simultaneously. You'd be nowhere fully. The same applies to attention and presence. The person juggling ten priorities is truly engaged in none. The person with a hundred social commitments is genuinely present to no one. You exist where you focus. Everywhere else you're a ghost.",
                    bullets = listOf(
                        InsightBullet("Presence as existence", "You exist where you give your attention completely."),
                        InsightBullet("The cost of omnipresence", "Trying to be everywhere important results in being nowhere fully.")
                    )
                ),
                InsightSection(
                    number = 2,
                    title = "The Power of Specificity",
                    blockquote = "...nowhere.",
                    body = "Seneca isn't saying stay in one place forever. He's saying: be there when you're there. Engage deeply with what's in front of you. Then move to the next thing fully. The person who does this creates impact. They're remembered because they were genuinely present. The person spread thin leaves no real mark anywhere.",
                    bullets = listOf(
                        InsightBullet("Depth over breadth", "One place where you're fully present beats ten places where you're distracted."),
                        InsightBullet("The legacy of presence", "What people remember is when someone was truly there with them.")
                    )
                )
            ),
            modernApplication = "Neuroscience shows that attention is limited and context-switching is exhausting. Deep work requires sustained focus. The impact you make is in proportion to the depth of your engagement, not the breadth of your commitments.",
            closing = "Be somewhere fully, and you'll matter. Be everywhere partially, and you'll matter nowhere.",
            reflectionPrompt = "Where are you spread too thin? What would happen if you committed fully to being present in fewer places? Where do you need to choose depth over breadth?"
        ),

        // ── EMERGENCY (SOS) QUOTES — emotion-specific, crisis format ────────────

        // ANGER CRISIS
        // q200 — Marcus Aurelius
        "q200" to QuoteInsight(
            intro = "When anger rises in you, Marcus Aurelius offers an immediate truth: the consequences of your anger will harm you more than the thing that provoked it. Anger damages the angry person first.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Harm You're Already Taking",
                    blockquote = "How much more grievous are the consequences of anger than the causes of it.",
                    body = "Right now, as anger rises, your nervous system is already damaged. Your clarity is gone. Your wisdom is offline. The thing that angered you created one problem. But your anger is creating multiple problems in you — in your body, your mind, your decisions. The anger doesn't punish the offender. It punishes you."
                )
            ),
            modernApplication = "Neuroscience confirms: anger activates threat responses that impair prefrontal judgment. You literally can't think clearly while angry. The consequence of anger is self-inflicted damage.",
            closing = "The person who angered you may never know. But you will feel it. Don't let anger make you suffer twice.",
            reflectionPrompt = "What would it look like to set this anger down right now? What do you want instead: to be right, or to be at peace?"
        ),

        // q201 — Marcus Aurelius
        "q201" to QuoteInsight(
            intro = "When someone injures you and you want to strike back, Marcus Aurelius offers a reframe: the best response is not to become like them, but to become unlike them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The True Victory",
                    blockquote = "The best revenge is to be unlike him who performed the injustice.",
                    body = "Revenge makes you like your enemy. You adopt their methods, their cruelty, their moral baseline. But transcendence — becoming someone better than what was done to you — that's a victory the injurer can't touch. It separates you from them and proves you're capable of something they're not."
                )
            ),
            modernApplication = "Research on revenge shows it rarely brings satisfaction. The satisfaction that does come is from the realization that you responded with integrity rather than retaliation.",
            closing = "Live well. That's more powerful than any revenge.",
            reflectionPrompt = "How could you become better through this, rather than bitter about it?"
        ),

        // q202 — Seneca
        "q202" to QuoteInsight(
            intro = "Seneca identifies the real victim of your anger: when you're angry, you're punishing yourself for someone else's fault.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Who Pays the Price?",
                    blockquote = "To be angry is to revenge the faults of others on ourselves.",
                    body = "The person who wronged you is likely unaffected by your anger. But you? You're carrying the weight, the adrenaline, the sleeplessness. You're the one suffering. Your anger is a punishment you're inflicting on yourself for someone else's mistake."
                )
            ),
            modernApplication = "Anger researcher James Doty notes: anger feels like it should hurt the target, but it actually damages the carrier. The nervous system pays the price.",
            closing = "Stop punishing yourself for their mistake.",
            reflectionPrompt = "Can you release this anger without forgiving them? Can you simply stop carrying it?"
        ),

        // q203 — Epictetus
        "q203" to QuoteInsight(
            intro = "When someone angers you and has you in their grip, Epictetus offers the harsh truth: they've conquered you. Your anger is proof they've won.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Who's in Control?",
                    blockquote = "He who angers you conquers you.",
                    body = "In this moment, they control your emotional state. They control your nervous system. They determine what you feel. That's what conquest looks like. The only way to be unconquered is to refuse to be angered by their actions."
                )
            ),
            modernApplication = "Emotional regulation research shows that accepting that you have the power to manage your response is what creates actual freedom from others' influence.",
            closing = "Take back control. They can't hurt you if you don't let them live rent-free in your mind.",
            reflectionPrompt = "What would it look like to stay calm right now? What power does that give you back?"
        ),

        // q204 — Marcus Aurelius
        "q204" to QuoteInsight(
            intro = "Marcus Aurelius asks you to measure: what's actually costing you? The original offense or the anger you're carrying about it?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Hidden Arithmetic",
                    blockquote = "Consider how much more you often suffer from your anger and grief than from those very things for which you are angry and grieved.",
                    body = "The original hurt may have been small. But the anger, the rumination, the sleeplessness, the replayed scenarios in your mind — these are multiplying the damage tenfold. You're not suffering because of what happened. You're suffering because of what you're doing in response to what happened."
                )
            ),
            modernApplication = "Rumination studies show that the retelling of a grievance amplifies suffering far beyond the original event. The mind makes the pain worse each time it replays.",
            closing = "The math is clear: drop the anger or suffer its weight.",
            reflectionPrompt = "How much of your suffering right now is from the original event versus from your anger about it?"
        ),

        // q205 — Seneca
        "q205" to QuoteInsight(
            intro = "When anger peaks, Seneca offers the simplest intervention: wait. Time is anger's antidote.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Power of Delay",
                    blockquote = "The greatest remedy for anger is delay.",
                    body = "Don't respond now. Don't decide now. Don't act now. Give time to do its work. In an hour, you'll think differently. In a day, more clearly. The anger that feels urgent now will feel manageable after delay. The words you want to say now would damage things you want to keep."
                )
            ),
            modernApplication = "Neuroscience on the amygdala hijack: it takes approximately 20 minutes for the prefrontal cortex to reactivate after anger. Waiting is literally waiting for your wisdom to return.",
            closing = "If it's worth saying when angry, it's worth waiting to say it right.",
            reflectionPrompt = "What happens if you simply don't respond for one hour? What becomes true then that isn't true now?"
        ),

        // ANXIETY CRISIS
        // q210 — Seneca
        "q210" to QuoteInsight(
            intro = "When anxiety multiplies your suffering, Seneca points to the source: most of it is happening in your head. The real threat is smaller than the imagined one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Imagination vs. Reality",
                    blockquote = "We suffer more often in imagination than in reality.",
                    body = "Right now, you're suffering in two places: the real challenge (which exists) and the catastrophic scenarios your mind is generating (which don't exist yet). The real challenge is usually manageable. But the imagined futures — all of them negative — are what's actually overwhelming you."
                )
            ),
            modernApplication = "Anxiety neuroscience: the amygdala generates threat predictions, most of which never happen. The prefrontal cortex knows this. Redirecting attention to present reality (not future imagination) activates the cortex and reduces amygdala activation.",
            closing = "Separate the real problem from the imagined fantasies. The real one you can handle.",
            reflectionPrompt = "What's actually happening right now (not what might happen)? Can you handle that?"
        ),

        // q211 — Marcus Aurelius
        "q211" to QuoteInsight(
            intro = "Marcus Aurelius reminds you: the future hasn't arrived yet, and when it does, you'll face it with the same resources you have now. Anxiety about tomorrow is weakness today.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "You'll Be Ready Then Too",
                    blockquote = "Never let the future disturb you. You will meet it, if you have to, with the same weapons of reason which today arm you against the present.",
                    body = "You're frightened of a future scenario. But when that scenario arrives (if it arrives), you won't be today's unprepared version. You'll have the same reason, the same resilience you have now. You can handle tomorrow with tomorrow's clarity just as you handle today."
                )
            ),
            modernApplication = "Research on coping: people consistently overestimate how much future problems will bother them and underestimate their own adaptive capacity. You're more capable than you assume.",
            closing = "Your future self will be as resourceful as you are right now.",
            reflectionPrompt = "If this feared thing actually happened, how would you handle it? (You'd figure it out, wouldn't you?)"
        ),

        // q212 — Seneca
        "q212" to QuoteInsight(
            intro = "When anxiety about the future dominates, Seneca identifies the problem: your mind is imprisoned in a future that doesn't exist, making you miserable in the present that does.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Trap of Future-Focused Suffering",
                    blockquote = "The mind that is anxious about future events is miserable.",
                    body = "The future you're anxious about might never arrive. The present you're sacrificing by being anxious — that's real. That's now. You're trading actual peace for imagined problems. The exchange rate is brutal."
                )
            ),
            modernApplication = "Mindfulness research consistently shows that redirecting attention from future worry back to present sensory experience reduces anxiety measurably within minutes.",
            closing = "The only moment you can actually live in is this one. Don't trade it for a future that might not happen.",
            reflectionPrompt = "Can you notice one thing happening right now that isn't scary? Your breath? A sound? A sensation?"
        ),

        // q213 — Marcus Aurelius
        "q213" to QuoteInsight(
            intro = "Marcus Aurelius offers a direct intervention in the moment of anxiety: question the necessity of each worry. Are all these thoughts actually necessary?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Interrogating the Spiral",
                    blockquote = "Ask yourself at every moment: is this necessary?",
                    body = "You're thinking about something that might happen. Is it necessary to think about it right now? You're planning for a scenario. Is it necessary to plan for it while anxious? Each thought in the spiral asks for your participation. You can refuse. 'Is this necessary?' often has a clear answer: no."
                )
            ),
            modernApplication = "Cognitive behavioral therapy identifies thought spirals as anxiety's vehicle. Interrupting with the question 'Is this necessary?' is a standard intervention that disrupts the pattern.",
            closing = "You don't have to think every thought that arrives.",
            reflectionPrompt = "What thought just arrived? Is thinking it necessary right now? What happens if you don't?"
        ),

        // q214 — Marcus Aurelius
        "q214" to QuoteInsight(
            intro = "The simplest instruction: return your attention to what's actually happening. The now.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Only Moment That Exists",
                    blockquote = "Confine yourself to the present.",
                    body = "Anxiety lives in the future. The future is not here. The present is. What's happening right now, in this moment? Not the threat you're imagining. Something else. Something real. That's where you actually are. That's where you're actually safe."
                )
            ),
            modernApplication = "Neuroscience of presence: focusing on present sensory experience directly activates the parasympathetic nervous system, which is incompatible with the threat response underlying anxiety.",
            closing = "Come back. You're safe right now.",
            reflectionPrompt = "Where are you physically in this moment? What do you actually see, hear, feel? Stay there."
        ),

        // q215 — Marcus Aurelius
        "q215" to QuoteInsight(
            intro = "Marcus Aurelius offers the ultimate reframing: the worst thing you fear is usually not being alive. But you are alive right now. Don't waste it through fear.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What's Actually at Risk",
                    blockquote = "It is not death that a man should fear, but he should fear never beginning to live.",
                    body = "You fear many things — failure, loss, pain. But underneath most fears is the fear of death, of nonexistence. And yet you're alive right now. Every moment you spend anxious is a moment of this life unlived. That's the real tragedy."
                )
            ),
            modernApplication = "Terror management theory and existential psychology show that acknowledging mortality actually decreases anxiety by clarifying what matters: living now.",
            closing = "You're alive. Don't waste it being afraid of dying.",
            reflectionPrompt = "If you weren't afraid, what would you do right now?"
        ),

        // GRIEF CRISIS
        // q220 — Seneca
        "q220" to QuoteInsight(
            intro = "When grief overwhelms, Seneca offers a truth: your mind can find calm even in the midst of pain. The pain doesn't have to destroy your peace.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Possibility of Calm",
                    blockquote = "Nothing is so bitter that a calm mind cannot find comfort in it.",
                    body = "Grief is real. The loss is real. But a mind that remains calm can metabolize the grief differently. It can hold the sadness without being shattered by it. It can remember and hurt without being destroyed. This isn't denying the pain. It's refusing to let the pain destroy your coherence."
                )
            ),
            modernApplication = "Research on resilience shows that people who can maintain a sense of calm within grief (not bypassing it, but witnessing it gracefully) recover more fully and faster.",
            closing = "You can be sad and whole at the same time.",
            reflectionPrompt = "Can you feel this grief without being destroyed by it? What would that look like?"
        ),

        // q221 — Epictetus
        "q221" to QuoteInsight(
            intro = "When grief fixates on what's lost, Epictetus redirects: you still have things. Grieve what's gone, yes. But also notice what remains.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Survives",
                    blockquote = "He is a wise man who does not grieve for the things which he has not, but rejoices for those which he has.",
                    body = "Your mind wants to catalog what's gone. Let it, but also break the spell by noticing what's still here. The person you lost — but the memories remain. The opportunity missed — but other paths still open. Wisdom isn't ignoring the loss. It's not losing sight of what wasn't lost."
                )
            ),
            modernApplication = "Grief counseling research shows that balanced grieving (acknowledging loss while also acknowledging presence) leads to healthier processing.",
            closing = "Include the presence in the grief.",
            reflectionPrompt = "What do you still have? Not instead of your loss, but in addition to it?"
        ),

        // q222 — Marcus Aurelius
        "q222" to QuoteInsight(
            intro = "When grief makes you feel victimized, Marcus Aurelius reminds you: accept what is. Struggle against reality is what multiplies suffering.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Accepting the Unacceptable",
                    blockquote = "Accept the things to which fate binds you.",
                    body = "This happened. You didn't choose it. You can't change it. Fighting that reality — wishing it didn't happen, raging against fate — doesn't bring it back. It just adds layers of resistance on top of the grief. Acceptance isn't approval. It's ceasing to fight what is."
                )
            ),
            modernApplication = "Acceptance and Commitment Therapy shows that accepting the unchangeable (while acting on what you can change) is what moves people through grief.",
            closing = "Stop fighting what happened and you'll have energy for what comes next.",
            reflectionPrompt = "What if you stopped trying to undo this and instead accepted it? What becomes possible then?"
        ),

        // q223 — Marcus Aurelius
        "q223" to QuoteInsight(
            intro = "Marcus Aurelius reframes loss itself: loss is change, and change is the fundamental nature of existence. To live is to lose. To lose is to change.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Loss as Transformation",
                    blockquote = "Loss is nothing else but change, and change is Nature's delight.",
                    body = "Everything changes. Everything that arrived will leave. Everything you have will be taken. This isn't a curse; it's the condition of existence. And paradoxically, this transience is what makes things valuable. Because nothing lasts, everything matters now."
                )
            ),
            modernApplication = "Philosophy of impermanence and research on meaning both suggest that accepting transience increases gratitude for what is present.",
            closing = "Loss is the price of having had. Both are equal.",
            reflectionPrompt = "What did this loss teach you about what you valued? Honor that by valuing what remains."
        ),

        // q224 — Seneca
        "q224" to QuoteInsight(
            intro = "When grief connects you to past pain, Seneca instructs: come to the present. Happiness is available now, not somewhere else.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Presence Over Memory",
                    blockquote = "True happiness is to enjoy the present, without anxious dependence upon the future.",
                    body = "Grief keeps you in loss. But the present moment contains something other than grief — a breath, a sight, a connection that's happening right now. Happiness isn't in fixing what was lost. It's in fully meeting what's here."
                )
            ),
            modernApplication = "Positive psychology research shows that small practices of present enjoyment (savoring a taste, noticing beauty) are measurable antidotes to grief spirals.",
            closing = "There is good happening right now. Can you notice one?",
            reflectionPrompt = "What's one small good thing present in this moment? The grief doesn't have to disappear for you to notice it."
        ),

        // q225 — Seneca
        "q225" to QuoteInsight(
            intro = "Seneca offers a paradox that defies grief: time is healing you even as you hurt. If you can bear the waiting, time will soften this.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Medicine of Time",
                    blockquote = "Time heals what reason cannot.",
                    body = "Right now you can't reason this pain away. But if you simply endure, time does the work. Days pass. Memories settle. New experiences arrive. The wound doesn't close into being gone — it closes into being bearable. This isn't something you do. It's something that happens to you if you don't resist it."
                )
            ),
            modernApplication = "Neuroscience on memory consolidation: emotional memories fade in intensity over time if not repeatedly reactivated. Living forward from grief gradually decreases its acute intensity.",
            closing = "Survive this day. Time will handle the rest.",
            reflectionPrompt = "Can you commit to giving this one more week without deciding you won't survive it?"
        ),

        // FEAR CRISIS
        // q230 — Seneca
        "q230" to QuoteInsight(
            intro = "When fear paralyzes, Seneca identifies the real problem: not the difficulty, but your refusal to attempt it. Fear wins before the effort begins.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Pre-Emptive Surrender",
                    blockquote = "It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.",
                    body = "The thing you fear seems impossible because you've surrendered before attempting it. Surrender makes everything impossible. But start — just start — and the thing that seemed insurmountable often reveals itself to be manageable."
                )
            ),
            modernApplication = "Starting research (getting off the couch effect): the resistance to starting is almost always worse than the actual task. Action reduces fear.",
            closing = "Start. That breaks the spell.",
            reflectionPrompt = "What's the first tiny step? Can you take just that?"
        ),

        // q231 — Seneca
        "q231" to QuoteInsight(
            intro = "Seneca reminds you: nothing great has ever been accomplished without risk. If you want something that matters, fear is the companion.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Fear as a Sign of Courage",
                    blockquote = "Nothing great is accomplished without danger.",
                    body = "You feel fear. That means you're considering something that matters to you, something real. Fear is not a sign you shouldn't do it. It's a sign that you care about the outcome."
                )
            ),
            modernApplication = "Courage research: courage isn't the absence of fear. It's action taken despite fear. People who accomplish things feel the fear and proceed.",
            closing = "The fear means it matters. Do it anyway.",
            reflectionPrompt = "If you're afraid, you know it matters. What do you do with that knowledge?"
        ),

        // q232 — Seneca
        "q232" to QuoteInsight(
            intro = "When facing something difficult, Seneca suggests preparing mentally: assume you're at the threshold of your last day. This strips away trivial fear.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Ultimate Perspective",
                    blockquote = "Let us prepare our minds as if we had come to the very end of life. Let us postpone nothing.",
                    body = "From that vantage, the thing you're afraid of often shrinks. It seems manageable. Or if it remains hard, it becomes clear that it's worth attempting anyway. Fear loses its grip when you've accepted that you'd regret not trying more than you'd regret failing."
                )
            ),
            modernApplication = "Terror management theory: contemplating mortality cuts through everyday anxieties and reveals what actually matters.",
            closing = "Do what dying-you would want live-you to do right now.",
            reflectionPrompt = "If this were your last year, what would you do about this fear?"
        ),

        // q233 — Epictetus
        "q233" to QuoteInsight(
            intro = "Epictetus states a hard truth: if you won't begin, you've already lost. The dread is the defeat.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Dread as the Real Enemy",
                    blockquote = "He who dreads toil has already lost.",
                    body = "You haven't started and you're already defeated inside. The dread is doing the damage before the toil ever touches you. Move. Begin. That interrupts the defeat."
                )
            ),
            modernApplication = "Behavioral activation (core CBT technique): action, not willpower or feeling ready, is what moves through fear.",
            closing = "Move and the dread loses its power.",
            reflectionPrompt = "What's one small action you can take in the next 10 minutes?"
        ),

        // q234 — Seneca
        "q234" to QuoteInsight(
            intro = "Seneca identifies an irony: the fear you feel now is worse than the thing you fear. Fear itself is the torture.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Fear > The Feared Thing",
                    blockquote = "Fear is more painful than the thing feared.",
                    body = "You're suffering from the fear more than from the thing. If the feared thing happened, you'd often find it less terrible than you imagined. But the fear is already terrible. You're already hurt."
                )
            ),
            modernApplication = "Anticipatory anxiety research: the actual event is almost always less distressing than its anticipation.",
            closing = "The fear is hurting you more than the reality will.",
            reflectionPrompt = "If the thing you fear happened today, what would actually happen? How would you handle it?"
        ),

        // q235 — Seneca
        "q235" to QuoteInsight(
            intro = "Seneca offers a reframe for poverty (real or feared): poverty is not having little. It's wanting more than you have. Shift your focus and you're richer than you were.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Poverty as Mental State",
                    blockquote = "It is not the man who has too little who is poor, but the man who hankers after more.",
                    body = "Fear about lack is often really about desire exceeding what you have. The shift internal — deciding what you actually need vs. what you're comparing yourself to — changes your experience of scarcity."
                )
            ),
            modernApplication = "Research on adaptation: people adapt to less stuff quickly. The suffering comes from wanting more, not from having less.",
            closing = "You have enough for today. That's enough.",
            reflectionPrompt = "What do you actually need right now? Separate that from what you're afraid you lack."
        )
    )
}
