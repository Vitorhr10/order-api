package br.com.vitorhr.orderapi.products.service;

import br.com.vitorhr.orderapi.products.dto.request.CreateProductRequestDto;
import br.com.vitorhr.orderapi.products.dto.request.UpdateResquestProductDto;
import br.com.vitorhr.orderapi.products.entity.ProductEntity;
import br.com.vitorhr.orderapi.products.repository.ProductRepository;
import br.com.vitorhr.orderapi.util.exception.BadRequestException;
import br.com.vitorhr.orderapi.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity createProduct(CreateProductRequestDto dto) {
        ProductEntity product = ProductEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .status(1)
                .createdAt(LocalDateTime.now())
                .build();
        return productRepository.save(product);
    }

    public Page<ProductEntity> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public ProductEntity findProductById(Long id) {
        if(id  == null || id == 0) throw new BadRequestException("O identificador do produto é obrigatório.");
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException( "Product não encontrado."));
    }

    public void deleteProductById(Long id) {
        if(id  == null || id == 0) throw new BadRequestException("O identificador do produto é obrigatório.");
        productRepository.deleteById(id);
    }

    public ProductEntity updateProductById(Long id, UpdateResquestProductDto dto) {
        if(id  == null || id == 0) throw new BadRequestException("O identificador do produto é obrigatório.");
        ProductEntity product = findProductById(id);
        product.updateFromDto(dto);
        return productRepository.save(product);
    }
}
