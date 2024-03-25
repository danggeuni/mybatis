package com.mybatis.mybatis.controller;

import com.mybatis.mybatis.domain.dto.BoardDto;
import com.mybatis.mybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);

        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDto boardDto, Model model) {
        boardService.update(boardDto);
        BoardDto dto = boardService.findById(boardDto.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/list";
    }
}
