package pe.edu.cibertec.appgrupo2_t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo2_t2.adapter.FrutaAdapter
import pe.edu.cibertec.appgrupo2_t2.databinding.FragmentPregunta3Binding
import pe.edu.cibertec.appgrupo2_t2.model.Fruta


class Pregunta3Fragment : Fragment() {
    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater,container,false)

        binding.rvFrutas.layoutManager = LinearLayoutManager(requireContext())
        val lista = obtenerListaFrutas()
        binding.rvFrutas.adapter = FrutaAdapter(lista)

        return binding.root
    }

    private fun obtenerListaFrutas():List<Fruta>{
        val nombres = listOf(
            "Apple", "Banana", "Strawberry", "Orange"
            , "Grape", "Mango", "Pineapple", "Papaya"
            , "Watermelon", "Melon", "Peach", "Plum"
            , "Kiwi", "Pear", "Mandarin", "Fig", "granadilla"
            , "Passionfruit", "Soursop", "Cherimoya"
        )
        return nombres.mapIndexed { index,nombre ->
            Fruta(
                id = index + 1,
                nombre = nombre,
                urlImagen="https://loremflickr.com/200/200/${nombre}"
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}