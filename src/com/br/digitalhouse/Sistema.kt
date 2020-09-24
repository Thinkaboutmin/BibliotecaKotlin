package com.br.digitalhouse



class Sistema(){

    private val listaLivro =  mutableListOf<Livro>()
    private val listaColecoes =  mutableListOf<Colecao>()


    fun cadastrarLivro(livro: Livro){
        listaLivro.add(livro)

    }

    fun cadastrarColecao(colecao: Colecao){
        listaColecoes.add(colecao)

    }

    fun consultarLivro(cod:Int) {
        this.listaLivro.forEach {
            when (it.codigo == cod) {

            }
            println(it)

            }

    fun consultarColecao(cod: Int){

        this.listaColecoes.forEach {
            when (it.codigo == cod) {

            }
            println(it)


    fun efetuarVenda(cod: Int) {

        this.listaLivro.forEach{
            when (it.codigo == cod) {
                true -> {
                    when (it.quantidadeEmEstoque <= 0) {
                        true -> {
                            println("Produto esgotado")
                        }
                    }
                }

                false -> {
                    it.quantidadeEmEstoque--
                }


            }
        }
                }
            }
        }
    }
}