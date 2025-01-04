package com.cypher.blog_app_apis.repositories;

import com.cypher.blog_app_apis.entities.Category;
import com.cypher.blog_app_apis.entities.Post;
import com.cypher.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String keyword);
}
