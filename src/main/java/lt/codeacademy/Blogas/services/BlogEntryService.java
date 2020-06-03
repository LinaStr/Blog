package lt.codeacademy.Blogas.services;

import lt.codeacademy.Blogas.controller.BlogEntryNotFoundException;
import lt.codeacademy.Blogas.entities.BlogEntry;
import lt.codeacademy.Blogas.repositories.BlogEntryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BlogEntryService {

    private BlogEntryRepository blogEntryRepository;

    public BlogEntryService(BlogEntryRepository blogEntryRepository) {
        this.blogEntryRepository = blogEntryRepository;
    }

    public BlogEntry getBlogEntry(Long id) {
        BlogEntry blogEntry = blogEntryRepository.findById(id)
            .orElseThrow(() -> new BlogEntryNotFoundException("Blog Entry was not found"));
        return blogEntry;
    }

    public void deleteBlogEntry(Long id) {
        blogEntryRepository.deleteById(id);
    }

    public BlogEntry createOrUpdateBlogEntry(BlogEntry blogEntry) {
        return blogEntryRepository.save(blogEntry);
    }

    public List<BlogEntry> getAllBlogEntries() {
        return blogEntryRepository.findAll();
    }

    public Page<BlogEntry> getAllBlogEntriesPaginated(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
//        if (price != null) {
//            return blogEntryRepository.getAllByPrice(price, pageable);
//        }
        return blogEntryRepository.findAll(pageable);
    }
}
