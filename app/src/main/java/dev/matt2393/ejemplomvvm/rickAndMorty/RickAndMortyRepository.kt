package dev.matt2393.ejemplomvvm.rickAndMorty

import dev.matt2393.ejemplomvvm.Model.Entity.PersonajesRaM
import dev.matt2393.ejemplomvvm.Model.RetrofitConnect.RetrofitSingleton
import dev.matt2393.ejemplomvvm.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickAndMortyRepository {
    suspend fun getPersonajes(): ResultData<PersonajesRaM>
        = withContext(Dispatchers.IO) {
         try {
             val per = RetrofitSingleton.requests.getPersonajes()
             ResultData.Success(per)
         } catch (ex: Exception) {
             ResultData.Error(ex)
         }
    }
}