package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<MemberVo> {

    private static final long serialVersionUID = 1904487244L;

    public static final QMember member = new QMember("member1");

    public final EnumPath<Authority> authority = createEnum("authority", Authority.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public QMember(String variable) {
        super(MemberVo.class, forVariable(variable));
    }

    public QMember(Path<? extends MemberVo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(MemberVo.class, metadata);
    }

}

