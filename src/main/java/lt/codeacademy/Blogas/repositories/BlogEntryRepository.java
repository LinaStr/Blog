package lt.codeacademy.Blogas.repositories;

import lt.codeacademy.Blogas.entities.BlogEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface BlogEntryRepository extends JpaRepository<BlogEntry, Long> {

//      @Query("SELECT p FROM Product p WHERE p.price = ?1")
//      List<Product> getProductsByPrice(Double price);

//      @Query(value = "SELECT * FROM Products WHERE price=?1", nativeQuery = true)
//      List<Product> getProductsByPrice(Double price);

        Page<BlogEntry> getAllByCreatedOn(LocalDateTime createdOn, Pageable pageable);

}
