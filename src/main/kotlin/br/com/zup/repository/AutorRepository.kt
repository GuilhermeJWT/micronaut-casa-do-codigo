package br.com.zup.repository

import br.com.zup.model.ModelAutor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository : JpaRepository<ModelAutor, Long> {

}