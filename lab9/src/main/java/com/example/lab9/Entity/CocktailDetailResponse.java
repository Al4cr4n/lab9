package com.example.lab9.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CocktailDetailResponse {
    private List<Cocktail> drinks;
}