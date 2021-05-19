package ch.leytto.cynoclient.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ch.leytto.cynoclient.db.dao.ClientDao
import ch.leytto.cynoclient.db.dao.DogDao
import ch.leytto.cynoclient.db.entities.*
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Breed::class, Category::class, Client::class, ClientTakeService::class, Consultation::class, Disease::class, Dog::class, DogHaveDisease::class, DogHaveService::class, Locality::class, Service::class), version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class CynoClientRoomDatabase : RoomDatabase() {

    // DAOs
    abstract fun dogDao(): DogDao
    abstract fun clientDao(): ClientDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CynoClientRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): CynoClientRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CynoClientRoomDatabase::class.java,
                    "CynoClient.db"
                )
                    .createFromAsset("database/CynoClientBase.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}