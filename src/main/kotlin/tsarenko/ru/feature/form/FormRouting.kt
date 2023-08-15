package tsarenko.ru.feature.form

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureFormRouting() {

    routing {
        route("/poll/{id}") {

            get {
                val id = call.parameters["id"]!!
                FormController(call).getPoll(id)
            }

            delete {
                val id = call.parameters["id"]!!
                FormController(call).deletePoll(id)
            }

        }
    }

}