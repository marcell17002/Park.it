package com.example.last.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.last.R
import android.widget.TextView
import android.app.DatePickerDialog
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import java.text.SimpleDateFormat
import android.view.View
import com.example.last.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*



class Home1 : AppCompatActivity() {
    private var datePickerDialog: DatePickerDialog? = null
    private var dateFormatter: SimpleDateFormat? = null
    private var tvDateResult: TextView? = null
    private var btDatePicker: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.last.R.layout.fragment_home1)
        dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)

        tvDateResult = findViewById(com.example.last.R.id.tv_dateresult) as TextView
        btDatePicker = findViewById(com.example.last.R.id.bt_datepicker) as Button
        btDatePicker!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                showDateDialog()
            }
        })
        find_out.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {
                // Handler code here.
                val intent = Intent(this@Home1, Home3::class.java)
                startActivity(intent)
            }
        })
    }
    private fun showDateDialog() {

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        val newCalendar = Calendar.getInstance()

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                val newDate = Calendar.getInstance()
                newDate.set(year, monthOfYear, dayOfMonth)

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult?.setText("Tanggal dipilih : " + dateFormatter?.format(newDate.time))
            },
            newCalendar.get(Calendar.YEAR),
            newCalendar.get(Calendar.MONTH),
            newCalendar.get(Calendar.DAY_OF_MONTH)
        )

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog!!.show()
    }

}
