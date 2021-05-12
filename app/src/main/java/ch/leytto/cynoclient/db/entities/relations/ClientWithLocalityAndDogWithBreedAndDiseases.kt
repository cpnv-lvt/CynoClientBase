package ch.leytto.cynoclient.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ch.leytto.cynoclient.db.entities.*

data class ClientWithLocalityAndDogWithBreedAndDiseases(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "id_locality",
        entityColumn = "id"
    )
    val locality: Locality?,
    @Relation(
        entity = Dog::class,
        parentColumn = "id",
        entityColumn = "id_client"
    )
    val dogs: List<DogWithBreedAndDiseases>
) {
}