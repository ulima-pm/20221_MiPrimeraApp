package pe.edu.ulima.pm.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import pe.edu.ulima.pm.miprimeraapp.views.ULFaceView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main) // Proceso de inflado

        val faceView = findViewById<ULFaceView>(R.id.cara)
        faceView.setOnClickListener { v : View ->
            val face = v as ULFaceView
            face.BocaHeight += 50
        }

        if (savedInstanceState == null) {
            Log.i("MainActivity", "SavedInstanceState null")
        } else {
            Log.i("MainActivity", savedInstanceState?.getString("NOMBRE")!!);
        }

        // Obtenemos los datos guardados en el intent
        val correo = intent.getStringExtra("USERNAME")
        val credenciales : Credenciales = intent.getSerializableExtra(
            "DATA_CREDENCIALES") as Credenciales
        val tviUsername = findViewById<TextView>(R.id.tviUsername)
        tviUsername.text = credenciales.username

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("NOMBRE", "Jose")
    }
}