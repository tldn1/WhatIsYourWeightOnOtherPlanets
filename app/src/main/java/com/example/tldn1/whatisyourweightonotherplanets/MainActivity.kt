package com.example.tldn1.whatisyourweightonotherplanets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val marsGravity = 0.38
    val venusGravit = 0.91
    val jupiterGravity = 2.34
    var planet = "mars"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = edtEnterWeight.text

        btnShowWeight.setOnClickListener {

            txtShowWeight.text = calculateWeight(weight.toString().toDouble(),planet).toString()

        }

    }

    fun calculateWeight(userWeight: Double, planet: String): Double {

        when (planet) {
            "mars" -> return userWeight * marsGravity
            "venus" -> return userWeight * venusGravit
            "jupiter" -> return userWeight * jupiterGravity
            else -> return userWeight
        }

    }

    fun selectPlanet(view: View) {
        view as CheckBox
        when(view.id){
            R.id.chkMars -> if(view.isChecked){planet = "mars"}
            R.id.chkVenus -> if(view.isChecked){planet = "venus"}
            R.id.chkJupiter -> if(view.isChecked){planet = "jupiter"}
            else -> planet = "mars"
        }

    }


}
