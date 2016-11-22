package me.codaline.dao;


import me.codaline.model.User;
import me.codaline.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery(" from User where username=?").setParameter(0, username)
                .list();


        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }


    }

    public void saveUser(User user, UserRole userRole) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(userRole);
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setAccess(String username, boolean status) {
        Query query = sessionFactory.getCurrentSession().createQuery("update User set enabled = :status where username = :name");
        query.setParameter("name", username);
        query.setParameter("status", status);
        int result = query.executeUpdate();
    }
}