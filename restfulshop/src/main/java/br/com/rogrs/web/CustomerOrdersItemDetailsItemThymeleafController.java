package br.com.rogrs.web;
import br.com.rogrs.model.CustomerOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

/**
 * = CustomerOrdersItemDetailsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = CustomerOrder.class, type = ControllerType.DETAIL_ITEM)
@RooDetail(relationField = "details")
@RooThymeleaf
public class CustomerOrdersItemDetailsItemThymeleafController {
}
