package lt.codeacademy.Blogas.controller;

import lt.codeacademy.Blogas.entities.BlogEntry;
import lt.codeacademy.Blogas.entities.Comment;
import lt.codeacademy.Blogas.entities.User;
import lt.codeacademy.Blogas.services.BlogEntryService;
import lt.codeacademy.Blogas.services.CommentService;
import lt.codeacademy.Blogas.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/blogentries/{blogEntryId}/comments")
public class CommentsContoller {
    private CommentService commentService;
    private UserService userService;
    private BlogEntryService blogEntryService;

    public CommentsContoller(CommentService commentService, UserService userService, BlogEntryService blogEntryService) {
        this.commentService = commentService;
        this.userService = userService;
        this.blogEntryService = blogEntryService;
    }

    @GetMapping
    public String getCommentsByBlogEntry(@PathVariable Long blogEntryId,
            Model model,
            @AuthenticationPrincipal User user
    ) {
        List<Comment> comments = commentService.getAllCommentsForBlogEntry(blogEntryId);
        model.addAttribute("comments", comments);

        Comment newComment = new Comment();
        model.addAttribute("comment", newComment);

        model.addAttribute("user", user);
        return "comments";
    }

    @GetMapping("/delete/{commentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteComment(@PathVariable Long commentId, @PathVariable Long blogEntryId, Model model, @AuthenticationPrincipal User user) {
        commentService.deleteComment(commentId);
        List<Comment> comments = commentService.getAllCommentsForBlogEntry(blogEntryId);
        Comment newComment = new Comment();
        model.addAttribute("comment", newComment);
        model.addAttribute("comments", comments);
        return "comments";
    }

    @PostMapping("/newcomment")
//    @PreAuthorize("hasRole('ADMIN')")
    public String submitComment(Comment comment,
                                  @PathVariable Long blogEntryId,
                                  Model model,
                                  @AuthenticationPrincipal User user) {

        comment.setUser(user);
        BlogEntry blogEntry = blogEntryService.getBlogEntry(blogEntryId);
        comment.setBlogEntry(blogEntry);

        Comment newComment = commentService.createOrUpdateComment(comment);
        Comment emptyComment = new Comment();
        model.addAttribute("comment", emptyComment);
        model.addAttribute("blogEntryId", blogEntryId);

        List<Comment> comments = commentService.getAllCommentsForBlogEntry(blogEntryId);
        model.addAttribute("comments", comments);

        return "comments";
    }
}
