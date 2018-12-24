package com.cluster.android.constraintanim

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val setExpanded:ConstraintSet = ConstraintSet()
    val setCollapsed:ConstraintSet = ConstraintSet()

    var expanded:Boolean = true




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_expanded)

        setExpanded.clone(root)
        setCollapsed.clone(this, R.layout.activity_main)


        //Modelo que exprese los pasos para insertar (inyectar)
        today.text = "12 de Diciembre"
        time.text = "2 horas"

        des.text = "La mejor pelicula..."
        name.text = "Interestellar"
        img.setImageURI("https://i1.wp.com/asdecopas.cl/wp-content/uploads/2014/11/interstellar.jpg?w=960")

        //Implementando un lambda (function type)
        btnInfo.setOnClickListener{
            TransitionManager.beginDelayedTransition(root)
            if(expanded) setCollapsed.applyTo(root)
            else setExpanded.applyTo(root)
            expanded =  !expanded

        }



    }
}
