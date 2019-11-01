package com.honey.attendanceproject.presenter

import com.honey.attendanceproject.view.UserView

interface UserPresenter : LifeCyclePresenter {
    fun loginApi()
    fun saveToken(token : String)
    fun setView(view : UserView)
}