package br.com.vitorhr.orderapi.restaurants.entity;

import br.com.vitorhr.orderapi.restaurants.dto.request.UpdateResquestRestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "zip_code_address")
    private Long zipCodeAddress;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "additional_address")
    private String additionalAddress;

    @Column(name = "neighborhood_address")
    private String neighborhoodAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "open")
    private Integer open;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    public void updateFromDto(UpdateResquestRestaurantDto dto) {
        this.name = dto.getName();
        this.zipCodeAddress = dto.getZipCodeAddress();
        this.streetAddress = dto.getStreetAddress();
        this.additionalAddress = dto.getAdditionalAddress();
        this.neighborhoodAddress = dto.getNeighborhoodAddress();
        this.phone = dto.getPhone();
        this.status = dto.getStatus();
        this.open = dto.getOpen();
        this.updatedAt = LocalDateTime.now();
    }
}
