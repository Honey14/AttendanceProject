package com.honey.attendanceproject.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.honey.attendanceproject.R
import com.honey.attendanceproject.model.AttendanceItems

internal class DetailAdapter(
    private val context: Context,
    lists: ArrayList<AttendanceItems>
) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_detail,parent,false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}