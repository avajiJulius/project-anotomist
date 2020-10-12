package edu.anatomist.service;

import edu.anatomist.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    List<User> getUserByUsername(String username);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
}
