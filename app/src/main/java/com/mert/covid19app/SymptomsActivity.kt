package com.mert.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nopalyer.covidapp.SymptomsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Dry cough in coronavirus is one of the symptoms."))
        symptomsList.add(Model(R.drawable.fever,"Fever","High fever is one of the serious symptoms of corona virus."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Severe headache is in the symptoms of coronavirus."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","Sore Throat is one of the symptoms of corona."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}
