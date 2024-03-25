package com.mybatis.mybatis.service;

import com.mybatis.mybatis.domain.dto.BoardDto;
import com.mybatis.mybatis.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void save(BoardDto boardDto) {
        boardRepository.save(boardDto);
    }

    public List<BoardDto> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDto boardDto) {
        boardRepository.update(boardDto);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
