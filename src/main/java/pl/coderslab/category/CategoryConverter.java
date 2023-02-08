package pl.coderslab.category;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String, Category> {
    private final CategoryDao categoryDao;

    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String source) {
        return categoryDao.findById(Long.parseLong(source));
    }
}