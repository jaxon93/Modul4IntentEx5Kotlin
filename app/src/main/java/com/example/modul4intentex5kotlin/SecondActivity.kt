package com.example.modul4intentex5kotlin


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.modul4intentex5kotlin.modul.Member
import com.example.modul4intentex5kotlin.modul.User


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    fun initView() {
        val tv_second = findViewById<TextView>(R.id.tv_second)
        val b_exit_second = findViewById<Button>(R.id.b_exit_second)
        val user: User? = intent.getParcelableExtra("user")
        tv_second.text = user.toString()

        var member = Member(21, "Mirabbos")

        b_exit_second.setOnClickListener() {
            backToFinish(member)
        }
    }

    fun backToFinish(member: Member) {
        val returnIntent = Intent()
        returnIntent.putExtra("member", member)
        setResult(RESULT_OK, returnIntent)
        finish()
    }
}