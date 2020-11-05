package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var sugar = "無糖"
        var iceopt = "去冰"
        var rg1 : RadioGroup = findViewById(R.id.RadioGroup)
        rg1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton1 -> sugar = "無糖"
                R.id.radioButton2 -> sugar = "少糖"
                R.id.radioButton3 -> sugar = "半糖"
                R.id.radioButton4 -> sugar = "全糖"
            }
        })
        var rg2 : RadioGroup = findViewById(R.id.RadioGroup2)
        rg2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton5 -> iceopt = "微冰"
                R.id.radioButton6 -> iceopt = "少冰"
                R.id.radioButton7 -> iceopt = "正常冰"
            }
        })
        var sendbtn : Button = findViewById(R.id.btn_send)
        sendbtn.setOnClickListener(View.OnClickListener {
            var set_drink : EditText = findViewById(R.id.ed_drink)
            val drink = set_drink.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar", sugar)
            b.putString("drink", drink)
            b.putString("ice", iceopt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        })
    }
}