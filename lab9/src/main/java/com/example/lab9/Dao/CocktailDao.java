package com.example.lab9.Dao;

import com.example.lab9.Entity.Cocktail;
import com.example.lab9.Entity.CocktailResponse;
import com.example.lab9.Entity.CocktailDetailResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CocktailDao {
    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    // Método para obtener los 12 cócteles principales
    public List<Cocktail> getTop12Cocktails() {
        String url = BASE_URL + "filter.php?c=Cocktail";
        RestTemplate restTemplate = new RestTemplate();

        CocktailResponse response = restTemplate.getForObject(url, CocktailResponse.class);

        if (response != null && response.getDrinks() != null) {
            return response.getDrinks().stream().limit(12).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    // Método para encontrar un cóctel por ID
    public Optional<Cocktail> findById(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "lookup.php")
                .queryParam("i", id)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();

        CocktailResponse response = restTemplate.getForObject(url, CocktailResponse.class);

        if (response != null && response.getDrinks() != null && !response.getDrinks().isEmpty()) {
            return Optional.of(response.getDrinks().get(0));
        } else {
            return Optional.empty();
        }
    }

    // Método para obtener detalles completos de un cóctel
    public Optional<CocktailDetailResponse> getCocktailDetails(String id) {
        String url = BASE_URL + "lookup.php?i=" + id;
        RestTemplate restTemplate = new RestTemplate();

        CocktailDetailResponse response = restTemplate.getForObject(url, CocktailDetailResponse.class);

        return Optional.ofNullable(response);
    }
}
