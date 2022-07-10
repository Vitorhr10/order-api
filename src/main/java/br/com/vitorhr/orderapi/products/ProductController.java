package br.com.vitorhr.orderapi.products;

import br.com.vitorhr.orderapi.products.dto.request.CreateProductRequestDto;
import br.com.vitorhr.orderapi.products.dto.request.UpdateResquestProductDto;
import br.com.vitorhr.orderapi.products.dto.response.ProductResponseDto;
import br.com.vitorhr.orderapi.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody @Valid CreateProductRequestDto dto) {
        return new ProductResponseDto(productService.createProduct(dto));
    }

    @GetMapping
    public Page<ProductResponseDto> findAllProducts(Pageable pageable) {
        return productService.findAllProducts(pageable).map(ProductResponseDto::new);
    }

    @GetMapping("/{id}")
    public ProductResponseDto findProductById(@PathVariable Long id) {
        return new ProductResponseDto(productService.findProductById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto updateProductById(@PathVariable Long id, @RequestBody @Valid UpdateResquestProductDto dto) {
        return new ProductResponseDto(productService.updateProductById(id, dto));
    }
}
