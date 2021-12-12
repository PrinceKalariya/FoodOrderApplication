package com.example.foodorderingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.foodorderingapplication.Login_Signup.Companion.Name
import com.example.foodorderingapplication.Login_Signup.Companion.Email
import com.example.foodorderingapplication.Login_Signup.Companion.Password
import com.example.foodorderingapplication.Login_Signup.Companion.Phone
import com.example.foodorderingapplication.Login_Signup.Companion.Conform_Password

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val signup_button = findViewById<Button>(R.id.btn_signup)
        val signup_name = findViewById<EditText>(R.id.et_signup_name)
        val signup_email = findViewById<EditText>(R.id.et_signup_email)
        val signup_number = findViewById<EditText>(R.id.et_signup_no)
        val signup_password = findViewById<EditText>(R.id.et_signup_password)
        val signup_conform_password = findViewById<EditText>(R.id.et_signup_con_pass)
        val already_account = findViewById<TextView>(R.id.tv_al_acc)


        already_account.setOnClickListener {
            Intent(this, Login::class.java).apply { startActivity(this) }
        }

        signup_button.setOnClickListener {

            Name = signup_name.text.toString()
            Email = signup_email.text.toString().trim()
            Phone = signup_number.text.toString()
            Password = signup_password.text.toString()
            Conform_Password = signup_conform_password.text.toString()

            val emailpattern = "[a-zA-Z0-9._-]+@['a-z']+\\.+['a-z']+"

            if(Name.isEmpty())
            {
                signup_name.error = "Name Require"
            }
            else if(Email.isEmpty() || Email.isNotEmpty())
            {
                if(Email.isEmpty())
                {
                    signup_email.error = " Valid Email Require"
                }
                    else if(Email.matches(emailpattern.toRegex()))
                    {
                        if(Phone.length != 10)
                        {
                            signup_number.error = "Valid Number Require"
                        }
                        else if(Password.length <= 8)
                        {
                            signup_password.error = "Valid Password Require"
                        }
                        else if(Conform_Password.isEmpty())
                        {
                            signup_conform_password.error = "Valid Conform Password Require"
                        }
                        else
                        {
                            if(Password == Conform_Password)
                            {
                                Intent(this, Login::class.java).apply {
                                    startActivity(this)
                                }
                            }
                            else
                            {
                                Toast.makeText(applicationContext, "Password and Confirm Password doesn't match", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    else
                    {
                        signup_email.error = " Valid Email Require"
                    }

            }


        }
    }
}