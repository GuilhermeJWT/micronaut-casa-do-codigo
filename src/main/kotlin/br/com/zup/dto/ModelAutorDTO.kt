package br.com.zup.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import kotlin.math.max

@Introspected
data class ModelAutorDTO (

    @field:NotBlank
    val nome: String,

    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank @field:Size(max = 400)
    val descricao: String

)