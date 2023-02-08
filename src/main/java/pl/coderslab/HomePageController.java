package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.article.Article;
import pl.coderslab.article.ArticleRepository;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorRepository;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class HomePageController {
    private final ArticleRepository articleRepo;
    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;

    public HomePageController(
            ArticleRepository articleRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
        this.articleRepo = articleRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("/")
    public String displayArticlesOnHomePage(Model model) {
        List<Article> articles = articleRepo
                .getAllByOrderByCreatedOnDesc()
                .stream()
                .limit(5)
                .collect(Collectors.toList());

        model.addAttribute("articles", articles);

        return "homePage";
    }
    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepo.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepo.findAll();
    }

//    @RequestMapping("/category/new")
//    @ResponseBody
//    public String newCategory() {
//        Category category = new Category();
//        category.setName("Global news");
//        category.setDescription("From around the world.");
//        categoryRepo.save(category);
//
//        Category category2 = new Category();
//        category2.setName("Local news");
//        category2.setDescription("Everything you need to know about your neighbourhood.");
//        categoryRepo.save(category2);
//
//        Category category3 = new Category();
//        category3.setName("Fashion");
//        category3.setDescription("Beauty awaits behind every corner.");
//        categoryRepo.save(category3);
//
//        Category category4 = new Category();
//        category4.setName("Technology");
//        category4.setDescription("Digital world.");
//        categoryRepo.save(category4);
//
//        Category category5 = new Category();
//        category5.setName("Culture");
//        category5.setDescription("Theater, music, cinema and books.");
//        categoryRepo.save(category5);
//
//        Category category6 = new Category();
//        category6.setName("Health");
//        category6.setDescription("Feel safe every day.");
//        categoryRepo.save(category6);
//
//        return category6.toString();
//    }
}
