package com.peihan.springtest.service.serviceImpl;

import com.peihan.spring.bean.Component;

/**
 * @author:peihan.Z
 * @date:2019/7/6 23:59
 * @description:
 */

@Component
public class SalaryService {
    public Integer calSalary(Integer experience) {
        return experience * 3000;
    }
}
