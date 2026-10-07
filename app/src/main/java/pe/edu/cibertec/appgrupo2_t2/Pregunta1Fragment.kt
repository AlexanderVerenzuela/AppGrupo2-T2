package pe.edu.cibertec.appgrupo2_t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo2_t2.databinding.FragmentPregunta1Binding

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta1Binding.inflate(
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

            val textoDias = binding.etDiasRetraso.text.toString().trim()

            if (textoDias.isEmpty()) {
                binding.etDiasRetraso.error = "Ingrese los días de retraso"
                return
            }

            val dias = textoDias.toInt()

            if (dias <= 5) {

                binding.tvResultado.text =
                    "Entrega dentro de la tolerancia contractual."

            } else {

                val diasPenalidad = dias - 5
                val penalidad = 500.0 + (150.0 * diasPenalidad)

                binding.tvResultado.text =
                    "Días de retraso: $dias\n" +
                            "Días computables para penalidad: $diasPenalidad\n" +
                            "Descuento o penalidad: S/ %.2f".format(penalidad)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}