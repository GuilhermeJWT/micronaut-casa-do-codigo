package br.com.zup.controller

import br.com.zup.dto.ModelAutorDTO
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller
class CadastroAutorController {

    @Post
    fun cadastra(@Body modelAutorDTO: ModelAutorDTO){
        println(modelAutorDTO)
    }

}