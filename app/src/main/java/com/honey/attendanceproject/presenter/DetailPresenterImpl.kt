package com.honey.attendanceproject.presenter

import com.honey.attendanceproject.model.AttendanceItems
import com.honey.attendanceproject.presenter.retrofit.Interactor
import com.honey.attendanceproject.view.DetailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailPresenterImpl : DetailPresenter {

    private lateinit var view: DetailView

    override fun setView(view: DetailView) {
        this.view = view
    }

    override fun getAllAttendanceDetails(
        token: String,
        month: String,
        year: String,
        status: String
    ) {
        // adding url pending
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(Interactor::class.java)
        val call = service.getAttendanceDetails("Token $token", month, year, status)
        call.enqueue(object : Callback<ArrayList<AttendanceItems>> {
            override fun onFailure(call: Call<ArrayList<AttendanceItems>>, t: Throwable) {
                view.showEmpty()
            }

            override fun onResponse(
                call: Call<ArrayList<AttendanceItems>>,
                response: Response<ArrayList<AttendanceItems>>
            ) {
                val array = response.body()
                if (array != null) {
                    view.openRecyclerview(array)
                } else {
                    view.showEmpty()
                }
            }
        })
    }
}