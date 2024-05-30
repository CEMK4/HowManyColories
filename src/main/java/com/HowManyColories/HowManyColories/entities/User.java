package com.HowManyColories.HowManyColories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @PositiveOrZero
    @NotNull
    @Column(name = "age")
    private Integer age;

    @Positive
    @NotNull
    @Column(name = "height")
    private Double height;

    @Positive
    @NotNull
    @Column(name = "weight")
    private Double weight;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Meal> meals = new LinkedHashSet<>();

    @Positive
    @NotNull
    @Column(name = "calories_consumption")
    private Integer caloriesConsumption;

    @Positive
    @NotNull
    @Column(name = "water_consumption")
    private Double waterConsumption;

}