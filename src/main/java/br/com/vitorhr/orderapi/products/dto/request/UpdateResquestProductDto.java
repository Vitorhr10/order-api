package br.com.vitorhr.orderapi.products.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateResquestProductDto {
    @NotNull(message = "Nome é um parametro obrigatório.")
    @Size(min = 3, max = 250, message = "Nome deve ter entre 3 a 250 caracteres.")
    private String name;

    @NotNull(message = "Descrição é um parametro obrigatório.")
    @Size(min = 3, max = 250, message = "Horário de funcionamento deve ter entre 3 a 250 caracteres.")
    private String description;

    @NotNull(message = "Preço é um parametro obrigatório.")
    private BigDecimal price;

    @NotNull(message = "1-ativo ou 2-inativo é um parametro obrigatório.")
    private Integer status;
}
