package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.forgot_pass.*
import kotlinx.android.synthetic.main.user_login.*

class ForgotPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_pass)

        val maxPhoneLength = 10
        et_phone2.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))
        /*Toast.makeText(this, "Phone number max length is 10 characters", Toast.LENGTH_SHORT).show()*/

        supportActionBar?.hide()

        iv_arrow_back2.setOnClickListener {
            val intent = Intent(this@ForgotPass,UserLogin::class.java)
            startActivity(intent)
            finish()
        }

        btn_submit2.setOnClickListener {
            validation_phone()
        }
    }
    public fun validation_phone(){
        if (et_phone2.text.isEmpty()){
            val_phone2.isVisible = true
            val_phone2.text = "*Please enter valid phone number."
        }
        else if (et_phone2.text.length<10){
            val_phone2.isVisible = true
            val_phone2.text = "*Please enter 10 digits phone number"
        }

        else
        {

            val intent = Intent(this@ForgotPass,ResetPass::class.java)
            startActivity(intent)
        }
    }
}