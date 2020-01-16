package com.sayhitoiot.cursomvvmudemy.model

import android.app.Application
import com.sayhitoiot.cursomvvmudemy.inject_dependencies.ModulosDeDependencias
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(ModulosDeDependencias.moduloApp)
        )
    }


}