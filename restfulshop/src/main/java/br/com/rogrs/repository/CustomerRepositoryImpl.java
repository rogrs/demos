package br.com.rogrs.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import br.com.rogrs.model.Customer;

/**
 * = CustomerRepositoryImpl
 *
 * Implementation of CustomerRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerRepositoryCustom.class)
public class CustomerRepositoryImpl extends QueryDslRepositorySupportExt<Customer> implements CustomerRepositoryCustom{

    /**
     * Default constructor
     */
    CustomerRepositoryImpl() {
        super(Customer.class);
    }
}