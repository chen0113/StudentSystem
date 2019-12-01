package com.ccxg.controller;

import com.ccxg.entity.TbMajor;
import com.ccxg.service.TbMajorService;
import com.ccxg.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/major/management")
public class TbMajorController {
    @Resource
    private TbMajorService tbMajorService;

    @GetMapping("list")
    public Response list(String departmentId) {
        List<TbMajor> list = tbMajorService.findByDepartmentId(departmentId);
        return new Response<>("0", "success", list);
    }

    @PostMapping("add")
    public Response add(@RequestBody TbMajor major) {
        if (major.getDepartmentId() == null) {
            return new Response<>("1", "failed", "学院号不能为空");
        }
        if (major.getMajorId() == null) {
            return new Response<>("1", "failed", "专业号不能为空");
        }
        if (major.getMajorName() == null) {
            return new Response<>("1", "failed", "专业名不能为空");
        }
        int res = tbMajorService.insert(major);
        if (res == 1) {
            return new Response<>("0", "success", "添加专业成功");
        }
        return new Response<>("1", "success", "添加专业失败");
    }

    @PostMapping("delete")
    public Response delete(@RequestParam String id) {
        if (id == null) {
            return new Response<>("1", "failed", "ID参数错误");
        }
        int res = tbMajorService.deleteById(id);
        if (res == 1) {
            return new Response<>("0", "success", "删除专业成功");
        }
        return new Response<>("1", "success", "删除专业失败");
    }
}
