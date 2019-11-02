package com.honey.attendanceproject.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.honey.attendanceproject.R
import com.honey.attendanceproject.presenter.UserPresenterImpl
import com.honey.attendanceproject.view.UserView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , UserView{

lateinit var userPresenter  : UserPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userPresenter = UserPresenterImpl()
        userPresenter.setView(this) // this activity is an instance of userView
//        var email = enter_email.text
//        var password = enter_password.text
        button_go.setOnClickListener {
//            userPresenter.loginApi()
            var intent = Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userPresenter.resume()
    }

    override fun onPause() {
        super.onPause()
        userPresenter.pause()
    }

    override fun showBothFieldsAreRequired() {
        enter_email.error = "Please Enter Email"
        enter_password.error = "Please Enter Password"
    }

    override fun getEmail(): String {
        return enter_email.text.toString()
    }

    override fun getPassword(): String {
        return enter_password.text.toString()
    }

    override fun userNotFound() {
        Toast.makeText(this,"User not found",Toast.LENGTH_LONG).show()
    }

    override fun userLoggedIn() {
        Toast.makeText(this,"Login Success!",Toast.LENGTH_LONG).show()
    }
}
