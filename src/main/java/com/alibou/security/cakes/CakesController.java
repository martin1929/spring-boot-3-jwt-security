package com.alibou.security.cakes;

import com.alibou.security.auth.AuthenticationService;
import com.alibou.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cake")
@RequiredArgsConstructor
public class CakesController {
    private final AuthenticationService authenticationService;

    private final CakeService cakeService;

    private final UserRepository userRepository;


    @GetMapping("/getCakes")
    public List<Cake> getImage() {
        return cakeService.getAllCakesFromDb();
    }

    @PostMapping("/saveCake")
    public String saveCake(@RequestBody Cake cake) {
        cakeService.saveCakeAndImageInDB(cake);
        return "";
    }

    //  @GetMapping("/getUsers")
    //  public User getUsersByEmail() {
    //      // Retrieve user by email from the repository
    //      List<User> users = userRepository.findAll();
    //      for (int i = 0; i < users.size(); i++) {
    //          System.out.println(users.get(i).getEmail());
    //          System.out.println(users.get(i).getFirstName());

    //          System.out.println(users.get(i).getLastName());
    //      }
    //      return users.get(0);

    //  }


}
