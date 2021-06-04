package br.com.zup.controller

import br.com.zup.dto.ModelAutorDTO
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastroAutorController {

    @Post
    fun cadastra(@Body @Valid modelAutorDTO: ModelAutorDTO){

        println("requisição: ${modelAutorDTO}")

        val autor = modelAutorDTO.converte()

        println("Autor: ${autor.nome}")
    }

}