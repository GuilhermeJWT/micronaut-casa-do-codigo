package br.com.zup.model

import br.com.zup.dto.ModelEnderecoDTO
import javax.persistence.Embeddable

@Embeddable
class ModelEndereco (modelEnderecoDTO: ModelEnderecoDTO, val numero: String){

    val rua = modelEnderecoDTO.rua
    val cidade = modelEnderecoDTO.cidade
    val estado = modelEnderecoDTO.estado

}