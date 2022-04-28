package com.cdom.motivationudemy.dados

import com.cdom.motivationudemy.infra.ConstantesMotivation
import kotlin.random.Random

data class Frase(val descricao: String, val IdCategoria: Int){

}

class Mock {

    private val infinito = ConstantesMotivation.FILTER.INFINITO
    private val sorriso = ConstantesMotivation.FILTER.SORRISO
    private val sol = ConstantesMotivation.FILTER.SOL

    private val mListFrases = listOf<Frase>(
        //sorriso
        Frase("Não sabendo que era impossível, foi lá e fez", sorriso),
        Frase("Você não é derrotado quando perde, apenas quando desiste", sorriso),
        Frase("É quando está mais escuro que vemos as mais belas estrelas", sorriso),
        Frase("O que voê pode fazer agora que tem maior impacto no seu sucesso?", sorriso),

        //sol
        Frase("A melhor maneira de prever o futuro é criá-lo", sol),
        Frase("Você perde toda luta que abandona", sol),
        Frase("Você perde toda chance que não aproveita", sol),
        Frase("Não é sobre motivação, é sobre disciplina", sol)
    )

    fun receberFrase(valor: Int): String {
        val listaFiltrada = mListFrases.filter {it.IdCategoria == valor || valor == infinito}
        val index = Random.nextInt(listaFiltrada.size)

        return listaFiltrada[index].descricao
    }
}