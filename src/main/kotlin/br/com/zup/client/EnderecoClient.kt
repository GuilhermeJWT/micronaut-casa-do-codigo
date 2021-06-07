package br.com.zup.client

import br.com.zup.dto.ModelEnderecoDTO
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8081/cep/cep")
interface EnderecoClient {

    @Get("{cep}")
    fun consulta(cep: String): HttpResponse<ModelEnderecoDTO>

}