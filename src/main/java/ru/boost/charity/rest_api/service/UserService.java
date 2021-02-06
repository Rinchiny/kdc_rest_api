package ru.boost.charity.rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.UserModel;
import ru.boost.charity.rest_api.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public UserModel getUserById(Long id) {
        return userConverter.entityToModel(userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }
}
