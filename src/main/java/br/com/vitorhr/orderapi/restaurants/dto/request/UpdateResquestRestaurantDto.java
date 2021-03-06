package br.com.vitorhr.orderapi.restaurants.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateResquestRestaurantDto {
    @NotNull(message = "Nome é um parametro obrigatório.")
    @Size(min = 3, max = 250, message = "Nome deve ter entre 3 a 250 caracteres.")
    private String name;

    @NotNull(message = "Cep é um parametro obrigatório.")
    private Long zipCodeAddress;

    @NotNull(message = "Endereço é um parametro obrigatório.")
    @Size(min = 3, max = 250, message = "Endereço deve ter entre 3 a 250 caracteres.")
    private String streetAddress;

    private String additionalAddress;

    @NotNull(message = "Bairro é um parametro obrigatório.")
    @Size(min = 3, max = 250, message = "Bairro deve ter entre 3 a 250 caracteres.")
    private String neighborhoodAddress;

    @NotNull(message = "Telefone é um parametro obrigatório.")
    @Size(min = 8, max = 15, message = "Telefone deve ter entre 3 a 15 caracteres.")
    private String phone;

    @NotNull(message = "1-ativo ou 2-inativo é um parametro obrigatório.")
    private Integer status;

    @NotNull(message = "1-aberto ou 2-fechado é um parametro obrigatório.")
    private Integer open;
}
