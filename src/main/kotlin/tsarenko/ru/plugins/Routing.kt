package tsarenko.ru.plugins

import io.ktor.server.application.*
import tsarenko.ru.feature.form.configureFormRouting
import tsarenko.ru.feature.statistics.configureStatisticsRouting
import tsarenko.ru.feature.user.configureUserRouting

fun Application.configureRouting() {
    configureUserRouting()
    configureFormRouting()
    configureStatisticsRouting()
}
