package com.dosol.demo1.service;

import com.dosol.demo1.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO getOne(int bno);
    void register(BoardDTO boardDTO);
    void modify(BoardDTO boardDTO);
    void remove(int bno);

//    매퍼에 있는 아이디를 왜 같이 안쓸까?
    //visitcount는 read할때 호출하니까 여기서 안만든다네

}
