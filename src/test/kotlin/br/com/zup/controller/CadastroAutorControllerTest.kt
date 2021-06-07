package br.com.zup.controller

import br.com.zup.client.EnderecoClient
import br.com.zup.dto.ModelAutorDTO
import br.com.zup.dto.ModelDetalhesAutorDTO
import br.com.zup.dto.ModelEnderecoDTO
import br.com.zup.model.ModelAutor
import br.com.zup.model.ModelEndereco
import br.com.zup.repository.AutorRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class CadastroAutorControllerTest{

    @field:Inject
    lateinit var autorRepository: AutorRepository

    lateinit var modelAutor: ModelAutor

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @field:Inject
    lateinit var enderecoClient: EnderecoClient

    //Antes de Iniciar
    @BeforeEach
    internal fun setUp() {
        val modelEnderecoDTO = ModelEnderecoDTO("Rua da Casa", "Caconde", "SP")
        val endereco = ModelEndereco(modelEnderecoDTO, "13770-000", "240")
        modelAutor = ModelAutor("Guilherme Santos", "gui@gmail.com", "Livro de Programação", endereco)

        autorRepository.save(modelAutor)
    }

    //Quando acabar
    @AfterEach
    internal fun tearDown(){
        autorRepository.deleteAll()
    }

    @Test
    fun `deve cadastrar um novo autor`(){
        //cenário
        val modelAutorDTO = ModelAutorDTO("Guilherme", "gui@teste", "Livro Teste", "13770-000", "299")

        val enderecoResponse = ModelEnderecoDTO("Rua das Flores", "Caconde", "SP")
        Mockito.`when`(enderecoClient.consulta(modelAutorDTO.cep)).thenReturn(HttpResponse.ok(enderecoResponse))

        val request = HttpRequest.POST("/autores", modelAutorDTO)
        //ação
        val resposta = client.toBlocking().exchange(request, Any::class.java)
        //Corretude
        assertEquals(HttpStatus.CREATED, resposta.status)
        assertTrue(resposta.headers.contains("Location"))
        assertTrue((resposta.header("Location")!!.matches("/autores/\\d".toRegex())))
    }

    @Test
    internal fun `deve retornar os detalhes de um autor`() {

        val response = client.toBlocking().exchange("/autores?email=${modelAutor.email}", ModelDetalhesAutorDTO::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        assertEquals(modelAutor.nome, response.body()!!.nome)
        assertEquals(modelAutor.email, response.body()!!.email)
        assertEquals(modelAutor.descricao, response.body()!!.descricao)
    }

    @MockBean(EnderecoClient::class)
    fun enderecoMock(): EnderecoClient{
        return Mockito.mock(EnderecoClient::class.java)
    }

}