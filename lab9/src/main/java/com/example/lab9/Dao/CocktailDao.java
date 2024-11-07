package com.example.lab9.Dao;

import com.example.lab9.Entity.Cocktail;
import com.example.lab9.Entity.CocktailResponse;
import com.example.lab9.Entity.CocktailDetailResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CocktailDao {

    public List<Cocktail> getTop12Cocktails() {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        RestTemplate restTemplate = new RestTemplate();

        CocktailResponse response = restTemplate.getForObject(url, CocktailResponse.class);

        if (response != null && response.getDrinks() != null) {
            return response.getDrinks().stream().limit(12).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    public Cocktail getCocktailDetailById(String id) {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + id;
        RestTemplate restTemplate = new RestTemplate();
        CocktailDetailResponse response = restTemplate.getForObject(url, CocktailDetailResponse.class);
        if (response != null && response.getDrinks() != null && !response.getDrinks().isEmpty()) {
            return response.getDrinks().get(0); // Devuelve el primer resultado
        }
        return null;
    }
}


