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

    @Override
    public BoardDTO getOne(int bno) {
        boardMapper.visitCountUpdate(bno);
        //이거 왜 이렇게 하지. 한개 페이지를 읽을때마다 업데이트를 하겠다는거네. 그래서 서비스에 따로 없구나.
        return boardMapper.selectOne(bno);
    }

    @Override
    public void register(BoardDTO boardDTO) {
        boardMapper.insert(boardDTO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        BoardDTO dto = boardMapper.selectOne(boardDTO.getBno());
        boardMapper.update(boardDTO);
        //만약 전체 다 업데이트하면 전달된 데이터가 3가지뿐이라서 나머지가 null이 된다. 그래서 어떻게 하냐면 밑에봐
//        BoardDTO dto = boardMapper.selectOne(boardDTO.getBno());
//        dto.setVisitcount(dto.getVisitcount());
//        dto.setPostdate(boardDTO.getPostdate());
        //이렇게 해줘야함. 바꿀건 바꾸고 안바뀌는건 그대로 하라 이뜻인가봄
    }

    @Override
    public void remove(int bno) {
        boardMapper.delete(bno);
    }
}
