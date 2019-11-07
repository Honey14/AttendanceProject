package com.honey.attendanceproject.presenter.retrofit

import com.honey.attendanceproject.model.AttendanceItems
import com.honey.attendanceproject.model.TokenModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Interactor {

    @FormUrlEncoded
    @POST("login/")
    fun goLogin(
        @Field("username") Username: String,
        @Field("password") Password: String
    ): Call<TokenModel>

    @GET("attendance/")
    fun getAttendanceDetails(
        @Header("Authorization") Authorization: String,
        @Query("month") month: String,
        @Query("year") year: String,
        @Query("attendance_status") attendance_status: String
    ): Call<ArrayList<AttendanceItems>>


}