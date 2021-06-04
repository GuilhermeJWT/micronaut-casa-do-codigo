package br.com.zup.controller

import br.com.zup.dto.ModelAutorDTO
import br.com.zup.repository.AutorRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastroAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid modelAutorDTO: ModelAutorDTO){

        println("requisição: ${modelAutorDTO}")

        val autor = modelAutorDTO.converte()
        autorRepository.save(autor)

        println("Autor: ${autor.nome}")
    }

}