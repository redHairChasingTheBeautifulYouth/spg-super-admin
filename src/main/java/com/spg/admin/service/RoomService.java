package com.spg.admin.service;


import com.spg.admin.domain.Room;

public interface RoomService {

    /**
     * 生成一个房间
     * @param room
     */
    void insertOne(Room room);

    /**
     * 检查房间是否存在
     * @param roomId
     * @return
     */
    Long isExist(Long roomId);
}
