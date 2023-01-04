package com.test.redisconfiguration.controller;

import com.test.redisconfiguration.core.result.DataResult;
import com.test.redisconfiguration.core.result.Result;
import com.test.redisconfiguration.model.User;
import com.test.redisconfiguration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<Optional<User>> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    public Result saveUser(@RequestBody User user){
        return userService.add(user);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
