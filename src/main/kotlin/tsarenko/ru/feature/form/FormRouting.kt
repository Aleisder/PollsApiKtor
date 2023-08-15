package tsarenko.ru.feature.form

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import tsarenko.ru.database.Form
import tsarenko.ru.database.FormRepository
import tsarenko.ru.exception.ErrorBody
import tsarenko.ru.exception.ErrorType

fun Application.configureFormRouting() {

    val service = FormRepository()

    routing() {
        get("/poll/{id}") {
            val id = call.parameters["id"].toString()

            if (id.length != 24) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorBody.Builder()
                        .setId(id)
                        .setErrorType(ErrorType.INVALID_ID)
                        .build()
                )
            }

            val poll: Form? = service.findById(id)

            if (poll == null)
                call.respond(
                    HttpStatusCode.NotFound,
                    ErrorBody.Builder()
                        .setId(id)
                        .setErrorType(ErrorType.OBJECT_NOT_FOUND)
                        .build()
                )
            else
                call.respond(HttpStatusCode.OK, poll)
            return@get
        }
    }
}