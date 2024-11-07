package com.example.lab9.Repository;

import com.example.lab9.Entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByDrinkId(String drinkId);
}
