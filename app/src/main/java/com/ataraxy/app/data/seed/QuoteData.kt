package com.ataraxy.app.data.seed

import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.QuoteEntity

object AuthorData {
    val authors = listOf(
        AuthorEntity(
            id = "marcus_aurelius",
            name = "Marcus Aurelius",
            bio = "Roman Emperor from 161 to 180 AD and Stoic philosopher. His personal writings, compiled as the Meditations, remain one of the greatest works of philosophy.",
            era = "121–180 AD",
            school = "Stoicism"
        ),
        AuthorEntity(
            id = "epictetus",
            name = "Epictetus",
            bio = "Greek Stoic philosopher born into slavery. His teachings were compiled by his student Arrian into the Discourses and the Enchiridion.",
            era = "50–135 AD",
            school = "Stoicism"
        ),
        AuthorEntity(
            id = "seneca",
            name = "Seneca",
            bio = "Roman Stoic philosopher, statesman, and dramatist. Served as advisor to Emperor Nero. Known for his Letters to Lucilius and moral essays.",
            era = "4 BC–65 AD",
            school = "Stoicism"
        ),
        AuthorEntity(
            id = "cato",
            name = "Cato the Younger",
            bio = "Roman statesman and Stoic philosopher. Known for his moral integrity and his resistance to Caesar. Considered by many as the embodiment of Stoic virtue.",
            era = "95–46 BC",
            school = "Stoicism"
        )
    )
}

