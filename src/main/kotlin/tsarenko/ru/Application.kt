package tsarenko.ru

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import tsarenko.ru.plugins.configureDatabases
import tsarenko.ru.plugins.configureRouting
import tsarenko.ru.plugins.configureSerialization

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureRouting()
}
