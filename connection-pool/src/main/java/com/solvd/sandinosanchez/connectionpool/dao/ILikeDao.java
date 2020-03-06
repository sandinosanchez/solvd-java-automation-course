package com.solvd.sandinosanchez.connectionpool.dao;

import com.solvd.sandinosanchez.connectionpool.models.Like;

import java.util.List;

public interface ILikeDao extends IQuery<Like> {

<<<<<<< HEAD
    List<Like> getLikesByPostId(long id);
=======
    List<Like> getAllByPostId(long id);
>>>>>>> 6f2746a38ec765cca33fc53e5f24be71c90be632

}
