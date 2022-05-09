package pe.edu.ulima.pm.miprimeraapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.miprimeraapp.R

class FragmentDos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.butFragmentDos).setOnClickListener {
            Toast.makeText(activity, "Fragment DOS", Toast.LENGTH_SHORT).show()
        }
    }
}