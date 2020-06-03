package lt.codeacademy.Blogas.repositories;

import lt.codeacademy.Blogas.entities.BlogEntry;
import lt.codeacademy.Blogas.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBlogEntryId(Long blogEntryId);
}
