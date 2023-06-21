package com.metaclass.metaclass.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;
    private String writer;
    private String password;
    private String title;
    @Lob
    private String content;
    private Date regdate;
    private int viewCnt;
    private int replyCnt;
}
