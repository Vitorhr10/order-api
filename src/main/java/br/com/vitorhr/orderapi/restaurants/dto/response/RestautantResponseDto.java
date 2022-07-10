package br.com.vitorhr.orderapi.restaurants.dto.response;

import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestautantResponseDto {
    private Long id;
    private String name;
    private Long zipCodeAddress;
    private String streetAddress;
    private String additionalAddress;
    private String neighborhoodAddress;
    private String phone;
    private Integer status;
    private Integer open;

    public RestautantResponseDto(RestaurantEntity restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.zipCodeAddress = restaurant.getZipCodeAddress();
        this.streetAddress = restaurant.getStreetAddress();
        this.additionalAddress = restaurant.getAdditionalAddress();
        this.neighborhoodAddress = restaurant.getNeighborhoodAddress();
        this.phone = restaurant.getPhone();
        this.status = restaurant.getStatus();
        this.open = restaurant.getOpen();
    }
}
