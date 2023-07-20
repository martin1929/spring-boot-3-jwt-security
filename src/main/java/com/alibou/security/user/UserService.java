package com.alibou.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;


    public UserDto getUser(String email) throws ResourceNotFoundException {
        return userRepository.findByEmail(email)
                .map(userDtoMapper)
                .orElseThrow(() -> new ResourceNotFoundException("ResourceNot Find"));

    }
}
