package dev.matt2393.ejemplomvvm.Model.RetrofitConnect

import dev.matt2393.ejemplomvvm.Model.Entity.PersonajesRaM
import retrofit2.http.GET

interface RetrofitRequest {
    @GET("character")
    suspend fun getPersonajes(): PersonajesRaM
}