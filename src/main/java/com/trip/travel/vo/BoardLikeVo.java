package com.trip.travel.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@Table(name = "board_like")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardLikeVo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardVo boardVo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberVo memberVo;

    private LocalDateTime createdTime;

    public BoardLikeVo(BoardVo board, MemberVo member) {
        this.boardVo = board;
        this.memberVo = member;
        this.createdTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

}
