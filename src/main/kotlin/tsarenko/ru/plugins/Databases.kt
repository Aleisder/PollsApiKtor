package tsarenko.ru.plugins

import org.jetbrains.exposed.sql.Database

fun configureDatabases() {

    Database.connect(
        url = "jdbc:postgresql://localhost:5432/polls",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres"
    )

}
