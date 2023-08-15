package tsarenko.ru.database

import org.litote.kmongo.*
import org.bson.types.ObjectId
import org.litote.kmongo.id.toId

class FormRepository {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("polls")
    private val pollCollection = database.getCollection<Form>("pol")

    fun findAll(): List<Form> = pollCollection.find().toList()

    fun findById(id: String): Form? {
        val bsonId: Id<Form> = ObjectId(id).toId()
        return pollCollection.findOneById(bsonId)
    }
}