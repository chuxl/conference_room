package main.com.em.dao;

import main.com.em.domain.PagingVO;
import main.com.em.domain.Room;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface RoomMapper {
    public Integer roomCount();

    public List<Room> findByPaging(PagingVO pagingVO) throws Exception;

    public void add(Room room) throws Exception;

    public void updateById(Room room) throws Exception;

    public Room findById(Integer id) throws Exception;

    public void removeById(Integer id) throws Exception;

    public List<Room> findByName(String name) throws Exception;

    public List<Room> nameList() throws Exception;
}
