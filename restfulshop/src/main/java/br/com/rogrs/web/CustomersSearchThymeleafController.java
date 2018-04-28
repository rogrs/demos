package br.com.rogrs.web;
import br.com.rogrs.model.Customer;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.finder.RooSearch;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = CustomersSearchThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Customer.class, type = ControllerType.SEARCH)
@RooSearch(finders = { "findByFirstNameAndLastName" })
@RooThymeleaf
public class CustomersSearchThymeleafController {
}
