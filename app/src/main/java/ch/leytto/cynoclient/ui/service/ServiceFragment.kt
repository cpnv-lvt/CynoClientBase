package ch.leytto.cynoclient.ui.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ch.leytto.cynoclient.R

class ServiceFragment : Fragment() {

    private lateinit var serviceViewModel: ServiceViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        serviceViewModel =
                ViewModelProvider(this).get(ServiceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_service, container, false)
        val textView: TextView = root.findViewById(R.id.text_service)
        serviceViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}