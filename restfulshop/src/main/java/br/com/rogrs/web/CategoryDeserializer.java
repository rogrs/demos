package br.com.rogrs.web;
import br.com.rogrs.model.Category;
import br.com.rogrs.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = CategoryDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Category.class)
public class CategoryDeserializer extends JsonObjectDeserializer<Category> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryService categoryService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param conversionService
     */
    @Autowired
    public CategoryDeserializer(@Lazy CategoryService categoryService, ConversionService conversionService) {
        this.categoryService = categoryService;
        this.conversionService = conversionService;
    }
}
