package br.com.rogrs.web;
import br.com.rogrs.model.Product;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = ProductsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Product.class, type = ControllerType.ITEM)
@RooThymeleaf
public class ProductsItemThymeleafController implements ConcurrencyManager<Product> {
}
