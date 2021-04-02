package dev.matt2393.ejemplomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.matt2393.ejemplomvvm.Model.Entity.PersonajesRaM
import dev.matt2393.ejemplomvvm.databinding.ActivityMainBinding
import dev.matt2393.ejemplomvvm.rickAndMorty.RickAnMortyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RickAnMortyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        binding.buttonPersonajes.setOnClickListener {
            viewModel.getPersonajes()
        }
    }

    private fun initObservers() {
        viewModel.personajes.observe(this, {
            Log.e("Datos", "datos de personajes")
            it.results.forEachIndexed { i, d->
                Log.e("Personaje$i", d.name)
            }
        })
        viewModel.error.observe(this, {
            Log.e("Error", it.toString())
        })
    }
}