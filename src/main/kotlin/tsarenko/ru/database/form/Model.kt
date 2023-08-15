package tsarenko.ru.database.form

import kotlinx.serialization.Serializable

@Serializable
data class Form(
    val title: String,
    val date: String,
    val content: List<Poll>
)

@Serializable
data class Poll(
    val question: String,
    val type: String,
    val answers: List<String>
)
