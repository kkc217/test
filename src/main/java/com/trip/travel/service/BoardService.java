package com.trip.travel.service;

import com.trip.travel.dao.BoardCommentDao;
import com.trip.travel.dao.BoardDao;
import com.trip.travel.dao.BoardLikeDao;
import com.trip.travel.vo.BoardCommentVo;
import com.trip.travel.vo.BoardLikeVo;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;

    private final BoardCommentDao boardCommentDao;

    private final BoardLikeDao boardLikeDao;

    private static int BOARD_LIMIT = 10;

    public List<BoardVo> getBoards(int page, int limit) {
        return boardDao.findBoardsPaging(limit * (page - 1), limit);
    }

    public Long getBoardCount() {
        return boardDao.countAllBoard();
    }

    public List<BoardVo> getBoardsSearching(String content, int page) {
        return boardDao.findBoardsSearching(content, BOARD_LIMIT * (page - 1), BOARD_LIMIT);
    }

    public Long getTotalPage(String content) {
        return (boardDao.countTotalCount(content) / 10L) + 1;
    }

    @Transactional
    public void createNewBoard(BoardVo board) {
        boardDao.save(board);
    }

    public BoardVo getBoard(Long boardId) {
        return boardDao.findById(boardId);
    }

    @Transactional
    public void createNewBoardComment(BoardCommentVo boardComment) {
        boardCommentDao.save(boardComment);
    }

    public List<BoardCommentVo> getBoardComments(BoardVo board) {
        return boardCommentDao.findCommentsByBoard(board);
    }

    public boolean checkLike(BoardVo board, MemberVo member) {
        BoardLikeVo boardLike = boardLikeDao.getBoardLike(board, member);
        return boardLike != null;
    }

    @Transactional
    public void changeLike(BoardVo board, MemberVo member, boolean changedLike) {
        if (changedLike) {
            BoardLikeVo boardLike = new BoardLikeVo(board, member);
            boardLikeDao.save(boardLike);
        } else {
            boardLikeDao.deleteBoardLike(board, member);
        }
    }

}
