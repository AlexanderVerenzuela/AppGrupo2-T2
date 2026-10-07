package pe.edu.cibertec.appgrupo2_t2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo2_t2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Cargar por defecto el primer Fragment al iniciar la pantalla
        if (savedInstanceState == null) {
            reemplazarFragment(Pregunta1Fragment())
        }

        // 2. Configurar el listener del BottomNavigationView para cambiar de Fragment
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_pregunta1 -> reemplazarFragment(Pregunta1Fragment())
                R.id.nav_pregunta2 -> reemplazarFragment(Pregunta2Fragment())
                R.id.nav_pregunta3 -> reemplazarFragment(Pregunta3Fragment()) // Tu lista de Frutas
                R.id.nav_pregunta4 -> reemplazarFragment(Pregunta4Fragment())
                else -> false
            }
            true
        }
    }

    private fun reemplazarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
