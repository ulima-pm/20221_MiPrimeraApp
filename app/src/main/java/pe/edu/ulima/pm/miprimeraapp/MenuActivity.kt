package pe.edu.ulima.pm.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import pe.edu.ulima.pm.miprimeraapp.fragments.FragmentDos
import pe.edu.ulima.pm.miprimeraapp.fragments.FragmentUno

class MenuActivity : AppCompatActivity() {
    val fragments : List<Fragment> = listOf(
        FragmentUno(), FragmentDos()
    )

    var mCurrentFragmentIndex : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val butIrFragmentUno : Button = findViewById(R.id.butIrFragmentUno)
        val butIrFragmentDos : Button = findViewById(R.id.butIrFragmentDos)

        butIrFragmentUno.setOnClickListener {
            if (mCurrentFragmentIndex != 0)
            {
                mCurrentFragmentIndex = 0
                val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fcvFragments, fragments[mCurrentFragmentIndex])
                ft.commit()

            }

        }

        butIrFragmentDos.setOnClickListener {
            if (mCurrentFragmentIndex != 1)
            {
                mCurrentFragmentIndex = 1
                val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fcvFragments, fragments[mCurrentFragmentIndex])
                ft.commit()

            }

        }

        // Agregamos fragment por defecto
        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fcvFragments, fragments[mCurrentFragmentIndex])
        ft.commit()
    }
}