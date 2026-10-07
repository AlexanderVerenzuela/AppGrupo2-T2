package pe.edu.cibertec.appgrupo2_t2

import retrofit2.Call
import retrofit2.http.GET

interface RecipeApiService {
    @GET("recipes")
    fun obtenerRecetas(): Call<RecipeResponse>
}
