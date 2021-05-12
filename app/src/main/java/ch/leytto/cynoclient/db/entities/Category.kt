package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "noun") val noun: String
) {

}