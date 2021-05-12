package ch.leytto.cynoclient.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import ch.leytto.cynoclient.db.entities.Breed
import ch.leytto.cynoclient.db.entities.Category

data class BreedWithCategory(
    @Embedded val breed: Breed,
    @Relation(
        parentColumn = "idCategory",
        entityColumn = "id"
    )
    val category: Category?
) {
}