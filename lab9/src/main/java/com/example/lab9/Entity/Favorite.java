package com.example.lab9.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Entity
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


}