package br.com.zup.controller

import br.com.zup.dto.ModelAutorDTO
import br.com.zup.dto.ModelDetalhesAutorDTO
import br.com.zup.repository.AutorRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
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

    @Get
    fun lista(): HttpResponse<List<ModelDetalhesAutorDTO>>{
        val autores = autorRepository.findAll()
        val resposta = autores.map { autor ->  ModelDetalhesAutorDTO(autor)}

        return HttpResponse.ok(resposta)
    }

}