package com.trip.travel.vo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardVo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberVo memberVo;

    private String title;

    private String content;

    private LocalDateTime createdTime;

    private String placeTag;

    @Builder
    public BoardVo(MemberVo member, String title, String content, String placeTag) {
        this.memberVo = member;
        this.title = title;
        this.content = content;
        this.createdTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        this.placeTag = placeTag;
    }

}
