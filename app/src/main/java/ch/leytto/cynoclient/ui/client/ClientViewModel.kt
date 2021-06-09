package ch.leytto.cynoclient.ui.client

import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.relations.ClientWithLocality
import ch.leytto.cynoclient.model.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    val allClients: LiveData<List<Client>> = repository.allClients.asLiveData()
    val allClientsWithLocalities: LiveData<List<ClientWithLocality>> = repository.allClientsWithLocalities.asLiveData()

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }

}