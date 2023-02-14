package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.exobe.databinding.UserLoginBinding
import kotlinx.android.synthetic.main.user_login.*

class UserLogin : AppCompatActivity() {

    lateinit var binding: UserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)


        var f =true
        iv_visible0.setOnClickListener {
            if(f==true)
            {
                et_pass0.transformationMethod=HideReturnsTransformationMethod.getInstance()
                iv_visible0.setImageResource(R.drawable.visibility_off)
                f=false
            }
            else
            {
                et_pass0.transformationMethod=PasswordTransformationMethod.getInstance()
                iv_visible0.setImageResource(R.drawable.eye)
                f=true
            }
        }




        val maxPhoneLength = 10
        et_phone0.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))
        /*Toast.makeText(this, "Phone number max length is 10 characters", Toast.LENGTH_SHORT).show()
*/
        val maxPassLength = 16
        et_pass0.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPassLength))
        /*Toast.makeText(this, "Password max length is 16 characters", Toast.LENGTH_SHORT).show()*/

        supportActionBar?.hide()

        tv_forgot.setOnClickListener {
            val intent = Intent(this@UserLogin,ForgotPass::class.java)
            startActivity(intent)
        }

        tv_register0.setOnClickListener {
            val intent = Intent(this@UserLogin,Registration::class.java)
            startActivity(intent)
        }

        var flag =false

        btn_login.setOnClickListener {

            //et_pass0.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            validations()
            
        }
        
    }
    public fun validations():Editable?
    {
        if (et_phone0.text.isEmpty()){
            val_phone0.isVisible = true
//                mobileNumberTV.visibility = View.VISIBLE
            val_phone0.text = "*Please enter valid phone number"
        }
        else if (et_phone0.text.length<10){
            val_phone0.isVisible = true
//                mobileNumberTV.visibility = View.VISIBLE
            val_phone0.text = "*Please enter 10 digits phone number"
        }

        else if(et_pass0.text.isEmpty()){
            val_pass0.isVisible = true
            val_pass0.text = "*Please enter valid password"

        }
        else if(et_pass0.text.length<8){
            val_pass0.isVisible = true
            val_pass0.text = "*Minimum 8 characters are allowed"

        }
        else if(!et_pass0.text.matches(".*[A-Z].*".toRegex())){
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one uppercase letter"
        }
        else if(!et_pass0.text.matches(".*[a-z].*".toRegex())){
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one lowercase letter"
        }
        else if(!et_pass0.text.matches(".*[0-9].*".toRegex())){
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one number"
        }
        else if(!et_pass0.text.matches(".*[&@#$%^+=_.*].*".toRegex())){
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one special character"
        }




        else
        {val_phone0.isVisible = false
            val_pass0.isVisible = false
            val intent = Intent(this@UserLogin,Home::class.java)
            startActivity(intent)
            finish()
        }


        return null

    }
    public fun funn(){
        binding.etPhone0.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus)
            {
                binding.etPhone0.text=validations()
            }
        }
    }
}