package ch.leytto.cynoclient.model

import androidx.annotation.WorkerThread
import ch.leytto.cynoclient.db.dao.ClientDao
import ch.leytto.cynoclient.db.dao.DogDao
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.Dog
import kotlinx.coroutines.flow.Flow

class ClientRepository(private val clientDao: ClientDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allClients: Flow<List<Client>> = clientDao.getClients()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(client: Client) {
        clientDao.insert(client)
    }
}