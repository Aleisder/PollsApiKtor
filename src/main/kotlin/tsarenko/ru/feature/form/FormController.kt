package tsarenko.ru.feature.form

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import tsarenko.ru.database.form.Form
import tsarenko.ru.database.form.FormRepository
import tsarenko.ru.exception.ErrorBody
import tsarenko.ru.util.toMongoId

class FormController(private val call: ApplicationCall) {

    private val repository = FormRepository()

    suspend fun getPoll(id: String) {
        validateId(call, id)

        val poll: Form? = repository.findById(id.toMongoId())

        if (poll == null)
            call.respond(
                HttpStatusCode.NotFound,
                ErrorBody.getNoObjectFoundError(id)
            )
        else call.respond(HttpStatusCode.OK, poll)
    }

    suspend fun deletePoll(id: String) {
        validateId(call, id)
        call.respond(
            if (repository.deleteById(id.toMongoId()))
                HttpStatusCode.OK
            else
                HttpStatusCode.Conflict
        )
    }

    private suspend fun validateId(call: ApplicationCall, id: String?) {
        if (id?.length != 24) {
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorBody.getInvalidIdError(id!!)
            )
        }
    }

}