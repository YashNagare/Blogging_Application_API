package com.cypher.blog_app_apis.services.impl;

import com.cypher.blog_app_apis.entities.Comment;
import com.cypher.blog_app_apis.entities.Post;
import com.cypher.blog_app_apis.exceptions.ResourceNotFoundException;
import com.cypher.blog_app_apis.payloads.Dtos.CommentDto;
import com.cypher.blog_app_apis.repositories.CommentRepository;
import com.cypher.blog_app_apis.repositories.PostRepository;
import com.cypher.blog_app_apis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));

        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","comment id",commentId));
        this.commentRepository.delete(comment);
    }
}
