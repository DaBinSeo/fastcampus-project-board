package org.fastcampus.projectboard.repository;

import org.fastcampus.projectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource     //spring data rest
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
