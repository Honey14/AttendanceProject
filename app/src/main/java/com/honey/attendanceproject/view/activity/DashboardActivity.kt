package com.honey.attendanceproject.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.honey.attendanceproject.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity()  , View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cardView -> {
                goToDash("") // all details
            }
            R.id.cardView1 ->{
//                goToDash("working")
            }
            R.id.cardView2 ->{
                goToDash("PR") // present
            }
            R.id.cardView3 ->{
                goToDash("LT") // late
            }
            R.id.cardView5 ->{
                goToDash("HD") // half day
            }
            R.id.cardView6 ->{
                goToDash("AB") // absent
            }
            else -> {
                goToDash("")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cardView.setOnClickListener(this)
        cardView1.setOnClickListener(this)
        cardView2.setOnClickListener(this)
        cardView3.setOnClickListener(this)
        cardView5.setOnClickListener(this)
        cardView6.setOnClickListener(this)
    }

    private fun goToDash(from : String){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("from",from)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                val preferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.clear()
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}
