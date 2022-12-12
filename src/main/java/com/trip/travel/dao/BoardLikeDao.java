package com.trip.travel.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.travel.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.travel.vo.QBoardCommentVo.boardCommentVo;
import static com.trip.travel.vo.QBoardLikeVo.boardLikeVo;

@Repository
@RequiredArgsConstructor
public class BoardLikeDao {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(BoardLikeVo boardLikeVo) {
        em.persist(boardLikeVo);
    }

    public BoardLikeVo getBoardLike(BoardVo board, MemberVo member) {
        return queryFactory.selectFrom(boardLikeVo)
                .where(boardLikeVo.boardVo.eq(board), boardLikeVo.memberVo.eq(member))
                .fetchOne();
    }

    public void deleteBoardLike(BoardVo board, MemberVo member) {
        queryFactory
                .delete(boardLikeVo)
                .where(boardLikeVo.boardVo.eq(board), boardLikeVo.memberVo.eq(member))
                .execute();
    }
}
