package com.metaclass.metaclass.board.repository;

import com.metaclass.metaclass.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
