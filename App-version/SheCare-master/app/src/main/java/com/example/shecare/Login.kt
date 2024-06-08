package com.example.shecare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.example.shecare.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    //declaration of the views
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        //to initialise firebase only
        mAuth= FirebaseAuth.getInstance()
        // initialisation of the views
        edtEmail=findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btnLogin=findViewById(R.id.btn_login)
        btnSignUp=findViewById(R.id.btn_signup)


        //to redirect to the SignUp page
        btnSignUp.setOnClickListener {
            //create an intent to launch the activity
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)

        }

        btnLogin.setOnClickListener {
            //to accept or read the email and password
            val email=edtEmail.text.toString()
            val password= edtPassword.text.toString()

            login(email,password) //function to check the login credentials


        }
    }
    //code for the login function to work
    private fun login(email: String,password: String){
        //logic for logging in a user
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                Toast.makeText(this, "Task processed", Toast.LENGTH_SHORT).show()
                if (task.isSuccessful) {
                    // code for logging in a user
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                    //code for jumping to home activity
                    val intent = Intent(this,MainActivity ::class.java)
                    startActivity(intent)
                } else {
                    //to display error
                    Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{ exception ->
                Toast.makeText(this,exception.toString(), Toast.LENGTH_SHORT).show()
            }
    }

}