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

        fun getInvalidIdError(path: String) =
            ErrorBody(
                httpCode = HttpStatusCode.BadRequest.value,
                request = path,
                error = "Invalid ID. Must be hex string of 24 symbols"
            )

        fun getNoObjectFoundError(id: String, path: String) =
            ErrorBody(
                httpCode = HttpStatusCode.NotFound.value,
                request = path,
                error = "This is no object with id $id"
            )

    }

}