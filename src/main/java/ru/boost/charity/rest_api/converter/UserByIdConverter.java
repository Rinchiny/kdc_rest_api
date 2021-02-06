package ru.boost.charity.rest_api.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.boost.charity.rest_api.model.User;
import org.springframework.core.convert.converter.Converter;
import ru.boost.charity.rest_api.repository.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserByIdConverter implements Converter<Long, User>{

    private final UserRepository userRepository;

    @Override
    public User convert(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }
}