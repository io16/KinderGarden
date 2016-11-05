package me.codaline.dao;

import me.codaline.model.Post;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by igor on 04.11.16.
 */
@Repository
@Transactional
public class PostDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Post> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(Post.class).list();
    }

    public void savePost(Post post) {
        sessionFactory.getCurrentSession().saveOrUpdate(post);
    }

    public void deletePost(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }

    public Post getPostById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Post.class);
        criteria.add(Restrictions.eq("id", id));
        return (Post) criteria.uniqueResult();
    }
}
