package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberVo is a Querydsl query type for MemberVo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberVo extends EntityPathBase<MemberVo> {

    private static final long serialVersionUID = -1842802480L;

    public static final QMemberVo memberVo = new QMemberVo("memberVo");

    public final StringPath email = createString("email");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final DateTimePath<java.time.LocalDateTime> joinDate = createDateTime("joinDate", java.time.LocalDateTime.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath profileImage = createString("profileImage");

    public QMemberVo(String variable) {
        super(MemberVo.class, forVariable(variable));
    }

    public QMemberVo(Path<? extends MemberVo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberVo(PathMetadata metadata) {
        super(MemberVo.class, metadata);
    }

}

