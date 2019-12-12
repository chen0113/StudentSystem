package com.ccxg.controller;

import com.ccxg.entity.TbDepartment;
import com.ccxg.service.TbDepartmentService;
import com.ccxg.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 谢陈
 */
@CrossOrigin
@RestController
@RequestMapping("/department/management")
public class TbDepartmentController {
    @Resource
    private TbDepartmentService tbDepartmentService;

    @GetMapping("list")
    public Response list() {
        List<TbDepartment> list = tbDepartmentService.findByMap();
        return new Response<>("0", "success", list);
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
        return new Response<>("0", "success", list);
    }
}
