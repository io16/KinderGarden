package Team_Z.service;

import Team_Z.dao.FeedBackDao;
import Team_Z.model.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        feedBack.setText(text);
        feedBack.setEmail(email);
        feedBack.setName(name);
        feedBack.setDate(String.valueOf(new Date()));
        feedBackDao.safeFeedBack(feedBack);
        return feedBack;

    }

    public List<FeedBack> getFeddBacks() {
        return feedBackDao.getFeedBacks();
    }
    public void deleteFeedBack(int idFeedBack){
        FeedBack feedBack = feedBackDao.getFeedbackById(idFeedBack);
        feedBackDao.deleteFeedBack(feedBack);
    }
}
