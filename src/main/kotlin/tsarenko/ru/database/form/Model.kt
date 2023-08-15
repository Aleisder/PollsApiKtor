package tsarenko.ru.database.form

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Form(
    @BsonId
    val id: String? = null,
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