package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.boost.charity.rest_api.model.UserModel;
import ru.boost.charity.rest_api.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createNewUser(UserModel userModel) {
        userService.createNewUser(userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") Long userId, UserModel userModel) {
        userService.updateUserById(userId, userModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
