package com.example.demo.brd.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 2091262512L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final StringPath brdContent = createString("brdContent");

    public final StringPath brdImg = createString("brdImg");

    public final NumberPath<Long> brdKind = createNumber("brdKind", Long.class);

    public final StringPath brdLike = createString("brdLike");

    public final NumberPath<Long> brdNo = createNumber("brdNo", Long.class);

    public final StringPath brdPwd = createString("brdPwd");

    public final StringPath brdRank = createString("brdRank");

    public final StringPath brdTitle = createString("brdTitle");

    public final StringPath brdWrtDate = createString("brdWrtDate");

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final com.example.demo.pay.domain.QPayment payment;

    public final com.example.demo.prd.domain.QProduct product;

    public final ListPath<com.example.demo.rpl.domain.Reply, com.example.demo.rpl.domain.QReply> replyList = this.<com.example.demo.rpl.domain.Reply, com.example.demo.rpl.domain.QReply>createList("replyList", com.example.demo.rpl.domain.Reply.class, com.example.demo.rpl.domain.QReply.class, PathInits.DIRECT2);

    public final com.example.demo.usr.domain.QUser user;

    public final StringPath usrNickname = createString("usrNickname");

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new com.example.demo.pay.domain.QPayment(forProperty("payment"), inits.get("payment")) : null;
        this.product = inits.isInitialized("product") ? new com.example.demo.prd.domain.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.example.demo.usr.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

