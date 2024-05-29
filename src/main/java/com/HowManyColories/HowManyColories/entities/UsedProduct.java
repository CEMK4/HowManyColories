package com.HowManyColories.HowManyColories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "used_product")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "measure")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private String measure;

}