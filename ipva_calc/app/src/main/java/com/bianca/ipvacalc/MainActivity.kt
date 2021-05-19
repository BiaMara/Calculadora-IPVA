package com.bianca.ipvacalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaAliquota = arrayListOf(0.02, 0.025, 0.03, 0.035, 0.04)

        //findViewById
        val txvMainEstado: TextView = findViewById(R.id.txvMainEstado)
        val txvMainAliquota: TextView = findViewById(R.id.txvMainAliquota)
        val txvMainIpva: TextView = findViewById(R.id.txvMainIpva)
        val btnMainRecalcular: Button = findViewById(R.id.btnMainRecalcular)


        //Recuperando o estado através da Intent
        val estado = intent.getStringExtra("ESTADO")
        val valor = intent.getStringExtra("VALOR")

        val valor_numero = valor.toString().toDouble()

    //Definindo alíquota
       val aliquota = if(estado == "Santa Catarina" || estado == "Espírito Santo" || estado == "Sergipe" ||
            estado == "Paraíba" || estado == "Acre" || estado == "Tocantins"){
            listaAliquota[0]
        }else if (estado == "Alagoas" || estado ==  "Pernambuco" || estado == "Rio Grande do Norte" ||
            estado == "Ceará" || estado == "Piauí" || estado == "Maranhão" || estado == "Bahia" ||
            estado == "Pará" || estado == "Mato Grosso do Sul" || estado == "Goiás"){
            listaAliquota[1]
        }else if (estado == "Rio Grande do Sul" || estado == "São Paulo" || estado == "Amapá" ||
           estado == "Amazonas" || estado == "Roraima" || estado == "Rondônia" || estado == "Mato Grosso" ||
           estado == "Distrito Federal"){
           listaAliquota[2]
       }else if (estado == "Paraná"){
           listaAliquota[3]
       }else {
           listaAliquota[4]
       }

        //Calculando IPVA

        val ipva = valor_numero * aliquota
        val ipva_int = ipva.toInt()
        val aliquota_perc = aliquota * 100

        //Exibindo os dados recuperados na tela
        txvMainEstado.text = estado
        txvMainAliquota.text = "$aliquota_perc%"
        txvMainIpva.text = "R$$ipva_int,00"

        btnMainRecalcular.setOnClickListener {
            val nIntent = Intent(this, EntradaActivity::class.java)
            startActivity(nIntent)
        }
    }
}