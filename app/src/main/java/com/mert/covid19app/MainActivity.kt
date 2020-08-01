package com.mert.covid19app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.nopalyer.covidapp.PrecautionsAdapter
import com.nopalyer.covidapp.SymptomsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Dry cough in coronavirus is one of the symptoms."))
        symptomsList.add(Model(R.drawable.fever,"Fever","High fever is one of the serious symptoms of corona virus."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Severe headache is in the symptoms of coronavirus."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","Sore Throat is one of the symptoms of corona."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter

        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL, false)
        val  precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","You can reduce the risk of corona virus by washing your hands for 20 seconds."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","We must clean the items we use."))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Try to touch the possible profile of the surfaces less."))


        val precautionsAdapter = PrecautionsAdapter(precautionsList)


        recyclerViewPrecautions.adapter = precautionsAdapter

        txtViewSymptoms.setOnClickListener {
            var intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

        btnKnow.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener {
            var intent = Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }


        getGlobalData()
    }

    fun getGlobalData(){
        val url:String ="https://disease.sh/v2/all"

        val stringRequest:StringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                txtInfected.text = jsonObject.getString("cases")
                txtrecovered.text = jsonObject.getString("recovered")
                txtdeaths.text = jsonObject.getString("deaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,"Something went wrong", Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtrecovered.text = "-"
                txtdeaths.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)

    }
}
