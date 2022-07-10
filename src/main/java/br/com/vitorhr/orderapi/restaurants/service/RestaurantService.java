package br.com.vitorhr.orderapi.restaurants.service;

import br.com.vitorhr.orderapi.restaurants.dto.request.CreateRestautantRequestDto;
import br.com.vitorhr.orderapi.restaurants.dto.response.RestautantResponseDto;
import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import br.com.vitorhr.orderapi.restaurants.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantEntity createRestaurant(CreateRestautantRequestDto dto) {
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .name(dto.getName())
                .additionalAddress(dto.getAdditionalAddress())
                .openingHours(dto.getOpeningHours())
                .neighborhoodAddress(dto.getNeighborhoodAddress())
                .zipCodeAddress(dto.getZipCodeAddress())
                .phone(dto.getPhone())
                .streetAddress(dto.getStreetAddress())
                .createdAt(LocalDateTime.now())
                .build();
        return restaurantRepository.save(restaurant);
    }

    public Page<RestaurantEntity> getAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

}
