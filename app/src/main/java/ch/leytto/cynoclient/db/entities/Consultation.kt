package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "consultations")
data class Consultation(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "situation") val situation: String,
    @ColumnInfo(name = "goal") val goal: String?,
    @ColumnInfo(name = "deadline") val deadline: String?,
    @ColumnInfo(name = "solution") val solution: String?,
    @ColumnInfo(name = "medicines") val medicines: String?,
    @ColumnInfo(name = "argumentation") val argumentation: String?,
    @ColumnInfo(name = "id_service") val idService: Int
) {
}