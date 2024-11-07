package com.example.lab9.Controller;

import com.example.lab9.Dao.CocktailDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.lab9.Entity.Cocktail;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
