package br.com.vitorhr.orderapi.products.repository;

import br.com.vitorhr.orderapi.products.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
