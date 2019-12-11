package com.ccxg.controller;

import com.ccxg.entity.*;
import com.ccxg.service.*;
import com.ccxg.util.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class TbScoreController {

    @Resource
    private TbScoreService tbScoreService;

    @Resource
    private TbStudentService tbStudentService;

    @Resource
    private TbCourseService tbCourseService;

    @Resource
    private TbMajorService tbMajorService;

    @RequestMapping("/getAll")
    public Response<Object> getAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<TbScore> tbScores = tbScoreService.getAll();
        if (tbScores != null && tbScores.size() != 0) {
            PageInfo<TbScore> pageInfo = new PageInfo<>(tbScores);
            return new Response<>("0", "success", pageInfo);
        }
        return new Response<>("1", "failed", "未找到成绩");
    }

    @RequestMapping("/getByStudent")
    public Response<Object> getByStudent(TbScore tbScore) {

        List<TbScore> tbScores = tbScoreService.getByStudent(tbScore);
        if (tbScores != null && tbScores.size() != 0) {
            return new Response<>("0", "success", tbScores);
        }
        return new Response<>("1", "failed", "未找到成绩");
    }

    @RequestMapping("/getByMajor")
    public Response<Object> getByDepartment(@RequestParam("id") String id) {

        TbScore tbScore = new TbScore();
        TbStudent tbStudent = new TbStudent();
        List<TbScore> tbScores = new ArrayList<>();
//        TbMajor tbMajor = tbMajorService.selectById(id);
//        String majorId = tbMajor.getMajorId();
        tbStudent.setMajorId(id);
        List<TbStudent> tbStudents = tbStudentService.search(tbStudent);
        for (TbStudent tbStudent1 : tbStudents) {
            String studentId = tbStudent1.getStudentId();
            tbScore.setStudentId(studentId);
            List<TbScore> tbScores1 = tbScoreService.getByStudent(tbScore);
            tbScores.addAll(tbScores1);
        }
        if (tbScores.size() != 0) {
            return new Response<>("0", "success", tbScores);
        }
        return new Response<>("1", "failed", "未找到成绩");
    }

    @RequestMapping("/addScore")
    public Response<Object> addScore(TbScore tbScore) {

        Integer integer = tbScoreService.addScore(tbScore);
        if (integer == 1) {
            return new Response<>("0", "success", "插入成功");
        }
        return new Response<>("1", "failed", "插入失败");
    }

    @RequestMapping("/updateScore")
    public Response<Object> updateScore(TbScore tbScore) {

        Integer integer = tbScoreService.updateScore(tbScore);
        if (integer == 1) {
            return new Response<>("0", "success", "更新成功");
        }
        return new Response<>("1", "failed", "更新失败");
    }

    @RequestMapping("/deleteScore")
    public Response<Object> deleteScore(TbScore tbScore) {

        Integer integer = tbScoreService.deleteScore(tbScore);
        if (integer == 1) {
            return new Response<>("0", "success", "删除成功");
        }
        return new Response<>("1", "failed", "删除失败");
    }

    @RequestMapping("/getInfo")
    public Response<Object> getInfo(@RequestParam("studentId") String studentId) {

        List<TbStudent> tbStudents = tbStudentService.selectByPrimaryKey(studentId);
        if (tbStudents != null && tbStudents.size() != 0) {
            TbStudent tbStudent = tbStudents.get(0);
            TbCourse tbCourse = new TbCourse();
            tbCourse.setMajorId(tbStudent.getMajorId());
            tbCourse.setGrade(tbStudent.getGrade());
            List<String> maps = tbCourseService.selectByCourse(tbCourse);
            if (maps != null && maps.size() != 0) {
                Map<String, Object> res = new HashMap<>();
                res.put("studentId", studentId);
                res.put("studentName", tbStudent.getStudentName());
                res.put("courseNames", maps);
                return new Response<>("0", "success", res);
            }
        }
        return new Response<>("1", "failed", "学号不存在");
    }

}
