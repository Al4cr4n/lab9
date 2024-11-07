package com.example.lab9.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drinkId;
    private String drinkName;
    private String drinkCategory;
    private String drinkAlcoholic;
    private String drinkGlass;
    private String drinkInstructions;
    private String drinkImageUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
}