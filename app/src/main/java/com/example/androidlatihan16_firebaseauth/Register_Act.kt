package com.example.androidlatihan16_firebaseauth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register_act.*

class Register_Act : AppCompatActivity() {

    lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_act)
        fAuth = FirebaseAuth.getInstance()

        btn_reg.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            if (email.isNotEmpty() || password.isNotEmpty() || !email.equals("") || !password.equals("")) {
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "REGISTRASI BERHASIL", Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        } else {
                            Toast.makeText(this, "REGISTRASI GAGAL", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Email/password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

}