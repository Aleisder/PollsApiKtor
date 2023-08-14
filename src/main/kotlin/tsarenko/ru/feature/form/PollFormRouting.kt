package tsarenko.ru.feature.form

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import tsarenko.ru.database.PollFormRepository
import tsarenko.ru.database.toDTO

fun Application.configurePollFormRouting() {

    val service = PollFormRepository()

    routing {
        get("/poll/{id}") {
            val id = call.parameters["id"].toString()
            val poll = service.findById(id)

            if (poll == null) {
                call.respond(HttpStatusCode.NotFound, "This is no object this id $id")
            }
            call.respond(HttpStatusCode.OK, poll!!.toDTO())
        }
    }
}