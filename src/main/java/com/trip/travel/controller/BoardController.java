package com.trip.travel.controller;

import com.trip.travel.service.BoardService;
import com.trip.travel.service.PlaceService;
import com.trip.travel.vo.BoardCommentVo;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.MemberVo;
import com.trip.travel.vo.PlaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    private final PlaceService placeService;

    @GetMapping("")
    public String boardForm(
            @RequestParam(value = "search", required = false, defaultValue = "") String content,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            HttpServletRequest request) {
        request.setAttribute("searchContent", content == null ? "" : content);
        request.setAttribute("currentPage", page);

        List<BoardVo> boardList;
        if (content.length() > 0) {
            boardList = boardService.getBoardsSearching(content, page);
            request.setAttribute("totalPage", 1);
        } else {
            boardList = boardService.getBoards(page, 10);
            request.setAttribute("totalPage", 3);
        }
        request.setAttribute("boardList", boardList);

        Long totalPage = boardService.getTotalPage(content);
        request.setAttribute("totalPage", Integer.parseInt(totalPage.toString()));
        return "board/board_list";
    }

    @GetMapping("/new")
    public String newBoardForm() {
        return "board/board_new";
    }

    @PostMapping("/new")
    public String createNewBoard(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "placeTag") String placeTag,
            @SessionAttribute(name = "loginMember", required = false) MemberVo member) {
        BoardVo board = BoardVo.builder()
                .member(member)
                .title(title)
                .content(content)
                .placeTag(placeTag)
                .build();

        boardService.createNewBoard(board);

        return "redirect:";
    }

    @GetMapping("/{boardId}")
    public String boardDetail(
            HttpServletRequest request,
            @PathVariable(name = "boardId") Long boardId,
            @SessionAttribute(name = "loginMember", required = false) MemberVo member) {
        BoardVo board = boardService.getBoard(boardId);
        request.setAttribute("board", board);

        List<PlaceVo> placeList = new ArrayList<>();
        if (board.getPlaceTag() != null && board.getPlaceTag().length() > 0) {
            placeList.addAll(placeService.getPlaceListByTag(board.getPlaceTag()));
        }
        request.setAttribute("placeList", placeList);

        List<BoardCommentVo> boardCommentList = boardService.getBoardComments(board);
        request.setAttribute("commentList", boardCommentList);

        boolean isLike = false;
        if (member != null) {
            isLike = boardService.checkLike(board, member);
        }
        request.setAttribute("boardLike", isLike);

        return "/board/board_detail";
    }

    @PostMapping("/comment")
    public String addBoardComment(
            @RequestParam(value = "boardId") Long boardId,
            @RequestParam(value = "content") String content,
            @SessionAttribute(name = "loginMember", required = false) MemberVo member) {
        BoardVo board = boardService.getBoard(boardId);
        BoardCommentVo boardComment = BoardCommentVo.builder()
                .board(board)
                .member(member)
                .content(content)
                .build();

        boardService.createNewBoardComment(boardComment);
        return "redirect:/board/" + boardId;
    }

    @PostMapping("/like")
    public String changeBoard(
            @RequestParam(value = "changedLike") boolean changedLike,
            @RequestParam(value = "boardId") Long boardId,
            @SessionAttribute(name = "loginMember", required = false) MemberVo member) {
        BoardVo board = boardService.getBoard(boardId);
        boardService.changeLike(board, member, changedLike);
        return "redirect:/board/" + boardId;
    }

}
