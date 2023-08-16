package tsarenko.ru.database.user

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val email: String,
    val name: String,
    val photo: String
)
