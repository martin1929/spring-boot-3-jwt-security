package com.alibou.security.cakes;

import com.alibou.security.cakes.cakes.image.CakeImage;
import com.alibou.security.cakes.cakes.image.ImageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    private final CakeRepo cakeRepo;
    private final ImageRepo imageRepo;

    public CakeService(CakeRepo cakeRepo, ImageRepo imageRepo) {
        this.cakeRepo = cakeRepo;
        this.imageRepo = imageRepo;
    }

    public void saveCakeAndImageInDB(Cake cake){
        CakeImage cakeImage=new CakeImage(cake.getCakeImgName(),cake);
        cakeRepo.save(cake);
        imageRepo.save(cakeImage);
    }

    public List<Cake> getAllCakesFromDb(){
        return cakeRepo.findAll();
    }
}
