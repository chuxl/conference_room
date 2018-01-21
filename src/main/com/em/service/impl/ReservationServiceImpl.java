package main.com.em.service.impl;

import main.com.em.dao.ReservationMapper;
import main.com.em.domain.PagingVO;
import main.com.em.domain.Reservation;
import main.com.em.domain.ReservationCustom;
import main.com.em.domain.ReservationVo;
import main.com.em.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public Integer reservationCount() {
        return reservationMapper.reservationCount();
    }

    @Override
    public List<ReservationVo> findByPaging(Integer toPageNo) {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public List<Reservation> findByName(String name) {
        return reservationMapper.findByName(name);
    }

    @Override
    public Integer reservationPassCount() {
        return reservationMapper.reservationPassCount();
    }

    @Override
    public List<ReservationVo> findRecord(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findRecord(pagingVO);
        return list;
    }

    @Override
    public void reviewReservation(Integer id) throws Exception {
        reservationMapper.reviewReservation(id);
    }

    @Override
    public Integer reserveCount() throws Exception {
        return reservationMapper.reserveCount();
    }

    @Override
    public List<ReservationVo> findAllByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<ReservationVo> list = reservationMapper.findAllByPaging(pagingVO);
        return list;
    }

    @Override
    public void addReservation(ReservationCustom reservationCustom) throws Exception {
        reservationMapper.addReservation(reservationCustom);
    }

    @Override
    public List<ReservationVo> queryByUser(String name) throws Exception {
        return reservationMapper.queryByUser(name);
    }

    @Override
    public List<ReservationCustom> findByUser(String name) throws Exception {
        return reservationMapper.findByUser(name);
    }

    @Override
    public void cancelApplication(Integer id) throws Exception {
        reservationMapper.cancelApplication(id);
    }
}
