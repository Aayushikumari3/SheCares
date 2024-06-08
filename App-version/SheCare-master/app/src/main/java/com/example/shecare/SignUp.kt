package com.example.shecare

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class SignUp : AppCompatActivity() {

    //declaration of the views
    private lateinit var edtName : EditText
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnSignUp : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        //to initialise firebase only
        mAuth= FirebaseAuth.getInstance()
        // initialisation of the views
        edtName=findViewById(R.id.edt_name)
        edtEmail=findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btnSignUp=findViewById(R.id.btn_signup)


        btnSignUp.setOnClickListener {
            //to accept or read the email and password
            val email=edtEmail.text.toString()
            val password= edtPassword.text.toString()

            signup(email, password) //function to check the login credentials

        }
    }

    //code for the signup function to work
    private fun signup(email: String,password: String) {
        //logic for creating a user
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                Toast.makeText(this, "Task processed", Toast.LENGTH_SHORT).show()
                if (task.isSuccessful) {
                    //code for jumping to home activity
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    //to display error message
                    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener{ exception ->
                Toast.makeText(this,exception.toString(), Toast.LENGTH_SHORT).show()
            }
    }

}