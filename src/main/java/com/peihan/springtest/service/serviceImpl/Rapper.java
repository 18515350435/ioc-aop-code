package com.peihan.springtest.service.serviceImpl;


import com.peihan.spring.bean.Component;
import com.peihan.springtest.service.Rap;

@Component
public class Rapper implements Rap {
    @Override
    public void rap() {
        System.out.println("CXK rapping...");
    }
}
