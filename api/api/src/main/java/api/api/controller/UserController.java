package api.api.controller;

import api.api.model.User;
import api.api.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserJpaRepo userJpaRepo;

    @GetMapping(value="/user")
    public List<User> findAllUser(){
        return userJpaRepo.findAll();
    }

    @PostMapping(value="/user")
    public User save(){
        User user = User.builder().uid("jdrjk").name("재훈").build();
        return userJpaRepo.save(user);
    }

}
