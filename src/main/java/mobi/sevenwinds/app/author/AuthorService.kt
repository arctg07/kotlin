package mobi.sevenwinds.app.author

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction

object AuthorService {
    suspend fun addRecord(body: AuthorRecord): AuthorResponse = withContext(Dispatchers.IO) {
        transaction {
            val entity = AuthorEntity.new {
                this.name = body.name
            }

            return@transaction entity.toResponse()
        }
    }

    fun getAuthor(id: Int): AuthorEntity? {
        return AuthorEntity.find {
            AuthorTable.id eq id }.limit(1).firstOrNull()
    }
}