package com.sxdxswxy.drugsys.common.log;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TopLog {

    /**
     * 操作描述
     **/
    String description() default "";

    /**
     * 功能模块名称
     */
    String module() default "";

    /**
     * 方法名称
     */
    String methods() default "";

    /**
     * 日志级别
     * 0 不记录
     * 1~3 不重要
     * 4~6 一般
     * 7~9 重要
     * 10 非常重要
     */
    int level() default 0;

}
