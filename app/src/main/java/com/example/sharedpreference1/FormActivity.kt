package com.example.sharedpreference1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*
import java.nio.file.Files.find

class FormActivity : AppCompatActivity() {
    lateinit var profilePref:ProfilePref
//    lateinit var etName: EditText
//    lateinit var etAge: EditText
//    lateinit var etGender: EditText
//    lateinit var btnsave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)




//        etAge=findViewById(R.id.etAge)
//        etGender=findViewById(R.id.etGender)
        profilePref= ProfilePref(this)
        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val profile = profilePref.getProfile()
            //etName.setText(profile.name)
            etNama.setText(profile.name)
            profile.age?.let { etAge.setText(it.toString()) }
            etGender.setText(profile.gender)


        }
       // btnsave=findViewById(R.id.btnsave)
        btnsave.setOnClickListener {
         val name = etNama.text.toString().trim()
            val age=etAge.text.toString().trim()
            val gender=etGender.text.toString().trim()

            val profile=Profile(
                    name,
                    age.toInt(),
                    gender


            )
            saveToPref(profile)
        }


    }

    private fun saveToPref(profile: Profile) {
profilePref.setProfile(profile)
        Toast.makeText(this,"Data Berhasil", Toast.LENGTH_SHORT).show()
        Intent(this,MainActivity::class.java).also {
            it.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}