package org.fastcampus.projectboard.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.fastcampus.projectboard.domain.ArticleComment;
import org.fastcampus.projectboard.domain.QArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource   //spring data rest
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content,root.createdAt,root.createdBy);
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase));  // like '%{}%'
        bindings.bind(root.createdAt).first((DateTimeExpression::eq));  // like '%{}%'
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));  // like '%{}%'
    }

}
