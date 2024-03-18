package com.example.tmdb_test.repository;

import com.example.tmdb_test.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.movie=:id ORDER BY c.dateCreated DESC")
    List<Comment> findAllCommentsByMovieId(Long id);
}
