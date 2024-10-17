package com.dosol.demo1.controller;

import com.dosol.demo1.dto.BoardDTO;
import com.dosol.demo1.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        //이 모델이 뷰로 이동 시켜주는거임
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("registerGet");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO) {
        log.info("registerPost");
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    //얘는 리드할때랑 모디파이할때 둘다 쓰는거임 페이지 이동할떄
    public void read(@RequestParam("bno") int bno, Model model) {
        //unt bno에 할당하겠다.
        log.info("read");
        BoardDTO dto = boardService.getOne(bno);
        //보드 서비스에서 겟원 할당받음
        model.addAttribute("dto", dto);
        //add어트리뷰트가 뷰로 주는거임
    }

    @PostMapping("/modify")
    //모디파이 페이지에 오면 이 밑에꺼를 쓰겠다는거임
    public String modifyPost(BoardDTO boardDTO) {
        //이게 찐 수정해주는 거임
        //, RedirectAttributes redirectAttributes 이거는 내가 이동하는 페이지, 예를 들어서 지금 read로 가는데,
        //read에 값을 전달하는게 있으면 그때 쓰는거임. 지금은 수정하면서 read에 값을 가져가는게 아니고
        //수정이 된거라서 필요가 없다는....그런건가?? 맞나?? 근데 read로 가면 값이 바껴서 가니까 바뀌는 값이 있는거 아닌가?
        log.info("modiftPost");
        boardService.modify(boardDTO);
        return "redirect:/board/read?bno="+boardDTO.getBno();
    }

    @GetMapping("/remove")
    public String remove(int bno) {
        //리무브는 DTO 다 가져올 필요없이 그냥 bno만 가져와서 그 번호 다 지워버리는거임
        log.info("remove");
        boardService.remove(bno);
        return "redirect:/board/list";
    }
}
