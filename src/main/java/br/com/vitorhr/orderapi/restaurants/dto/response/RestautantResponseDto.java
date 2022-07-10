package br.com.vitorhr.orderapi.restaurants.dto.response;

import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestautantResponseDto {
    private Long id;
    private String name;
    private String openingHours;
    private Long zipCodeAddress;
    private String streetAddress;
    private String additionalAddress;
    private String neighborhoodAddress;
    private String phone;

    public RestautantResponseDto(RestaurantEntity restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.openingHours = restaurant.getOpeningHours();;
        this.zipCodeAddress = restaurant.getZipCodeAddress();
        this.streetAddress = restaurant.getStreetAddress();
        this.additionalAddress = restaurant.getAdditionalAddress();
        this.neighborhoodAddress = restaurant.getNeighborhoodAddress();
        this.phone = restaurant.getPhone();
    }
}
