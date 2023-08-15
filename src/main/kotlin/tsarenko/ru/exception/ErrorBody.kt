package tsarenko.ru.exception

import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class ErrorBody(
    @SerialName("http_code") val httpCode: Int,
    val request: String,
    val time: String = LocalDateTime.now().toString(),
    val error: String
) {
    companion object {

        fun getInvalidIdError(id: String) =
            ErrorBody(
                httpCode = HttpStatusCode.BadRequest.value,
                request = "/poll/$id",
                error = "Invalid ID. Must be hex string of 24 symbols"
            )

        fun getNoObjectFoundError(id: String) =
            ErrorBody(
                httpCode = HttpStatusCode.NotFound.value,
                request = "/poll/${id}",
                error = "This is no object with id $id"
            )

    }

}