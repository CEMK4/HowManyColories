package com.HowManyColories.HowManyColories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipe")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "description", length = 512)
    @JdbcTypeCode(SqlTypes.LONGNVARCHAR)
    private String description;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_productItems",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "productItems_id"))
    private Set<ProductItem> productItems = new LinkedHashSet<>();

}