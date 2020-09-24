package com.br.digitalhouse

data class Livro(val codigo: Int, val autor: String, val anoDeLancamento: java.util.Date, val quantidadeEmEstoque: Int, val preco: Double, val titulo: String) {
    fun validar() {
        if (this.preco < 0 || this.quantidadeEmEstoque < 0)
            return "Digite valores válidos"

    }
}
