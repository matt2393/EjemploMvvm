package dev.matt2393.ejemplomvvm.Model.RetrofitConnect

import dev.matt2393.ejemplomvvm.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    val requests = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitRequest::class.java)
}