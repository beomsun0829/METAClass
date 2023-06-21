package com.metaclass.metaclass.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.metaclass.metaclass.board.service.BoardService;
import com.metaclass.metaclass.board.model.Board;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<Board> getBoardList() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable(value = "id") int boardId) {
        return boardService.getBoardById(boardId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable(value = "id") int boardId,
            @RequestBody Board boardDetails,
            @RequestParam("password") String password) {
        Board board = boardService.getBoardById(boardId).orElse(null);

        if (board == null) {
            return ResponseEntity.notFound().build();
        }

        if (!boardService.isPasswordMatch(board, password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Board updatedBoard = boardService.updateBoard(boardId, boardDetails).orElse(null);

        if (updatedBoard == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(updatedBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable(value = "id") int boardId,
            @RequestParam("password") String password) {
        Board board = boardService.getBoardById(boardId).orElse(null);

        if (board == null) {
            return ResponseEntity.notFound().build();
        }

        if (!boardService.isPasswordMatch(board, password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public String test() {
        return "You are in board controller";
    }
}
