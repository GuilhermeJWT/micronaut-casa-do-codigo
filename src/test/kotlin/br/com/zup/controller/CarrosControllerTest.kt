package br.com.zup.controller

import br.com.zup.model.ModelCarro
import br.com.zup.repository.CarroRepository
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(rollback = false, transactionMode = TransactionMode.SINGLE_TRANSACTION, transactional = false)
class CarrosControllerTest{

    //rollback = false =  ele vai deixar salvar no banco se o teste passar
    //TransactionMode.SINGLE_TRANSACTION = o BeforeEach e o @Test vão rodar na mesma transação
    //transactional = false o teste não vai comitar as transações

    @Inject
    lateinit var carroRepository: CarroRepository

    @BeforeEach
    fun setup(){
        carroRepository.deleteAll()
    }

    @AfterEach
    fun cleanUp(){
        carroRepository.deleteAll()
    }

    @Test
    internal fun `deve inserir um novo carro`() {
        //ação
        carroRepository.save(ModelCarro("Astra", "HPX-3487"))

        //validação
        assertEquals(1, carroRepository.count())
    }

    @Test
    internal fun `deve encontrar carro por placa`() {
        //cenário
        carroRepository.save(ModelCarro("Fiat Toro", "LJA-1387"))

        //ação
        val encontrado = carroRepository.existsByPlaca("LJA-1387")

        //validação
        assertTrue(encontrado)

    }
}