package com.alibou.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/getUser")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String email) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.getUser(email));

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
}
