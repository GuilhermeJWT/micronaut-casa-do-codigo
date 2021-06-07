package br.com.zup.controller

import br.com.zup.model.ModelCarro
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller
class CarrosController {

    @Post("/api/carros")
    fun cria(@Body @Valid modelCarro: ModelCarro): HttpResponse<Any>{
        return HttpResponse.ok(modelCarro)
    }

}