package br.com.vitorhr.orderapi.products.dto.response;

import br.com.vitorhr.orderapi.products.entity.ProductEntity;
import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer status;
    private Long restaurantId;

    public ProductResponseDto(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.status = product.getStatus();
        this.restaurantId = product.getRestaurant().getId();
    }
}
