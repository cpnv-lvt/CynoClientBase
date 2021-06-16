package ch.leytto.cynoclient.ui.client

import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.relations.ClientWithLocality
import ch.leytto.cynoclient.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import ch.leytto.cynoclient.model.ClientRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    val allClients: LiveData<List<Client>> = repository.allClients.asLiveData()
    val allClientsWithLocalities: LiveData<List<ClientWithLocality>> = repository.allClientsWithLocalities.asLiveData()

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }

    fun findClientWithLocalityAndDogWithBreedAndDiseasesById(id: Int): LiveData<ClientWithLocalityAndDogWithBreedAndDiseases> {
        val currentClient = MutableLiveData<ClientWithLocalityAndDogWithBreedAndDiseases>()
        viewModelScope.launch {
            currentClient.value = repository.findClientWithLocalityAndDogWithBreedAndDiseasesById(id)
        }
        return currentClient
    }

}