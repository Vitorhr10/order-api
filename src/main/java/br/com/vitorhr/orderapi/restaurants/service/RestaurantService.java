package br.com.vitorhr.orderapi.restaurants.service;

import br.com.vitorhr.orderapi.restaurants.dto.request.CreateRestautantRequestDto;
import br.com.vitorhr.orderapi.restaurants.dto.request.UpdateResquestRestaurantDto;
import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import br.com.vitorhr.orderapi.restaurants.repository.RestaurantRepository;
import br.com.vitorhr.orderapi.util.exception.BadRequestException;
import br.com.vitorhr.orderapi.util.exception.NotFoundException;
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

    public Page<RestaurantEntity> findAllRestaurants(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    public RestaurantEntity findRestaurantsById(Long id) {
        if(id  == null || id == 0) throw new BadRequestException("O identificador do restaurante é obrigatório.");
        return restaurantRepository.findById(id).orElseThrow(() -> new NotFoundException( "Restaurante não encontrado."));
    }

    public void deleteRestaurantsById(Long id) {
        restaurantRepository.deleteById(id);
    }

    public RestaurantEntity updateRestaurantById(Long id, UpdateResquestRestaurantDto dto) {
        RestaurantEntity restaurant = findRestaurantsById(id);
        restaurant.updateFromDto(dto);
        return restaurantRepository.save(restaurant);
    }
}
