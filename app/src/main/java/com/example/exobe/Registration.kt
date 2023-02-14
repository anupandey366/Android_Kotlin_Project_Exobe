package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.reset_pass.*
import kotlinx.android.synthetic.main.user_login.*

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)




        var f =true
        iv_visible1.setOnClickListener {
            if(f==true)
            {
                et_pass1.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_visible1.setImageResource(R.drawable.visibility_off)
                f=false
            }
            else
            {
                et_pass1.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_visible1.setImageResource(R.drawable.eye)
                f=true
            }
        }
        var f2 =true
        iv_convisible1.setOnClickListener {
            if(f2==true)
            {
                et_conpass1.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_convisible1.setImageResource(R.drawable.visibility_off)
                f2=false
            }
            else
            {
                et_conpass1.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_convisible1.setImageResource(R.drawable.eye)
                f2=true
            }
        }






        val maxFirstNLength = 12
        et_firstn.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxFirstNLength))
        val maxLastNLength = 12
        et_lastn.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLastNLength))
        val maxPhoneLength = 10
        et_phone1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))
        val maxEmailLength = 36
        et_email1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))
        val maxPassLength = 16
        et_pass1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPassLength))

        val maxConPassLength = 16
        et_conpass1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxConPassLength))


        supportActionBar?.hide()

        tv_already.setOnClickListener {
            val intent = Intent(this@Registration, UserLogin::class.java)
            startActivity(intent)
        }

       

        btn_register.setOnClickListener {
            validateRegistration()
        }
    }
    public fun validateRegistration()
    {

        if (et_firstn.text.isEmpty()) {
            val_firstn.isVisible = true
            
            val_firstn.text = "*Please enter First Name"
        }


        else if(!et_firstn.text.matches(".*^[A-Z]{1}.*".toRegex())){
            val_firstn.isVisible = true
            val_firstn.text = "*First letter must be in uppercase"
        }
        else if(et_firstn.text.length<3){
            val_firstn.isVisible = true
            val_firstn.text = "*Minimum 3 characters are allowed"

        }
        /*else if(!et_firstn.text.matches(".*[a-z].*".toRegex())){
            val_firstn.isVisible = true
            val_firstn.text = "*Password must have atleast one lowercase letter"
        }*/

        else if (et_lastn.text.isEmpty()) {
            val_lastn.isVisible = true
            
            val_lastn.text = "*Please enter Last Name"
        }
        else if(!et_lastn.text.matches(".*^[A-Z]{1}.*".toRegex())){
            val_lastn.isVisible = true
            val_lastn.text = "*First letter must be in uppercase"
        }
        else if(et_lastn.text.length<3){
            val_lastn.isVisible = true
            val_lastn.text = "*Minimum 3 characters are allowed"

        }
        

        else if (et_phone1.text.isEmpty()) {
            val_phone1.isVisible = true
            
            val_phone1.text = "*Please enter Phone Number"
        }
        else if (et_phone1.text.length<10){
            val_phone1.isVisible = true
//                mobileNumberTV.visibility = View.VISIBLE
            val_phone1.text = "*Please enter 10 digits phone number"
        }

       else if (et_email1.text.isEmpty()) {
            val_email1.isVisible = true
            
            val_email1.text = "*Please enter E-mail "
        }
        else if(!et_email1.text.matches(".*^[a-z0-9]+([.]{1}|[a-z0-9])+[@]{1}[a-z]+(.com|.in){1}$.*".toRegex())){
            val_email1.isVisible = true
            val_email1.text = "*Please enter valid email"
        }


        else if (et_pass1.text.isEmpty()) {
            val_pass1.isVisible = true
            
            val_pass1.text = "*Please enter Password"
        }

        else if(et_pass1.text.length<8){
            val_pass1.isVisible = true
            val_pass1.text = "*Minimum 8 characters are allowed"

        }
        else if(!et_pass1.text.matches(".*[A-Z].*".toRegex())){
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one uppercase letter"
        }
        else if(!et_pass1.text.matches(".*[a-z].*".toRegex())){
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one lowercase letter"
        }
        else if(!et_pass1.text.matches(".*[0-9].*".toRegex())){
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one number"
        }
        else if(!et_pass1.text.matches(".*[&@#$%^+=_.*].*".toRegex())){
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one special character"
        }
        
        

        else if (et_conpass1.text.isEmpty()) {
            val_conpass1.isVisible = true
            
            val_conpass1.text = "*Confirm password should be same with  the password field."
        }

        else if (et_conpass1.text.toString()!=et_pass1.text.toString()){
            val_conpass1.isVisible = true
            val_conpass1.text = "*New Password and Confirm password must be same"

        }

        else if (!cb_terms.isChecked()) {
            val_terms.isVisible = true
            
            val_terms.text = "Please accept terms and conditions. "
        } 
            

            else {
                val intent = Intent(this@Registration, UserLogin::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
