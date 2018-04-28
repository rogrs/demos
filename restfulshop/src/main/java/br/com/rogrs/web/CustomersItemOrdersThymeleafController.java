package br.com.rogrs.web;
import br.com.rogrs.model.Customer;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = CustomersItemOrdersThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Customer.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "orders", views = { "list", "findByFirstNameAndLastName" })
@RooThymeleaf
public class CustomersItemOrdersThymeleafController {
}
