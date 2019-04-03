package com.spg.admin.service;

import com.spg.admin.dao.RoomMapper;
import com.spg.admin.domain.Room;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoomServciceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    @Override
    public void insertOne(Room room) {
        roomMapper.insertOne(room);
    }

    @Override
    public Long isExist(Long roomId){
        return roomMapper.isExist(roomId);
    }
}
