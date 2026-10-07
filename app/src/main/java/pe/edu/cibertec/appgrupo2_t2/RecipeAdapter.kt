package pe.edu.cibertec.appgrupo2_t2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo2_t2.databinding.ItemRecipeBinding

class RecipeAdapter(
    private var listaRecetas: List<Recipe> = emptyList()
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val receta = listaRecetas[position]
        holder.binding.tvId.text = "ID: ${receta.id}"
        holder.binding.tvName.text = receta.name
        holder.binding.tvPrepTime.text = "Tiempo de preparación: ${receta.prepTimeMinutes} min"
        holder.binding.tvDifficulty.text = "Dificultad: ${receta.difficulty}"
        holder.binding.tvCuisine.text = "Cocina: ${receta.cuisine}"
    }

    override fun getItemCount(): Int = listaRecetas.size

    fun actualizarLista(nuevaLista: List<Recipe>) {
        listaRecetas = nuevaLista
        notifyDataSetChanged()
    }
}
