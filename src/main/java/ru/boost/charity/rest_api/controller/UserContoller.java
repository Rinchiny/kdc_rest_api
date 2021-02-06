package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.boost.charity.rest_api.converter.UserByIdConverter;
import ru.boost.charity.rest_api.model.User;

@Controller
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserContoller {

    private final UserByIdConverter converter;

    @GetMapping
    public User getUserById(@RequestParam("userId") Long userId) {
        return converter.convert(userId);

    }
}
