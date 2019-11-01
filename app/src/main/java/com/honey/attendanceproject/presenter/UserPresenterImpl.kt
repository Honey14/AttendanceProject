package com.honey.attendanceproject.presenter

import android.text.TextUtils
import com.honey.attendanceproject.model.TokenModel
import com.honey.attendanceproject.view.UserView

class UserPresenterImpl : UserPresenter {
    private lateinit var view: UserView
    private lateinit var token: TokenModel

    override fun loginApi() {

        if(TextUtils.isEmpty(view.getEmail()) && TextUtils.isEmpty(view.getPassword()))
            view.showBothFieldsAreRequired()
        else
//         implement api
            hitLoginApi()
    }

    private fun hitLoginApi() {
        // after hitting the call savetoken here and store the token in shared preferences
        saveToken("")
        view.userLoggedIn()
        view.userNotFound()
    }

    override fun saveToken(token: String) {


    }

    override fun setView(view: UserView) {
        this.view = view
    }

    override fun pause() {

    }

    override fun resume() {
        loginApi()
    }
}