package com.example.modul4intentex5kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.modul4intentex5kotlin.modul.User
import java.lang.reflect.Member

class MainActivity : AppCompatActivity() {
    lateinit var tv_main: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    // Create the ActivityResultLauncher
    var secondLauncher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            // Retrieve the object from the detail activity
            val data = result.data
            if (data != null) {
                val member: Parcelable? = data.getParcelableExtra("member")
                tv_main.text = member.toString()
            }
        }
    }

    protected fun initView() {
        val b_open_second = findViewById<Button>(R.id.b_open_second)
        tv_main = findViewById<TextView>(R.id.tv_main)
        val user = User(20, "Jakhongir")
        b_open_second.setOnClickListener() {
            openSecondActivity(user)
        }
    }

    private fun openSecondActivity(user: User?) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        secondLauncher.launch(intent)
    }
}