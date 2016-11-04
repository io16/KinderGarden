package Team_Z.service;

import Team_Z.dao.UserDao;
import Team_Z.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User createUser(String firstName, String lastName, String email) {
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPass(generatePass());
        userDao.save(user);
        return user;
    }

    public List<User> getUsers() {
            return userDao.getUsers();
    }

    public User getUser(String email) {
        return userDao.getUser(email);
    }

    private String generatePass() {
        return "myGeneratedPass"; //TODO generate random email!!!!
    }
}
