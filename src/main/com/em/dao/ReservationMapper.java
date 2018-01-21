package main.com.em.dao;

import main.com.em.domain.PagingVO;
import main.com.em.domain.Reservation;
import main.com.em.domain.ReservationCustom;
import main.com.em.domain.ReservationVo;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface ReservationMapper {
    public Integer reservationCount();

    public List<ReservationVo> findByPaging(PagingVO pagingVO);

    public List<Reservation> findByName(String name);

    public Integer reservationPassCount();

    public List<ReservationVo> findRecord(PagingVO pagingVO);

    public void reviewReservation(Integer id);

    public Integer reserveCount();

    public List<ReservationVo> findAllByPaging(PagingVO pagingVO);

    public void addReservation(ReservationCustom reservationCustom);

    public List<ReservationVo> queryByUser(String name);

    public List<ReservationCustom> findByUser(String name);

    public void cancelApplication(Integer id);
}
