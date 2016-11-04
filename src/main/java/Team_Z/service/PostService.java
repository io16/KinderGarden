package Team_Z.service;

import Team_Z.dao.PostDao;
import Team_Z.model.Post;
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

    public Post createPost(String title, String context, String date, int idImage, String userName) {
        Post post = new Post();

        post.setDate(date);
        post.setContext(context);
        post.setTitle(title);
        post.setUserName(userName);
        post.setIdImage(idImage);

        postDao.savePost(post);

        return post;

    }

    public List<Post> getPosts() {
        return postDao.getUsers();
    }

    public void deletePost(int idPost){

        Post post = postDao.getPostById(idPost);
        postDao.deletePost(post);
    }
}
