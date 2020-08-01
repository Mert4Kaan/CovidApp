package com.mert.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nopalyer.covidapp.PrecautionsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)

        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayout.VERTICAL, false)
        val  precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","You can reduce the risk of corona virus by washing your hands for 20 seconds."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","You can prevent the spread of the virus by staying in your home."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","We must clean the items we use."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","We must clean the items we use."))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Try to touch the possible profile of the surfaces less."))


        val precautionsAdapter = PrecautionsAdapter(precautionsList)


        recyclerView.adapter = precautionsAdapter
    }
}
