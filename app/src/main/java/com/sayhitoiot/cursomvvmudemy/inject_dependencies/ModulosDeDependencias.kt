package com.sayhitoiot.cursomvvmudemy.inject_dependencies

import com.sayhitoiot.cursomvvmudemy.model.GestorDeNotas
import com.sayhitoiot.cursomvvmudemy.model.RepositorioNotas
import com.sayhitoiot.cursomvvmudemy.viewmodels.NotasViewMode
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object ModulosDeDependencias {
    val moduloApp = module{
        single { RepositorioNotas() } //Cria uma instancia Singleton
        factory { GestorDeNotas(get()) } //Neste contexto o get() vai procurar uma instancia de RepositorioNotas dentro do modulo
        viewModel { NotasViewMode(get()) }
    }
}
