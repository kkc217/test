package com.trip.travel.controller;

import com.trip.travel.service.BoardService;
import com.trip.travel.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    @RequestMapping("")
    public String home(HttpServletRequest request) {
        List<BoardVo> boardList = boardService.getBoards(1, 5);
        request.setAttribute("boardList", boardList);

        return "home";
    }

}
