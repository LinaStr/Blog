package lt.codeacademy.Blogas.services;

import lt.codeacademy.Blogas.entities.BlogEntry;
import lt.codeacademy.Blogas.entities.Comment;
import lt.codeacademy.Blogas.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment createOrUpdateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentsForBlogEntry(Long blogEntryId){
        return commentRepository.findAllByBlogEntryId(blogEntryId);
    }

}
