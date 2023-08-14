package tsarenko.ru.database

import kotlinx.serialization.Serializable

@Serializable
data class PollFormDTO(
    val id: String? = null,
    val title: String,
    val date: String
)

fun PollFormDTO.toPollForm(): PollForm {
    return PollForm(
        title = this.title,
        date = this.date
    )
}
