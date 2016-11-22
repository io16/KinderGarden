package me.codaline.service;


import me.codaline.dao.UserDao;
import me.codaline.dao.UserDaoImpl;

import me.codaline.model.User;
import me.codaline.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserService {

    @Autowired
    UserDaoImpl dao;


    public void createUser(String userName, String pass, String email, String firstName) {
        User user = new User();
        user.setEnabled(false);
        user.setPassword(pass);
        user.setUsername(userName);
        user.setEmail(email);
        user.setFirstName(firstName);
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUser(user);
        dao.saveUser(user, userRole);

    }





    public List<User> getUsers() {
        return dao.getUsers();
    }

    public void setAccess(String username, boolean status) {
        dao.setAccess(username, status);
    }

    public User getUser(String userName) {
        return dao.findByUserName(userName);
    }


}
