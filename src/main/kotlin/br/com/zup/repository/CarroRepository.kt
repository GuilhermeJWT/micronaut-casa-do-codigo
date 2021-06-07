package br.com.zup.repository

import br.com.zup.model.ModelCarro
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarroRepository: JpaRepository<ModelCarro, Long> {

    fun existsByPlaca(placa: String): Boolean

}