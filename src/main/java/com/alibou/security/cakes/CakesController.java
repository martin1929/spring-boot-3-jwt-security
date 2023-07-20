package com.alibou.security.cakes;

import com.alibou.security.auth.AuthenticationService;
import com.alibou.security.cakes.image.CakeImage;
import com.alibou.security.cakes.image.ImageRepo;
import com.alibou.security.user.User;
import com.alibou.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cake")
@RequiredArgsConstructor
public class CakesController {

    private final AuthenticationService authenticationService;
    private final CakeRepo cakeRepo;
    private final ImageRepo imageRepo;
    private final UserRepository userRepository;

    @PostMapping("/saveCake")
    public String uploadImage(@RequestBody Cake requests) {
        Cake cake = new Cake(null, requests.getCakeName(), requests.getCakeImgName(), requests.getDescription(), requests.getPrice());
        cakeRepo.save(cake);
        CakeImage cakeImage=new CakeImage();
        cakeImage.setImageName(cake.getCakeImgName());
        cakeImage.setCake(cake);
        imageRepo.save(cakeImage);
        System.out.println(requests);
        return "";
    }

    @GetMapping("/getUsers")
    public User getUsersByEmail() {
        // Retrieve user by email from the repository
        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getEmail());
            System.out.println(users.get(i).getFirstName());
            System.out.println(users.get(i).getLastName());

        }
        return users.get(0);
    }

    @GetMapping("/getCakeName")
    public List<Cake> getImage() {
        return cakeRepo.findAll();
    }


}
