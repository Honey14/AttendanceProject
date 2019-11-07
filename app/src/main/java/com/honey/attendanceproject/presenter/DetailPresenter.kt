package com.honey.attendanceproject.presenter

import com.honey.attendanceproject.view.DetailView

interface DetailPresenter {
    fun getAllAttendanceDetails(token : String, month : String, year : String, status : String)
    fun setView(view : DetailView)
}