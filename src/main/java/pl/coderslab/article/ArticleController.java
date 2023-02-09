package pl.coderslab.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryController;
import pl.coderslab.category.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    public ArticleController(
            CategoryRepository categoryRepository, AuthorRepository authorRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article/{id}")
    public String showArticleById(@PathVariable long id, Model model) {
        model.addAttribute("article", articleRepository.findById(id).get());
        return "/article/get";
    }

    @GetMapping("/article/new")
    public String newArticle(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "/article/new";
    }

    @PostMapping("/article/save")
    public String saveArticle(@Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/article/new";
        }
//        article.prePersist();
        articleRepository.save(article);
        return "redirect:/article/list";
    }

    @GetMapping("/article/list")
    public String listArticles(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "/article/list";
    }

    @GetMapping("/article/edit/{id}")
    public String editArticle(@PathVariable long id, Model model) {
        Article article = articleRepository.findById(id).get();
        model.addAttribute("articleToEdit", article);
        return "/article/edit";
    }

    @PostMapping("/article/edit/save/{id}")
    public String editArticle(Article article, @PathVariable long id) {
//        article.setId(id);
//        article.preUpdate();
        articleRepository.save(article);
        return "redirect:/article/list";
//        return book.toString() + " , id= " + id;
    }

    @GetMapping("/article/confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/article/deleteConfirm";
    }

    @RequestMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        articleRepository.deleteById(id);
        return "redirect:/article/list";
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
