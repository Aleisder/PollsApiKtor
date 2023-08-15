package tsarenko.ru.database

import kotlinx.serialization.Serializable

@Serializable
data class Poll(
    val question: String,
    val type: String,
    val answers: List<String>
)
