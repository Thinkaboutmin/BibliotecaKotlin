package com.br.digitalhouse

data class Colecao(val lista:MutableList<Livro>,val codigo:Int,val preco:Double,val descricao:String) {

    fun verificaListaVazia(lista:MutableList<Livro>){
        if(lista.isEmpty())
            println("A lista está vazia ")
    }
    
}
