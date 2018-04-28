package br.com.rogrs.repository;
import br.com.rogrs.model.Customer;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import br.com.rogrs.model.CustomerFindByFirstNameAndLastName;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;

/**
 * = CustomerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Customer.class, finders = { @RooFinder(value = "findByFirstNameAndLastName", returnType = Customer.class, formBean = CustomerFindByFirstNameAndLastName.class) })
public interface CustomerRepository extends DetachableJpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
