package com.mybatis.mybatis.domain.repository;

import com.mybatis.mybatis.domain.dto.BoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public BoardRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void save(BoardDto boardDto) {
        sqlSessionTemplate.insert("Board.save", boardDto);
    }

    public List<BoardDto> findAll() {
        return sqlSessionTemplate.selectList("Board.findAll");
    }

    public void updateHits(Long id) {
        sqlSessionTemplate.update("Board.updateHits", id);
    }

    public BoardDto findById(Long id) {
        return sqlSessionTemplate.selectOne("Board.findById", id);
    }

    public void update(BoardDto boardDto) {
        sqlSessionTemplate.update("Board.update", boardDto);
    }

    public void delete(Long id) {
        sqlSessionTemplate.delete("Board.delete", id);
    }
}
