package br.com.rogrs.web;
import br.com.rogrs.model.OrderDetail;
import br.com.rogrs.service.api.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = OrderDetailDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = OrderDetail.class)
public class OrderDetailDeserializer extends JsonObjectDeserializer<OrderDetail> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailService orderDetailService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailService
     * @param conversionService
     */
    @Autowired
    public OrderDetailDeserializer(@Lazy OrderDetailService orderDetailService, ConversionService conversionService) {
        this.orderDetailService = orderDetailService;
        this.conversionService = conversionService;
    }
}
