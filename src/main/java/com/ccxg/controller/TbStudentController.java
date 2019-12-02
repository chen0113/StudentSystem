package com.ccxg.controller;

import com.ccxg.entity.TbStudent;
import com.ccxg.service.TbStudentService;
import com.ccxg.util.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 谢陈
 */
@RestController


@RequestMapping("/student/management")
public class TbStudentController {
    @Resource
    private TbStudentService tbStudentService;

    @GetMapping("list")
    public Response list() {
        PageInfo<TbStudent> pageInfo = tbStudentService.findByMap();
        return new Response<>("0", "success", pageInfo);
    }

    @PostMapping("add")
    public Response add(@RequestBody TbStudent student) {
        if (student.getStudentName() == null) {
            return new Response<>("1", "failed", "学生姓名不能为空");
        }
        if (student.getDepartmentName() == null) {
            return new Response<>("1", "failed", "学生所属学院不能为空");
        }
        if (student.getMajorName() == null) {
            return new Response<>("1", "failed", "学生所属专业不能为空");
        }
        int res = tbStudentService.insert(student);
        if (res == 1) {
            return new Response<>("0", "success", "添加学生成功");
        }
        return new Response<>("1", "success", "添加学生失败");

    }

    @PostMapping("update")
    public Response update(@RequestBody TbStudent student) {
        if (student.getStudentName() == null) {
            return new Response<>("1", "failed", "学生姓名不能为空");
        }
        if (student.getDepartmentName() == null) {
            return new Response<>("1", "failed", "学生所属学院不能为空");
        }
        if (student.getMajorName() == null) {
            return new Response<>("1", "failed", "学生所属专业不能为空");
        }
        int res = tbStudentService.update(student);
        if (res == 1) {
            return new Response<>("0", "success", "更新学生信息成功");
        }
        return new Response<>("1", "success", "更新学生信息失败");
    }

    @PostMapping("delete")
    public Response delete(@RequestParam String id) {
        if (id == null) {
            return new Response<>("1", "failed", "ID参数错误");
        }
        int res = tbStudentService.deleteById(id);
        if (res == 1) {
            return new Response<>("0", "success", "删除学生成功");
        }
        return new Response<>("1", "success", "删除学生失败");
    }

    @PostMapping("detail")
    public Response detail(@RequestParam String id){
        if (id == null) {
            return new Response<>("1", "failed", "ID参数错误");
        }
        List<TbStudent> list = tbStudentService.selectByPrimaryKey(id);
        return new Response<>("0", "success", list);
    }

    @PostMapping("search")
    public Response search(@RequestBody TbStudent student){
        List<TbStudent> list = tbStudentService.search(student);
        return new Response<>("0", "success", list);
    }

}
