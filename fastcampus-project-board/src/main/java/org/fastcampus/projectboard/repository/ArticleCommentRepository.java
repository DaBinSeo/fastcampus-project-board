package org.fastcampus.projectboard.repository;

import org.fastcampus.projectboard.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource   //spring data rest
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
