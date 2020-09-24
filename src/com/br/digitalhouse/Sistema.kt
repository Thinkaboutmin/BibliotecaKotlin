package com.br.digitalhouse

class Sistema(){
    private val livros =  mutableListOf<Livro>()
    private val colecoes =  mutableListOf<Colecao>()


    fun cadastrarLivro(livro: Livro){
        if (!livros.contains(livro)) {
            livros.add(livro)
        } else {
            println("Livro já cadastrado")
        }
    }

    fun cadastrarColecao(colecao: Colecao){
        if (!colecoes.contains(colecao)) {
            colecoes.add(colecao)
        } else {
            println("Coleção já cadastrada")
        }
    }

    fun consultarLivro(cod:Int): Livro? {
        val livro = livros.find { it.codigo == cod }

        return livro
    }

    fun consultarColecao(cod: Int): Colecao? {
        val colecao = colecoes.find {it.codigo == cod}

        return colecao
    }

    fun efetuarVendaLivro(cod: Int) {
        val livro = livros.find {it.codigo == cod}
        if (livro != null) {
            if (livro.quantidadeEmEstoque > 0) {
                --livro.quantidadeEmEstoque
                println("Livro vendido")
            } else {
                println("Livro esgotado.")
            }
        } else {
            println("Livro não disponivel")
        }
    }

    fun efetuarVendaColecao(cod: Int) {
        val colecao = colecoes.find {it.codigo == cod}
        if (colecao != null) {
            for (livro in colecao.lista) {
                if (livro.quantidadeEmEstoque > 0) {
                    --livro.quantidadeEmEstoque
                    println("Coleção vendida")
                } else {
                    println("Coleção esgotada")
                }
            }
        } else {
            println("Coleção não disponivel")
        }
    }
}