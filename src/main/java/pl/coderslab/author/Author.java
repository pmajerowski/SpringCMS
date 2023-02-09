package pl.coderslab.author;

import pl.coderslab.article.Article;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "authors")
public class Author {
    // class fields:
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    //getters and setters:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName ;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }
}
