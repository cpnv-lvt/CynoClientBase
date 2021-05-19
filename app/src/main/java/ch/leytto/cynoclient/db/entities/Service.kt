package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "services")
data class Service (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "moment") val moment: String,
    @ColumnInfo(name = "duration") val duration: Float,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "street") val street: String?,
    @ColumnInfo(name = "id_locality") val idLocality: Int
        ) {

}