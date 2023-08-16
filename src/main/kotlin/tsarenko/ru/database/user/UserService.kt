package tsarenko.ru.database.user

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction


class UserService {

    object User : Table("user") {

        private val id = integer("id").autoIncrement()
        private val email = varchar("email", 25)
        private val name = varchar("name", 25)
        private val photo = varchar("photo", 50)

        private suspend fun <T> dbQuery(block: suspend () -> T): T {
            return newSuspendedTransaction(Dispatchers.IO) {
                block()
            }
        }

        suspend fun create(userDTO: UserDTO): Int = dbQuery {
            User.insert {
                it[name] = userDTO.name
                it[email] = userDTO.email
                it[photo] = userDTO.photo
            }[id]
        }

        suspend fun fetch(id: Int): UserDTO? = dbQuery {
            User
                .select { User.id eq id }
                .map(::resultRowToUser)
                .singleOrNull()
        }

        private fun resultRowToUser(row: ResultRow) = UserDTO(
            email = row[email],
            name = row[name],
            photo = row[photo]
        )
    }

    suspend fun getUser(id: String) = User.fetch(id.toInt())
    suspend fun addUser(userDTO: UserDTO) = User.create(userDTO)
}


