package pl.coderslab.author;

import pl.coderslab.article.Article;

import javax.persistence.*;
import javax.validation.constraints.Min;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @OneToMany(mappedBy = "author")
    private List<Article> articles = new ArrayList<>();

    //getters and setters:
    public Long getId() {
        return id;
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

    public String getName() {
        return firstName + " " + lastName ;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }
}
