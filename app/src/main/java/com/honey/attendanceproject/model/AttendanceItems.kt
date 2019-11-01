package com.honey.attendanceproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AttendanceItems(var id : Int,
                      var year : String,
                      var month : String,
                      var attendance_date : String,
                      var attendance_status : String,
                      var in_time : String,
                      var out_time : String,
                      var total_hours : String
                      ) : Parcelable