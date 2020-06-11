package com.peihan.springtest.controller;

import com.peihan.spring.bean.AutoWired;
import com.peihan.spring.web.mvc.Controller;
import com.peihan.spring.web.mvc.RequestMapping;
import com.peihan.springtest.service.Rap;

@Controller
public class RapController {
    @AutoWired
    private Rap rapper;

    @RequestMapping("/rap")
    public String rap() {
        rapper.rap();
        return "CXK";
    }
}