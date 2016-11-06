package me.codaline.dao;

import me.codaline.model.Gallery;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by igor on 05.11.16.
 */
@Repository
@Transactional
public class GalleryDao {
    @Autowired
    SessionFactory sessionFactory;

    public void createGallery(Gallery gallery) {
        sessionFactory.getCurrentSession().save(gallery);
    }

    public void deleteGallery(Gallery gallery) {
        sessionFactory.getCurrentSession().delete(gallery);
    }

    public List<Gallery> getGalleries() {
        return sessionFactory.getCurrentSession().createCriteria(Gallery.class).addOrder(Order.desc("id")).list();
    }

    public Gallery getFeedbackById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Gallery.class);
        criteria.add(Restrictions.eq("id", id));
        return (Gallery) criteria.uniqueResult();
    }
}
