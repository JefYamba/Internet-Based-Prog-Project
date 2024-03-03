package cg.jefy.IBPProject.services.impl;

import cg.jefy.IBPProject.entities.User;
import cg.jefy.IBPProject.repositories.UserRepository;
import cg.jefy.IBPProject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: JefYamba
 */
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User updateUserPassword(Long id, String password) {
        return null;
    }

    @Override
    public void addAccountToUser(User user, String username, String password) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()){

        }
    }
}
