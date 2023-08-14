package tsarenko.ru.feature.form.model

data class Form(
    val title: String,
    val date: String,
    val polls: List<Poll>
)
