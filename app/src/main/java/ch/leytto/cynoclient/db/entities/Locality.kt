package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localities")
data class Locality (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "noun") val noun: String,
    @ColumnInfo(name = "zip") val zip: Int,
    @ColumnInfo(name = "zip_complement") val zipComplement: Int,
    @ColumnInfo(name = "toponym") val toponym: String,
    @ColumnInfo(name = "department") val department: String,
    @ColumnInfo(name = "language") val language: String
) {

}