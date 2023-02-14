package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.forgot_pass.*
import kotlinx.android.synthetic.main.reset_pass.*
import kotlinx.android.synthetic.main.user_login.*

class ResetPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_pass)


        var f =true
        iv_visible3.setOnClickListener {
            if(f==true)
            {
                et_newpass3.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_visible3.setImageResource(R.drawable.visibility_off)
                f=false
            }
            else
            {
                et_newpass3.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_visible3.setImageResource(R.drawable.eye)
                f=true
            }
        }
        var f2 =true
        iv_convisible3.setOnClickListener {
            if(f2==true)
            {
                et_conpass3.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_convisible3.setImageResource(R.drawable.visibility_off)
                f2=false
            }
            else
            {
                et_conpass3.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_convisible3.setImageResource(R.drawable.eye)
                f2=true
            }
        }

        val maxPassLength = 16
        et_newpass3.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPassLength))
        /*Toast.makeText(this, "Password max length is 16 characters", Toast.LENGTH_SHORT).show()*/

        val maxConPassLength = 16
        et_conpass3.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxConPassLength))
//        Toast.makeText(this, "Confirm password must be same as password", Toast.LENGTH_SHORT).show()

        supportActionBar?.hide()

        var flag =false

        iv_arrow_back3.setOnClickListener {
            val intent = Intent(this@ResetPass,ForgotPass::class.java)
            startActivity(intent)
            finish()
        }

        btn_submit3.setOnClickListener {
            validatePassword()
        }

    }
    public fun validatePassword()
    {
        if (et_newpass3.text.isEmpty()){
            val_newpass3.isVisible = true
            val_newpass3.text = "Please enter password"

        }

        else if(et_newpass3.text.isEmpty()){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Please enter new password"

        }
        else if(et_newpass3.text.length<8){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Minimum 8 characters are allowed"

        }
        else if(!et_newpass3.text.matches(".*[A-Z].*".toRegex())){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Password must have atleast one uppercase letter"
        }
        else if(!et_newpass3.text.matches(".*[a-z].*".toRegex())){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Password must have atleast one lowercase letter"
        }
        else if(!et_newpass3.text.matches(".*[0-9].*".toRegex())){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Password must have atleast one number"
        }
        else if(!et_newpass3.text.matches(".*[&@#$%^+=_.*].*".toRegex())){
            val_newpass3.isVisible = true
            val_newpass3.text = "*Password must have atleast one special character"
        }

        else if (et_conpass3.text.isEmpty()){
            val_conpass3.isVisible = true
            val_conpass3.text = "*Please enter Confirm password"

        }
        else if (et_conpass3.text.toString()!=et_newpass3.text.toString()){
            val_conpass3.isVisible = true
            val_conpass3.text = "*New Password and Confirm password must be same"


        }

        else
        {
            val intent = Intent(this@ResetPass,UserLogin::class.java)
            startActivity(intent)
            finish()
        }
    }
}