object QuoteData {
    val quotes = listOf(
        // ── WISDOM (dayOfYear 1–40) ──────────────────────────────────────────
        QuoteEntity("q001", "You have power over your mind — not outside events. Realize this, and you will find strength.", "marcus_aurelius", "Meditations", "WISDOM", 1),
        QuoteEntity("q002", "The impediment to action advances action. What stands in the way becomes the way.", "marcus_aurelius", "Meditations", "WISDOM", 2),
        QuoteEntity("q003", "Waste no more time arguing about what a good man should be. Be one.", "marcus_aurelius", "Meditations", "WISDOM", 3),
        QuoteEntity("q004", "Very little is needed to make a happy life; it is all within yourself, in your way of thinking.", "marcus_aurelius", "Meditations", "WISDOM", 4),
        QuoteEntity("q005", "If it is not right, do not do it; if it is not true, do not say it.", "marcus_aurelius", "Meditations", "WISDOM", 5),
        QuoteEntity("q006", "The first rule is to keep an untroubled spirit. The second is to look things in the face and know them for what they are.", "marcus_aurelius", "Meditations", "WISDOM", 6),
        QuoteEntity("q007", "Accept the things to which fate binds you, and love the people with whom fate brings you together.", "marcus_aurelius", "Meditations", "WISDOM", 7),
        QuoteEntity("q008", "Confine yourself to the present.", "marcus_aurelius", "Meditations", "WISDOM", 8),
        QuoteEntity("q009", "The best revenge is to be unlike him who performed the injustice.", "marcus_aurelius", "Meditations", "WISDOM", 9),
        QuoteEntity("q010", "It is not death that a man should fear, but he should fear never beginning to live.", "marcus_aurelius", "Meditations", "WISDOM", 10),
        QuoteEntity("q011", "Make the best use of what is in your power, and take the rest as it happens.", "epictetus", "Enchiridion", "WISDOM", 11),
        QuoteEntity("q012", "Seek not the good in external things; seek it in yourself.", "epictetus", "Discourses", "WISDOM", 12),
        QuoteEntity("q013", "First, say to yourself what you would be; and then do what you have to do.", "epictetus", "Discourses", "WISDOM", 13),
        QuoteEntity("q014", "It is impossible for a man to learn what he thinks he already knows.", "epictetus", "Discourses", "WISDOM", 14),
        QuoteEntity("q015", "Men are disturbed not by things, but by the opinions about things.", "epictetus", "Enchiridion", "WISDOM", 15),
        QuoteEntity("q016", "He is a wise man who does not grieve for the things which he has not, but rejoices for those which he has.", "epictetus", "Discourses", "WISDOM", 16),
        QuoteEntity("q017", "No man is free who is not master of himself.", "epictetus", "Discourses", "WISDOM", 17),
        QuoteEntity("q018", "Seek freedom and become captive of your desires. Seek discipline and find your liberty.", "epictetus", "Discourses", "WISDOM", 18),
        QuoteEntity("q019", "It's not what happens to you, but how you react to it that matters.", "epictetus", "Enchiridion", "WISDOM", 19),
        QuoteEntity("q020", "The key is to keep company only with people who uplift you, whose presence calls forth your best.", "epictetus", "Enchiridion", "WISDOM", 20),
        QuoteEntity("q021", "It is not the man who has too little, but the man who craves more, that is poor.", "seneca", "Letters to Lucilius", "WISDOM", 21),
        QuoteEntity("q022", "Begin at once to live, and count each separate day as a separate life.", "seneca", "Letters to Lucilius", "WISDOM", 22),
        QuoteEntity("q023", "Dum differtur vita transcurrit — While we are postponing, life speeds by.", "seneca", "Letters to Lucilius", "WISDOM", 23),
        QuoteEntity("q024", "We suffer more often in imagination than in reality.", "seneca", "Letters to Lucilius", "WISDOM", 24),
        QuoteEntity("q025", "The whole future lies in uncertainty: live immediately.", "seneca", "Letters to Lucilius", "WISDOM", 25),
        QuoteEntity("q026", "Nusquam est qui ubique est — He who is everywhere is nowhere.", "seneca", "Letters to Lucilius", "WISDOM", 26),
        QuoteEntity("q027", "Omnia aliena sunt, tempus tantum nostrum est — Everything is alien to us; time alone is ours.", "seneca", "Letters to Lucilius", "WISDOM", 27),
        QuoteEntity("q028", "True happiness is to enjoy the present, without anxious dependence upon the future.", "seneca", "On the Happy Life", "WISDOM", 28),
        QuoteEntity("q029", "He who has made a fair compact with poverty is rich.", "seneca", "Letters to Lucilius", "WISDOM", 29),
        QuoteEntity("q030", "The mind that is anxious about future events is miserable.", "seneca", "Letters to Lucilius", "WISDOM", 30),
        QuoteEntity("q031", "The time will come when diligent research over long periods will bring to light things which now lie hidden.", "seneca", "Natural Questions", "WISDOM", 31),
        QuoteEntity("q032", "I have learned to be a friend to myself.", "seneca", "Letters to Lucilius", "WISDOM", 32),
        QuoteEntity("q033", "The man who has anticipated the coming of troubles takes away their power when they arrive.", "seneca", "Letters to Lucilius", "WISDOM", 33),
        QuoteEntity("q034", "If you want to be a philosopher, prepare to be laughed at from the start.", "epictetus", "Discourses", "WISDOM", 34),
        QuoteEntity("q035", "A good character carries within it its own reward.", "marcus_aurelius", "Meditations", "WISDOM", 35),
        QuoteEntity("q036", "Think of yourself as dead. You have lived your life. Now take what's left and live it properly.", "marcus_aurelius", "Meditations", "WISDOM", 36),
        QuoteEntity("q037", "Never let the future disturb you. You will meet it, if you have to, with the same weapons of reason which today arm you against the present.", "marcus_aurelius", "Meditations", "WISDOM", 37),
        QuoteEntity("q038", "Everything we hear is an opinion, not a fact. Everything we see is a perspective, not the truth.", "marcus_aurelius", "Meditations", "WISDOM", 38),
        QuoteEntity("q039", "How much more grievous are the consequences of anger than the causes of it.", "marcus_aurelius", "Meditations", "WISDOM", 39),
        QuoteEntity("q040", "Look well into thyself; there is a source of strength which will always spring up if thou wilt always look.", "marcus_aurelius", "Meditations", "WISDOM", 40),

        // ── COURAGE (dayOfYear 41–80) ────────────────────────────────────────
        QuoteEntity("q041", "You could leave life right now. Let that determine what you do and say and think.", "marcus_aurelius", "Meditations", "COURAGE", 41),
        QuoteEntity("q042", "Perfection of character is this: to live each day as if it were your last, without frenzy, without apathy, without pretense.", "marcus_aurelius", "Meditations", "COURAGE", 42),
        QuoteEntity("q043", "Never be afraid of what you are about to do — a new experience is just around the corner.", "marcus_aurelius", "Meditations", "COURAGE", 43),
        QuoteEntity("q044", "The brave man is not he who does not feel afraid, but he who conquers that fear.", "epictetus", "Discourses", "COURAGE", 44),
        QuoteEntity("q045", "Difficulties are things that show a person what they are.", "epictetus", "Discourses", "COURAGE", 45),
        QuoteEntity("q046", "Nothing great is accomplished without danger.", "seneca", "Letters to Lucilius", "COURAGE", 46),
        QuoteEntity("q047", "Vivere militare est — To live is to fight.", "seneca", "Letters to Lucilius", "COURAGE", 47),
        QuoteEntity("q048", "It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.", "seneca", "Letters to Lucilius", "COURAGE", 48),
        QuoteEntity("q049", "He conquers who endures.", "seneca", "Letters to Lucilius", "COURAGE", 49),
        QuoteEntity("q050", "You must never confuse faith that you will prevail in the end with the discipline to confront the most brutal facts of your current reality.", "seneca", "Letters to Lucilius", "COURAGE", 50),
        QuoteEntity("q051", "Confront the dark parts of yourself, and work to banish them with illumination and forgiveness.", "epictetus", "Discourses", "COURAGE", 51),
        QuoteEntity("q052", "Endure and persist; this pain will turn to your good by and by.", "epictetus", "Enchiridion", "COURAGE", 52),
        QuoteEntity("q053", "Practice yourself, for heaven's sake, in little things; and thence proceed to greater.", "epictetus", "Discourses", "COURAGE", 53),
        QuoteEntity("q054", "If you are pained by any external thing, it is not this thing that disturbs you, but your own judgment about it. And it is in your power to wipe out that judgment now.", "marcus_aurelius", "Meditations", "COURAGE", 54),
        QuoteEntity("q055", "Our life is what our thoughts make it.", "marcus_aurelius", "Meditations", "COURAGE", 55),
        QuoteEntity("q056", "Forward, as occasion offers. Never look round to see whether any shall note it.", "marcus_aurelius", "Meditations", "COURAGE", 56),
        QuoteEntity("q057", "The object of life is not to be on the side of the majority, but to escape finding oneself in the ranks of the insane.", "marcus_aurelius", "Meditations", "COURAGE", 57),
        QuoteEntity("q058", "The man who fears death will never do anything worth of a man who is alive.", "seneca", "Letters to Lucilius", "COURAGE", 58),
        QuoteEntity("q059", "Omnia, Lucili, aliena sunt, tempus tantum nostrum est — All things, Lucilius, belong to others; time alone is ours.", "seneca", "Letters to Lucilius", "COURAGE", 59),
        QuoteEntity("q060", "If you want to improve, be content to be thought foolish and stupid.", "epictetus", "Enchiridion", "COURAGE", 60),
        QuoteEntity("q061", "Retire into yourself as much as you can.", "marcus_aurelius", "Meditations", "COURAGE", 61),
        QuoteEntity("q062", "He who does not know what the world is does not know where he is.", "marcus_aurelius", "Meditations", "COURAGE", 62),
        QuoteEntity("q063", "Act well your part, there all the honour lies.", "epictetus", "Enchiridion", "COURAGE", 63),
        QuoteEntity("q064", "There is nothing so well worth having as a friend who will boldly tell us our faults.", "seneca", "Letters to Lucilius", "COURAGE", 64),
        QuoteEntity("q065", "Let us prepare our minds as if we had come to the very end of life. Let us postpone nothing.", "seneca", "Letters to Lucilius", "COURAGE", 65),
        QuoteEntity("q066", "What progress, you ask, have I made? I have begun to be a friend to myself.", "seneca", "Letters to Lucilius", "COURAGE", 66),
        QuoteEntity("q067", "As long as you live, keep learning how to live.", "seneca", "Letters to Lucilius", "COURAGE", 67),
        QuoteEntity("q068", "The more we value things outside our control, the less control we have.", "epictetus", "Enchiridion", "COURAGE", 68),
        QuoteEntity("q069", "We cannot choose our external circumstances, but we can always choose how we respond to them.", "epictetus", "Discourses", "COURAGE", 69),
        QuoteEntity("q070", "Freedom is the only worthy goal in life. It is won by disregarding things that lie beyond our control.", "epictetus", "Discourses", "COURAGE", 70),
        QuoteEntity("q071", "Cato won every contest. He showed that a brave man can live under a tyrant and — which is harder — can die.", "seneca", "Letters to Lucilius", "COURAGE", 71),
        QuoteEntity("q072", "Let him who wants glory fight; I will sit quietly and rest my bones.", "cato", "Sayings", "COURAGE", 72),
        QuoteEntity("q073", "I would rather be first in a village than second in Rome.", "cato", "Sayings", "COURAGE", 73),
        QuoteEntity("q074", "He who has a why to live can bear almost any how.", "epictetus", "Discourses", "COURAGE", 74),
        QuoteEntity("q075", "You have been imposed upon by nobody, when the obstacles you meet are your own.", "epictetus", "Discourses", "COURAGE", 75),
        QuoteEntity("q076", "When you are offended at any man's fault, turn to yourself and study your own failings.", "epictetus", "Enchiridion", "COURAGE", 76),
        QuoteEntity("q077", "With everything which entices you and is of use to you, or which you love, remember to say to yourself what sort of a thing it is.", "epictetus", "Enchiridion", "COURAGE", 77),
        QuoteEntity("q078", "The good man orders his life as a whole. The bad man lives only from day to day.", "seneca", "Letters to Lucilius", "COURAGE", 78),
        QuoteEntity("q079", "Omnia, Lucili, aliena sunt — Everything, Lucilius, belongs to others.", "seneca", "Letters to Lucilius", "COURAGE", 79),
        QuoteEntity("q080", "Carry out some action every day that is of benefit to others.", "marcus_aurelius", "Meditations", "COURAGE", 80),

        // ── JUSTICE (dayOfYear 81–120) ───────────────────────────────────────
        QuoteEntity("q081", "Treat other people as ends in themselves, not as means to an end.", "marcus_aurelius", "Meditations", "JUSTICE", 81),
        QuoteEntity("q082", "When you wake up in the morning, tell yourself: The people I deal with today will be meddling, ungrateful, arrogant, dishonest, jealous, and surly.", "marcus_aurelius", "Meditations", "JUSTICE", 82),
        QuoteEntity("q083", "What harms the hive harms the bee.", "marcus_aurelius", "Meditations", "JUSTICE", 83),
        QuoteEntity("q084", "He who lives in harmony with himself lives in harmony with the universe.", "marcus_aurelius", "Meditations", "JUSTICE", 84),
        QuoteEntity("q085", "We are made for cooperation, like feet, like hands, like eyelids, like the rows of the upper and lower teeth.", "marcus_aurelius", "Meditations", "JUSTICE", 85),
        QuoteEntity("q086", "He who does not know what the world is does not know who he is.", "marcus_aurelius", "Meditations", "JUSTICE", 86),
        QuoteEntity("q087", "If it is not right, do not do it; if it is not true, do not say it.", "marcus_aurelius", "Meditations", "JUSTICE", 87),
        QuoteEntity("q088", "Do not indulge in anger or punishment more than is needful.", "marcus_aurelius", "Meditations", "JUSTICE", 88),
        QuoteEntity("q089", "Never value anything as profitable to yourself which will compel you to break your promise.", "marcus_aurelius", "Meditations", "JUSTICE", 89),
        QuoteEntity("q090", "He who offends you in some way is your superior in wisdom, inferior in vice.", "epictetus", "Discourses", "JUSTICE", 90),
        QuoteEntity("q091", "Know, first, who you are; and then adorn yourself accordingly.", "epictetus", "Discourses", "JUSTICE", 91),
        QuoteEntity("q092", "God hath entrusted me with myself.", "epictetus", "Discourses", "JUSTICE", 92),
        QuoteEntity("q093", "Never say of anything 'I have lost it'; but say 'I have returned it.'", "epictetus", "Enchiridion", "JUSTICE", 93),
        QuoteEntity("q094", "Seek not that the things which happen should happen as you wish; but wish the things which happen to be as they are, and you will have a tranquil flow of life.", "epictetus", "Enchiridion", "JUSTICE", 94),
        QuoteEntity("q095", "What wouldst thou be found doing when overtaken by death? I would have it be some work of humanity, of general utility.", "epictetus", "Discourses", "JUSTICE", 95),
        QuoteEntity("q096", "Regard your neighbour's good as your own good.", "seneca", "Letters to Lucilius", "JUSTICE", 96),
        QuoteEntity("q097", "We are all one body, to preserve the whole as you preserve the part.", "seneca", "Letters to Lucilius", "JUSTICE", 97),
        QuoteEntity("q098", "Nothing is more honorable than a grateful heart.", "seneca", "Letters to Lucilius", "JUSTICE", 98),
        QuoteEntity("q099", "Consider that everything is opinion, and opinion is in thy power.", "marcus_aurelius", "Meditations", "JUSTICE", 99),
        QuoteEntity("q100", "We are too much accustomed to attribute to a single cause that which is the product of several.", "marcus_aurelius", "Meditations", "JUSTICE", 100),
        QuoteEntity("q101", "Never esteem anything as of advantage to you that will make you break your word or lose your self-respect.", "marcus_aurelius", "Meditations", "JUSTICE", 101),
        QuoteEntity("q102", "Be tolerant with others and strict with yourself.", "marcus_aurelius", "Meditations", "JUSTICE", 102),
        QuoteEntity("q103", "To see a man fearless in dangers, untainted with lusts, happy in adversity, composed in a tumult — is not this a sight at which every Roman should rejoice?", "seneca", "Letters to Lucilius", "JUSTICE", 103),
        QuoteEntity("q104", "I shall do more because of your expectation than I could have done merely for my own sake.", "seneca", "Letters to Lucilius", "JUSTICE", 104),
        QuoteEntity("q105", "Men do not care how nobly they live, but only how long, although it is within the reach of every man to live nobly, but within no man's power to live long.", "seneca", "Letters to Lucilius", "JUSTICE", 105),
        QuoteEntity("q106", "The mind that is anxious about future events is miserable.", "seneca", "Letters to Lucilius", "JUSTICE", 106),
        QuoteEntity("q107", "Do not spoil what you have by desiring what you have not; remember that what you now have was once among the things you only hoped for.", "epictetus", "Enchiridion", "JUSTICE", 107),
        QuoteEntity("q108", "When someone is properly grounded in life, they shouldn't have to look outside themselves for approval.", "epictetus", "Discourses", "JUSTICE", 108),
        QuoteEntity("q109", "Nature has so created us that a certain tie unites us all.", "seneca", "Letters to Lucilius", "JUSTICE", 109),
        QuoteEntity("q110", "Cherish those who seek the truth, but beware of those who find it.", "epictetus", "Discourses", "JUSTICE", 110),
        QuoteEntity("q111", "Justice is the crowning glory of the virtues.", "cato", "Sayings", "JUSTICE", 111),
        QuoteEntity("q112", "The guilty catch their own guilt in their deeds.", "seneca", "Letters to Lucilius", "JUSTICE", 112),
        QuoteEntity("q113", "What is defeat? Nothing but education; nothing but the first step to something better.", "epictetus", "Discourses", "JUSTICE", 113),
        QuoteEntity("q114", "We learn not in the school but in life.", "seneca", "Letters to Lucilius", "JUSTICE", 114),
        QuoteEntity("q115", "Just as nature takes every obstacle, every impediment, and works around it — turns it to its purposes, incorporates it into itself — so, too, a rational being can turn each setback into raw material and use it to achieve its goals.", "marcus_aurelius", "Meditations", "JUSTICE", 115),
        QuoteEntity("q116", "That which is not good for the bee-hive cannot be good for the bees.", "marcus_aurelius", "Meditations", "JUSTICE", 116),
        QuoteEntity("q117", "The object of all virtue is peace of mind.", "seneca", "Letters to Lucilius", "JUSTICE", 117),
        QuoteEntity("q118", "To see clearly is poetry, prophecy, and religion all in one.", "epictetus", "Discourses", "JUSTICE", 118),
        QuoteEntity("q119", "Injustice never rules forever.", "seneca", "Medea", "JUSTICE", 119),
        QuoteEntity("q120", "You are a little soul carrying around a corpse. — But what a soul!", "epictetus", "Discourses", "JUSTICE", 120),

        // ── MODERATION (dayOfYear 121–160) ───────────────────────────────────
        QuoteEntity("q121", "If one does not know to which port one is sailing, no wind is favorable.", "seneca", "Letters to Lucilius", "MODERATION", 121),
        QuoteEntity("q122", "Receive without pride, relinquish without struggle.", "marcus_aurelius", "Meditations", "MODERATION", 122),
        QuoteEntity("q123", "Wealth is the slave of a wise man. The master of a fool.", "seneca", "Letters to Lucilius", "MODERATION", 123),
        QuoteEntity("q124", "He is richest who is content with the least, for contentment is the wealth of nature.", "seneca", "Letters to Lucilius", "MODERATION", 124),
        QuoteEntity("q125", "Omnia, Lucili, aliena sunt — Everything is alien to us; time alone is ours.", "seneca", "Letters to Lucilius", "MODERATION", 125),
        QuoteEntity("q126", "Simplify, simplify.", "marcus_aurelius", "Meditations", "MODERATION", 126),
        QuoteEntity("q127", "We must make the best of those things that are in our power, and take the rest as nature gives it.", "epictetus", "Discourses", "MODERATION", 127),
        QuoteEntity("q128", "He has the most who is most content with the least.", "epictetus", "Discourses", "MODERATION", 128),
        QuoteEntity("q129", "The secret of happiness, you see, is not found in seeking more, but in developing the capacity to enjoy less.", "epictetus", "Discourses", "MODERATION", 129),
        QuoteEntity("q130", "Eat to live, not live to eat.", "epictetus", "Discourses", "MODERATION", 130),
        QuoteEntity("q131", "Be content to seem what you really are.", "marcus_aurelius", "Meditations", "MODERATION", 131),
        QuoteEntity("q132", "Do not indulge in speech that consumes without nourishing.", "marcus_aurelius", "Meditations", "MODERATION", 132),
        QuoteEntity("q133", "It is enough if each man thinks himself poor only in respect of time.", "seneca", "Letters to Lucilius", "MODERATION", 133),
        QuoteEntity("q134", "Live as if you were to die tomorrow. Learn as if you were to live forever.", "seneca", "Letters to Lucilius", "MODERATION", 134),
        QuoteEntity("q135", "Every addition to true knowledge is an addition to human power.", "seneca", "Natural Questions", "MODERATION", 135),
        QuoteEntity("q136", "Retire from the world and live with yourself.", "seneca", "Letters to Lucilius", "MODERATION", 136),
        QuoteEntity("q137", "Omnia aliena sunt — All things are alien to us.", "seneca", "Letters to Lucilius", "MODERATION", 137),
        QuoteEntity("q138", "Consider at what price you sell your integrity.", "epictetus", "Enchiridion", "MODERATION", 138),
        QuoteEntity("q139", "He who is not satisfied with a little is satisfied with nothing.", "epictetus", "Discourses", "MODERATION", 139),
        QuoteEntity("q140", "Moderation is the highest virtue.", "cato", "Sayings", "MODERATION", 140),
        QuoteEntity("q141", "It is never too late to be what you might have been.", "seneca", "Letters to Lucilius", "MODERATION", 141),
        QuoteEntity("q142", "Better to trip with the feet than with the tongue.", "epictetus", "Enchiridion", "MODERATION", 142),
        QuoteEntity("q143", "Difficulties strengthen the mind, as labor does the body.", "seneca", "Letters to Lucilius", "MODERATION", 143),
        QuoteEntity("q144", "We are lazier in mind than in body.", "seneca", "Letters to Lucilius", "MODERATION", 144),
        QuoteEntity("q145", "If you wish to be a writer, write.", "epictetus", "Discourses", "MODERATION", 145),
        QuoteEntity("q146", "The greatest thing is the small thing done well.", "marcus_aurelius", "Meditations", "MODERATION", 146),
        QuoteEntity("q147", "Restraint in all things is a greater virtue than brilliance in any one thing.", "cato", "Sayings", "MODERATION", 147),
        QuoteEntity("q148", "The frugal man, though hungry, does not ask for more than what is fitting.", "cato", "Sayings", "MODERATION", 148),
        QuoteEntity("q149", "In moderation keeping the middle way is the foundation of wisdom.", "epictetus", "Discourses", "MODERATION", 149),
        QuoteEntity("q150", "Let not your mind run on what you lack as much as on what you have already.", "marcus_aurelius", "Meditations", "MODERATION", 150),

        // ── Additional archive-only quotes (dayOfYear = null) ────────────────
        QuoteEntity("q151", "Do not go where the path may lead; go instead where there is no path and leave a trail.", "marcus_aurelius", "Meditations", "WISDOM", null),
        QuoteEntity("q152", "The day is lost on which one has not laughed.", "seneca", "Letters to Lucilius", "WISDOM", null),
        QuoteEntity("q153", "Neither seek nor shun tasks; but bear whatever comes with grace.", "epictetus", "Discourses", "WISDOM", null),
        QuoteEntity("q154", "What need is there to weep over parts of life? The whole of it calls for tears.", "seneca", "Letters to Lucilius", "WISDOM", null),
        QuoteEntity("q155", "Time heals what reason cannot.", "seneca", "Agamemnon", "WISDOM", null),
        QuoteEntity("q156", "Choose your companion carefully; the man who associates with the wretched soon learns their habits.", "cato", "Sayings", "COURAGE", null),
        QuoteEntity("q157", "Bold in counsel, brave in action, steadfast in resolution — these three make the perfect citizen.", "cato", "Sayings", "COURAGE", null),
        QuoteEntity("q158", "Do not trust him who once has been perfidious.", "seneca", "Phaedra", "JUSTICE", null),
        QuoteEntity("q159", "Virtue is its own reward.", "seneca", "Epistles", "JUSTICE", null),
        QuoteEntity("q160", "There is nothing permanent except change. But virtue abides.", "marcus_aurelius", "Meditations", "MODERATION", null),
        QuoteEntity("q161", "Begin with the end in mind. The sage imagines his death to order his life.", "seneca", "Letters to Lucilius", "MODERATION", null),
        QuoteEntity("q162", "He who dreads toil has already lost.", "epictetus", "Discourses", "COURAGE", null),
        QuoteEntity("q163", "Take heed of the quality, not the quantity, of your friends.", "epictetus", "Enchiridion", "WISDOM", null),
        QuoteEntity("q164", "I am not born for one corner; the whole world is my native land.", "seneca", "Letters to Lucilius", "JUSTICE", null),
        QuoteEntity("q165", "To be everywhere is to be nowhere.", "seneca", "Letters to Lucilius", "MODERATION", null),

        // ── EMERGENCY (SOS) QUOTES — feeling-tagged, no dayOfYear ─────────────
        // OVERWHELMED
        QuoteEntity("q300", "Confine yourself to the present.", "marcus_aurelius", "Meditations", "WISDOM", null, "OVERWHELMED"),
        QuoteEntity("q301", "The greatest remedy for anger is delay.", "seneca", "On Anger", "MODERATION", null, "OVERWHELMED"),

        // PROCRASTINATING
        QuoteEntity("q302", "How long are you going to wait before you demand the best for yourself?", "epictetus", "Discourses", "COURAGE", null, "PROCRASTINATING"),
        QuoteEntity("q303", "Let us postpone nothing.", "seneca", "Letters to Lucilius", "COURAGE", null, "PROCRASTINATING"),

        // STUCK
        QuoteEntity("q304", "If you are distressed by anything external, the pain is not due to the thing itself, but to your estimate of it.", "marcus_aurelius", "Meditations", "WISDOM", null, "STUCK"),
        QuoteEntity("q305", "First say to yourself what you would be; and then do what you have to do.", "epictetus", "Discourses", "COURAGE", null, "STUCK"),

        // HELPLESS
        QuoteEntity("q306", "You have power over your mind, not outside events. Realize this, and you will find strength.", "marcus_aurelius", "Meditations", "WISDOM", null, "HELPLESS"),
        QuoteEntity("q307", "No man is free who is not master of himself.", "epictetus", "Discourses", "MODERATION", null, "HELPLESS"),

        // INSECURE
        QuoteEntity("q308", "Waste no more time arguing what a good man should be. Be one.", "marcus_aurelius", "Meditations", "JUSTICE", null, "INSECURE"),
        QuoteEntity("q309", "Begin at once to live, and count each separate day as a separate life.", "seneca", "Letters to Lucilius", "WISDOM", null, "INSECURE"),

        // ASHAMED
        QuoteEntity("q310", "The soul becomes dyed with the color of its thoughts.", "marcus_aurelius", "Meditations", "WISDOM", null, "ASHAMED"),
        QuoteEntity("q311", "Every new beginning comes from some other beginning's end.", "seneca", "Letters to Lucilius", "COURAGE", null, "ASHAMED"),

        // GUILTY
        QuoteEntity("q312", "When you make a mistake, correct yourself quickly and move on.", "marcus_aurelius", "Meditations", "WISDOM", null, "GUILTY"),
        QuoteEntity("q313", "A fault confessed is half redressed.", "seneca", "Moral Letters", "JUSTICE", null, "GUILTY"),

        // LONELY
        QuoteEntity("q314", "Nowhere can man find a quieter or more untroubled retreat than in his own soul.", "marcus_aurelius", "Meditations", "MODERATION", null, "LONELY"),
        QuoteEntity("q315", "Associate with people who are likely to improve you.", "seneca", "Letters to Lucilius", "JUSTICE", null, "LONELY"),

        // REJECTED
        QuoteEntity("q316", "Choose not to be harmed and you will not feel harmed.", "marcus_aurelius", "Meditations", "WISDOM", null, "REJECTED"),
        QuoteEntity("q317", "He who is brave is free.", "seneca", "Letters to Lucilius", "COURAGE", null, "REJECTED"),

        // DISCOURAGED
        QuoteEntity("q318", "You could leave life right now. Let that determine what you do and say and think.", "marcus_aurelius", "Meditations", "COURAGE", null, "DISCOURAGED"),
        QuoteEntity("q319", "Difficulties strengthen the mind, as labor does the body.", "seneca", "Letters to Lucilius", "COURAGE", null, "DISCOURAGED"),

        // RESENTFUL
        QuoteEntity("q320", "The best revenge is to be unlike him who performed the injustice.", "marcus_aurelius", "Meditations", "JUSTICE", null, "RESENTFUL"),
        QuoteEntity("q321", "He who angers you conquers you.", "epictetus", "Enchiridion", "WISDOM", null, "RESENTFUL"),

        // TREATED_UNFAIRLY
        QuoteEntity("q322", "When you are offended at any man's fault, turn to yourself and study your own failings.", "epictetus", "Discourses", "WISDOM", null, "TREATED_UNFAIRLY"),
        QuoteEntity("q323", "What injures the hive injures the bee.", "marcus_aurelius", "Meditations", "JUSTICE", null, "TREATED_UNFAIRLY"),

        // BURNED_OUT
        QuoteEntity("q324", "Do less, but do it better.", "marcus_aurelius", "Meditations", "MODERATION", null, "BURNED_OUT"),
        QuoteEntity("q325", "To be everywhere is to be nowhere.", "seneca", "Letters to Lucilius", "MODERATION", null, "BURNED_OUT"),

        // NUMB
        QuoteEntity("q326", "It is not things that disturb us, but our judgments about things.", "epictetus", "Enchiridion", "WISDOM", null, "NUMB"),
        QuoteEntity("q327", "Return to yourself constantly.", "marcus_aurelius", "Meditations", "MODERATION", null, "NUMB"),

        // RESTLESS
        QuoteEntity("q328", "The happiness of your life depends upon the quality of your thoughts.", "marcus_aurelius", "Meditations", "WISDOM", null, "RESTLESS"),
        QuoteEntity("q329", "True happiness is to enjoy the present without anxious dependence upon the future.", "seneca", "On the Happy Life", "MODERATION", null, "RESTLESS"),

        // CONFUSED
        QuoteEntity("q330", "If it is not right, do not do it; if it is not true, do not say it.", "marcus_aurelius", "Meditations", "WISDOM", null, "CONFUSED"),
        QuoteEntity("q331", "First learn the meaning of what you say, and then speak.", "epictetus", "Discourses", "WISDOM", null, "CONFUSED"),

        // REGRETFUL
        QuoteEntity("q332", "Do not be ashamed of needing help.", "marcus_aurelius", "Meditations", "COURAGE", null, "REGRETFUL"),
        QuoteEntity("q333", "While we are postponing, life speeds by.", "seneca", "Letters to Lucilius", "WISDOM", null, "REGRETFUL"),

        // JEALOUS_ENVIOUS
        QuoteEntity("q334", "Wealth consists not in having great possessions, but in having few wants.", "epictetus", "Discourses", "MODERATION", null, "JEALOUS_ENVIOUS"),
        QuoteEntity("q335", "No one can lose either the past or the future; for how can one lose what one does not have?", "marcus_aurelius", "Meditations", "WISDOM", null, "JEALOUS_ENVIOUS"),

        // UNMOTIVATED
        QuoteEntity("q336", "At dawn, when you have trouble getting out of bed, tell yourself: I have to go to work as a human being.", "marcus_aurelius", "Meditations", "COURAGE", null, "UNMOTIVATED"),
        QuoteEntity("q337", "He who dreads toil has already lost.", "epictetus", "Discourses", "COURAGE", null, "UNMOTIVATED"),

        // HOPELESS
        QuoteEntity("q338", "Never let the future disturb you. You will meet it with the same weapons of reason that arm you today.", "marcus_aurelius", "Meditations", "COURAGE", null, "HOPELESS"),
        QuoteEntity("q339", "Begin at once to live.", "seneca", "Letters to Lucilius", "COURAGE", null, "HOPELESS")
    )
}
