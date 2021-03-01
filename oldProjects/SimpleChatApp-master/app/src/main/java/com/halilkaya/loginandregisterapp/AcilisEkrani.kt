package com.halilkaya.loginandregisterapp

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import kotlinx.android.synthetic.main.activity_acilis_ekrani.*

class AcilisEkrani : AppCompatActivity() {

    lateinit var mAuthStateListener:FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acilis_ekrani)
        initAuthStateListener()



        btnGirisYap.setOnClickListener {

            var options = ActivityOptions.makeSceneTransitionAnimation(this@AcilisEkrani)
            var intent = Intent(this,GirisEkrani::class.java)
            startActivity(intent,options.toBundle())

        }

        btnKaydol.setOnClickListener {

            var options = ActivityOptions.makeSceneTransitionAnimation(this@AcilisEkrani)
            var intent = Intent(this,KayitEkrani::class.java)
            startActivity(intent,options.toBundle())

        }


    }





    fun initAuthStateListener(){


        mAuthStateListener = object : FirebaseAuth.AuthStateListener{

            override fun onAuthStateChanged(p0: FirebaseAuth) {

                if(!KayitEkrani.kayitEkraniAcikMi){

                var kullanici = p0.currentUser
                if(kullanici != null){

                    var options = ActivityOptions.makeSceneTransitionAnimation(this@AcilisEkrani)
                    var intent = Intent(this@AcilisEkrani, MainActivity::class.java)
                    startActivity(intent,options.toBundle())
                    finish()

                }

            }


            }


        }

    }


    override fun onStart() {
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener)
        super.onStart()
    }

    override fun onDestroy() {
        FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener)
        super.onDestroy()
    }



}
