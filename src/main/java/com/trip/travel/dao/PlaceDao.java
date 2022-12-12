package com.trip.travel.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.PlaceVo;
import com.trip.travel.vo.QPlaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.travel.vo.QBoardVo.boardVo;
import static com.trip.travel.vo.QPlaceVo.placeVo;

@Repository
@RequiredArgsConstructor
public class PlaceDao {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public List<PlaceVo> findByTitle(String title) {
        return queryFactory.selectFrom(placeVo)
                .where(placeVo.title.contains(title))
                .fetch();
    }

}
