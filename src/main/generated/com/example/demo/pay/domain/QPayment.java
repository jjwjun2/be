package com.example.demo.pay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = -1621914180L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayment payment = new QPayment("payment");

    public final ListPath<com.example.demo.brd.domain.Board, com.example.demo.brd.domain.QBoard> boardList = this.<com.example.demo.brd.domain.Board, com.example.demo.brd.domain.QBoard>createList("boardList", com.example.demo.brd.domain.Board.class, com.example.demo.brd.domain.QBoard.class, PathInits.DIRECT2);

    public final com.example.demo.cart.domain.QCart cart;

    public final StringPath dvrFee = createString("dvrFee");

    public final NumberPath<Long> payAmount = createNumber("payAmount", Long.class);

    public final StringPath payDate = createString("payDate");

    public final NumberPath<Integer> payNo = createNumber("payNo", Integer.class);

    public final StringPath payPrice = createString("payPrice");

    public final StringPath payState = createString("payState");

    public final com.example.demo.prd.domain.QProduct product;

    public final ListPath<com.example.demo.rcv.domain.Receiver, com.example.demo.rcv.domain.QReceiver> receiverList = this.<com.example.demo.rcv.domain.Receiver, com.example.demo.rcv.domain.QReceiver>createList("receiverList", com.example.demo.rcv.domain.Receiver.class, com.example.demo.rcv.domain.QReceiver.class, PathInits.DIRECT2);

    public final com.example.demo.usr.domain.QUser user;

    public QPayment(String variable) {
        this(Payment.class, forVariable(variable), INITS);
    }

    public QPayment(Path<? extends Payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayment(PathMetadata metadata, PathInits inits) {
        this(Payment.class, metadata, inits);
    }

    public QPayment(Class<? extends Payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new com.example.demo.cart.domain.QCart(forProperty("cart"), inits.get("cart")) : null;
        this.product = inits.isInitialized("product") ? new com.example.demo.prd.domain.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.usr.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

