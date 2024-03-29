package com.ccxg.controller;

import com.ccxg.entity.TbCourse;
import com.ccxg.entity.TbScore;
import com.ccxg.entity.TbStudent;
import com.ccxg.service.TbCourseService;
import com.ccxg.util.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 谢陈
 */
@CrossOrigin
@RestController
@RequestMapping("/course/management")
public class TbCourseController {
    @Resource
    private TbCourseService tbCourseService;

    @GetMapping("list")
    public Response list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbCourse> tbCourses = tbCourseService.findByMap();
        if (tbCourses != null && tbCourses.size() != 0) {
            PageInfo<TbCourse> pageInfo = new PageInfo<>(tbCourses);
            return new Response<>("0", "success", pageInfo);
        }
        return new Response<>("1", "failed", "未找到成绩");
    }

    @PostMapping("add")
    public Response add(@RequestBody TbCourse course) {
        if (course.getCourseName() == null) {
            return new Response<>("1", "failed", "课程名不能为空");
        }
        if (course.getGrade() == null) {
            return new Response<>("1", "failed", "开课年级不能为空");
        }
        if (course.getMajorId() == null) {
            return new Response<>("1", "failed", "开课专业不能为空");
        }
        int res = tbCourseService.insert(course);
        if (res == 1) {
            return new Response<>("0", "success", "添加课程成功");
        }
        return new Response<>("1", "success", "添加课程失败");

    }

    @PostMapping("delete")
    public Response delete(@RequestBody TbCourse course) {
        int res = tbCourseService.deleteByCourse(course);
        if (res == 1) {
            return new Response<>("0", "success", "删除课程成功");
        }
        return new Response<>("1", "success", "删除课程失败");
    }

//    @PostMapping("detail")
//    public Response detail(@RequestBody TbCourse course){
//        List<TbCourse> list = tbCourseService.selectByCourse(course);
//        return new Response<>("0", "success", list);
//    }

    @PostMapping("search")
    public Response search(@RequestBody TbCourse course){
        List<TbCourse> list = tbCourseService.search(course);
        return new Response<>("0", "success", list);
    }

}
