package com.honey.attendanceproject.view

interface UserView {
    // presenter
    // interface will be implemented by the activity/ view
    fun showBothFieldsAreRequired()  // check if email and password is not empty

    fun getEmail() : String  // email to pass in api
    fun getPassword() : String // password to pass in api

    fun userNotFound() // show msg after api
    fun userLoggedIn() // show msg after api


}