package pe.edu.cibertec.appgrupo2_t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo2_t2.databinding.FragmentPregunta2Binding

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == binding.btnCalcular.id) {
            val textoPrendas = binding.etPrendasDefectuosas.text.toString().trim()

            if (textoPrendas.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Debe ingresar la cantidad de prendas defectuosas",
                    Toast.LENGTH_SHORT
                ).show()
                binding.etPrendasDefectuosas.error = "Ingrese la cantidad"
                return
            }

            val prendas = textoPrendas.toIntOrNull()
            if (prendas == null || prendas < 0) {
                Toast.makeText(
                    requireContext(),
                    "Ingrese un número entero válido",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            if (prendas <= 10) {
                binding.tvResultado.text =
                    "Nivel de merma dentro del margen admisible."
            } else {
                val exceso = prendas - 10
                val descuento = 100.00 + (exceso * 28.00)

                binding.tvResultado.text =
                    "Fallas registradas: $prendas\n" +
                            "Exceso de prendas defectuosas: $exceso\n" +
                            "Descuento total por reposición: S/ %.2f".format(descuento)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}