package com.br.digitalhouse

import sun.security.ec.point.ProjectivePoint
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
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
        "",
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

    val precos = arrayListOf<Double>(
        0.25,
        1.25,
        -0.14,
        0.0,
        0.36
    )
    for (i in 0..5) {
        livros.add(
            Livro(
                i,
                nomesAutores[i % nomesAutores.size],
                Date.from(dataLancamento[i % dataLancamento.size].atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                i,
                precos[i % precos.size],
                nomesLivros[i % nomesLivros.size]
            )
        )
    }

    val livrosComErro = mutableListOf<Livro>()
    for (livro in livros) {
        val erro = livro.validar()
        if (erro.isNotEmpty()) {
            livrosComErro.add(livro)
            println("Livro não aceito. Razão: $erro")
        }
    }

    for (livroErro in livrosComErro) {
        livros.remove(livroErro)
    }

    return livros
}

fun gerarColecoes(listaColecoes: List<MutableList<Livro>>): List<Colecao> {
    val precos = arrayListOf(
        0.45,
        -0.36
    )
    val descricao = arrayListOf(
        "Lista suprema",
        "Rápido"
    )

    val colecoes = mutableListOf<Colecao>()
    for (i in 0..1) {
        colecoes.add(
            Colecao(
                listaColecoes[i],
                i,
                precos[i],
                descricao[i]
            )
        )

    }

    val colecaoComErro = mutableListOf<Colecao>()
    for (colecao in colecoes) {
        val erro = colecao.validar()
        if (erro.isNotEmpty()) {
            colecaoComErro.add(colecao)
            println("Coleção não aceita. Razão: $erro")
        }
    }

    for (colecaoErro in colecaoComErro) {
        colecoes.remove(colecaoErro)
    }

    return colecoes
}

fun gerarUsuario(): Usuario {
    val sistema = Sistema()
    val usuario = Usuario(sistema)

    return usuario
}

fun main() {
    val livros = gerarLivros()
    val colecoes = gerarColecoes(arrayListOf(
        mutableListOf(
            livros[0]
        ),
        mutableListOf(
            livros[1]
        )
    ))

    val usuario = gerarUsuario()

    for (livro in livros) {
        usuario.sistema.cadastrarLivro(livro)
    }
    // Erro de cadastro
    for (livro in livros) {
        usuario.sistema.cadastrarLivro(livro)
    }
    for (colecao in colecoes) {
        usuario.sistema.cadastrarColecao(colecao)
    }
    // Erro de cadastro
    for (colecao in colecoes) {
        usuario.sistema.cadastrarColecao(colecao)
    }

    val livroAVender = livros[1]
    val colecaoAVender = colecoes[0]

    if (usuario.sistema.consultarLivro(livroAVender.codigo) != null)
        usuario.sistema.efetuarVendaLivro(livroAVender.codigo)
    if (usuario.sistema.consultarColecao(colecaoAVender.codigo) != null)
        usuario.sistema.efetuarVendaColecao(colecaoAVender.codigo)
}