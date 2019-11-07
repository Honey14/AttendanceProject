package com.honey.attendanceproject.presenter

import android.text.TextUtils
import com.honey.attendanceproject.model.TokenModel
import com.honey.attendanceproject.presenter.retrofit.Interactor
import com.honey.attendanceproject.view.UserView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserPresenterImpl : UserPresenter {
    private lateinit var view: UserView
    override fun loginApi() {

        if (TextUtils.isEmpty(view.getEmail()) && TextUtils.isEmpty(view.getPassword()))
            view.showBothFieldsAreRequired()
        else
//         implement api
            hitLoginApi(view.getEmail(), view.getPassword())
    }

    private fun hitLoginApi(email: String, password: String) {
        // after hitting the call savetoken here and store the token in shared preferences
        // adding api link is pending
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(Interactor::class.java)
        val call = service.goLogin(email, password)
        call.enqueue(object : Callback<TokenModel> {
            override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                view.userNotFound()
            }

            override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {
                if (response.code() == 200) {
                    var token = response.body()?.token

                    if (token != null) {
                        view.userLoggedIn(token)
                        saveToken(token)
                    }

                } else if (response.code() == 400) {
                    view.tryAgain()
                }
            }

        })
    }

    override fun saveToken(token: String) {
    }

    override fun setView(view: UserView) {
        this.view = view
    }

    override fun pause() {

    }

    override fun resume() {
    }
}