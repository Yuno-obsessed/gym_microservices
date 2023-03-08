package com.sanitynil.userservice.domain.user;

import java.util.function.Function;

public class UserDtoMapper implements Function<User, UserOutDto> {
    @Override
    public UserOutDto apply(User user) {
        return new UserOutDto(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity()
        );
    }
}
