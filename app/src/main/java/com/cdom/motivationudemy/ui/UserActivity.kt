package com.cdom.motivationudemy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cdom.motivationudemy.infra.PreferenciasDeSeguranca
import com.cdom.motivationudemy.R
import com.cdom.motivationudemy.databinding.ActivityUserBinding
import com.cdom.motivationudemy.infra.ConstantesMotivation

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bindingUser: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        bindingUser = ActivityUserBinding.inflate(layoutInflater)
        setContentView(bindingUser.root)

        bindingUser.buttonSalvar.setOnClickListener(this)

        verificarNomeUsuario()

    }

    override fun onClick(botao: View) {
        if (botao.id == R.id.button_salvar) {
            operarSave()
        }
    }

    private fun verificarNomeUsuario() {
        val nome = PreferenciasDeSeguranca(this).recebeString(ConstantesMotivation.KEY.nomeDoUsuario)
        if (nome != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun operarSave() {
        val nome = bindingUser.editNome.text.toString()
        if (nome != "") {
            PreferenciasDeSeguranca(this).armazenaString(ConstantesMotivation.KEY.nomeDoUsuario, nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Insira o nome", Toast.LENGTH_LONG)
        }
    }

}