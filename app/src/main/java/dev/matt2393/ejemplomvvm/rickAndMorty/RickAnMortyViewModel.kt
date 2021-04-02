package dev.matt2393.ejemplomvvm.rickAndMorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.matt2393.ejemplomvvm.Model.Entity.PersonajesRaM
import dev.matt2393.ejemplomvvm.ResultData
import kotlinx.coroutines.launch

class RickAnMortyViewModel(
    private val rickAndMortyRepository: RickAndMortyRepository = RickAndMortyRepository()
): ViewModel() {
    val personajes = MutableLiveData<PersonajesRaM>().apply {  PersonajesRaM() }
    val error =  MutableLiveData<Exception>().apply { Throwable() }
    fun getPersonajes() {
        viewModelScope.launch {
            val res = rickAndMortyRepository.getPersonajes()
            when(res) {
                is ResultData.Success -> personajes.value = res.data
                is ResultData.Error -> error.value = res.ex
            }
        }
    }
}