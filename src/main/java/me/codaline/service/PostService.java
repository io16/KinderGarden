package me.codaline.service;

import me.codaline.dao.PostDao;
import me.codaline.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by igor on 04.11.16.
 */
@Service
public class PostService {
    @Autowired
    PostDao postDao;
    public void sevePost(){

    }
    public List<Post> getPosts(){
        return postDao.getUsers();
    }
}
