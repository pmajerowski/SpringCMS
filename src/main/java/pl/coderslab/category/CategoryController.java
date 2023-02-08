package pl.coderslab.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.article.ArticleRepository;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    public CategoryController(
            CategoryRepository categoryRepository, AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/category/new")
    public String newCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "/category/new";
    }

    @PostMapping("/category/save")
    public String saveCategory(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/category/new";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/category/list")
    public String listCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "/category/list";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable long id, Model model) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("categoryToEdit", category);
        return "/category/edit";
    }

    @PostMapping("/category/edit/save/{id}")
    public String editCategory(Category category, @PathVariable long id) {
        category.setId(id);
        categoryRepository.save(category);
        return "redirect:/category/list";
//        return book.toString() + " , id= " + id;
    }

    @GetMapping("/category/confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/category/deleteConfirm";
    }

    @RequestMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return "redirect:/category/list";
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


