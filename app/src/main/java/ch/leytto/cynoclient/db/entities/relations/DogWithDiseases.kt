package ch.leytto.cynoclient.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ch.leytto.cynoclient.db.entities.*

data class DogWithDiseases(
    @Embedded val dog: Dog,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(DogHaveDisease::class)
    )
    val diseases: List<Disease>
) {
}