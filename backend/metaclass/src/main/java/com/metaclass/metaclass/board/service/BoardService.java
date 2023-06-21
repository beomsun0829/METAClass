package com.metaclass.metaclass.board.service;

import com.metaclass.metaclass.board.model.Board;
import com.metaclass.metaclass.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(int boardId) {
        return boardRepository.findById(boardId);
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> updateBoard(int boardId, Board boardDetails) {
        return boardRepository.findById(boardId).map(board -> {
            board.setTitle(boardDetails.getTitle());
            board.setContent(boardDetails.getContent());
            return boardRepository.save(board);
        });
    }

    public void deleteBoard(int boardId) {
        boardRepository.findById(boardId).ifPresent(boardRepository::delete);
    }

    public boolean isPasswordMatch(Board board, String password) {
        return board.getPassword().equals(password);
    }
}
