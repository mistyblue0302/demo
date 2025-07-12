package com.example.demo.domain.post.dto;

import com.example.demo.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
            .title(this.title)
            .content(this.content)
            .build();
    }
}