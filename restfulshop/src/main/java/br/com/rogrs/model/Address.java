package br.com.rogrs.model;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.NumberFormat;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * = Address
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
public class Address {

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
    private String street;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String city;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Min(1L)
    @NumberFormat
    private Integer streetNumber;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_customer")
    @EntityFormat
    private Customer customer;
}
