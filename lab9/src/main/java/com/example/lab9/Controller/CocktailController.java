package com.example.lab9.Controller;

import com.example.lab9.Dao.CocktailDao;
import com.example.lab9.Entity.Favorite;
import com.example.lab9.Repository.FavoriteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.lab9.Entity.Cocktail;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/detail")
    public String getCocktailDetail(@RequestParam String id, Model model) {
        Cocktail cocktail = cocktailDao.getCocktailDetailById(id);
        if (cocktail != null) {
            model.addAttribute("cocktail", cocktail);
            return "cocktailDetail";  // nombre de la vista que mostrará el detalle del cóctel
        } else {
            return "error";  // nombre de una vista de error o redirigir a otra página si el cóctel no se encuentra
        }
    }


    @PostMapping("/addFavorite")
    public ResponseEntity<Map<String, Object>> addFavorite(@RequestParam String id, @RequestParam String name,
                                                           @RequestParam String category, @RequestParam String alcoholic,
                                                           @RequestParam String glass, @RequestParam String instructions,
                                                           @RequestParam String imageUrl) {
        Map<String, Object> response = new HashMap<>();

        if (!favoriteRepository.existsByDrinkId(id)) {
            Favorite favorite = new Favorite();
            favorite.setDrinkId(id);
            favorite.setDrinkName(name);
            favorite.setDrinkCategory(category);
            favorite.setDrinkAlcoholic(alcoholic);
            favorite.setDrinkGlass(glass);
            favorite.setDrinkInstructions(instructions);
            favorite.setDrinkImageUrl(imageUrl);
            favoriteRepository.save(favorite);

            response.put("success", true);
            return ResponseEntity.ok(response); // 200 OK
        } else {
            response.put("success", false);
            response.put("message", "Ya está en favoritos");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409 Conflict
        }
    }
}
