package ch.leytto.cynoclient

import android.app.Application
import ch.leytto.cynoclient.db.CynoClientRoomDatabase
import ch.leytto.cynoclient.model.ClientRepository
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CynoClientApplication: Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { CynoClientRoomDatabase.getDatabase(this, applicationScope) }
    val clientRepository by lazy { ClientRepository(database.clientDao()) }
    val dogRepository by lazy { DogRepository(database.dogDao()) }
}