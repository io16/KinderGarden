package me.codaline.dao;

import me.codaline.model.FeedBack;
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
public class FeedBackDao {
    @Autowired
    SessionFactory sessionFactory;

    public void safeFeedBack(FeedBack feedBack) {
        sessionFactory.getCurrentSession().save(feedBack);
    }

    public FeedBack getFeedbackById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FeedBack.class);
        criteria.add(Restrictions.eq("id", id));
        return (FeedBack) criteria.uniqueResult();
    }

    public List<FeedBack> getFeedBacks() {
        return sessionFactory.getCurrentSession().createCriteria(FeedBack.class).list();
    }

    public void deleteFeedBack(FeedBack feedBack) {
        sessionFactory.getCurrentSession().delete(feedBack);

    }
}
