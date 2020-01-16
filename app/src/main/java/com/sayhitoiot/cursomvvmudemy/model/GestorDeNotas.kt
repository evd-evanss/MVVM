package com.sayhitoiot.cursomvvmudemy.model

/**
 * Classes model nesta arquitetura são responsáveis de pegar dados do servidor
 */
class GestorDeNotas(val repositorioNotas: RepositorioNotas) {

    fun getNotas() = repositorioNotas.obterNotas()

    fun addNota(mNota: Nota){
        repositorioNotas.insertNota(mNota)
    }

}