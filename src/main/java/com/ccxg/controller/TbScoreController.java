package com.ccxg.controller;

import com.ccxg.entity.TbCourse;
import com.ccxg.entity.TbScore;
import com.ccxg.entity.TbStudent;
import com.ccxg.service.TbCourseService;
import com.ccxg.service.TbScoreService;
import com.ccxg.service.TbStudentService;
import com.ccxg.util.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.annotation.Repeatable;
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

    @RequestMapping("/getAll")
    public Response<Object> getAll() {

        List<TbScore> tbScores = tbScoreService.getAll();
        if (tbScores != null && tbScores.size() != 0) {
            return new Response<>("0", "success", tbScores);
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
        if (tbStudents != null && tbStudents.size() != 0){
            TbStudent tbStudent = tbStudents.get(0);
            TbCourse tbCourse = new TbCourse();
            tbCourse.setMajorId(tbStudent.getMajorId());
            tbCourse.setGrade(tbStudent.getGrade());
            List<String> maps = tbCourseService.selectByCourse(tbCourse);
            if (maps != null && maps.size() != 0){
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
