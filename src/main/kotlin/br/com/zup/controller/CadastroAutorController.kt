package br.com.zup.controller

import br.com.zup.dto.ModelAutorDTO
import br.com.zup.dto.ModelDetalhesAutorDTO
import br.com.zup.repository.AutorRepository
import io.micronaut.validation.Validated
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastroAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid modelAutorDTO: ModelAutorDTO): HttpResponse<Any>{
        val autor = modelAutorDTO.converte()
        autorRepository.save(autor)

        val uri = UriBuilder.of("/autores/{id}").expand(mutableMapOf(Pair("id", autor.id)))

        return HttpResponse.created(uri)

    }

    @Get
    fun lista(): HttpResponse<List<ModelDetalhesAutorDTO>>{
        val autores = autorRepository.findAll()
        val resposta = autores.map { autor ->  ModelDetalhesAutorDTO(autor)}

        return HttpResponse.ok(resposta)
    }

    @Put("/{id}")
    fun atualiza(@PathVariable id: Long, descricao: String): HttpResponse<Any>{
        val autor = autorRepository.findById(id)
        if(autor.isEmpty){
            return HttpResponse.notFound()
        }

        val novoAutor = autor.get()
        novoAutor.descricao = descricao
        autorRepository.update(novoAutor)

        return HttpResponse.ok(ModelDetalhesAutorDTO(novoAutor))
    }

    @Delete("/{id}")
    fun deleta(@PathVariable id: Long): HttpResponse<Any>{
        val autor = autorRepository.findById(id)
        
        if(autor.isEmpty){
            return HttpResponse.notFound()
        }
        val autorRemovido = autor.get()
        autorRepository.delete(autorRemovido)

        return HttpResponse.ok()
    }
}