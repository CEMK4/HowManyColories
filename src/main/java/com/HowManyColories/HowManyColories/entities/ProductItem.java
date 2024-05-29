package com.HowManyColories.HowManyColories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "product_item")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "title", unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String title;

    @PositiveOrZero
    @NotNull
    @Column(name = "calories")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double calories;

    @PositiveOrZero
    @NotNull
    @Column(name = "proteins")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double proteins;

    @PositiveOrZero
    @NotNull
    @Column(name = "fats")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double fats;

    @PositiveOrZero
    @NotNull
    @Column(name = "carbs")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double carbs;
}