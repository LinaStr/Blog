package lt.codeacademy.Blogas.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "BlogEntry")
public class BlogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlogEntry_id")
    private Long id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "blog_content")
    @NotNull
    private String blogContent;


    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_entry_id")
    private List<Comment> commentsList = new ArrayList<>();


//    private Date created_at;
//    @NotNull
//    private java.sql.Timestamp date;
}
