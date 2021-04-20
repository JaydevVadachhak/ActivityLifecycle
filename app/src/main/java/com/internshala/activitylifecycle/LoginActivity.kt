package com.internshala.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterYourself: TextView

    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("thanos","bruce","tony","widow","panther","thor","steve")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)

        if (isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)

        btnLogin.setOnClickListener {

            var nameOfAvenger = ""

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            val toast = Toast.makeText(this@LoginActivity, "Logged In", Toast.LENGTH_SHORT)

            if(etMobileNumber.text.toString() == validMobileNumber){
                when(etPassword.text.toString()){
                    validPassword[0] -> {
                        toast.show()
                        nameOfAvenger = "The Avengers"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[1] -> {
                        toast.show()
                        nameOfAvenger = "The Hulk"
                        savedPrefernces(nameOfAvenger)
                    }

                    validPassword[2] -> {
                        toast.show()
                        nameOfAvenger = "The Ironman"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[3] -> {
                        toast.show()
                        nameOfAvenger = "Natasha Romanvo"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[4] -> {
                        toast.show()
                        nameOfAvenger = "T'Challa"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[5] -> {
                        toast.show()
                        nameOfAvenger = "Thor Odinson"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }

                    validPassword[6] -> {
                        toast.show()
                        nameOfAvenger = "Captain America"
                        savedPrefernces(nameOfAvenger)
                        startActivity(intent)
                    }
                }
            }else{
                Toast.makeText(this@LoginActivity, "Invalid Credentials!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savedPrefernces(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

    override fun onClick(v: View?) {

    }
}