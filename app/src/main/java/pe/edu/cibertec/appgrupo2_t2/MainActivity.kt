package pe.edu.cibertec.appgrupo2_t2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo2_t2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val listaUsuarios = listOf(
        Usuario("i202500911", "005397526"),
        Usuario("I202402162", "44122028"),
        Usuario("I202120270", "43570426"),
        Usuario("i202312139", "70938210"),
        Usuario("i202505681", "44998660"),
        Usuario("i202419559", "73036339"),
        Usuario("i201614176", "73680615"),
        Usuario("123456", "123456")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnIngresar.id) {
            val usuarioIngresado = binding.etUsuario.text.toString()
            val contrasenaIngresada = binding.etContrasena.text.toString()

            autenticar(usuarioIngresado, contrasenaIngresada)
        }
    }

    private fun autenticar(usuario: String, contrasena: String) {
        if (usuario.isBlank() || contrasena.isBlank()) {
            Toast.makeText(
                this,
                "Por favor ingrese usuario y contraseña. Los campos no pueden estar vacíos ni contener solo espacios.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val esValido = verificarCredenciales(usuario.trim(), contrasena.trim())

        if (esValido) {
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(
                this,
                "Credenciales incorrectas. El usuario o la contraseña no coinciden.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun verificarCredenciales(usuario: String, contrasena: String): Boolean {
        return listaUsuarios.any {
            it.usuario == usuario && it.contrasena == contrasena
        }
    }
}