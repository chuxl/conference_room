package main.com.em.service;

import main.com.em.domain.PagingVO;
import main.com.em.domain.Reservation;
import main.com.em.domain.ReservationCustom;
import main.com.em.domain.ReservationVo;

import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface ReservationService {
    /**
     * 查询15天内待审核的预约总数
     * @return
     */
    public Integer reservationCount() throws Exception;

    /**
     * 查询15天内的所有待审核预约记录
     * @return
     */
    public List<ReservationVo> findByPaging(Integer toPageNo) throws Exception;

    /**
     * 根据借用人查询其所有预约记录
     * @param name
     * @return
     */
    public List<Reservation> findByName(String name);

    /**
     * 查询15天内的审核通过的预约总数
     * @return
     */
    public Integer reservationPassCount();

    /**
     * 查询15天内的所有审核通过预约记录
     * @param toPageNo
     * @return
     * @throws Exception
     */
    public List<ReservationVo> findRecord(Integer toPageNo) throws Exception;

    /**
     * 审核预约会议室
     * @param id
     * @throws Exception
     */
    public void reviewReservation(Integer id) throws Exception;

    /**
     * 查询15天内所有预约记录
     * @return
     */
    public Integer reserveCount() throws Exception;

    /**
     * 查询当前日期起,15天内的所有已被预约的会议室记录
     * @return
     */
    public List<ReservationVo> findAllByPaging(Integer toPageNo) throws Exception;

    /**
     * 添加会议室预约
     * @param reservationCustom
     */
    public void addReservation(ReservationCustom reservationCustom) throws Exception;

    /**
     * 根据借用人查询所有会议室预约信息
     * @param name
     * @return
     * @throws Exception
     */
    public List<ReservationVo> queryByUser(String name) throws Exception;

    /**
     * 查询指定借用人预约会议室信息
     * @param name
     * @return
     * @throws Exception
     */
    public List<ReservationCustom> findByUser(String name) throws Exception;

    /**
     * 根据id取消会议室申请
     * @param id
     * @throws Exception
     */
    public void cancelApplication(Integer id) throws Exception;
}
