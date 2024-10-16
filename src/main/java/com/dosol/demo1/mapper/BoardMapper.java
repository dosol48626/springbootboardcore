package com.dosol.demo1.mapper;

import com.dosol.demo1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//내가 매퍼입니다. 하는 그런 어노테이션임
public interface BoardMapper {
    List<BoardDTO> selectAll();
}
