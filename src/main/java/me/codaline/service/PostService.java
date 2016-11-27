package me.codaline.service;

import me.codaline.dao.PostDao;
import me.codaline.model.Post;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    @Autowired
    ImageService imageService;


    public void createPost(String title, String context, int idImage) {

        Post post = new Post();
        post.setTitle(title);
        post.setContext(context);
        post.setIdImage(idImage);

        post.setDate(String.valueOf(LocalDate.now()));

        postDao.savePost(post);


    }

    public JSONObject getPosts() {

        JSONObject mainObject = new JSONObject();
        JSONObject dataPosts = new JSONObject();

        JSONArray jsonArrayIds = new JSONArray();
        JSONArray jsonArrayData;
        List<Post> posts = postDao.getPosts();


        for (Post post : posts) {
            jsonArrayData = new JSONArray();

            jsonArrayIds.put(post.getId());


            jsonArrayData.put(post.getTitle());
            jsonArrayData.put(post.getContext());
            jsonArrayData.put(post.getDate());
            jsonArrayData.put(post.getIdImage());

            try {
                dataPosts.put(String.valueOf(post.getId()), jsonArrayData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {

            mainObject.put("postData", dataPosts);
            mainObject.put("idPosts", jsonArrayIds);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mainObject;
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
