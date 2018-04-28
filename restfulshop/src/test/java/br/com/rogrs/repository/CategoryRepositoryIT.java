package br.com.rogrs.repository;
import br.com.rogrs.dod.DataOnDemandConfiguration;
import br.com.rogrs.model.dod.CategoryDataOnDemand;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;

/**
 * = CategoryRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = CategoryRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = CategoryDataOnDemand.class)
public class CategoryRepositoryIT {
}
