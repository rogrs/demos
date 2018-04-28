package br.com.rogrs.model;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;

/**
 * = Customer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{firstName} #{lastName}")
@RooEquals(isJpaEntity = true)
public class Customer {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String firstName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String lastName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToOne(cascade = { javax.persistence.CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "customer")
    @RooJpaRelation(type = JpaRelationType.COMPOSITION)
    @EntityFormat
    private Address address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customer")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<CustomerOrder> orders = new HashSet<CustomerOrder>();
}
