package com.ataraxy.app.data.seed

import com.ataraxy.app.domain.model.AuthorProfile
import com.ataraxy.app.domain.model.AuthorWork

object AuthorDetailData {

    val profiles: Map<String, AuthorProfile> = mapOf(

        "marcus_aurelius" to AuthorProfile(
            id = "marcus_aurelius",
            name = "Marcus Aurelius",
            era = "121–180 AD",
            bio = "Marcus Aurelius was born in Rome in 121 AD into a prominent family with connections to the imperial court. He did not expect to become Emperor. At age seventeen, he was adopted by the reigning Emperor Antoninus Pius — along with Lucius Verus — and spent the next twenty-three years being educated and prepared to rule the Roman Empire.\n\nHe became Emperor in 161 AD and ruled for nineteen years, overseeing one of the largest and most complex states in the ancient world. His reign was marked by continuous military crises on the frontiers — Germanic tribes in the north, the Parthian Empire in the east — as well as the Antonine Plague, which killed millions across the empire. He spent much of his reign on campaign, living under military conditions far removed from Rome.\n\nDespite, or perhaps because of, the weight of his position, Marcus turned to Stoic philosophy as a personal discipline. He studied under several teachers, including the Stoic philosopher Junius Rusticus, who introduced him to the works of Epictetus. Philosophy was not a public enterprise for Marcus — it was a private practice.\n\nThe Meditations was written for no one but himself. In notebooks, probably during military campaigns, he recorded reminders, reframings, and exhortations — not polished essays but rough working notes in the ongoing project of becoming a better person. He holds himself to account on every page. There is no vanity in the text; only someone who believed daily self-examination was necessary to remain human.\n\nHe is considered one of the rare heads of state who genuinely tried to live according to his stated values. He was faulted by some historians for failing to stop the rise of his son Commodus, who proved to be a disastrous emperor. But his own reign is widely regarded as a period of stable, humane governance at the height of Rome's power.",
            works = listOf(
                AuthorWork(
                    title = "Meditations",
                    type = "Personal Journal",
                    description = "Written in Greek and titled Ta eis heauton — \"To Himself\" — the Meditations is a private philosophical notebook, never intended for publication. It was discovered and circulated after Marcus's death.\n\nThe text has no formal structure. It is a series of numbered reflections, some only a sentence long, others running several paragraphs. Marcus uses it to argue with himself, to remind himself of principles he already knows but struggles to embody, and to reframe events that disturb him.\n\nThere is no performance in it. He berates himself for wasting time, for being too easily unsettled, for failing to act with the equanimity he preaches. The reader gets access to the inner life of a man with virtually unlimited external power who was genuinely uncertain whether he was living well.\n\nIt is read today because its questions — about distraction, anger, mortality, other people's behaviour — have not changed."
                )
            )
        ),

        "seneca" to AuthorProfile(
            id = "seneca",
            name = "Seneca",
            era = "4 BC–65 AD",
            bio = "Lucius Annaeus Seneca was born in Córdoba, Spain around 4 BC and brought to Rome as a child. He trained as an orator and philosopher and became one of Rome's most celebrated writers. His career, however, was defined by constant proximity to power — and to danger.\n\nHe was exiled to Corsica for eight years under Emperor Claudius on a charge of adultery with the Emperor's niece. Whether the charge was political or genuine is debated. He spent the years in Corsica writing and studying. When recalled to Rome, he was appointed tutor to the young Nero and later became one of the most powerful figures in the empire, functioning effectively as a senior advisor and co-administrator during Nero's early reign.\n\nHis position became increasingly precarious as Nero's behaviour grew erratic and violent. In 65 AD, Seneca was implicated in the Pisonian conspiracy — a plot to assassinate Nero. Whether he was actually involved is unknown. Nero ordered him to take his own life.\n\nSeneca's death was a Stoic performance. He opened his veins calmly, dictated to secretaries, and reportedly stated that he was leaving the pattern of his life as his legacy. He died slowly, and with apparent equanimity — the death he had described, theoretically, many times in his writing.\n\nHis legacy is genuinely complicated by the contradiction between his philosophy and his life. He preached simplicity and independence from wealth while accumulating one of the largest fortunes in Rome. He addressed this directly in his writing, without entirely resolving it. Some readers find the honesty refreshing; others find it damning. Either way, his prose remains some of the most direct and human philosophical writing in the ancient world.",
            works = listOf(
                AuthorWork(
                    title = "Letters to Lucilius",
                    type = "Personal Letters",
                    description = "One hundred and twenty-four letters written to his friend Gaius Lucilius in the final years of Seneca's life. They are the most personal and readable of the Stoic texts — part philosophical instruction, part personal correspondence, part confession.\n\nSeneca addresses practical questions: how to handle illness, how to manage time, how to face death, how to resist the pull of crowd opinion. He moves easily between abstract principle and daily annoyance. He is frequently funny. He quotes Epicurus alongside Stoic thought without apology.\n\nThe letters give the impression of a man working through his own questions in real time — not a completed philosophical system, but an active, sometimes contradictory process of trying to live carefully. They remain among the most widely read Stoic texts."
                ),
                AuthorWork(
                    title = "On the Shortness of Life",
                    type = "Essay",
                    description = "Seneca's most famous essay, addressed to his father-in-law Paulinus. The central argument: life is not short. We simply waste most of it on distraction, ambition, and busyness that serves other people's purposes rather than our own.\n\nHe draws a sharp distinction between living and merely existing — between people who are present in their lives and those who drift through them in an agitated blur. The essay is an intervention, addressed to a man trapped in administrative duties, but clearly aimed at a broader audience."
                ),
                AuthorWork(
                    title = "On the Happy Life",
                    type = "Essay",
                    description = "Written partly in response to critics who noted the gap between Seneca's philosophical teachings and his enormous personal wealth. He defends the Stoic position that virtue — not pleasure, not wealth — is the foundation of a good life, while acknowledging the difficulty of living that principle consistently.\n\nThe essay is unusually candid. Seneca does not claim to have solved the problem. He argues that philosophical progress, even imperfect, is better than no engagement with the question at all."
                ),
                AuthorWork(
                    title = "On Tranquility of Mind",
                    type = "Dialogue",
                    description = "A philosophical dialogue between Seneca and his friend Serenus, who describes a kind of restless dissatisfaction — neither fully engaged nor fully at peace. Seneca addresses the condition systematically: its causes, its remedies, and the practical measures a person can take to find stability.\n\nThe diagnosis of Serenus feels strikingly modern. The treatment Seneca prescribes involves reducing external commitments, cultivating inner quietness, and accepting that occasional difficulty is not a sign of failure."
                ),
                AuthorWork(
                    title = "Natural Questions",
                    type = "Scientific Essays",
                    description = "A series of scientific and philosophical reflections on natural phenomena: weather, earthquakes, rivers, comets, and the nature of the cosmos. Less read than his moral essays, but revealing of the full range of Seneca's curiosity.\n\nThroughout the scientific observations, Seneca returns to philosophical questions — particularly about humanity's place in a vast and largely indifferent universe, and what that perspective should do to our sense of our own importance."
                )
            )
        ),

        "epictetus" to AuthorProfile(
            id = "epictetus",
            name = "Epictetus",
            era = "50–135 AD",
            bio = "Epictetus was born a slave in Hierapolis, a city in what is now western Turkey. His name means simply \"acquired\" — a name given, not chosen. He was owned by Epaphroditus, one of Emperor Nero's personal secretaries.\n\nThe most striking story from his life concerns his leg. According to the philosopher Celsus, Epaphroditus once twisted Epictetus's leg to demonstrate that a Stoic would not cry out in pain. Epictetus reportedly said, calmly: \"You are going to break it.\" When the leg snapped, he said: \"Did I not tell you so?\" He walked with a limp for the rest of his life.\n\nWhether the story is precisely true is uncertain. What is clear is that Epictetus studied Stoic philosophy while enslaved — under the Stoic teacher Musonius Rufus — and was eventually freed, probably after Nero's death. He went on to found a school of philosophy in Nicopolis, a city in northwestern Greece, where he taught openly for decades.\n\nHe wrote nothing himself. His student Arrian — who later became a historian and governor — attended his lectures and transcribed them, producing what we now have of Epictetus's thought. Two major works survive: the Discourses and the shorter Enchiridion.\n\nEpictetus represents a version of Stoicism tested by extreme conditions. He had no wealth, no power, no freedom for large portions of his life. His teaching on the dichotomy of control — the foundational Stoic idea that some things are within our power and some are not — comes from someone for whom this was not an abstract philosophical observation but a daily survival strategy. His school attracted students from across the empire, including, it is believed, the young Marcus Aurelius through Junius Rusticus.",
            works = listOf(
                AuthorWork(
                    title = "Discourses",
                    type = "Transcribed Lectures",
                    description = "Arrian attended Epictetus's lectures and wrote them down in eight books, of which four survive. The Discourses are the closest thing to Epictetus speaking directly — conversational, sometimes demanding, frequently blunt.\n\nHe does not flatter his students. He challenges them to ask whether they have actually changed, or merely learned to talk about philosophy. The discussions cover practical life questions: how to handle insults, how to behave toward family, how to deal with illness and death, how to maintain integrity in a corrupt system.\n\nThe Discourses are longer and more discursive than the Enchiridion. They capture the texture of a philosophical education — circling back to the same ideas from different angles, pushing students to apply principles rather than simply understand them."
                ),
                AuthorWork(
                    title = "Enchiridion",
                    type = "Handbook",
                    description = "Compiled by Arrian as a short summary of Epictetus's core teachings, the Enchiridion — meaning \"handbook\" or \"that which is held in the hand\" — was designed as a portable reference.\n\nIt opens with what is perhaps the most direct statement of Stoic philosophy ever written: \"Some things are in our control and others not.\" Everything in the text follows from this premise.\n\nThe Enchiridion has been one of the most continuously read philosophical texts in Western history. It was used as a training manual by generals and monks alike. It influenced the development of Christian monasticism and later cognitive behavioural therapy, which shares its core premise that disturbance comes not from events but from our judgements about them."
                )
            )
        ),

        "cato" to AuthorProfile(
            id = "cato",
            name = "Cato the Younger",
            era = "95–46 BC",
            bio = "Marcus Porcius Cato — called the Younger to distinguish him from his famous great-great-grandfather Cato the Elder — was born in 95 BC. He became the Roman Republic's most formidable moral voice and one of its most stubborn political actors.\n\nCato served as a military officer, a treasury official known for his incorruptibility, and eventually a senator. He was famous throughout Rome for two things: his absolute refusal to compromise on matters of principle, and his personal austerity — he wore simple clothes, walked rather than rode, and ate plainly, regardless of his wealth or status.\n\nHis political career was dominated by opposition to Julius Caesar. Cato saw in Caesar the destruction of the Republic — a man using military success and popular appeal to accumulate power that no individual should hold. Their conflict ran for two decades and defined Roman politics. Every political manoeuvre Cato made was directed, in some way, at containing Caesar.\n\nWhen Caesar crossed the Rubicon in 49 BC and civil war began, Cato fought with the Pompeian forces. After their defeat at Pharsalus in 48 BC, and then again at Thapsus in 46 BC, the Republican cause was lost. Cato withdrew to Utica in North Africa.\n\nHe spent his final evening in conversation with friends, arranged the escape of Republican soldiers, and retired to read Plato's Phaedo — the dialogue on the soul's immortality. In the night he stabbed himself. His physician found him and stitched the wound. Cato removed the stitches and died.\n\nCaesar, upon hearing the news, reportedly said: \"Cato, I grudge you your death, as you would have grudged me your pardon.\" The statement became famous because it acknowledged what Cato understood: that refusing to be pardoned was itself a political act, a final refusal to accept Caesar's authority to decide who deserved forgiveness.\n\nCato wrote nothing that survives. He became, in his death, what he could not be in any text — a philosophical argument. Later Stoics, particularly Seneca, cite him constantly as the supreme example of the Stoic life lived without compromise.",
            works = listOf(
                AuthorWork(
                    title = "No Surviving Texts",
                    type = "Historical Record",
                    description = "Cato left no philosophical writings. What survives of him comes through Plutarch's biography, Cicero's letters and speeches — in which Cato appears frequently — and the accounts of later historians.\n\nSeneca references Cato more than any other figure in his letters. For Seneca, Cato was the proof that Stoic philosophy was not merely theoretical: a real person, living within recent memory, had actually done it — had held to virtue absolutely, under the most extreme pressure, and died rather than compromise.\n\nIn this sense Cato's philosophy is his life. His actions were his argument. The Stoics who came after him treated his biography as a philosophical text."
                )
            )
        )
    )
}
