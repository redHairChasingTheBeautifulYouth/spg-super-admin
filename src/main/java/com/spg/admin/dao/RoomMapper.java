package com.spg.admin.dao;

import com.spg.admin.domain.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMapper {

    void insertOne(@Param("room") Room room);

    Long isExist(@Param("roomId") Long roomId);
}
