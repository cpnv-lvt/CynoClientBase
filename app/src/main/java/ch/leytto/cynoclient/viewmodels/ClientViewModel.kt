package ch.leytto.cynoclient.viewmodels

import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.model.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    val AllClients: LiveData<List<Client>> = repository.allClients.asLiveData()

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }

}