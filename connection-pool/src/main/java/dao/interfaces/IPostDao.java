package dao.interfaces;

import model.Post;

public interface IPostDao extends IQuery<Post> {

    Post getMostLikedPostById(long id);

    Post getMostLikedPostByFirstName(String firstName);

    Post getMostCommentedPost();

}
