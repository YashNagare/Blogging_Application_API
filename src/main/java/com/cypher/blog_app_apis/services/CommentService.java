package com.cypher.blog_app_apis.services;

import com.cypher.blog_app_apis.payloads.Dtos.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);


}
