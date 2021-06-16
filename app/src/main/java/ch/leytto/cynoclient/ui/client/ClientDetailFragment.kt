package ch.leytto.cynoclient.ui.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import ch.leytto.cynoclient.Constants
import ch.leytto.cynoclient.CynoClientApplication
import ch.leytto.cynoclient.R
import ch.leytto.cynoclient.ui.ViewModelFactory

class ClientDetailFragment : Fragment() {

    private val clientViewModel: ClientViewModel by viewModels {
        ViewModelFactory((requireActivity().application as CynoClientApplication).clientRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_client_detail, container, false)

        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val clientLiveData = clientViewModel.findClientWithLocalityAndDogWithBreedAndDiseasesById(id)
        clientLiveData.observe(viewLifecycleOwner) { client ->
            root.findViewById<TextView>(R.id.text_id).text = client.dogs.get(0).crossbreed?.noun ?: client.dogs.get(0).breed.noun
        }

        return root
    }
}