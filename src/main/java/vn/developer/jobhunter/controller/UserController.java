package vn.developer.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.developer.jobhunter.domain.User;
import vn.developer.jobhunter.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User reqUSer) {
        return this.userService.handleCreateUser(reqUSer);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return ("delete successfully ! ");
    }

    @GetMapping("/user/{id}")
    public User getUserId(@PathVariable("id") long id) {
        return this.userService.handleGetUserById(id);
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return this.userService.handleGetUser();
    }

    @PutMapping("/user")
    public User UpdateUserById(@RequestBody User reqUser) {
        return this.userService.handleUpdateUser(reqUser);
    }

}
