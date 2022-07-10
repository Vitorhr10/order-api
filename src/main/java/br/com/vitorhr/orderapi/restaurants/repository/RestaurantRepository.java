package br.com.vitorhr.orderapi.restaurants.repository;

import br.com.vitorhr.orderapi.restaurants.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
