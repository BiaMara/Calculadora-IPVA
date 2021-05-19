package com.bianca.ipvacalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Abrindo tela de login após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //Após 3 segundos, iniciando uma intent - intenção de alguam coisa
            //Sai de splash e vai para tela de login
            val nIntent = Intent(this, EntradaActivity::class.java)
            startActivity(nIntent)
            finish()
        }, 4000)
    }
}