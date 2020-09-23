package com.br.digitalhouse

data class Livro(val codigo: Int, val autor: String, val anoDeLancamento: java.util.Date, val quantidadeEmEstoque: Int, val preco: Double, val titulo: String) {

    fun verificarLivro(preco: Double, quantidadeEmEstoque: Int) {
        if (preco < 0 || quantidadeEmEstoque < 0)
            return "Digite valores válido"

    }
}