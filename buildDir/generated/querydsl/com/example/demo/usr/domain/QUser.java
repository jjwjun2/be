package com.example.demo.usr.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 683814593L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.example.demo.lvl.domain.QLevel level;

    public final ListPath<com.example.demo.pay.domain.Payment, com.example.demo.pay.domain.QPayment> userList = this.<com.example.demo.pay.domain.Payment, com.example.demo.pay.domain.QPayment>createList("userList", com.example.demo.pay.domain.Payment.class, com.example.demo.pay.domain.QPayment.class, PathInits.DIRECT2);

    public final StringPath usrAddr = createString("usrAddr");

    public final StringPath usrAges = createString("usrAges");

    public final StringPath usrCity = createString("usrCity");

    public final StringPath usrEmail = createString("usrEmail");

    public final StringPath usrGender = createString("usrGender");

    public final StringPath usrName = createString("usrName");

    public final StringPath usrNickname = createString("usrNickname");

    public final NumberPath<Long> usrNo = createNumber("usrNo", Long.class);

    public final StringPath usrPhone = createString("usrPhone");

    public final StringPath usrPwd = createString("usrPwd");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.level = inits.isInitialized("level") ? new com.example.demo.lvl.domain.QLevel(forProperty("level")) : null;
    }

}

