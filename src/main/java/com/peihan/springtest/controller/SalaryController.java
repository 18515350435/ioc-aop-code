package com.peihan.springtest.controller;

import com.peihan.spring.bean.AutoWired;
import com.peihan.spring.web.mvc.Controller;
import com.peihan.spring.web.mvc.RequestMapping;
import com.peihan.spring.web.mvc.RequestParam;
import com.peihan.springtest.service.serviceImpl.SalaryService;

/**
 * @author:peihan.Z
 * @date:2019/7/6 16:48
 * @description:
 */
@Controller
public class SalaryController {
    @AutoWired
    private SalaryService salaryService;

    @RequestMapping("/getSalary")
    public Integer getSalary(@RequestParam("name") String name, @RequestParam("experience") String experience) {
        if (experience == null || experience.isEmpty()) {
            return 0;
        }
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}
