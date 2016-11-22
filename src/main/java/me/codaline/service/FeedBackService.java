package me.codaline.service;

import me.codaline.model.FeedBack;
import me.codaline.dao.FeedBackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by igor on 04.11.16.
 */
@Service
public class FeedBackService {
    @Autowired
    FeedBackDao feedBackDao;

    public FeedBack createFeedBack(String name, String email, String text) {

        FeedBack feedBack = new FeedBack();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date c= null;
        try {
            c = sdf.parse("2015-05-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String date=sdf.format(c);

        feedBack.setText(text);
        feedBack.setEmail(email);
        feedBack.setName(name);
        feedBack.setDate(date);
        feedBackDao.safeFeedBack(feedBack);

        return feedBack;

    }

    public List<FeedBack> getFeedBacks() {

        return feedBackDao.getFeedBacks();
    }

    public void deleteFeedBack(int idFeedBack) {

        FeedBack feedBack = feedBackDao.getFeedbackById(idFeedBack);
        feedBackDao.deleteFeedBack(feedBack);
    }
    public void deleteAllFeedBacks(){
        feedBackDao.deleteAllFeedBacks();
    }
}
