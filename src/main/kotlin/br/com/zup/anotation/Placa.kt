package br.com.zup.anotation

import br.com.zup.validation.PlacaValidator
import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [PlacaValidator::class])
annotation class Placa(
    val message : String = "Placa com Formato Inválido"
)
