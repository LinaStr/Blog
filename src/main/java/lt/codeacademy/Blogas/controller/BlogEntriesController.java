package lt.codeacademy.Blogas.controller;

import lt.codeacademy.Blogas.entities.BlogEntry;
import lt.codeacademy.Blogas.entities.User;
import lt.codeacademy.Blogas.services.BlogEntryService;
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
@RequestMapping("/blogentries")
public class BlogEntriesController {
    private BlogEntryService blogEntryService;
    private UserService userService;

    public BlogEntriesController(BlogEntryService blogEntryService, UserService userService) {
        this.blogEntryService = blogEntryService;
        this.userService = userService;
    }


    @GetMapping("/{blogEntryId}")
    public String getBlogEntry(@PathVariable Long blogEntryId, Model model, @AuthenticationPrincipal User user) {
        BlogEntry blogEntry = blogEntryService.getBlogEntry(blogEntryId);
        model.addAttribute("blogEntry", blogEntry);
        model.addAttribute("user", user);
        return "blogentry";
    }

    @GetMapping("/newblogentry")
    @PreAuthorize("hasRole('ADMIN')")
    public String createNewBlogEntry(Model model) {
        model.addAttribute("blogentry", new BlogEntry());
        return "blogentryform";
    }


    @PostMapping("/newblogentry")
    @PreAuthorize("hasRole('ADMIN')")
    public String submitBlogEntry(@Valid BlogEntry blogEntry, Model model) {

        BlogEntry newblogEntry = blogEntryService.createOrUpdateBlogEntry(blogEntry);
        model.addAttribute("blogentry", newblogEntry);
        return "redirect:/blogentries/" + newblogEntry.getId();
    }

    //todo
    //grazina negerai "pageNumber - 1"
    @GetMapping("/{blogEntryId}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBlogEntry(@PathVariable Long blogEntryId, Model model) {
        blogEntryService.deleteBlogEntry(blogEntryId);
        List<BlogEntry> blogEntries = blogEntryService.getAllBlogEntries();
        model.addAttribute("blogEntries", blogEntries);
        return "blogentries";
    }

    @GetMapping("{blogEntryId}/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUpdateBlogEntry(@PathVariable Long blogEntryId, Model model, @AuthenticationPrincipal User user) {
        BlogEntry blogEntry = blogEntryService.getBlogEntry(blogEntryId);
        model.addAttribute("user", user);
        model.addAttribute("blogentry", blogEntry);
        return "blogentryform";
    }

    @GetMapping
    public String getBlogEntriesByPage(
            @RequestParam(defaultValue = "0") int pageNumber,
//            @RequestParam(required = false) BigDecimal price,
            Model model,
            @AuthenticationPrincipal User user
    ) {
        Page<BlogEntry> blogEntries = blogEntryService.getAllBlogEntriesPaginated(pageNumber);
        model.addAttribute("blogEntries", blogEntries.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("hasNextPage", blogEntries.hasNext());
        model.addAttribute("user", user);
        return "blogentries";
    }




}
