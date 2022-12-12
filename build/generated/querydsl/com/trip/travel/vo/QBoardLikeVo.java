package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardLikeVo is a Querydsl query type for BoardLikeVo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardLikeVo extends EntityPathBase<BoardLikeVo> {

    private static final long serialVersionUID = 336651321L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardLikeVo boardLikeVo = new QBoardLikeVo("boardLikeVo");

    public final QBoardVo boardVo;

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberVo memberVo;

    public QBoardLikeVo(String variable) {
        this(BoardLikeVo.class, forVariable(variable), INITS);
    }

    public QBoardLikeVo(Path<? extends BoardLikeVo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardLikeVo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardLikeVo(PathMetadata metadata, PathInits inits) {
        this(BoardLikeVo.class, metadata, inits);
    }

    public QBoardLikeVo(Class<? extends BoardLikeVo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardVo = inits.isInitialized("boardVo") ? new QBoardVo(forProperty("boardVo"), inits.get("boardVo")) : null;
        this.memberVo = inits.isInitialized("memberVo") ? new QMemberVo(forProperty("memberVo")) : null;
    }

}

