package com.trip.travel.service;

import com.trip.travel.dao.BoardDao;
import com.trip.travel.dao.PlaceDao;
import com.trip.travel.vo.BoardVo;
import com.trip.travel.vo.PlaceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceDao placeDao;

    public List<PlaceVo> getPlaceListByTag(String placeTag) {
        List<String> tagList = Arrays.asList(placeTag.split(","));
        List<PlaceVo> placeList = new ArrayList<>();
        for (String tag : tagList) {
            List<PlaceVo> placeVoList = placeDao.findByTitle(tag);
            if (placeVoList != null && placeVoList.size() > 0) {
                placeList.add(placeVoList.get(0));
            }
        }

        return placeList;
    }

}
