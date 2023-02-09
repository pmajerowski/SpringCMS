package pl.coderslab.article;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter implements Converter<String, Article> {
    private final ArticleDao articleDao;

    public ArticleConverter(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article convert(String source) {
        return articleDao.findById(Long.parseLong(source));
    }
}