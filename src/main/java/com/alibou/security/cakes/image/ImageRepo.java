package com.alibou.security.cakes.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<CakeImage,Integer> {
}
