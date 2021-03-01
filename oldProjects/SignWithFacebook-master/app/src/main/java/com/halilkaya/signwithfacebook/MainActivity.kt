package com.halilkaya.signwithfacebook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginResult
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    //Hexadecimal -> base64 string decoder
    //https://tomeko.net/online_tools/hex_to_base64.php

    var callbackManager:CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FacebookSdk.sdkInitialize(applicationContext)


        callbackManager = CallbackManager.Factory.create()

        login_button.registerCallback(callbackManager,object : FacebookCallback<LoginResult>{

            override fun onSuccess(result: LoginResult?) {
                handleFacebookAccessToken(result?.accessToken)
            }

            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException?) {
                TODO("Not yet implemented")
            }


        })


    }




    fun handleFacebookAccessToken(result:AccessToken?){

        var credential = FacebookAuthProvider.getCredential(result?.token!!)

        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(p0: Task<AuthResult>) {

                    if(p0.isSuccessful){
                        println("kayit basarili")
                    }else{
                        println("kayit basarisiz")
                    }

                }

            })


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager?.onActivityResult(requestCode,resultCode,data)

        super.onActivityResult(requestCode, resultCode, data)
    }







}
