package br.com.rogrs.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerOrder is a Querydsl query type for CustomerOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomerOrder extends EntityPathBase<CustomerOrder> {

    private static final long serialVersionUID = 1490248637L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerOrder customerOrder = new QCustomerOrder("customerOrder");

    public final QCustomer customer;

    public final SetPath<OrderDetail, QOrderDetail> details = this.<OrderDetail, QOrderDetail>createSet("details", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> orderDate = createDateTime("orderDate", java.util.Date.class);

    public final StringPath shipAddress = createString("shipAddress");

    public final DateTimePath<java.util.Date> shippedDate = createDateTime("shippedDate", java.util.Date.class);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QCustomerOrder(String variable) {
        this(CustomerOrder.class, forVariable(variable), INITS);
    }

    public QCustomerOrder(Path<? extends CustomerOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerOrder(PathMetadata metadata, PathInits inits) {
        this(CustomerOrder.class, metadata, inits);
    }

    public QCustomerOrder(Class<? extends CustomerOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer"), inits.get("customer")) : null;
    }

}

