package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.entity.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PostRepositoryCustom에서 정의한 메소드를 구현한다.
 */

@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Post> findByTitleContains(String keyword) {
        QPost post = QPost.post;

        return queryFactory
            .selectFrom(post)
            .where(post.title.containsIgnoreCase(keyword))
            .fetch();
    }
}
