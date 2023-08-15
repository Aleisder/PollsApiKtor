package tsarenko.ru.util

import org.bson.types.ObjectId
import org.litote.kmongo.id.toId
import tsarenko.ru.database.form.Form

fun String.toMongoId() = ObjectId(this).toId<Form>()