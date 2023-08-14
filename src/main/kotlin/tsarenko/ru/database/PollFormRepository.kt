package tsarenko.ru.database

import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.id.toId

class PollFormRepository {
    private val client = KMongo.createClient()
    private val database = client.getDatabase("polls")
    private val pollCollection = database.getCollection<PollForm>()

    fun findAll(): List<PollForm> = pollCollection.find().toList()

    fun findById(id: String): PollForm? {
        val bsonId: Id<PollForm> = ObjectId(id).toId()
        return pollCollection.findOneById(bsonId)
    }
}