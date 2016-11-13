package me.codaline.dao;

import me.codaline.model.ImagesAndGalleries;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by igor on 13.11.16.
 */
@Repository
@Transactional
public class ImagesAndGalleriesDao {

    @Autowired
    SessionFactory sessionFactory;

    public void addImage(ImagesAndGalleries imagesAndGalleries) {
        sessionFactory.getCurrentSession().save(imagesAndGalleries);
    }

    public void deleteImage(int idImage) {
        String hql = "delete from ImagesAndGalleries where idImage =:idImage ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("idImage", idImage);
        query.executeUpdate();
    }

    public void  deleteGallery(int idGallery){
        String hql = "delete from ImagesAndGalleries where idGallery =:idGallery ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("idGallery", idGallery);
        query.executeUpdate();
    }


    public List<ImagesAndGalleries> getImagesAndGalleries(){

        return sessionFactory.getCurrentSession().createCriteria(ImagesAndGalleries.class).addOrder(Order.desc("id")).list();
    }

}
