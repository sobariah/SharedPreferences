  package com.example.sharedpreference1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var profilePref: ProfilePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

profilePref = ProfilePref(this)
        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val profile = profilePref.getProfile()
            tvName.text= profile.name
            tvAge.text= profile.age.toString()
            tvGender.text= profile.gender



        }

      btnLogin.setOnClickListener {
          Intent(this, FormActivity::class.java).also {
              startActivity(it)
          }
      }
}
}