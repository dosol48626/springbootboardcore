package com.dosol.demo1.mapper;

import com.dosol.demo1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//내가 매퍼입니다. 하는 그런 어노테이션임
public interface BoardMapper {
    List<BoardDTO> selectAll();
    BoardDTO selectOne(int bno);
    void insert(BoardDTO board);
    void update(BoardDTO board);
    void delete(int bno);
    void visitCountUpdate(int bno);
    //매퍼 짤때 대략적으로 어떤거 쓸지 다 적고 하는게 편함
}
