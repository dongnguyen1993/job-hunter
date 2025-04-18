package vn.developer.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.developer.jobhunter.domain.User;
import vn.developer.jobhunter.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User handleGetUserById(long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    public List<User> handleGetUser() {
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User user) {

        User updateUser = this.handleGetUserById(user.getId());
        if (updateUser != null) {
            updateUser.setEmail(user.getEmail());
            updateUser.setName(user.getName());
            updateUser.setPassword(user.getPassword());

            updateUser = this.userRepository.save(updateUser);
        }
        return updateUser;
    }

}
