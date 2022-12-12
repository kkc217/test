package com.trip.travel.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.travel.vo.BoardCommentVo;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.QBoardCommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.travel.vo.QBoardCommentVo.boardCommentVo;
import static com.trip.travel.vo.QBoardVo.boardVo;

@Repository
@RequiredArgsConstructor
public class BoardCommentDao {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(BoardCommentVo boardCommentVo) {
        em.persist(boardCommentVo);
    }

    public List<BoardCommentVo> findCommentsByBoard(BoardVo boardVo) {
        return queryFactory.selectFrom(boardCommentVo)
                .where(boardCommentVo.boardVo.eq(boardVo))
                .orderBy(boardCommentVo.createdTime.desc())
                .fetch();
    }

}
