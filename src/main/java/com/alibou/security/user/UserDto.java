package com.alibou.security.user;

public record UserDto(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Role role
) {

}
