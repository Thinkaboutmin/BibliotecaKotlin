package com.br.digitalhouse



class Sistema(){

    val livros =  mutableListOf<Livro>()
    val colecoes =  mutableListOf<Colecao>()


    fun cadastrarLivro(livro: Livro){
        livros.add(livro)
        println("Novo livro adicionado na lista")
        println(livro)

    }

    fun cadastrarColecao(colecao: Colecao){
        colecoes.add(colecao)
        println("A colecao foi adicionada")
        println(colecoes)
    }

    fun consultarLivro(codigo: Int){
        println(livros.get(codigo))

    }

    fun consultarColecao(codigo: Int): Colecao{
        println(livros[codigo])
        return 0

    }

    fun efetuarVenda(codigo: Int): Int {
        return 0

    }
}