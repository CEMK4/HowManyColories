package com.HowManyColories.HowManyColories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "meal")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_type_id")
    private MealType mealType;

    @NotNull
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsedProduct> usedProducts = new LinkedHashSet<>();

    @PastOrPresent
    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}