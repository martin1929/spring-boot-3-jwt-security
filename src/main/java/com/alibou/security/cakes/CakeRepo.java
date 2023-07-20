package com.alibou.security.cakes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CakeRepo extends JpaRepository<Cake,Integer> {
    @Query("SELECT c.cakeName FROM Cake c")
    List<String> findAllCakeName();

    List<Cake> findAll() ;

}
