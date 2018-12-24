package com.cluster.android.constraintanim

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco


//Archivo kotlin para inicializar la libreria de fresoo

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

    }

}