package com.ccxg.controller;

import com.ccxg.entity.TbDepartment;
import com.ccxg.entity.TbMajor;
import com.ccxg.service.TbDepartmentService;
import com.ccxg.service.TbMajorService;
import com.ccxg.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 谢陈
 */
@CrossOrigin
@RestController
@RequestMapping("/department/management")
public class TbDepartmentController {
    @Resource
    private TbDepartmentService tbDepartmentService;

    @Resource
    private TbMajorService tbMajorService;

    @GetMapping("list")
    public Response list() {

        List<TbDepartment> list = tbDepartmentService.findByMap();
        List<Map<String, Object>> majorDepartment = new ArrayList<>();
        for (TbDepartment tbDepartment : list) {
            List<TbMajor> list1 = tbMajorService.findByDepartmentId(tbDepartment.getDepartmentId());
            List<Map<String, Object>> tbMajors = new ArrayList<>();
            for (TbMajor tbMajor : list1) {
                Map<String, Object> map = new HashMap<>();
                map.put("majorId", tbMajor.getMajorId());
                map.put("majorName", tbMajor.getMajorName());
                tbMajors.add(map);
            }
            Map<String, Object> major = new HashMap<>();
            major.put("children", tbMajors);
            major.put("departmentName", tbDepartment.getDepartmentName());
            major.put("departmentId", tbDepartment.getDepartmentId());
            majorDepartment.add(major);
        }
        return new Response<>("0", "success", majorDepartment);
    }

    @PostMapping("add")
    public Response add(@RequestBody TbDepartment department) {
        if (department.getDepartmentId() == null) {
            return new Response<>("1", "failed", "学院号不能为空");
        }
        if (department.getDepartmentName() == null) {
            return new Response<>("1", "failed", "学院名不能为空");
        }
        int res = tbDepartmentService.insert(department);
        if (res == 1) {
            return new Response<>("0", "success", "添加学院成功");
        }
        return new Response<>("1", "success", "添加学院失败");
    }

    @PostMapping("update")
    public Response update(@RequestBody TbDepartment department) {
        if (department.getDepartmentId() == null) {
            return new Response<>("1", "failed", "学院号不能为空");
        }
        if (department.getDepartmentName() == null) {
            return new Response<>("1", "failed", "学院名不能为空");
        }
        int res = tbDepartmentService.update(department);
        if (res == 1) {
            return new Response<>("0", "success", "更新学院信息成功");
        }
        return new Response<>("1", "success", "更新学院信息失败");
    }

    @PostMapping("delete")
    public Response delete(@RequestParam String id) {
        if (id == null) {
            return new Response<>("1", "failed", "ID参数错误");
        }
        int res = tbDepartmentService.deleteById(id);
        if (res == 1) {
            return new Response<>("0", "success", "删除学院成功");
        }
        return new Response<>("1", "success", "删除学院失败");
    }

    @PostMapping("detail")
    public Response detail(@RequestParam String id){
        if (id == null) {
            return new Response<>("1", "failed", "ID参数错误");
        }
        List<TbDepartment> list = tbDepartmentService.selectById(id);
        return new Response<>("0", "success", list);
    }

    @PostMapping("search")
    public Response search(@RequestBody TbDepartment department){
        List<TbDepartment> list = tbDepartmentService.search(department);
        List<Map<String, Object>> majorDepartment = new ArrayList<>();
        for (TbDepartment tbDepartment : list) {
            List<TbMajor> list1 = tbMajorService.findByDepartmentId(tbDepartment.getDepartmentId());
            List<Map<String, Object>> tbMajors = new ArrayList<>();
            for (TbMajor tbMajor : list1) {
                Map<String, Object> map = new HashMap<>();
                map.put("majorId", tbMajor.getMajorId());
                map.put("majorName", tbMajor.getMajorName());
                tbMajors.add(map);
            }
            Map<String, Object> major = new HashMap<>();
            major.put("children", tbMajors);
            major.put("departmentName", tbDepartment.getDepartmentName());
            major.put("departmentId", tbDepartment.getDepartmentId());
            majorDepartment.add(major);
        }
        return new Response<>("0", "success", majorDepartment);
    }
}
