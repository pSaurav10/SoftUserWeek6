package com.example.softuserassignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etPassword = findViewById(R.id.etPassword)
        etUsername = findViewById(R.id.etUsername)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if (etPassword.text.toString() == "coventry" && etUsername.text.toString() == "softwarica"){
                val intent = Intent(this@LoginActivity as Context, MainActivity::class.java)
                this@LoginActivity.startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(
                    this@LoginActivity as Context,
                    "Either Username or Password is Incorrect",
                    Toast.LENGTH_SHORT
                ).show()
                etUsername.error = "Username or Password is incorrect"
                etUsername.requestFocus()
            }
        }
    }
}