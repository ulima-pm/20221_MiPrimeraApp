package pe.edu.ulima.pm.miprimeraapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

data class Credenciales(val username : String, val password : String) : Serializable

// Controller
class LoginActivity : AppCompatActivity(){
    private var mButIngresar : Button?  = null
    private var mButRegistrar : Button? = null
    private var mEteUsuarioCorreo : EditText? = null
    private var mEteUsuarioPassword : EditText? = null
    private var mTviMensaje : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Obtener referencias a componentes UI
        mButIngresar = findViewById(R.id.butIngresar)
        mButRegistrar = findViewById(R.id.butRegistrar)
        mEteUsuarioCorreo = findViewById(R.id.eteUsuarioCorreo)
        mEteUsuarioPassword = findViewById(R.id.eteUsuarioPassword)
        mTviMensaje = findViewById(R.id.tviMensaje)

        //  <Controller>            <View>
        // LoginActivity ------> mButIngresar : Button
        //         (setOnClickListener)
        mButIngresar!!.setOnClickListener{ v : View ->
            Log.i("LoginActivity", "Hizo click")
            val correo : String = mEteUsuarioCorreo!!.text.toString()
            val password : String = mEteUsuarioPassword!!.text.toString()

            if (correo == "pm@ulima.edu.pe" && password == "123") {
                //mTviMensaje!!.text = "Login Correcto"
                // Configurando intent
                val intent : Intent = Intent()
                intent.setClass(this, MainActivity::class.java)

                // Pasar parametros
                val credenciales = Credenciales(correo, password)

                val data = Bundle()
                data.putString("USERNAME", correo)
                data.putSerializable("DATA_CREDENCIALES", credenciales)
                intent.putExtras(data)


                // Lanzar el intent
                startActivity(intent)

            }else {
                mTviMensaje!!.text = "Login Incorrecto"
            }
        }

        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            // Codigo a ejecutarse al regresar del activity
            Log.i("LoginActivity", "Regresando del RegistroActivity");
            val intentRespuesta = result.data
            val username : String = intentRespuesta!!.getStringExtra(
                "USERNAME_REGISTRADO")!!
            mEteUsuarioCorreo!!.setText(username)
        }

        mButRegistrar!!.setOnClickListener { v : View ->
            val intent = Intent()
            intent.setClass(this, RegistroActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

    override fun onStart() {
        super.onStart()
    }

}