package com.trip.travel.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.trip.travel.vo.QBoardVo.boardVo;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public void save(BoardVo boardVo) {
        em.persist(boardVo);
    }

    public BoardVo findById(Long boardId) {
        return queryFactory.selectFrom(boardVo)
                .where(boardVo.id.eq(boardId))
                .fetchOne();
    }

    public List<BoardVo> findBoardsByEmail(String email) {
        return queryFactory.selectFrom(boardVo)
                .where(boardVo.memberVo.email.eq(email))
                .fetch();
    }

    public List<BoardVo> findBoardsPaging(int page, int limit) {
        return queryFactory.selectFrom(boardVo)
                .orderBy(boardVo.createdTime.desc())
                .offset(page)
                .limit(limit)
                .fetch();
    }

    public Long countAllBoard() {
        return queryFactory.select(boardVo.count())
                .from(boardVo)
                .fetchOne();
    }

    public List<BoardVo> findBoardsSearching(String content, int page, int limit) {
        return queryFactory.selectFrom(boardVo)
                .where(boardVo.placeTag.contains(content)
                        .or(boardVo.title.contains(content)))
                .orderBy(boardVo.createdTime.desc())
                .offset(page)
                .limit(limit)
                .fetch();
    }

    public Long countTotalCount(String content) {
        return queryFactory.select(boardVo.count())
                .from(boardVo)
                .where(boardVo.placeTag.contains(content)
                        .or(boardVo.title.contains(content)))
                .fetchOne();
    }
}
