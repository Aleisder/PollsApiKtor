package tsarenko.ru.exception

import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class ErrorBody(
    @SerialName("http_code") val httpCode: Int,
    val request: String,
    val time: String,
    val error: String
) {
    class Builder {

        private var httpCode = 0
        private var request = ""
        private var error = ""

        private var id = ""

        fun setId(id: String): Builder {
            this.id = id
            return this
        }

        fun setErrorType(type: ErrorType): Builder {
            when (type) {
                ErrorType.INVALID_ID -> {
                    httpCode = HttpStatusCode.BadRequest.value
                    request = "/poll/$id"
                    error = "Invalid ID. Must be hex string of 24 symbols"
                }
                ErrorType.OBJECT_NOT_FOUND -> {
                    httpCode = HttpStatusCode.NotFound.value
                    request = "/poll/$id"
                    error = "This is no object with id $id"
                }
            }
            return this
        }

        fun build() = ErrorBody(httpCode, request, LocalDateTime.now().toString(), error)
    }

}