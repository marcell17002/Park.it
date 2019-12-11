package com.example.last.ui.slideshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.last.MainActivity
import com.example.last.R
import kotlinx.android.synthetic.main.fragment_slideshow1.*
import kotlinx.android.synthetic.main.fragment_slideshow2.*

class Slide2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_slideshow2)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        check_this_out.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(this@Slide2, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> {finish()}
        }
        return super.onOptionsItemSelected(item)
    }

}
