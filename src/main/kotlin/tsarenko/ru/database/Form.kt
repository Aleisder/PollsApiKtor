package tsarenko.ru.database

import kotlinx.serialization.Serializable

@Serializable
data class Form(
    val title: String,
    val date: String,
    val content: List<Poll>
)

