package com.example.last.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.last.MainActivity
import com.example.last.R
import com.example.last.RegisterActivity
import com.example.last.ui.share.ShareFragment
import kotlinx.android.synthetic.main.fragment_home3.*
import kotlinx.android.synthetic.main.fragment_slideshow2.*

class Home3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home3)
        more.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(this@Home3, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

}
