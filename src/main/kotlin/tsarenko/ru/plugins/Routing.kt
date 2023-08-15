package tsarenko.ru.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import tsarenko.ru.feature.form.configureFormRouting

fun Application.configureRouting() {
    configureFormRouting()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
