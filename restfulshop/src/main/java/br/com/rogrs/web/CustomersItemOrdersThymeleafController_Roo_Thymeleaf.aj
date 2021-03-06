// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.com.rogrs.web;

import br.com.rogrs.model.Customer;
import br.com.rogrs.model.CustomerOrder;
import br.com.rogrs.service.api.CustomerOrderService;
import br.com.rogrs.service.api.CustomerService;
import br.com.rogrs.web.CustomersCollectionThymeleafController;
import br.com.rogrs.web.CustomersCollectionThymeleafLinkFactory;
import br.com.rogrs.web.CustomersItemOrdersThymeleafController;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

privileged aspect CustomersItemOrdersThymeleafController_Roo_Thymeleaf {
    
    declare @type: CustomersItemOrdersThymeleafController: @Controller;
    
    declare @type: CustomersItemOrdersThymeleafController: @RequestMapping(value = "/customers/{customer}/orders", name = "CustomersItemOrdersThymeleafController", produces = MediaType.TEXT_HTML_VALUE);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private CustomerService CustomersItemOrdersThymeleafController.customerService;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private CustomerOrderService CustomersItemOrdersThymeleafController.customerOrderService;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private MessageSource CustomersItemOrdersThymeleafController.messageSource;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private MethodLinkBuilderFactory<CustomersCollectionThymeleafController> CustomersItemOrdersThymeleafController.collectionLink;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private ConversionService CustomersItemOrdersThymeleafController.conversionService;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param customerService
     * @param customerOrderService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CustomersItemOrdersThymeleafController.new(CustomerService customerService, CustomerOrderService customerOrderService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCustomerService(customerService);
        setCustomerOrderService(customerOrderService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(CustomersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @return CustomerService
     */
    public CustomerService CustomersItemOrdersThymeleafController.getCustomerService() {
        return customerService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerService
     */
    public void CustomersItemOrdersThymeleafController.setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return CustomerOrderService
     */
    public CustomerOrderService CustomersItemOrdersThymeleafController.getCustomerOrderService() {
        return customerOrderService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customerOrderService
     */
    public void CustomersItemOrdersThymeleafController.setCustomerOrderService(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return MessageSource
     */
    public MessageSource CustomersItemOrdersThymeleafController.getMessageSource() {
        return messageSource;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param messageSource
     */
    public void CustomersItemOrdersThymeleafController.setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<CustomersCollectionThymeleafController> CustomersItemOrdersThymeleafController.getCollectionLink() {
        return collectionLink;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param collectionLink
     */
    public void CustomersItemOrdersThymeleafController.setCollectionLink(MethodLinkBuilderFactory<CustomersCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ConversionService
     */
    public ConversionService CustomersItemOrdersThymeleafController.getConversionService() {
        return conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param conversionService
     */
    public void CustomersItemOrdersThymeleafController.setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @param locale
     * @param method
     * @return Customer
     */
    @ModelAttribute
    public Customer CustomersItemOrdersThymeleafController.getCustomer(@PathVariable("customer") Long id, Locale locale, HttpMethod method) {
        Customer customer = null;
        if (HttpMethod.PUT.equals(method)) {
            customer = customerService.findOneForUpdate(id);
        } else {
            customer = customerService.findOne(id);
        }
        
        if (customer == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] {"Customer", id}, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return customer;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void CustomersItemOrdersThymeleafController.populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("orderDate_date_format", "dd/MM/yyyy");
        model.addAttribute("shippedDate_date_format", "dd/MM/yyyy");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void CustomersItemOrdersThymeleafController.populateForm(Model model) {
        populateFormats(model);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customer
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<CustomerOrder>> CustomersItemOrdersThymeleafController.datatables(@ModelAttribute Customer customer, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        
        Page<CustomerOrder> orders = getCustomerOrderService().findByCustomer(customer, search, pageable);
        long totalOrdersCount = getCustomerOrderService().countByCustomer(customer);
        ConvertedDatatablesData<CustomerOrder> data =  new ConvertedDatatablesData<CustomerOrder>(orders, totalOrdersCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatablesByIdsIn", produces = Datatables.MEDIA_TYPE, value = "/dtByIdsIn")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<CustomerOrder>> CustomersItemOrdersThymeleafController.datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        
        Page<CustomerOrder> orders = getCustomerOrderService().findAllByIdsIn(ids, search, pageable);
        long totalOrdersCount = orders.getTotalElements();
        ConvertedDatatablesData<CustomerOrder> data =  new ConvertedDatatablesData<CustomerOrder>(orders, totalOrdersCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView CustomersItemOrdersThymeleafController.createForm(@ModelAttribute Customer customer, Model model) {
        populateForm(model);
        model.addAttribute("customerOrder", new CustomerOrder());
        return new ModelAndView("customers/orders/create");
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customer
     * @param ordersToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromOrders", value = "/{ordersToRemove}")
    @ResponseBody
    public ResponseEntity<?> CustomersItemOrdersThymeleafController.removeFromOrders(@ModelAttribute Customer customer, @PathVariable("ordersToRemove") Long ordersToRemove) {
        getCustomerService().removeFromOrders(customer,Collections.singleton(ordersToRemove));
        return ResponseEntity.ok().build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customer
     * @param ordersToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromOrdersBatch", value = "/batch/{ordersToRemove}")
    @ResponseBody
    public ResponseEntity<?> CustomersItemOrdersThymeleafController.removeFromOrdersBatch(@ModelAttribute Customer customer, @PathVariable("ordersToRemove") Collection<Long> ordersToRemove) {
        getCustomerService().removeFromOrders(customer, ordersToRemove);
        return ResponseEntity.ok().build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param customer
     * @param orders
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView CustomersItemOrdersThymeleafController.create(@ModelAttribute Customer customer, @RequestParam(value = "ordersIds", required = false) List<Long> orders, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (orders != null) {
            for (Iterator<Long> iterator = orders.iterator(); iterator.hasNext();) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if(!Objects.equals(version, customer.getVersion()) && StringUtils.isEmpty(concurrencyControl)){
            populateForm(model);
            // Obtain the selected books and include them in the author that will be 
            // included in the view
            if (orders != null) {
                customer.setOrders(new HashSet<CustomerOrder>(getCustomerOrderService().findAll(orders)));
            }else{
                customer.setOrders(new HashSet<CustomerOrder>());
            }
            // Reset the version to prevent update
             customer.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("customer", customer);
            model.addAttribute("concurrency", true);
            return new ModelAndView("customers/orders/create");
        }else if(!Objects.equals(version, customer.getVersion()) && "discard".equals(concurrencyControl)){
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("customer", customer);
            model.addAttribute("concurrency", false);
            return new ModelAndView("customers/orders/create");
        }
        getCustomerService().setOrders(customer,orders);
        return new ModelAndView("redirect:" + getCollectionLink().to(CustomersCollectionThymeleafLinkFactory.LIST).toUriString());
    }
    
}
