package tsarenko.ru.database

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

data class PollForm(
    @BsonId
    val id: Id<PollForm>? = null,
    val title: String,
    val date: String
)

fun PollForm.toDTO(): PollFormDTO {
    return PollFormDTO(
        title = this.title,
        date = this.date
    )
}


