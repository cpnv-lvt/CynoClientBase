package ch.leytto.cynoclient.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_take_services")
data class ClientTakeService (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "id_client") val idClient: Int,
    @ColumnInfo(name = "id_service") val idService: Int,
    @ColumnInfo(name = "paid") val paid: Boolean
        ) {

}