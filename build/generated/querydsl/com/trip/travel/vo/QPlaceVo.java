package com.trip.travel.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaceVo is a Querydsl query type for PlaceVo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceVo extends EntityPathBase<PlaceVo> {

    private static final long serialVersionUID = -1641098077L;

    public static final QPlaceVo placeVo = new QPlaceVo("placeVo");

    public final StringPath address = createString("address");

    public final StringPath dialNum = createString("dialNum");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath introduction = createString("introduction");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath shortIntroduction = createString("shortIntroduction");

    public final StringPath tag = createString("tag");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath zipCode = createString("zipCode");

    public QPlaceVo(String variable) {
        super(PlaceVo.class, forVariable(variable));
    }

    public QPlaceVo(Path<? extends PlaceVo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaceVo(PathMetadata metadata) {
        super(PlaceVo.class, metadata);
    }

}

