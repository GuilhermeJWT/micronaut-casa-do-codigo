package br.com.zup.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class ModelCarro (

    @field:NotBlank
    val modelo: String,

    @field:NotBlank
    @Column(unique = true)
    val placa: String
)

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}