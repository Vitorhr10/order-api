package br.com.vitorhr.orderapi.products.dto;

import br.com.vitorhr.orderapi.products.entity.ProductEntity;
import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductToRestaurantDto {
    private ProductEntity product;
    private RestaurantEntity restaurant;
}
