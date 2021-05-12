package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class Client (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "female") val female: Boolean,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "street") val street: String?,
    @ColumnInfo(name = "id_locality") val idLocality: Int?
        ) {

}