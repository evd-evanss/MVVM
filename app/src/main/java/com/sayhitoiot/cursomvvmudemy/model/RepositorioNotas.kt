package com.sayhitoiot.cursomvvmudemy.model

import androidx.lifecycle.MutableLiveData

class RepositorioNotas{
    private val repositorioNotas: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun insertNota(nota: Nota){
        var tempNotas = repositorioNotas.value
        if(tempNotas==null){
            tempNotas = mutableListOf()
            tempNotas.add(nota)
        }else{
            tempNotas.add(nota)
        }
        repositorioNotas.postValue(tempNotas)

    }

    fun obterNotas() = repositorioNotas
}