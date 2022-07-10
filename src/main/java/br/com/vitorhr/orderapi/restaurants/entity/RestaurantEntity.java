package br.com.vitorhr.orderapi.restaurants.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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

    @Column(name = "opening_hours")
    private String openingHours;

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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
