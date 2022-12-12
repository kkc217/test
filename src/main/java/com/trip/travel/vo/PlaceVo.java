package com.trip.travel.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "place")
public class PlaceVo {

    @Id
    @Column(name = "place_id")
    private Long id;

    private String title;

    private String address;

    private String shortIntroduction;

    private String dialNum;

    private String type;

    private String imageUrl;

    private String zipCode;

    private String tag;

    private Double latitude;

    private Double longitude;

    private String introduction;

}
