package br.com.rogrs.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import br.com.rogrs.model.Category;

/**
 * = CategoryRepositoryImpl
 *
 * Implementation of CategoryRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = CategoryRepositoryCustom.class)
public class CategoryRepositoryImpl extends QueryDslRepositorySupportExt<Category> implements CategoryRepositoryCustom{

    /**
     * Default constructor
     */
    CategoryRepositoryImpl() {
        super(Category.class);
    }
}