package pe.edu.cibertec.appgrupo2_t2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo2_t2.databinding.ItemFrutaBinding
import pe.edu.cibertec.appgrupo2_t2.model.Fruta

class FrutaAdapter(private val listaFrutas: List<Fruta>)
    : RecyclerView.Adapter<FrutaAdapter.ViewHolder> () {
    inner class ViewHolder(val binding: ItemFrutaBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrutaAdapter.ViewHolder {
        val binding = ItemFrutaBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrutaAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listaFrutas[position]){
                binding.tvnombre.text = nombre
                Glide.with(itemView.context)
                    .load(urlImagen)
                    .into(binding.ivfoto)

            }
        }
    }

    override fun getItemCount() = listaFrutas.size


}