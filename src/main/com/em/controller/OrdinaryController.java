package main.com.em.controller;

import main.com.em.domain.*;
import main.com.em.service.ReservationService;
import main.com.em.service.RoomService;
import main.com.em.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Admiral on 2018/1/20.
 */
@Controller
@RequestMapping("/ordinary")
public class OrdinaryController {

    @Resource(name = "roomServiceImpl")
    private RoomService roomService;

    @Resource(name = "reservationServiceImpl")
    private ReservationService reservationService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<会议室信息管理>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    // 会议室信息显示
    @RequestMapping("/showRoom")
    public String showRoom(Model model, Integer page) throws Exception {

        List<Room> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(roomService.roomCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = roomService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = roomService.findByPaging(page);
        }

        model.addAttribute("roomList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "/ordinary/showRoom";
    }

    //搜索会议室
    @RequestMapping(value = "/queryRoom", method = {RequestMethod.POST})
    private String queryRoom(String findByName, Model model) throws Exception {

        List<Room> list = roomService.findByName(findByName);

        model.addAttribute("roomList", list);
        return "/ordinary/showRoom";
    }

    //查询接下来的15天内所有已被预约的会议室记录
    @RequestMapping("/showRecord")
    public String findAllReservation(Model model, Integer page) throws Exception {
        List<ReservationVo> list = null;

        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(reservationService.reserveCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = reservationService.findAllByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = reservationService.findAllByPaging(page);
        }

        model.addAttribute("recordList", list);
        model.addAttribute("pagingVo", pagingVO);

        return "/ordinary/showRecord";
    }

    //搜索借用人
    @RequestMapping(value = "/queryByUser", method = {RequestMethod.POST})
    private String queryUser(String findByName, Model model) throws Exception {

        List<ReservationVo> list = reservationService.queryByUser(findByName);

        model.addAttribute("recordList", list);

        return "/ordinary/showRecord";
    }

    //预约会议室页面跳转
    @RequestMapping(value = "/reserveRoom", method = RequestMethod.GET)
    public String reserveRoomUI(Model model) throws Exception {
        //从数据库查询出所有会议室信息回显到页面
        List<Room> list = roomService.nameList();
        model.addAttribute("nameList", list);

        return "/ordinary/reserveRoom";
    }

    //预约会议室功能实现
    @RequestMapping(value = "/reserveRoom", method = RequestMethod.POST)
    public String reserveRoom(ReservationCustom reservationCustom) throws Exception {

        reservationService.addReservation(reservationCustom);

        return "redirect:/ordinary/showRecord";
    }

    //取消预约申请页面跳转
    @RequestMapping(value = "/cancelApplication",method = RequestMethod.GET)
    public String cancelApplicationUI(String user,Model model) throws Exception{
        List<ReservationCustom> list=reservationService.findByUser(user);
        model.addAttribute("reserveList",list);

        return "/ordinary/cancelApplication";
    }

    //取消预约申请业务实现
    @RequestMapping("/cancelApply")
    public String cancelApplication(Integer id) throws Exception{
        reservationService.cancelApplication(id);

        return "redirect:/ordinary/showRecord";
    }

}
