package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.article.Article;
import pl.coderslab.article.ArticleDao;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.category.CategoryDao;

@Controller
public class TestController {
    AuthorDao authorDao;
    CategoryDao categoryDao;
    ArticleDao articleDao;

    @RequestMapping("/test")
    @ResponseBody
    public String hello() {
        return "ELEKTROWNIA";
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        return "ss";
    }
}

