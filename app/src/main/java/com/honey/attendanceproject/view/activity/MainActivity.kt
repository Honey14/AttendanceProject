package com.honey.attendanceproject.view.activity

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
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

        val typeface = Typeface.createFromAsset(assets, "fonts/rockb.ttf")
        login.typeface = typeface
        enter_email.typeface = typeface
        enter_password.typeface = typeface
        button_go.typeface = typeface
        textlogo.typeface = typeface
        button_go.setOnClickListener {
            if (!TextUtils.isEmpty(enter_email.text) && !TextUtils.isEmpty(enter_password.text)) {
                progressBar.visibility = View.VISIBLE
                userPresenter.loginApi()
            } else {
                enter_email.error = "Please Enter Email"
                enter_password.error = "Please Enter Password"
            }
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

    override fun tryAgain() {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "Unable to log in with provided credentials.", Toast.LENGTH_LONG)
            .show()
    }

    override fun userNotFound() {
        progressBar.visibility = View.GONE
        Toast.makeText(this,"User not found",Toast.LENGTH_LONG).show()
    }

    override fun userLoggedIn(token : String) {
        Toast.makeText(this,"Login Success!",Toast.LENGTH_LONG).show()
        progressBar.visibility = View.GONE
        val sharedprefs = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        val editor = sharedprefs.edit()
        editor.putString("token", token)
        editor.putBoolean("loggedIn", false) // implement later by getting a splash screen
        editor.apply()

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
