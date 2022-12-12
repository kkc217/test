package com.trip.travel.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@Table(name = "board_comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCommentVo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardVo boardVo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberVo memberVo;

    private String content;

    private LocalDateTime createdTime;

    @Builder
    public BoardCommentVo(BoardVo board, MemberVo member, String content) {
        this.boardVo = board;
        this.memberVo = member;
        this.content = content;
        this.createdTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

}
