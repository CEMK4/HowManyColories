package com.HowManyColories.HowManyColories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "meal_type")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MealType {
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

}