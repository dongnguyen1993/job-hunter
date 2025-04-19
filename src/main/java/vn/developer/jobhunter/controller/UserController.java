package vn.developer.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.developer.jobhunter.domain.User;
import vn.developer.jobhunter.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User reqUSer) {
        User user = this.userService.handleCreateUser(reqUSer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.handleGetUserById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.handleGetUser());
    }

    @PutMapping("/users")
    public ResponseEntity<User> UpdateUserById(@RequestBody User reqUser) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.handleUpdateUser(reqUser));
    }

}
