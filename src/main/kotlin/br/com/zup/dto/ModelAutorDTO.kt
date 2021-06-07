package br.com.zup.dto

import br.com.zup.model.ModelAutor
import br.com.zup.model.ModelEndereco
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class ModelAutorDTO (

    @field:NotBlank
    val nome: String,

    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank @field:Size(max = 400)
    val descricao: String,

    @field:NotBlank val cep: String,

    @field:NotBlank val numero: String

) {
    fun converte(modelEnderecoDTO: ModelEnderecoDTO): ModelAutor {
        val endereco = ModelEndereco(modelEnderecoDTO, numero)
        return ModelAutor(nome, email, descricao, endereco)
    }
}