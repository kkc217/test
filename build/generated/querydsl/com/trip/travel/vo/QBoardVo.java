package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardVo is a Querydsl query type for BoardVo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardVo extends EntityPathBase<BoardVo> {

    private static final long serialVersionUID = -1094914366L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardVo boardVo = new QBoardVo("boardVo");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberVo memberVo;

    public final StringPath placeTag = createString("placeTag");

    public final StringPath title = createString("title");

    public QBoardVo(String variable) {
        this(BoardVo.class, forVariable(variable), INITS);
    }

    public QBoardVo(Path<? extends BoardVo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardVo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardVo(PathMetadata metadata, PathInits inits) {
        this(BoardVo.class, metadata, inits);
    }

    public QBoardVo(Class<? extends BoardVo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberVo = inits.isInitialized("memberVo") ? new QMemberVo(forProperty("memberVo")) : null;
    }

}

