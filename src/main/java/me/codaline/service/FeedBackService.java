package me.codaline.service;

import me.codaline.dao.FeedBackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 04.11.16.
 */
@Service
public class FeedBackService {
    @Autowired
    FeedBackDao feedBackDao;
}
