package ru.boost.charity.rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.UserModel;
import ru.boost.charity.rest_api.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public UserModel getUserById(Long id) {
        return userConverter.entityToModel(userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    public List<UserModel> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(userConverter::entityToModel)
                .collect(Collectors.toList());
    }

    public void createNewUser(UserModel userModel) {
        userRepository.save(userConverter.modelToEntity(userModel));
    }

    public void updateUserById(Long id, UserModel userModel) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        user.setAvatar(userModel.getAvatar());
        user.setEmail(userModel.getEmail());
        user.setUpdateDate(LocalDateTime.now());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(userModel.getPassword());
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        user.setActive(false);
        userRepository.save(user);
    }
}
