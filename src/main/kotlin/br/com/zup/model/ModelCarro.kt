package br.com.zup.model

import br.com.zup.anotation.Placa
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class ModelCarro (

    @field:NotBlank val modelo: String?,
    @field:NotBlank @field:Placa val placa: String?)

{

}