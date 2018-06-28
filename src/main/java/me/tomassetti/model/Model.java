package me.tomassetti.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Model {
    UUID createPost(String title, String content, List<Area> areasList);
    UUID createArea(String nombre, List<Area> areasList);
    UUID Area(UUID area, String id);
   UUID createComment(UUID post, String author, String content);
    List<Post> getAllPosts();
    List<Area> getAllAreas();
    List<Comment> getAllCommentsOn(UUID post);
    boolean existPost(UUID post);

    Optional<Area> getArea(UUID uuid);

 /*   void updatePost(Post post);

    void deletePost(UUID uuid);
    */
	List<Area> areasList();
	
	


	
}
