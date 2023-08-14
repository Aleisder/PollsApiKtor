package tsarenko.ru.feature.form.model

data class Poll(
    val question: String,
    val type: String,
    val answers: List<String>
)
