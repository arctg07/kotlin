package mobi.sevenwinds.app.author

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object AuthorTable : IntIdTable("author") {
    val name = text("ФИО");
}

class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable) {
    }
    var name by AuthorTable.name

    fun toResponse(): AuthorResponse {
        return AuthorResponse(id.value, name)
    }
}

data class AuthorRecord(
    val name: String
)

data class AuthorResponse(
    val id: Int,
    val name: String
)