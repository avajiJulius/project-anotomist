package edu.anatomist.service;

import edu.anatomist.domain.User;
import edu.anatomist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userById = repository.findUserById(id);
        if (userById.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        User user = userById.get();

        return user;
    }

    public List<User> getUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

}
