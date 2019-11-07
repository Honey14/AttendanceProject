package com.honey.attendanceproject.view

import com.honey.attendanceproject.model.AttendanceItems

interface DetailView {
//    fun onSuccess()
//    fun onFailure()
    fun openRecyclerview(lists: ArrayList<AttendanceItems>?)
    fun showEmpty()
}