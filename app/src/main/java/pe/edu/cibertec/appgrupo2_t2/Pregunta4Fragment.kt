package pe.edu.cibertec.appgrupo2_t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo2_t2.databinding.FragmentPregunta4Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!
    private val adapter = RecipeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvRecetas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecetas.adapter = adapter

        cargarRecetas()
    }

    private fun cargarRecetas() {
        RetrofitClient.apiService.obtenerRecetas().enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    val recetas = response.body()?.recipes ?: emptyList()
                    adapter.actualizarLista(recetas)
                } else {
                    Toast.makeText(requireContext(), "Error al obtener recetas", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Error de red: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
