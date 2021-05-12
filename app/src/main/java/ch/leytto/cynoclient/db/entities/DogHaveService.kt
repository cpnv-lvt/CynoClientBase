package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_have_services")
data class DogHaveService (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "id_dog") val idDog: Int,
    @ColumnInfo(name = "id_service") val idService: Int
        ) {

}