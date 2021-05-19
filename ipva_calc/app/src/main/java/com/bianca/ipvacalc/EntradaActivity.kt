package com.bianca.ipvacalc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EntradaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrada)

        //findViewById
        val spnEntradaEstado: Spinner = findViewById(R.id.spnEntradaEstado)
        val edtEntradaValor: EditText = findViewById(R.id.edtEntradaValor)
        val btnEntradaCalcular: Button = findViewById(R.id.btnEntradaCalcular)

        //Criando uma lista para o Spinner
        val listaEstado = arrayListOf("Selecione seu estado", "Acre", "Alagoas", "Amapá",
            "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás",
            "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba",
            "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
            "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins")


        //Criando um adaptador para o Spinner
        val estadoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listaEstado
        )

        // Plugando o adptador no spinner
        spnEntradaEstado.adapter = estadoAdapter

        //Executando o clique Calcular
       btnEntradaCalcular.setOnClickListener {

           //Capturando os dados digitados pelo usuario
           val estado = spnEntradaEstado.selectedItem.toString()
           val valor = edtEntradaValor.text.toString()


           //Validação dos campos
           if (estado.isEmpty() || valor.isEmpty()) {
               //Apresentando uma mensagem de erro ao usuário
               Toast.makeText(this, "Preencha os dados!", Toast.LENGTH_LONG).show()
           }else{

               //Todos os campos foram preenchidos
               val nIntent = Intent(this, MainActivity::class.java)
               nIntent.putExtra("ESTADO", estado)
               nIntent.putExtra("VALOR", valor)
               startActivity(nIntent)
           }
       }
    }
}