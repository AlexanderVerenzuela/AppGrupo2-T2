package pe.edu.cibertec.appgrupo2_t2

data class RecipeResponse(
    val recipes: List<Recipe>
)

data class Recipe(
    val id: Int,
    val name: String,
    val prepTimeMinutes: Int,
    val difficulty: String,
    val cuisine: String
)
