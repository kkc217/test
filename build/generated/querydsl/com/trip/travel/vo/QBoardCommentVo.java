package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardCommentVo is a Querydsl query type for BoardCommentVo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardCommentVo extends EntityPathBase<BoardCommentVo> {

    private static final long serialVersionUID = -891973297L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardCommentVo boardCommentVo = new QBoardCommentVo("boardCommentVo");

    public final QBoardVo boardVo;

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberVo memberVo;

    public QBoardCommentVo(String variable) {
        this(BoardCommentVo.class, forVariable(variable), INITS);
    }

    public QBoardCommentVo(Path<? extends BoardCommentVo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardCommentVo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardCommentVo(PathMetadata metadata, PathInits inits) {
        this(BoardCommentVo.class, metadata, inits);
    }

    public QBoardCommentVo(Class<? extends BoardCommentVo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardVo = inits.isInitialized("boardVo") ? new QBoardVo(forProperty("boardVo"), inits.get("boardVo")) : null;
        this.memberVo = inits.isInitialized("memberVo") ? new QMemberVo(forProperty("memberVo")) : null;
    }

}

