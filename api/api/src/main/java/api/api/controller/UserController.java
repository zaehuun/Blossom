package api.api.controller;

import api.api.model.User;
import api.api.repo.UserJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"1. User"})
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserJpaRepo userJpaRepo;

    @ApiOperation(value="회원조회", notes = "모든 회원 조회")
    @GetMapping(value="/user")
    public List<User> findAllUser(){
        return userJpaRepo.findAll();
    }

    @ApiOperation(value = "회원입력",notes="회원입력")
    @PostMapping(value="/user")
    public User save(@ApiParam(value="회원아이디",required=true) @RequestParam String uid, @ApiParam(value="회원이름",required=true) @RequestParam String name){
        User user = User.builder().uid(uid).name(name).build();
        return userJpaRepo.save(user);
    }

}
