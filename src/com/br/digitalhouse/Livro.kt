package com.br.digitalhouse

data class Livro(val codigo: Int, val autor: String, val anoDeLancamento: java.util.Date, var quantidadeEmEstoque: Int, val preco: Double, val titulo: String) {
    fun validar(): String {
        if (this.preco < 0 || this.quantidadeEmEstoque < 0 || autor.isEmpty() || titulo.isEmpty())
            return "Digite valores válidos"

        return ""
    }
}
