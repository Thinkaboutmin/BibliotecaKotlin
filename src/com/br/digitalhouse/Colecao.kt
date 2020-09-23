package com.br.digitalhouse

data class Colecao(val lista:MutableList<Livro>,val codigo:Int,val preco:Double,val descricao:String) {

    fun validar():String{
        if (this.lista.isEmpty()) {
            return "A lista está vazia"
        } else if (this.codigo < 0){
            return "Codigo inválido"
        } else if (this.preco < 0) {
            return "O preco está negativo"
        } else if (this.descricao.isEmpty()){
            return "A descrição está vazia"
        }else
            return ""
    }

}
