package com.example.demo.domain.post.service;

import com.example.demo.domain.post.dto.PostDto;
import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Service : 해당 클래스가 비즈니스 로직을 수행하는 서비스 클래스임을 나타내는 애노테이션
 * @RequiredArgsConstructor : final 필드의 생성자를 생성해주는 애노테이션
 */

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> searchPostsByTitle(String keyword) {
        return postRepository.findByTitleContains(keyword);
    }

    public Post create(PostDto postDto) {
        Post post = postRepository.save(postDto.toEntity());
        return post;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Post Not Found"));
    }

    public void update(Long id, PostDto postDto) {
        Post post = findById(id);
        post.update(postDto.getTitle(), postDto.getContent());
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
