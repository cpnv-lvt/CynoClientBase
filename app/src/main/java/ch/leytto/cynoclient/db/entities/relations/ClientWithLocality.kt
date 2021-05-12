package ch.leytto.cynoclient.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ch.leytto.cynoclient.db.entities.*

data class ClientWithLocality(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "id_locality",
        entityColumn = "id"
    )
    val locality: Locality?
) {
}