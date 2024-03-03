package cg.jefy.IBPProject.services;

import cg.jefy.IBPProject.entities.Book;
import cg.jefy.IBPProject.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * @author: JefYamba
 */
public interface UserService {


    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    User updateUserPassword(Long id, String password);

    void addAccountToUser(User user, String username, String password);

}
