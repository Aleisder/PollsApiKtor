package tsarenko.ru.database.form

import org.litote.kmongo.*

class FormRepository {

    private val collection = KMongo
        .createClient()
        .getDatabase("polls")
        .getCollection("pol", Form::class.java)

    fun findAll(): List<Form> = collection.find().toList()

    fun findById(bsonId: Id<Form>): Form? {
        return collection.findOneById(bsonId)
    }

    fun deleteById(bsonId: Id<Form>): Boolean {
        return collection.deleteOneById(bsonId).wasAcknowledged()
    }
}