package com.cdom.motivationudemy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.cdom.motivationudemy.infra.ConstantesMotivation
import com.cdom.motivationudemy.infra.PreferenciasDeSeguranca
import com.cdom.motivationudemy.R
import com.cdom.motivationudemy.dados.Mock
import com.cdom.motivationudemy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bindingMain: ActivityMainBinding
    private var categoriaId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //chamar a main para a tela
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        // esconder a barra
        supportActionBar?.hide()

        //operações
        operarNomeUsuario()
        operarFiltro(R.id.image_infinito)
        operarNovaFrase()

        //eventos
        bindingMain.buttonNovaFrase.setOnClickListener(this)
        bindingMain.imageInfinito.setOnClickListener(this)
        bindingMain.imageSorriso.setOnClickListener(this)
        bindingMain.imageSol.setOnClickListener(this)
    } // fim do OnCreate

    //funções da main
    override fun onClick(viewEspecifica: View) {
        if (viewEspecifica.id == R.id.button_nova_frase){
            operarNovaFrase()
        } else if (viewEspecifica.id in listOf(R.id.image_infinito, R.id.image_sorriso, R.id.image_sol)) {
            operarFiltro(viewEspecifica.id)
        }
    }

    private fun operarNovaFrase() {
        val proximaFrase = Mock().receberFrase(categoriaId)
        bindingMain.textFrase.text = proximaFrase
    }

    private fun operarFiltro(idEspecifica: Int) {

        bindingMain.imageInfinito.setColorFilter(ContextCompat.getColor(this, R.color.purple_wine_2))
        bindingMain.imageSorriso.setColorFilter(ContextCompat.getColor(this, R.color.purple_wine_2))
        bindingMain.imageSol.setColorFilter(ContextCompat.getColor(this, R.color.purple_wine_2))

        when (idEspecifica) {
            R.id.image_infinito -> {
                bindingMain.imageInfinito.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoriaId = ConstantesMotivation.FILTER.INFINITO
            }
            R.id.image_sorriso -> {
                bindingMain.imageSorriso.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoriaId = ConstantesMotivation.FILTER.SORRISO
            }
            R.id.image_sol -> {
                bindingMain.imageSol.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoriaId = ConstantesMotivation.FILTER.SOL
            }
        }
    }

    private fun operarNomeUsuario() {
        val nome = PreferenciasDeSeguranca(this).recebeString(ConstantesMotivation.KEY.nomeDoUsuario)
        bindingMain.textOlaKotlin.text = "Olá, $nome!"
    }
} //fim da classe