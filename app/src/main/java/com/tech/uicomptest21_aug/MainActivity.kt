package com.tech.uicomptest21_aug

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get string values from xml to kotlin

        var state_names = resources.getStringArray(R.array.states)

        //ArrayAdapter is used to present string type of values
        var arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, state_names)
        actv.threshold = 1
        actv.setAdapter(arrayAdapter)
        list_view.adapter = arrayAdapter


//        actv.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, "${state_names[position]}", Toast.LENGTH_LONG).show()
//        }


        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, "${state_names[p2]}", Toast.LENGTH_LONG).show()

                var intent = Intent(this@MainActivity, InfoActivity::class.java)
                intent.putExtra("state_name", "${state_names[p2]}")
                startActivity(intent)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        list_view.setOnItemClickListener(AdapterView.OnItemClickListener({ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            Toast.makeText(this@MainActivity, "${state_names[i]}", Toast.LENGTH_LONG).show()

        }))

    }
}