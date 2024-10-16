package com.dosol.demo1.service;

import com.dosol.demo1.dto.BoardDTO;
import com.dosol.demo1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
//이게 어떤 필드가 올지 모르지만 이게 있으면 필드 알아서 뭘 해줌
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    //어디어디 있는지 root-context에서 알려줬었는데, 지금은 없어서 빨간줄 남 boardmapper가
    //BoardMapper에 내가 @Mapper 입니다 해주니까 빨간줄 사라짐.

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.selectAll();
    }
}
