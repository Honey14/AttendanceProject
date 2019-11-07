package com.honey.attendanceproject.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.honey.attendanceproject.R
import com.honey.attendanceproject.model.AttendanceItems
import kotlinx.android.synthetic.main.row_detail.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

internal class DetailAdapter(
    private val context: Context,
    private val lists: ArrayList<AttendanceItems>
) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.date.text = lists?.get(position)?.attendance_date
        if (lists?.get(position)?.attendance_status.equals("LT") ||
            lists?.get(position)?.attendance_status.equals("AB")
        ) {
            holder.status.text = lists?.get(position)?.attendance_status
            holder.status.setTextColor(Color.RED)

        } else if (lists?.get(position)?.attendance_status.equals("PR")) {
            holder.status.text = lists?.get(position)?.attendance_status
            holder.status.setTextColor(Color.GREEN)
        } else {
            holder.status.text = lists?.get(position)?.attendance_status
            holder.status.setTextColor(Color.YELLOW)
        }

        holder.intime.text = lists?.get(position)?.in_time
        holder.outtime.text = lists?.get(position)?.out_time
        holder.text_day.text = getDayFromMonth(position)
    }

    private fun getDayFromMonth(position1: Int): String {
        // get the day when you input the date
        var day : String
        val c = Calendar.getInstance()
        val dateformat = SimpleDateFormat("dd-MM-yyyy").parse(lists?.get(position1)?.attendance_date)
        c.time = dateformat // yourdate is an object of type Date
        val dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
        day = when(dayOfWeek) {
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "NA"
        }
        return day
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_detail,parent,false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (lists != null) {
            return lists.size
        }
        return 0
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date = itemView.text_attendance_value
        val status = itemView.text_attendance_status_value
        val intime = itemView.text_in_time_value
        val outtime = itemView.text_out_time_value
        val text_day = itemView.text_day
    }
}