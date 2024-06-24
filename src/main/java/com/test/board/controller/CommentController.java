package com.test.board.controller;

import com.test.board.dto.CommentDTO;
import com.test.board.entity.Comment;
import com.test.board.repository.CommentRepository;
import com.test.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    //1. 댓글 조회
    @GetMapping("/api/article/{articleId}/comments")
    public ResponseEntity<List<CommentDTO>> comments(@PathVariable Long articleId) {
        //서비스에 위임
        List<CommentDTO> dtos = commentService.comments(articleId);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //2. 댓글 생성
    @PostMapping("/api/article/{articleId}/comments")
    public ResponseEntity<CommentDTO> create(@PathVariable Long articleId, @RequestBody CommentDTO dto) {
        //서비스에 위임
        CommentDTO CreatedDTO = commentService.create(articleId, dto);

        //결과 응답
        return ResponseEntity.status(HttpStatus.CREATED).body(CreatedDTO);
    }

    //3. 댓글 수정
    @PatchMapping("api/comments/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id, @RequestBody CommentDTO dto) {
        //서비스에 위임
        CommentDTO updatedDTO = commentService.update(id, dto);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
    }

    //4. 댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDTO> delete(@PathVariable Long id) {
        //서비스에 위임
        CommentDTO deletedDTO = commentService.delete(id);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDTO);
    }

}
