package pl.coderslab.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.article.ArticleRepository;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryController;
import pl.coderslab.category.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    public AuthorController(
            CategoryRepository categoryRepository, AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/author/{id}")
    public String showAuthorById(@PathVariable long id, Model model) {
        model.addAttribute("author", authorRepository.findById(id).get());
        return "/author/get";
    }

    @GetMapping("/author/new")
    public String newAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/new";
    }

    @PostMapping("/author/save")
    public String saveAuthor(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/author/new";
        }
        authorRepository.save(author);
        return "redirect:/author/list";
    }

    @GetMapping("/author/list")
    public String listAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "/author/list";
    }

    @GetMapping("/author/edit/{id}")
    public String editAuthor(@PathVariable long id, Model model) {
        Author author = authorRepository.findById(id).get();
        model.addAttribute("authorToEdit", author);
        return "/author/edit";
    }

    @PostMapping("/author/edit/save/{id}")
    public String editAuthor(Author author, @PathVariable long id) {
        author.setId(id);
        authorRepository.save(author);
        return "redirect:/author/list";
//        return book.toString() + " , id= " + id;
    }

    @GetMapping("/author/confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/author/deleteConfirm";
    }

    @RequestMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable long id) {
        authorRepository.deleteById(id);
        return "redirect:/author/list";
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}

