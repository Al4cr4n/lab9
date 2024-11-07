package com.example.lab9.Controller;

import com.example.lab9.Dao.CocktailDao;
import com.example.lab9.Entity.CocktailDetailResponse;
import com.example.lab9.Repository.FavoriteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.lab9.Entity.Cocktail;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.lab9.Entity.Favorite;


@Controller
@RequestMapping(value = "/cocktails")
public class CocktailController {

    @Autowired
    private CocktailDao cocktailDao;
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/lista")
    public String getCocktails(Model model) {
        List<Cocktail> cocktails = cocktailDao.getTop12Cocktails();
        model.addAttribute("cocktails", cocktails);
        return "listaCocktails";
    }

    @GetMapping("/favorites")
    public String listFavorites(Model model) {
        List<Favorite> favorites = favoriteRepository.findAll();
        model.addAttribute("favorites", favorites);
        return "favorites"; // Nombre de la plantilla HTML
    }

    @GetMapping("/{id}")
    public String getCocktailDetail(@PathVariable("id") String id, Model model) {
        Optional<CocktailDetailResponse> response = cocktailDao.getCocktailDetails(id);

        if (response.isPresent() && !response.get().getDrinks().isEmpty()) {
            Cocktail cocktail = response.get().getDrinks().get(0);

            // Crear listas de ingredientes y medidas
            List<String> ingredients = new ArrayList<>();
            List<String> measures = new ArrayList<>();

            if (cocktail.getStrIngredient1() != null && !cocktail.getStrIngredient1().isEmpty()) {
                ingredients.add(cocktail.getStrIngredient1());
                measures.add(cocktail.getStrMeasure1());
            }
            if (cocktail.getStrIngredient2() != null && !cocktail.getStrIngredient2().isEmpty()) {
                ingredients.add(cocktail.getStrIngredient2());
                measures.add(cocktail.getStrMeasure2());
            }
            if (cocktail.getStrIngredient3() != null && !cocktail.getStrIngredient3().isEmpty()) {
                ingredients.add(cocktail.getStrIngredient3());
                measures.add(cocktail.getStrMeasure3());
            }
            if (cocktail.getStrIngredient4() != null && !cocktail.getStrIngredient4().isEmpty()) {
                ingredients.add(cocktail.getStrIngredient4());
                measures.add(cocktail.getStrMeasure4());
            }

            // Agregar el cóctel y las listas al modelo
            model.addAttribute("cocktail", cocktail);
            model.addAttribute("ingredients", ingredients);
            model.addAttribute("measures", measures);

            return "detalleCocktail";
        } else {
            System.out.println("No cocktail found for ID: " + id);
            return "redirect:/cocktails/lista";
        }
    }








}
