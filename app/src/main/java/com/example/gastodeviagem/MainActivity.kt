package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener(this)
    }

    //Usando função de click
    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            //Chamando função calcular
            calcute()
        }

    }

    private fun calcute() {

        if (validationOk()) {

            try {
                // Incluindo valores do ID em variaveis
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                //Calculando o valor total gasto
                val totalValue = (distance * price) / autonomy

                //Inserindo e formatando o valor no text
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (nfe: java.lang.NumberFormatException) {
                Toast.makeText(this, getString(R.string.numeros_validos), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.Preencha_tds_campos), Toast.LENGTH_LONG).show()
        }
    }

    //Função paravalidar se os campos não estão vazios
    private fun validationOk(): Boolean = (editDistance.text.toString() != ""
            && editPrice.text.toString() != ""
            && editAutonomy.text.toString() != "")

}