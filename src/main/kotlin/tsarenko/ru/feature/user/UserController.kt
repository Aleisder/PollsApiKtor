package tsarenko.ru.feature.user

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import tsarenko.ru.database.user.UserDTO
import tsarenko.ru.database.user.UserService
import tsarenko.ru.exception.ErrorBody

class UserController(private val call: ApplicationCall) {

    private val UserService = UserService()

    suspend fun addNewUser(userDTO: UserDTO) {
        val id = UserService.addUser(userDTO)
        call.respond(HttpStatusCode.OK, id)
    }

    suspend fun getUserById(id: String) {
        val user = UserService.getUser(id)

        if (user == null)
            call.respond(
                HttpStatusCode.NotFound,
                ErrorBody(
                    httpCode = HttpStatusCode.NotFound.value,
                    request = call.request.path(),
                    error = "There is no user with id $id"
                )
            )
        else
            call.respond(HttpStatusCode.OK, user)
    }
}