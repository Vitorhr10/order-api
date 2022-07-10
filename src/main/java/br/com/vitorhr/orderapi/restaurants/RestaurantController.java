package br.com.vitorhr.orderapi.restaurants;

import br.com.vitorhr.orderapi.restaurants.dto.request.CreateRestautantRequestDto;
import br.com.vitorhr.orderapi.restaurants.dto.request.UpdateResquestRestaurantDto;
import br.com.vitorhr.orderapi.restaurants.dto.response.RestautantResponseDto;
import br.com.vitorhr.orderapi.restaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestautantResponseDto createRestaurant(@RequestBody @Valid CreateRestautantRequestDto dto) {
        return new RestautantResponseDto(restaurantService.createRestaurant(dto));
    }

    @GetMapping
    public Page<RestautantResponseDto> findAllRestaurants(Pageable pageable) {
        return restaurantService.findAllRestaurants(pageable).map(RestautantResponseDto::new);
    }

    @GetMapping("/{id}")
    public RestautantResponseDto findRestaurantsById(@PathVariable Long id) {
        return new RestautantResponseDto(restaurantService.findRestaurantsById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
    }

    @PatchMapping("/{id}")
    public RestautantResponseDto updateRestaurantById(@PathVariable Long id, @RequestBody @Valid UpdateResquestRestaurantDto dto) {
        return new RestautantResponseDto(restaurantService.updateRestaurantById(id, dto));
    }
}
