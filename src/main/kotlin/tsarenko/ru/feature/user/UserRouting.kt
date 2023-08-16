package tsarenko.ru.feature.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import tsarenko.ru.database.user.UserDTO

fun Application.configureUserRouting(){
    routing {
        route("/user") {

            get("/{id}") {
                val id = call.parameters["id"]!!
                UserController(call).getUserById(id)
            }

            post {
                val userDTO = call.receive<UserDTO>()
                UserController(call).addNewUser(userDTO)
            }
        }

    }
}