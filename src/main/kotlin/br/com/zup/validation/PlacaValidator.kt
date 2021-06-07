package br.com.zup.validation

import br.com.zup.anotation.Placa
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton

@Singleton
class PlacaValidator : ConstraintValidator<Placa, String>{

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Placa>,
        context: ConstraintValidatorContext
    ): Boolean {
        // [A-Z]{3}[0-9][0-9A-Z]{2}

        if (value == null){
            return true
        }

        return value.matches("[A-Z]{3}[0-9][0-9A-Z]{2}".toRegex())
    }

}