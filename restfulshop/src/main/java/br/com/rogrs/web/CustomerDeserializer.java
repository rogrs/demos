package br.com.rogrs.web;
import br.com.rogrs.model.Customer;
import br.com.rogrs.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = CustomerDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Customer.class)
public class CustomerDeserializer extends JsonObjectDeserializer<Customer> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerService customerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerService
     * @param conversionService
     */
    @Autowired
    public CustomerDeserializer(@Lazy CustomerService customerService, ConversionService conversionService) {
        this.customerService = customerService;
        this.conversionService = conversionService;
    }
}
