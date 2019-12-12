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

@CrossOrigin
@RestController
@RequestMapping("/major/management")
public class TbMajorController {
    @Resource
    private TbMajorService tbMajorService;

    @Resource
    private TbDepartmentService tbDepartmentService;

    @GetMapping("list")
    public Response list() {
        List<TbDepartment> tbDepartments = tbDepartmentService.findByMap();
        List<Map<String, Object>> majorDepartment = new ArrayList<>();
        for (TbDepartment tbDepartment : tbDepartments) {
            List<TbMajor> list = tbMajorService.findByDepartmentId(tbDepartment.getDepartmentId());
            List<Map<String, Object>> tbMajors = new ArrayList<>();
            for (TbMajor tbMajor : list) {
                Map<String, Object> map = new HashMap<>();
                String majorId = tbMajor.getMajorId();
                if (majorId != null && majorId.startsWith("0")) {
                    majorId = majorId.split("0")[1];
                    tbMajor.setMajorId(majorId);
                }
                map.put("id", tbMajor.getMajorId());
                map.put("text", tbMajor.getMajorName());
                tbMajors.add(map);
            }
            Map<String, Object> major = new HashMap<>();
            major.put("children", tbMajors);
            major.put("text", tbDepartment.getDepartmentName());
            major.put("id", tbDepartment.getDepartmentId());
            majorDepartment.add(major);
        }
        return new Response<>("0", "success", majorDepartment);
    }

    @GetMapping("webList")
    public Response webList() {
        List<TbDepartment> tbDepartments = tbDepartmentService.findByMap();
        List<Map<String, Object>> majorDepartment = new ArrayList<>();
        for (TbDepartment tbDepartment : tbDepartments) {
            List<TbMajor> list = tbMajorService.findByDepartmentId(tbDepartment.getDepartmentId());
            List<Map<String, Object>> tbMajors = new ArrayList<>();
            for (TbMajor tbMajor : list) {
                Map<String, Object> map = new HashMap<>();
                String majorId = tbMajor.getMajorId();
//                if (majorId != null && majorId.startsWith("0")) {
//                    majorId = majorId.split("0")[1];
//                    tbMajor.setMajorId(majorId);
//                }
                map.put("id", tbMajor.getMajorId());
                map.put("value", tbMajor.getMajorName());
                map.put("label", tbMajor.getMajorName());
                tbMajors.add(map);
            }
            Map<String, Object> major = new HashMap<>();
            major.put("children", tbMajors);
            major.put("value", tbDepartment.getDepartmentName());
            major.put("label", tbDepartment.getDepartmentName());
            major.put("id", tbDepartment.getDepartmentId());
            majorDepartment.add(major);
        }
        return new Response<>("0", "success", majorDepartment);
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
