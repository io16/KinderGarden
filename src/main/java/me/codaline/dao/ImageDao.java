package me.codaline.dao;

import me.codaline.model.Image;
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
public class ImageDao {
    @Autowired
    SessionFactory sessionFactory;

    public void saveImage(Image image) {
        sessionFactory.getCurrentSession().save(image);
    }

    public Image getImageById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Image.class);
        criteria.add(Restrictions.eq("id", id));
        return (Image) criteria.uniqueResult();
    }

    public List<Image> getImages() {
        return sessionFactory.getCurrentSession().createCriteria(Image.class).list();
    }

    public void deleteImage(Image image) {
        sessionFactory.getCurrentSession().delete(image);
    }

}
