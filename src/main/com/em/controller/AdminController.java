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
import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

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

        return "/admin/showRoom";
    }

    //搜索会议室
    @RequestMapping(value = "/queryRoom", method = {RequestMethod.POST})
    private String queryRoom(String findByName, Model model) throws Exception {

        List<Room> list = roomService.findByName(findByName);

        model.addAttribute("roomList", list);
        return "/admin/showRoom";
    }

    //添加会议室页面跳转
    @RequestMapping(value = "/addRoom", method = {RequestMethod.GET})
    public String addRoom(Model model) throws Exception {

        return "/admin/addRoom";
    }

    //添加会议室业务实现
    @RequestMapping(value = "/addRoom", method = {RequestMethod.POST})
    public String addRoom(Room room, Model model) throws Exception {

        roomService.add(room);

        return "redirect:/admin/showRoom";
    }

    // 修改会议室信息页面显示
    @RequestMapping(value = "/editRoom", method = {RequestMethod.GET})
    public String editRoomUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showRoom";
        }
        Room room = roomService.findById(id);
        model.addAttribute("roomList", room);

        return "/admin/editRoom";
    }

    // 修改会议室信息页面处理
    @RequestMapping(value = "/editRoom", method = {RequestMethod.POST})
    public String editRoom(Room room) throws Exception {
        roomService.updateById(room);

        //重定向
        return "redirect:/admin/showRoom";
    }

    // 删除会议室信息
    @RequestMapping("/removeRoom")
    public String removeRoom(Integer id) throws Exception {
        if (id == null) {
            //加入没有带教师id就进来的话就返回教师显示页面
            return "/admin/showRoom";
        }
        roomService.removeById(id);

        return "redirect:/admin/showRoom";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<会议室预约管理>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //查询所有待审核预约记录
    @RequestMapping("/showReservation")
    public String findAllReservation(Model model,Integer page) throws Exception {
        List<ReservationVo> list = null;

        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(reservationService.reservationCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = reservationService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = reservationService.findByPaging(page);
        }

        model.addAttribute("reservationList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "/admin/showReservation";
    }

    //搜索借用人
    @RequestMapping(value = "queryUser", method = {RequestMethod.POST})
    private String queryUser(String findByName, Model model) throws Exception {

        List<Reservation> list = reservationService.findByName(findByName);

        model.addAttribute("reservationList", list);
        return "/admin/showReservation";
    }

    //同意会议室申请
    @RequestMapping("/reviewReservation")
    public String reviewReservation(Integer id) throws Exception{
        reservationService.reviewReservation(id);
        return "redirect:/admin/showReservation";
    }

    //查询所有审核通过预约记录
    @RequestMapping("/showRecord")
    public String findRecord(Model model,Integer page) throws Exception{
        List<ReservationVo> list = null;

        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(reservationService.reservationPassCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = reservationService.findRecord(1);
        } else {
            pagingVO.setToPageNo(page);
            list = reservationService.findRecord(page);
        }

        model.addAttribute("recordList", list);
        model.addAttribute("pagingVo", pagingVO);

        return "/admin/showRecord";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户信息管理>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //添加新用户
    @RequestMapping(value = "/userRegister", method = {RequestMethod.GET})
    public String userRegister(Model model) throws Exception {
        return "/admin/userRegister";
    }

    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public String userRegister(User user) throws Exception{
        userService.addNewUser(user);
        return "redirect:/admin/userRegister";
    }
}
