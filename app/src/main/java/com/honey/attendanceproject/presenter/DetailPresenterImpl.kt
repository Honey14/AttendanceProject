package com.honey.attendanceproject.presenter

import com.honey.attendanceproject.model.AttendanceItems
import com.honey.attendanceproject.view.DetailView


class DetailPresenterImpl : DetailPresenter {

    private lateinit var view: DetailView

    override fun setView(view: DetailView) {
        this.view = view
    }

    override fun getAllAttendanceDetails(token: String, month : String, year : String, status : String) {
        view.showEmpty()

//        view.openRecyclerview()

    }
}