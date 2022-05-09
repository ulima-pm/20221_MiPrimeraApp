package pe.edu.ulima.pm.miprimeraapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.miprimeraapp.R

class FragmentMenubar : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menubar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.butIrFragmentUno).setOnClickListener {
            // Se va a mostrar FragmentUno
        }

        view.findViewById<Button>(R.id.butIrFragmentDos).setOnClickListener {
            // Se va a mostrar FragmentDos
        }

        view.findViewById<Button>(R.id.butIrLogin).setOnClickListener {
            // Debe retonar al activity login
        }
    }
}