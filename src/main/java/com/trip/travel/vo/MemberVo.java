package com.trip.travel.vo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "member")
public class MemberVo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private String introduction;

    private String profileImage;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime joinDate;

}
