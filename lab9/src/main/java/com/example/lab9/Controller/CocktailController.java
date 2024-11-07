package com.example.lab9.Controller;

import com.example.lab9.Dao.CocktailDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.lab9.Entity.Cocktail;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/cocktails")
public class CocktailController {

    @Autowired
    private CocktailDao cocktailDao;

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
}
