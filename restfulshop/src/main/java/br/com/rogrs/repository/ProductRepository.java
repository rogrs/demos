package br.com.rogrs.repository;
import br.com.rogrs.model.Product;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = ProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Product.class)
public interface ProductRepository extends DetachableJpaRepository<Product, Long>, ProductRepositoryCustom {
}
