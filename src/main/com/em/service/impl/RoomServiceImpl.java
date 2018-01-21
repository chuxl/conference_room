package main.com.em.service.impl;

import main.com.em.dao.RoomMapper;
import main.com.em.domain.PagingVO;
import main.com.em.domain.Room;
import main.com.em.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Integer roomCount() {
        return roomMapper.roomCount();
    }

    @Override
    public List<Room> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Room> list = roomMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public void add(Room room) throws Exception {
        roomMapper.add(room);
    }

    @Override
    public Room findById(Integer id) throws Exception {
        return roomMapper.findById(id);
    }

    @Override
    public void updateById(Room room) throws Exception {
        roomMapper.updateById(room);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        roomMapper.removeById(id);
    }

    @Override
    public List<Room> findByName(String name) throws Exception {
        return roomMapper.findByName(name);
    }

    @Override
    public List<Room> nameList() throws Exception {
        return roomMapper.nameList();
    }

}
