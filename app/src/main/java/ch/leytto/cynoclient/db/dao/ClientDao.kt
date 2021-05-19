package ch.leytto.cynoclient.db.dao

import androidx.room.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Transaction
    @Query("SELECT * FROM clients")
    suspend fun getClientWithLocalityAndDogWithBreedAndDiseases(): List<ClientWithLocalityAndDogWithBreedAndDiseases>

    @Query("SELECT * FROM clients")
    fun getClients() : Flow<List<Client>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client)

    @Update
    suspend fun updateDogs(vararg clients: Client)

    @Delete
    suspend fun deleteDogs(vararg clients: Client)
}