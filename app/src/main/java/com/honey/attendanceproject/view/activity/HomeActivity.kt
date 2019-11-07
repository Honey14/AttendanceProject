package com.honey.attendanceproject.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.honey.attendanceproject.R
import kotlinx.android.synthetic.main.activity_home.*
import java.lang.Exception
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import android.content.Context
import android.view.WindowManager
import android.graphics.Point
import android.graphics.Typeface

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_ham)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        val typeface = Typeface.createFromAsset(assets, "fonts/rockb.ttf")
        textView.typeface = typeface

        try {
            val sharedPrefs = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            val tokenReceived = sharedPrefs.getString("token", "")
            val manager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = manager.defaultDisplay
            val point = Point()
            display.getSize(point)
            val width = point.x
            val height = point.y
            var smallerDimension = if (width < height) width else height
            smallerDimension = smallerDimension * 3 / 4
            val qrgEncoder =
                QRGEncoder(tokenReceived, null, QRGContents.Type.TEXT, smallerDimension)
            val bitmap = qrgEncoder.encodeAsBitmap()
            barcode.setImageBitmap(bitmap)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}