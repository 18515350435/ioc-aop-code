package com.peihan.spring.bean;

import java.lang.annotation.*;

/**
 * @author:peihan.Z
 * @date:2019/7/6 23:23
 * @description:
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoWired {
}
