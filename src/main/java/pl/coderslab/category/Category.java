package pl.coderslab.category;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")
public class Category {
    // class fields:
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2)
    private String name;
    @Nullable
    private String description;

    // getters and setters:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
