package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var btn: Button? = null
    private var tv_meal: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button= findViewById(R.id.btn_choice)
        btn.setOnClickListener(View.OnClickListener { startActivityForResult(Intent(this@MainActivity, MainActivity2::class.java), 1) })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var tvmeal : TextView = findViewById(R.id.tv_meal)
        if (data == null) return
        if (requestCode == 1) {
            if (resultCode == 101) {
                val b = data.extras
                val str1 = b!!.getString("drink")
                val str2 = b.getString("sugar")
                val str3 = b.getString("ice")
                tvmeal!!.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", str1, str2, str3)
            }
        }
    }
}