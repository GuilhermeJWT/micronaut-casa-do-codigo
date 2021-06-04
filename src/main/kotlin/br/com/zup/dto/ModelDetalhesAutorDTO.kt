package br.com.zup.dto

import br.com.zup.model.ModelAutor

class ModelDetalhesAutorDTO(autor: ModelAutor) {

    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao

}