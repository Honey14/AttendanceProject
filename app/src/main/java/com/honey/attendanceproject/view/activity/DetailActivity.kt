package com.honey.attendanceproject.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.honey.attendanceproject.R
import com.honey.attendanceproject.model.AttendanceItems
import com.honey.attendanceproject.presenter.DetailPresenterImpl
import com.honey.attendanceproject.view.DetailView
import com.honey.attendanceproject.view.adapter.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() , DetailView {
    private val months = arrayOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )
    private val years = arrayOf(
        "2017",
        "2018",
        "2019",
        "2020",
        "2021",
        "2022",
        "2023",
        "2024",
        "2025",
        "2026",
        "2027"
    )
    lateinit var from: String
    override fun openRecyclerview(lists: ArrayList<AttendanceItems>?) {
        progressBar1.visibility = View.GONE
        if (lists != null && lists.size > 0) {
            text_empty.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = DetailAdapter(this, lists)
        } else {
            text_empty.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }
    }

    override fun showEmpty() {
        progressBar1.visibility = View.GONE
        Toast.makeText(this, "No Attendance Details Found", Toast.LENGTH_LONG).show()
    }

    lateinit var detailPresenter: DetailPresenterImpl
    var month_selected = ""
    var year_selected = ""
    lateinit var month: String
    lateinit var year: String
    private lateinit var tokenReceived: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detailPresenter = DetailPresenterImpl()
        detailPresenter.setView(this)
        val intent = intent
        if (intent != null) from = intent.getStringExtra("from")

        val prefs = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        tokenReceived = prefs.getString("token", "").toString()
        progressBar1.visibility = View.VISIBLE
        detailPresenter.getAllAttendanceDetails(tokenReceived, "November", "2019", from)
    }
}
