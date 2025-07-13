package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.entity.Post;
import java.util.List;

/**
 * findByTitleContains : 제목에 해당 keyword가 포함된 게시글 조회
 */

public interface PostRepositoryCustom {
    List<Post> findByTitleContains(String keyword);
}
