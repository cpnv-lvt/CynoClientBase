package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dogs")
data class Dog (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "noun") val noun: String,
    @ColumnInfo(name = "female") val female: Boolean,
    @ColumnInfo(name = "birthdate") val birthdate: String,
    @ColumnInfo(name = "sterilized") val sterilized: Boolean,
    @ColumnInfo(name = "chemical") val chemical: Boolean,
    @ColumnInfo(name = "color") val color: String?,
    @ColumnInfo(name = "dead") val dead: Boolean,
    @ColumnInfo(name = "id_client") val idClient: Int,
    @ColumnInfo(name = "breed") val breed: Int,
    @ColumnInfo(name = "crossbreed") val crossbreed: Int?
        ) {

}