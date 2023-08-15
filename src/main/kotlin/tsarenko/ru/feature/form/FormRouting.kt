package tsarenko.ru.feature.form

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import tsarenko.ru.database.form.Form

fun Application.configureFormRouting() {

    routing {
        route("/poll") {

            get("/{id}") {
                val id = call.parameters["id"]!!
                FormController(call).getForm(id)
            }

            post {
                val form = call.receive<Form>()
                FormController(call).addForm(form)
            }

            delete("/{id}") {
                val id = call.parameters["id"]!!
                FormController(call).deleteForm(id)
            }

        }
    }

}