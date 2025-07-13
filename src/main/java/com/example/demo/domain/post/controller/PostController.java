package com.example.demo.domain.post.controller;

import com.example.demo.domain.post.dto.PostDto;
import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController : 해당 클래스가 컨트롤러임을 나타내는 애노테이션으로 HTTP 요청과 응답을 처리하는 컨트롤러로 사용
 * @RequestMapping : 요청 URL과 이를 처리하는 메소드를 매핑하기 위한 애노테이션
 * @RequiredArgsConstructor : final 필드의 생성자를 생성해주는 애노테이션
 */

@Tag(name = "게시글 API", description = "게시글 관련 API입니다.")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Operation(summary = "게시글 등록", description = "새로운 게시글을 등록합니다.")
    @PostMapping
    public Post post(@RequestBody PostDto postDto) {
        return postService.create(postDto);
    }

    @Operation(summary = "게시글 전체 조회", description = "모든 게시글을 조회합니다.")
    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @Operation(summary = "특정 게시글 조회", description = "아이디로 특정 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public Post findById(
        @Parameter(description = "조회할 게시글 id", example = "1")
        @PathVariable Long id) {
        return postService.findById(id);
    }

    @Operation(summary = "게시글 수정", description = "아이디를 기준으로 게시글을 수정합니다.")
    @PatchMapping("/{id}")
    public void update(
        @Parameter(description = "수정할 게시글 id", example = "1")
        @PathVariable Long id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
    }

    @Operation(summary = "게시글 삭제", description = "아이디를 기준으로 게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(
        @Parameter(description = "삭제할 게시글 id", example = "1")
        @PathVariable Long id) {
        postService.delete(id);
    }

    @Operation(summary = "제목으로 게시글 검색", description = "제목에 특정 키워드가 포함된 게시글을 검색합니다.")
    @GetMapping("/search")
    public List<Post> searchByTitle(@RequestParam String keyword) {
        return postService.searchPostsByTitle(keyword);
    }
}