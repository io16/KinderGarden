package me.codaline.service;

import me.codaline.dao.PostDao;
import me.codaline.model.Post;
import me.codaline.dao.PostDao;
import me.codaline.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by igor on 04.11.16.
 */
@Service
public class PostService {
    @Autowired
    PostDao postDao;

    public void createPost(String title, String context, int idImage) {

        Post post = new Post();
        post.setTitle(title);
        post.setContext(context);
        post.setIdImage(idImage);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("2016-12-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        post.setDate(sdf.format(date));

        postDao.savePost(post);


    }

    public List getPosts() {
        return postDao.getPosts();
    }

    public void deletePost(int idPost) {

        Post post = postDao.getPostById(idPost);
        postDao.deletePost(post);
    }

    public List<Integer> getIdImages() {

        ArrayList idList = new ArrayList();
        postDao.getPosts().forEach(i -> {
            idList.add(i.getIdImage());
        });
        return idList;
    }
}
