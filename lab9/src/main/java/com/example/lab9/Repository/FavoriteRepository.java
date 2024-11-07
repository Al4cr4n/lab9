package com.example.lab9.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab9.Entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByDrinkId(String drinkId);
}
