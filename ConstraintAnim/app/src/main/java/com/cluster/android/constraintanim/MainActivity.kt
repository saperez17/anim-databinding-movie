package com.cluster.android.constraintanim

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import com.cluster.android.constraintanim.databinding.ActivityMainExpandedBinding
import com.cluster.android.constraintanim.models.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val setExpanded:ConstraintSet = ConstraintSet()
    val setCollapsed:ConstraintSet = ConstraintSet()

    var expanded:Boolean = true





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainExpandedBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_expanded)

        setExpanded.clone(root)
        setCollapsed.clone(this, R.layout.activity_main)


        //Modelo que exprese los pasos para insertar (inyectar)
        /* Con el data binding no son necesarias las siguientes lineas de codigo
        today.text = "12 de Diciembre"
        time.text = "2 horas"

        des.text = "La mejor pelicula..."
        name.text = "Interestellar"
        img.setImageURI("https://i1.wp.com/asdecopas.cl/wp-content/uploads/2014/11/interstellar.jpg?w=960")
        */

        //Objeto de tipo "Movie"
        val movie = Movie("Intererestellar",
            "https://i1.wp.com/asdecopas.cl/wp-content/uploads/2014/11/interstellar.jpg?w=960",
            "12 de Diciembre",
            "2 hours",
            "Best movie")

        binding.movie = movie


        //Implementando un lambda (function type)
        btnInfo.setOnClickListener{
            TransitionManager.beginDelayedTransition(root)
            if(expanded) setCollapsed.applyTo(root)
            else setExpanded.applyTo(root)
            expanded =  !expanded

        }



    }
}
