package ch.leytto.cynoclient.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import ch.leytto.cynoclient.db.entities.Breed
import ch.leytto.cynoclient.db.entities.Category

data class CategoryWithBreeds(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCategory"
    )
    val breeds: List<Breed>
) {
}