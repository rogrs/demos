package br.com.rogrs.repository;
import br.com.rogrs.model.OrderDetail;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = OrderDetailRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = OrderDetail.class)
public interface OrderDetailRepository extends DetachableJpaRepository<OrderDetail, Long>, OrderDetailRepositoryCustom {
}
