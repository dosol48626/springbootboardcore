package com.dosol.demo1.controller;

import com.dosol.demo1.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2

@RequestMapping("/board")
public class BoardController {
    @Autowired
    //final 쓰고 싶으면 리콰이어드 아그 컨스트럭트 해줘야함. @Log밑에
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        //근데 여기서 Model이 뭐지??
        log.info("list");
        model.addAttribute("boardList", boardService.getList());
    }
}
