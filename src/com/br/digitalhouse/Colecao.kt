package com.br.digitalhouse

data class Colecao(val lista:MutableList<Livro>,val codigo:Int,val preco:Double,val descricao:String) {

    fun verificarColecao():String{
        if (this.lista.isEmpty()) {
            return "A lista está vazia"
        } else
            return ""

        if (this.codigo < 0){
            return "Codigo inválido"
        } else
            return ""

        if (this.preco < 0) {
            return "O preco está negativo"
        } else
        return ""

        if (this.descricao.isEmpty()){
            return "A descrição está vazia"
        }else
            return ""

    }


}
