package com.ataraxy.app.data.seed

import com.ataraxy.app.domain.model.InsightSection
import com.ataraxy.app.domain.model.QuoteInsight

/** Insights for the Find Your Footing quotes, one short crisis-format reading per quote. */
object SosInsightData {
    val insights: Map<String, QuoteInsight> = mapOf(
        // q300, Marcus Aurelius (overwhelmed)
        "q300" to QuoteInsight(
            intro = "When everything seems to arrive at once, Marcus Aurelius offers a quiet instruction he wrote to himself: you do not have to hold your whole life in your mind at the same time.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Piece at a Time",
                    blockquote = "Do not disturb yourself by thinking of the whole of your life.",
                    body = "Overwhelm often comes from stacking every worry into one heavy pile: this week, this year, everything that might go wrong. Marcus noticed his own mind doing this. In the same passage he reminds himself to ask, of the present moment alone, what in it is truly unbearable. Usually the answer is less than the pile suggests. The whole of your life is never in front of you at once. Only this hour is, and this hour can be met."
                )
            ),
            modernApplication = "Write down the one thing that actually needs you in the next hour. Put everything else on a separate list and turn the page over. Then ask, as Marcus did: what in this moment can I not bear?",
            closing = "You only ever have to carry this hour.",
            reflectionPrompt = "What is the one thing in front of you right now? What could wait until tomorrow?"
        ),

        // q301, Marcus Aurelius (overwhelmed)
        "q301" to QuoteInsight(
            intro = "When your mind is racing ahead of you, Marcus Aurelius offers three short commands, almost like steps on a stair, that bring you back to where you actually are.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Back to the Present",
                    blockquote = "Wipe out the imagination. Stop the pulling of the strings. Confine yourself to the present.",
                    body = "Marcus wrote these lines to himself, and their shortness is part of their help. Wipe out the imagination: set aside the pictures your mind is painting of what might happen. Stop the pulling of the strings: notice the urges tugging you in five directions at once, and let them go slack. Confine yourself to the present: this room, this breath, this task. The present is usually smaller and easier to manage than the story your mind has been telling about it."
                )
            ),
            modernApplication = "Say the three lines slowly, one per breath. On the last one, name three things you can see right now. Then choose the smallest next action and do only that.",
            closing = "The present moment is smaller than your fears.",
            reflectionPrompt = "Which strings are pulling at you most right now? What is actually here in this moment?"
        ),

        // q302, Marcus Aurelius (procrastinating)
        "q302" to QuoteInsight(
            intro = "When you have been thinking about the person you want to be instead of being that person, Marcus Aurelius offers a gentle push he gave himself: stop talking and begin.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Be Such",
                    blockquote = "No longer talk at all about the kind of man that a good man ought to be, but be such.",
                    body = "Marcus wrote this in his private notebook, so it was meant for himself, not for an audience. He knew how easily planning a good life can stand in for living it. Thinking about who you ought to be can feel productive, but it can also become a place to hide. The good news is that being such a person does not require a grand change. It can start with one honest action, taken now, in the direction you already know is right."
                )
            ),
            modernApplication = "Pick one quality you want to have, such as patience or follow-through, and do one small act of it in the next ten minutes. Let the act speak instead of the plan.",
            closing = "One small act says more than a long plan.",
            reflectionPrompt = "What kind of person do you keep describing to yourself? What is one thing that person would do right now?"
        ),

        // q303, Seneca (procrastinating)
        "q303" to QuoteInsight(
            intro = "When you keep pushing things to tomorrow, Seneca offers a steady practice: settle each day as it comes, so nothing important piles up waiting.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Balancing the Day",
                    blockquote = "Let us postpone nothing. Let us balance life's account every day.",
                    body = "Seneca wrote this to Lucilius after the sudden death of an acquaintance reminded him how little any of us can count on later. His point was not to frighten, but to free. When we postpone, part of life is always left unfinished, and that unfinished part breeds worry about the future. Balancing the account each day means doing what matters today and letting the day be complete. A finished day is easier to rest in than a postponed one."
                )
            ),
            modernApplication = "Before evening, ask: what one thing would make today feel complete? Do it now, even in a small form, so the day can close cleanly.",
            closing = "Let today be finished, not postponed.",
            reflectionPrompt = "What is one thing you have been carrying from day to day? What would it take to settle it today?"
        ),

        // q304, Marcus Aurelius (stuck)
        "q304" to QuoteInsight(
            intro = "When something blocks your way and you feel stuck, Marcus Aurelius offers a quiet reversal: the obstacle itself can become part of the path.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Obstacle Becomes the Road",
                    blockquote = "that which is an obstacle on the road helps us on this road.",
                    body = "Marcus wrote this in a note to himself about people who got in the way of his work. He could not control what they did, but he noticed that his mind could still choose how to respond. A blocked plan asks for patience, honesty, or a new approach, and each of those is a way forward. Being stuck does not mean nothing is happening. It may mean the road has turned, and the turn is asking something of you."
                )
            ),
            modernApplication = "Name the thing blocking you in one plain sentence. Then ask: what quality does this obstacle give me a chance to use right now? Patience, a request for help, a smaller step. Pick one and do it.",
            closing = "What stands in the way can still carry you forward.",
            reflectionPrompt = "What is this obstacle asking of you? How could it become part of your path?"
        ),

        // q305, Marcus Aurelius (stuck)
        "q305" to QuoteInsight(
            intro = "When your plans stall and the way ahead feels closed, Marcus Aurelius suggests a gentle move: accept the block, and turn to what is still allowed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Is Still Allowed",
                    blockquote = "another opportunity of action is immediately put before you in place of that which was hindered.",
                    body = "In this note, Marcus is reminding himself to build his life one act at a time, doing each as well as he can. He knew that outside things would get in the way. His answer was not to push harder against the wall, but to accept it and look to the side. When you stop straining against what is closed, you can see what is open. There is almost always some small, good action still within reach, even if it is not the one you planned."
                )
            ),
            modernApplication = "Write down the action you cannot take right now. Next to it, write one action that is still allowed today, however small. Give that one your full attention for the next ten minutes.",
            closing = "When one way closes, look for the way that is open.",
            reflectionPrompt = "What are you pushing against that will not move? What is one thing you are still free to do?"
        ),

        // q306, Marcus Aurelius (helpless)
        "q306" to QuoteInsight(
            intro = "When you feel helpless against something outside you, Marcus Aurelius points to one place where you still have power: your judgment about it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Power Left to You",
                    blockquote = "it is not this thing that disturbs you, but your own judgment about it. And it is in your power to wipe out this judgment now.",
                    body = "Marcus does not pretend that hard things are not hard, and this is not a demand to stop hurting. He is saying that between the event and your pain there is a layer: the story you tell yourself about what it means. That story often says \"this is unbearable\" or \"nothing can be done.\" You may not be able to change the event. But you can question that story and soften it, right now. That is the one kind of power no one can take from you."
                )
            ),
            modernApplication = "Notice the sentence your mind keeps repeating, such as \"I can't handle this.\" Try replacing it with something truer and kinder, like \"This is hard, and I can take the next small step.\" Say it slowly once.",
            closing = "You can still choose what you tell yourself.",
            reflectionPrompt = "What story are you telling yourself about this? What would a gentler, truer version sound like?"
        ),

        // q307, Marcus Aurelius (helpless)
        "q307" to QuoteInsight(
            intro = "When you feel powerless and at the mercy of others, Marcus Aurelius offers steady reassurance: no one can stop you from living by your own good sense.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "No One Can Take This",
                    blockquote = "No man will hinder you from living according to the reason of your own nature",
                    body = "Other people can block your plans, change your circumstances, or refuse what you ask. Marcus knew this well. But he saw that one thing stays in your keeping: how you choose to think and act in response. You can still be honest, kind, and fair, whatever others do. He also trusted that what happens is part of a larger order, not aimed at you. Both thoughts can steady you when you feel pushed around by events."
                )
            ),
            modernApplication = "Write down one thing someone else is preventing. Then write one thing they cannot prevent, like how you speak to yourself or the care you put into your next task. Spend a few minutes on that second thing.",
            closing = "Your way of living stays in your own hands.",
            reflectionPrompt = "What is still yours to choose, even here? How do you want to act in this moment?"
        ),

        // q308, Marcus Aurelius (insecure)
        "q308" to QuoteInsight(
            intro = "When you feel unsure of yourself and hang on what others think, Marcus Aurelius notices a strange habit we share: we love ourselves most, yet trust others' opinions of us more than our own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Whose Opinion Counts",
                    blockquote = "every man loves himself more than all the rest of men, but yet sets less value on his own opinion of himself than on the opinion of others.",
                    body = "Marcus, an emperor surrounded by praise and criticism, still found this puzzling. If you would not let a stranger decide what you eat or where you live, why let their passing opinion decide your worth? Other people see only a small slice of you, filtered through their own worries. You see your intentions, your effort, and your growth. Your own honest view of yourself deserves at least as much weight as theirs."
                )
            ),
            modernApplication = "Notice whose approval you are waiting for right now. Then ask yourself, \"What do I honestly think of how I am handling this?\" Answer as kindly and fairly as you would for a friend.",
            closing = "Your own fair view of yourself matters most.",
            reflectionPrompt = "Whose opinion are you giving the most weight to today? What is your own honest view?"
        ),

        // q309, Seneca (regretful)
        "q309" to QuoteInsight(
            intro = "When regret about lost time weighs on you, Seneca offers a fresh start: begin living now, and treat each day as a whole life of its own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Each Day a Whole Life",
                    blockquote = "Begin at once to live, and count each separate day as a separate life.",
                    body = "Seneca wrote this to Lucilius in a letter about how uncertain the future is and how easy it is to keep postponing life for some later plan. His answer is to make each day complete in itself, a rounded whole. Regret often comes from looking back at all the days that did not go as we hoped. But you do not have to fix the past to live well today. Today can be begun and finished with care, whatever came before."
                )
            ),
            modernApplication = "Tonight, before sleep, name one thing you did today with care. Tomorrow morning, decide one thing that would make the day feel complete, and do it.",
            closing = "Today is a whole life waiting to be lived.",
            reflectionPrompt = "What would make today feel complete? What could you begin right now?"
        ),

        // q310, Marcus Aurelius (ashamed)
        "q310" to QuoteInsight(
            intro = "When shame makes you feel that nothing good is left in you, Marcus Aurelius offers a hopeful image: within you is a fountain of good that keeps rising when you dig.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Fountain Within",
                    blockquote = "Look within. Within is the fountain of good, and it will ever bubble up, if you will ever dig.",
                    body = "Marcus wrote this short line to himself, a reminder he clearly needed too. Shame tells you that what you did is who you are. Marcus saw it differently. Beneath mistakes and regrets, there is a source of goodness that does not run dry. It may be covered over, but it is still there. Digging means paying attention to it: your care for others, your wish to do better, your honesty in feeling this way at all."
                )
            ),
            modernApplication = "Take a slow breath and name one good quality you know is in you, even on hard days. Kindness, loyalty, effort. Say it to yourself: \"This is still in me.\"",
            closing = "The good in you has not run dry.",
            reflectionPrompt = "What good in you feels hidden right now? What could help you dig toward it?"
        ),

        // q311, Marcus Aurelius (ashamed)
        "q311" to QuoteInsight(
            intro = "When you feel ashamed of what you lack, Marcus Aurelius turns your attention to qualities fully in your power, ones you can show right now.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Qualities Within Your Reach",
                    blockquote = "Show those qualities then which are altogether in your power",
                    body = "Marcus began this note by imagining someone saying that people do not admire his cleverness. Fine, he answered, but there are many good qualities that do not depend on natural gifts. Sincerity, endurance, contentment with little, kindness, frankness: these are open to anyone, at any moment. Shame often fixes on what we cannot change about ourselves. Marcus points instead to what you can begin showing today."
                )
            ),
            modernApplication = "Choose one quality from Marcus's list, perhaps sincerity or benevolence. Look for one chance in the next hour to show it, such as an honest word or a small kindness.",
            closing = "Show what is already within your power.",
            reflectionPrompt = "Which of these qualities could you show today? What small chance might you find?"
        ),

        // q312, Marcus Aurelius (guilty)
        "q312" to QuoteInsight(
            intro = "When guilt over a failure weighs on you, Marcus Aurelius offers gentle advice: do not despair, come back, and be content if most of what you do is good.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Returning After a Fall",
                    blockquote = "when you have failed, return back again, and be content if the greater part of what you do is consistent with man's nature.",
                    body = "Marcus wrote this to himself, which means he failed too and needed the reminder. He did not ask for perfection. He asked himself not to be disgusted or discouraged, and to come back to his principles after each slip. Guilt can make one mistake feel like the whole story. Marcus measured himself by the greater part of his life, not by its worst moment. Returning is what matters, and you can return today."
                )
            ),
            modernApplication = "Acknowledge the failure in one plain sentence. Then name one small action that puts you back on track, such as an apology, a repair, or a single good act. Do it today.",
            closing = "Return, and let the greater part of your life count.",
            reflectionPrompt = "What is one way you can return today? What does the greater part of your life say about you?"
        ),

        // q313, Marcus Aurelius (guilty)
        "q313" to QuoteInsight(
            intro = "When guilt pulls your thoughts in every direction, Marcus Aurelius narrows the focus: attend to yourself, and aim to be good in each act.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Good Act at a Time",
                    blockquote = "Only attend to yourself, and resolve to be a good man in every act which you do.",
                    body = "Marcus wrote this after reminding himself that others had faced the same troubles and been needlessly upset by them. Guilt often spins into replaying the past and imagining what others think. Marcus brings it back to something you can do: the act in front of you. You cannot redo yesterday. You can make this next act a good one, and then the next. That is how a life is mended, one act at a time."
                )
            ),
            modernApplication = "Ask, \"What is the next good act I can do right now?\" It might be a kind message, a careful piece of work, or rest so you can do better tomorrow. Do that one thing well.",
            closing = "The next good act is always available.",
            reflectionPrompt = "What is the next act in front of you? How can you make it a good one?"
        ),

        // q314, Marcus Aurelius (lonely)
        "q314" to QuoteInsight(
            intro = "When you feel cut off from everyone, Marcus Aurelius notices how deeply people are drawn together: sooner would you find earth that touches no earth than a person fully cut off from others.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Never Wholly Separate",
                    blockquote = "Sooner, then, will one find anything earthy which comes in contact with no earthy thing, than a man altogether separated from other men.",
                    body = "In this note, Marcus looked at how like things seek each other in nature: earth falls toward earth, water flows toward water, fire rises toward fire. He saw the same pull among people. We are made for each other, and that pull does not vanish when we feel alone. Loneliness is real and painful. But it is not proof that you are outside the human circle. The thread that ties you to others is still there, even when it feels thin."
                )
            ),
            modernApplication = "Think of one small thread of connection you still have: a neighbor, an old friend, a shopkeeper who knows your face. Reach toward it today in a small way, a greeting or a short message.",
            closing = "The thread connecting you to others is still there.",
            reflectionPrompt = "What threads of connection do you still have, even thin ones? Which one could you strengthen today?"
        ),

        // q315, Marcus Aurelius (lonely)
        "q315" to QuoteInsight(
            intro = "When you feel alone, Marcus Aurelius reminds you of a kinship deeper than family: you belong to the whole human community through the mind you share.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Kin to Everyone",
                    blockquote = "How close is the kinship between a man and the whole human race, for it is a community, not of a little blood or seed, but of intelligence.",
                    body = "Marcus wrote this near the end of his notes, in a list of truths he wanted to keep close. He saw every person as related, not by blood but by the shared capacity to think, care, and wonder. That kinship does not depend on who is in the room with you. When you feel alone, you are still part of this vast family. Others, right now, are thinking, hoping, and struggling as you are."
                )
            ),
            modernApplication = "Picture someone far away, perhaps also awake and unsettled tonight. Silently wish them well. Let yourself feel that you are part of the same human family.",
            closing = "You belong to a family larger than any room.",
            reflectionPrompt = "Who might be feeling as you do right now? What would you wish for them?"
        ),

        // q316, Marcus Aurelius (rejected)
        "q316" to QuoteInsight(
            intro = "When someone looks down on you, it can feel like a verdict on your worth. Marcus Aurelius, writing private notes to himself, draws a clear line between their contempt and your conduct.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Their Part and Yours",
                    blockquote = "Suppose any man shall despise me. Let him look to that himself. But I will look to this, that I be not discovered doing or saying anything deserving of contempt.",
                    body = "Marcus does not pretend contempt cannot sting. He sorts it. How another person regards you belongs to them, and they will answer for it. What belongs to you is narrower and steadier: whether your own words and actions are worth respecting. You cannot make someone value you, but you can make sure nothing you do gives their rejection real grounds. That is a place you can stand, even while it hurts."
                )
            ),
            modernApplication = "When the sting returns, say quietly: \"That is theirs to look to. Mine is how I act next.\" Then pick one small thing to do today that you would be glad to be seen doing.",
            closing = "Their view is theirs to carry; your conduct is yours.",
            reflectionPrompt = "What would acting well look like in the next hour, whatever they think of you?"
        ),

        // q317, Marcus Aurelius (rejected)
        "q317" to QuoteInsight(
            intro = "Rejection can make you want to pull away from everyone. Marcus offers a different direction: accept the life and the people you have been given, and love them sincerely.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Love the People Here",
                    blockquote = "the men among whom you have received your portion, love them, but do it truly.",
                    body = "When one place of belonging closes, attention can fix on it and miss everyone else nearby. Marcus reminds himself to adapt to the circumstances he actually has, and to love the people who share them. The word that matters is \"truly\": not a polite show, but real warmth offered to real people. You may not have been chosen where you hoped. There are still people around you, a neighbor, a coworker, an old friend, who are part of your portion right now."
                )
            ),
            modernApplication = "Think of one person already in your life who is easy to overlook. Send them a short, honest message today, with no aim beyond letting them know you value them.",
            closing = "Belonging begins with the people already beside you.",
            reflectionPrompt = "Who is already in your portion that you could love a little more truly today?"
        ),

        // q318, Marcus Aurelius (discouraged)
        "q318" to QuoteInsight(
            intro = "When something feels too hard, it is easy to slide into believing it is impossible. Marcus Aurelius catches that slide in himself and turns it around.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Possible for You Too",
                    blockquote = "if anything is possible for man and conformable to his nature, think that this can be attained by yourself too.",
                    body = "Marcus separates two thoughts that discouragement blends together: \"this is hard for me\" and \"this cannot be done.\" Difficulty is real, and he does not deny it. But if other people have done a thing, and it fits human nature, then it is within human reach, and you are human. That does not promise it will be quick or easy. It only means the path is not closed to you."
                )
            ),
            modernApplication = "Think of someone who has done the thing you are struggling with. Remind yourself: \"They are a person, and so am I.\" Then take the smallest step they would have taken at the start.",
            closing = "Hard is not the same as impossible.",
            reflectionPrompt = "Who has done something like this before, and what was their first small step?"
        ),

        // q319, Marcus Aurelius (discouraged)
        "q319" to QuoteInsight(
            intro = "When you have nearly given up on something, practice can feel pointless. Marcus offers a small, physical image that shows why it still matters.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Left Hand's Lesson",
                    blockquote = "Practice yourself even in the things which you despair of accomplishing. For even the left hand, which is ineffectual for all other things for want of practice, holds the bridle more vigorously than the right hand.",
                    body = "Marcus notices that the left hand, clumsy at most tasks, holds a horse's bridle more firmly than the right, because it has been trained for that one job. Skill follows practice more than natural gift. The things you feel worst at may be things you have not yet had the chance to practice. He tells himself to keep practicing even what he despairs of. Despair is a feeling about the future; practice is something you can do today."
                )
            ),
            modernApplication = "Pick the task you feel most hopeless about and give it ten unhurried minutes today. Do not judge the result. Count the minutes as the win.",
            closing = "What is practiced grows strong.",
            reflectionPrompt = "What small part of this could you practice today, without needing it to go well?"
        ),

        // q320, Marcus Aurelius (resentful)
        "q320" to QuoteInsight(
            intro = "When someone has wronged you, the wish to get even can feel like the only way to make it right. Marcus Aurelius suggests a different kind of answer.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Best Revenge",
                    blockquote = "The best way of avenging yourself is not to become like the wrong-doer.",
                    body = "Marcus does not tell himself the wrong did not happen. He asks what kind of response would actually be a victory. If you answer cruelty with cruelty, the other person has changed you into a copy of themselves. Refusing to become like them keeps your character in your own hands. That refusal is not weakness or surrender. It is the one outcome they cannot take from you."
                )
            ),
            modernApplication = "Before you reply, act, or rehearse a comeback, ask: \"Would this make me more like them, or more like myself?\" Choose the response that keeps you yourself.",
            closing = "Stay yourself; that is the answer they cannot touch.",
            reflectionPrompt = "What would you do right now if your only goal was not to become like them?"
        ),

        // q321, Marcus Aurelius (resentful)
        "q321" to QuoteInsight(
            intro = "Resentment keeps carrying someone else's wrong around with you. In one short note to himself, Marcus suggests putting it down where it belongs.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Leave It Where It Is",
                    blockquote = "It is your duty to leave another man's wrongful act there where it is.",
                    body = "The wrong belongs to the person who did it. It sits with them, in their choices. Resentment picks it up and brings it home: you replay it, reshape it, and feel it again. Marcus calls leaving it there a duty, something worth choosing on purpose. This is not saying the act was fine. It is deciding you will not be the one who keeps it alive."
                )
            ),
            modernApplication = "Picture the wrong as an object on the other person's desk. Each time your mind reaches for it today, say, \"That stays there,\" and bring your attention back to your own work.",
            closing = "Their wrong can stay with them.",
            reflectionPrompt = "What would you carry differently today if this wrong stayed where it was done?"
        ),

        // q322, Marcus Aurelius (treated unfairly)
        "q322" to QuoteInsight(
            intro = "Being treated unfairly hurts, and part of that hurt is the story you tell about it. Marcus offers a short exercise for separating what happened from the weight you add.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Remove the Complaint",
                    blockquote = "Take away your opinion, and then there is taken away the complaint, \"I have been harmed.\" Take away the complaint, \"I have been harmed,\" and the harm is taken away.",
                    body = "Marcus describes a chain. First comes your opinion about the event. From the opinion comes the complaint, \"I have been harmed.\" From the complaint comes the felt harm. He suggests working backward. This does not erase what was done, and he is not asking you to pretend it was fair. He is pointing at the part you can loosen: the sense that your inner self has been damaged."
                )
            ),
            modernApplication = "Describe what happened in one plain sentence, with no adjectives and no judgment. Read it back. Notice how much of the weight was in the words you left out.",
            closing = "The event is one thing; the injury is another.",
            reflectionPrompt = "How would you describe what happened if you left out \"I have been harmed\"?"
        ),

        // q323, Marcus Aurelius (treated unfairly)
        "q323" to QuoteInsight(
            intro = "When you are treated unfairly, it is tempting to let it change who you are. Marcus uses the image of an emerald to describe a steadier way.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Keep Your Color",
                    blockquote = "Whatever any one does or says, I must be emerald and keep my color.",
                    body = "An emerald does not stop being green because someone speaks badly of it. Gold does not lose its worth because it is mishandled. Marcus reminds himself that goodness can work the same way. It is part of what you are, not a reward you owe only to people who deserve it. Others can be unfair. They cannot change your nature unless you let their behavior become your own."
                )
            ),
            modernApplication = "Before your next contact with the person who wronged you, picture a deep green stone in your palm. Say to yourself, \"I keep my color,\" and let that guide your tone.",
            closing = "Be the emerald, whatever is said.",
            reflectionPrompt = "What part of who you are do you most want to keep intact through this?"
        ),

        // q324, Marcus Aurelius (burned out)
        "q324" to QuoteInsight(
            intro = "When you are worn down, you may long to escape somewhere far away. Marcus, writing notes to himself amid heavy duties, describes a retreat you can reach without going anywhere.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Retreat Within",
                    blockquote = "Constantly then give to yourself this retreat, and renew yourself; and let your principles be brief and fundamental.",
                    body = "Marcus notes that people seek retreats in the country, by the sea, or in the mountains, but the quietest retreat is in your own mind. He tells himself to go there often and renew himself. The key is to keep a few short, basic principles ready, so that returning to them takes only a moment. When everything feels like too much, you do not need a grand plan. A small place to rest and a few true things to remember can be enough."
                )
            ),
            modernApplication = "Choose two short lines to be your principles, such as \"Do the next right thing\" and \"This will pass.\" Close your eyes for one minute and repeat them slowly.",
            closing = "Your quiet place goes wherever you go.",
            reflectionPrompt = "What two or three plain truths would you want to come back to when you are tired?"
        ),

        // q325, Marcus Aurelius (burned out)
        "q325" to QuoteInsight(
            intro = "Exhaustion often comes from carrying more than is needed. Marcus suggests asking whether everything you are doing and saying is actually necessary.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Less, and Lighter",
                    blockquote = "The greatest part of what we say and do being unnecessary, if a man takes this away, he will have more leisure and less uneasiness.",
                    body = "Marcus observes that most of what we say and do is not necessary. Remove it, and you gain both time and calm. He goes on to say you should ask on every occasion, \"Is this one of the unnecessary things?\" and that this applies to thoughts too, since unnecessary thoughts lead to unnecessary acts. Being worn out is not always about doing too little well. Sometimes it comes from doing too much that does not matter."
                )
            ),
            modernApplication = "Look at today's list and cross off one thing that is not truly necessary. Notice the space it leaves, and do not fill it.",
            closing = "Letting go of the unnecessary is a form of rest.",
            reflectionPrompt = "What is one thing you could stop doing today without losing anything that matters?"
        ),

        // q326, Marcus Aurelius (numb)
        "q326" to QuoteInsight(
            intro = "When you feel flat and disconnected, it can seem like your old self is gone. Marcus wrote this to himself as a reminder that the way back is still within reach.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Seeing Again",
                    blockquote = "To recover your life is in your power. Look at things again as you used to look at them; for in this consists the recovery of your life.",
                    body = "Marcus notes that our principles only fade when the thoughts that keep them alive go out, and that we can fan those thoughts into a flame again. Recovery, for him, begins with looking: seeing things again the way you once did. You do not have to force feeling to return all at once. Remembering how something used to look to you, and looking at it again, is already a start."
                )
            ),
            modernApplication = "Choose one thing you used to love: a song, a place, a photo. Spend a few quiet minutes with it, not demanding to feel anything, only remembering how it once looked to you.",
            closing = "A small spark can be fanned again.",
            reflectionPrompt = "What did you once see with fondness that you could look at again today?"
        ),

        // q327, Marcus Aurelius (numb)
        "q327" to QuoteInsight(
            intro = "Numbness can shrink the world to a dull, small room. Marcus offers a way to widen it again, by lifting your attention to the stars.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Moving With the Stars",
                    blockquote = "Look round at the courses of the stars, as if you were going along with them.",
                    body = "Marcus asks himself to watch the paths of the stars as if he were traveling with them. He adds that such thoughts wash away the grime of ordinary life. There is nothing to achieve here. You are invited to take part in something vast and steady, which keeps moving whether or not you feel much today. Sometimes the first feeling to return is a quiet sense of being part of something larger."
                )
            ),
            modernApplication = "If you can, step outside tonight and look up for a minute. If you cannot, picture the night sky turning slowly above you, and imagine moving with it.",
            closing = "The sky keeps turning, and you turn with it.",
            reflectionPrompt = "What would it be like to feel yourself moving with something larger tonight?"
        ),

        // q328, Marcus Aurelius (restless)
        "q328" to QuoteInsight(
            intro = "When everything around you seems to pull at your attention, Marcus Aurelius asks a plain question: are outside things scattering you? His answer is to give yourself time for something good.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Stop Being Whirled Around",
                    blockquote = "Do the things external which fall upon you distract you? Give yourself time to learn something new and good, and cease to be whirled around.",
                    body = "Marcus wrote these notes to himself, and here he does not tell you to escape the noise. He tells you to give yourself time: a small, deliberate pocket of attention for something worth learning. Restlessness often comes from being pushed by whatever arrives next. Choosing one good thing to attend to turns you from something blown about into someone moving on purpose. The world keeps spinning, but you do not have to spin with it."
                )
            ),
            modernApplication = "Pick one small good thing to learn in the next ten minutes: a paragraph of a book, a new word, the name of a tree outside. Put your phone in another room while you do it.",
            closing = "You can choose what you turn toward.",
            reflectionPrompt = "What is pulling at you most right now? What one good thing could you give your attention to instead?"
        ),

        // q329, Marcus Aurelius (restless)
        "q329" to QuoteInsight(
            intro = "When something has thrown you off balance, Marcus Aurelius does not ask you to never be shaken. He asks you to come back to yourself quickly, and to keep coming back.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Returning to the Harmony",
                    blockquote = "When you have been compelled by circumstances to be disturbed in a manner, quickly return to yourself, and do not continue out of tune longer than the compulsion lasts; for you will have more mastery over the harmony by continually recurring to it.",
                    body = "Marcus admits that circumstances will sometimes force a disturbance on you. That part is not a failure. What he watches is how long you stay out of tune after the pressure has passed. His image is musical: a player who keeps returning to the true note grows more skilled at finding it. Each time you notice you have drifted and gently come back, you are practicing. Calm is less a place you live than a home you keep returning to."
                )
            ),
            modernApplication = "Choose an anchor, like three slow breaths or placing your feet flat on the floor. Each time you notice you are agitated today, use it, and count the return as a small win.",
            closing = "Every return makes the next one easier.",
            reflectionPrompt = "Has the thing that disturbed you actually passed? What would it feel like to come back to yourself now?"
        ),

        // q330, Marcus Aurelius (confused)
        "q330" to QuoteInsight(
            intro = "When everything feels tangled and you do not know where to start, Marcus Aurelius cuts it down to two plain tests: is it right, and is it true?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Two Plain Tests",
                    blockquote = "If it is not right, do not do it; if it is not true, do not say it.",
                    body = "Marcus wrote this as a reminder to himself, and its strength is how little it asks. You may not see the whole path, and that is all right. You can still check the next action: is it right? And the next words: are they true? Confusion often comes from trying to solve everything at once. These two questions shrink the problem to the size of a single choice, which you can make even when the bigger picture is blurry."
                )
            ),
            modernApplication = "Before your next decision or message today, pause and ask the two questions, out loud or in your head. If either answer is no, wait.",
            closing = "Right action and true words are always within reach.",
            reflectionPrompt = "Is there something you are about to do or say that fails one of these tests? What would pass both?"
        ),

        // q331, Marcus Aurelius (confused)
        "q331" to QuoteInsight(
            intro = "When you cannot tell which way to go, Marcus Aurelius gives you permission to stop. If you see clearly, go on content. If you do not, pause and seek good counsel.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Permission to Pause",
                    blockquote = "If you see clear, go by this way content, without turning back; but if you do not see clear, stop and take the best advisers.",
                    body = "There is no shame in not seeing clearly. Marcus, who carried the weight of ruling an empire, wrote that when the way is unclear, the right move is to stop and ask those whose judgment you trust. He also says that once the way is clear, you can walk it without looking back. Confusion is not a command to act fast. It is a signal to slow down and gather wisdom. Pausing here is not weakness. It is good judgment."
                )
            ),
            modernApplication = "Name one person whose judgment you respect and write down the question you would ask them. If you can, send it. Until then, let the decision wait.",
            closing = "Not knowing yet is allowed.",
            reflectionPrompt = "Do you see clearly right now, or not yet? Who could help you see?"
        ),

        // q332, Marcus Aurelius (regretful)
        "q332" to QuoteInsight(
            intro = "When the past keeps pulling you back, Marcus Aurelius suggests a three-part rest: let the past go, trust the future, and give your care to the present.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Setting Down the Past",
                    blockquote = "Take no notice of all the past, and trust the future to providence, and direct the present only conformably to piety and justice.",
                    body = "Marcus wrote this at the start of the last book of his notes to himself. He does not deny that the past happened. He says to stop dwelling on it, because no amount of attention can change it. The future, too, is not yours to control. What remains is the present, and there he asks only that you act with reverence and fairness. Regret grows lighter when you put your energy where it can still do some good."
                )
            ),
            modernApplication = "When a regret comes up today, say to yourself, 'That is past.' Then ask what one fair or kind thing you can do in the next hour.",
            closing = "The present is where repair begins.",
            reflectionPrompt = "What part of the past are you holding most tightly? What kind act is possible now?"
        ),

        // q333, Seneca (regretful)
        "q333" to QuoteInsight(
            intro = "If you regret putting things off, Seneca meets you there in his very first letter to Lucilius: take hold of today's task, and tomorrow will need to carry less.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Taking Hold of Today",
                    blockquote = "Lay hold of today's task, and you will not need to depend so much upon tomorrow's. While we are postponing, life speeds by.",
                    body = "Seneca's first letter is about time, and how it slips away while we wait for a better moment. He does not scold. He reminds Lucilius that nothing is truly ours except time, and that grasping the present hour lightens tomorrow. Regret about postponing can turn into more postponing, because the backlog feels too heavy. The way out is small. One task taken up today is one less weight, and one less regret, later."
                )
            ),
            modernApplication = "Pick the smallest task you have been avoiding and do only the first five minutes of it now. Let that be enough for this moment.",
            closing = "One task today is a gift to tomorrow.",
            reflectionPrompt = "What one small task could you take hold of right now? How might it feel to have it begun?"
        ),

        // q334, Marcus Aurelius (jealous envious)
        "q334" to QuoteInsight(
            intro = "When your eyes keep landing on what others have and you lack, Marcus Aurelius suggests turning toward what you already have, and imagining how much you would miss it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Treasuring What You Have",
                    blockquote = "Think not so much of what you have not as of what you have: but of the things which you have select the best, and then reflect how eagerly they would have been sought, if you had them not.",
                    body = "Envy narrows attention to the gap between your life and someone else's. Marcus asks you to widen it again. Pick the best things you already have and picture how eagerly you would seek them if they were gone. He adds a caution in the same note: do not cling so tightly that losing them would wreck your peace. The aim is appreciation, not grasping. Gratitude does not deny what you want. It reminds you what you hold."
                )
            ),
            modernApplication = "Write down three good things in your life right now. For each, picture for a moment not having it, then let yourself feel glad it is here.",
            closing = "What you have is already worth a great deal.",
            reflectionPrompt = "Which of your blessings would you miss most? How could you enjoy it today?"
        ),

        // q335, Marcus Aurelius (jealous envious)
        "q335" to QuoteInsight(
            intro = "When you find yourself watching what others say, do, or have, Marcus Aurelius notes how much trouble you spare yourself by looking at your own conduct instead.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Eyes on Your Own Path",
                    blockquote = "How much trouble he avoids who does not look to see what his neighbor says or does or thinks, but only to what he does himself, that it may be just and pure.",
                    body = "Marcus wrote this to himself as a relief, not a rule. Comparing yourself with a neighbor drains energy you could spend on your own life. His alternative is to ask whether what you do is just and pure. That question has an answer you can work on, while the question of someone else's life does not. Turning your eyes home is not shutting others out. It is choosing to tend the one garden you can actually tend."
                )
            ),
            modernApplication = "Next time you catch yourself checking on someone else's success, close the app or look away and ask, 'What is one fair thing I can do today?' Then do it.",
            closing = "Your own conduct is the field worth tending.",
            reflectionPrompt = "Whose life have you been watching closely? What in your own life deserves that attention?"
        ),

        // q336, Marcus Aurelius (unmotivated)
        "q336" to QuoteInsight(
            intro = "If getting up feels heavy, you are in good company. Marcus Aurelius wrote to himself about rising unwillingly, and he gave himself a reason: I am rising to the work of a human being.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Work of a Human Being",
                    blockquote = "In the morning when you rise unwillingly, let this thought be present: I am rising to the work of a human being.",
                    body = "Even an emperor found it hard to leave his warm blankets; in the same note Marcus asks himself whether he was made to lie in bed and keep warm. He did not shame himself for it. Instead he reminded himself what he was rising for: the work people are made for, being useful and kind toward others. Low motivation often comes from forgetting why something matters. A purpose, even a small one, can make the first step lighter."
                )
            ),
            modernApplication = "Tomorrow morning, before you sit up, say one sentence to yourself about who you are getting up for. It can be a friend, a coworker, or your future self.",
            closing = "You are rising for something that matters.",
            reflectionPrompt = "What small piece of human work is waiting for you today? Who might it help?"
        ),

        // q337, Marcus Aurelius (unmotivated)
        "q337" to QuoteInsight(
            intro = "When everything feels like too much, Marcus Aurelius suggests a gentler measure of success: be content if the smallest thing goes well, and count it as no small matter.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Small Things Count",
                    blockquote = "Be content if the smallest thing goes on well, and consider such an event to be no small matter.",
                    body = "In this note Marcus tells himself not to expect Plato's ideal republic. He would rather see a little good done well than wait for grand results. Lack of motivation often grows from setting the bar so high that starting feels pointless. Marcus lowers the bar without lowering your worth. One dish washed, one email sent, one walk taken: each is a real thing that went well. Let it count."
                )
            ),
            modernApplication = "Choose the smallest useful task you can think of and do it now. When it is done, pause and say, 'That went well.'",
            closing = "A small thing done well is not small.",
            reflectionPrompt = "What small thing could go well in the next ten minutes? Will you let it count?"
        ),

        // q338, Marcus Aurelius (hopeless)
        "q338" to QuoteInsight(
            intro = "When everything feels dark and fixed, Marcus Aurelius offers a quiet possibility: much of the weight comes from how things look to you, and that view can shift. Beyond it, he promises calm water.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Rounding the Headland",
                    blockquote = "Consider that everything is opinion, and opinion is in your power. Take away then, when you choose, your opinion, and like a mariner who has doubled the promontory, you will find calm, everything stable, and a waveless bay.",
                    body = "Marcus is not saying your pain is imagined. He is saying that the judgments layered on top of events, such as 'this will never change' or 'nothing can help,' are yours to examine. His image is a sailor rounding a rocky point after rough seas and finding a still bay on the other side. Hopelessness can feel like the whole ocean. Marcus reminds himself, and you, that calmer water may be closer than it looks."
                )
            ),
            modernApplication = "Notice one hopeless thought, like 'it will always be like this.' Gently ask, 'Do I know that for certain?' Let even a small doubt in.",
            closing = "Calm water may lie past the next headland.",
            reflectionPrompt = "What thought is making this feel hopeless? Is there a gentler way to hold it, even for a moment?"
        ),

        // q339, Marcus Aurelius (hopeless)
        "q339" to QuoteInsight(
            intro = "When troubles keep crashing over you, Marcus Aurelius offers an image of steadiness: a rocky headland that the waves break against, standing firm while the water calms around it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Standing Like the Headland",
                    blockquote = "Be like the promontory against which the waves continually break, but it stands firm and tames the fury of the water around it.",
                    body = "Marcus does not pretend the waves stop. They keep coming. But the headland is still there after each one. In the same note he turns from 'unhappy am I because this has happened' toward bearing it, neither crushed by the present nor fearing the future. That is not a demand to feel fine. It is a reminder that you have stood through waves before. Your steadiness may be quieter than you think, and it is still there."
                )
            ),
            modernApplication = "Sit or stand with your feet planted. Breathe slowly and picture yourself as that rock. With each breath, say, 'This wave will pass, and I am still here.'",
            closing = "The waves come, and you are still standing.",
            reflectionPrompt = "What waves have you already stood through? What helps you stay steady now?"
        ),

        // q340, Epictetus (overwhelmed)
        "q340" to QuoteInsight(
            intro = "When feelings come too fast to sort, Epictetus offers a way to slow them down: speak to the impression directly and ask it to wait.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Asking Appearances to Wait",
                    blockquote = "Be not hurried away by the rapidity of the appearance, but say, Appearances, wait for me a little; let me see who you are, and what you are about; let me put you to the test.",
                    body = "For Epictetus, an appearance is the first impression something makes on you: this is a disaster, this is too much. These impressions arrive quickly and ask to be believed at once. Epictetus, who was born enslaved and later taught in Nicopolis, trained his students to pause before agreeing. You can treat the rush of thoughts as visitors at the door. You do not have to let each one in. You can ask who it is and what it wants, and only then decide."
                )
            ),
            modernApplication = "When a thought like \"I can't handle this\" arrives, say to it: \"Wait a little. Let me see what you are.\" Write it down and ask whether it is a fact or an impression.",
            closing = "You are allowed to take a moment before believing a thought.",
            reflectionPrompt = "Which impression is rushing you right now? What would you find if you asked it to wait?"
        ),

        // q341, Epictetus (overwhelmed)
        "q341" to QuoteInsight(
            intro = "When there is more to do than any one person can do, Epictetus offers a permission that can feel surprising: some things must be set down, and some can wait.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Setting Some Things Down",
                    blockquote = "You must leave alone some things entirely, and postpone others for the present.",
                    body = "Epictetus wrote this about anyone reaching for what matters most: you cannot pursue everything at once and do it well. Choosing what to put aside is not failure. It is how a person makes room for what counts. When you feel overwhelmed, it can seem as if every task is equally urgent. Usually that is not true. Some things can be let go entirely, and others can rest for a while without harm."
                )
            ),
            modernApplication = "Make three short lists: what matters today, what can wait, and what you can let go of entirely. Move at least one item off today's list before you start.",
            closing = "Letting some things wait is part of doing things well.",
            reflectionPrompt = "What could you leave alone entirely? What could rest until later this week?"
        ),

        // q342, Seneca (overwhelmed)
        "q342" to QuoteInsight(
            intro = "When you are trying to take in too much at once, Seneca offers advice he gave his friend Lucilius: match the load to what you can carry.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Burden Suited to You",
                    blockquote = "The burden should be suited to your strength, nor should you tackle more than you can adequately handle. Absorb not all that you wish, but all that you can hold.",
                    body = "Seneca wrote this to Lucilius, who was so eager to learn philosophy that his eagerness was getting in its own way. Seneca told him that understanding comes from taking the parts one at a time, not from seizing everything in a mass. The same holds for any heavy season. Trying to absorb every task, every worry, and every piece of news at once only spills it. Taking in what you can hold is not weakness. It is how anything is carried well."
                )
            ),
            modernApplication = "Pick a portion you can really hold today, one task, one conversation, one page, and give it your full attention. When it is done, choose the next portion.",
            closing = "Take in what you can hold, and let that be enough for now.",
            reflectionPrompt = "What is a load you could carry well today? What are you trying to hold that could be put down?"
        ),

        // q343, Seneca (overwhelmed)
        "q343" to QuoteInsight(
            intro = "When troubles are already heavy, Seneca gently points out one weight we sometimes add ourselves: going over and over how hard it all is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Adding to the Load",
                    blockquote = "Do not of your own accord make your troubles heavier to bear and burden yourself with complaining.",
                    body = "Seneca wrote this in a letter to Lucilius, who was ill, and he drew on his own memories of sickness. He was not saying the trouble is unreal. He was saying that repeating the complaint, to others and inside your own head, makes the burden feel heavier than it is. In the same letter he notes that pain is lighter when opinion adds nothing to it. You can admit that this is hard and still choose not to keep retelling it."
                )
            ),
            modernApplication = "Say once, clearly, what is hard right now, aloud or on paper. Then say: \"That is enough said.\" Turn to one small thing you can do next.",
            closing = "Name the trouble once, then set the retelling down.",
            reflectionPrompt = "Is there a complaint you keep repeating to yourself? What would be left if you let it rest?"
        ),

        // q344, Seneca (overwhelmed)
        "q344" to QuoteInsight(
            intro = "When the world around you is loud and demanding, Seneca offers a picture from his own life: calm can be made on the inside, even when the outside is noisy.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Quiet Within the Noise",
                    blockquote = "I force my mind to concentrate, and keep it from straying to things outside itself; all outdoors may be bedlam, provided that there is no disturbance within.",
                    body = "Seneca wrote this letter while lodging above a public bath, surrounded by shouting, splashing, and street sellers calling out their wares. He admitted the noise was real. What he found was that the deeper disturbance came from inside, when fear and desire were quarreling in his chest. Outside chaos does not have to set the tone. You may not be able to quiet everything around you, but you can turn your attention gently back to one place."
                )
            ),
            modernApplication = "Choose one point of focus, your breath, the task in your hands, or a single word, and return to it each time your attention is pulled away. Count each return as a success, not a failure.",
            closing = "Let the noise stay outside while you stay steady inside.",
            reflectionPrompt = "What is the loudest thing around you right now? What would quiet look like inside you?"
        ),

        // q345, Marcus Aurelius (procrastinating)
        "q345" to QuoteInsight(
            intro = "When you have been waiting for the right moment to look after yourself, Marcus Aurelius offers a kind but clear reminder: help yourself while you still can.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Coming to Your Own Aid",
                    blockquote = "Come to your own aid, if you care at all for yourself, while it is in your power.",
                    body = "Marcus wrote this to himself, urging himself to stop wandering and to hurry toward what mattered. Notice the tenderness in it: if you care at all for yourself. Putting things off often hurts the very person who will have to face them later, which is you. Taking a step now is a way of being kind to your future self. The power to act is here today, and it is worth using while it is in your hands."
                )
            ),
            modernApplication = "Think of one thing your future self will thank you for, and give it ten minutes now. Set a timer, begin, and let yourself stop when it rings if you need to.",
            closing = "Starting now is a kindness to yourself.",
            reflectionPrompt = "What would caring for yourself look like in the next hour? What is one way to come to your own aid today?"
        ),

        // q346, Marcus Aurelius (procrastinating)
        "q346" to QuoteInsight(
            intro = "When you notice how long something has been waiting, Marcus Aurelius offers an honest look rather than a harsh one: the chances keep coming, and you can still take this one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Opportunity in Front of You",
                    blockquote = "Remember how long you have been putting off these things, and how often you have received an opportunity from the gods, and yet do not use it.",
                    body = "Marcus wrote this to himself, and it reads as an emperor being honest about his own delays. He does not dwell in shame. He remembers how often he has been given an opening, and that the present one will not wait forever. The weight of past delays can make starting feel harder, as if it is too late. But each day brings a fresh opportunity. Remembering the delays is useful only as a nudge toward using this one."
                )
            ),
            modernApplication = "Name the thing you have been putting off, then shrink it to a first step that takes under five minutes. Do that step before you do anything else.",
            closing = "This opportunity is still open to you.",
            reflectionPrompt = "What have you been putting off the longest? What is the smallest first step you could take today?"
        ),

        // q347, Epictetus (procrastinating)
        "q347" to QuoteInsight(
            intro = "When you feel you can begin properly some other day, Epictetus offers a vivid picture: the contest is not later, it is now.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Contest Is Now",
                    blockquote = "Remember that now is the contest, now are the Olympic games, and they cannot be deferred.",
                    body = "Epictetus taught students in Nicopolis, and he knew how easily they planned to improve someday. He compared life to the Olympic games: the athlete cannot ask the games to wait until he feels ready. In the same passage he asks what teacher they are still waiting for before they begin correcting themselves. Today's small task is the event you are actually entered in. You do not need to feel ready to step forward."
                )
            ),
            modernApplication = "Treat the next half hour as your event. Clear the space, choose one task, and begin without waiting to feel ready. Let readiness catch up with you once you have started.",
            closing = "You are already entered in today's contest.",
            reflectionPrompt = "What would it mean to treat today as the real event? What are you waiting to feel before you start?"
        ),

        // q348, Epictetus (procrastinating)
        "q348" to QuoteInsight(
            intro = "When you plan to focus tomorrow, Epictetus asks a plain question: if attention is good tomorrow, why not today?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Attention Today",
                    blockquote = "If it is good to use attention tomorrow, how much better is it to do so today?",
                    body = "In his discourse on attention, Epictetus warns against letting attention slip while telling ourselves we will gather it again whenever we choose. Each delay makes the next one easier. Attention is not something you store up for a better day. It is something you use now, in small ways, with whatever is in front of you. The good you hope to do tomorrow is available today, in a smaller and more ordinary form."
                )
            ),
            modernApplication = "Give five minutes of full attention to one thing right now: one email, one page, one drawer. When the five minutes end, decide whether to keep going.",
            closing = "The attention you want tomorrow is available today.",
            reflectionPrompt = "What would five minutes of real attention change today? Where is your attention going instead?"
        ),

        // q349, Epictetus (procrastinating)
        "q349" to QuoteInsight(
            intro = "When putting things off has started to feel like proof that you are not good enough, Epictetus offers a different question: how long will you wait to believe you are worthy of the best things?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Worthy of the Best",
                    blockquote = "How long will you then still defer thinking yourself worthy of the best things?",
                    body = "Epictetus asked this of students who already knew the principles but kept postponing the work of living them. Behind procrastination there is often a quiet doubt: maybe I am not the kind of person who does this well. Epictetus treats worthiness as something you choose to claim, not something you wait to earn. You do not need to become a different person first. You can treat yourself as someone capable of good things today."
                )
            ),
            modernApplication = "Say to yourself: \"I am worth the effort this takes.\" Then do one small piece of the task you have been delaying, as someone who deserves to see it done.",
            closing = "You do not have to earn the right to begin.",
            reflectionPrompt = "Where are you waiting to feel worthy? What would you do today if you already believed you were?"
        ),

        // q350, Seneca (procrastinating)
        "q350" to QuoteInsight(
            intro = "When you keep preparing to start your real life, Seneca shares a saying with his friend Lucilius: the mistake is to be always getting ready.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Living, Not Getting Ready",
                    blockquote = "he is always getting ready to live.",
                    body = "Seneca closed one letter to Lucilius with this saying and asked him to reflect on what it means. He described people who lay new foundations every day and keep starting fresh plans without ever living in them. The words are blunt, but the invitation behind them is kind. Your life is not waiting at the end of preparation. It is already here, in this ordinary day, and it can be lived now, imperfect plans and all."
                )
            ),
            modernApplication = "Notice one thing you are waiting to do until conditions are right. Do a small, imperfect version of it today, and let that count as living rather than preparing.",
            closing = "Your life is already here, ready or not.",
            reflectionPrompt = "What are you getting ready for that you could begin today? What would an imperfect start look like?"
        ),

        // q351, Marcus Aurelius (stuck)
        "q351" to QuoteInsight(
            intro = "If you feel stuck and embarrassed that you cannot manage alone, Marcus Aurelius speaks plainly: there is no shame in being helped.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Climbing With Help",
                    blockquote = "Be not ashamed to be helped",
                    body = "Marcus wrote these notes while leading an army, and he reached for a soldier's image here. A soldier with a lame leg cannot climb the wall alone, but with another's help he can still reach the top. The task is what matters, not whether you did it unaided. Needing help is not a failure of character. It is part of how people have always gotten through hard things together. Letting someone lift you is one more way of doing your part."
                )
            ),
            modernApplication = "Think of one person who could help with one piece of what has you stuck. Write a short, specific ask, such as \"Could you look at this with me for twenty minutes?\" Send it today.",
            closing = "Being helped is still climbing.",
            reflectionPrompt = "Where are you trying to climb alone? Who could offer you a hand?"
        ),

        // q352, Epictetus (stuck)
        "q352" to QuoteInsight(
            intro = "When you feel boxed in with no room to move, Epictetus offers a surprising thought: much of the squeeze comes from our own opinions about the situation.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Loosening the Squeeze",
                    blockquote = "it is we who squeeze ourselves, who put ourselves in straits; that is, our opinions squeeze us and put us in straits.",
                    body = "Epictetus gave the example of a man who wanted a senator's seat at the games and felt cramped and slighted without it. The crowd was not the problem. His wish for that particular seat was. Feeling stuck often works the same way. We hold tight to one idea of how things must go, and everything else starts to feel like a wall. When you notice which opinion is pressing on you, you can loosen your grip on it, and there is often more room than you thought."
                )
            ),
            modernApplication = "Finish this sentence: \"I feel stuck because things must...\" Look at what you wrote. Ask gently whether it truly must, or whether you have been insisting on it. Try holding it a little more loosely.",
            closing = "Some walls are made of opinions, and opinions can soften.",
            reflectionPrompt = "Which belief about how this must go is pressing on you most? What would change if you loosened it?"
        ),

        // q353, Epictetus (stuck)
        "q353" to QuoteInsight(
            intro = "When you feel trapped in the same pattern again and again, Epictetus gives a short, practical answer: you do not fight a habit with willpower alone, you answer it with another habit.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Answering One Habit With Another",
                    blockquote = "What aid, then, can we find against habit? The contrary habit.",
                    body = "Epictetus taught that much of what troubles us is habit: habits of thought, of speech, of reaction. He did not tell his students to feel ashamed of them. He told them to practice the opposite, steadily, until it became familiar. A rut is worn by repetition, and a new path is made the same way. You do not need to change everything today. Each time you choose the new response, the old one loosens its hold a little."
                )
            ),
            modernApplication = "Pick one habit that keeps you stuck, like scrolling when you meant to start, or saying \"I can't\" first. Choose a small opposite action, such as opening the task for two minutes. Do it once now, and once more tomorrow.",
            closing = "A new path is worn the same way the old one was.",
            reflectionPrompt = "What pattern keeps pulling you back? What small opposite action could you repeat?"
        ),

        // q354, Seneca (stuck)
        "q354" to QuoteInsight(
            intro = "When you feel stuck and the urge is to push harder and faster, Seneca offers a vivid picture: in a maze, rushing only tangles you more.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Slowing Down in the Maze",
                    blockquote = "This is what happens when you hurry through a maze; the faster you go, the worse you are entangled.",
                    body = "Seneca wrote this to his friend Lucilius about people who chase peace of mind while piling up more cares and burdens. The harder they strained, the further they drifted from what they wanted. Being stuck can feel urgent, as if speed will free you. But frantic effort often adds knots instead of loosening them. Slowing down is not giving up. It lets you see the turns clearly, so your next step can be a wise one instead of a hurried one."
                )
            ),
            modernApplication = "Stop for one minute. Put both feet on the floor and take three slow breaths. Then ask: what is the very next step, only the next one? Take that step at an unhurried pace.",
            closing = "Slow steps find the way out of a maze.",
            reflectionPrompt = "Where are you rushing in a way that tangles things more? What would a slower next step look like?"
        ),

        // q355, Seneca (stuck)
        "q355" to QuoteInsight(
            intro = "When you feel stuck in the way you are, as if you could never change, Seneca offers real encouragement: even bent timber can be made straight again.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Bent Timber Can Straighten",
                    blockquote = "however much the timber may be bent, you can make it straight again.",
                    body = "Seneca wrote this to Lucilius while admitting that he, too, was still struggling with his faults. He said he did not despair even of someone long set in their ways. Woodworkers use heat and patience to straighten curved beams, and he believed a person is far more pliable than wood. Change rarely comes from one great effort. It comes from steady, careful attention, returned to again and again, until the shape begins to change."
                )
            ),
            modernApplication = "Choose one small thing you want to straighten. Give it five minutes of careful attention today, and again at the same time tomorrow. Let steadiness do the work that force cannot.",
            closing = "Patient attention reshapes what seemed fixed.",
            reflectionPrompt = "What part of your life feels bent out of shape? What small, steady attention could you give it?"
        ),

        // q356, Seneca (stuck)
        "q356" to QuoteInsight(
            intro = "When you have good intentions but feel stuck turning them into action, Seneca names the gap and how to close it: keep going until the inclination becomes a settled purpose.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "From Inclination to Purpose",
                    blockquote = "You must persevere, must develop new strength by continuous study, until that which is only a good inclination becomes a good settled purpose.",
                    body = "Seneca told Lucilius that he could see his friend's progress, but that keeping the resolutions already made matters more than making new, noble ones. A good inclination is a real beginning. It is not yet sturdy, though, and it can wobble when life gets hard. Strength grows by returning to it day after day, through reading, reflection, and small acts. Feeling stuck may only mean your purpose is still young. Keep tending it."
                )
            ),
            modernApplication = "Write down one good intention you already hold. Under it, write a single action you can repeat every day this week, small enough that you will not skip it. Do the first one today.",
            closing = "Keep the resolution you have already made.",
            reflectionPrompt = "Which good intention do you want to make steady? What will you do each day to strengthen it?"
        ),

        // q357, Epictetus (helpless)
        "q357" to QuoteInsight(
            intro = "When illness or physical limits leave you feeling helpless, Epictetus offers a careful distinction: the body can be hindered, but your will, your power to choose, remains your own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Body and the Will",
                    blockquote = "Disease is an impediment to the body, but not to the will, unless the will itself chooses. Lameness is an impediment to the leg, but not to the will.",
                    body = "Epictetus does not say illness or injury is easy, or that it should not hurt. He is pointing out that a limit on the body is not a limit on who you are. Your leg may not carry you far today, but you can still choose how you meet the day: with patience, with honesty, with a small kindness toward yourself. That inner choice stays yours, even when much else feels out of reach."
                )
            ),
            modernApplication = "Place a hand on the part of you that hurts or feels limited and say quietly, \"My body is struggling, and I can still choose how I meet this.\" Then pick one small thing within your reach and do it gently.",
            closing = "Your will can move even when your body cannot.",
            reflectionPrompt = "What is your body asking of you today? What choice is still yours, even within this limit?"
        ),

        // q358, Epictetus (helpless)
        "q358" to QuoteInsight(
            intro = "When something happens that leaves you feeling powerless, Epictetus offers a steady question to turn to: what power do I have for using this?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Turning to Your Own Resources",
                    blockquote = "On the occasion of every event that befalls you, remember to turn to yourself and inquire what power you have for turning it to use.",
                    body = "In the rest of this passage, Epictetus gives examples. Faced with temptation, you may find you have self-control. Faced with pain or toil, endurance. Faced with harsh words, patience. The point is not that hard events are good. It is that you are not empty-handed when they arrive. You carry qualities you have practiced and can draw on. Turning inward to ask what you have is often the first step out of feeling helpless."
                )
            ),
            modernApplication = "Name what has happened in a few words. Then ask: which of my strengths fits this? Patience, endurance, honesty, humor. Choose one and let it guide your next hour.",
            closing = "You never arrive at a hard moment empty-handed.",
            reflectionPrompt = "What strength do you already have that fits this moment? How could you use it today?"
        ),

        // q359, Seneca (helpless)
        "q359" to QuoteInsight(
            intro = "When events are beyond your control and you feel helpless, Seneca does not pretend you can change them. He points instead to what you can grow: a steady heart.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Growing a Stout Heart",
                    blockquote = "We cannot change this order of things; but what we can do is to acquire stout hearts, worthy of good men, thereby courageously enduring chance and placing ourselves in harmony with Nature.",
                    body = "Seneca wrote this to comfort Lucilius after a setback at home that had clearly upset him. He reminded his friend that trouble is part of how the world turns, as storms follow calm and night follows day. We cannot change that order. What we can do is build the courage to meet it. This is not about pretending to feel fine. It is about finding enough steadiness to face what comes, one day at a time, alongside everyone else who has had to do the same."
                )
            ),
            modernApplication = "Say to yourself: \"I cannot change this, but I can meet it with courage.\" Then choose one small brave act for today, like making a call you have avoided or getting through the next hour with care.",
            closing = "Courage grows where control runs out.",
            reflectionPrompt = "What here is beyond your power to change? What would meeting it with courage look like?"
        ),

        // q360, Seneca (helpless)
        "q360" to QuoteInsight(
            intro = "When outcomes feel out of your hands, Seneca draws a clear line: the beginning is yours, the result belongs to fortune, and neither defines your worth.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Your Part and Fortune's Part",
                    blockquote = "The beginning is in our own power; fortune decides the issue, but I do not allow her to pass sentence upon myself.",
                    body = "Seneca wrote that the wise person looks to the reasons for their actions, not to how things turn out. You can choose to start well, to act with care and good intent. After that, many forces you cannot see take over. When things go badly, it is easy to feel that the result is a verdict on you. Seneca refused to let fortune pass that sentence. Your part was the effort, and that part you can still offer, whatever happens next."
                )
            ),
            modernApplication = "Draw a line down a page. On one side, write what is yours to begin. On the other, what fortune will decide. Put your energy into the first column today, and let the second one rest.",
            closing = "Do your part well, and let fortune keep hers.",
            reflectionPrompt = "What part of this is truly yours to begin? Can you let the outcome stop being a judgment of you?"
        ),

        // q361, Seneca (helpless)
        "q361" to QuoteInsight(
            intro = "When you are facing something that cannot be fixed, Seneca offers a short and honest line: what you cannot reform, it is best to endure.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Bearing What Cannot Change",
                    blockquote = "That which you cannot reform, it is best to endure.",
                    body = "This is not a call to give up or to stop caring. Seneca wrote it in a letter urging his friend to meet hardship with courage instead of complaint. Some things will not change no matter how hard we push, and fighting them can wear us out. Enduring means setting down the struggle against what is fixed, so your strength can go to living well alongside it. It is a quiet kind of strength, and it is available to you now."
                )
            ),
            modernApplication = "Name one thing you have been trying to change that will not change. Breathe out slowly and say, \"I can bear this.\" Then turn your attention to one thing you can still tend today.",
            closing = "Enduring is its own quiet strength.",
            reflectionPrompt = "What are you struggling against that cannot be changed? What might you do with the strength you free up?"
        ),

        // q362, Marcus Aurelius (insecure)
        "q362" to QuoteInsight(
            intro = "When you feel unworthy unless someone praises you, Marcus Aurelius offers a calm truth: what is good and beautiful is complete in itself, and praise adds nothing to it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Complete Without Praise",
                    blockquote = "Neither worse then nor better is a thing made by being praised.",
                    body = "Marcus asked whether an emerald becomes worse if no one praises it, or a flower, or gold. Of course not. The same holds for you. The kindness you showed today, the effort you made, the honesty you kept: none of these is made smaller by going unseen. Praise is pleasant, but it does not create worth. It only comments on what was already there, and what was there remains whether anyone speaks of it or not."
                )
            ),
            modernApplication = "Think of one good thing you did recently that no one noticed. Hold it in mind for a moment and say, \"That was good, whether or not anyone saw it.\"",
            closing = "What is good in you needs no audience.",
            reflectionPrompt = "What good have you done lately that went unnoticed? Does it feel any less real?"
        ),

        // q363, Marcus Aurelius (insecure)
        "q363" to QuoteInsight(
            intro = "When you feel you need others to hold you up, Marcus Aurelius offers a quiet invitation: learn to stand on your own feet.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Standing Upright on Your Own",
                    blockquote = "A man then must stand erect, not be kept erect by others.",
                    body = "Marcus wrote this as advice to himself, not as a rule to shame anyone. He wanted a steadiness that did not depend on others' reassurance, because reassurance comes and goes. This does not mean refusing comfort or friendship. It means building a center of your own, a sense of what you value and how you want to act, so that you stay upright even on days when no one is nearby to steady you."
                )
            ),
            modernApplication = "Stand up for a moment, feet planted, shoulders easy. Say to yourself one thing you value, such as \"I keep my word.\" Let that be what holds you up for the next hour.",
            closing = "You can learn to hold yourself up.",
            reflectionPrompt = "What values could you lean on instead of others' approval? How would it feel to stand on them today?"
        ),

        // q364, Epictetus (insecure)
        "q364" to QuoteInsight(
            intro = "When you fear you are nobody, Epictetus pushes back gently: you can be somebody in the things within your power, and there your worth can be great.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Somebody Where It Counts",
                    blockquote = "How will you be nobody nowhere, when you ought to be somebody in those things only which are in your power, in which indeed it is permitted to you to be a man of the greatest worth?",
                    body = "Epictetus was answering the worry that you will live without honor or status, overlooked by the world. He was born enslaved and knew what it was to have no rank. He taught that positions, invitations, and titles are not truly yours to command. Your character is. In how you think, choose, and treat people, you can be a person of the greatest worth, and no one can grant or remove that."
                )
            ),
            modernApplication = "Write down one way you feel like \"nobody\" right now. Next to it, write one quality you can show today, like patience, honesty, or care. Act on it once before the day ends.",
            closing = "Your worth lives in what is yours to do.",
            reflectionPrompt = "Where do you feel overlooked? In what way can you be somebody in what is yours?"
        ),

        // q365, Epictetus (insecure)
        "q365" to QuoteInsight(
            intro = "When someone's opinion of you is weighing you down, Epictetus asks a direct question: is their opinion within your control? If not, it need not rule you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Their Opinion, Not Yours",
                    blockquote = "For another man then to have an opinion about you, of what kind is it? It is a thing independent of the will.",
                    body = "Epictetus was speaking to people who were upset at being pitied or looked down on. His point was not that people do not matter. It was that what another person thinks happens in their mind, not yours. You cannot reach in and change it. You can only tend your own conduct. When you let go of managing their opinion, you free up energy for the part that is truly yours, and that part is enough to work with."
                )
            ),
            modernApplication = "When you catch yourself replaying what someone might think, say quietly, \"That lives in their mind, not mine.\" Then return to one action that is yours to do right now.",
            closing = "Let their opinion stay with them.",
            reflectionPrompt = "Whose opinion are you trying to control? What would you do with the energy you got back?"
        ),

        // q366, Seneca (insecure)
        "q366" to QuoteInsight(
            intro = "When you feel judged and unsure of yourself, Seneca offers a plain reminder to his friend: what you think of yourself matters more than what others think of you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Weighing Judgments Wisely",
                    blockquote = "what you think of yourself is much more to the point than what others think of you.",
                    body = "Seneca wrote this to Lucilius in a letter about the pull of popular approval. He noticed that winning over a crowd often means becoming like it, and that the favor of careless people is easily lost. He wanted his friend to weigh people's judgments rather than count them. A few thoughtful opinions, including your own fair one, are worth more than many passing reactions. Your honest view of yourself is a steadier place to stand."
                )
            ),
            modernApplication = "Ask yourself one honest question: \"Am I acting in a way I respect?\" If the answer is yes, let that be enough for today. If not, choose one small change you would respect.",
            closing = "Weigh opinions; do not merely count them.",
            reflectionPrompt = "Are you acting in a way you respect? What would help you feel more at ease with yourself?"
        ),

        // q367, Seneca (insecure)
        "q367" to QuoteInsight(
            intro = "When you measure yourself against others and come up short, Seneca offers a kinder comparison: look at how far you have come from who you were.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Only Fair Comparison",
                    blockquote = "What have you to do with the others? You have outstripped yourself.",
                    body = "Seneca suggested to Lucilius that when he saw many people ahead of him, he should think of how many were behind. Then he went further: why compare with others at all? The truest measure is the distance between who you were and who you are now. Others started from different places, carried different loads, and walked different roads. Your own growth is the one you can honestly see, and it deserves your notice."
                )
            ),
            modernApplication = "Think of yourself one year ago. Name one thing you handle better now, however small. Write it down and come back to it the next time comparison pulls at you.",
            closing = "Measure yourself against who you used to be.",
            reflectionPrompt = "How have you grown since last year? What would you tell your earlier self?"
        ),

        // q368, Seneca (insecure)
        "q368" to QuoteInsight(
            intro = "When you doubt you can do something hard, Seneca turns the problem around: often it is not the difficulty that shrinks our confidence, but our lack of confidence that makes things seem difficult.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Confidence Before Difficulty",
                    blockquote = "Our lack of confidence is not the result of difficulty; the difficulty comes from our lack of confidence.",
                    body = "Seneca noticed that people often decide a task is impossible before they try it. Yet, he asked, to whom did hard things not seem easier once they were actually doing them? Insecurity tends to make the mountain look taller from below. Starting, even clumsily, often shows that the path is more walkable than it seemed. You do not have to feel sure first. Confidence often arrives after the first step, not before it."
                )
            ),
            modernApplication = "Pick the task you doubt you can do. Set a timer for five minutes and begin the smallest part of it. When the timer ends, notice whether it felt as hard as you expected.",
            closing = "Begin, and let confidence catch up.",
            reflectionPrompt = "What have you decided is too hard before trying? What is the smallest way to begin?"
        ),

        // q369, Epictetus (ashamed)
        "q369" to QuoteInsight(
            intro = "When you feel ashamed of something you did not choose, Epictetus asks a clarifying question: how can something be shameful if it was not your act?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Yours to Be Ashamed Of",
                    blockquote = "Is that shameful to you which is not your own act, that of which you are not the cause, that which has come to you by accident, as a headache, as a fever?",
                    body = "Epictetus asked whether it is shameful to have a headache, or poor parents, or a misfortune you did not cause. He taught that shame belongs only to what is truly your own choice. Much of what we feel ashamed of, like where we came from, an illness, or how others treated us, was never our act at all. You can begin to set that weight down. It was never yours to carry, and letting it go is not a failure but a truth."
                )
            ),
            modernApplication = "Write down what you feel ashamed of. Ask honestly: \"Did I choose this?\" If you did not, say to yourself, \"This happened to me. It is not my fault.\"",
            closing = "What you did not choose is not your shame.",
            reflectionPrompt = "What shame are you carrying that was never your choice? Can you begin to set it down?"
        ),

        // q370, Epictetus (ashamed)
        "q370" to QuoteInsight(
            intro = "When you feel ashamed and keep imagining how others see you, Epictetus offers a different aim: be willing, at last, to be approved by yourself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Approved by Yourself",
                    blockquote = "Be willing at length to be approved by yourself, be willing to appear beautiful to God.",
                    body = "Epictetus said this while teaching how to loosen the grip of a troubling habit, one day at a time. His advice was to want something higher than others' approval: to be at peace with your own better self and to appear beautiful to God. He also suggested spending time with good people. Shame often looks outward, imagining judgment. Epictetus invites you to look inward and toward what is good, and to begin seeking your own honest approval."
                )
            ),
            modernApplication = "Ask yourself: \"What would I need to do today to approve of myself, gently and honestly?\" Choose one small act from your answer and do it.",
            closing = "Seek the approval of your better self.",
            reflectionPrompt = "What would it take for you to approve of yourself today? Whose good company could help?"
        ),

        // q371, Seneca (ashamed)
        "q371" to QuoteInsight(
            intro = "When you feel ashamed of where you come from or what your past has been, Seneca offers a freeing truth: the soul alone makes us noble, whatever came before.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Your Past Does Not Decide",
                    blockquote = "The soul alone renders us noble, and it may rise superior to Fortune out of any earlier condition, no matter what that condition has been.",
                    body = "Seneca wrote this to Lucilius, who kept telling him that he was a nobody, poorly treated by birth and fortune. Seneca answered that a hall of ancestors' portraits does not make anyone noble, and that every family line goes back to both great and lowly roots. Nobility comes from the character you build now. No past condition, no earlier chapter of your life, can take that possibility away from you."
                )
            ),
            modernApplication = "Name one thing about your past that you feel ashamed of. Then name one choice you are making today that reflects who you want to be. Let the second one speak louder.",
            closing = "Who you are becoming matters more than where you began.",
            reflectionPrompt = "What part of your past do you let define you? What do you want your character to say instead?"
        ),

        // q372, Seneca (ashamed)
        "q372" to QuoteInsight(
            intro = "When you feel ashamed of your faults, Seneca offers real comfort: no one starts out good. Everyone begins with the bad and has to unlearn it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Everyone Starts Here",
                    blockquote = "There is no man to whom a good mind comes before an evil one. It is the evil mind that gets first hold on all of us. Learning virtue means unlearning vice.",
                    body = "Seneca wrote this to Lucilius, counting himself among those still in the grip of faults. He was clear that this is no reason to lose hope. Bad habits get the first hold on all of us, not only on you. Growth means steadily unlearning them, and he added that virtue, once learned, is not lost. Your faults are not proof that you are worse than others. They are the common starting point of every person who ever grew."
                )
            ),
            modernApplication = "Name one fault you are ashamed of. Then say, \"This is something I am unlearning.\" Choose one small way to practice the opposite today.",
            closing = "Every good person once began where you are.",
            reflectionPrompt = "What are you in the middle of unlearning? How can you be patient with yourself as you do?"
        ),

        // q373, Seneca (ashamed)
        "q373" to QuoteInsight(
            intro = "When shame makes you feel uniquely broken, Seneca offers companionship: he speaks as a fellow patient, not a perfect teacher.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Patients in the Same Ward",
                    blockquote = "I am, however, discussing with you troubles which concern us both, and sharing the remedy with you, just as if we were lying ill in the same hospital.",
                    body = "Lucilius had asked Seneca whether he had already corrected his own faults before advising others. Seneca said no. He was sharing the remedy as one sick person to another, as if they lay in the same hospital. There is great relief in this. You are not the only one with failings, and those who seem wise are often still working on themselves too. Shame isolates. Seneca's honesty brings you back into company."
                )
            ),
            modernApplication = "Remind yourself: \"I am not the only one struggling with this.\" If you can, share one honest sentence about it with someone you trust, or write it down as if to a friend.",
            closing = "You are healing alongside everyone else.",
            reflectionPrompt = "Who else might be struggling as you are? What would you say to them?"
        ),

        // q374, Marcus Aurelius (guilty)
        "q374" to QuoteInsight(
            intro = "When guilt tells you that you have lost your good character, Marcus Aurelius offers a hopeful instruction: if you lose these names, quickly return to them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Reclaiming Your Names",
                    blockquote = "if you should lose them, quickly return to them.",
                    body = "Marcus listed the names he wanted to live up to: good, modest, true, rational, even-tempered, and great of soul. He expected that he would sometimes fall short of them. His answer was not self-punishment but return, and quickly. Falling away from who you want to be does not erase those names. They are still yours to reclaim, the moment you choose to act by them again."
                )
            ),
            modernApplication = "Choose one name you want to live up to, like \"honest\" or \"kind.\" Say it to yourself, then do one small thing in the next hour that fits it.",
            closing = "Your good names are waiting for you to return.",
            reflectionPrompt = "Which name do you want to reclaim? What small act would bring you back to it?"
        ),

        // q375, Epictetus (guilty)
        "q375" to QuoteInsight(
            intro = "When guilt comes from not being perfect, Epictetus offers relief: being free from faults is not possible, but steady effort is.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Effort, Not Perfection",
                    blockquote = "Is it possible to be free from faults? It is not possible; but this is possible, to direct your efforts incessantly to being faultless.",
                    body = "Epictetus, a demanding teacher, still admitted plainly that no one can be without faults. What he asked for was attention: a steady, ongoing effort to do better. He said we should be content if, by keeping that attention, we avoid at least a few errors. Guilt can demand a flawless record. Epictetus asks only that you keep trying, and he counts even small gains as real ones."
                )
            ),
            modernApplication = "Instead of promising never to err again, choose one area to pay attention to today. At the end of the day, notice one error you avoided, and let that count.",
            closing = "A few errors avoided is real progress.",
            reflectionPrompt = "Where could you pay closer attention today? What small progress can you allow yourself to notice?"
        ),

        // q376, Epictetus (guilty)
        "q376" to QuoteInsight(
            intro = "When guilt turns into harsh self-blame, Epictetus describes a path of growth: first we blame others, then ourselves, and at last neither.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Beyond Blame",
                    blockquote = "of one whose instruction is completed, neither to blame another, nor himself.",
                    body = "Epictetus saw blaming yourself as a step forward from blaming others, but not the end of the road. The aim is to look clearly at what happened, take responsibility for your part, and then stop punishing yourself. Blame keeps you circling the past. Understanding lets you learn and act differently next time. You can own your mistake fully without making yourself the enemy, and that is a sign of growth, not of weakness."
                )
            ),
            modernApplication = "Replace \"I am terrible for doing that\" with \"I did that, and here is what I will do next.\" Say the new sentence out loud, then take the first step it names.",
            closing = "Own the mistake, and release the blame.",
            reflectionPrompt = "Where are you blaming yourself instead of learning? What would responsibility without blame look like?"
        ),

        // q377, Epictetus (guilty)
        "q377" to QuoteInsight(
            intro = "When guilt makes every day feel heavy, Epictetus offers a brighter practice: celebrate each small act you do well.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Festival Every Day",
                    blockquote = "You can celebrate a festival daily, today because you have behaved well in one act, and tomorrow because you have behaved well in another.",
                    body = "Epictetus said that if you have lessened a bad habit, a quick temper, or harsh words, that is worth celebrating more than any public honor. You do not have to wait for a total transformation. Each day offers a chance to do one thing well, and that one thing is enough reason for quiet gladness. Guilt counts only failures. Epictetus asks you to count the good acts too."
                )
            ),
            modernApplication = "Tonight, name one thing you did well today, however small: patience in traffic, a kind word, a promise kept. Pause and let yourself feel glad about it.",
            closing = "Each good act deserves a quiet celebration.",
            reflectionPrompt = "What did you do well today? How might you mark it with a little gladness?"
        ),

        // q378, Seneca (guilty)
        "q378" to QuoteInsight(
            intro = "When guilt stings, Seneca shares a saying from Epicurus that reframes it: knowing you have done wrong is the beginning of setting things right.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Guilt as a Beginning",
                    blockquote = "The knowledge of sin is the beginning of salvation.",
                    body = "Seneca called this saying noble. His reasoning was clear: a person who does not see their wrong has no wish to correct it. You must notice where you went astray before you can change. He suggested being first your own accuser, then your judge, and last your own advocate. The ache you feel shows that your conscience is working. It is not the end of the story. It can be the first step toward repair."
                )
            ),
            modernApplication = "Write one sentence naming what you did wrong. Below it, write one thing you can do to repair it or to act differently next time. Then put the page away and take that step.",
            closing = "Seeing the wrong is the first step toward the right.",
            reflectionPrompt = "What is your guilt pointing you toward? What would repair look like?"
        ),

        // q379, Seneca (guilty)
        "q379" to QuoteInsight(
            intro = "When guilt makes you doubt you can ever be good, Seneca offers encouragement: the larger part of goodness is the will to become good.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Will to Become Good",
                    blockquote = "Hence it is that the larger part of goodness is the will to become good.",
                    body = "Seneca wrote this to Lucilius, praising his progress and urging him on. He said that in matters of character, wanting to be good is more than half the work. Feeling guilty already shows that you care about doing right. That care is not a small thing. It is the root from which better actions grow, as long as you keep tending it and let your words and deeds follow it."
                )
            ),
            modernApplication = "Say to yourself, \"I want to be good, and that wanting matters.\" Then let it guide one action in the next hour, however small.",
            closing = "Wanting to be good is most of the way there.",
            reflectionPrompt = "What does your guilt show you about what you care for? How can you let that guide you today?"
        ),

        // q380, Marcus Aurelius (lonely)
        "q380" to QuoteInsight(
            intro = "When loneliness makes you feel apart from the world, Marcus Aurelius points to what you share with every living being: the same light, the same air.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Light, One Air",
                    blockquote = "We see by one light, and breathe one air, all of us that have the faculty of vision and all that have life.",
                    body = "Marcus wrote this as part of a longer thought about how all rational beings belong together, as earthly things are drawn to earth. It is a quiet, physical reminder. The light falling on your hand right now is the light falling on others. The air you breathe is the air the whole world breathes. Loneliness is real, and this does not erase it. It offers one small, true thing to hold alongside it: even alone in a room, you are part of something shared."
                )
            ),
            modernApplication = "Step to a window or outside if you can. Take one slow breath and notice the light. Remind yourself: \"Everyone alive shares this air with me.\"",
            closing = "The light you see is the light we all share.",
            reflectionPrompt = "What do you share with others right now, even unseen? How does it feel to notice it?"
        ),

        // q381, Epictetus (lonely)
        "q381" to QuoteInsight(
            intro = "When being alone feels heavy, Epictetus offers a gentle reframe: the same hours might also be called tranquility and freedom.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Another Name for Solitude",
                    blockquote = "You ought when you are alone to call this condition by the name of tranquility and freedom.",
                    body = "Epictetus noticed that the names we give a situation shape how it feels. Alone, we call it solitude and suffer; among others, we call them troublesome. He suggested choosing kinder names. This does not deny that you long for company, and that longing is human. But some of these quiet hours can also hold rest, room to think, and freedom to do as you choose. Both can be true at once."
                )
            ),
            modernApplication = "For the next half hour, try naming this time as freedom. Use it for something you enjoy and rarely have space for: a walk, music, a book, a slow cup of tea.",
            closing = "Quiet hours can hold rest as well as longing.",
            reflectionPrompt = "What might this time alone offer you, alongside the longing? How would you like to spend it?"
        ),

        // q382, Epictetus (lonely)
        "q382" to QuoteInsight(
            intro = "When you are alone more than you wish, Epictetus offers a steady skill to build: learning to be good company for yourself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Your Own Companion",
                    blockquote = "A man ought to be prepared in a manner for this also (being alone), to be able to be sufficient for himself and to be his own companion.",
                    body = "In a talk on solitude, Epictetus acknowledged the natural human desire for community, love, and conversation. He did not dismiss it. He also said we should be ready for times alone, able to talk with ourselves, reflect, and pass our time well. Being your own companion does not replace other people. It means that when they are not near, you still have someone kind to spend time with."
                )
            ),
            modernApplication = "Talk to yourself today as a good friend would. Ask, \"How are you doing, really?\" Listen to the answer, and offer yourself one small comfort in return.",
            closing = "You can learn to keep yourself good company.",
            reflectionPrompt = "What kind of companion are you to yourself? How could you be a kinder one today?"
        ),

        // q383, Seneca (lonely)
        "q383" to QuoteInsight(
            intro = "When loneliness aches, Seneca shares a line from the philosopher Hecato: the person who has begun to be a friend to himself can never be alone.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Friend to Yourself",
                    blockquote = "I have begun to be a friend to myself.",
                    body = "Seneca passed this along to Lucilius as a small daily gift, and added that such a person is a friend to all mankind. Being a friend to yourself means treating yourself with patience, honesty, and care, the way you would treat someone you love. It does not erase the wish for others. It gives you steady ground to stand on, and it often makes reaching out to others a little easier too."
                )
            ),
            modernApplication = "Do one thing for yourself today that a good friend would do for you: make a warm meal, take a walk, or write down three things you appreciate about yourself.",
            closing = "Befriending yourself is a beginning, not a retreat.",
            reflectionPrompt = "How could you be a better friend to yourself today? What would that friend say to you?"
        ),

        // q384, Seneca (lonely)
        "q384" to QuoteInsight(
            intro = "When you miss someone far away, Seneca offers comfort: a friend held in the spirit is never truly absent.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Friends Held in Mind",
                    blockquote = "A friend should be retained in the spirit; such a friend can never be absent.",
                    body = "Seneca wrote this to Lucilius while they were apart. He told his friend that he could see him and hear him even at that moment, so close did he feel. Distance does not erase a bond. You can bring a friend to mind, recall their voice, and imagine what they would say. That presence is real in its own way, and it can keep you company in the meantime, wherever you are."
                )
            ),
            modernApplication = "Bring to mind someone who cares about you. Picture their face and imagine what they would say to you right now. If you can, send them a short note telling them you thought of them.",
            closing = "Those you carry in mind are never far.",
            reflectionPrompt = "Who do you carry with you, even at a distance? What would they say to you today?"
        ),

        // q385, Seneca (lonely)
        "q385" to QuoteInsight(
            intro = "When you long to feel loved, Seneca shares a philosopher's remedy that needs no magic: if you would be loved, love.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Philter Without Magic",
                    blockquote = "If you would be loved, love.",
                    body = "Seneca quoted this from Hecato in a letter on friendship, and said there is real pleasure in making new friends, not only in keeping old ones. He compared it to a farmer sowing seeds. Love is not only something we wait to receive. It is something we can begin. A small act of warmth toward someone else is a seed, and seeds take time, but they are how friendships start."
                )
            ),
            modernApplication = "Offer one small act of warmth today: a kind word to a cashier, a message to someone you have lost touch with, a thank-you note. Expect nothing back. Let it be a seed.",
            closing = "Love offered is the seed of love returned.",
            reflectionPrompt = "Who could you show a little warmth to today? What small seed could you plant?"
        ),

        // q386, Epictetus (rejected)
        "q386" to QuoteInsight(
            intro = "Being passed over, left off the invitation, or greeted less warmly than someone else hurts. Epictetus asks you to look calmly at what was actually handed out.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Weighing What Was Given",
                    blockquote = "If these things are good, you ought to rejoice that he has obtained them; but if bad, be not grieved because you have not obtained them.",
                    body = "Epictetus names small, ordinary rejections: a better place at dinner, a warmer greeting, an invitation to give advice. Then he offers a gentle test. If the thing was truly good, you can be glad for the person who received it. If it was not truly good, there is nothing to grieve in missing it. He adds that such favors often have a price, like flattery or constant attendance, which you may not have wanted to pay. Your worth was not handed out with the seating."
                )
            ),
            modernApplication = "Name exactly what you were passed over for. Ask: was it good in itself, or did it only feel like a sign of approval? If it was good, try saying, \"I am glad they have it.\"",
            closing = "Missing an invitation is not missing your worth.",
            reflectionPrompt = "What were you hoping that invitation would prove about you?"
        ),

        // q387, Epictetus (rejected)
        "q387" to QuoteInsight(
            intro = "When you feel despised, it can seem like the whole world agrees. Epictetus breaks that feeling into a few quiet questions that loosen its grip.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Despised by Whom",
                    blockquote = "how shall those who know you despise a man who is gentle and modest?",
                    body = "Epictetus asks a plain question: despised by whom? People who truly know you have seen how you treat others, and it is hard to hold a gentle, modest person in contempt. People who do not know you are judging someone they have not met. Their opinion is about a picture in their own mind, not about you. The feeling of rejection is real, but when you ask who is actually doing the rejecting, it often shrinks to a size you can hold."
                )
            ),
            modernApplication = "Write down the names of the people whose opinion truly matters to you. Next to each, note whether they actually know you well. Let the rest of the list go a little.",
            closing = "Those who know you are the ones who see you.",
            reflectionPrompt = "Whose opinion is weighing on you, and how well do they really know you?"
        ),

        // q388, Seneca (rejected)
        "q388" to QuoteInsight(
            intro = "When you feel unwanted, a small circle can seem like failure. Seneca passes along a saying from someone whose name was lost, an answer about doing work that would reach very few.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Content With Few",
                    blockquote = "I am content with few, content with one, content with none at all.",
                    body = "In a letter to his friend Lucilius, Seneca records someone being asked why he labored at an art so few would ever appreciate. His reply was this line. It is not a boast about needing no one. It is a quiet freedom: the value of what you do and who you are does not depend on the size of the crowd that approves. One person who understands you is enough. And on days when it feels like no one does, your worth has not gone anywhere."
                )
            ),
            modernApplication = "Instead of counting who did not respond, think of one person who has ever truly understood you. Let that be enough for today, and keep doing your work as if for them.",
            closing = "One true audience is enough.",
            reflectionPrompt = "What would you keep doing even if only one person ever noticed?"
        ),

        // q389, Seneca (rejected)
        "q389" to QuoteInsight(
            intro = "Being dropped by someone you thought was a friend is painful and confusing. Seneca, writing to his friend Lucilius, offers a sober way to understand why some bonds end the way they began.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Friendship That Pays",
                    blockquote = "He who begins to be your friend because it pays will also cease because it pays.",
                    body = "Seneca observes that a friendship built on usefulness carries its ending inside it. When the benefit stops, so does the friend. This does not make your loss smaller, but it can change what the loss means. If someone left when you stopped being useful to them, it says more about what they were looking for than about what you are worth. Seneca hoped for friendships valued for their own sake, and those are still possible for you."
                )
            ),
            modernApplication = "If a recent rejection felt like this, say to yourself: \"That bond was built on something other than me.\" Then reach toward one person who has stayed when there was nothing to gain.",
            closing = "Some endings were written in the beginning.",
            reflectionPrompt = "Who in your life has stayed when you had nothing to offer them?"
        ),

        // q390, Seneca (rejected)
        "q390" to QuoteInsight(
            intro = "Rejection can make it feel as though some doors are closed to you for good. Seneca, reassuring Lucilius about his humble origins, insists that the most important path is open to everyone.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Light for Everyone",
                    blockquote = "Philosophy neither rejects nor selects anyone; its light shines for all.",
                    body = "Lucilius worried about his background, and Seneca reminded him that many places in Rome were closed to most people: certain seats, the senate, even the army chose whom it would admit. But a noble mind, he says, is free to all. He points to Cleanthes, who worked as a hired man watering a garden, and to Socrates, who was no aristocrat. Whoever turned you away, they cannot close this path. Becoming a good person has no gatekeeper."
                )
            ),
            modernApplication = "Choose one quality you admire, such as patience or honesty, and practice it once today. No one has to approve your entry into that.",
            closing = "No one can turn you away from becoming good.",
            reflectionPrompt = "Which way feels closed right now, and which one is still open to you?"
        ),

        // q391, Epictetus (discouraged)
        "q391" to QuoteInsight(
            intro = "If you have given up before and feel ashamed of it, Epictetus has a merciful word. Speaking to those who fall away from their purpose, he says the contest can always be renewed.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Renew the Contest",
                    blockquote = "if again you renounce it, you may again renew it; and if you once gain the victory, you are like him who has never renounced the combat.",
                    body = "Epictetus compares the effort to live well with the athletic games, with one big difference: you do not have to wait four years for Olympia to come around again. As soon as you have rested and gathered yourself, you can begin again. And again, if needed. Past lapses do not stack up against you. One real success, and it is as if you never quit. He asks only that quitting not become a comfortable habit."
                )
            ),
            modernApplication = "Rest first, without guilt. Then pick a single moment today to restart, even in a small way, and say: \"I am renewing the contest.\"",
            closing = "You can always begin again.",
            reflectionPrompt = "What do you need to recover before you begin again, and when might that be?"
        ),

        // q392, Epictetus (discouraged)
        "q392" to QuoteInsight(
            intro = "Discouragement often comes from expecting change faster than it can arrive. Epictetus answered a man troubled by a strained family bond with a patient image from the orchard.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Let It Flower First",
                    blockquote = "Nothing great, said Epictetus, is produced suddenly, since not even the grape or the fig is.",
                    body = "A man asked Epictetus how he could stay steady even if his brother never made peace with him. Epictetus said nothing great happens suddenly, not even a fig. First the tree flowers, then the fruit forms, then it ripens. If a fig needs a season, a steady mind needs longer. The slowness you feel is not a sign of failure. It is the normal pace of growing something that lasts."
                )
            ),
            modernApplication = "Look back three months instead of three days. Notice one small way you have grown. Then let today be one ordinary day of ripening, not a test.",
            closing = "Even the fig takes its season.",
            reflectionPrompt = "Where are you expecting fruit while the tree is still flowering?"
        ),

        // q393, Epictetus (discouraged)
        "q393" to QuoteInsight(
            intro = "If you feel you lack the talent for something, discouragement can turn into giving up. Epictetus, speaking about himself, offers a modest and steady answer.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not the Highest, Still Worth It",
                    blockquote = "What then, since I am naturally dull, shall I, for this reason, take no pains? I hope not.",
                    body = "Epictetus admits he is no Socrates. He will never be Milo the wrestler or Croesus the rich king, yet he still cares for his body and his property. We do not stop tending to something, he says, because we despair of reaching the very top. You may not be the most gifted at this. That does not make your effort worthless. Being a little better than you were is a real and worthy aim."
                )
            ),
            modernApplication = "Set aside the comparison with the best for today. Ask instead: \"What is one thing I can do slightly better than yesterday?\" Do that one thing.",
            closing = "Effort is worth it without being the best.",
            reflectionPrompt = "What would you attempt if you only had to improve on yourself, not on others?"
        ),

        // q394, Seneca (discouraged)
        "q394" to QuoteInsight(
            intro = "When you keep falling short, it can feel like you are doing something wrong. Seneca reminds Lucilius of how every one of us first learned to stand.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Falling and Rising",
                    blockquote = "The child who is trying to stand and is becoming used to carry his own weight, on beginning to test his strength, falls and rises again and again with tears until through painful effort he has trained himself to the demands of nature.",
                    body = "Seneca describes a small child learning to carry its own weight. It falls, rises, and falls again, often in tears, and keeps going until its body learns what it is made to do. He uses this to show how strongly living things move toward what is natural to them, even through pain. The falls were never proof that the child could not stand. They were how standing was learned. Your stumbles may be part of the same process."
                )
            ),
            modernApplication = "If you have cried over this, that is allowed. Let yourself rest for a moment, then make one more small attempt, the way a child pulls itself up on the nearest chair.",
            closing = "Tears and falls are part of learning to stand.",
            reflectionPrompt = "What would you say to a child who fell while learning, and can you say it to yourself?"
        ),

        // q395, Seneca (discouraged)
        "q395" to QuoteInsight(
            intro = "When effort has gone unrewarded, it is natural to want to stop trying. Seneca, writing to Lucilius after he met with ingratitude, answers that urge with a farmer's patience.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Sow Again",
                    blockquote = "Even after a poor crop one should sow again; for often losses due to continued barrenness of an unproductive soil have been made good by one year's fertility.",
                    body = "Lucilius had done good for someone who gave nothing back. Seneca does not call the hurt foolish. He says that if you stop giving to avoid disappointment, you lose more than you protect. A farmer who has a poor season still plants again, because one good year can make up for many lean ones. A failed effort is a poor crop, not a barren life."
                )
            ),
            modernApplication = "Choose one small thing you stopped doing after it failed to pay off. Plant it again today in a tiny way, and let go of needing to see the harvest soon.",
            closing = "One good season can repay many lean ones.",
            reflectionPrompt = "What did you stop planting after a poor season, and could you sow a little again?"
        ),

        // q396, Seneca (discouraged)
        "q396" to QuoteInsight(
            intro = "Discouragement can make you forget how much you have already come through. Seneca reminds his friend Lucilius of his own record of getting back up.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "You Have Stood Before",
                    blockquote = "Fortune has often in the past got the upper hand of you, and yet you have not surrendered, but have leaped up and stood your ground still more eagerly.",
                    body = "Seneca compares life to a boxing match. The fighter who can enter the ring with confidence is the one who has been knocked down and risen again. Then he turns to Lucilius: fortune has beaten you before, and you did not give in. You stood up and held your ground. Your hard times are not only wounds. They are also evidence of what you are capable of."
                )
            ),
            modernApplication = "Write down two times you thought you could not get through something, and did. Read them back slowly. You are the same person now.",
            closing = "You have risen before, and you can rise again.",
            reflectionPrompt = "When have you been knocked down before and found your footing anyway?"
        ),

        // q397, Marcus Aurelius (resentful)
        "q397" to QuoteInsight(
            intro = "When someone wrongs you, it is easy to stay stuck in disbelief and anger. Marcus offers a way to understand them that softens both.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What They Believed",
                    blockquote = "When a man has done you any wrong, immediately consider with what opinion about good or evil he has done wrong. For when you have seen this, you will pity him, and will neither wonder nor be angry.",
                    body = "Marcus asks one question: what did this person believe was good or bad when they acted? People act on their opinions, and a twisted opinion leads to a twisted act. When you see what they mistakenly valued, the wrong stops feeling mysterious. Marcus says you may even feel pity, and no longer wonder or rage. Understanding is not excusing. It is seeing clearly enough to set your anger down."
                )
            ),
            modernApplication = "Finish this sentence in your head: \"They must have thought that ___ mattered more.\" Notice whether your anger loosens a little once the wrong makes sense.",
            closing = "Understanding their mistake can quiet your anger.",
            reflectionPrompt = "What might this person have mistakenly believed was good when they acted?"
        ),

        // q398, Epictetus (resentful)
        "q398" to QuoteInsight(
            intro = "Resentment grabs a situation by the side that hurts most. Epictetus points out that there is usually another side you can take hold of.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Two Handles",
                    blockquote = "Everything has two handles, the one by which it may be borne, the other by which it may not.",
                    body = "Epictetus gives an example right after this line: if your brother acts unjustly, do not take hold of the matter by the handle of his injustice, because that handle cannot be carried. Take it instead by the other handle: he is your brother, raised with you. The wrong is still real. But how you hold it decides whether you can bear it. You may have more than one way to grip what happened."
                )
            ),
            modernApplication = "Name the handle you have been holding, such as \"they wronged me.\" Then look for another true handle, like \"we have shared a lot,\" and try holding that one for an hour.",
            closing = "Choose the handle you can carry.",
            reflectionPrompt = "What other handle does this situation have that you have not tried to hold?"
        ),

        // q399, Epictetus (resentful)
        "q399" to QuoteInsight(
            intro = "When someone has treated you unjustly, striking back can feel fair. Epictetus asks a question that shows where that road leads.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Two Hurts, Not One",
                    blockquote = "What then, since that man has hurt himself by doing an unjust act to me, shall I not hurt myself by doing some unjust act to him?",
                    body = "Epictetus sees an unjust act as harm to the person who does it, because it damages their character. So answering injustice with injustice does not cancel the wrong. It adds a second harm, and this one lands on you. His question is gently ironic: since they hurt themselves, should I hurt myself too? You are allowed to protect yourself and set limits. You do not have to wound your own character to do it."
                )
            ),
            modernApplication = "When you feel the pull to retaliate, pause and say: \"I will not hurt myself because they hurt themselves.\" Then choose a response that is firm and fair.",
            closing = "Their wrong does not need a partner.",
            reflectionPrompt = "What response would protect you without asking you to become unjust?"
        ),

        // q400, Epictetus (resentful)
        "q400" to QuoteInsight(
            intro = "Resentment often grows from the feeling that someone has damaged you. Epictetus draws attention to the part of harm that only your own judgment can complete.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Damage You Agree To",
                    blockquote = "Another will not damage you, unless you choose: but you will be damaged then when you shall think that you are damaged.",
                    body = "Epictetus is not saying painful things do not happen. He is saying the deepest damage, to your character and your peace, needs your agreement. He says this while speaking of a difficult father or a brother who wrongs you: look not at what they are doing, but at what you must do. Whether you conclude \"I have been made smaller\" is a judgment you make. That part stays yours."
                )
            ),
            modernApplication = "Notice the sentence your mind keeps repeating about what they did. Try ending it sooner: from \"they ruined my week\" to \"they did this, and I am still here, still choosing.\"",
            closing = "No one can reach your character without your consent.",
            reflectionPrompt = "Which part of this hurt comes from the event, and which from what you have told yourself it means?"
        ),

        // q401, Seneca (resentful)
        "q401" to QuoteInsight(
            intro = "When an injury looms large, the good in your life can fade from view. Seneca, writing to Lucilius about gratitude, names this as one of the saddest patterns a person can fall into.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Remember the Benefits",
                    blockquote = "What is more wretched than a man who forgets his benefits and clings to his injuries?",
                    body = "Seneca describes how the ungrateful person enlarges his injuries in memory and shrinks the good he has received. The result is a mind that keeps the wounds and loses the gifts. It is a lonely way to live, and Seneca calls it wretched. If you notice yourself doing this, it is not something to be ashamed of; it is a habit of attention. Attention can be turned, a little at a time, toward what has been given to you."
                )
            ),
            modernApplication = "Next to the injury you keep replaying, write down three kindnesses you have received this year, even small ones. Read the kindnesses last.",
            closing = "Hold your gifts at least as tightly as your hurts.",
            reflectionPrompt = "What good has someone done for you that resentment has pushed out of sight?"
        ),

        // q402, Seneca (resentful)
        "q402" to QuoteInsight(
            intro = "Resentment can feel like a way of making someone pay. Seneca quotes his teacher Attalus on where the poison of wrongdoing actually ends up.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Poison That Turns Inward",
                    blockquote = "Evil herself drinks the largest portion of her own poison.",
                    body = "Seneca explains that when we do wrong, only the lightest part of the harm reaches the other person. The heaviest part stays with the one who did it. Unlike a serpent's venom, which leaves the serpent unharmed, this poison works on its owner. So the person who wronged you is already living with the cost, and you do not need to add to it. It also means resentment you keep feeding may become a poison of your own."
                )
            ),
            modernApplication = "When you catch yourself wishing them harm, take one slow breath and say: \"I do not need to drink this too.\" Then turn to something that nourishes you.",
            closing = "Let the poison stay with the one who made it.",
            reflectionPrompt = "Is this resentment protecting you, or is it slowly working on you?"
        ),

        // q403, Marcus Aurelius (treated unfairly)
        "q403" to QuoteInsight(
            intro = "Doing good and being treated badly for it can feel like the worst kind of unfairness. Marcus copied a line from the philosopher Antisthenes that gives that experience unexpected dignity.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Royal Ground",
                    blockquote = "It is royal to do good and to be abused.",
                    body = "Marcus kept this saying in his private notes, and as emperor he knew criticism well. It reminded him that being abused for doing good is not a sign you have failed. It can be the mark of someone who acts well without needing applause. The unfairness is real. But it does not cancel the good you did. That good stands on its own, whether or not anyone thanks you."
                )
            ),
            modernApplication = "Write down the good thing you did, plainly, as a record for yourself. Let it stand there, separate from how it was received.",
            closing = "The good you did still stands.",
            reflectionPrompt = "What good did you do here that remains true, however it was received?"
        ),

        // q404, Epictetus (treated unfairly)
        "q404" to QuoteInsight(
            intro = "When someone treats you badly or speaks ill of you, it can feel aimed and deliberate. Epictetus offers a way of seeing them that takes some of the sting out.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Seemed Right to Them",
                    blockquote = "It is not possible then for him to follow that which seems right to you, but that which seems right to himself.",
                    body = "Epictetus says people act on what seems right to them. The person who wronged you did not consult your sense of fairness. They followed their own, and if their judgment is wrong, they are the one deceived by it. He adds that holding this view makes you mild toward the one who reviles you, and suggests a phrase: \"It seemed so to him.\" That does not approve of what they did. It frees you from needing them to see as you do."
                )
            ),
            modernApplication = "When the unfair words replay, try saying quietly, \"It seemed so to them.\" Let it be a statement about their judgment, not about your worth.",
            closing = "Their view is not the measure of you.",
            reflectionPrompt = "What might have seemed right to them, even if it was wrong?"
        ),

        // q405, Epictetus (treated unfairly)
        "q405" to QuoteInsight(
            intro = "Hearing that someone has spoken badly about you can make you want to defend yourself right away. Epictetus suggests a lighter response, with a touch of humor.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Rest of My Faults",
                    blockquote = "do not make any defense to what has been told you; but reply, The man did not know the rest of my faults, for he would not have mentioned these only.",
                    body = "Epictetus advises against rushing to answer every criticism you hear secondhand. Instead he offers a gentle joke: they must not know the rest of my faults, or they would have mentioned more. The humor does real work. It admits you are imperfect, which takes the power out of the remark, and it spares you the tiring job of correcting everyone's opinion. Your energy can go back to living well."
                )
            ),
            modernApplication = "If a reported remark is stinging today, try saying Epictetus's reply aloud, even with a small smile. Notice whether the urge to defend yourself eases.",
            closing = "You do not have to answer every word said about you.",
            reflectionPrompt = "What would you gain by letting this remark go undefended?"
        ),

        // q406, Epictetus (treated unfairly)
        "q406" to QuoteInsight(
            intro = "When you have kept your side of something and the other person has not, the unfairness can feel heavy. Epictetus offers a clean way to set down what is not yours.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "I Have Done My Part",
                    blockquote = "I have done my part; but whether you also have done yours, you must look to that.",
                    body = "Epictetus draws a line between your part and the other person's. You can be careful and honest in what you do. Whether they do the same is up to them. This is not coldness. It is clarity about where your responsibility ends. Much of the weight of unfairness comes from trying to hold both sides at once. Once you have truly done your part, you can stop carrying theirs as well."
                )
            ),
            modernApplication = "Make two short lists: what you did, and what you hoped they would do. Look at the first and say, \"I have done my part.\" Let the second list rest with them.",
            closing = "Your part is enough to carry.",
            reflectionPrompt = "Have you done your part here, and can you let the rest belong to them?"
        ),

        // q407, Seneca (treated unfairly)
        "q407" to QuoteInsight(
            intro = "When someone insults you or works against you, it can feel like they have power over your whole life. Seneca quotes Socrates on the one thing an insult cannot reach.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Virtue Stays With You",
                    blockquote = "Allow any man who so desires to insult you and work you wrong; but if only virtue dwells with you, you will suffer nothing.",
                    body = "Seneca passes along this advice from Socrates, who urged people to live by good rules even if some thought them fools. Insults and wrongs can hurt, and the Stoics knew that. Their claim is narrower: the part of you that matters most, your goodness and your choices, cannot be taken by someone else's malice. What they do may shape your circumstances. It does not decide who you are."
                )
            ),
            modernApplication = "Name one value you acted on today, such as honesty or patience. Hold onto it as the thing that was not touched, however unfairly you were treated.",
            closing = "What dwells in you cannot be insulted away.",
            reflectionPrompt = "Which of your values stayed whole through this, even if it hurt?"
        ),

        // q408, Seneca (treated unfairly)
        "q408" to QuoteInsight(
            intro = "Being on the receiving end of injury can feel like losing. Seneca, writing to Lucilius about how people belong to one another, turns that around.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Lighter Side of Wrong",
                    blockquote = "It is more wretched to commit than to suffer injury.",
                    body = "Seneca sees all people as parts of one great body, made by nature for fairness and kindness toward each other. Seen that way, the person who commits injury has turned against their own nature. The person who suffers it has lost something outside themselves, but not their goodness. Your pain is not small. But you are not the one who has damaged your own character. That is still whole."
                )
            ),
            modernApplication = "When you feel the unfairness rise, remind yourself: \"I was wronged, but I did not do wrong.\" Let that sentence steady you for a moment.",
            closing = "Suffering a wrong leaves your goodness intact.",
            reflectionPrompt = "What do you still have that the person who wronged you may have lost?"
        ),

        // q409, Marcus Aurelius (burned out)
        "q409" to QuoteInsight(
            intro = "Burnout can leave you pulled in every direction, with no room to breathe. Marcus sets out a short, balanced picture of a life with space in it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Room to Breathe",
                    blockquote = "Nor let there be in your soul inward contention nor external effusion, nor in life be so busy as to have no leisure.",
                    body = "Marcus names three things to avoid: inner conflict, scattering yourself outward, and being so busy that you have no leisure at all. They feed each other. When you are overloaded, your mind argues with itself and your energy leaks in every direction. Leisure here is not laziness. It is the open space that lets you think clearly and act from a settled place."
                )
            ),
            modernApplication = "Block out fifteen minutes today with nothing in them. No phone, no task. Treat it as an appointment you keep with yourself.",
            closing = "A life needs some empty space.",
            reflectionPrompt = "Where could you make a small pocket of leisure today, even ten minutes?"
        ),

        // q410, Epictetus (burned out)
        "q410" to QuoteInsight(
            intro = "When you feel responsible for everything, exhaustion follows. Epictetus offers relief by narrowing the job to what is really yours.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Your Own Work Is Enough",
                    blockquote = "It is enough if every man fully discharges the work that is his own.",
                    body = "Epictetus answers someone who worries that his city will go without his help. A city is not given shoes by its smiths or arms by its shoemakers, he says; it is enough if each person fully does the work that is their own. You are not asked to hold up the whole world. You are asked to do your own part well. Letting go of the rest is not failure. It is accuracy about what belongs to you."
                )
            ),
            modernApplication = "Write down the three things that are truly yours to do this week. Let everything else wait, or belong to someone else.",
            closing = "Doing your own part fully is enough.",
            reflectionPrompt = "Which of the things weighing on you are actually someone else's work?"
        ),

        // q411, Epictetus (burned out)
        "q411" to QuoteInsight(
            intro = "When you are depleted, every demand can feel like it must be met. Epictetus gives quiet permission to carry only what you can.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Bear What You Can",
                    blockquote = "You must then bear such things as you are able.",
                    body = "Epictetus says this while talking about beginners, noting that every great power is dangerous to someone still learning. His advice is to take on what you are able to bear, in a way that fits nature. Strength grows by degrees, not by overloading yourself. If you are spent, that is information, not a moral failing. Carrying less for a while can be the wise choice."
                )
            ),
            modernApplication = "Ask yourself honestly: \"What can I bear today?\" Do that much, and let the rest be set down without apology.",
            closing = "Strength grows from what you can carry, not from what crushes you.",
            reflectionPrompt = "What is the honest amount you can carry today?"
        ),

        // q412, Seneca (burned out)
        "q412" to QuoteInsight(
            intro = "If you have been running without stopping, you may feel rest is something you have not earned. Seneca, writing to Lucilius, points to the natural rhythm of day and night.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Day and Night",
                    blockquote = "He who reposes should act and he who acts should take repose. Discuss the problem with Nature; she will tell you that she has created both day and night.",
                    body = "Seneca warns against two extremes. Constant bustle is not real industry; he calls it the restlessness of a hunted mind. Yet endless repose turns into slackness. The answer is to combine them: the one who rests should act, and the one who acts should rest. Nature built this into every day. You are not failing when you stop. You are following the same rhythm that brings night after day."
                )
            ),
            modernApplication = "Tonight, treat rest as part of your work, not a break from it. Set a time to stop, and when it comes, stop the way the sun sets: without arguing.",
            closing = "Night belongs to the day's work too.",
            reflectionPrompt = "Where in your day is there night, a real time of rest?"
        ),

        // q413, Seneca (burned out)
        "q413" to QuoteInsight(
            intro = "When your mind is strained, pushing harder rarely helps. Seneca, writing to Lucilius, borrows an image from a craftsman who knows when to look away from his work.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Rest Your Eyes",
                    blockquote = "Just as an engraver rests his eyes when they have long been under a strain and are weary, and calls them from their work, and \"feasts\" them, as the saying is; so we at times should slacken our minds and refresh them with some sort of entertainment.",
                    body = "An engraver doing fine, careful work has to stop and rest his eyes, calling them away to something pleasant. Seneca says the mind needs the same. Some lightness and refreshment belong to good work; they are not opposed to it. He adds that even our entertainment can carry some benefit, but the main point is plain: a weary mind deserves rest. Looking away for a while is how you keep seeing clearly."
                )
            ),
            modernApplication = "Step away from what you are working on for ten minutes. Look out a window, listen to a song you love, or walk around the block. Let your mind \"feast\" on something easy.",
            closing = "A rested eye sees more clearly.",
            reflectionPrompt = "What small pleasure could refresh your mind today?"
        ),

        // q414, Seneca (burned out)
        "q414" to QuoteInsight(
            intro = "Weariness that has built up over time can feel permanent. Seneca, writing to Lucilius after a tiring journey, offers a short reassurance.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Rest Can Lighten",
                    blockquote = "That which toil has accumulated, rest can lighten.",
                    body = "Seneca reached his country house late at night, worn out more by the discomfort of the trip than its length. He asked for no special comforts, no bath and no one to rub him down, only time. Then he wrote this line. Fatigue accumulates, but it also lifts. You do not have to fix everything tonight. Rest, given time and patience, does real work of its own."
                )
            ),
            modernApplication = "Tonight, let rest be enough. Skip one task, go to bed a little earlier, and trust that some of this weight will be lighter by morning.",
            closing = "What toil has gathered, rest can ease.",
            reflectionPrompt = "What could you set aside tonight to give rest a chance to work?"
        ),

        // q415, Marcus Aurelius (numb)
        "q415" to QuoteInsight(
            intro = "When life feels flat, joy can seem out of reach. Marcus offers a gentle way to rebuild it, one good thing at a time.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "One Good Thing, Then Another",
                    blockquote = "What remains, except to enjoy life by joining one good thing to another so as not to leave even the smallest intervals between?",
                    body = "Marcus wrote this right after reminding himself to see things clearly, act justly, and speak the truth. The good things he means are good actions, linked one to the next. He does not wait for a feeling of joy to arrive first. Enjoyment, for him, comes from the chain itself. When you feel numb, you can still do one small good thing, then another. Sometimes feeling follows."
                )
            ),
            modernApplication = "Do one small good thing right now: water a plant, send a kind word, tidy one surface. Then look for the next one. You do not have to feel like it first.",
            closing = "Link one small good to the next.",
            reflectionPrompt = "What is one small good thing you could do in the next five minutes?"
        ),

        // q416, Epictetus (numb)
        "q416" to QuoteInsight(
            intro = "When nothing seems to move you, the beauty of the world can feel far away. Epictetus asks a plain question about what is already in front of you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Already in View",
                    blockquote = "Have you anything better or greater to see than the sun, the moon, the stars, the whole earth, the sea?",
                    body = "Epictetus was speaking to people who missed a city or a place they had loved. He asked whether there was anything better to see than what is visible every day: the sun, the moon, the stars, the earth, the sea. You may not feel much when you look at them right now, and that is all right. They are still there, and they are still yours to look at. Attention can come before feeling."
                )
            ),
            modernApplication = "Go to a window or step outside. Name five things you can see in the sky or the natural world, slowly, one at a time, without needing to feel anything about them.",
            closing = "The sky is still yours to see.",
            reflectionPrompt = "What could you look at today, slowly, as if for the first time?"
        ),

        // q417, Epictetus (numb)
        "q417" to QuoteInsight(
            intro = "Numbness can make the world seem like background noise. Epictetus reminds his listeners that they were made not only to see, but to understand.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Why You Have Eyes",
                    blockquote = "Will you not perceive either what you are, or what you were born for, or what this is for which you have received the faculty of sight?",
                    body = "Epictetus notes that people travel far to see the famous statue at Olympia and count it a great loss never to have seen it. Yet the works of nature are all around, wherever you are, with no journey needed. He asks whether you will notice what you are and what your sight is for. Read gently, his question is an invitation. Your capacity to look and understand has not gone anywhere, even if feeling is quiet."
                )
            ),
            modernApplication = "Pick one ordinary thing near you: a leaf, a cup, your own hand. Look at it for one full minute as if you had traveled far to see it.",
            closing = "Wonder can start with one small thing.",
            reflectionPrompt = "What is near you right now that deserves a longer look?"
        ),

        // q418, Seneca (numb)
        "q418" to QuoteInsight(
            intro = "When you feel nothing, joy can seem like something that happens to other people. Seneca tells Lucilius that joy is something you can learn.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Learning Joy",
                    blockquote = "Above all, my dear Lucilius, make this your business: learn how to feel joy.",
                    body = "Seneca calls learning joy the chief business of life. He does not mean chasing pleasures or waiting for luck to hand you something. He means a deeper gladness that grows from within and does not depend on outside events. If that sounds far away right now, notice the word \"learn.\" Joy, for Seneca, is something you can grow into slowly, not something you either have or lack."
                )
            ),
            modernApplication = "Today, notice one moment that is even slightly good: warm tea, sunlight, a familiar voice. Pause on it for three breaths. That is a first lesson.",
            closing = "Joy can be learned, one lesson at a time.",
            reflectionPrompt = "What small moment today was a little better than the rest?"
        ),

        // q419, Seneca (numb)
        "q419" to QuoteInsight(
            intro = "Numbness can make it seem that gladness has left for good. Seneca tells Lucilius that he wants him never to lose it, and he says where it lives.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Born in Your House",
                    blockquote = "I do not wish you ever to be deprived of gladness. I would have it born in your house; and it is born there, if only it be inside of you.",
                    body = "Seneca says he does not want Lucilius ever to be without gladness. He wants it born in his own house, and it will be, if it is inside him. Outer pleasures may make us smile for a moment, but they come and go. The gladness he means is quieter and steadier. If you cannot feel it right now, that does not mean it is gone. It may need a quiet place to be born again."
                )
            ),
            modernApplication = "Make a small, quiet space today: a chair by a window, a few minutes without noise. Sit there and let whatever is inside you be enough for now.",
            closing = "Gladness has a home in you.",
            reflectionPrompt = "Where could you make a small, quiet space for gladness to return?"
        ),

        // q420, Epictetus (restless)
        "q420" to QuoteInsight(
            intro = "When your mind keeps running to some other place or some other life, Epictetus offers a steady instruction: be where you are, and think about how to live well there.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Life in Front of You",
                    blockquote = "If you be in Rome, do not imagine what the life in Athens is, but think only of the life in Rome.",
                    body = "Epictetus says this right after a harder example: if you are on Gyara, an island where people were sent into exile, do not dream about the pleasures of Rome. Ask instead how to live well on Gyara, with courage. Restlessness often feeds on imagined elsewheres: the city you could be in, the life you might be living. Those pictures are vivid, but they give you nothing to work with. The place you are in is the only one where you can act today."
                )
            ),
            modernApplication = "When you catch yourself picturing another life, say quietly, 'I am here.' Then name one thing you could do well in this place, this hour.",
            closing = "Here is where your life is happening.",
            reflectionPrompt = "What place or life is your mind running toward? What would living well right here look like today?"
        ),

        // q421, Epictetus (restless)
        "q421" to QuoteInsight(
            intro = "If you feel that a different place would finally settle you, Epictetus suggests that what made you well was never the place. It was the way you see things, and that travels with you.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "You Carry Your Peace",
                    blockquote = "Wherever I shall go, there it will be well with me; for here also where I am, it was not because of the place that it was well with me, but because of my opinions which I shall carry off with me.",
                    body = "Epictetus was born enslaved and later taught in Nicopolis, so he knew something about having little say over where he lived. His comfort is that the source of being well goes where you go. A place cannot give you steadiness, and it cannot fully take it away. Your judgments about what matters, what is yours, and what you can let pass are portable. That means the work of feeling settled can start before anything around you changes."
                )
            ),
            modernApplication = "Before deciding that a move or a new setting will fix this feeling, try a small test: spend ten minutes here sorting what is in your control from what is not, and see what shifts.",
            closing = "Your steadiness goes wherever you go.",
            reflectionPrompt = "Which of your own opinions is making this place feel wrong? Could you carry a kinder one instead?"
        ),

        // q422, Epictetus (restless)
        "q422" to QuoteInsight(
            intro = "When you feel restless because something you want is out of reach, Epictetus offers a surprising route to freedom: not getting everything, but loosening the wanting.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Freedom by Letting Go",
                    blockquote = "Freedom is acquired not by the full possession of the things which are desired, but by removing the desire.",
                    body = "We usually imagine freedom as finally having what we want. Epictetus, who was born enslaved and thought deeply about freedom, saw it differently. Desire for things outside your control keeps you on a hook, because those things can always be withheld or taken. Every craving carries a kind of restlessness: a sense that you cannot settle until something changes. When you ease the grip of a desire, the restlessness eases too. You do not need to crush the wish, only to stop letting it rule you."
                )
            ),
            modernApplication = "Name the thing you are restless for. Then say to yourself, 'I would like this, and I can be well without it.' Notice whether your body softens a little.",
            closing = "Less craving leaves more room to breathe.",
            reflectionPrompt = "What desire is keeping you unsettled right now? What would loosening it, even slightly, feel like?"
        ),

        // q423, Seneca (restless)
        "q423" to QuoteInsight(
            intro = "If you have tried changing your surroundings and the unrest came along anyway, Seneca understands. He wrote to his friend Lucilius, who had traveled far and still felt heavy, that the change needed is inside.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Change of Soul",
                    blockquote = "You need a change of soul rather than a change of climate.",
                    body = "Lucilius had gone on long journeys hoping to shake off a gloom, and it followed him. Seneca was not surprised. In the same letter he recalls Socrates asking why anyone wonders that travel does not help, since you always take yourself along. This is not meant to make you feel trapped. It is freeing: the thing that needs to shift is something you can work on wherever you are. A new view outside can be lovely, but a new way of seeing is what brings rest."
                )
            ),
            modernApplication = "Instead of planning an escape today, ask what you are trying to leave behind. Write it in one sentence, and treat that sentence as the real destination for your attention.",
            closing = "The journey that helps most is inward.",
            reflectionPrompt = "What are you hoping a new place would fix? Could you begin working on that here?"
        ),

        // q424, Seneca (restless)
        "q424" to QuoteInsight(
            intro = "When you cannot sit still, Seneca offers a gentle sign of a settled mind: being able to stay in one place and keep yourself company.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Lingering in Your Own Company",
                    blockquote = "The primary indication, to my thinking, of a well-ordered mind is a man's ability to remain in one place and linger in his own company.",
                    body = "Seneca opens his second letter to Lucilius by praising him for not rushing about from place to place. He goes on to warn against flitting from book to book, never staying long enough for anything to take root. Restlessness can feel like hunger for more, but often it is discomfort with being alone with ourselves. Learning to linger is a skill, not a fixed trait. It grows a little each time you stay put a moment longer than you wanted to."
                )
            ),
            modernApplication = "Sit somewhere for five minutes with nothing to do. When the urge to move or check something arrives, notice it, let it pass, and stay.",
            closing = "You are good company to keep.",
            reflectionPrompt = "What makes it hard to stay with yourself right now? What might you notice if you stayed a little longer?"
        ),

        // q425, Seneca (restless)
        "q425" to QuoteInsight(
            intro = "If you suspect a better setting would finally bring you peace, Seneca gently disagrees. Writing to Lucilius about a quiet country house he visited, he says the place helps little; the mind does the real work.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Mind Makes the Place",
                    blockquote = "The place where one lives, however, can contribute little towards tranquility; it is the mind which must make everything agreeable to itself.",
                    body = "Seneca had been visiting the villa of a man named Vatia, known for withdrawing from public life. Seneca admired the house but remarked that Vatia knew how to hide, not how to live. A lovely place can soothe for a while, yet the same mind arrives in every room. If your thoughts are agitated, a quiet location will not quiet them on its own. This is good news: you do not have to wait for the perfect setting to start feeling more at ease."
                )
            ),
            modernApplication = "Wherever you are, make one small change that is about attention, not location: slow your breathing, soften your shoulders, and choose one thing nearby to look at with care.",
            closing = "Peace is something you bring into the room.",
            reflectionPrompt = "What would make this place more agreeable to you, from the inside? What thought could you set down?"
        ),

        // q426, Marcus Aurelius (confused)
        "q426" to QuoteInsight(
            intro = "When you are unsure whether you have been thinking or acting rightly, Marcus Aurelius models an open heart: if someone can show him he is wrong, he will gladly change.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Gladly Changing Course",
                    blockquote = "If any man is able to convince me and show me that I do not think or act right, I will gladly change; for I seek the truth, by which no man was ever injured.",
                    body = "Confusion can feel threatening, as if being wrong would be a disaster. Marcus turns that around. He seeks the truth, and he says no one was ever harmed by it. What harms us, he goes on, is staying in our own error and ignorance. So being corrected is not a loss. It is a gift. If you hold your views loosely enough to change them, you no longer have to defend every position, and the knot of confusion begins to loosen."
                )
            ),
            modernApplication = "Pick the belief you are least sure of right now and say, 'I might be wrong about this, and that is all right.' Then look for one piece of information that could change your mind.",
            closing = "The truth never harms the one who seeks it.",
            reflectionPrompt = "What would you be willing to change your mind about? What would you gain by finding out?"
        ),

        // q427, Epictetus (confused)
        "q427" to QuoteInsight(
            intro = "When your thoughts are spinning, Epictetus offers one sorting question to return to: what here is your own, and what belongs to someone or something else?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Sorting What Is Yours",
                    blockquote = "Always remember what is your own, and what belongs to another; and you will not be disturbed.",
                    body = "This is the heart of Epictetus's teaching. What is your own includes your judgments, your choices, and how you respond. Everything else, such as other people's actions, outcomes, and events, belongs elsewhere. Much confusion comes from trying to manage things that were never ours to manage. When you sort them, the picture gets clearer. You can put your full effort into what is yours and hold the rest with open hands."
                )
            ),
            modernApplication = "Draw a line down a page. On one side, list what is yours in this situation. On the other, what belongs to others. Spend your next hour only on the first column.",
            closing = "Clarity begins with knowing what is yours.",
            reflectionPrompt = "In what is troubling you, what is truly yours? What could you hand back?"
        ),

        // q428, Epictetus (confused)
        "q428" to QuoteInsight(
            intro = "When you face a situation and do not know how to carry yourself, Epictetus suggests picturing someone wise and asking what they would do.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Borrowing a Wiser Eye",
                    blockquote = "Place before yourself what Socrates or Zeno would have done in such circumstances, and you will have no difficulty in making a proper use of the occasion.",
                    body = "Epictetus offers this advice for moments like meeting someone powerful, when it is easy to lose your footing. He names Socrates and Zeno, the founder of Stoicism, because they lived what they taught. Imagining them in your place gives you a little distance from your own confusion. You do not have to become them. You only need to borrow their calm for a moment. Often the answer you find is one you already knew."
                )
            ),
            modernApplication = "Think of someone you admire for their steadiness, from history or your own life. Ask, 'What would they do right now?' and take the first small step that answer suggests.",
            closing = "Wisdom you admire is wisdom you can borrow.",
            reflectionPrompt = "Whose steadiness do you admire? What would they do in your place?"
        ),

        // q429, Epictetus (confused)
        "q429" to QuoteInsight(
            intro = "When you are unsure whether to take something on, Epictetus offers a careful habit: look at what comes before an action and what follows it, then decide.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Comes First, What Follows",
                    blockquote = "In every act observe the things which come first, and those which follow it; and so proceed to the act.",
                    body = "In this passage Epictetus uses the example of wanting to win at the Olympic games. He asks you to consider the training, the discipline, and the hard parts that come along with the prize. Confusion often comes from seeing only the goal or only the obstacle. Looking at the whole sequence, beginning to end, gives you a fuller picture. Then you can step forward with open eyes, or decide not to, without regret."
                )
            ),
            modernApplication = "Choose the decision in front of you. Write down three things it requires beforehand and three likely things that follow. Read the list once, then decide.",
            closing = "Seeing the whole path steadies each step.",
            reflectionPrompt = "What comes before and after the choice you are weighing? Does it still feel right?"
        ),

        // q430, Seneca (confused)
        "q430" to QuoteInsight(
            intro = "When your plans keep falling apart and nothing feels right, Seneca suggests the trouble may be the lack of a clear aim. Without a harbor, no wind will help.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Choosing Your Harbor",
                    blockquote = "Our plans miscarry because they have no aim. When a man does not know what harbor he is making for, no wind is the right wind.",
                    body = "Seneca wrote this to Lucilius, who kept asking him for advice on particular questions. Seneca replies that good advice depends on knowing what a person is aiming at in life as a whole. His image is a sailor: if you do not know where you are going, every wind feels wrong. Confusion about small choices often grows from uncertainty about larger ones. You do not need a perfect life plan. Naming even a plain direction, such as 'I want to act with honesty,' makes many smaller choices clearer."
                )
            ),
            modernApplication = "Write one sentence that describes the kind of person you want to be this week. Hold today's choices up against it and see which ones fit.",
            closing = "A clear aim makes every wind useful.",
            reflectionPrompt = "What harbor are you making for? Which choice in front of you moves you toward it?"
        ),

        // q431, Seneca (confused)
        "q431" to QuoteInsight(
            intro = "If you feel like you are moving without going anywhere, Seneca names the difference between traveling and wandering: knowing what to seek and what to avoid.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Traveling, Not Wandering",
                    blockquote = "As long as you are ignorant of what you should avoid or seek, or of what is necessary or superfluous, or of what is right or wrong, you will not be traveling, but merely wandering.",
                    body = "In this letter Seneca again writes about restless journeys and why they fail to help. Wandering is motion without direction. Traveling is motion with a purpose. He says the difference lies in understanding what is worth seeking, what is worth avoiding, and what is necessary versus extra. When you feel lost, it can help to stop asking where to go and start asking what you value. Direction tends to follow."
                )
            ),
            modernApplication = "Make three short lists: what you want more of, what you want less of, and what you could do without. Let one item from each guide what you do today.",
            closing = "Knowing what matters turns wandering into a path.",
            reflectionPrompt = "What do you truly want to seek, and what do you want to avoid? What could you let go of as extra?"
        ),

        // q432, Marcus Aurelius (regretful)
        "q432" to QuoteInsight(
            intro = "When regret keeps you looking backward, Marcus Aurelius reminds you that the only life anyone truly lives is this present moment.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "This Indivisible Point",
                    blockquote = "Bear in mind that every man lives only this present time, which is an indivisible point, and that all the rest of his life is either past or it is uncertain.",
                    body = "Marcus describes the present as a single, indivisible point. Everything else is either already past or not yet certain. That can sound stark, but for someone weighed down by regret it can be a relief. The past is real, yet you do not live there anymore. You live here, in this moment, which is small enough to handle. Whatever you did before, this point in time is open to you now."
                )
            ),
            modernApplication = "Feel your breath go in and out three times. With each breath, tell yourself, 'This is the moment I am living.' Then choose one thing to do with it.",
            closing = "This moment is the one you get to live.",
            reflectionPrompt = "What is happening in this present moment? What do you want to do with it?"
        ),

        // q433, Epictetus (regretful)
        "q433" to QuoteInsight(
            intro = "When you keep tallying what a choice cost you, Epictetus offers a different ledger: notice what you gained in its place.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What You Gained Instead",
                    blockquote = "Keep this thought in readiness, when you lose anything external, what you acquire in place of it; and if it be worth more, never say, I have had a loss.",
                    body = "Epictetus gives examples: if you gave up a little money for a good action, or idle talk for a calmer mind, you did not lose. Regret tends to see only the cost. It rarely counts the honesty you kept, the lesson you learned, or the person you became through the choice. This is not about pretending a loss did not hurt. It is about seeing the full exchange, so the story you tell yourself is complete."
                )
            ),
            modernApplication = "Write down one thing you regret losing. Beside it, write anything you gained: a lesson, a value you kept, a new clarity. Read both sides slowly.",
            closing = "Count the whole exchange, gains included.",
            reflectionPrompt = "What did you gain through the thing you regret? Is it worth more than you have been allowing?"
        ),

        // q434, Seneca (regretful)
        "q434" to QuoteInsight(
            intro = "When you regret days that slipped away, Seneca offers a welcome for the day in front of you: treat it as the best one, and make it your own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Welcoming the Day",
                    blockquote = "Let every day, as soon as it comes, be welcome as being the choicest, and let it be made our own possession.",
                    body = "Seneca wrote this in a long letter to Lucilius about how to learn from philosophy and how to treat time. Rather than mourning wasted days, he asks you to greet each new day as the choicest you will get. Regret keeps comparing today with all the days you wish had gone differently. Welcoming makes today something to receive, not something to measure. A day you have taken up as your own is not wasted, whatever came before it."
                )
            ),
            modernApplication = "When you notice the next hour beginning, greet it in your head: 'This one is mine.' Then spend a few minutes of it on something you care about.",
            closing = "Welcome today as if it were the best one.",
            reflectionPrompt = "How could you make the rest of today your own? What would it mean to welcome it?"
        ),

        // q435, Seneca (regretful)
        "q435" to QuoteInsight(
            intro = "If you regret not knowing better sooner, Seneca offers a lifelong reassurance: as long as you live, keep learning how to live.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Never Too Late to Learn",
                    blockquote = "As long as you live, keep learning how to live.",
                    body = "Seneca was an old man when he wrote this, and he was attending a philosopher's lectures alongside much younger students. He quotes the line as a proverb and takes it to heart. Regret often carries the thought that we should have known already. Seneca shows that wisdom is not a finished state. Everyone is still learning, at every age. What you know now, you can use now, and that is what matters."
                )
            ),
            modernApplication = "Name one thing your regret has taught you. Write it as a short sentence beginning, 'From now on, I...' and keep it where you will see it.",
            closing = "You are still learning, and that is enough.",
            reflectionPrompt = "What has this regret taught you? How could you use that today?"
        ),

        // q436, Epictetus (jealous envious)
        "q436" to QuoteInsight(
            intro = "When envy stings, Epictetus offers a quiet idea: if what is truly good lies within your own power, there is nothing left to envy.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Good That Is Yours",
                    blockquote = "If the nature of the good is in our power, neither envy nor jealousy will have a place in us.",
                    body = "Epictetus taught that real goods are inner: good judgment, honesty, steadiness. Those belong to you, and no one else can have them in your place. Status, money, and attention are things others control, and they come and go. Envy assumes someone else has taken a good that should have been yours. But if the deepest good is your own character, another person's gain takes nothing from you. That frees you to wish them well."
                )
            ),
            modernApplication = "When envy arises, ask, 'Does their gain take anything from my character?' Then name one quality of yours you can strengthen today.",
            closing = "No one can take the good that lives in you.",
            reflectionPrompt = "What good thing do you have that no one else can take? How might you grow it?"
        ),

        // q437, Epictetus (jealous envious)
        "q437" to QuoteInsight(
            intro = "When you see someone with more money or comfort, Epictetus suggests a turn of attention: look at what you possess in place of riches.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What You Possess Instead",
                    blockquote = "When you see another rich, see what you possess in place of riches.",
                    body = "Epictetus, who was born enslaved, knew what it was to have little. He is not pretending money does not matter to daily life. He is asking you to notice the things you have that wealth cannot buy: self-respect, a clear conscience, the capacity to be content. Envy measures by one ruler only. Epictetus offers another ruler, and by it you may be richer than you thought."
                )
            ),
            modernApplication = "Write the sentence, 'In place of riches, I have...' and complete it three times. Read the list when the comparison comes back.",
            closing = "There is more than one way to be rich.",
            reflectionPrompt = "What do you possess that money could not buy? How does it feel to name it?"
        ),

        // q438, Epictetus (jealous envious)
        "q438" to QuoteInsight(
            intro = "When it seems someone gets ahead unfairly, Epictetus asks a sharper question: does that person have the advantage over you in being faithful, in being modest?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Where Your Advantage Lies",
                    blockquote = "See if he has the advantage over you in being faithful, in being modest; for you will not find it to be so; but wherein you are superior, there you will find that you have the advantage.",
                    body = "Epictetus raises this when someone complains that the unjust prosper. Yes, he says, they may have more money, gained by flattery or shamelessness. But look at what they paid for it. In faithfulness and modesty, they do not outrank you. Each of us gains in what we invest in. If you have chosen integrity over advantage, you are not behind. You hold a different kind of wealth."
                )
            ),
            modernApplication = "Name the person you envy and the quality you have kept instead of following their path. Say to yourself, 'I made a trade, and I would make it again.'",
            closing = "Integrity is an advantage no one can buy.",
            reflectionPrompt = "What have you chosen that the person you envy has not? Does it still feel worth it?"
        ),

        // q439, Seneca (jealous envious)
        "q439" to QuoteInsight(
            intro = "When others are praised and celebrated and you are not, Seneca reminds you that you need not envy them, and that applause need not shake your calm.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Applause Need Not Move You",
                    blockquote = "You need not be envious of those whom the people call great and fortunate; applause need not disturb your composed attitude and your sanity of mind.",
                    body = "In this letter Seneca writes about how sound principles can steady a person against the pull of crowds. People call some lives great and fortunate, but the crowd's judgment is often shallow and changing. Praise for someone else does not reduce you. Your composure and good sense are yours to keep, even while others cheer. Seneca is not asking you to despise success. He is asking you not to hand your peace over to the crowd."
                )
            ),
            modernApplication = "When you see someone praised today, take one slow breath and quietly wish them well. Then return to a task that matters to you, applause or not.",
            closing = "Your calm does not depend on the crowd.",
            reflectionPrompt = "Whose praise are you measuring yourself against? What would you value if no one were watching?"
        ),

        // q440, Seneca (jealous envious)
        "q440" to QuoteInsight(
            intro = "When you feel you have too little compared with others, Seneca, drawing on Epicurus, offers a reframe: poverty is less about having little than about craving more.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Poverty of Craving",
                    blockquote = "It is not the man who has too little, but the man who craves more, that is poor.",
                    body = "Seneca took this thought from Epicurus, whose school was a rival to his own, saying he crossed into the other camp as a scout. The idea is that wanting more and more can leave even a wealthy person feeling poor. Envy often works this way: it keeps raising the bar so nothing you have feels like enough. When you ease the craving, what you already have starts to feel fuller. Contentment is a kind of wealth you can begin building today."
                )
            ),
            modernApplication = "For one day, when you notice yourself wanting something someone else has, pause and say, 'I have enough for this moment.' See how it changes the feeling.",
            closing = "Enough is a place you can arrive at.",
            reflectionPrompt = "What would feel like enough for you today? What craving could you set aside?"
        ),

        // q441, Seneca (jealous envious)
        "q441" to QuoteInsight(
            intro = "When comparison makes you feel you will never have enough, Seneca shares a saying of Epicurus: live by nature and you will never be poor; live by opinion and you will never be rich.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Nature, Not Opinion",
                    blockquote = "If you live according to nature, you will never be poor; if you live according to opinion, you will never be rich.",
                    body = "Seneca follows this saying with a plain line: nature's wants are slight, while the demands of opinion have no limit. Envy belongs to opinion. It measures you against what others have, and that measure always moves. Nature asks for much less: food, shelter, rest, people to care for. When you separate what you need from what you have been told to want, much of the comparison falls quiet."
                )
            ),
            modernApplication = "Make two short lists: what you truly need, and what you want because others have it. Let yourself feel the relief of how short the first list is.",
            closing = "Your real needs are smaller than envy claims.",
            reflectionPrompt = "Which of your wants comes from comparison? What do you truly need right now?"
        ),

        // q442, Epictetus (unmotivated)
        "q442" to QuoteInsight(
            intro = "When motivation is missing, Epictetus offers a practical truth: every habit is built and kept by doing it. You become a reader by reading, a writer by writing.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Doing Builds the Habit",
                    blockquote = "Every habit and faculty is maintained and increased by the corresponding actions: the habit of walking by walking, the habit of running by running. If you would be a good reader, read; if a writer, write.",
                    body = "Epictetus taught that we strengthen whatever we practice. Walking makes you a better walker, running a better runner. It works the other way too: skipped actions let habits weaken. That can sound like pressure, but it is also hope. You do not have to wait to feel motivated before you act. Often the action comes first and the feeling follows. Even a few minutes of doing keeps the thread unbroken."
                )
            ),
            modernApplication = "Pick the habit you are struggling with and do the smallest version of it today: one page, one paragraph, one lap. Mark it done.",
            closing = "You become what you keep doing.",
            reflectionPrompt = "What habit do you want to keep alive? What is the smallest action that would feed it today?"
        ),

        // q443, Epictetus (unmotivated)
        "q443" to QuoteInsight(
            intro = "If you feel far from who you want to be, Epictetus offers encouragement: you are not yet a Socrates, but you can live as someone who wishes to be one.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Living Toward Who You Hope to Be",
                    blockquote = "You, though you are not yet a Socrates, ought to live as one who wishes to be a Socrates.",
                    body = "This line comes near the end of the Enchiridion, where Epictetus urges a student to stop delaying improvement. He notes that Socrates became who he was by attending to reason in everything. You do not need to be finished to begin. The gap between where you are and where you want to be can feel discouraging. Epictetus suggests a different view: wishing to grow, and acting on that wish today, already makes you a person on the way."
                )
            ),
            modernApplication = "Picture the person you hope to become. Ask what one thing they would do today, and do a small version of it.",
            closing = "Wishing to grow is already a beginning.",
            reflectionPrompt = "Who do you wish to become? What would that person do in the next hour?"
        ),

        // q444, Epictetus (unmotivated)
        "q444" to QuoteInsight(
            intro = "When you feel flat and directionless, Epictetus offers a gentle nudge: look around, stir yourself a little, so you can remember who you are.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Stirring Yourself Awake",
                    blockquote = "Examine a little at last, look around, stir yourself up, that you may know who you are.",
                    body = "Epictetus says this after observing that some people cannot walk alone and hide in the chorus of others. He invites you to step out a little, to walk and talk with yourself. Low motivation can feel like fog, where you lose track of what you care about. Stirring yourself does not mean forcing big changes. It means waking up enough to look around, ask questions, and notice who you are under the heaviness."
                )
            ),
            modernApplication = "Stand up, open a window or step outside, and look at three things around you with care. Then ask yourself, 'What do I care about today?'",
            closing = "A little stirring can remind you who you are.",
            reflectionPrompt = "What do you notice when you look around right now? What does that tell you about yourself?"
        ),

        // q445, Seneca (unmotivated)
        "q445" to QuoteInsight(
            intro = "When sluggishness settles over you, Seneca's advice is to rouse yourself and turn to something good. He wrote this letter while living above a noisy bathhouse.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Rousing Toward the Good",
                    blockquote = "We must therefore rouse ourselves to action and busy ourselves with interests that are good, as often as we are in the grasp of an uncontrollable sluggishness.",
                    body = "Seneca describes trying to read amid shouting, splashing, and street sellers, and finding that the real noise was inside. He notes that a still body does not mean a quiet soul. His remedy for a heavy, idle mind is to give it something good to do. Sluggishness often feeds on itself. Turning even a little energy toward a worthwhile task can interrupt the cycle and bring the mind back to life."
                )
            ),
            modernApplication = "Choose one worthwhile thing that takes ten minutes: tidy a corner, write a note to a friend, read a page of something good. Start before you feel ready.",
            closing = "A good task can wake a tired mind.",
            reflectionPrompt = "What good thing could you turn toward right now? How might it feel after ten minutes?"
        ),

        // q446, Seneca (unmotivated)
        "q446" to QuoteInsight(
            intro = "When starting feels impossible, Seneca admits it: the mind sometimes has to be pushed to begin. But once the cure starts working, it begins to feel good.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Hardest Part Is Starting",
                    blockquote = "The mind must, therefore, be forced to make a beginning; from then on, the medicine is not bitter; for just as soon as it is curing us it begins to give pleasure.",
                    body = "Seneca compares growing better to taking medicine. The first taste can be bitter, and the mind resists. But he says once you make a beginning, the bitterness fades, because healing brings its own pleasure. This is a kind word for anyone stuck at the starting line. Your reluctance does not mean you are failing. It is the ordinary resistance before the first step, and it often softens once you move."
                )
            ),
            modernApplication = "Set a timer for five minutes and begin the thing you have been avoiding. When the timer ends, you may stop, or keep going if it has become easier.",
            closing = "The beginning is the bitter part, and it passes.",
            reflectionPrompt = "What would it take to begin for only five minutes? What might change once you start?"
        ),

        // q447, Marcus Aurelius (hopeless)
        "q447" to QuoteInsight(
            intro = "When it feels like you cannot go on, Marcus Aurelius asks you to remember how much you have already passed through, and how much you have been able to bear.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Remembering What You Endured",
                    blockquote = "Call to recollection both how many things you have passed through, and how many things you have been able to endure.",
                    body = "Hopelessness can erase memory, making it seem as if you have never come through anything hard. Marcus asked himself to recall the full record. You have come through difficult days before, ones that felt endless while you were in them. That does not make your pain small. It is a sign of your own strength. The person who got through those times is the same person here now."
                )
            ),
            modernApplication = "Write down one hard time you got through. Under it, write one thing that helped. Keep that note close today.",
            closing = "You have carried hard things before.",
            reflectionPrompt = "What difficult time have you already come through? What helped you then?"
        ),

        // q448, Epictetus (hopeless)
        "q448" to QuoteInsight(
            intro = "When your mind keeps asking how it will all turn out, Epictetus offers reassurance: however it goes, you can meet it in a way that is your own.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "However It Turns Out",
                    blockquote = "No longer then say to me, How will it be? For, however it may be, you will dispose of it well, and the result to you will be a fortunate one.",
                    body = "Epictetus taught that outcomes are beyond our control, but how we meet them is within it. The anxious question 'How will it be?' assumes everything depends on the outcome. He shifts the weight to you: whatever comes, you can handle it with judgment and care, and that is where your good lies. This does not promise that things will go as you hope. It promises that you will still have something to bring to them."
                )
            ),
            modernApplication = "When the question 'How will it turn out?' comes up, replace it with 'Whatever happens, how do I want to meet it?' Name one quality you want to bring.",
            closing = "Whatever comes, you will still have yourself.",
            reflectionPrompt = "What quality do you want to bring to whatever happens? What would that look like today?"
        ),

        // q449, Seneca (hopeless)
        "q449" to QuoteInsight(
            intro = "When you are in the very middle of something painful, Seneca offers a line of poetry to hold: perhaps some day the memory of this sorrow will even bring delight.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Future Memory",
                    blockquote = "When set in the very midst of troubles one should say: Perhaps some day the memory of this sorrow will even bring delight.",
                    body = "Seneca wrote this to Lucilius, who was troubled by repeated illness, and he borrowed the line from Virgil. Earlier in the letter he notes that what was bitter to bear can be pleasant to have borne. He does not deny that the trouble is real or heavy now. He invites you to imagine a future self looking back, having come through. That future is not certain, but it is possible, and holding the possibility can make the present a little lighter."
                )
            ),
            modernApplication = "Write one sentence your future self might say about this time: 'I remember when...' You do not have to believe it fully. Let it sit as a possibility.",
            closing = "One day this may be a story you tell.",
            reflectionPrompt = "What might your future self want you to know right now? Can you imagine looking back on this?"
        ),

        // q450, Seneca (hopeless)
        "q450" to QuoteInsight(
            intro = "When something you built has fallen, Seneca offers a word of hope he once wrote for a friend whose beloved city had burned: many structures have fallen only to rise higher.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Room for Something Greater",
                    blockquote = "Oftentimes a reverse has but made room for more prosperous fortune. Many structures have fallen only to rise to a greater height.",
                    body = "Seneca wrote this letter thinking of his friend Liberalis, who was grieving the destruction of a city he loved by fire. Seneca does not tell him to stop caring. He suggests that ruin can sometimes clear space for something better. Collapse does not have to be the final word. This is not a promise that every loss turns into gain. It is a reminder that what falls can be rebuilt, sometimes more strongly than before."
                )
            ),
            modernApplication = "Think of one thing in your life that fell apart and later made room for something good. Let that memory sit beside what you are facing now.",
            closing = "What falls can rise again.",
            reflectionPrompt = "What might this loss be making room for, in time? Is there one small thing you could rebuild today?"
        ),

        // q451, Seneca (hopeless)
        "q451" to QuoteInsight(
            intro = "When you feel sure the worst is coming, Seneca reminds you that even bad fortune is fickle. It may come, it may not, and right now it is not here.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Here Yet",
                    blockquote = "Even bad fortune is fickle. Perhaps it will come, perhaps not; in the meantime it is not. So look forward to better things.",
                    body = "Seneca wrote this letter to Lucilius about fears that run ahead of reality. In it he observes that we suffer more often in imagination than in fact. Hopelessness often treats the future as already decided. Seneca loosens that certainty: fortune changes, and the thing you dread is, for this moment, not happening. That opening is enough to let hope back in, even a little."
                )
            ),
            modernApplication = "Say to yourself, 'Right now, in this moment, it is not happening.' Then look around and name one thing that is all right in this exact minute.",
            closing = "In this moment, the worst has not come.",
            reflectionPrompt = "What are you bracing for? What is actually here with you right now?"
        ),

        // q452, Marcus Aurelius (anxious)
        "q452" to QuoteInsight(
            intro = "When the future feels frightening, Marcus Aurelius offers a steadying thought: whatever comes, you will meet it with the same mind you are using right now.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Same Reason Then",
                    blockquote = "Let not future things disturb you, for you will come to them, if it shall be necessary, having with you the same reason which now you use for present things.",
                    body = "Anxiety often imagines a future version of you who is helpless. Marcus reminds himself that this is not how it works. If a hard thing does come, you will arrive there with the same reason, the same ability to think and choose, that you have today. You have met many present moments already, including difficult ones. The future will also be a present moment when you reach it, and you will be there to meet it."
                )
            ),
            modernApplication = "Recall one hard moment you already got through. Say to yourself: \"I will bring the same mind to whatever comes.\" Then turn back to what is in front of you now.",
            closing = "You will bring yourself to whatever comes.",
            reflectionPrompt = "What has helped you through hard moments before? Which of those things do you have with you now?"
        ),

        // q453, Marcus Aurelius (anxious)
        "q453" to QuoteInsight(
            intro = "When anxiety feels like it is pressing in from outside, Marcus Aurelius offers a discovery he wrote down one day: much of the trouble was in how he was seeing things.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Casting Out Trouble",
                    blockquote = "Today I have got out of all trouble, or rather I have cast out all trouble, for it was not outside, but within and in my opinions.",
                    body = "Notice how Marcus corrects himself mid-sentence. At first he says he got out of trouble, as if he escaped something. Then he says he cast it out, because it was within, in his opinions. This is not a claim that nothing hard is happening. It is a recognition that the extra weight, the dread and the spiraling, often comes from the story we tell about events. Stories can be examined and set aside, sometimes within a single day."
                )
            ),
            modernApplication = "Write down the worry, then underline the parts that are opinion rather than fact, such as \"this will be a disaster.\" Ask what remains when the opinion is set aside.",
            closing = "Some trouble lives in opinion, and opinion can change.",
            reflectionPrompt = "Which part of your worry is fact, and which part is opinion? What could you cast out today?"
        ),

        // q454, Epictetus (anxious)
        "q454" to QuoteInsight(
            intro = "When you feel anxious, Epictetus offers a question that can untangle it: what do I want right now that is not in my power?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What Do You Want",
                    blockquote = "When I see a man anxious, I say, What does this man want? If he did not want something which is not in his power, how could he be anxious?",
                    body = "Epictetus pictured a lute player who plays well alone but grows anxious when he enters the theater. The music is in his power. The crowd's applause is not. Anxiety, he suggests, often comes from reaching for something outside our control, such as how others will respond or how events will turn out. Naming what you want is not a criticism. It is a way of finding the knot so you can begin to loosen it."
                )
            ),
            modernApplication = "Finish this sentence: \"Right now I want...\" Then sort what you wrote into two parts: what is in your power, and what is not. Give your effort to the first part.",
            closing = "Find the want, and the knot begins to loosen.",
            reflectionPrompt = "What do you want right now that is not in your power? What part of it is yours to do?"
        ),

        // q455, Epictetus (anxious)
        "q455" to QuoteInsight(
            intro = "When you are tense about how things will turn out, Epictetus offers a way to ease the grip: let things be as they are, and life begins to flow.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Tranquil Flow",
                    blockquote = "Seek not that the things which happen should happen as you wish; but wish the things which happen to be as they are, and you will have a tranquil flow of life.",
                    body = "Much anxiety comes from demanding that events go one particular way. Epictetus suggests turning the wish around: instead of insisting the world match your plan, try welcoming what actually happens. This does not mean you stop caring or stop acting. It means you hold your hopes loosely enough that reality is not a constant threat. When you stop wrestling with what is, there is more strength left for what you can do."
                )
            ),
            modernApplication = "Name one outcome you are gripping tightly. Breathe out slowly and say: \"Let it be as it is. I will do my part.\" Then choose one action that is yours to take.",
            closing = "Hold your hopes loosely, and your part firmly.",
            reflectionPrompt = "Which outcome are you gripping right now? What might ease if you let it be as it is?"
        ),

        // q456, Epictetus (anxious)
        "q456" to QuoteInsight(
            intro = "When you have done what you can and still feel uneasy, Epictetus offers the picture of a sea voyage: you choose the ship and the day, and then your part is done.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "My Part Is Done",
                    blockquote = "What can I do? I can choose the master of the ship, the sailors, the day, the opportunity. Then comes a storm. What more have I to care for? For my part is done.",
                    body = "Epictetus describes setting out on a voyage. You can choose a good captain, a good crew, and a good day to sail. Then a storm comes, and it is not yours to command. Anxiety often keeps working long after our part is finished, replaying choices and bracing for storms. Epictetus invites you to notice the line between preparing well and trying to control the weather. Once you have done your part, you are allowed to rest."
                )
            ),
            modernApplication = "List what you have already done to prepare. Read it back and say: \"My part is done.\" If there is one more reasonable step, take it, then let the rest go.",
            closing = "Once your part is done, you may rest.",
            reflectionPrompt = "What have you already done well here? What is the storm that is not yours to control?"
        ),

        // q457, Seneca (anxious)
        "q457" to QuoteInsight(
            intro = "When your mind is full of what might go wrong, Seneca offers his friend Lucilius a gentle observation: we suffer more often in imagination than in reality.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "More Frightening Than Real",
                    blockquote = "There are more things, Lucilius, likely to frighten us than there are to crush us; we suffer more often in imagination than in reality.",
                    body = "Seneca wrote this to Lucilius as a friend, not a judge. He notices that many things threaten us but few actually arrive, and that much of our suffering happens in rehearsal. In the same letter he urges Lucilius to look closely at a fear, since what troubles us is often exaggerated or not yet real. Imagination is a gift, but it can also build storms that never come. Seeing this can loosen anxiety's hold, even a little."
                )
            ),
            modernApplication = "Ask of your worry: has this happened, or am I picturing it? If it is still in the future, say gently: \"Not yet, and maybe not at all.\"",
            closing = "Much of what you fear is still only imagined.",
            reflectionPrompt = "Which part of your worry has actually happened? Which part is your imagination rehearsing?"
        ),

        // q458, Seneca (anxious)
        "q458" to QuoteInsight(
            intro = "When you are already hurting over something that has not happened, Seneca offers a short, clear line: suffering early only adds to the suffering.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Suffering Before the Time",
                    blockquote = "He suffers more than is necessary, who suffers before it is necessary.",
                    body = "Seneca wrote this to Lucilius about people who torment themselves in advance. Worry can feel like preparation, as if suffering now will make a hard thing easier later. Seneca saw that it does not. It only doubles the pain: once in anticipation, and again if the thing does come. You are allowed to wait until something is actually here before you carry it. Until then, this moment can be lived on its own terms."
                )
            ),
            modernApplication = "When you catch yourself suffering in advance, say: \"That is not here yet.\" Then name one thing in the present that is okay, even something small, like warmth or a quiet room.",
            closing = "You do not have to carry tomorrow's weight today.",
            reflectionPrompt = "What are you suffering in advance? What in this moment is actually okay?"
        ),

        // q459, Seneca (anxious)
        "q459" to QuoteInsight(
            intro = "When fear of a future problem is spoiling today, Seneca offers his friend Lucilius a calm reminder: being unhappy now because you might be unhappy later costs you twice.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Do Not Borrow Unhappiness",
                    blockquote = "It is indeed foolish to be unhappy now because you may be unhappy at some future time.",
                    body = "Seneca wrote this to Lucilius, who was anxious about a lawsuit threatened by an angry opponent. Seneca did not offer empty reassurance. Instead he suggested a different route to peace: picture the feared thing honestly, measure it, and see that it is often smaller or shorter than the dread suggests. Meanwhile, the present is here, and it does not have to be spent in fear of what may never come."
                )
            ),
            modernApplication = "Picture the worst realistic outcome and describe it in two plain sentences. Ask how you would cope if it came. Then return to today, which is still yours.",
            closing = "Today does not have to pay for tomorrow.",
            reflectionPrompt = "If the thing you fear did happen, how would you cope? What does today still have to offer?"
        ),

        // q460, Marcus Aurelius (angry)
        "q460" to QuoteInsight(
            intro = "When someone's actions have made you angry, Marcus Aurelius offers a thought from a list he kept for himself: the anger often hurts you more than what was done.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Weight of Vexation",
                    blockquote = "Consider how much more pain is brought on us by the anger and vexation caused by such acts than by the acts themselves, at which we are angry and vexed.",
                    body = "Marcus wrote a whole list of reminders for moments when others offended him, and this is one of them. The act happened once. But anger and vexation can replay it for hours or days, and each replay hurts again. Marcus is not saying the act was fine. He is pointing out where most of the pain is coming from now. That part, at least, is something you can begin to set down."
                )
            ),
            modernApplication = "Notice how many times you have replayed the event in your mind. On the next replay, pause and say: \"This part is hurting me now, not them.\" Take three slow breaths.",
            closing = "The act happened once, and you need not relive it.",
            reflectionPrompt = "How much of your pain right now comes from the act, and how much from replaying it?"
        ),

        // q461, Marcus Aurelius (angry)
        "q461" to QuoteInsight(
            intro = "When people frustrate you, Marcus Aurelius offers two plain options: help them understand, or bear with them.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Teach or Bear With",
                    blockquote = "Men exist for the sake of one another. Teach them then, or bear with them.",
                    body = "Marcus believed people are made to live with and for one another, like parts of one body. When someone acts badly, he gave himself two choices. If you can help them see more clearly, do it, kindly. If you cannot, then patience is the other path. Both choices keep you connected rather than at war. Neither requires you to pretend the wrong did not happen, and neither asks you to carry rage."
                )
            ),
            modernApplication = "Ask yourself: can I teach here, or is this a time to bear with? If teaching, plan one calm sentence. If bearing, let the next breath be longer than the last.",
            closing = "Teach if you can, and bear with them if you cannot.",
            reflectionPrompt = "Is this a moment to teach or to bear with? What would either look like right now?"
        ),

        // q462, Marcus Aurelius (angry)
        "q462" to QuoteInsight(
            intro = "When someone's fault has offended you, Marcus Aurelius offers a quieting move: turn, for a moment, toward your own mistakes.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Turning the Mirror",
                    blockquote = "When you are offended at any man's fault, forthwith turn to yourself and reflect in what like manner you err yourself.",
                    body = "This is not about blaming yourself. Marcus used it to soften his anger by remembering what he shared with the other person. He notes in the same passage that anger is quickly forgotten this way, especially when you also consider what may be driving the other person. When you recall a time you made a similar mistake, they stop looking like a villain and start looking like someone who erred, as you sometimes have."
                )
            ),
            modernApplication = "Recall one time you made a similar mistake and how you hoped to be treated then. Let that memory shape the next thing you say or do.",
            closing = "Seeing yourself in another can soften the anger.",
            reflectionPrompt = "When have you made a mistake like this one? How did you hope others would respond?"
        ),

        // q463, Epictetus (angry)
        "q463" to QuoteInsight(
            intro = "When someone irritates you, Epictetus offers two tools: recognize that your opinion is part of the reaction, and give yourself time before you act.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Gaining Time",
                    blockquote = "When then a man irritates you, you must know that it is your own opinion which has irritated you. Therefore especially try not to be carried away by the appearance. For if you once gain time and delay, you will more easily master yourself.",
                    body = "Epictetus taught that people do not hurt us so much as our judgment about what they did. This is not to say the other person behaved well. It means the sting comes partly from the meaning we give their words. His practical advice is to slow down. Anger arrives quickly and wants action immediately. If you can delay, even briefly, the first wave passes, and you are far more likely to respond the way you would want to."
                )
            ),
            modernApplication = "Before replying to anything that irritated you, wait ten minutes. Use the time to ask: what opinion am I holding about this? Then decide how to respond.",
            closing = "A little delay gives you back yourself.",
            reflectionPrompt = "What opinion is fueling your irritation right now? What might change if you waited before responding?"
        ),

        // q464, Epictetus (angry)
        "q464" to QuoteInsight(
            intro = "When anger has become a habit, Epictetus offers a patient path: stop feeding it, keep quiet at first, and count the calm days.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Counting Calm Days",
                    blockquote = "If then you wish not to be of an angry temper, do not feed the habit: throw nothing on it which will increase it: at first keep quiet, and count the days on which you have not been angry.",
                    body = "Epictetus treated anger like a fire that grows with fuel. Every time we act on it, we strengthen the habit. In the same discourse he describes the progress: angry every day, then every second day, then every third. There is no demand for instant perfection here. Each day without anger is worth noticing and counting. Small, steady progress is how a habit changes, and it begins with one quiet day."
                )
            ),
            modernApplication = "Mark today on a calendar if you get through it without acting on anger. If you do not, there is no shame in it: begin the count again tomorrow.",
            closing = "Every calm day counts.",
            reflectionPrompt = "What feeds your anger most often? How might you keep quiet the next time it rises?"
        ),

        // q465, Epictetus (angry)
        "q465" to QuoteInsight(
            intro = "When someone has taken something from you, Epictetus offers a searching question: how much of the anger comes from how much we value what was taken?",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "What We Value",
                    blockquote = "Why then are we angry? Is it because we value so much the things of which these men rob us? Do not admire your clothes, and then you will not be angry with the thief.",
                    body = "Epictetus tells of losing his own lamp to a thief who was more wakeful than he was. His response was not rage but reflection. He suggests that anger often grows in proportion to how tightly we hold onto external things. This does not mean your loss is unimportant. It means you can ask whether the thing is worth the peace it is costing you, and choose where to place your care."
                )
            ),
            modernApplication = "Name what was taken from you, whether time, respect, or an object. Ask: how much peace am I willing to give for this? Choose a response that protects what matters most.",
            closing = "Hold things loosely, and anger has less to grip.",
            reflectionPrompt = "What do you feel was taken from you? How much of your peace is it worth?"
        ),

        // q466, Seneca (angry)
        "q466" to QuoteInsight(
            intro = "When anger is flaring, Seneca offers his friend Lucilius a strong warning given in care: the real reason to step back is to keep your mind healthy.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Healthy Mind",
                    blockquote = "So it is with anger, my dear Lucilius; the outcome of a mighty anger is madness, and hence anger should be avoided, not merely that we may escape excess, but that we may have a healthy mind.",
                    body = "Seneca compares anger to fire. A great blaze can fail to catch solid timber, while dry, easily lit material flares from the smallest spark. What matters is not how big the provocation is, but what kind of mind it lands on. His concern is for the health of your mind, not for appearances or manners. Stepping back from anger is a way of protecting yourself and keeping your thinking clear."
                )
            ),
            modernApplication = "Treat your mind like dry timber that needs protecting. Step away from the spark for a few minutes: a short walk, a glass of water, a window opened.",
            closing = "Your clear mind is worth protecting.",
            reflectionPrompt = "What kind of spark has landed on you today? What would help your mind feel less ready to catch?"
        ),

        // q467, Seneca (angry)
        "q467" to QuoteInsight(
            intro = "When small frustrations pile up, Seneca offers a lesson from a tired night of his own: anger only adds one more trouble to the pile.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not One More Trouble",
                    blockquote = "Nothing need provoke one's anger if one does not add to one's pile of troubles by getting angry.",
                    body = "Seneca wrote this after arriving at his country house late at night, worn out by an uncomfortable journey, to find the cook and baker unprepared and no bread ready. Instead of getting angry, he sat at his writing table and reflected. The inconvenience was real, but anger would only have added a second trouble to the first. Choosing not to get angry is not giving in. It is refusing to make a hard moment heavier."
                )
            ),
            modernApplication = "When something goes wrong, say to yourself: \"This is one trouble. I will not add a second.\" Then look for the easiest workaround available.",
            closing = "Do not add anger to the pile.",
            reflectionPrompt = "What frustration is on your pile right now? What would it feel like not to add anger to it?"
        ),

        // q468, Marcus Aurelius (grieving)
        "q468" to QuoteInsight(
            intro = "When you have lost someone, Marcus Aurelius offers a quiet thought: what has died does not fall out of the universe.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Still Part of the Whole",
                    blockquote = "That which has died falls not out of the universe.",
                    body = "Marcus wrote this in his notebook as part of his reflection on nature and change. He believed that nothing is truly lost from the whole of things. What has died remains within the universe, changed and returned to the elements that also make up you. This does not remove the ache of absence, and it is not meant to. But it may offer a sense that the one you love is still, in some way, part of the world you live in."
                )
            ),
            modernApplication = "Step outside or open a window. Let yourself feel that the person you miss belongs to the same world you are breathing in. Say their name softly, if you wish.",
            closing = "What you loved is still part of this world.",
            reflectionPrompt = "Where do you feel the presence of the one you lost? What would you like to say to them?"
        ),

        // q469, Marcus Aurelius (grieving)
        "q469" to QuoteInsight(
            intro = "When loss feels as if everything has turned to nothing, Marcus Aurelius offers an image from the vineyard: each change becomes something new, not nothing.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Not Into Nothing",
                    blockquote = "The unripe grape, the ripe bunch, the dried grape, are all changes, not into nothing, but into something which exists not yet.",
                    body = "Marcus recorded this image in his notebook among sayings of Epictetus. The grape grows, ripens, and dries, and each stage gives way to another. Loss does not have to mean erasure. The life you shared has not disappeared into nothing. It has become part of who you are now, and part of what is still unfolding. Grief and this thought can sit side by side. You do not have to choose between them."
                )
            ),
            modernApplication = "Write one way the person you lost has shaped you: a habit, a phrase, a way of seeing. Keep the note somewhere you will find it.",
            closing = "Love changes form, but it does not become nothing.",
            reflectionPrompt = "How has the one you lost shaped who you are? What of them continues in you?"
        ),

        // q470, Marcus Aurelius (grieving)
        "q470" to QuoteInsight(
            intro = "When grief makes the world feel broken, Marcus Aurelius offers a vision of belonging: all things come from nature, live within it, and return to it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Everything Returns",
                    blockquote = "from you are all things, in you are all things, to you all things return.",
                    body = "Marcus wrote this almost as a prayer to nature. He saw every life as held within a larger whole, coming from it and going back to it. For someone grieving, this does not make the loss smaller. It can offer a sense that the one you love has not gone somewhere foreign, but has returned to the same nature that holds you. Your sorrow, too, belongs within that whole, and it is welcome there."
                )
            ),
            modernApplication = "Spend a few minutes with something living: a tree, the sky, a plant on the windowsill. Let it remind you that the one you lost belongs to the same nature that holds you.",
            closing = "The one you love has returned to what holds us all.",
            reflectionPrompt = "Where do you feel most held by the world around you? What would you like to give back to it in their memory?"
        ),

        // q471, Seneca (grieving)
        "q471" to QuoteInsight(
            intro = "When memories of someone you lost are painful, Seneca offers a hope he shared with his friend Lucilius: that in time, remembering can become a comfort.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Memory as Comfort",
                    blockquote = "Let us see to it that the recollection of those whom we have lost becomes a pleasant memory to us.",
                    body = "Seneca wrote this to Lucilius, who was grieving the death of his friend Flaccus. In the same letter Seneca admits that he once wept for a dear friend more than he thought he should, so he wrote as someone who knew this sorrow. He does not ask the pain to vanish. He hopes that over time, the memory of the person can become something you return to gladly. There is no schedule for this. It can happen slowly, one memory at a time."
                )
            ),
            modernApplication = "Choose one happy memory of the person you lost and let yourself stay with it for a minute. You might write it down, or tell it to someone who also knew them.",
            closing = "Each memory can be a way of keeping them close.",
            reflectionPrompt = "What is one memory of them that brings you warmth? Who might you share it with?"
        ),

        // q472, Seneca (grieving)
        "q472" to QuoteInsight(
            intro = "When you are grieving, Seneca offers a way of holding love and loss together: he had his friends as if he might lose them, and lost them as if he had them still.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Having Them Still",
                    blockquote = "To me, the thought of my dead friends is sweet and appealing. For I have had them as if I should one day lose them; I have lost them as if I have them still.",
                    body = "Seneca wrote these words in the same letter to Lucilius, who was mourning a friend. He describes how the thought of his own dead friends had become sweet to him. While they lived, he treasured them, knowing time was not promised. After they were gone, he kept them close in memory and in the ways they had shaped him. Grief and love are woven together here. The loss is real, and so is what remains."
                )
            ),
            modernApplication = "Think of something your loved one gave you: a word, a lesson, a way of laughing. Do one small thing today that carries it forward, as if they were still beside you.",
            closing = "Love can hold someone even after they are gone.",
            reflectionPrompt = "In what ways do you still have them with you? What part of them would you like to carry forward?"
        ),

        // q473, Seneca (grieving)
        "q473" to QuoteInsight(
            intro = "When it feels as though everything has been taken, Seneca offers a steady truth: much of those we love still abides with us, and the past is ours to keep.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Past Is Ours",
                    blockquote = "Believe me, a great part of those we have loved, though chance has removed their persons, still abides with us. The past is ours, and there is nothing more secure for us than that which has been.",
                    body = "Seneca wrote this in a letter of consolation. He reminds the grieving reader that the years shared, the conversations, and the closeness cannot be undone. Chance can take a person's presence, but it cannot take what has already been. That shared past is secure, more secure than anything the future can promise. Your grief is a sign of how much was real, and all of that is still yours."
                )
            ),
            modernApplication = "Look at a photo, a letter, or an object connected to them. Say quietly: \"This was real, and it is still mine.\" Let yourself feel both the love and the loss.",
            closing = "What you shared can never be taken from you.",
            reflectionPrompt = "What part of your shared past do you most want to hold onto? How does it feel to know it is secure?"
        ),

        // q474, Marcus Aurelius (afraid)
        "q474" to QuoteInsight(
            intro = "When you are afraid of pain, Marcus Aurelius offers a steadying reminder: pain has limits, and imagination does not need to add to it.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Pain Has Limits",
                    blockquote = "Pain is neither intolerable nor everlasting, if you bear in mind that it has its limits, and if you add nothing to it in imagination.",
                    body = "Marcus took this thought from Epicurus and kept it close. Fear often pictures pain as endless and unbearable. Marcus reminds himself of two things. Pain has edges: it rises, changes, and eases. And much of what makes it frightening is what imagination adds, the dread of what comes next. You do not have to face all of it at once. You only have to meet this moment, which has limits of its own."
                )
            ),
            modernApplication = "If you are facing pain or the fear of it, breathe slowly and say: \"This has limits. I only need to meet this moment.\" Notice one part of your body that feels calm or neutral.",
            closing = "This moment has edges, and you can meet it.",
            reflectionPrompt = "What is your imagination adding to this fear? What is actually here right now?"
        ),

        // q475, Marcus Aurelius (afraid)
        "q475" to QuoteInsight(
            intro = "When you are afraid of where life might take you, Marcus Aurelius offers a quiet confidence: wherever you are placed, your inner self can stay steady.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Wherever I Am Placed",
                    blockquote = "Take me and cast me where you will; for there I shall keep my divine part tranquil, that is, content.",
                    body = "Marcus wrote many of these notes while on campaign, far from home. He knew he could not choose every place or circumstance. What he could keep was his divine part, the reasoning, choosing self within him. That part, he believed, could stay tranquil anywhere. Fear often comes from imagining being thrown into circumstances beyond our control. Marcus reminds you that your center goes with you."
                )
            ),
            modernApplication = "Place a hand on your chest and say: \"Wherever I am, this stays with me.\" Let yourself feel steady in your own body before facing what comes next.",
            closing = "Your steady center goes wherever you go.",
            reflectionPrompt = "What inner strength goes with you wherever you are? How can you lean on it now?"
        ),

        // q476, Marcus Aurelius (afraid)
        "q476" to QuoteInsight(
            intro = "When the thought of death frightens you, Marcus Aurelius offers a gentle way of seeing it: as a mystery of nature, like birth itself.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "A Mystery Like Birth",
                    blockquote = "Death is such as generation is, a mystery of nature.",
                    body = "Marcus places death beside birth. Both are natural, both are beyond our full understanding, and both are part of how life moves. In the same note he describes it as a coming together and a coming apart of the same elements, nothing shameful and nothing against the order of things. This does not erase fear, and it is natural to feel it. But it may soften the sense that death is strange or wrong, rather than part of the mystery that brought you here."
                )
            ),
            modernApplication = "Sit for a moment with the mystery of being born, how you arrived without understanding how. Let that same wonder rest alongside your fear, without forcing the fear away.",
            closing = "Birth and death share the same quiet mystery.",
            reflectionPrompt = "What helps you feel held when you face the unknown? Where do you find a sense of wonder?"
        ),

        // q477, Epictetus (afraid)
        "q477" to QuoteInsight(
            intro = "When fear is building, Epictetus offers a clarifying distinction: what weighs on us most is often the fear itself, more than the thing feared.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "The Fear Behind the Fear",
                    blockquote = "Death or pain is not formidable, but the fear of pain or death.",
                    body = "Epictetus taught that we can be confident about things outside our control and careful about our own judgments. What is truly formidable, he said, is not pain or death but the fear of them. This is not to say pain does not hurt. It means that much of our distress comes from anticipation. Fear can be met and examined, and once you see it as fear, its grip can begin to loosen."
                )
            ),
            modernApplication = "Name your fear in one sentence, beginning: \"I am afraid that...\" Then say: \"This is fear speaking.\" Breathe slowly and notice that you are here, breathing, in this moment.",
            closing = "Seeing fear as fear begins to loosen it.",
            reflectionPrompt = "What is your fear telling you right now? How does it change when you name it as fear?"
        ),

        // q478, Epictetus (afraid)
        "q478" to QuoteInsight(
            intro = "When you are afraid of something ahead, Epictetus offers the example of Socrates: the best preparation is taking care of what is in your own power.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Prepared All Along",
                    blockquote = "Socrates said to one who was reminding him to prepare for his trial, Do you not think then that I have been preparing for it all my life? By what kind of preparation? I have maintained that which was in my own power.",
                    body = "Before his trial, Socrates was urged to prepare a defense. His answer was that he had been preparing his whole life, by keeping what was in his own power: his honesty and his choices. He did not try to control the outcome. He trusted the way he had lived. When fear rises about what is coming, you can ask the same: what is in my power right now? Caring for that is real preparation."
                )
            ),
            modernApplication = "Write down what is in your power about the thing you fear: your effort, your honesty, how you treat others. Choose one of these and tend to it today.",
            closing = "Tend what is yours, and you are already preparing.",
            reflectionPrompt = "What is in your power about what lies ahead? How have you already been preparing without knowing it?"
        ),

        // q479, Seneca (afraid)
        "q479" to QuoteInsight(
            intro = "When you fear pain, Seneca offers a reassuring thought to his friend Lucilius, who was ill: pain is either bearable or brief.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Endurable or Short",
                    blockquote = "No man can suffer both severely and for a long time; Nature, who loves us most tenderly, has so constituted us as to make pain either endurable or short.",
                    body = "Seneca wrote this to Lucilius, who was unwell, and he drew on his own years of poor health. He saw a kind of tenderness in the way we are made: pain that is severe tends not to last, and pain that lasts tends to ease enough to be borne. He was not dismissing suffering. He was offering a reason not to picture the worst stretching on forever. You can meet what is here, moment by moment, as it changes."
                )
            ),
            modernApplication = "If fear of pain is growing, focus on the next few minutes only. Say: \"I can meet this moment.\" When the moment passes, meet the next one the same way.",
            closing = "Nature, Seneca believed, holds us more tenderly than fear does.",
            reflectionPrompt = "What would it be like to face only the next few minutes? What helps you feel cared for right now?"
        ),

        // q480, Seneca (afraid)
        "q480" to QuoteInsight(
            intro = "When fear feels overwhelming, especially at night, Seneca offers a comforting truth: many things that terrify us in the dark look different in daylight.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Daylight on Night Fears",
                    blockquote = "Many a sight that is held a terror in the night-time, is turned to ridicule by day.",
                    body = "Seneca wrote this while reflecting on a line from Vergil about shapes that are dreadful to look upon. His point was that such shapes seem terrible but often are not, once we look at them steadily. Night has a way of enlarging fears, making them feel certain and close. In daylight, with rest and a clearer view, many of those same fears shrink. If it is dark for you right now, the morning may bring a different view."
                )
            ),
            modernApplication = "If fear is strong tonight, write it down and tell yourself: \"I will look at this again in the morning.\" Then do one calming thing, like dimming the screen or taking a slow breath.",
            closing = "Morning often shows fear its true size.",
            reflectionPrompt = "Which of your fears might look different in daylight? What could you set aside until morning?"
        ),

        // q481, Seneca (afraid)
        "q481" to QuoteInsight(
            intro = "When you are afraid of what lies ahead, Seneca offers a practical encouragement: we meet hardship with more courage when we have thought it through beforehand.",
            sections = listOf(
                InsightSection(
                    number = 1,
                    title = "Courage Through Preparation",
                    blockquote = "Everyone approaches courageously a danger which he has prepared himself to meet long before, and withstands even hardships if he has previously practiced how to meet them.",
                    body = "Seneca wrote this to Lucilius, who was upset after members of his household ran away. Seneca's advice was to look ahead calmly and think through difficulties before they arrive. This is not about dwelling on disaster. It is about rehearsing, gently, so that hard things are less unfamiliar. When you have pictured yourself meeting a challenge, you are steadier when it comes. Preparation turns fear into readiness."
                )
            ),
            modernApplication = "Picture the situation you fear, then picture yourself handling it calmly, step by step. Choose one small action that would make you more ready, and do it today.",
            closing = "What you have prepared for, you can face.",
            reflectionPrompt = "What would help you feel more prepared for what lies ahead? What is one step toward that today?"
        )
    )
}
