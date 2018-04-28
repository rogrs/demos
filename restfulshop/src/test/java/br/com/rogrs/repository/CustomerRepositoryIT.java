package br.com.rogrs.repository;
import br.com.rogrs.dod.DataOnDemandConfiguration;
import br.com.rogrs.model.dod.CustomerDataOnDemand;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;

/**
 * = CustomerRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = CustomerRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = CustomerDataOnDemand.class)
public class CustomerRepositoryIT {
}
