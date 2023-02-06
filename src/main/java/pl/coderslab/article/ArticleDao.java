package pl.coderslab.article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }
    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void delete(Article article) {
        Article persistedArticle = entityManager.contains(article) ? article : entityManager.merge(article);
        entityManager.remove(persistedArticle);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }
}
