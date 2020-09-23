package com.br.digitalhouse

import java.time.LocalDate
import java.util.Date

fun gerarLivros(): MutableList<Livro> {
    val livros = mutableListOf<Livro>()
    val nomesAutores = arrayListOf(
        "Jomar Júnior",
        "Michele Sotto",
        "João Borges",
        "Stephani Torisu",
        "Arthur Araujo",
        ""
    )
    val nomesLivros = arrayListOf(
        "Matemática Pura",
        "Campeão",
        "", // Gera execção
        "Apreendendo Kotlin",
        "Desenvolvimento Rápido com Kanban e Scrum",
        "Como Ganhar Dinheiro",
    )
    val dataLancamento = arrayListOf(
        LocalDate.parse("2019-02-15"),
        LocalDate.parse("2017-05-14"),
        LocalDate.parse("2019-05-14"),
        LocalDate.parse("2016-06-24"),
        LocalDate.parse("2015-01-26")
    )

    val precos = arrayListOf(
        0.25,
        1.25,
        0.14,
        0,
        0.36
    )
    for (i in 0..5) {
        livros.add(
            Livro(
                i,
                nomesAutores[i % nomesAutores.size()],
                dataLancamento[i % dataLancamento.size()],
                i,
                precos[i % precos.size()],
                nomesLivros[i % nomesLivros.size()]
            )
        )

        erro = livros[i].validar()
        if (erro.isNotEmpty()) {
            println("Livro não aceito. Razão: $erro")
            livros.removeLast()
        }
    }

    return livros
}

fun gerarColecoes(listaColecoes: List<List<Livro>>): List<Colecao> {
    val precos = arrayListOf(
        0.45,
        0.36
    )
    val descricao = arrayListOf(
        "Lista suprema",
        "Rápido"
    )

    val colecoes = mutableListOf<Colecao>()
    for (i in 0..1) {
        colecoes.add(
            Colecao(
                colecoes[i],
                i,
                precos[i],
                descricao[i]
            )
        )

        val erro = colecoes[i].validar()
        if (erro.isNotEmpty()) {
            println("Coleção não aceita. Razão $erro")
            colecoes.removeLast()
        }
    }

    return colecoes
}

fun gerarUsuario(): Usuario {
    val sistema = Sistema()
    val usuario = Sistema(Usuario)

    return usuario
}

fun main() {
    val livros = gerarLivros()
    val colecoes = gerarColecoes(arrayListOf(
        arrayListOf(
            livros[0]
        ),
        arrayListOf(
            livros[1]
        )
    ))

    val usuario = gerarUsuario()

    for (livro in livros) {
        usuario.sistema.cadastrarLivro(livro)
    }
    for (colecao in colecoes) {
        usuario.sistema.cadastrarColecao(colecao)
    }

    // TODO: Finalizar o fluxo.
}