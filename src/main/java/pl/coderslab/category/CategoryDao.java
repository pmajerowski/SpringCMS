package pl.coderslab.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void delete(Category category) {
        Category persistedCategory = entityManager.contains(category) ? category : entityManager.merge(category);
        entityManager.remove(persistedCategory);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }
}
