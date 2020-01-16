package com.sayhitoiot.cursomvvmudemy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sayhitoiot.cursomvvmudemy.model.GestorDeNotas
import com.sayhitoiot.cursomvvmudemy.model.Nota
import com.sayhitoiot.cursomvvmudemy.model.RepositorioNotas

class NotasViewMode(val gestorDeNotas: GestorDeNotas): ViewModel() {


    private var mNotas: MutableLiveData<MutableList<Nota>>? = null //sobrevive a mudança de rotação de tela

    fun getNotas(): LiveData<MutableList<Nota>> {
        if(mNotas==null){
            mNotas = gestorDeNotas.getNotas()
        }
        return  mNotas!!
    }

    fun insertNota(mNota: Nota){
        gestorDeNotas.addNota(mNota)
    }

}