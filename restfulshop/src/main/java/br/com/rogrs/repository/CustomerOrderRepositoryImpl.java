package br.com.rogrs.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import br.com.rogrs.model.CustomerOrder;

/**
 * = CustomerOrderRepositoryImpl
 *
 * Implementation of CustomerOrderRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerOrderRepositoryCustom.class)
public class CustomerOrderRepositoryImpl extends QueryDslRepositorySupportExt<CustomerOrder> implements CustomerOrderRepositoryCustom{

    /**
     * Default constructor
     */
    CustomerOrderRepositoryImpl() {
        super(CustomerOrder.class);
    }
}