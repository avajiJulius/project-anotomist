package edu.anatomist.service;

import edu.anatomist.domain.User;
import edu.anatomist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;


    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findUserById(id);
    }

    public List<User> getUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

}
