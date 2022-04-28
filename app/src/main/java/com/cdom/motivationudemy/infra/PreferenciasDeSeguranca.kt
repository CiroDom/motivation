package com.cdom.motivationudemy.infra

import android.content.Context
import android.content.SharedPreferences

class PreferenciasDeSeguranca(contexto: Context) {

    private val seguranca: SharedPreferences =
        contexto.getSharedPreferences("Nome do Shared Preference", Context.MODE_PRIVATE)

    fun armazenaString(chave: String, str: String){
        seguranca.edit().putString(chave, str).apply()
    }

    fun recebeString(chave: String): String {
        return seguranca.getString(chave, "") ?: ""
    }

}