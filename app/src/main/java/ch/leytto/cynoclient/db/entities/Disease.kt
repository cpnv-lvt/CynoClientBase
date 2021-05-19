package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diseases")
data class Disease (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "noun") val noun: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "symptoms") val symptoms: String,
    @ColumnInfo(name = "preventive") val preventive: String,
    @ColumnInfo(name = "curative") val curative: String,
    @ColumnInfo(name = "vaccinable") val vaccinable: Boolean,
    @ColumnInfo(name = "zoonosis") val zoonosis: Boolean
) {

}